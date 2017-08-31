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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.impl.SemaOverloadStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompareOverloadCandidatesForDisplay">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9868,
 FQN="(anonymous namespace)::CompareOverloadCandidatesForDisplay", NM="_ZN12_GLOBAL__N_135CompareOverloadCandidatesForDisplayE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_135CompareOverloadCandidatesForDisplayE")
//</editor-fold>
public class/*struct*/ CompareOverloadCandidatesForDisplay implements Compare<OverloadCandidate> {
  public final Sema /*&*/ S;
  public SourceLocation Loc;
  public /*size_t*/int NumArgs;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompareOverloadCandidatesForDisplay::CompareOverloadCandidatesForDisplay">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9873,
   FQN="(anonymous namespace)::CompareOverloadCandidatesForDisplay::CompareOverloadCandidatesForDisplay", NM="_ZN12_GLOBAL__N_135CompareOverloadCandidatesForDisplayC1ERN5clang4SemaENS1_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_135CompareOverloadCandidatesForDisplayC1ERN5clang4SemaENS1_14SourceLocationEj")
  //</editor-fold>
  public CompareOverloadCandidatesForDisplay(final Sema /*&*/ S, SourceLocation Loc, /*size_t*/int nArgs) {
    // : S(S), Loc(), NumArgs(nArgs) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.Loc = new SourceLocation();
    this.NumArgs = nArgs;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompareOverloadCandidatesForDisplay::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9876,
   FQN="(anonymous namespace)::CompareOverloadCandidatesForDisplay::operator()", NM="_ZN12_GLOBAL__N_135CompareOverloadCandidatesForDisplayclEPKN5clang17OverloadCandidateES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_135CompareOverloadCandidatesForDisplayclEPKN5clang17OverloadCandidateES4_")
  //</editor-fold>
  public boolean compare(/*const*/ OverloadCandidate /*P*/ L, 
       /*const*/ OverloadCandidate /*P*/ R) {
    // Fast-path this check.
    if (L == R) {
      return false;
    }
    
    // Order first by viability.
    if (L.Viable) {
      if (!R.Viable) {
        return true;
      }
      
      // TODO: introduce a tri-valued comparison for overload
      // candidates.  Would be more worthwhile if we had a sort
      // that could exploit it.
      if (isBetterOverloadCandidate(S, $Deref(L), $Deref(R), new SourceLocation())) {
        return true;
      }
      if (isBetterOverloadCandidate(S, $Deref(R), $Deref(L), new SourceLocation())) {
        return false;
      }
    } else if (R.Viable) {
      return false;
    }
    assert (L.Viable == R.Viable);
    
    // Criteria by which we can sort non-viable candidates:
    if (!L.Viable) {
      // 1. Arity mismatches come after other candidates.
      if ($uchar2int(L.FailureKind) == OverloadFailureKind.ovl_fail_too_many_arguments.getValue()
         || $uchar2int(L.FailureKind) == OverloadFailureKind.ovl_fail_too_few_arguments.getValue()) {
        if ($uchar2int(R.FailureKind) == OverloadFailureKind.ovl_fail_too_many_arguments.getValue()
           || $uchar2int(R.FailureKind) == OverloadFailureKind.ovl_fail_too_few_arguments.getValue()) {
          int LDist = std.abs((int)L.getNumParams() - (int)NumArgs);
          int RDist = std.abs((int)R.getNumParams() - (int)NumArgs);
          if (LDist == RDist) {
            if ($uchar2int(L.FailureKind) == $uchar2int(R.FailureKind)) {
              // Sort non-surrogates before surrogates.
              return !L.IsSurrogate && R.IsSurrogate;
            }
            // Sort candidates requiring fewer parameters than there were
            // arguments given after candidates requiring more parameters
            // than there were arguments given.
            return $uchar2int(L.FailureKind) == OverloadFailureKind.ovl_fail_too_many_arguments.getValue();
          }
          return LDist < RDist;
        }
        return false;
      }
      if ($uchar2int(R.FailureKind) == OverloadFailureKind.ovl_fail_too_many_arguments.getValue()
         || $uchar2int(R.FailureKind) == OverloadFailureKind.ovl_fail_too_few_arguments.getValue()) {
        return true;
      }
      
      // 2. Bad conversions come first and are ordered by the number
      // of bad conversions and quality of good conversions.
      if ($uchar2int(L.FailureKind) == OverloadFailureKind.ovl_fail_bad_conversion.getValue()) {
        if ($uchar2int(R.FailureKind) != OverloadFailureKind.ovl_fail_bad_conversion.getValue()) {
          return true;
        }
        
        // The conversion that can be fixed with a smaller number of changes,
        // comes first.
        /*uint*/int numLFixes = L.Fix.NumConversionsFixed;
        /*uint*/int numRFixes = R.Fix.NumConversionsFixed;
        numLFixes = (numLFixes == 0) ? UINT_MAX : numLFixes;
        numRFixes = (numRFixes == 0) ? UINT_MAX : numRFixes;
        if (numLFixes != numRFixes) {
          return $less_uint(numLFixes, numRFixes);
        }
        
        // If there's any ordering between the defined conversions...
        // FIXME: this might not be transitive.
        assert (L.NumConversions == R.NumConversions);
        
        int leftBetter = 0;
        /*uint*/int I = ((L.IgnoreObjectArgument || R.IgnoreObjectArgument) ? 1 : 0);
        for (/*uint*/int E = L.NumConversions; I != E; ++I) {
          switch (CompareImplicitConversionSequences(S, new SourceLocation(Loc), 
              L.Conversions[I], 
              R.Conversions[I])) {
           case Better:
            leftBetter++;
            break;
           case Worse:
            leftBetter--;
            break;
           case Indistinguishable:
            break;
          }
        }
        if (leftBetter > 0) {
          return true;
        }
        if (leftBetter < 0) {
          return false;
        }
      } else if ($uchar2int(R.FailureKind) == OverloadFailureKind.ovl_fail_bad_conversion.getValue()) {
        return false;
      }
      if ($uchar2int(L.FailureKind) == OverloadFailureKind.ovl_fail_bad_deduction.getValue()) {
        if ($uchar2int(R.FailureKind) != OverloadFailureKind.ovl_fail_bad_deduction.getValue()) {
          return true;
        }
        if (L.Unnamed_field12.DeductionFailure.Result != $int2uint_8bits(R.Unnamed_field12.DeductionFailure.Result)) {
          return $less_uint(RankDeductionFailure(L.Unnamed_field12.DeductionFailure)
            , RankDeductionFailure(R.Unnamed_field12.DeductionFailure));
        }
      } else if ($uchar2int(R.FailureKind) == OverloadFailureKind.ovl_fail_bad_deduction.getValue()) {
        return false;
      }
      // TODO: others?
    }
    
    // Sort everything else by location.
    SourceLocation LLoc = GetLocationForCandidate(L);
    SourceLocation RLoc = GetLocationForCandidate(R);
    
    // Put candidates without locations (e.g. builtins) at the end.
    if (LLoc.isInvalid()) {
      return false;
    }
    if (RLoc.isInvalid()) {
      return true;
    }
    
    return S.SourceMgr.isBeforeInTranslationUnit(/*NO_COPY*/LLoc, /*NO_COPY*/RLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompareOverloadCandidatesForDisplay::CompareOverloadCandidatesForDisplay">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9868,
   FQN="(anonymous namespace)::CompareOverloadCandidatesForDisplay::CompareOverloadCandidatesForDisplay", NM="_ZN12_GLOBAL__N_135CompareOverloadCandidatesForDisplayC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_135CompareOverloadCandidatesForDisplayC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CompareOverloadCandidatesForDisplay(final /*const*/ CompareOverloadCandidatesForDisplay /*&*/ $Prm0) {
    // : S(.S), Loc(.Loc), NumArgs(.NumArgs) 
    //START JInit
    this./*&*/S=/*&*/$Prm0.S;
    this.Loc = new SourceLocation($Prm0.Loc);
    this.NumArgs = $Prm0.NumArgs;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompareOverloadCandidatesForDisplay::CompareOverloadCandidatesForDisplay">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9868,
   FQN="(anonymous namespace)::CompareOverloadCandidatesForDisplay::CompareOverloadCandidatesForDisplay", NM="_ZN12_GLOBAL__N_135CompareOverloadCandidatesForDisplayC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_135CompareOverloadCandidatesForDisplayC1EOS0_")
  //</editor-fold>
  public /*inline*/ CompareOverloadCandidatesForDisplay(JD$Move _dparam, final CompareOverloadCandidatesForDisplay /*&&*/$Prm0) {
    // : S(static_cast<CompareOverloadCandidatesForDisplay &&>().S), Loc(static_cast<CompareOverloadCandidatesForDisplay &&>().Loc), NumArgs(static_cast<CompareOverloadCandidatesForDisplay &&>().NumArgs) 
    //START JInit
    this./*&*/S=/*&*/$Prm0.S;
    this.Loc = new SourceLocation(JD$Move.INSTANCE, $Prm0.Loc);
    this.NumArgs = $Prm0.NumArgs;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", NumArgs=" + NumArgs; // NOI18N
  }
}
