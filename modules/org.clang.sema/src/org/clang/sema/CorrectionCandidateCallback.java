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
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// @brief Base class for callback objects used by Sema::CorrectTypo to check
/// the validity of a potential typo correction.
//<editor-fold defaultstate="collapsed" desc="clang::CorrectionCandidateCallback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 252,
 FQN="clang::CorrectionCandidateCallback", NM="_ZN5clang27CorrectionCandidateCallbackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang27CorrectionCandidateCallbackE")
//</editor-fold>
public class CorrectionCandidateCallback implements Destructors.ClassWithDestructor {
/*public:*/
  public static /*const*//*uint*/int InvalidDistance = TypoCorrection.InvalidDistance;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CorrectionCandidateCallback::CorrectionCandidateCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 256,
   FQN="clang::CorrectionCandidateCallback::CorrectionCandidateCallback", NM="_ZN5clang27CorrectionCandidateCallbackC1EPNS_14IdentifierInfoEPNS_19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang27CorrectionCandidateCallbackC1EPNS_14IdentifierInfoEPNS_19NestedNameSpecifierE")
  //</editor-fold>
  public /*explicit*/ CorrectionCandidateCallback() {
    this((IdentifierInfo /*P*/ )null, 
      (NestedNameSpecifier /*P*/ )null);
  }
  public /*explicit*/ CorrectionCandidateCallback(IdentifierInfo /*P*/ Typo/*= null*/) {
    this(Typo, 
      (NestedNameSpecifier /*P*/ )null);
  }
  public /*explicit*/ CorrectionCandidateCallback(IdentifierInfo /*P*/ Typo/*= null*/, 
      NestedNameSpecifier /*P*/ TypoNNS/*= null*/) {
    // : WantTypeSpecifiers(true), WantExpressionKeywords(true), WantCXXNamedCasts(true), WantFunctionLikeCasts(true), WantRemainingKeywords(true), WantObjCSuper(false), IsObjCIvarLookup(false), IsAddressOfOperand(false), Typo(Typo), TypoNNS(TypoNNS) 
    //START JInit
    this.WantTypeSpecifiers = true;
    this.WantExpressionKeywords = true;
    this.WantCXXNamedCasts = true;
    this.WantFunctionLikeCasts = true;
    this.WantRemainingKeywords = true;
    this.WantObjCSuper = false;
    this.IsObjCIvarLookup = false;
    this.IsAddressOfOperand = false;
    this.Typo = Typo;
    this.TypoNNS = TypoNNS;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CorrectionCandidateCallback::~CorrectionCandidateCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 264,
   FQN="clang::CorrectionCandidateCallback::~CorrectionCandidateCallback", NM="_ZN5clang27CorrectionCandidateCallbackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang27CorrectionCandidateCallbackD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  /// \brief Simple predicate used by the default RankCandidate to
  /// determine whether to return an edit distance of 0 or InvalidDistance.
  /// This can be overrided by validators that only need to determine if a
  /// candidate is viable, without ranking potentially viable candidates.
  /// Only ValidateCandidate or RankCandidate need to be overriden by a
  /// callback wishing to check the viability of correction candidates.
  /// The default predicate always returns true if the candidate is not a type
  /// name or keyword, true for types if WantTypeSpecifiers is true, and true
  /// for keywords if WantTypeSpecifiers, WantExpressionKeywords,
  /// WantCXXNamedCasts, WantRemainingKeywords, or WantObjCSuper is true.
  //<editor-fold defaultstate="collapsed" desc="clang::CorrectionCandidateCallback::ValidateCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4834,
   FQN="clang::CorrectionCandidateCallback::ValidateCandidate", NM="_ZN5clang27CorrectionCandidateCallback17ValidateCandidateERKNS_14TypoCorrectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang27CorrectionCandidateCallback17ValidateCandidateERKNS_14TypoCorrectionE")
  //</editor-fold>
  public boolean ValidateCandidate(final /*const*/ TypoCorrection /*&*/ candidate) {
    if (!candidate.isResolved()) {
      return true;
    }
    if (candidate.isKeyword()) {
      return WantTypeSpecifiers || WantExpressionKeywords || WantCXXNamedCasts
         || WantRemainingKeywords || WantObjCSuper;
    }
    
    boolean HasNonType = false;
    boolean HasStaticMethod = false;
    boolean HasNonStaticMethod = false;
    for (Decl /*P*/ D : candidate) {
      {
        FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(D);
        if ((FTD != null)) {
          D = FTD.getTemplatedDecl();
        }
      }
      {
        CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(D);
        if ((Method != null)) {
          if (Method.isStatic()) {
            HasStaticMethod = true;
          } else {
            HasNonStaticMethod = true;
          }
        }
      }
      if (!isa_TypeDecl(D)) {
        HasNonType = true;
      }
    }
    if (IsAddressOfOperand && HasNonStaticMethod && !HasStaticMethod
       && !(candidate.getCorrectionSpecifier() != null)) {
      return false;
    }
    
    return WantTypeSpecifiers || HasNonType;
  }

  
  /// \brief Method used by Sema::CorrectTypo to assign an "edit distance" rank
  /// to a candidate (where a lower value represents a better candidate), or
  /// returning InvalidDistance if the candidate is not at all viable. For
  /// validation callbacks that only need to determine if a candidate is viable,
  /// the default RankCandidate returns either 0 or InvalidDistance depending
  /// whether ValidateCandidate returns true or false.
  //<editor-fold defaultstate="collapsed" desc="clang::CorrectionCandidateCallback::RankCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 284,
   FQN="clang::CorrectionCandidateCallback::RankCandidate", NM="_ZN5clang27CorrectionCandidateCallback13RankCandidateERKNS_14TypoCorrectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang27CorrectionCandidateCallback13RankCandidateERKNS_14TypoCorrectionE")
  //</editor-fold>
  public /*virtual*/ /*uint*/int RankCandidate(final /*const*/ TypoCorrection /*&*/ candidate) {
    return (!MatchesTypo(candidate) && ValidateCandidate(candidate)) ? 0 : InvalidDistance;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CorrectionCandidateCallback::setTypoName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 290,
   FQN="clang::CorrectionCandidateCallback::setTypoName", NM="_ZN5clang27CorrectionCandidateCallback11setTypoNameEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang27CorrectionCandidateCallback11setTypoNameEPNS_14IdentifierInfoE")
  //</editor-fold>
  public void setTypoName(IdentifierInfo /*P*/ II) {
    Typo = II;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CorrectionCandidateCallback::setTypoNNS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 291,
   FQN="clang::CorrectionCandidateCallback::setTypoNNS", NM="_ZN5clang27CorrectionCandidateCallback10setTypoNNSEPNS_19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang27CorrectionCandidateCallback10setTypoNNSEPNS_19NestedNameSpecifierE")
  //</editor-fold>
  public void setTypoNNS(NestedNameSpecifier /*P*/ NNS) {
    TypoNNS = NNS;
  }

  
  // Flags for context-dependent keywords. WantFunctionLikeCasts is only
  // used/meaningful when WantCXXNamedCasts is false.
  // TODO: Expand these to apply to non-keywords or possibly remove them.
  public boolean WantTypeSpecifiers;
  public boolean WantExpressionKeywords;
  public boolean WantCXXNamedCasts;
  public boolean WantFunctionLikeCasts;
  public boolean WantRemainingKeywords;
  public boolean WantObjCSuper;
  // Temporary hack for the one case where a CorrectTypoContext enum is used
  // when looking up results.
  public boolean IsObjCIvarLookup;
  public boolean IsAddressOfOperand;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CorrectionCandidateCallback::MatchesTypo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 308,
   FQN="clang::CorrectionCandidateCallback::MatchesTypo", NM="_ZN5clang27CorrectionCandidateCallback11MatchesTypoERKNS_14TypoCorrectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang27CorrectionCandidateCallback11MatchesTypoERKNS_14TypoCorrectionE")
  //</editor-fold>
  protected boolean MatchesTypo(final /*const*/ TypoCorrection /*&*/ candidate) {
    return (Typo != null) && candidate.isResolved() && !candidate.requiresImport()
       && candidate.getCorrectionAsIdentifierInfo() == Typo
      // FIXME: This probably does not return true when both
      // NestedNameSpecifiers have the same textual representation.
       && candidate.getCorrectionSpecifier() == TypoNNS;
  }

  
  protected IdentifierInfo /*P*/ Typo;
  protected NestedNameSpecifier /*P*/ TypoNNS;
  
  @Override public String toString() {
    return "" + "WantTypeSpecifiers=" + WantTypeSpecifiers // NOI18N
              + ", WantExpressionKeywords=" + WantExpressionKeywords // NOI18N
              + ", WantCXXNamedCasts=" + WantCXXNamedCasts // NOI18N
              + ", WantFunctionLikeCasts=" + WantFunctionLikeCasts // NOI18N
              + ", WantRemainingKeywords=" + WantRemainingKeywords // NOI18N
              + ", WantObjCSuper=" + WantObjCSuper // NOI18N
              + ", IsObjCIvarLookup=" + IsObjCIvarLookup // NOI18N
              + ", IsAddressOfOperand=" + IsAddressOfOperand // NOI18N
              + ", Typo=" + Typo // NOI18N
              + ", TypoNNS=" + TypoNNS; // NOI18N
  }
}
