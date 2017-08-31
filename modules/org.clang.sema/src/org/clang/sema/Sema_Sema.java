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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.impl.*;
import org.clank.java.stdimpl.aliases.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaRTTI.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.sema.AnalysisBasedWarnings.Policy;
import static org.clang.sema.impl.SemaStatics.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_Sema">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_JumpDiagnostics ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema10InitializeEv;_ZN5clang4Sema11getCurBlockEv;_ZN5clang4Sema12ActOnCommentENS_11SourceRangeE;_ZN5clang4Sema12getCurLambdaEv;_ZN5clang4Sema13tryExprAsCallERNS_4ExprERNS_8QualTypeERNS_17UnresolvedSetImplE;_ZN5clang4Sema14PushBlockScopeEPNS_5ScopeEPNS_9BlockDeclE;_ZN5clang4Sema15PushLambdaScopeEv;_ZN5clang4Sema16PopCompoundScopeEv;_ZN5clang4Sema16getCurMethodDeclEv;_ZN5clang4Sema17ImpCastExprToTypeEPNS_4ExprENS_8QualTypeENS_8CastKindENS_13ExprValueKindEPKN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEENS0_21CheckedConversionKindE;_ZN5clang4Sema17PushCompoundScopeEv;_ZN5clang4Sema17PushFunctionScopeEv;_ZN5clang4Sema17addExternalSourceEPNS_18ExternalSemaSourceE;_ZN5clang4Sema17findMacroSpellingERNS_14SourceLocationEN4llvm9StringRefE;_ZN5clang4Sema17getPrintingPolicyERKNS_10ASTContextERKNS_12PreprocessorE;_ZN5clang4Sema18addImplicitTypedefEN4llvm9StringRefENS_8QualTypeE;_ZN5clang4Sema18getCurFunctionDeclEv;_ZN5clang4Sema18getScopeForContextEPNS_11DeclContextE;_ZN5clang4Sema19getCurGenericLambdaEv;_ZN5clang4Sema19getLocForEndOfTokenENS_14SourceLocationEj;_ZN5clang4Sema19getUndefinedButUsedERN4llvm15SmallVectorImplISt4pairIPNS_9NamedDeclENS_14SourceLocationEEEE;_ZN5clang4Sema20PopFunctionScopeInfoEPKNS_4sema21AnalysisBasedWarnings6PolicyEPKNS_4DeclEPKNS_9BlockExprE;_ZN5clang4Sema20getCurCapturedRegionEv;_ZN5clang4Sema20tryToRecoverWithCallERNS_12ActionResultIPNS_4ExprELb1EEERKNS_17PartialDiagnosticEbPFbNS_8QualTypeEE;_ZN5clang4Sema21EmitCurrentDiagnosticEj;_ZN5clang4Sema23PushCapturedRegionScopeEPNS_5ScopeEPNS_12CapturedDeclEPNS_10RecordDeclENS_18CapturedRegionKindE;_ZN5clang4Sema25ActOnEndOfTranslationUnitEv;_ZN5clang4Sema25ActOnTranslationUnitScopeEPNS_5ScopeE;_ZN5clang4Sema26getCurFunctionOrMethodDeclEv;_ZN5clang4Sema27ScalarTypeToBooleanCastKindENS_8QualTypeE;_ZN5clang4Sema27getFunctionLevelDeclContextEv;_ZN5clang4Sema29makeUnavailableInSystemHeaderENS_14SourceLocationENS_15UnavailableAttr14ImplicitReasonE;_ZN5clang4Sema35RecordParsingTemplateParameterDepthEj;_ZN5clang4Sema35diagnoseNullableToNonnullConversionENS_8QualTypeES1_NS_14SourceLocationE;_ZN5clang4Sema37LoadExternalWeakUndeclaredIdentifiersEv;_ZN5clang4Sema38emitAndClearUnusedLocalTypedefWarningsEv;_ZN5clang4Sema4DiagENS_14SourceLocationERKNS_17PartialDiagnosticE;_ZNK5clang4Sema10PrintStatsEv;_ZNK5clang4Sema15getModuleLoaderEv;_ZNK5clang4Sema18getSuperIdentifierEv;_ZNK5clang4Sema21getFloat128IdentifierEv;_ZNK5clang4Sema22getASTMutationListenerEv;_ZNK5clang4Sema31getMismatchingDeleteExpressionsEv;_ZNK5clang4Sema39hasAnyUnrecoverableErrorsInThisFunctionEv; -static-type=Sema_Sema -package=org.clang.sema")
//</editor-fold>
public class Sema_Sema extends Sema_JumpDiagnostics {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// \brief Load weak undeclared identifiers from the external source.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::LoadExternalWeakUndeclaredIdentifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 545,
 FQN="clang::Sema::LoadExternalWeakUndeclaredIdentifiers", NM="_ZN5clang4Sema37LoadExternalWeakUndeclaredIdentifiersEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema37LoadExternalWeakUndeclaredIdentifiersEv")
//</editor-fold>
public final void LoadExternalWeakUndeclaredIdentifiers() {
  if (!($this().ExternalSource != null)) {
    return;
  }
  
  SmallVector<std.pairPtrType<IdentifierInfo /*P*/ , WeakInfo>> WeakIDs/*J*/= new SmallVector<std.pairPtrType<IdentifierInfo /*P*/ , WeakInfo>>(4, new std.pairPtrType<IdentifierInfo /*P*/ , WeakInfo>(null, new WeakInfo()));
  $this().ExternalSource.ReadWeakUndeclaredIdentifiers(WeakIDs);
  for (final pairPtrType<IdentifierInfo /*P*/ , WeakInfo> /*&*/ WeakID : WeakIDs)  {
    $this().WeakUndeclaredIdentifiers.insert(WeakID);
  }
}


/// Obtain a sorted list of functions that are undefined but ODR-used.

/// Obtains a sorted list of functions and variables that are undefined but
/// ODR-used.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getUndefinedButUsed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 474,
 FQN="clang::Sema::getUndefinedButUsed", NM="_ZN5clang4Sema19getUndefinedButUsedERN4llvm15SmallVectorImplISt4pairIPNS_9NamedDeclENS_14SourceLocationEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema19getUndefinedButUsedERN4llvm15SmallVectorImplISt4pairIPNS_9NamedDeclENS_14SourceLocationEEEE")
//</editor-fold>
public final void getUndefinedButUsed(final SmallVectorImpl<std.pair<NamedDecl /*P*/ , SourceLocation> > /*&*/ Undefined) {
  for (final /*const*/ pair<NamedDecl /*P*/ , SourceLocation> /*&*/ UndefinedUse : $this().UndefinedButUsed) {
    NamedDecl /*P*/ ND = UndefinedUse.first;
    
    // Ignore attributes that have become invalid.
    if (ND.isInvalidDecl()) {
      continue;
    }
    
    // __attribute__((weakref)) is basically a definition.
    if (ND.hasAttr(WeakRefAttr.class)) {
      continue;
    }
    {
      
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
      if ((FD != null)) {
        if (FD.isDefined()) {
          continue;
        }
        if (FD.isExternallyVisible()
           && !FD.getMostRecentDecl().isInlined()) {
          continue;
        }
      } else {
        VarDecl /*P*/ VD = cast_VarDecl(ND);
        if (VD.hasDefinition() != VarDecl.DefinitionKind.DeclarationOnly) {
          continue;
        }
        if (VD.isExternallyVisible() && !VD.getMostRecentDecl().isInline()) {
          continue;
        }
      }
    }
    
    Undefined.push_back(std.make_pair_Ptr_T(ND, UndefinedUse.second));
  }
}


/// Retrieves list of suspicious delete-expressions that will be checked at
/// the end of translation unit.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getMismatchingDeleteExpressions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1518,
 FQN="clang::Sema::getMismatchingDeleteExpressions", NM="_ZNK5clang4Sema31getMismatchingDeleteExpressionsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema31getMismatchingDeleteExpressionsEv")
//</editor-fold>
public final /*const*/ MapVectorPtrType<FieldDecl /*P*/ , SmallVector<std.pairTypeBool<SourceLocation>> > /*&*/ getMismatchingDeleteExpressions() /*const*/ {
  return $this().DeleteExprs;
}


/// \brief Cause the active diagnostic on the DiagosticsEngine to be
/// emitted. This is closely coupled to the SemaDiagnosticBuilder class and
/// should not be used elsewhere.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::EmitCurrentDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 959,
 FQN="clang::Sema::EmitCurrentDiagnostic", NM="_ZN5clang4Sema21EmitCurrentDiagnosticEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema21EmitCurrentDiagnosticEj")
