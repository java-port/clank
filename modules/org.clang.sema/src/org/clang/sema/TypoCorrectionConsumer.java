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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import java.util.Iterator;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clank.java.stdimpl.aliases.*;
import static org.clang.sema.impl.SemaLookupStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 103,
 FQN="clang::TypoCorrectionConsumer", NM="_ZN5clang22TypoCorrectionConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumerE")
//</editor-fold>
public class TypoCorrectionConsumer extends /*public*/ VisibleDeclConsumer implements Destructors.ClassWithDestructor {
  /*typedef SmallVector<TypoCorrection, 1> TypoResultList*/
//  public final class TypoResultList extends SmallVector<TypoCorrection>{ };
  /*typedef llvm::StringMap<TypoResultList> TypoResultsMap*/
//  public final class TypoResultsMap extends StringMap<SmallVector<TypoCorrection>>{ };
  /*typedef std::map<unsigned int, TypoResultsMap> TypoEditDistanceMap*/
//  public final class TypoEditDistanceMap extends std.mapUIntType<StringMap<SmallVector<TypoCorrection>>>{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::TypoCorrectionConsumer">
  @Converted(kind = Converted.Kind.MANUAL/*fixed default values*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 109,
   FQN="clang::TypoCorrectionConsumer::TypoCorrectionConsumer", NM="_ZN5clang22TypoCorrectionConsumerC1ERNS_4SemaERKNS_19DeclarationNameInfoENS1_14LookupNameKindEPNS_5ScopeEPNS_12CXXScopeSpecESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISC_EEPNS_11DeclContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumerC1ERNS_4SemaERKNS_19DeclarationNameInfoENS1_14LookupNameKindEPNS_5ScopeEPNS_12CXXScopeSpecESt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteISC_EEPNS_11DeclContextEb")
  //</editor-fold>
  public TypoCorrectionConsumer(final Sema /*&*/ SemaRef, 
      final /*const*/ DeclarationNameInfo /*&*/ TypoName, 
      Sema.LookupNameKind LookupKind, 
      Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
      std.unique_ptr<CorrectionCandidateCallback> CCC, 
      DeclContext /*P*/ MemberContext, 
      boolean EnteringContext) {
    // : VisibleDeclConsumer(), Typo(TypoName.getName().getAsIdentifierInfo()), CorrectionResults(), ValidatedCorrections(), CurrentTCIndex(0), SavedTCIndex(0), SemaRef(SemaRef), S(S), SS(SS ? $c$.track(llvm::make_unique<CXXScopeSpec>(*SS)) : $c$.track(null)), CorrectionValidator(std::move(CCC)), MemberContext(MemberContext), Result(SemaRef, TypoName, LookupKind), Namespaces(SemaRef.Context, SemaRef.CurContext, SS), QualifiedResults(), EnteringContext(EnteringContext), SearchNamespaces(false) 
    //START JInit
    super();
    this.Typo = TypoName.getName().getAsIdentifierInfo();
    this.CorrectionResults = new std.mapUIntType<StringMap<SmallVector<TypoCorrection>>>(new StringMap<SmallVector<TypoCorrection>>(new SmallVector<>(1, new TypoCorrection())));
    this.ValidatedCorrections = new SmallVector<TypoCorrection>(4, new TypoCorrection());
    this.CurrentTCIndex = 0;
    this.SavedTCIndex = 0;
    this./*&*/SemaRef=/*&*/SemaRef;
    this.S = S;
    this.SS = (SS != null) ? llvm.make_unique(new CXXScopeSpec($Deref(SS))) : new unique_ptr<CXXScopeSpec>(JD$NullPtr.INSTANCE, null);
    this.CorrectionValidator = new std.unique_ptr<CorrectionCandidateCallback>(JD$Move.INSTANCE, std.move(CCC));
    this.MemberContext = MemberContext;
    this.Result = new LookupResult(SemaRef, TypoName, LookupKind);
    this.Namespaces = new NamespaceSpecifierSet(SemaRef.Context, SemaRef.CurContext, SS);
    this.QualifiedResults = new SmallVector<TypoCorrection>(2, new TypoCorrection());
    this.EnteringContext = EnteringContext;
    this.SearchNamespaces = false;
    //END JInit
    Result.suppressDiagnostics();
    // Arrange for ValidatedCorrections[0] to always be an empty correction.
    ValidatedCorrections.push_back_T$RR(new TypoCorrection());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::includeHiddenDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 128,
   FQN="clang::TypoCorrectionConsumer::includeHiddenDecls", NM="_ZNK5clang22TypoCorrectionConsumer18includeHiddenDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZNK5clang22TypoCorrectionConsumer18includeHiddenDeclsEv")
  //</editor-fold>
  @Override public boolean includeHiddenDecls() /*const*//* override*/ {
    return true;
  }

  
  // Methods for adding potential corrections to the consumer.
  
