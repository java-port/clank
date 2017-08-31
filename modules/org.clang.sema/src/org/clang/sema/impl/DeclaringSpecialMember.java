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
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.sema.*;
import static org.clang.sema.Sema.*;

/// RAII object to register a special member as being currently declared.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaringSpecialMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9086,
 FQN="(anonymous namespace)::DeclaringSpecialMember", NM="_ZN12_GLOBAL__N_122DeclaringSpecialMemberE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_122DeclaringSpecialMemberE")
//</editor-fold>
public class/*struct*/ DeclaringSpecialMember implements Destructors.ClassWithDestructor {
  public final Sema /*&*/ S;
  public std.pair<CXXRecordDecl /*P*/ , CXXSpecialMember> D;
  public Sema.ContextRAII SavedContext;
  public boolean WasAlreadyBeingDeclared;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaringSpecialMember::DeclaringSpecialMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9092,
   FQN="(anonymous namespace)::DeclaringSpecialMember::DeclaringSpecialMember", NM="_ZN12_GLOBAL__N_122DeclaringSpecialMemberC1ERN5clang4SemaEPNS1_13CXXRecordDeclENS2_16CXXSpecialMemberE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_122DeclaringSpecialMemberC1ERN5clang4SemaEPNS1_13CXXRecordDeclENS2_16CXXSpecialMemberE")
  //</editor-fold>
  public DeclaringSpecialMember(final Sema /*&*/ S, CXXRecordDecl /*P*/ RD, Sema.CXXSpecialMember CSM) {
    // : S(S), D(RD, CSM), SavedContext(S, RD) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.D = new std.pairPtrType<CXXRecordDecl /*P*/ , CXXSpecialMember>(JD$T$RR_T1$RR.INSTANCE, RD, CSM);
    this.SavedContext = new Sema.ContextRAII(S, RD);
    //END JInit
    WasAlreadyBeingDeclared = !S.SpecialMembersBeingDeclared.insert(D);
    if (WasAlreadyBeingDeclared) {
      // This almost never happens, but if it does, ensure that our cache
      // doesn't contain a stale result.
      S.SpecialMemberCache.clear();
    }
    // FIXME: Register a note to be produced if we encounter an error while
    // declaring the special member.
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaringSpecialMember::~DeclaringSpecialMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9103,
   FQN="(anonymous namespace)::DeclaringSpecialMember::~DeclaringSpecialMember", NM="_ZN12_GLOBAL__N_122DeclaringSpecialMemberD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_122DeclaringSpecialMemberD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (!WasAlreadyBeingDeclared) {
      S.SpecialMembersBeingDeclared.erase(D);
    }
    //START JDestroy
    SavedContext.$destroy();
    //END JDestroy
  }

  
  /// \brief Are we already trying to declare this special member?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclaringSpecialMember::isAlreadyBeingDeclared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9109,
   FQN="(anonymous namespace)::DeclaringSpecialMember::isAlreadyBeingDeclared", NM="_ZNK12_GLOBAL__N_122DeclaringSpecialMember22isAlreadyBeingDeclaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZNK12_GLOBAL__N_122DeclaringSpecialMember22isAlreadyBeingDeclaredEv")
  //</editor-fold>
  public boolean isAlreadyBeingDeclared() /*const*/ {
    return WasAlreadyBeingDeclared;
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", D=" + D // NOI18N
              + ", SavedContext=" + SavedContext // NOI18N
              + ", WasAlreadyBeingDeclared=" + WasAlreadyBeingDeclared; // NOI18N
  }
}