//</editor-fold>
public final void EmitCurrentDiagnostic(/*uint*/int DiagID) {
  {
    // FIXME: It doesn't make sense to me that DiagID is an incoming argument here
    // and yet we also use the current diag ID on the DiagnosticsEngine. This has
    // been made more painfully obvious by the refactor that introduced this
    // function, but it is possible that the incoming argument can be
    // eliminnated. If it truly cannot be (for example, there is some reentrancy
    // issue I am not seeing yet), then there should at least be a clarifying
    // comment somewhere.
    OptionalPtr<TemplateDeductionInfo /*P*/ > Info = $this().isSFINAEContext();
    if (Info.$bool()) {
      switch (DiagnosticIDs.getDiagnosticSFINAEResponse($this().Diags.getCurrentDiagID())) {
       case SFINAE_Report:
        // We'll report the diagnostic below.
        break;
       case SFINAE_SubstitutionFailure:
        // Count this failure so that we know that template argument deduction
        // has failed.
        ++$this().NumSFINAEErrors;
        
        // Make a copy of this suppressed diagnostic and store it with the
        // template-deduction information.
        if ((Info.$star() != null) && !(Info.$star()).hasSFINAEDiagnostic()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Diagnostic DiagInfo/*J*/= new Diagnostic($AddrOf($this().Diags));
            (Info.$star()).addSFINAEDiagnostic(new SourceLocation(DiagInfo.getLocation()), 
                $c$.track(new PartialDiagnostic(DiagInfo, $this().Context.getDiagAllocator()))); $c$.clean();
          } finally {
            $c$.$destroy();
          }
        }
        
        $this().Diags.setLastDiagnosticIgnored();
        $this().Diags.Clear();
        return;
       case SFINAE_AccessControl:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Per C++ Core Issue 1170, access control is part of SFINAE.
            // Additionally, the AccessCheckingSFINAE flag can be used to temporarily
            // make access control a part of SFINAE for the purposes of checking
            // type traits.
            if (!$this().AccessCheckingSFINAE && !$this().getLangOpts().CPlusPlus11) {
              break;
            }
            
            SourceLocation Loc = $this().Diags.getCurrentDiagLoc();
            
            // Suppress this diagnostic.
            ++$this().NumSFINAEErrors;
            
            // Make a copy of this suppressed diagnostic and store it with the
            // template-deduction information.
            if ((Info.$star() != null) && !(Info.$star()).hasSFINAEDiagnostic()) {
              Diagnostic DiagInfo/*J*/= new Diagnostic($AddrOf($this().Diags));
              (Info.$star()).addSFINAEDiagnostic(new SourceLocation(DiagInfo.getLocation()), 
                  $c$.track(new PartialDiagnostic(DiagInfo, $this().Context.getDiagAllocator()))); $c$.clean();
            }
            
            $this().Diags.setLastDiagnosticIgnored();
            $this().Diags.Clear();
            
            // Now the diagnostic state is clear, produce a C++98 compatibility
            // warning.
            $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_cxx98_compat_sfinae_access_control)));
            
            // The last diagnostic which Sema produced was ignored. Suppress any
            // notes attached to it.
            $this().Diags.setLastDiagnosticIgnored();
            return;
          } finally {
            $c$.$destroy();
          }
        }
       case SFINAE_Suppress:
        // Make a copy of this suppressed diagnostic and store it with the
        // template-deduction information;
        if ((Info.$star() != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Diagnostic DiagInfo/*J*/= new Diagnostic($AddrOf($this().Diags));
            (Info.$star()).addSuppressedDiagnostic(new SourceLocation(DiagInfo.getLocation()), 
                $c$.track(new PartialDiagnostic(DiagInfo, $this().Context.getDiagAllocator()))); $c$.clean();
          } finally {
            $c$.$destroy();
          }
        }
        
        // Suppress this diagnostic.
        $this().Diags.setLastDiagnosticIgnored();
        $this().Diags.Clear();
        return;
      }
    }
  }
  
  // Set up the context's printing policy based on our current state.
  $this().Context.setPrintingPolicy($this().getPrintingPolicy());
  
  // Emit the diagnostic.
  if (!$this().Diags.EmitCurrentDiagnostic()) {
    return;
  }
  
  // If this is not a note, and we're in a template instantiation
  // that is different from the last template instantiation where
  // we emitted an error, print a template instantiation
  // backtrace.
  if (!DiagnosticIDs.isBuiltinNote(DiagID)
     && !$this().ActiveTemplateInstantiations.empty()
     && ActiveTemplateInstantiation.$noteq_ActiveTemplateInstantiation$C($this().ActiveTemplateInstantiations.back(), 
      $this().LastTemplateInstantiationErrorContext)) {
    $this().PrintInstantiationStack();
    $this().LastTemplateInstantiationErrorContext.$assign($this().ActiveTemplateInstantiations.back());
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::addImplicitTypedef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 136,
 FQN="clang::Sema::addImplicitTypedef", NM="_ZN5clang4Sema18addImplicitTypedefEN4llvm9StringRefENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema18addImplicitTypedefEN4llvm9StringRefENS_8QualTypeE")
//</editor-fold>
public final void addImplicitTypedef(StringRef Name, QualType T) {
  DeclarationName DN = new DeclarationName($AddrOf($this().Context.Idents.get(/*NO_COPY*/Name)));
  if ($this().IdResolver.begin(new DeclarationName(DN)).$eq($this().IdResolver.end())) {
    $this().PushOnScopeChains($this().Context.buildImplicitTypedef(new QualType(T), new StringRef(Name)), $this().TUScope);
  }
}


/// \brief Perform initialization that occurs after the parser has been
/// initialized but before it parses anything.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::Initialize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 142,
 FQN="clang::Sema::Initialize", NM="_ZN5clang4Sema10InitializeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema10InitializeEv")
//</editor-fold>
public final void Initialize() {
  {
    SemaConsumer /*P*/ SC = dyn_cast_SemaConsumer($AddrOf($this().Consumer));
    if ((SC != null)) {
      SC.InitializeSema(/*Deref*/$this());
    }
  }
  {
    
    // Tell the external Sema source about this Sema object.
    ExternalSemaSource /*P*/ ExternalSema = dyn_cast_or_null_ExternalSemaSource($this().Context.getExternalSource());
    if ((ExternalSema != null)) {
      ExternalSema.InitializeSema(/*Deref*/$this());
    }
  }
  
  // This needs to happen after ExternalSemaSource::InitializeSema(this) or we
  // will not be able to merge any duplicate __va_list_tag decls correctly.
  $this().VAListTagName.$assignMove(new DeclarationName($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"__va_list_tag"))));
  if (!($this().TUScope != null)) {
    return;
  }
  
  // Initialize predefined 128-bit integer types, if needed.
  if ($this().Context.getTargetInfo().hasInt128Type()) {
    // If either of the 128-bit integer types are unavailable to name lookup,
    // define them now.
    DeclarationName Int128 = new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"__int128_t"))));
    if ($this().IdResolver.begin(new DeclarationName(Int128)).$eq($this().IdResolver.end())) {
      $this().PushOnScopeChains($this().Context.getInt128Decl(), $this().TUScope);
    }
    
    DeclarationName UInt128 = new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"__uint128_t"))));
    if ($this().IdResolver.begin(new DeclarationName(UInt128)).$eq($this().IdResolver.end())) {
      $this().PushOnScopeChains($this().Context.getUInt128Decl(), $this().TUScope);
    }
  }
  
  // Initialize predefined Objective-C types:
  if ($this().getLangOpts().ObjC1) {
    // If 'SEL' does not yet refer to any declarations, make it refer to the
    // predefined 'SEL'.
    DeclarationName SEL = new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"SEL"))));
    if ($this().IdResolver.begin(new DeclarationName(SEL)).$eq($this().IdResolver.end())) {
      $this().PushOnScopeChains($this().Context.getObjCSelDecl(), $this().TUScope);
    }
    
    // If 'id' does not yet refer to any declarations, make it refer to the
    // predefined 'id'.
    DeclarationName Id = new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"id"))));
    if ($this().IdResolver.begin(new DeclarationName(Id)).$eq($this().IdResolver.end())) {
      $this().PushOnScopeChains($this().Context.getObjCIdDecl(), $this().TUScope);
    }
    
    // Create the built-in typedef for 'Class'.
    DeclarationName Class = new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"Class"))));
    if ($this().IdResolver.begin(new DeclarationName(Class)).$eq($this().IdResolver.end())) {
      $this().PushOnScopeChains($this().Context.getObjCClassDecl(), $this().TUScope);
    }
    
    // Create the built-in forward declaratino for 'Protocol'.
    DeclarationName Protocol = new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"Protocol"))));
    if ($this().IdResolver.begin(new DeclarationName(Protocol)).$eq($this().IdResolver.end())) {
      $this().PushOnScopeChains($this().Context.getObjCProtocolDecl(), $this().TUScope);
    }
  }
  
  // Create the internal type for the *StringMakeConstantString builtins.
  DeclarationName ConstantString = new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"__NSConstantString"))));
  if ($this().IdResolver.begin(new DeclarationName(ConstantString)).$eq($this().IdResolver.end())) {
    $this().PushOnScopeChains($this().Context.getCFConstantStringDecl(), $this().TUScope);
  }
  
  // Initialize Microsoft "predefined C++ types".
  if ($this().getLangOpts().MSVCCompat) {
    if ($this().getLangOpts().CPlusPlus
       && $this().IdResolver.begin(new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"type_info"))))).$eq($this().IdResolver.end())) {
      $this().PushOnScopeChains($this().Context.buildImplicitRecord(new StringRef(/*KEEP_STR*/"type_info"), TagTypeKind.TTK_Class), 
          $this().TUScope);
    }
    
    $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"size_t"), $this().Context.getSizeType().$QualType());
  }
  
  // Initialize predefined OpenCL types and supported optional core features.
  if ($this().getLangOpts().OpenCL) {
    // OPENCLEXT_INTERNAL
    
    // OpenCL 1.0.
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_3d_image_writes_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_3d_image_writes = true;
    }
    // fprounding mode is special since it is not mentioned beyond 1.0
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_select_fprounding_mode_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_select_fprounding_mode = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_byte_addressable_store_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_byte_addressable_store = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_fp16_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_fp16 = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_fp64_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_fp64 = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_global_int32_base_atomics_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_global_int32_base_atomics = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_global_int32_extended_atomics_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_global_int32_extended_atomics = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_local_int32_base_atomics_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_local_int32_base_atomics = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_local_int32_extended_atomics_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_local_int32_extended_atomics = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_int64_base_atomics_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_int64_base_atomics = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_int64_extended_atomics_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_int64_extended_atomics = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_gl_sharing_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_gl_sharing = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_icd_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_icd = true;
    }
    
    // OpenCL 1.1.
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_gl_event_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_gl_event = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_d3d10_sharing_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_d3d10_sharing = true;
    }
    
    // OpenCL 1.2.
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_context_abort_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_context_abort = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_d3d11_sharing_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_d3d11_sharing = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_depth_images_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_depth_images = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_dx9_media_sharing_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_dx9_media_sharing = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_image2d_from_buffer_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_image2d_from_buffer = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_initialize_memory_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_initialize_memory = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_gl_depth_images_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_gl_depth_images = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_gl_msaa_sharing_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_gl_msaa_sharing = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_spir_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_spir = true;
    }
    
    // OpenCL 2.0.
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_egl_event_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_egl_event = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_egl_image_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_egl_image = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_srgb_image_writes_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_srgb_image_writes = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_subgroups_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_subgroups = true;
    }
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_khr_terminate_context_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_khr_terminate_context = true;
    }
    
    // Clang Extensions.
    if ($this().Context.getTargetInfo().getSupportedOpenCLOpts$Const().is_cl_clang_storage_class_specifiers_supported_core($this().getLangOpts().OpenCLVersion)) {
      $this().getOpenCLOptions().cl_clang_storage_class_specifiers = true;
    }
    
    $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"sampler_t"), $this().Context.OCLSamplerTy.$QualType());
    $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"event_t"), $this().Context.OCLEventTy.$QualType());
    if ($greatereq_uint($this().getLangOpts().OpenCLVersion, 200)) {
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"clk_event_t"), $this().Context.OCLClkEventTy.$QualType());
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"queue_t"), $this().Context.OCLQueueTy.$QualType());
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"ndrange_t"), $this().Context.OCLNDRangeTy.$QualType());
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"reserve_id_t"), $this().Context.OCLReserveIDTy.$QualType());
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"atomic_int"), $this().Context.getAtomicType($this().Context.IntTy.$QualType()));
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"atomic_uint"), 
          $this().Context.getAtomicType($this().Context.UnsignedIntTy.$QualType()));
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"atomic_long"), $this().Context.getAtomicType($this().Context.LongTy.$QualType()));
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"atomic_ulong"), 
          $this().Context.getAtomicType($this().Context.UnsignedLongTy.$QualType()));
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"atomic_float"), 
          $this().Context.getAtomicType($this().Context.FloatTy.$QualType()));
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"atomic_double"), 
          $this().Context.getAtomicType($this().Context.DoubleTy.$QualType()));
      // OpenCLC v2.0, s6.13.11.6 requires that atomic_flag is implemented as
      // 32-bit integer and OpenCLC v2.0, s6.1.1 int is always 32-bit wide.
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"atomic_flag"), $this().Context.getAtomicType($this().Context.IntTy.$QualType()));
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"atomic_intptr_t"), 
          $this().Context.getAtomicType($this().Context.getIntPtrType()));
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"atomic_uintptr_t"), 
          $this().Context.getAtomicType($this().Context.getUIntPtrType()));
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"atomic_size_t"), 
          $this().Context.getAtomicType($this().Context.getSizeType().$QualType()));
      $this().addImplicitTypedef(new StringRef(/*KEEP_STR*/"atomic_ptrdiff_t"), 
          $this().Context.getAtomicType($this().Context.getPointerDiffType()));
    }
  }
  if ($this().Context.getTargetInfo().hasBuiltinMSVaList()) {
    DeclarationName MSVaList = new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"__builtin_ms_va_list"))));
    if ($this().IdResolver.begin(new DeclarationName(MSVaList)).$eq($this().IdResolver.end())) {
      $this().PushOnScopeChains($this().Context.getBuiltinMSVaListDecl(), $this().TUScope);
    }
  }
  
  DeclarationName BuiltinVaList = new DeclarationName($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"__builtin_va_list"))));
  if ($this().IdResolver.begin(new DeclarationName(BuiltinVaList)).$eq($this().IdResolver.end())) {
    $this().PushOnScopeChains($this().Context.getBuiltinVaListDecl(), $this().TUScope);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getASTMutationListener">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 317,
 FQN="clang::Sema::getASTMutationListener", NM="_ZNK5clang4Sema22getASTMutationListenerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema22getASTMutationListenerEv")
