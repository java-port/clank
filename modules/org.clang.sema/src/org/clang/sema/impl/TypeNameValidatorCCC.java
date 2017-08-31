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
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeNameValidatorCCC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 65,
 FQN="(anonymous namespace)::TypeNameValidatorCCC", NM="_ZN12_GLOBAL__N_120TypeNameValidatorCCCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120TypeNameValidatorCCCE")
//</editor-fold>
public class TypeNameValidatorCCC extends /*public*/ CorrectionCandidateCallback implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeNameValidatorCCC::TypeNameValidatorCCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 67,
   FQN="(anonymous namespace)::TypeNameValidatorCCC::TypeNameValidatorCCC", NM="_ZN12_GLOBAL__N_120TypeNameValidatorCCCC1Ebbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120TypeNameValidatorCCCC1Ebbb")
  //</editor-fold>
  public TypeNameValidatorCCC(boolean AllowInvalid) {
    this(AllowInvalid, false, 
      false);
  }
  public TypeNameValidatorCCC(boolean AllowInvalid, boolean WantClass/*= false*/) {
    this(AllowInvalid, WantClass, 
      false);
  }
  public TypeNameValidatorCCC(boolean AllowInvalid, boolean WantClass/*= false*/, 
      boolean AllowTemplates/*= false*/) {
    // : CorrectionCandidateCallback(), AllowInvalidDecl(AllowInvalid), WantClassName(WantClass), AllowClassTemplates(AllowTemplates) 
    //START JInit
    super();
    this.AllowInvalidDecl = AllowInvalid;
    this.WantClassName = WantClass;
    this.AllowClassTemplates = AllowTemplates;
    //END JInit
    WantExpressionKeywords = false;
    WantCXXNamedCasts = false;
    WantRemainingKeywords = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeNameValidatorCCC::ValidateCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 76,
   FQN="(anonymous namespace)::TypeNameValidatorCCC::ValidateCandidate", NM="_ZN12_GLOBAL__N_120TypeNameValidatorCCC17ValidateCandidateERKN5clang14TypoCorrectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120TypeNameValidatorCCC17ValidateCandidateERKN5clang14TypoCorrectionE")
  //</editor-fold>
  @Override public boolean ValidateCandidate(final /*const*/ TypoCorrection /*&*/ candidate)/* override*/ {
    {
      NamedDecl/*P*/ ND = candidate.getCorrectionDecl();
      if ((ND != null)) {
        boolean IsType = isa_TypeDecl(ND) || isa_ObjCInterfaceDecl(ND);
        boolean AllowedTemplate = AllowClassTemplates && isa_ClassTemplateDecl(ND);
        return (IsType || AllowedTemplate)
           && (AllowInvalidDecl || !ND.isInvalidDecl());
      }
    }
    return !WantClassName && candidate.isKeyword();
  }

/*private:*/
  private boolean AllowInvalidDecl;
  private boolean WantClassName;
  private boolean AllowClassTemplates;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeNameValidatorCCC::~TypeNameValidatorCCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 65,
   FQN="(anonymous namespace)::TypeNameValidatorCCC::~TypeNameValidatorCCC", NM="_ZN12_GLOBAL__N_120TypeNameValidatorCCCD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_120TypeNameValidatorCCCD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "AllowInvalidDecl=" + AllowInvalidDecl // NOI18N
              + ", WantClassName=" + WantClassName // NOI18N
              + ", AllowClassTemplates=" + AllowClassTemplates // NOI18N
              + super.toString(); // NOI18N
  }
}
