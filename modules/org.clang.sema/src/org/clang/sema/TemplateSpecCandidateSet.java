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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;


/// TemplateSpecCandidateSet - A set of generalized overload candidates,
/// used in template specializations.
/// TODO: In the future, we may need to unify/generalize this with
/// OverloadCandidateSet.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 272,
 FQN="clang::TemplateSpecCandidateSet", NM="_ZN5clang24TemplateSpecCandidateSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24TemplateSpecCandidateSetE")
//</editor-fold>
public class TemplateSpecCandidateSet implements Destructors.ClassWithDestructor {
  private SmallVector<TemplateSpecCandidate> Candidates;
  private SourceLocation Loc;
  // Stores whether we're taking the address of these candidates. This helps us
  // produce better error messages when dealing with the pass_object_size
  // attribute on parameters.
  private boolean ForTakingAddress;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::TemplateSpecCandidateSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 280,
   FQN="clang::TemplateSpecCandidateSet::TemplateSpecCandidateSet", NM="_ZN5clang24TemplateSpecCandidateSetC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24TemplateSpecCandidateSetC1ERKS0_")
  //</editor-fold>
  private TemplateSpecCandidateSet(final /*const*/ TemplateSpecCandidateSet /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 282,
   FQN="clang::TemplateSpecCandidateSet::operator=", NM="_ZN5clang24TemplateSpecCandidateSetaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24TemplateSpecCandidateSetaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ TemplateSpecCandidateSet /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::destroyCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10193,
   FQN="clang::TemplateSpecCandidateSet::destroyCandidates", NM="_ZN5clang24TemplateSpecCandidateSet17destroyCandidatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24TemplateSpecCandidateSet17destroyCandidatesEv")
  //</editor-fold>
  private void destroyCandidates() {
    for (type$ptr<TemplateSpecCandidate> i = begin(), /*P*/ e = end(); $noteq_iter(i, e); i.$preInc()) {
      i./*->*/$star().DeductionFailure.Destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::TemplateSpecCandidateSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 287,
   FQN="clang::TemplateSpecCandidateSet::TemplateSpecCandidateSet", NM="_ZN5clang24TemplateSpecCandidateSetC1ENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24TemplateSpecCandidateSetC1ENS_14SourceLocationEb")
  //</editor-fold>
  public TemplateSpecCandidateSet(SourceLocation Loc) {
    this(Loc, false);
  }
  public TemplateSpecCandidateSet(SourceLocation Loc, boolean ForTakingAddress/*= false*/) {
    // : Candidates(), Loc(Loc), ForTakingAddress(ForTakingAddress) 
    //START JInit
    this.Candidates = new SmallVector<TemplateSpecCandidate>(16, new TemplateSpecCandidate());
    this.Loc = new SourceLocation(Loc);
    this.ForTakingAddress = ForTakingAddress;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::~TemplateSpecCandidateSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 289,
   FQN="clang::TemplateSpecCandidateSet::~TemplateSpecCandidateSet", NM="_ZN5clang24TemplateSpecCandidateSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24TemplateSpecCandidateSetD0Ev")
  //</editor-fold>
  public void $destroy() {
    destroyCandidates();
    //START JDestroy
    Candidates.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 291,
   FQN="clang::TemplateSpecCandidateSet::getLocation", NM="_ZNK5clang24TemplateSpecCandidateSet11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang24TemplateSpecCandidateSet11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  
  /// \brief Clear out all of the candidates.
  /// TODO: This may be unnecessary.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10199,
   FQN="clang::TemplateSpecCandidateSet::clear", NM="_ZN5clang24TemplateSpecCandidateSet5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24TemplateSpecCandidateSet5clearEv")
  //</editor-fold>
  public void clear() {
    destroyCandidates();
    Candidates.clear();
  }

  
  /*typedef SmallVector<TemplateSpecCandidate, 16>::iterator iterator*/
//  public final class iterator extends type$ptr<TemplateSpecCandidate>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 298,
   FQN="clang::TemplateSpecCandidateSet::begin", NM="_ZN5clang24TemplateSpecCandidateSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24TemplateSpecCandidateSet5beginEv")
  //</editor-fold>
  public type$ptr<TemplateSpecCandidate> begin() {
    return Candidates.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 299,
   FQN="clang::TemplateSpecCandidateSet::end", NM="_ZN5clang24TemplateSpecCandidateSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24TemplateSpecCandidateSet3endEv")
  //</editor-fold>
  public type$ptr<TemplateSpecCandidate> end() {
    return Candidates.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 301,
   FQN="clang::TemplateSpecCandidateSet::size", NM="_ZNK5clang24TemplateSpecCandidateSet4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang24TemplateSpecCandidateSet4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return Candidates.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 302,
   FQN="clang::TemplateSpecCandidateSet::empty", NM="_ZNK5clang24TemplateSpecCandidateSet5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang24TemplateSpecCandidateSet5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Candidates.empty();
  }

  
  /// \brief Add a new candidate with NumConversions conversion sequence slots
  /// to the overload set.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::addCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 306,
   FQN="clang::TemplateSpecCandidateSet::addCandidate", NM="_ZN5clang24TemplateSpecCandidateSet12addCandidateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24TemplateSpecCandidateSet12addCandidateEv")
  //</editor-fold>
  public TemplateSpecCandidate /*&*/ addCandidate() {
    Candidates.emplace_back();
    return Candidates.back();
  }

  
  
  /// NoteCandidates - When no template specialization match is found, prints
  /// diagnostic messages containing the non-matching specializations that form
  /// the candidate set.
  /// This is analoguous to OverloadCandidateSet::NoteCandidates() with
  /// OCD == OCD_AllCandidates and Cand->Viable == false.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::NoteCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10209,
   FQN="clang::TemplateSpecCandidateSet::NoteCandidates", NM="_ZN5clang24TemplateSpecCandidateSet14NoteCandidatesERNS_4SemaENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24TemplateSpecCandidateSet14NoteCandidatesERNS_4SemaENS_14SourceLocationE")
  //</editor-fold>
  public void NoteCandidates(final Sema /*&*/ S, SourceLocation Loc) {
    // Sort the candidates by position (assuming no candidate is a match).
    // Sorting directly would be prohibitive, so we make a set of pointers
    // and sort those.
    SmallVector<TemplateSpecCandidate /*P*/ > Cands/*J*/= new SmallVector<TemplateSpecCandidate /*P*/ >(32, (TemplateSpecCandidate /*P*/ )null);
    Cands.reserve(size());
    for (type$ptr<TemplateSpecCandidate> Cand = begin(), /*P*/ LastCand = end(); $noteq_iter(Cand, LastCand); Cand.$preInc()) {
      if ((Cand./*->*/$star().Specialization != null)) {
        Cands.push_back(Cand.$star());
      }
      // Otherwise, this is a non-matching builtin candidate.  We do not,
      // in general, want to list every possible builtin candidate.
    }
    
    std.sort(Cands.begin(), Cands.end(), 
        new CompareTemplateSpecCandidatesForDisplay(S));
    
    // FIXME: Perhaps rename OverloadsShown and getShowOverloads()
    // for generalization purposes (?).
    /*const*/ OverloadsShown ShowOverloads = S.Diags.getShowOverloads();
    
    type$ptr<TemplateSpecCandidate /*P*/ /*P*/> I, /*P*/ E;
    /*uint*/int CandsShown = 0;
    for (I = $tryClone(Cands.begin()) , E = $tryClone(Cands.end()); $noteq_iter(I, E); I.$preInc()) {
      TemplateSpecCandidate /*P*/ Cand = I.$star();
      
      // Set an arbitrary limit on the number of candidates we'll spam
      // the user with.  FIXME: This limit should depend on details of the
      // candidate list.
      if ($greatereq_uint(CandsShown, 4) && ShowOverloads == OverloadsShown.Ovl_Best) {
        break;
      }
      ++CandsShown;
      assert ((Cand.Specialization != null)) : "Non-matching built-in candidates are not added to Cands.";
      Cand.NoteDeductionFailure(S, ForTakingAddress);
    }
    if ($noteq_iter(I, E)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.note_ovl_too_many_candidates)), ((int)(E.$sub(I)))));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidateSet::NoteCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 313,
   FQN="clang::TemplateSpecCandidateSet::NoteCandidates", NM="_ZNK5clang24TemplateSpecCandidateSet14NoteCandidatesERNS_4SemaENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang24TemplateSpecCandidateSet14NoteCandidatesERNS_4SemaENS_14SourceLocationE")
  //</editor-fold>
  public void NoteCandidates$Const(final Sema /*&*/ S, SourceLocation Loc) /*const*/ {
    ((/*const_cast*/TemplateSpecCandidateSet /*P*/ )(this)).NoteCandidates(S, new SourceLocation(Loc));
  }

  
  @Override public String toString() {
    return "" + "Candidates=" + Candidates // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", ForTakingAddress=" + ForTakingAddress; // NOI18N
  }
}