//</editor-fold>
public final ASTMutationListener /*P*/ getASTMutationListener() /*const*/ {
  return $this().getASTConsumer().GetASTMutationListener();
}


///\brief Registers an external source. If an external source already exists,
/// creates a multiplex external source and appends to it.
///
///\param[in] E - A non-null external sema source.
///

///\brief Registers an external source. If an external source already exists,
/// creates a multiplex external source and appends to it.
///
///\param[in] E - A non-null external sema source.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::addExternalSource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 326,
 FQN="clang::Sema::addExternalSource", NM="_ZN5clang4Sema17addExternalSourceEPNS_18ExternalSemaSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema17addExternalSourceEPNS_18ExternalSemaSourceE")
//</editor-fold>
public final void addExternalSource(ExternalSemaSource /*P*/ E) {
  assert ((E != null)) : "Cannot use with NULL ptr";
  if (!($this().ExternalSource != null)) {
    $this().ExternalSource = E;
    return;
  }
  if ($this().isMultiplexExternalSource) {
    ((/*static_cast*/MultiplexExternalSemaSource /*P*/ )($this().ExternalSource)).addSource($Deref(E));
  } else {
    $this().ExternalSource = new MultiplexExternalSemaSource($Deref($this().ExternalSource), $Deref(E));
    $this().isMultiplexExternalSource = true;
  }
}


/// \brief Print out statistics about the semantic analysis.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PrintStats">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 343,
 FQN="clang::Sema::PrintStats", NM="_ZNK5clang4Sema10PrintStatsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema10PrintStatsEv")
//</editor-fold>
public final void PrintStats() /*const*/ {
  llvm.errs().$out(/*KEEP_STR*/"\n*** Semantic Analysis Stats:\n");
  llvm.errs().$out_uint($this().NumSFINAEErrors).$out(/*KEEP_STR*/" SFINAE diagnostics trapped.\n");
  
  $this().BumpAlloc.PrintStats();
  $this().AnalysisWarnings.PrintStats();
}


/// \brief Emit a partial diagnostic.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::Diag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1061,
 FQN="clang::Sema::Diag", NM="_ZN5clang4Sema4DiagENS_14SourceLocationERKNS_17PartialDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema4DiagENS_14SourceLocationERKNS_17PartialDiagnosticE")
//</editor-fold>
public final Sema.SemaDiagnosticBuilder Diag(SourceLocation Loc, final /*const*/ PartialDiagnostic /*&*/ PD) {
  SemaDiagnosticBuilder Builder = null;
  try {
    Builder/*J*/= $this().Diag(new SourceLocation(Loc), PD.getDiagID());
    PD.Emit(Builder);
    
    return new Sema.SemaDiagnosticBuilder(Builder);
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}

// in SemaInternal.h

/// \brief Looks through the macro-expansion chain for the given
/// location, looking for a macro expansion with the given name.
/// If one is found, returns true and sets the location to that
/// expansion loc.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::findMacroSpelling">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1073,
 FQN="clang::Sema::findMacroSpelling", NM="_ZN5clang4Sema17findMacroSpellingERNS_14SourceLocationEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema17findMacroSpellingERNS_14SourceLocationEN4llvm9StringRefE")
//</editor-fold>
public final boolean findMacroSpelling(final SourceLocation /*&*/ locref, StringRef name) {
  SourceLocation loc = new SourceLocation(locref);
  if (!loc.isMacroID()) {
    return false;
  }
  
  // There's no good way right now to look at the intermediate
  // expansions, so just jump to the expansion location.
  loc.$assignMove($this().getSourceManager().getExpansionLoc(/*NO_COPY*/loc));
  
  // If that's written with the name, stop here.
  SmallString buffer/*J*/= new SmallString(16);
  if ($eq_StringRef($this().getPreprocessor().getSpelling(new SourceLocation(loc), buffer), /*NO_COPY*/name)) {
    locref.$assign(loc);
    return true;
  }
  return false;
}


/// \brief Calls \c Lexer::getLocForEndOfToken()
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getLocForEndOfToken">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 46,
 FQN="clang::Sema::getLocForEndOfToken", NM="_ZN5clang4Sema19getLocForEndOfTokenENS_14SourceLocationEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema19getLocForEndOfTokenENS_14SourceLocationEj")
//</editor-fold>
public final SourceLocation getLocForEndOfToken(SourceLocation Loc) {
  return getLocForEndOfToken(Loc, 0);
}
public final SourceLocation getLocForEndOfToken(SourceLocation Loc, /*uint*/int Offset/*= 0*/) {
  return Lexer.getLocForEndOfToken(/*NO_COPY*/Loc, Offset, $this().SourceMgr, $this().LangOpts);
}


/// \brief Retrieve the module loader associated with the preprocessor.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getModuleLoader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 50,
 FQN="clang::Sema::getModuleLoader", NM="_ZNK5clang4Sema15getModuleLoaderEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema15getModuleLoaderEv")
//</editor-fold>
public final ModuleLoader /*&*/ getModuleLoader() /*const*/ {
  return $this().PP.getModuleLoader();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::emitAndClearUnusedLocalTypedefWarnings">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 635,
 FQN="clang::Sema::emitAndClearUnusedLocalTypedefWarnings", NM="_ZN5clang4Sema38emitAndClearUnusedLocalTypedefWarningsEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema38emitAndClearUnusedLocalTypedefWarningsEv")
//</editor-fold>
public final void emitAndClearUnusedLocalTypedefWarnings() {
  if (($this().ExternalSource != null)) {
    $this().ExternalSource.ReadUnusedLocalTypedefNameCandidates($this().UnusedLocalTypedefNameCandidates);
  }
  for (/*const*/ TypedefNameDecl /*P*/ TD : $this().UnusedLocalTypedefNameCandidates) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (TD.isReferenced()) {
        continue;
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(TD.getLocation(), diag.warn_unused_local_typedef)), 
              isa_TypeAliasDecl(TD)), TD.getDeclName()));
    } finally {
      $c$.$destroy();
    }
  }
  $this().UnusedLocalTypedefNameCandidates.clear();
}


/// ActOnEndOfTranslationUnit - This is called at the very end of the
/// translation unit when EOF is reached and all but the top-level scope is
/// popped.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnEndOfTranslationUnit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 651,
 FQN="clang::Sema::ActOnEndOfTranslationUnit", NM="_ZN5clang4Sema25ActOnEndOfTranslationUnitEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema25ActOnEndOfTranslationUnitEv")
