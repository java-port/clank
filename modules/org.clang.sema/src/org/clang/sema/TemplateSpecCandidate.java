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
import static org.clang.sema.impl.SemaOverloadStatics.*;


/// TemplateSpecCandidate - This is a generalization of OverloadCandidate
/// which keeps track of template argument deduction failure info, when
/// handling explicit specializations (and instantiations) of templates
/// beyond function overloading.
/// For now, assume that the candidates are non-matching specializations.
/// TODO: In the future, we may need to unify/generalize this with
/// OverloadCandidate.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 246,
 FQN="clang::TemplateSpecCandidate", NM="_ZN5clang21TemplateSpecCandidateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang21TemplateSpecCandidateE")
//</editor-fold>
public class/*struct*/ TemplateSpecCandidate implements NativeCloneable<TemplateSpecCandidate> {
  /// \brief The declaration that was looked up, together with its access.
  /// Might be a UsingShadowDecl, but usually a FunctionTemplateDecl.
  public DeclAccessPair FoundDecl;
  
  /// Specialization - The actual specialization that this candidate
  /// represents. When NULL, this may be a built-in candidate.
  public Decl /*P*/ Specialization;
  
  /// Template argument deduction info
  public DeductionFailureInfo DeductionFailure;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidate::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TemplateDeduction.h", line = 258,
   FQN="clang::TemplateSpecCandidate::set", NM="_ZN5clang21TemplateSpecCandidate3setENS_14DeclAccessPairEPNS_4DeclENS_20DeductionFailureInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang21TemplateSpecCandidate3setENS_14DeclAccessPairEPNS_4DeclENS_20DeductionFailureInfoE")
  //</editor-fold>
  public void set(DeclAccessPair Found, Decl /*P*/ Spec, DeductionFailureInfo Info) {
    FoundDecl.$assign(Found);
    Specialization = Spec;
    DeductionFailure.$assign(Info);
  }

  
  /// Diagnose a template argument deduction failure.
  
  /// Diagnose a template argument deduction failure.
  /// We are treating these failures as overload failures due to bad
  /// deductions.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecCandidate::NoteDeductionFailure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10187,
   FQN="clang::TemplateSpecCandidate::NoteDeductionFailure", NM="_ZN5clang21TemplateSpecCandidate20NoteDeductionFailureERNS_4SemaEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang21TemplateSpecCandidate20NoteDeductionFailureERNS_4SemaEb")
  //</editor-fold>
  public void NoteDeductionFailure(final Sema /*&*/ S, 
                      boolean ForTakingAddress) {
    DiagnoseBadDeduction(S, FoundDecl.$NamedDecl$P(), Specialization,  // pattern
        DeductionFailure, /*NumArgs=*/ 0, ForTakingAddress);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public TemplateSpecCandidate() {
    this.FoundDecl = new DeclAccessPair();
    this.Specialization = null;
    this.DeductionFailure = new DeductionFailureInfo();
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public TemplateSpecCandidate(TemplateSpecCandidate Other) {
    this.FoundDecl = new DeclAccessPair(Other.FoundDecl);
    this.Specialization = Other.Specialization;
    this.DeductionFailure = new DeductionFailureInfo(Other.DeductionFailure);
  }
  
  @Override
  public TemplateSpecCandidate clone() {
    return new TemplateSpecCandidate(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "FoundDecl=" + FoundDecl // NOI18N
              + ", Specialization=" + Specialization // NOI18N
              + ", DeductionFailure=" + DeductionFailure; // NOI18N
  }
}
