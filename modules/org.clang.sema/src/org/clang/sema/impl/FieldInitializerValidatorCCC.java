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
import org.clang.ast.*;
import org.clang.sema.*;


// Callback to only accept typo corrections that are for field members of
// the given struct or union.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldInitializerValidatorCCC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1989,
 FQN="(anonymous namespace)::FieldInitializerValidatorCCC", NM="_ZN12_GLOBAL__N_128FieldInitializerValidatorCCCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_128FieldInitializerValidatorCCCE")
//</editor-fold>
public class FieldInitializerValidatorCCC extends /*public*/ CorrectionCandidateCallback implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldInitializerValidatorCCC::FieldInitializerValidatorCCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1991,
   FQN="(anonymous namespace)::FieldInitializerValidatorCCC::FieldInitializerValidatorCCC", NM="_ZN12_GLOBAL__N_128FieldInitializerValidatorCCCC1EPN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_128FieldInitializerValidatorCCCC1EPN5clang10RecordDeclE")
  //</editor-fold>
  public /*explicit*/ FieldInitializerValidatorCCC(RecordDecl /*P*/ RD) {
    // : CorrectionCandidateCallback(), Record(RD) 
    //START JInit
    super();
    this.Record = RD;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldInitializerValidatorCCC::ValidateCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1994,
   FQN="(anonymous namespace)::FieldInitializerValidatorCCC::ValidateCandidate", NM="_ZN12_GLOBAL__N_128FieldInitializerValidatorCCC17ValidateCandidateERKN5clang14TypoCorrectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_128FieldInitializerValidatorCCC17ValidateCandidateERKN5clang14TypoCorrectionE")
  //</editor-fold>
  @Override public boolean ValidateCandidate(final /*const*/ TypoCorrection /*&*/ candidate)/* override*/ {
    FieldDecl /*P*/ FD = candidate.<FieldDecl>getCorrectionDeclAs(FieldDecl.class);
    return (FD != null) && FD.getDeclContext().getRedeclContext().Equals(Record);
  }

/*private:*/
  private RecordDecl /*P*/ Record;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FieldInitializerValidatorCCC::~FieldInitializerValidatorCCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1989,
   FQN="(anonymous namespace)::FieldInitializerValidatorCCC::~FieldInitializerValidatorCCC", NM="_ZN12_GLOBAL__N_128FieldInitializerValidatorCCCD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZN12_GLOBAL__N_128FieldInitializerValidatorCCCD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Record=" + Record // NOI18N
              + super.toString(); // NOI18N
  }
}