//</editor-fold>
public final void ActOnEndOfTranslationUnit() {
  SmallSetT$PLess$T$P<VarDecl /*P*/ > Seen = null;
  try {
    assert ($this().DelayedDiagnostics.getCurrentPool() == null) : "reached end of translation unit with a pool attached?";
    
    // If code completion is enabled, don't perform any end-of-translation-unit
    // work.
    if ($this().PP.isCodeCompletionEnabled()) {
      return;
    }
    
    // Complete translation units and modules define vtables and perform implicit
    // instantiations. PCH files do not.
    if ($this().TUKind != TranslationUnitKind.TU_Prefix) {
      $this().DiagnoseUseOfUnimplementedSelectors();
      
      // If DefinedUsedVTables ends up marking any virtual member functions it
      // might lead to more pending template instantiations, which we then need
      // to instantiate.
      $this().DefineUsedVTables();
      
      // C++: Perform implicit template instantiations.
      //
      // FIXME: When we perform these implicit instantiations, we do not
      // carefully keep track of the point of instantiation (C++ [temp.point]).
      // This means that name lookup that occurs within the template
      // instantiation will always happen at the end of the translation unit,
      // so it will find some names that are not required to be found. This is
      // valid, but we could do better by diagnosing if an instantiation uses a
      // name that was not visible at its first point of instantiation.
      if (($this().ExternalSource != null)) {
        // Load pending instantiations from the external source.
        SmallVector<std.pair<ValueDecl /*P*/ , SourceLocation>> Pending/*J*/= new SmallVector<std.pair<ValueDecl /*P*/ , SourceLocation>>(4, new std.pairPtrType<ValueDecl /*P*/ , SourceLocation>(null, new SourceLocation()));
        $this().ExternalSource.ReadPendingInstantiations(Pending);
        $this().PendingInstantiations.insert$T(new std.deque.iterator<std.pair<ValueDecl /*P*/ , SourceLocation>>($this().PendingInstantiations.begin()), 
            Pending.begin(), Pending.end());
      }
      $this().PerformPendingInstantiations();
      if (($this().LateTemplateParserCleanup != null)) {
        $this().LateTemplateParserCleanup.$call($this().OpaqueParser);
      }
      
      $this().CheckDelayedMemberExceptionSpecs();
    }
    
    // All delayed member exception specs should be checked or we end up accepting
    // incompatible declarations.
    // FIXME: This is wrong for TUKind == TU_Prefix. In that case, we need to
    // write out the lists to the AST file (if any).
    assert ($this().DelayedDefaultedMemberExceptionSpecs.empty());
    assert ($this().DelayedExceptionSpecChecks.empty());
    
    // All dllexport classes should have been processed already.
    assert ($this().DelayedDllExportClasses.empty());
    
    // Remove file scoped decls that turned out to be used.
    $this().UnusedFileScopedDecls.erase(std.remove_if($this().UnusedFileScopedDecls.begin((ExternalSemaSource /*P*/ )null, true), 
            $this().UnusedFileScopedDecls.end(), 
            std.bind1st(/*FuncRef*/SemaStatics::ShouldRemoveFromUnused, $this())), 
        $this().UnusedFileScopedDecls.end());
    if ($this().TUKind == TranslationUnitKind.TU_Prefix) {
      // Translation unit prefixes don't need any of the checking below.
      $this().TUScope = null;
      return;
    }
    
    // Check for #pragma weak identifiers that were never declared
    $this().LoadExternalWeakUndeclaredIdentifiers();
    for (pair<IdentifierInfo /*P*/ , WeakInfo> WeakID : $this().WeakUndeclaredIdentifiers) {
      if (WeakID.second.getUsed()) {
        continue;
      }
      
      Decl /*P*/ PrevDecl = $this().LookupSingleName($this().TUScope, new DeclarationName(WeakID.first), new SourceLocation(), 
          LookupNameKind.LookupOrdinaryName);
      if (PrevDecl != null
         && !(isa_FunctionDecl(PrevDecl) || isa_VarDecl(PrevDecl))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(WeakID.second.getLocation(), diag.warn_attribute_wrong_decl_type)), 
                  /*KEEP_STR*/"'weak'"), AttributeDeclKind.ExpectedVariableOrFunction));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(WeakID.second.getLocation(), diag.warn_weak_identifier_undeclared)), 
              WeakID.first));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if ($this().LangOpts.CPlusPlus11
       && !$this().Diags.isIgnored(diag.warn_delegating_ctor_cycle, new SourceLocation())) {
      $this().CheckDelegatingCtorCycles();
    }
    if (!$this().Diags.hasErrorOccurred()) {
      if (($this().ExternalSource != null)) {
        $this().ExternalSource.ReadUndefinedButUsed($this().UndefinedButUsed);
      }
      checkUndefinedButUsed(/*Deref*/$this());
    }
    if ($this().TUKind == TranslationUnitKind.TU_Module) {
      {
        // If we are building a module, resolve all of the exported declarations
        // now.
        Module /*P*/ CurrentModule = $this().PP.getCurrentModule();
        if ((CurrentModule != null)) {
          final ModuleMap /*&*/ ModMap = $this().PP.getHeaderSearchInfo().getModuleMap();
          
          SmallVector<Module /*P*/> Stack/*J*/= new SmallVector<Module /*P*/>(2, (Module /*P*/)null);
          Stack.push_back(CurrentModule);
          while (!Stack.empty()) {
            Module /*P*/ Mod = Stack.pop_back_val();
            
            // Resolve the exported declarations and conflicts.
            // FIXME: Actually complain, once we figure out how to teach the
            // diagnostic client to deal with complaints in the module map at this
            // point.
            ModMap.resolveExports(Mod, /*Complain=*/ false);
            ModMap.resolveUses(Mod, /*Complain=*/ false);
            ModMap.resolveConflicts(Mod, /*Complain=*/ false);
            
            // Queue the submodules, so their exports will also be resolved.
            Stack.append_T(Mod.submodule_begin(), Mod.submodule_end());
          }
        }
      }
      
      // Warnings emitted in ActOnEndOfTranslationUnit() should be emitted for
      // modules when they are built, not every time they are used.
      $this().emitAndClearUnusedLocalTypedefWarnings();
      
      // Modules don't need any of the checking below.
      $this().TUScope = null;
      return;
    }
    
    // C99 6.9.2p2:
    //   A declaration of an identifier for an object that has file
    //   scope without an initializer, and without a storage-class
    //   specifier or with the storage-class specifier static,
    //   constitutes a tentative definition. If a translation unit
    //   contains one or more tentative definitions for an identifier,
    //   and the translation unit contains no external definition for
    //   that identifier, then the behavior is exactly as if the
    //   translation unit contains a file scope declaration of that
    //   identifier, with the composite type as of the end of the
    //   translation unit, with an initializer equal to 0.
    Seen/*J*/= new SmallSetT$PLess$T$P<VarDecl /*P*/ >(32);
    for (LazyVector.iterator<VarDecl /*P*/ , ExternalSemaSource> T = $this().TentativeDefinitions.begin($this().ExternalSource), 
        TEnd = $this().TentativeDefinitions.end();
         T.$noteq(TEnd); T.$preInc()) {
      VarDecl /*P*/ VD = (T.$star()).getActingDefinition();
      
      // If the tentative definition was completed, getActingDefinition() returns
      // null. If we've already seen this variable before, insert()'s second
      // return value is false.
      if (!(VD != null) || VD.isInvalidDecl() || !Seen.insert(VD).second) {
        continue;
      }
      {
        
        /*const*/ IncompleteArrayType /*P*/ ArrayT = $this().Context.getAsIncompleteArrayType(VD.getType());
        if ((ArrayT != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Set the length of the array to 1 (C99 6.9.2p5).
            $c$.clean($c$.track($this().Diag(VD.getLocation(), diag.warn_tentative_incomplete_array)));
            APInt One/*J*/= new APInt($ulong2uint($this().Context.getTypeSize($this().Context.getSizeType().$QualType())), /*true*/1);
            QualType T$1 = $this().Context.getConstantArrayType(ArrayT.getElementType(), 
                One, ArrayType.ArraySizeModifier.Normal, 0);
            VD.setType(new QualType(T$1));
          } finally {
            $c$.$destroy();
          }
        } else if ($this().RequireCompleteType(VD.getLocation(), VD.getType(), 
            diag.err_tentative_def_incomplete_type)) {
          VD.setInvalidDecl();
        }
      }
      
      $this().CheckCompleteVariableDeclaration(VD);
      
      // Notify the consumer that we've completed a tentative definition.
      if (!VD.isInvalidDecl()) {
        $this().Consumer.CompleteTentativeDefinition(VD);
      }
    }
    
    // If there were errors, disable 'unused' warnings since they will mostly be
    // noise.
    if (!$this().Diags.hasErrorOccurred()) {
      // Output warning for unused file scoped decls.      
      for (LazyVector.iterator<DeclaratorDecl, ?> I = $this().UnusedFileScopedDecls.begin($this().ExternalSource), 
          E = $this().UnusedFileScopedDecls.end(); I.$noteq(E); I.$preInc()) {
        if (ShouldRemoveFromUnused($this(), I.$star())) {
          continue;
        }
        {
          
          /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(I.$star());
          if ((FD != null)) {
            type$ref</*const*/ FunctionDecl /*P*/ > DiagD = create_type$ref();
            if (!FD.hasBody(DiagD)) {
              DiagD.$set(FD);
            }
            if (DiagD.$deref().isDeleted()) {
              continue; // Deleted functions are supposed to be unused.
            }
            if (DiagD.$deref().isReferenced()) {
              if (isa_CXXMethodDecl(DiagD)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DiagD.$deref().getLocation(), diag.warn_unneeded_member_function)), 
                      DiagD.$deref().getDeclName()));
                } finally {
                  $c$.$destroy();
                }
              } else {
                if (FD.getStorageClass() == StorageClass.SC_Static
                   && !FD.isInlineSpecified()
                   && !$this().SourceMgr.isInMainFile($this().SourceMgr.getExpansionLoc(FD.getLocation()))) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DiagD.$deref().getLocation(), 
                            diag.warn_unneeded_static_internal_decl)), 
                        DiagD.$deref().getDeclName()));
                  } finally {
                    $c$.$destroy();
                  }
                } else {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DiagD.$deref().getLocation(), diag.warn_unneeded_internal_decl)), 
                            /*function*/ 0), DiagD.$deref().getDeclName()));
                  } finally {
                    $c$.$destroy();
                  }
                }
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DiagD.$deref().getLocation(), 
                        isa_CXXMethodDecl(DiagD) ? diag.warn_unused_member_function : diag.warn_unused_function)), 
                    DiagD.$deref().getDeclName()));
              } finally {
                $c$.$destroy();
              }
            }
          } else {
            /*const*/ VarDecl /*P*/ DiagD = cast_VarDecl(I.$star()).getDefinition$Const();
            if (!(DiagD != null)) {
              DiagD = cast_VarDecl(I.$star());
            }
            if (DiagD.isReferenced()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DiagD.getLocation(), diag.warn_unneeded_internal_decl)), 
                        /*variable*/ 1), DiagD.getDeclName()));
              } finally {
                $c$.$destroy();
              }
            } else if (DiagD.getType().isConstQualified()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DiagD.getLocation(), diag.warn_unused_const_variable)), 
                    DiagD.getDeclName()));
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DiagD.getLocation(), diag.warn_unused_variable)), 
                    DiagD.getDeclName()));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
      
      $this().emitAndClearUnusedLocalTypedefWarnings();
    }
    if (!$this().Diags.isIgnored(diag.warn_unused_private_field, new SourceLocation())) {
      DenseMapTypeBool</*const*/ CXXRecordDecl /*P*/ > RecordsComplete/*J*/= new DenseMapTypeBool</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), false);
      DenseMapTypeBool</*const*/ CXXRecordDecl /*P*/ > MNCComplete/*J*/= new DenseMapTypeBool</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), false);
      //for (type$ptr</*const*/ NamedDecl /*P*/ /*const*/ /*P*/> I = $tryClone($this().UnusedPrivateFields.begin()), 
      for (StdVector.iterator<NamedDecl> I = $tryClone($this().UnusedPrivateFields.begin()), 
          /*P*/ E = $tryClone($this().UnusedPrivateFields.end()); $noteq_ptr(I, E); I.$preInc()) {
        /*const*/ NamedDecl /*P*/ D = I.$star();
        /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D.getDeclContext$Const());
        if ((RD != null) && !RD.isUnion()
           && IsRecordFullyDefined(RD, RecordsComplete, MNCComplete)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.warn_unused_private_field)), 
                D.getDeclName()));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if (!$this().Diags.isIgnored(diag.warn_mismatched_delete_new, new SourceLocation())) {
      if (($this().ExternalSource != null)) {
        $this().ExternalSource.ReadMismatchingDeleteExpressions($this().DeleteExprs);
      }
      for (final /*const*/ pair<FieldDecl /*P*/ , SmallVector<std.pairTypeBool<SourceLocation>> > /*&*/ DeletedFieldInfo : $this().DeleteExprs) {
        for (final /*const*/std.pairTypeBool<SourceLocation> /*&*/ DeleteExprLoc : DeletedFieldInfo.second) {
          $this().AnalyzeDeleteExprMismatch(DeletedFieldInfo.first, new SourceLocation(DeleteExprLoc.first), 
              DeleteExprLoc.second);
        }
      }
    }
    
    // Check we've noticed that we're no longer parsing the initializer for every
    // variable. If we miss cases, then at best we have a performance issue and
    // at worst a rejects-valid bug.
    assert ($this().ParsingInitForAutoVars.empty()) : "Didn't unmark var as having its initializer parsed";
    
    $this().TUScope = null;
  } finally {
    if (Seen != null) { Seen.$destroy(); }
  }
}