  // Methods for adding potential corrections to the consumer.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::FoundDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3854,
   FQN="clang::TypoCorrectionConsumer::FoundDecl", NM="_ZN5clang22TypoCorrectionConsumer9FoundDeclEPNS_9NamedDeclES2_PNS_11DeclContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer9FoundDeclEPNS_9NamedDeclES2_PNS_11DeclContextEb")
  //</editor-fold>
  @Override public void FoundDecl(NamedDecl /*P*/ ND, NamedDecl /*P*/ Hiding, 
           DeclContext /*P*/ Ctx, boolean InBaseClass)/* override*/ {
    // Don't consider hidden names for typo correction.
    if ((Hiding != null)) {
      return;
    }
    
    // Only consider entities with identifiers for names, ignoring
    // special names (constructors, overloaded operators, selectors,
    // etc.).
    IdentifierInfo /*P*/ Name = ND.getIdentifier();
    if (!(Name != null)) {
      return;
    }
    
    // Only consider visible declarations and declarations from modules with
    // names that exactly match.
    if (!LookupResult.isVisible(SemaRef, ND) && Name != Typo
       && !(findAcceptableDecl(SemaRef, ND) != null)) {
      return;
    }
    
    FoundName(Name.getName());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::FoundName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3876,
   FQN="clang::TypoCorrectionConsumer::FoundName", NM="_ZN5clang22TypoCorrectionConsumer9FoundNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer9FoundNameEN4llvm9StringRefE")
  //</editor-fold>
  public void FoundName(StringRef Name) {
    // Compute the edit distance between the typo and the name of this
    // entity, and add the identifier to the list of results.
    addName(new StringRef(Name), (NamedDecl /*P*/ )null);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::addKeywordResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3882,
   FQN="clang::TypoCorrectionConsumer::addKeywordResult", NM="_ZN5clang22TypoCorrectionConsumer16addKeywordResultEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer16addKeywordResultEN4llvm9StringRefE")
  //</editor-fold>
  public void addKeywordResult(StringRef Keyword) {
    // Compute the edit distance between the typo and this keyword,
    // and add the keyword to the list of results.
    addName(new StringRef(Keyword), (NamedDecl /*P*/ )null, (NestedNameSpecifier /*P*/ )null, true);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::addCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3911,
   FQN="clang::TypoCorrectionConsumer::addCorrection", NM="_ZN5clang22TypoCorrectionConsumer13addCorrectionENS_14TypoCorrectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer13addCorrectionENS_14TypoCorrectionE")
  //</editor-fold>
  public void addCorrection(TypoCorrection Correction) {
    StringRef TypoStr = Typo.getName();
    StringRef Name = Correction.getCorrectionAsIdentifierInfo().getName();
    
    // For very short typos, ignore potential corrections that have a different
    // base identifier from the typo or which have a normalized edit distance
    // longer than the typo itself.
    if ($less_uint(TypoStr.size(), 3)
       && ($noteq_StringRef(/*NO_COPY*/Name, /*NO_COPY*/TypoStr) || $greater_uint(Correction.getEditDistance(true), TypoStr.size()))) {
      return;
    }
    
    // If the correction is resolved but is not viable, ignore it.
    if (Correction.isResolved()) {
      checkCorrectionVisibility(SemaRef, Correction);
      if (!Correction.$bool() || !isCandidateViable(CorrectionValidator.$star(), Correction)) {
        return;
      }
    }
    
    final SmallVector<TypoCorrection> /*&*/ CList = CorrectionResults.$at_T$RR(Correction.getEditDistance(false)).$at(/*NO_COPY*/Name);
    if (!CList.empty() && !CList.back().isResolved()) {
      CList.pop_back();
    }
    {
      NamedDecl /*P*/ NewND = Correction.getCorrectionDecl();
      if ((NewND != null)) {
        std.string CorrectionStr = Correction.getAsString(SemaRef.getLangOpts());
        for (type$ptr<TypoCorrection /*P*/ > RI = $tryClone(CList.begin()), /*P*/ RIEnd = $tryClone(CList.end());
             $noteq_ptr(RI, RIEnd); RI.$preInc()) {
          // If the Correction refers to a decl already in the result list,
          // replace the existing result if the string representation of Correction
          // comes before the current result alphabetically, then stop as there is
          // nothing more to be done to add Correction to the candidate set.
          if (RI./*->*/$star().getCorrectionDecl() == NewND) {
            if ($less_string$C(CorrectionStr, RI./*->*/$star().getAsString(SemaRef.getLangOpts()))) {
              RI.$star().$assign(Correction);
            }
            return;
          }
        }
      }
    }
    if (CList.empty() || Correction.isResolved()) {
      CList.push_back_T$C$R(Correction);
    }
    while ($greater_uint(CorrectionResults.size(), MaxTypoDistanceResultSets)) {
      CorrectionResults.erase(std.prev(CorrectionResults.end()));
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 137,
   FQN="clang::TypoCorrectionConsumer::empty", NM="_ZNK5clang22TypoCorrectionConsumer5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZNK5clang22TypoCorrectionConsumer5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return CorrectionResults.empty() && ValidatedCorrections.size() == 1;
  }

  
  /// \brief Return the list of TypoCorrections for the given identifier from
  /// the set of corrections that have the closest edit distance, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 143,
   FQN="clang::TypoCorrectionConsumer::operator[]", NM="_ZN5clang22TypoCorrectionConsumerixEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumerixEN4llvm9StringRefE")
  //</editor-fold>
  public SmallVector<TypoCorrection> /*&*/ $at(StringRef Name) {
    return CorrectionResults.begin().$arrow().second.$at(/*NO_COPY*/Name);
  }
  public SmallVector<TypoCorrection> /*&*/ $at(String Name) {
    return $at(new StringRef(Name));
  }

  
  /// \brief Return the edit distance of the corrections that have the
  /// closest/best edit distance from the original typop.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::getBestEditDistance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 149,
   FQN="clang::TypoCorrectionConsumer::getBestEditDistance", NM="_ZN5clang22TypoCorrectionConsumer19getBestEditDistanceEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer19getBestEditDistanceEb")
  //</editor-fold>
  public /*uint*/int getBestEditDistance(boolean Normalized) {
    if (CorrectionResults.empty()) {
      return (std.numeric_limitsUInt.max());
    }
    
    /*uint*/int BestED = CorrectionResults.begin().$arrow().first;
    return Normalized ? TypoCorrection.NormalizeEditDistance(BestED) : BestED;
  }

  
  /// \brief Set-up method to add to the consumer the set of namespaces to use
  /// in performing corrections to nested name specifiers. This method also
  /// implicitly adds all of the known classes in the current AST context to the
  /// to the consumer for correcting nested name specifiers.
  
  /// \brief Set-up method to add to the consumer the set of namespaces to use
  /// in performing corrections to nested name specifiers. This method also
  /// implicitly adds all of the known classes in the current AST context to the
  /// to the consumer for correcting nested name specifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::addNamespaces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3956,
   FQN="clang::TypoCorrectionConsumer::addNamespaces", NM="_ZN5clang22TypoCorrectionConsumer13addNamespacesERKN4llvm9MapVectorIPNS_13NamespaceDeclEbNS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorISt4pairIS4_bESaISE_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer13addNamespacesERKN4llvm9MapVectorIPNS_13NamespaceDeclEbNS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorISt4pairIS4_bESaISE_EEEE")
  //</editor-fold>
  public void addNamespaces(final /*const*/MapVectorPtrBool<NamespaceDecl /*P*/ > /*&*/ KnownNamespaces) {
    SearchNamespaces = true;
    
    for (std.pairTypeBool<NamespaceDecl /*P*/ > KNPair : KnownNamespaces)  {
      Namespaces.addNameSpecifier(KNPair.first);
    }
    
    boolean SSIsTemplate = false;
    {
      NestedNameSpecifier /*P*/ NNS = (SS.$bool() && SS.$arrow().isValid()) ? SS.$arrow().getScopeRep() : null;
      if ((NNS != null)) {
        {
          /*const*/ Type /*P*/ T = NNS.getAsType();
          if ((T != null)) {
            SSIsTemplate = T.getTypeClass() == Type.TypeClass.TemplateSpecialization;
          }
        }
      }
    }
    // Do not transform this into an iterator-based loop. The loop body can
    // trigger the creation of further types (through lazy deserialization) and
    // invalide iterators into this list.
    final /*const*/ SmallVectorImpl<Type /*P*/ > /*&*/ Types = SemaRef.getASTContext().getTypes();
    for (/*uint*/int I = 0; I != Types.size(); ++I) {
      /*const*/ Type /*P*/ TI = Types.$at$Const(I);
      {
        CXXRecordDecl /*P*/ CD = TI.getAsCXXRecordDecl();
        if ((CD != null)) {
          CD = CD.getCanonicalDecl();
          if (!CD.isDependentType() && !CD.isAnonymousStructOrUnion()
             && !CD.isUnion() && (CD.getIdentifier() != null)
             && (SSIsTemplate || !isa_ClassTemplateSpecializationDecl(CD))
             && (CD.isBeingDefined() || CD.isCompleteDefinition())) {
            Namespaces.addNameSpecifier(CD);
          }
        }
      }
    }
  }


  
  /// \brief Return the next typo correction that passes all internal filters
  /// and is deemed valid by the consumer's CorrectionCandidateCallback,
  /// starting with the corrections that have the closest edit distance. An
  /// empty TypoCorrection is returned once no more viable corrections remain
  /// in the consumer.
  
  /// \brief Return the next typo correction that passes all internal filters
  /// and is deemed valid by the consumer's CorrectionCandidateCallback,
  /// starting with the corrections that have the closest edit distance. An
  /// empty TypoCorrection is returned once no more viable corrections remain
  /// in the consumer.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::getNextCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3986,
   FQN="clang::TypoCorrectionConsumer::getNextCorrection", NM="_ZN5clang22TypoCorrectionConsumer17getNextCorrectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer17getNextCorrectionEv")
  //</editor-fold>
  public /*const*/ TypoCorrection /*&*/ getNextCorrection() {
    if ($less_uint(++CurrentTCIndex, ValidatedCorrections.size())) {
      return ValidatedCorrections.$at(CurrentTCIndex);
    }
    
    CurrentTCIndex = ValidatedCorrections.size();
    while (!CorrectionResults.empty()) {
      TypoCorrection TC = null;
      try {
        std.mapUIntType.iterator<StringMap<SmallVector<TypoCorrection>>> DI = CorrectionResults.begin();
        if (DI.$arrow().second.empty()) {
          CorrectionResults.erase(new std.mapUIntType.iterator<StringMap<SmallVector<TypoCorrection>>>(DI));
          continue;
        }
        
        StringMapIterator<SmallVector<TypoCorrection> > RI = DI.$arrow().second.begin();
        if (RI.$arrow().second.empty()) {
          DI.$arrow().second.erase(/*NO_COPY*/RI);
          performQualifiedLookups();
          continue;
        }
        
        TC = RI.$arrow().second.pop_back_val();
        if (TC.isResolved() || TC.requiresImport() || resolveCorrection(TC)) {
          ValidatedCorrections.push_back_T$C$R(TC);
          return ValidatedCorrections.$at(CurrentTCIndex);
        }
      } finally {
        if (TC != null) { TC.$destroy(); }
      }
    }
    return ValidatedCorrections.$at(0); // The empty correction.
  }


  
  /// \brief Get the last correction returned by getNextCorrection().
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::getCurrentCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 172,
   FQN="clang::TypoCorrectionConsumer::getCurrentCorrection", NM="_ZN5clang22TypoCorrectionConsumer20getCurrentCorrectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer20getCurrentCorrectionEv")
  //</editor-fold>
  public /*const*/ TypoCorrection /*&*/ getCurrentCorrection() {
    return $less_uint(CurrentTCIndex, ValidatedCorrections.size()) ? ValidatedCorrections.$at(CurrentTCIndex) : ValidatedCorrections.$at(0); // The empty correction.
  }

  
  /// \brief Return the next typo correction like getNextCorrection, but keep
  /// the internal state pointed to the current correction (i.e. the next time
  /// getNextCorrection is called, it will return the same correction returned
  /// by peekNextcorrection).
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::peekNextCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 182,
   FQN="clang::TypoCorrectionConsumer::peekNextCorrection", NM="_ZN5clang22TypoCorrectionConsumer18peekNextCorrectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer18peekNextCorrectionEv")
  //</editor-fold>
  public /*const*/ TypoCorrection /*&*/ peekNextCorrection() {
    /*size_t*/int Current = CurrentTCIndex;
    final /*const*/ TypoCorrection /*&*/ TC = getNextCorrection();
    CurrentTCIndex = Current;
    return TC;
  }

  
  /// \brief Reset the consumer's position in the stream of viable corrections
  /// (i.e. getNextCorrection() will return each of the previously returned
  /// corrections in order before returning any new corrections).
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::resetCorrectionStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 192,
   FQN="clang::TypoCorrectionConsumer::resetCorrectionStream", NM="_ZN5clang22TypoCorrectionConsumer21resetCorrectionStreamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer21resetCorrectionStreamEv")
  //</editor-fold>
  public void resetCorrectionStream() {
    CurrentTCIndex = 0;
  }

  
  /// \brief Return whether the end of the stream of corrections has been
  /// reached.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::finished">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 198,
   FQN="clang::TypoCorrectionConsumer::finished", NM="_ZN5clang22TypoCorrectionConsumer8finishedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer8finishedEv")
  //</editor-fold>
  public boolean finished() {
    return CorrectionResults.empty()
       && $greatereq_uint(CurrentTCIndex, ValidatedCorrections.size());
  }

  
  /// \brief Save the current position in the correction stream (overwriting any
  /// previously saved position).
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::saveCurrentPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 205,
   FQN="clang::TypoCorrectionConsumer::saveCurrentPosition", NM="_ZN5clang22TypoCorrectionConsumer19saveCurrentPositionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer19saveCurrentPositionEv")
  //</editor-fold>
  public void saveCurrentPosition() {
    SavedTCIndex = CurrentTCIndex;
  }

  
  /// \brief Restore the saved position in the correction stream.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::restoreSavedPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 210,
   FQN="clang::TypoCorrectionConsumer::restoreSavedPosition", NM="_ZN5clang22TypoCorrectionConsumer20restoreSavedPositionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer20restoreSavedPositionEv")
  //</editor-fold>
  public void restoreSavedPosition() {
    CurrentTCIndex = SavedTCIndex;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 214,
   FQN="clang::TypoCorrectionConsumer::getContext", NM="_ZNK5clang22TypoCorrectionConsumer10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZNK5clang22TypoCorrectionConsumer10getContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getContext() /*const*/ {
    return SemaRef.Context;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::getLookupResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 215,
   FQN="clang::TypoCorrectionConsumer::getLookupResult", NM="_ZNK5clang22TypoCorrectionConsumer15getLookupResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZNK5clang22TypoCorrectionConsumer15getLookupResultEv")
  //</editor-fold>
  public /*const*/ LookupResult /*&*/ getLookupResult() /*const*/ {
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::isAddressOfOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 217,
   FQN="clang::TypoCorrectionConsumer::isAddressOfOperand", NM="_ZNK5clang22TypoCorrectionConsumer18isAddressOfOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZNK5clang22TypoCorrectionConsumer18isAddressOfOperandEv")
  //</editor-fold>
  public boolean isAddressOfOperand() /*const*/ {
    return CorrectionValidator.$arrow().IsAddressOfOperand;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::getSS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 218,
   FQN="clang::TypoCorrectionConsumer::getSS", NM="_ZNK5clang22TypoCorrectionConsumer5getSSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZNK5clang22TypoCorrectionConsumer5getSSEv")
  //</editor-fold>
  public /*const*/ CXXScopeSpec /*P*/ getSS() /*const*/ {
    return SS.get();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::getScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 219,
   FQN="clang::TypoCorrectionConsumer::getScope", NM="_ZNK5clang22TypoCorrectionConsumer8getScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZNK5clang22TypoCorrectionConsumer8getScopeEv")
  //</editor-fold>
  public Scope /*P*/ getScope() /*const*/ {
    return S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::getCorrectionValidator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 220,
   FQN="clang::TypoCorrectionConsumer::getCorrectionValidator", NM="_ZNK5clang22TypoCorrectionConsumer22getCorrectionValidatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZNK5clang22TypoCorrectionConsumer22getCorrectionValidatorEv")
  //</editor-fold>
  public CorrectionCandidateCallback /*P*/ getCorrectionValidator() /*const*/ {
    return CorrectionValidator.get();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 225,
   FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSetE")
  //</editor-fold>
  private static class NamespaceSpecifierSet implements Destructors.ClassWithDestructor, Iterable<NamespaceSpecifierSet.SpecifierInfo> {
    //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::SpecifierInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 226,
     FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::SpecifierInfo", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet13SpecifierInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet13SpecifierInfoE")
    //</editor-fold>
    private static class/*struct*/ SpecifierInfo {
      public DeclContext /*P*/ DeclCtx;
      public NestedNameSpecifier /*P*/ NameSpecifier;
      public /*uint*/int EditDistance;
      //////////////////////////////////////////////////////////////
      // EXTRA MEMBERS: BEGIN

      public SpecifierInfo(DeclContext DeclCtx, NestedNameSpecifier NameSpecifier, int EditDistance) {
        this.DeclCtx = DeclCtx;
        this.NameSpecifier = NameSpecifier;
        this.EditDistance = EditDistance;
      }


      // EXTRA MEMBERS: END
      //////////////////////////////////////////////////////////////
      
      @Override public String toString() {
        return "" + "DeclCtx=" + "[DeclContext]" // NOI18N
                  + ", NameSpecifier=" + NameSpecifier // NOI18N
                  + ", EditDistance=" + EditDistance; // NOI18N
      }
    };
    
    /*typedef SmallVector<DeclContext *, 4> DeclContextList*/
//    public final class DeclContextList extends SmallVector<DeclContext /*P*/ >{ };
    /*typedef SmallVector<SpecifierInfo, 16> SpecifierInfoList*/
//    public final class SpecifierInfoList extends SmallVector<SpecifierInfo>{ };
    
    private final ASTContext /*&*/ Context;
    private SmallVector<DeclContext /*P*/ > CurContextChain;
    private std.string CurNameSpecifier;
    private SmallVector</*const*/ IdentifierInfo /*P*/ > CurContextIdentifiers;
    private SmallVector</*const*/ IdentifierInfo /*P*/ > CurNameSpecifierIdentifiers;
    
    private std.mapUIntType<SmallVector<SpecifierInfo>> DistanceMap;
    
    /// \brief Helper for building the list of DeclContexts between the current
    /// context and the top of the translation unit
    
    /// \brief Helper for building the list of DeclContexts between the current
    /// context and the top of the translation unit
    //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::buildContextChain">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4166,
     FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::buildContextChain", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet17buildContextChainEPNS_11DeclContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet17buildContextChainEPNS_11DeclContextE")
    //</editor-fold>
    private static SmallVector<DeclContext /*P*/ > buildContextChain(DeclContext /*P*/ Start) {
      assert ((Start != null)) : "Building a context chain from a null context";
      SmallVector<DeclContext /*P*/ > Chain/*J*/= new SmallVector<DeclContext /*P*/ >(4, (DeclContext /*P*/ )null);
      for (DeclContext /*P*/ DC = Start.getPrimaryContext(); DC != null;
           DC = DC.getLookupParent()) {
        NamespaceDecl /*P*/ ND = dyn_cast_or_null_NamespaceDecl(DC);
        if (!DC.isInlineNamespace() && !DC.isTransparentContext()
           && !((ND != null) && ND.isAnonymousNamespace())) {
          Chain.push_back(DC.getPrimaryContext());
        }
      }
      return Chain;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::buildNestedNameSpecifier">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4180,
     FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::buildNestedNameSpecifier", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet24buildNestedNameSpecifierERN4llvm11SmallVectorIPNS_11DeclContextELj4EEERPNS_19NestedNameSpecifierE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet24buildNestedNameSpecifierERN4llvm11SmallVectorIPNS_11DeclContextELj4EEERPNS_19NestedNameSpecifierE")
    //</editor-fold>
    private /*uint*/int buildNestedNameSpecifier(final SmallVector<DeclContext /*P*/ > /*&*/ DeclChain, final type$ptr<NestedNameSpecifier /*P*/ /*&*/> NNS) {
      /*uint*/int NumSpecifiers = 0;
      for (DeclContext /*P*/ C : llvm.reverse$NotHasRBegin(DeclChain)) {
        {
          NamespaceDecl /*P*/ ND = dyn_cast_or_null_NamespaceDecl(C);
          if ((ND != null)) {
            NNS.$set(NestedNameSpecifier.Create(Context, NNS.$star(), ND));
            ++NumSpecifiers;
          } else {
            RecordDecl /*P*/ RD = dyn_cast_or_null_RecordDecl(C);
            if ((RD != null)) {
              NNS.$set(NestedNameSpecifier.Create(Context, NNS.$star(), RD.isTemplateDecl(), 
                  RD.getTypeForDecl()));
              ++NumSpecifiers;
            }
          }
        }
      }
      return NumSpecifiers;
    }


  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::NamespaceSpecifierSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4142,
     FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::NamespaceSpecifierSet", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSetC1ERNS_10ASTContextEPNS_11DeclContextEPNS_12CXXScopeSpecE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSetC1ERNS_10ASTContextEPNS_11DeclContextEPNS_12CXXScopeSpecE")
    //</editor-fold>
    public NamespaceSpecifierSet(final ASTContext /*&*/ Context, DeclContext /*P*/ CurContext, CXXScopeSpec /*P*/ CurScopeSpec) {
      // : Context(Context), CurContextChain(buildContextChain(CurContext)), CurNameSpecifier(), CurContextIdentifiers(), CurNameSpecifierIdentifiers(), DistanceMap() 
      //START JInit
      this./*&*/Context=/*&*/Context;
      this.CurContextChain = buildContextChain(CurContext);
      this.CurNameSpecifier = new std.string();
      this.CurContextIdentifiers = new SmallVector</*const*/ IdentifierInfo /*P*/ >(4, (/*const*/ IdentifierInfo /*P*/ )null);
      this.CurNameSpecifierIdentifiers = new SmallVector</*const*/ IdentifierInfo /*P*/ >(4, (/*const*/ IdentifierInfo /*P*/ )null);
      this.DistanceMap = new std.mapUIntType<SmallVector<SpecifierInfo>>(new SmallVector<SpecifierInfo>(16));
      //END JInit
      {
        NestedNameSpecifier /*P*/ NNS = (CurScopeSpec != null) ? CurScopeSpec.getScopeRep() : null;
        if ((NNS != null)) {
          raw_string_ostream SpecifierOStream = null;
          try {
            SpecifierOStream/*J*/= new raw_string_ostream(CurNameSpecifier);
            NNS.print(SpecifierOStream, Context.getPrintingPolicy());
            
            getNestedNameSpecifierIdentifiers(NNS, CurNameSpecifierIdentifiers);
          } finally {
            if (SpecifierOStream != null) { SpecifierOStream.$destroy(); }
          }
        }
      }
      // Build the list of identifiers that would be used for an absolute
      // (from the global context) NestedNameSpecifier referring to the current
      // context.
      for (DeclContext /*P*/ C : llvm.reverse$NotHasRBegin(CurContextChain)) {
        {
          NamespaceDecl /*P*/ ND = dyn_cast_or_null_NamespaceDecl(C);
          if ((ND != null)) {
            CurContextIdentifiers.push_back(ND.getIdentifier());
          }
        }
      }
      
      // Add the global context as a NestedNameSpecifier
      SpecifierInfo SI = new SpecifierInfo(
        cast_DeclContext(Context.getTranslationUnitDecl()), 
        NestedNameSpecifier.GlobalSpecifier(Context), 1);
      DistanceMap.$at_T$RR(1).push_back(SI);
    }


    
    /// \brief Add the DeclContext (a namespace or record) to the set, computing
    /// the corresponding NestedNameSpecifier and its distance in the process.
    
    /// \brief Add the DeclContext (a namespace or record) to the set, computing
    /// the corresponding NestedNameSpecifier and its distance in the process.
    //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::addNameSpecifier">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4197,
     FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::addNameSpecifier", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet16addNameSpecifierEPNS_11DeclContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet16addNameSpecifierEPNS_11DeclContextE")
    //</editor-fold>
    public void addNameSpecifier(DeclContext /*P*/ Ctx) {
      type$ptr<NestedNameSpecifier /*P*/ > NNS = create_type$null$ptr(null);
      /*uint*/int NumSpecifiers = 0;
      SmallVector<DeclContext /*P*/ > NamespaceDeclChain/*J*/= buildContextChain(Ctx);
      SmallVector<DeclContext /*P*/ > FullNamespaceDeclChain/*J*/= new SmallVector<DeclContext /*P*/ >(NamespaceDeclChain);
      
      // Eliminate common elements from the two DeclContext chains.
      for (DeclContext /*P*/ C : llvm.reverse$NotHasRBegin(CurContextChain)) {
        if (NamespaceDeclChain.empty() || NamespaceDeclChain.back() != C) {
          break;
        }
        NamespaceDeclChain.pop_back();
      }
      
      // Build the NestedNameSpecifier from what is left of the NamespaceDeclChain
      NumSpecifiers = buildNestedNameSpecifier(NamespaceDeclChain, NNS);
      
      // Add an explicit leading '::' specifier if needed.
      if (NamespaceDeclChain.empty()) {
        // Rebuild the NestedNameSpecifier as a globally-qualified specifier.
        NNS.$set(NestedNameSpecifier.GlobalSpecifier(Context));
        NumSpecifiers
           = buildNestedNameSpecifier(FullNamespaceDeclChain, NNS);
      } else {
        NamedDecl /*P*/ ND = dyn_cast_or_null_NamedDecl(NamespaceDeclChain.back());
        if ((ND != null)) {
          IdentifierInfo /*P*/ Name = ND.getIdentifier();
          boolean SameNameSpecifier = false;
          if ($noteq_ptr(std.find(CurNameSpecifierIdentifiers.begin(), 
              CurNameSpecifierIdentifiers.end(), 
              Name, true), CurNameSpecifierIdentifiers.end())) {
            raw_string_ostream SpecifierOStream = null;
            try {
              std.string NewNameSpecifier/*J*/= new std.string();
              SpecifierOStream/*J*/= new raw_string_ostream(NewNameSpecifier);
              SmallVector</*const*/ IdentifierInfo /*P*/ > NewNameSpecifierIdentifiers/*J*/= new SmallVector</*const*/ IdentifierInfo /*P*/ >(4, (/*const*/ IdentifierInfo /*P*/ )null);
              getNestedNameSpecifierIdentifiers(NNS.$star(), NewNameSpecifierIdentifiers);
              NNS.$star().print(SpecifierOStream, Context.getPrintingPolicy());
              SpecifierOStream.flush();
              SameNameSpecifier = $eq_str$C(NewNameSpecifier, CurNameSpecifier);
            } finally {
              if (SpecifierOStream != null) { SpecifierOStream.$destroy(); }
            }
          }
          if (SameNameSpecifier
             || $noteq_ptr(std.find(CurContextIdentifiers.begin(), CurContextIdentifiers.end(), 
              Name, true), CurContextIdentifiers.end())) {
            // Rebuild the NestedNameSpecifier as a globally-qualified specifier.
            NNS.$set(NestedNameSpecifier.GlobalSpecifier(Context));
            NumSpecifiers
               = buildNestedNameSpecifier(FullNamespaceDeclChain, NNS);
          }
        }
      }
      
      // If the built NestedNameSpecifier would be replacing an existing
      // NestedNameSpecifier, use the number of component identifiers that
      // would need to be changed as the edit distance instead of the number
      // of components in the built NestedNameSpecifier.
      if ((NNS.$star() != null) && !CurNameSpecifierIdentifiers.empty()) {
        SmallVector</*const*/ IdentifierInfo /*P*/ > NewNameSpecifierIdentifiers/*J*/= new SmallVector</*const*/ IdentifierInfo /*P*/ >(4, (/*const*/ IdentifierInfo /*P*/ )null);
        getNestedNameSpecifierIdentifiers(NNS.$star(), NewNameSpecifierIdentifiers);
        NumSpecifiers = llvm.ComputeEditDistance(llvm.makeArrayRef(CurNameSpecifierIdentifiers), 
            llvm.makeArrayRef(NewNameSpecifierIdentifiers));
      }
      
      SpecifierInfo SI = new SpecifierInfo(Ctx, NNS.$star(), NumSpecifiers);
      DistanceMap.$at_T$C$R(NumSpecifiers).push_back(SI);
    }


    
    /// \brief Provides flat iteration over specifiers, sorted by distance.
    //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 259,
     FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::iterator", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet8iteratorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet8iteratorE")
    //</editor-fold>
    public static class iterator extends /*public*/ iterator_facade_base<iterator, std.forward_iterator_tag, SpecifierInfo, SpecifierInfo> /*JAVA: implements Native.NativeComparable<iterator>*/ {
      /// Always points to the last element in the distance map.
      private /*const*/ StdMapUIntType.iterator<SmallVector<SpecifierInfo>> OuterBack;
      /// Iterator on the distance map.
      private StdMapUIntType.iterator<SmallVector<SpecifierInfo>> Outer;
      /// Iterator on an element in the distance map.
      private type$ptr<SpecifierInfo> Inner;
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::iterator::iterator">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 270,
       FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::iterator::iterator", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet8iteratorC1ERS1_b",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet8iteratorC1ERS1_b")
      //</editor-fold>
      public iterator(final NamespaceSpecifierSet /*&*/ Set, boolean IsAtEnd) {
        // : iterator_facade_base<iterator, std::forward_iterator_tag, SpecifierInfo>(), OuterBack(std::prev(Set.DistanceMap.end())), Outer(Set.DistanceMap.begin()), Inner(!IsAtEnd ? Outer->second.begin() : OuterBack->second.end()) 
        //START JInit
        super();
        this.OuterBack = new StdMapUIntType.iterator<SmallVector<SpecifierInfo>>( std.prev(Set.DistanceMap.end()) );
        this.Outer =     new StdMapUIntType.iterator<SmallVector<SpecifierInfo>>(Set.DistanceMap.begin());
        this.Inner = $tryClone(!IsAtEnd ? Outer.$arrow().second.begin() : OuterBack.$arrow().second.end());
        
        //END JInit
        assert (!Set.DistanceMap.empty());
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::iterator::operator++">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 277,
       FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::iterator::operator++", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet8iteratorppEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet8iteratorppEv")
      //</editor-fold>
      public iterator /*&*/ $preInc() {
        Inner.$preInc();
        if ($eq_ptr(Inner, Outer.$arrow().second.end()) && Outer.$noteq(OuterBack)) {
          Outer.$preInc();
          Inner = $tryClone(Outer.$arrow().second.begin());
        }
        return /*Deref*/this;
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::iterator::operator*">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 286,
       FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::iterator::operator*", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet8iteratordeEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet8iteratordeEv")
      //</editor-fold>
      public SpecifierInfo /*&*/ $star() {
        return Inner.$star();
      }

      //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::iterator::operator==">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 287,
       FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::iterator::operator==", NM="_ZNK5clang22TypoCorrectionConsumer21NamespaceSpecifierSet8iteratoreqERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZNK5clang22TypoCorrectionConsumer21NamespaceSpecifierSet8iteratoreqERKS2_")
      //</editor-fold>
      public boolean $eq(final /*const*/ iterator /*&*/ RHS) /*const*/ {
        return $eq_ptr(Inner, RHS.Inner);
      }

      //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::iterator::iterator">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 259,
       FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::iterator::iterator", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet8iteratorC1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet8iteratorC1EOS2_")
      //</editor-fold>
      public /*inline*/ iterator(JD$Move _dparam, final iterator /*&&*/$Prm0) {
        // : iterator_facade_base<iterator, std::forward_iterator_tag, SpecifierInfo>(static_cast<iterator &&>()), OuterBack(static_cast<iterator &&>().OuterBack), Outer(static_cast<iterator &&>().Outer), Inner(static_cast<iterator &&>().Inner) 
        //START JInit
        super(JD$Move.INSTANCE, $Prm0);
        this.OuterBack = new StdMapUIntType.iterator<SmallVector<SpecifierInfo>>($Prm0.OuterBack);
        this.Outer = new StdMapUIntType.iterator<SmallVector<SpecifierInfo>>(JD$Move.INSTANCE, $Prm0.Outer);
        this.Inner = $tryClone($Prm0.Inner);
        //END JInit
      }

      public iterator(iterator $Prm0) {
        super();
        this.OuterBack = $tryClone($Prm0.OuterBack);
        this.Outer = $tryClone($Prm0.Outer);
        this.Inner = $tryClone($Prm0.Inner);
      }
      
      @Override public boolean $eq(Object RHS) { return this.$eq((iterator)RHS); }
      @Override public iterator clone() { return new iterator(this); }
      
      @Override public String toString() {
        return "" + "OuterBack=" + OuterBack // NOI18N
                  + ", Outer=" + Outer // NOI18N
                  + ", Inner=" + Inner // NOI18N
                  + super.toString(); // NOI18N
      }
    };
    
    //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::begin">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 290,
     FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::begin", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet5beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet5beginEv")
    //</editor-fold>
    public iterator begin() {
      return new iterator(/*Deref*/this, /*IsAtEnd=*/ false);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::end">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 291,
     FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::end", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet3endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSet3endEv")
    //</editor-fold>
    public iterator end() {
      return new iterator(/*Deref*/this, /*IsAtEnd=*/ true);
    }

    @Override
    public Iterator<SpecifierInfo> iterator() {
      return new JavaIterator<>(begin(), end());
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::~NamespaceSpecifierSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 225,
     FQN="clang::TypoCorrectionConsumer::NamespaceSpecifierSet::~NamespaceSpecifierSet", NM="_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSetD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumer21NamespaceSpecifierSetD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      DistanceMap.$destroy();
      CurNameSpecifierIdentifiers.$destroy();
      CurContextIdentifiers.$destroy();
      CurNameSpecifier.$destroy();
      CurContextChain.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Context=" + "[ASTContext]" // NOI18N
                + ", CurContextChain=" + "[SmallVector$DeclContext]" // NOI18N
                + ", CurNameSpecifier=" + CurNameSpecifier // NOI18N
                + ", CurContextIdentifiers=" + CurContextIdentifiers // NOI18N
                + ", CurNameSpecifierIdentifiers=" + CurNameSpecifierIdentifiers // NOI18N
                + ", DistanceMap=" + DistanceMap; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::addName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3888,
   FQN="clang::TypoCorrectionConsumer::addName", NM="_ZN5clang22TypoCorrectionConsumer7addNameEN4llvm9StringRefEPNS_9NamedDeclEPNS_19NestedNameSpecifierEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer7addNameEN4llvm9StringRefEPNS_9NamedDeclEPNS_19NestedNameSpecifierEb")
  //</editor-fold>
  private void addName(StringRef Name, NamedDecl /*P*/ ND) {
    addName(Name, ND, 
         (NestedNameSpecifier /*P*/ )null, false);
  }
  private void addName(StringRef Name, NamedDecl /*P*/ ND, 
         NestedNameSpecifier /*P*/ NNS/*= null*/) {
    addName(Name, ND, 
         NNS, false);
  }
  private void addName(StringRef Name, NamedDecl /*P*/ ND, 
         NestedNameSpecifier /*P*/ NNS/*= null*/, boolean isKeyword/*= false*/) {
    TypoCorrection TC = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Use a simple length-based heuristic to determine the minimum possible
      // edit distance. If the minimum isn't good enough, bail out early.
      StringRef TypoStr = Typo.getName();
      /*uint*/int MinED = abs((int)Name.size() - (int)TypoStr.size());
      if ((MinED != 0) && $less_uint($div_uint(TypoStr.size(), MinED), 3)) {
        return;
      }
      
      // Compute an upper bound on the allowable edit distance, so that the
      // edit-distance algorithm can short-circuit.
      /*uint*/int UpperBound = $div_uint((TypoStr.size() + 2), 3) + 1;
      /*uint*/int ED = TypoStr.edit_distance(/*NO_COPY*/Name, /*KEEP_BOOL*/true, UpperBound);
      if ($greatereq_uint(ED, UpperBound)) {
        return;
      }
      
      TC/*J*/= new TypoCorrection(new DeclarationName($AddrOf(SemaRef.Context.Idents.get(/*NO_COPY*/Name.data().$array(), Name.data().$index(), Name.size()))), ND, NNS, ED);
      if (isKeyword) {
        TC.makeKeyword();
      }
      TC.setCorrectionRange((CXXScopeSpec /*P*/ )null, Result.getLookupNameInfo());
      addCorrection($c$.track(new TypoCorrection(TC))); $c$.clean();
    } finally {
      if (TC != null) { TC.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// \brief Find any visible decls for the given typo correction candidate.
  /// If none are found, it to the set of candidates for which qualified lookups
  /// will be performed to find possible nested name specifier changes.
  
  /// \brief Find any visible decls for the given typo correction candidate.
  /// If none are found, it to the set of candidates for which qualified lookups
  /// will be performed to find possible nested name specifier changes.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::resolveCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4014,
   FQN="clang::TypoCorrectionConsumer::resolveCorrection", NM="_ZN5clang22TypoCorrectionConsumer17resolveCorrectionERNS_14TypoCorrectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer17resolveCorrectionERNS_14TypoCorrectionE")
  //</editor-fold>
  private boolean resolveCorrection(final TypoCorrection /*&*/ Candidate) {
    IdentifierInfo /*P*/ Name = Candidate.getCorrectionAsIdentifierInfo();
    DeclContext /*P*/ TempMemberContext = MemberContext;
    CXXScopeSpec /*P*/ TempSS = SS.get();
   retry_lookup:
   while (true) {
    LookupPotentialTypoResult(SemaRef, Result, Name, S, TempSS, TempMemberContext, 
        EnteringContext, 
        CorrectionValidator.$arrow().IsObjCIvarLookup, 
        Name == Typo && !Candidate.WillReplaceSpecifier());
    switch (Result.getResultKind()) {
     case NotFound:
     case NotFoundInCurrentInstantiation:
     case FoundUnresolvedValue:
      if ((TempSS != null)) {
        // Immediately retry the lookup without the given CXXScopeSpec
        TempSS = null;
        Candidate.WillReplaceSpecifier(true);
          continue retry_lookup;
      }
      if ((TempMemberContext != null)) {
        if (SS.$bool() && !(TempSS != null)) {
          TempSS = SS.get();
        }
        TempMemberContext = null;
          continue retry_lookup;
      }
      if (SearchNamespaces) {
        QualifiedResults.push_back_T$C$R(Candidate);
      }
      break;
     case Ambiguous:
      // We don't deal with ambiguities.
      break;
     case Found:
     case FoundOverloaded:
      // Store all of the Decls for overloaded symbols
      for (NamedDecl /*P*/ TRD : Result)  {
        Candidate.addCorrectionDecl(TRD);
      }
      checkCorrectionVisibility(SemaRef, Candidate);
      if (!isCandidateViable(CorrectionValidator.$star(), Candidate)) {
        if (SearchNamespaces) {
          QualifiedResults.push_back_T$C$R(Candidate);
        }
        break;
      }
      Candidate.setCorrectionRange(SS.get(), Result.getLookupNameInfo());
      return true;
    }
      break;
    }
    return false;
  }


  
  /// \brief Perform qualified lookups on the queued set of typo correction
  /// candidates and add the nested name specifier changes to each candidate if
  /// a lookup succeeds (at which point the candidate will be returned to the
  /// main pool of potential corrections).
  
  /// \brief Perform qualified lookups on the queued set of typo correction
  /// candidates and add the nested name specifier changes to each candidate if
  /// a lookup succeeds (at which point the candidate will be returned to the
  /// main pool of potential corrections).
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::performQualifiedLookups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4064,
   FQN="clang::TypoCorrectionConsumer::performQualifiedLookups", NM="_ZN5clang22TypoCorrectionConsumer23performQualifiedLookupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang22TypoCorrectionConsumer23performQualifiedLookupsEv")
  //</editor-fold>
  private void performQualifiedLookups() {
    /*uint*/int TypoLen = Typo.getName().size();
    for (final /*const*/ TypoCorrection /*&*/ QR : QualifiedResults) {
      for (final /*const*/ NamespaceSpecifierSet.SpecifierInfo /*&*/ NSI : Namespaces) {
        TypoCorrection TC = null;
        try {
          DeclContext /*P*/ Ctx = NSI.DeclCtx;
          /*const*/ Type /*P*/ NSType = NSI.NameSpecifier.getAsType();
          {
            
            // If the current NestedNameSpecifier refers to a class and the
            // current correction candidate is the name of that class, then skip
            // it as it is unlikely a qualified version of the class' constructor
            // is an appropriate correction.
            CXXRecordDecl /*P*/ NSDecl = (NSType != null) ? NSType.getAsCXXRecordDecl() : null;
            if ((NSDecl != null)) {
              if (NSDecl.getIdentifier() == QR.getCorrectionAsIdentifierInfo()) {
                continue;
              }
            }
          }
          
          TC/*J*/= new TypoCorrection(QR);
          TC.ClearCorrectionDecls();
          TC.setCorrectionSpecifier(NSI.NameSpecifier);
          TC.setQualifierDistance(NSI.EditDistance);
          TC.setCallbackDistance(0); // Reset the callback distance
          
          // If the current correction candidate and namespace combination are
          // too far away from the original typo based on the normalized edit
          // distance, then skip performing a qualified name lookup.
          /*uint*/int TmpED = TC.getEditDistance(true);
          if (QR.getCorrectionAsIdentifierInfo() != Typo && (TmpED != 0)
             && $less_uint($div_uint(TypoLen, TmpED), 3)) {
            continue;
          }
          
          Result.clear();
          Result.setLookupName(new DeclarationName(QR.getCorrectionAsIdentifierInfo()));
          if (!SemaRef.LookupQualifiedName(Result, Ctx)) {
            continue;
          }
          
          // Any corrections added below will be validated in subsequent
          // iterations of the main while() loop over the Consumer's contents.
          switch (Result.getResultKind()) {
           case Found:
           case FoundOverloaded:
            {
              if (SS.$bool() && SS.$arrow().isValid()) {
                raw_string_ostream OldOStream = null;
                try {
                  std.string NewQualified = TC.getAsString(SemaRef.getLangOpts());
                  std.string OldQualified/*J*/= new std.string();
                  OldOStream/*J*/= new raw_string_ostream(OldQualified);
                  SS.$arrow().getScopeRep().print(OldOStream, SemaRef.getPrintingPolicy());
                  OldOStream.$out(Typo.getName());
                  // If correction candidate would be an identical written qualified
                  // identifer, then the existing CXXScopeSpec probably included a
                  // typedef that didn't get accounted for properly.
                  if ($eq_str$C(OldOStream.str(), NewQualified)) {
                    break;
                  }
                } finally {
                  if (OldOStream != null) { OldOStream.$destroy(); }
                }
              }
              for (UnresolvedSetIterator TRD = Result.begin(), TRDEnd = Result.end();
                   TRD.$noteq(TRDEnd); TRD.$preInc()) {
                if (SemaRef.CheckMemberAccess(TC.getCorrectionRange().getBegin(), 
                    (NSType != null) ? NSType.getAsCXXRecordDecl() : (CXXRecordDecl /*P*/ )null, 
                    new DeclAccessPair(TRD.getPair())) == Sema.AccessResult.AR_accessible) {
                  TC.addCorrectionDecl(TRD.$star());
                }
              }
              if (TC.isResolved()) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  TC.setCorrectionRange(SS.get(), Result.getLookupNameInfo());
                  addCorrection($c$.track(new TypoCorrection(TC))); $c$.clean();
                } finally {
                  $c$.$destroy();
                }
              }
              break;
            }
           case NotFound:
           case NotFoundInCurrentInstantiation:
           case Ambiguous:
           case FoundUnresolvedValue:
            break;
          }
        } finally {
          if (TC != null) { TC.$destroy(); }
        }
      }
    }
    QualifiedResults.clear();
  }


  
  /// \brief The name written that is a typo in the source.
  private IdentifierInfo /*P*/ Typo;
  
  /// \brief The results found that have the smallest edit distance
  /// found (so far) with the typo name.
  ///
  /// The pointer value being set to the current DeclContext indicates
  /// whether there is a keyword with this name.
  private std.mapUIntType<StringMap<SmallVector<TypoCorrection>>> CorrectionResults;
  
  private SmallVector<TypoCorrection> ValidatedCorrections;
  private /*size_t*/int CurrentTCIndex;
  private /*size_t*/int SavedTCIndex;
  
  private final Sema /*&*/ SemaRef;
  private Scope /*P*/ S;
  private std.unique_ptr<CXXScopeSpec> SS;
  private std.unique_ptr<CorrectionCandidateCallback> CorrectionValidator;
  private DeclContext /*P*/ MemberContext;
  private LookupResult Result;
  private NamespaceSpecifierSet Namespaces;
  private SmallVector<TypoCorrection> QualifiedResults;
  private boolean EnteringContext;
  private boolean SearchNamespaces;
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrectionConsumer::~TypoCorrectionConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 103,
   FQN="clang::TypoCorrectionConsumer::~TypoCorrectionConsumer", NM="_ZN5clang22TypoCorrectionConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22TypoCorrectionConsumerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    QualifiedResults.$destroy();
    Namespaces.$destroy();
    Result.$destroy();
    CorrectionValidator.$destroy();
    SS.$destroy();
    ValidatedCorrections.$destroy();
    CorrectionResults.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Typo=" + Typo // NOI18N
              + ", CorrectionResults=" + CorrectionResults // NOI18N
              + ", ValidatedCorrections=" + ValidatedCorrections // NOI18N
              + ", CurrentTCIndex=" + CurrentTCIndex // NOI18N
              + ", SavedTCIndex=" + SavedTCIndex // NOI18N
              + ", SemaRef=" + "[Sema]" // NOI18N
              + ", S=" + S // NOI18N
              + ", SS=" + SS // NOI18N
              + ", CorrectionValidator=" + CorrectionValidator // NOI18N
              + ", MemberContext=" + "[DeclContext]" // NOI18N
              + ", Result=" + Result // NOI18N
              + ", Namespaces=" + Namespaces // NOI18N
              + ", QualifiedResults=" + QualifiedResults // NOI18N
              + ", EnteringContext=" + EnteringContext // NOI18N
              + ", SearchNamespaces=" + SearchNamespaces // NOI18N
              + super.toString(); // NOI18N
  }
}
