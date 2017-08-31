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
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.sema.*;
import static org.clang.sema.impl.SemaDeclStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


// Callback to only accept typo corrections that have a non-zero edit distance.
// Also only accept corrections that have the same parent decl.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DifferentNameValidatorCCC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7114,
 FQN="(anonymous namespace)::DifferentNameValidatorCCC", NM="_ZN12_GLOBAL__N_125DifferentNameValidatorCCCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_125DifferentNameValidatorCCCE")
//</editor-fold>
public class DifferentNameValidatorCCC extends /*public*/ CorrectionCandidateCallback implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DifferentNameValidatorCCC::DifferentNameValidatorCCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7116,
   FQN="(anonymous namespace)::DifferentNameValidatorCCC::DifferentNameValidatorCCC", NM="_ZN12_GLOBAL__N_125DifferentNameValidatorCCCC1ERN5clang10ASTContextEPNS1_12FunctionDeclEPNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_125DifferentNameValidatorCCCC1ERN5clang10ASTContextEPNS1_12FunctionDeclEPNS1_13CXXRecordDeclE")
  //</editor-fold>
  public DifferentNameValidatorCCC(final ASTContext /*&*/ Context, FunctionDecl /*P*/ TypoFD, 
      CXXRecordDecl /*P*/ Parent) {
    // : CorrectionCandidateCallback(), Context(Context), OriginalFD(TypoFD), ExpectedParent(Parent ? Parent->getCanonicalDecl() : null) 
    //START JInit
    super();
    this./*&*/Context=/*&*/Context;
    this.OriginalFD = TypoFD;
    this.ExpectedParent = (Parent != null) ? Parent.getCanonicalDecl() : null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DifferentNameValidatorCCC::ValidateCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7121,
   FQN="(anonymous namespace)::DifferentNameValidatorCCC::ValidateCandidate", NM="_ZN12_GLOBAL__N_125DifferentNameValidatorCCC17ValidateCandidateERKN5clang14TypoCorrectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_125DifferentNameValidatorCCC17ValidateCandidateERKN5clang14TypoCorrectionE")
  //</editor-fold>
  @Override public boolean ValidateCandidate(final /*const*/ TypoCorrection /*&*/ candidate)/* override*/ {
    if (candidate.getEditDistance() == 0) {
      return false;
    }
    
    SmallVectorUInt MismatchedParams/*J*/= new SmallVectorUInt(1, 0);
    for (type$ptr<NamedDecl/*P*/ /*P*/> CDecl = candidate.begin$Const(), 
        /*P*/ CDeclEnd = candidate.end$Const();
         $noteq_iter(CDecl, CDeclEnd); CDecl.$preInc()) {
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(CDecl.$star());
      if ((FD != null) && !FD.hasBody()
         && hasSimilarParameters(Context, FD, OriginalFD, MismatchedParams)) {
        {
          CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
          if ((MD != null)) {
            CXXRecordDecl /*P*/ Parent = MD.getParent();
            if ((Parent != null) && Parent.getCanonicalDecl() == ExpectedParent) {
              return true;
            }
          } else if (!(ExpectedParent != null)) {
            return true;
          }
        }
      }
    }
    
    return false;
  }

/*private:*/
  private final ASTContext /*&*/ Context;
  private FunctionDecl /*P*/ OriginalFD;
  private CXXRecordDecl /*P*/ ExpectedParent;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DifferentNameValidatorCCC::~DifferentNameValidatorCCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7114,
   FQN="(anonymous namespace)::DifferentNameValidatorCCC::~DifferentNameValidatorCCC", NM="_ZN12_GLOBAL__N_125DifferentNameValidatorCCCD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_125DifferentNameValidatorCCCD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", OriginalFD=" + OriginalFD // NOI18N
              + ", ExpectedParent=" + ExpectedParent // NOI18N
              + super.toString(); // NOI18N
  }
}