/// \brief Determines the active Scope associated with the given declaration
/// context.
///
/// This routine maps a declaration context to the active Scope object that
/// represents that declaration context in the parser. It is typically used
/// from "scope-less" code (e.g., template instantiation, lazy creation of
/// declarations) that injects a name for name-lookup purposes and, therefore,
/// must update the Scope.
///
/// \returns The scope corresponding to the given declaraion context, or NULL
/// if no such scope is open.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getScopeForContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1101,
 FQN="clang::Sema::getScopeForContext", NM="_ZN5clang4Sema18getScopeForContextEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema18getScopeForContextEPNS_11DeclContextE")
//</editor-fold>
public final Scope /*P*/ getScopeForContext(DeclContext /*P*/ Ctx) {
  if (!(Ctx != null)) {
    return null;
  }
  
  Ctx = Ctx.getPrimaryContext();
  for (Scope /*P*/ S = $this().getCurScope(); (S != null); S = S.getParent()) {
    // Ignore scopes that cannot have declarations. This is important for
    // out-of-line definitions of static class members.
    if (((S.getFlags() & (Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.TemplateParamScope)) != 0)) {
      {
        DeclContext /*P*/ Entity = S.getEntity();
        if ((Entity != null)) {
          if (Ctx == Entity.getPrimaryContext()) {
            return S;
          }
        }
      }
    }
  }
  
  return null;
}


/// \brief Enter a new function scope
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PushFunctionScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1120,
 FQN="clang::Sema::PushFunctionScope", NM="_ZN5clang4Sema17PushFunctionScopeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema17PushFunctionScopeEv")
//</editor-fold>
public final void PushFunctionScope() {
  if ($this().FunctionScopes.size() == 1) {
    // Use the "top" function scope rather than having to allocate
    // memory for a new scope.
    $this().FunctionScopes.back().Clear();
    $this().FunctionScopes.push_back($this().FunctionScopes.back());
    return;
  }
  
  $this().FunctionScopes.push_back(new FunctionScopeInfo($this().getDiagnostics()));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PushBlockScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1132,
 FQN="clang::Sema::PushBlockScope", NM="_ZN5clang4Sema14PushBlockScopeEPNS_5ScopeEPNS_9BlockDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema14PushBlockScopeEPNS_5ScopeEPNS_9BlockDeclE")
//</editor-fold>
public final void PushBlockScope(Scope /*P*/ BlockScope, BlockDecl /*P*/ Block) {
  $this().FunctionScopes.push_back(new BlockScopeInfo($this().getDiagnostics(), 
          BlockScope, Block));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PushLambdaScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1137,
 FQN="clang::Sema::PushLambdaScope", NM="_ZN5clang4Sema15PushLambdaScopeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema15PushLambdaScopeEv")
//</editor-fold>
public final LambdaScopeInfo /*P*/ PushLambdaScope() {
  LambdaScopeInfo /*P*/ /*const*/ LSI = new LambdaScopeInfo($this().getDiagnostics());
  $this().FunctionScopes.push_back(LSI);
  return LSI;
}


/// \brief This is used to inform Sema what the current TemplateParameterDepth
/// is during Parsing.  Currently it is used to pass on the depth
/// when parsing generic lambda 'auto' parameters.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::RecordParsingTemplateParameterDepth">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1143,
 FQN="clang::Sema::RecordParsingTemplateParameterDepth", NM="_ZN5clang4Sema35RecordParsingTemplateParameterDepthEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema35RecordParsingTemplateParameterDepthEj")
//</editor-fold>
public final void RecordParsingTemplateParameterDepth(/*uint*/int Depth) {
  {
    LambdaScopeInfo /*P*/ /*const*/ LSI = $this().getCurLambda();
    if ((LSI != null)) {
      LSI.AutoTemplateParameterDepth = Depth;
      return;
    }
  }
  throw new llvm_unreachable("Remove assertion if intentionally called in a non-lambda context.");
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PushCapturedRegionScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1502,
 FQN="clang::Sema::PushCapturedRegionScope", NM="_ZN5clang4Sema23PushCapturedRegionScopeEPNS_5ScopeEPNS_12CapturedDeclEPNS_10RecordDeclENS_18CapturedRegionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema23PushCapturedRegionScopeEPNS_5ScopeEPNS_12CapturedDeclEPNS_10RecordDeclENS_18CapturedRegionKindE")
//</editor-fold>
public final void PushCapturedRegionScope(Scope /*P*/ S, CapturedDecl /*P*/ CD, RecordDecl /*P*/ RD, 
                       CapturedRegionKind K) {
  CapturingScopeInfo /*P*/ CSI = new CapturedRegionScopeInfo($this().getDiagnostics(), S, CD, RD, CD.getContextParam(), K, 
      (($this().getLangOpts().OpenMP != 0) && K == CapturedRegionKind.CR_OpenMP) ? $this().getOpenMPNestingLevel() : 0);
  CSI.ReturnType.$assignMove($this().Context.VoidTy.$QualType());
  $this().FunctionScopes.push_back(CSI);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PopFunctionScopeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1152,
 FQN="clang::Sema::PopFunctionScopeInfo", NM="_ZN5clang4Sema20PopFunctionScopeInfoEPKNS_4sema21AnalysisBasedWarnings6PolicyEPKNS_4DeclEPKNS_9BlockExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema20PopFunctionScopeInfoEPKNS_4sema21AnalysisBasedWarnings6PolicyEPKNS_4DeclEPKNS_9BlockExprE")
//</editor-fold>
public final void PopFunctionScopeInfo() {
  PopFunctionScopeInfo((/*const*/ AnalysisBasedWarnings.Policy /*P*/ )null, 
                    (/*const*/ Decl /*P*/ )null, (/*const*/ BlockExpr /*P*/ )null);
}
public final void PopFunctionScopeInfo(/*const*/ AnalysisBasedWarnings.Policy /*P*/ WP/*= null*/) {
  PopFunctionScopeInfo(WP, 
                    (/*const*/ Decl /*P*/ )null, (/*const*/ BlockExpr /*P*/ )null);
}
public final void PopFunctionScopeInfo(/*const*/ AnalysisBasedWarnings.Policy /*P*/ WP/*= null*/, 
                    /*const*/ Decl /*P*/ D/*= null*/) {
  PopFunctionScopeInfo(WP, 
                    D, (/*const*/ BlockExpr /*P*/ )null);
}
public final void PopFunctionScopeInfo(/*const*/ AnalysisBasedWarnings.Policy /*P*/ WP/*= null*/, 
                    /*const*/ Decl /*P*/ D/*= null*/, /*const*/ BlockExpr /*P*/ blkExpr/*= null*/) {
  FunctionScopeInfo /*P*/ Scope = $this().FunctionScopes.pop_back_val();
  assert (!$this().FunctionScopes.empty()) : "mismatched push/pop!";
  
  // Issue any analysis-based warnings.
  if ((WP != null) && (D != null)) {
    $this().AnalysisWarnings.IssueWarnings(new Policy($Deref(WP)), Scope, D, blkExpr);
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      for (final /*const*/ PossiblyUnreachableDiag /*&*/ PUD : Scope.PossiblyUnreachableDiags)  {
        $c$.clean($c$.track($this().Diag(new SourceLocation(PUD.Loc), PUD.PD)));
      }
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().FunctionScopes.back() != Scope) {
    if (Scope != null) { Scope.$destroy();};
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PushCompoundScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1168,
 FQN="clang::Sema::PushCompoundScope", NM="_ZN5clang4Sema17PushCompoundScopeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema17PushCompoundScopeEv")
//</editor-fold>
public final void PushCompoundScope() {
  $this().getCurFunction().CompoundScopes.push_back(new CompoundScopeInfo());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PopCompoundScope">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1172,
 FQN="clang::Sema::PopCompoundScope", NM="_ZN5clang4Sema16PopCompoundScopeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema16PopCompoundScopeEv")
//</editor-fold>
public final void PopCompoundScope() {
  FunctionScopeInfo /*P*/ CurFunction = $this().getCurFunction();
  // JAVA: do not corrupt NativeTrace.firstException by asserts from $destroy
  if (CurFunction.CompoundScopes.empty()) {
    NativeTrace.printDebuggingStackFrames("Sema::PopCompoundScope ERROR: mismatched push/pop " + 
            "(If in finally then check exception thrown in try/catch)");    
    return;
  }
  assert (!CurFunction.CompoundScopes.empty()) : "mismatched push/pop";
  
  CurFunction.CompoundScopes.pop_back();
}


/// \brief Determine whether any errors occurred within this function/method/
/// block.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::hasAnyUnrecoverableErrorsInThisFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1181,
 FQN="clang::Sema::hasAnyUnrecoverableErrorsInThisFunction", NM="_ZNK5clang4Sema39hasAnyUnrecoverableErrorsInThisFunctionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema39hasAnyUnrecoverableErrorsInThisFunctionEv")
//</editor-fold>
public final boolean hasAnyUnrecoverableErrorsInThisFunction() /*const*/ {
  return $this().getCurFunction().ErrorTrap.hasUnrecoverableErrorOccurred();
}


/// \brief Retrieve the current block, if any.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1185,
 FQN="clang::Sema::getCurBlock", NM="_ZN5clang4Sema11getCurBlockEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema11getCurBlockEv")
//</editor-fold>
public final BlockScopeInfo /*P*/ getCurBlock() {
  if ($this().FunctionScopes.empty()) {
    return null;
  }
  
  BlockScopeInfo /*P*/ CurBSI = dyn_cast_BlockScopeInfo($this().FunctionScopes.back());
  if ((CurBSI != null) && (CurBSI.TheDecl != null)
     && !CurBSI.TheDecl.Encloses($this().CurContext)) {
    // We have switched contexts due to template instantiation.
    assert (!$this().ActiveTemplateInstantiations.empty());
    return null;
  }
  
  return CurBSI;
}


/// \brief Retrieve the current lambda scope info, if any.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurLambda">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1200,
 FQN="clang::Sema::getCurLambda", NM="_ZN5clang4Sema12getCurLambdaEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12getCurLambdaEv")
//</editor-fold>
public final LambdaScopeInfo /*P*/ getCurLambda() {
  if ($this().FunctionScopes.empty()) {
    return null;
  }
  
  LambdaScopeInfo /*P*/ CurLSI = dyn_cast_LambdaScopeInfo($this().FunctionScopes.back());
  if ((CurLSI != null) && (CurLSI.Lambda != null)
     && !CurLSI.Lambda.Encloses($this().CurContext)) {
    // We have switched contexts due to template instantiation.
    assert (!$this().ActiveTemplateInstantiations.empty());
    return null;
  }
  
  return CurLSI;
}


/// \brief Retrieve the current generic lambda info, if any.
// We have a generic lambda if we parsed auto parameters, or we have 
// an associated template parameter list.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurGenericLambda">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1216,
 FQN="clang::Sema::getCurGenericLambda", NM="_ZN5clang4Sema19getCurGenericLambdaEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema19getCurGenericLambdaEv")
//</editor-fold>
public final LambdaScopeInfo /*P*/ getCurGenericLambda() {
  {
    LambdaScopeInfo /*P*/ LSI = $this().getCurLambda();
    if ((LSI != null)) {
      return ((LSI.AutoTemplateParams.size() != 0)
         || (LSI.GLTemplateParameterList != null)) ? LSI : null;
    }
  }
  return null;
}


/// \brief Retrieve the current captured region, if any.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurCapturedRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1511,
 FQN="clang::Sema::getCurCapturedRegion", NM="_ZN5clang4Sema20getCurCapturedRegionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema20getCurCapturedRegionEv")
//</editor-fold>
public final CapturedRegionScopeInfo /*P*/ getCurCapturedRegion() {
  if ($this().FunctionScopes.empty()) {
    return null;
  }
  
  return dyn_cast_CapturedRegionScopeInfo($this().FunctionScopes.back());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1225,
 FQN="clang::Sema::ActOnComment", NM="_ZN5clang4Sema12ActOnCommentENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema12ActOnCommentENS_11SourceRangeE")
//</editor-fold>
public final void ActOnComment(SourceRange Comment) {
  if (!$this().LangOpts.RetainCommentsFromSystemHeaders
     && $this().SourceMgr.isInSystemHeader(Comment.getBegin())) {
    return;
  }
  RawComment RC/*J*/= new RawComment($this().SourceMgr, new SourceRange(Comment), false, 
      $this().LangOpts.CommentOpts.ParseAllComments);
  if (RC.isAlmostTrailingComment()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceRange MagicMarkerRange/*J*/= new SourceRange(Comment.getBegin(), 
          Comment.getBegin().getLocWithOffset(3));
      StringRef MagicMarkerText/*J*/= new StringRef();
      switch (RC.getKind()) {
       case RCK_OrdinaryBCPL:
        MagicMarkerText.$assignMove(/*STRINGREF_STR*/"///<");
        break;
       case RCK_OrdinaryC:
        MagicMarkerText.$assignMove(/*STRINGREF_STR*/"/**<");
        break;
       default:
        throw new llvm_unreachable("if this is an almost Doxygen comment, it should be ordinary");
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Comment.getBegin(), diag.warn_not_a_doxygen_trailing_member_comment)), 
          FixItHint.CreateReplacement(/*NO_COPY*/MagicMarkerRange, /*NO_COPY*/MagicMarkerText)));
    } finally {
      $c$.$destroy();
    }
  }
  $this().Context.addComment(RC);
}


/// \brief Retrieve a suitable printing policy.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getPrintingPolicy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 52,
 FQN="clang::Sema::getPrintingPolicy", NM="_ZN5clang4Sema17getPrintingPolicyERKNS_10ASTContextERKNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema17getPrintingPolicyERKNS_10ASTContextERKNS_12PreprocessorE")
//</editor-fold>
public static PrintingPolicy getPrintingPolicy(final /*const*/ ASTContext /*&*/ Context, 
                 final /*const*/ Preprocessor /*&*/ PP) {
  PrintingPolicy Policy = new PrintingPolicy(Context.getPrintingPolicy());
  // Our printing policy is copied over the ASTContext printing policy whenever
  // a diagnostic is emitted, so recompute it.
  Policy.Bool = Context.getLangOpts().Bool;
  if (!Policy.Bool) {
    {
      /*const*/ MacroInfo /*P*/ BoolMacro = PP.getMacroInfo$Const(Context.getBoolName());
      if ((BoolMacro != null)) {
        Policy.Bool = BoolMacro.isObjectLike()
           && BoolMacro.getNumTokens() == 1
           && BoolMacro.getReplacementToken(0).is(tok.TokenKind.kw__Bool);
      }
    }
  }
  
  return Policy;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTranslationUnitScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 69,
 FQN="clang::Sema::ActOnTranslationUnitScope", NM="_ZN5clang4Sema25ActOnTranslationUnitScopeEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema25ActOnTranslationUnitScopeEPNS_5ScopeE")
//</editor-fold>
public final void ActOnTranslationUnitScope(Scope /*P*/ S) {
  $this().TUScope = S;
  $this().PushDeclContext(S, $this().Context.getTranslationUnitDecl());
}


//===----------------------------------------------------------------------===//
// Helper functions.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getFunctionLevelDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 920,
 FQN="clang::Sema::getFunctionLevelDeclContext", NM="_ZN5clang4Sema27getFunctionLevelDeclContextEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema27getFunctionLevelDeclContextEv")
//</editor-fold>
public final DeclContext /*P*/ getFunctionLevelDeclContext() {
  DeclContext /*P*/ DC = $this().CurContext;
  while (true) {
    if (isa_BlockDecl(DC) || isa_EnumDecl(DC) || isa_CapturedDecl(DC)) {
      DC = DC.getParent();
    } else if (isa_CXXMethodDecl(DC)
       && cast_CXXMethodDecl(DC).getOverloadedOperator() == OverloadedOperatorKind.OO_Call
       && cast_CXXRecordDecl(DC.getParent()).isLambda()) {
      DC = DC.getParent().getParent();
    } else {
      break;
    }
  }
  
  return DC;
}


/// getCurFunctionDecl - If inside of a function body, this returns a pointer
/// to the function decl for the function being parsed.  If we're currently
/// in a 'block', this returns the containing context.

/// getCurFunctionDecl - If inside of a function body, this returns a pointer
/// to the function decl for the function being parsed.  If we're currently
/// in a 'block', this returns the containing context.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurFunctionDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 940,
 FQN="clang::Sema::getCurFunctionDecl", NM="_ZN5clang4Sema18getCurFunctionDeclEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema18getCurFunctionDeclEv")
//</editor-fold>
public final FunctionDecl /*P*/ getCurFunctionDecl() {
  DeclContext /*P*/ DC = $this().getFunctionLevelDeclContext();
  return dyn_cast_FunctionDecl(DC);
}


/// getCurMethodDecl - If inside of a method body, this returns a pointer to
/// the method decl for the method being parsed.  If we're currently
/// in a 'block', this returns the containing context.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurMethodDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 945,
 FQN="clang::Sema::getCurMethodDecl", NM="_ZN5clang4Sema16getCurMethodDeclEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema16getCurMethodDeclEv")
//</editor-fold>
public final ObjCMethodDecl /*P*/ getCurMethodDecl() {
  DeclContext /*P*/ DC = $this().getFunctionLevelDeclContext();
  while (isa_RecordDecl(DC)) {
    DC = DC.getParent();
  }
  return dyn_cast_ObjCMethodDecl(DC);
}


/// getCurFunctionOrMethodDecl - Return the Decl for the current ObjC method
/// or C function we're in, otherwise return null.  If we're currently
/// in a 'block', this returns the containing context.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurFunctionOrMethodDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 952,
 FQN="clang::Sema::getCurFunctionOrMethodDecl", NM="_ZN5clang4Sema26getCurFunctionOrMethodDeclEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema26getCurFunctionOrMethodDeclEv")
//</editor-fold>
public final NamedDecl /*P*/ getCurFunctionOrMethodDecl() {
  DeclContext /*P*/ DC = $this().getFunctionLevelDeclContext();
  if (isa_ObjCMethodDecl(DC) || isa_FunctionDecl(DC)) {
    return cast_NamedDecl(DC);
  }
  return null;
}


/// \brief Warn if we're implicitly casting from a _Nullable pointer type to a
/// _Nonnull one.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::diagnoseNullableToNonnullConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 351,
 FQN="clang::Sema::diagnoseNullableToNonnullConversion", NM="_ZN5clang4Sema35diagnoseNullableToNonnullConversionENS_8QualTypeES1_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema35diagnoseNullableToNonnullConversionENS_8QualTypeES1_NS_14SourceLocationE")
//</editor-fold>
public final void diagnoseNullableToNonnullConversion(QualType DstType, 
                                   QualType SrcType, 
                                   SourceLocation Loc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Optional<NullabilityKind> ExprNullability = SrcType.$arrow().getNullability($this().Context);
    if (!ExprNullability.$bool() || ExprNullability.$star() != NullabilityKind.Nullable) {
      return;
    }
    
    Optional<NullabilityKind> TypeNullability = DstType.$arrow().getNullability($this().Context);
    if (!TypeNullability.$bool() || TypeNullability.$star() != NullabilityKind.NonNull) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_nullability_lost)), SrcType), DstType));
  } finally {
    $c$.$destroy();
  }
}


/// makeUnavailableInSystemHeader - There is an error in the current
/// context.  If we're still in a system header, and we can plausibly
/// make the relevant declaration unavailable instead of erroring, do
/// so and return true.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::makeUnavailableInSystemHeader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 296,
 FQN="clang::Sema::makeUnavailableInSystemHeader", NM="_ZN5clang4Sema29makeUnavailableInSystemHeaderENS_14SourceLocationENS_15UnavailableAttr14ImplicitReasonE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema29makeUnavailableInSystemHeaderENS_14SourceLocationENS_15UnavailableAttr14ImplicitReasonE")
//</editor-fold>
public final boolean makeUnavailableInSystemHeader(SourceLocation loc, 
                             UnavailableAttr.ImplicitReason reason) {
  // If we're not in a function, it's an error.
  FunctionDecl /*P*/ fn = dyn_cast_FunctionDecl($this().CurContext);
  if (!(fn != null)) {
    return false;
  }
  
  // If we're in template instantiation, it's an error.
  if (!$this().ActiveTemplateInstantiations.empty()) {
    return false;
  }
  
  // If that function's not in a system header, it's an error.
  if (!$this().Context.getSourceManager().isInSystemHeader(/*NO_COPY*/loc)) {
    return false;
  }
  
  // If the function is already unavailable, it's not an error.
  if (fn.hasAttr(UnavailableAttr.class)) {
    return true;
  }
  
  fn.addAttr(UnavailableAttr.CreateImplicit($this().Context, new StringRef(/*KEEP_STR*/$EMPTY), reason, new SourceRange(/*NO_COPY*/loc)));
  return true;
}


/// \brief Try to recover by turning the given expression into a
/// call.  Returns true if recovery was attempted or an error was
/// emitted; this may also leave the ExprResult invalid.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::tryToRecoverWithCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1452,
 FQN="clang::Sema::tryToRecoverWithCall", NM="_ZN5clang4Sema20tryToRecoverWithCallERNS_12ActionResultIPNS_4ExprELb1EEERKNS_17PartialDiagnosticEbPFbNS_8QualTypeEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema20tryToRecoverWithCallERNS_12ActionResultIPNS_4ExprELb1EEERKNS_17PartialDiagnosticEbPFbNS_8QualTypeEE")
//</editor-fold>
public final boolean tryToRecoverWithCall(final ActionResultTTrue<Expr /*P*/ > /*&*/ E, final /*const*/ PartialDiagnostic /*&*/ PD) {
  return tryToRecoverWithCall(E, PD, 
                    false, 
                    (BoolPredicate<QualType>)null);
}
public final boolean tryToRecoverWithCall(final ActionResultTTrue<Expr /*P*/ > /*&*/ E, final /*const*/ PartialDiagnostic /*&*/ PD, 
                    boolean ForceComplain/*= false*/) {
  return tryToRecoverWithCall(E, PD, 
                    ForceComplain, 
                    (BoolPredicate<QualType>)null);
}
public final boolean tryToRecoverWithCall(final ActionResultTTrue<Expr /*P*/ > /*&*/ E, final /*const*/ PartialDiagnostic /*&*/ PD, 
                    boolean ForceComplain/*= false*/, 
                    BoolPredicate<QualType> IsPlausibleResult/*= null*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SourceLocation Loc = E.get().getExprLoc();
    SourceRange Range = E.get().getSourceRange();
    
    QualType ZeroArgCallTy/*J*/= new QualType();
    UnresolvedSet Overloads/*J*/= new UnresolvedSet(4);
    if ($this().tryExprAsCall($Deref(E.get()), ZeroArgCallTy, Overloads)
       && !ZeroArgCallTy.isNull()
       && (!(IsPlausibleResult != null) || IsPlausibleResult.$call(new QualType(ZeroArgCallTy)))) {
      // At this point, we know E is potentially callable with 0
      // arguments and that it returns something of a reasonable type,
      // so we can emit a fixit and carry on pretending that E was
      // actually a CallExpr.
      SourceLocation ParenInsertionLoc = $this().getLocForEndOfToken(Range.getEnd());
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), PD)), 
                  /*zero-arg*/ 1), Range), 
          (IsCallableWithAppend(E.get()) ? FixItHint.CreateInsertion(/*NO_COPY*/ParenInsertionLoc, new StringRef(/*KEEP_STR*/$LPAREN_RPAREN)) : new FixItHint())));
      notePlausibleOverloads(/*Deref*/$this(), new SourceLocation(Loc), Overloads, IsPlausibleResult);
      
      // FIXME: Try this before emitting the fixit, and suppress diagnostics
      // while doing so.
      E.$assignMove($this().ActOnCallExpr((Scope /*P*/ )null, E.get(), Range.getEnd(), new MutableArrayRef<Expr /*P*/ >(None, true), 
              Range.getEnd().getLocWithOffset(1)));
      return true;
    }
    if (!ForceComplain) {
      return false;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), PD)), /*not zero-arg*/ 0), Range));
    notePlausibleOverloads(/*Deref*/$this(), new SourceLocation(Loc), Overloads, IsPlausibleResult);
    E.$assignMove(ExprError());
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Figure out if an expression could be turned into a call.

/// \brief Figure out if an expression could be turned into a call.
///
/// Use this when trying to recover from an error where the programmer may have
/// written just the name of a function instead of actually calling it.
///
/// \param E - The expression to examine.
/// \param ZeroArgCallReturnTy - If the expression can be turned into a call
///  with no arguments, this parameter is set to the type returned by such a
///  call; otherwise, it is set to an empty QualType.
/// \param OverloadSet - If the expression is an overloaded function
///  name, this parameter is populated with the decls of the various overloads.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::tryExprAsCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1297,
 FQN="clang::Sema::tryExprAsCall", NM="_ZN5clang4Sema13tryExprAsCallERNS_4ExprERNS_8QualTypeERNS_17UnresolvedSetImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema13tryExprAsCallERNS_4ExprERNS_8QualTypeERNS_17UnresolvedSetImplE")
//</editor-fold>
public final boolean tryExprAsCall(final Expr /*&*/ E, final QualType /*&*/ ZeroArgCallReturnTy, 
             final UnresolvedSetImpl /*&*/ OverloadSet) {
  ZeroArgCallReturnTy.$assignMove(new QualType());
  OverloadSet.clear();
  
  /*const*/ OverloadExpr /*P*/ Overloads = null;
  boolean IsMemExpr = false;
  if ($eq_QualType$C(E.getType(), $this().Context.OverloadTy.$QualType())) {
    OverloadExpr.FindResult FR = OverloadExpr.find(((/*const_cast*/Expr /*P*/ )($AddrOf(E))));
    
    // Ignore overloads that are pointer-to-member constants.
    if (FR.HasFormOfMemberPointer) {
      return false;
    }
    
    Overloads = FR.Expression;
  } else if ($eq_QualType$C(E.getType(), $this().Context.BoundMemberTy.$QualType())) {
    Overloads = dyn_cast_UnresolvedMemberExpr(E.IgnoreParens());
    IsMemExpr = true;
  }
  
  boolean Ambiguous = false;
  if ((Overloads != null)) {
    for (UnresolvedSetIterator it = Overloads.decls_begin(), 
        DeclsEnd = Overloads.decls_end(); it.$noteq(DeclsEnd); it.$preInc()) {
      OverloadSet.addDecl(it.$star());
      
      // Check whether the function is a non-template, non-member which takes no
      // arguments.
      if (IsMemExpr) {
        continue;
      }
      {
        /*const*/ FunctionDecl /*P*/ OverloadDecl = dyn_cast_FunctionDecl((it.$star()).getUnderlyingDecl());
        if ((OverloadDecl != null)) {
          if (OverloadDecl.getMinRequiredArguments() == 0) {
            if (!ZeroArgCallReturnTy.isNull() && !Ambiguous) {
              ZeroArgCallReturnTy.$assignMove(new QualType());
              Ambiguous = true;
            } else {
              ZeroArgCallReturnTy.$assignMove(OverloadDecl.getReturnType());
            }
          }
        }
      }
    }
    
    // If it's not a member, use better machinery to try to resolve the call
    if (!IsMemExpr) {
      return !ZeroArgCallReturnTy.isNull();
    }
  }
  
  // Attempt to call the member with no arguments - this will correctly handle
  // member templates with defaults/deduction of template arguments, overloads
  // with default arguments, etc.
  if (IsMemExpr && !E.isTypeDependent()) {
    boolean Suppress = $this().getDiagnostics().getSuppressAllDiagnostics();
    $this().getDiagnostics().setSuppressAllDiagnostics(true);
    ActionResultTTrue<Expr /*P*/ > R = $this().BuildCallToMemberFunction((Scope /*P*/ )null, $AddrOf(E), new SourceLocation(), 
        new MutableArrayRef<Expr /*P*/ >(None, true), new SourceLocation());
    $this().getDiagnostics().setSuppressAllDiagnostics(Suppress);
    if (R.isUsable()) {
      ZeroArgCallReturnTy.$assignMove(R.get().getType());
      return true;
    }
    return false;
  }
  {
    
    /*const*/ DeclRefExpr /*P*/ DeclRef = dyn_cast_DeclRefExpr(E.IgnoreParens());
    if ((DeclRef != null)) {
      {
        /*const*/ FunctionDecl /*P*/ Fun = dyn_cast_FunctionDecl(DeclRef.getDecl$Const());
        if ((Fun != null)) {
          if (Fun.getMinRequiredArguments() == 0) {
            ZeroArgCallReturnTy.$assignMove(Fun.getReturnType());
          }
          return true;
        }
      }
    }
  }
  
  // We don't have an expression that's convenient to get a FunctionDecl from,
  // but we can at least check if the type is "function of 0 arguments".
  QualType ExprTy = E.getType();
  /*const*/ FunctionType /*P*/ FunTy = null;
  QualType PointeeTy = ExprTy.$arrow().getPointeeType();
  if (!PointeeTy.isNull()) {
    FunTy = PointeeTy.$arrow().getAs(FunctionType.class);
  }
  if (!(FunTy != null)) {
    FunTy = ExprTy.$arrow().getAs(FunctionType.class);
  }
  {
    
    /*const*/ FunctionProtoType /*P*/ FPT = dyn_cast_or_null_FunctionProtoType(FunTy);
    if ((FPT != null)) {
      if (FPT.getNumParams() == 0) {
        ZeroArgCallReturnTy.$assignMove(FunTy.getReturnType());
      }
      return true;
    }
  }
  return false;
}


/// ImpCastExprToType - If Expr is not of type 'Type', insert an implicit
/// cast.  If there is already an implicit cast, merge into the existing one.
/// If isLvalue, the result of the cast is an lvalue.

/// ImpCastExprToType - If Expr is not of type 'Type', insert an implicit cast.
/// If there is already an implicit cast, merge into the existing one.
/// The result is of the given category.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ImpCastExprToType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 368,
 FQN="clang::Sema::ImpCastExprToType", NM="_ZN5clang4Sema17ImpCastExprToTypeEPNS_4ExprENS_8QualTypeENS_8CastKindENS_13ExprValueKindEPKN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEENS0_21CheckedConversionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema17ImpCastExprToTypeEPNS_4ExprENS_8QualTypeENS_8CastKindENS_13ExprValueKindEPKN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEENS0_21CheckedConversionKindE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ImpCastExprToType(Expr /*P*/ E, QualType Ty, 
                 CastKind Kind) {
  return ImpCastExprToType(E, Ty, 
                 Kind, ExprValueKind.VK_RValue, 
                 (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, 
                 CheckedConversionKind.CCK_ImplicitConversion);
}
public final ActionResultTTrue<Expr /*P*/ > ImpCastExprToType(Expr /*P*/ E, QualType Ty, 
                 CastKind Kind, ExprValueKind VK/*= VK_RValue*/) {
  return ImpCastExprToType(E, Ty, 
                 Kind, VK, 
                 (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, 
                 CheckedConversionKind.CCK_ImplicitConversion);
}
public final ActionResultTTrue<Expr /*P*/ > ImpCastExprToType(Expr /*P*/ E, QualType Ty, 
                 CastKind Kind, ExprValueKind VK/*= VK_RValue*/, 
                 /*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/ BasePath/*= null*/) {
  return ImpCastExprToType(E, Ty, 
                 Kind, VK, 
                 BasePath, 
                 CheckedConversionKind.CCK_ImplicitConversion);
}
public final ActionResultTTrue<Expr /*P*/ > ImpCastExprToType(Expr /*P*/ E, QualType Ty, 
                 CastKind Kind, ExprValueKind VK/*= VK_RValue*/, 
                 /*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/ BasePath/*= null*/, 
                 CheckedConversionKind CCK/*= CCK_ImplicitConversion*/) {
  if (VK == ExprValueKind.VK_RValue && !E.isRValue()) {
    switch (Kind) {
     default:
      throw new llvm_unreachable("can't implicitly cast lvalue to rvalue with this cast kind");
     case CK_LValueToRValue:
     case CK_ArrayToPointerDecay:
     case CK_FunctionToPointerDecay:
     case CK_ToVoid:
      break;
    }
  }
  assert ((VK == ExprValueKind.VK_RValue || !E.isRValue())) : "can't cast rvalue to lvalue";
  
  $this().diagnoseNullableToNonnullConversion(new QualType(Ty), E.getType(), E.getLocStart());
  
  QualType ExprTy = $this().Context.getCanonicalType(E.getType()).$QualType();
  QualType TypeTy = $this().Context.getCanonicalType(new QualType(Ty)).$QualType();
  if ($eq_QualType$C(ExprTy, TypeTy)) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  {
    
    ImplicitCastExpr /*P*/ ImpCast = dyn_cast_ImplicitCastExpr(E);
    if ((ImpCast != null)) {
      if (ImpCast.getCastKind() == Kind && (!(BasePath != null) || BasePath.empty())) {
        ImpCast.setType(new QualType(Ty));
        ImpCast.setValueKind(VK);
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ImplicitCastExpr.Create($this().Context, new QualType(Ty), Kind, E, BasePath, VK));
}


/// ScalarTypeToBooleanCastKind - Returns the cast kind corresponding
/// to the conversion from scalar type ScalarTy to the Boolean type.

/// ScalarTypeToBooleanCastKind - Returns the cast kind corresponding
/// to the conversion from scalar type ScalarTy to the Boolean type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ScalarTypeToBooleanCastKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 409,
 FQN="clang::Sema::ScalarTypeToBooleanCastKind", NM="_ZN5clang4Sema27ScalarTypeToBooleanCastKindENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4Sema27ScalarTypeToBooleanCastKindENS_8QualTypeE")
//</editor-fold>
public static CastKind ScalarTypeToBooleanCastKind(QualType ScalarTy) {
  switch (ScalarTy.$arrow().getScalarTypeKind()) {
   case STK_Bool:
    return CastKind.CK_NoOp;
   case STK_CPointer:
    return CastKind.CK_PointerToBoolean;
   case STK_BlockPointer:
    return CastKind.CK_PointerToBoolean;
   case STK_ObjCObjectPointer:
    return CastKind.CK_PointerToBoolean;
   case STK_MemberPointer:
    return CastKind.CK_MemberPointerToBoolean;
   case STK_Integral:
    return CastKind.CK_IntegralToBoolean;
   case STK_Floating:
    return CastKind.CK_FloatingToBoolean;
   case STK_IntegralComplex:
    return CastKind.CK_IntegralComplexToBoolean;
   case STK_FloatingComplex:
    return CastKind.CK_FloatingComplexToBoolean;
  }
  return CK_Invalid;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getSuperIdentifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1490,
 FQN="clang::Sema::getSuperIdentifier", NM="_ZNK5clang4Sema18getSuperIdentifierEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema18getSuperIdentifierEv")
//</editor-fold>
public final IdentifierInfo /*P*/ getSuperIdentifier() /*const*/ {
  if (!($this().Ident_super != null)) {
    $this().Ident_super = $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"super")));
  }
  return $this().Ident_super;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getFloat128Identifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp", line = 1496,
 FQN="clang::Sema::getFloat128Identifier", NM="_ZNK5clang4Sema21getFloat128IdentifierEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang4Sema21getFloat128IdentifierEv")
//</editor-fold>
public final IdentifierInfo /*P*/ getFloat128Identifier() /*const*/ {
  if (!($this().Ident___float128 != null)) {
    $this().Ident___float128 = $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/$__float128)));
  }
  return $this().Ident___float128;
}

} // END OF class Sema_Sema
