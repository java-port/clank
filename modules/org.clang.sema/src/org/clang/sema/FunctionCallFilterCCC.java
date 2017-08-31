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
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


// @brief Callback class to limit the allowed keywords and to only accept typo
// corrections that are keywords or whose decls refer to functions (or template
// functions) that accept the given number of arguments.
//<editor-fold defaultstate="collapsed" desc="clang::FunctionCallFilterCCC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 333,
 FQN="clang::FunctionCallFilterCCC", NM="_ZN5clang21FunctionCallFilterCCCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang21FunctionCallFilterCCCE")
//</editor-fold>
public class FunctionCallFilterCCC extends /*public*/ CorrectionCandidateCallback implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionCallFilterCCC::FunctionCallFilterCCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4866,
   FQN="clang::FunctionCallFilterCCC::FunctionCallFilterCCC", NM="_ZN5clang21FunctionCallFilterCCCC1ERNS_4SemaEjbPNS_10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang21FunctionCallFilterCCCC1ERNS_4SemaEjbPNS_10MemberExprE")
  //</editor-fold>
  public FunctionCallFilterCCC(final Sema /*&*/ SemaRef, /*uint*/int NumArgs, 
      boolean HasExplicitTemplateArgs) {
    this(SemaRef, NumArgs, 
      HasExplicitTemplateArgs, 
      (MemberExpr /*P*/ )null);
  }
  public FunctionCallFilterCCC(final Sema /*&*/ SemaRef, /*uint*/int NumArgs, 
      boolean HasExplicitTemplateArgs, 
      MemberExpr /*P*/ ME/*= null*/) {
    // : CorrectionCandidateCallback(), NumArgs(NumArgs), HasExplicitTemplateArgs(HasExplicitTemplateArgs), CurContext(SemaRef.CurContext), MemberFn(ME) 
    //START JInit
    super();
    this.NumArgs = NumArgs;
    this.HasExplicitTemplateArgs = HasExplicitTemplateArgs;
    this.CurContext = SemaRef.CurContext;
    this.MemberFn = ME;
    //END JInit
    WantTypeSpecifiers = false;
    WantFunctionLikeCasts = SemaRef.getLangOpts().CPlusPlus && NumArgs == 1;
    WantRemainingKeywords = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionCallFilterCCC::ValidateCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4876,
   FQN="clang::FunctionCallFilterCCC::ValidateCandidate", NM="_ZN5clang21FunctionCallFilterCCC17ValidateCandidateERKNS_14TypoCorrectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang21FunctionCallFilterCCC17ValidateCandidateERKNS_14TypoCorrectionE")
  //</editor-fold>
  @Override public boolean ValidateCandidate(final /*const*/ TypoCorrection /*&*/ candidate)/* override*/ {
    if (!(candidate.getCorrectionDecl() != null)) {
      return candidate.isKeyword();
    }
    
    for (NamedDecl /*P*/ C : candidate) {
      FunctionDecl /*P*/ FD = null;
      NamedDecl /*P*/ ND = C.getUnderlyingDecl();
      {
        FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(ND);
        if ((FTD != null)) {
          FD = FTD.getTemplatedDecl();
        }
      }
      if (!HasExplicitTemplateArgs && !(FD != null)) {
        if (!((FD = dyn_cast_FunctionDecl(ND)) != null) && isa_ValueDecl(ND)) {
          // If the Decl is neither a function nor a template function,
          // determine if it is a pointer or reference to a function. If so,
          // check against the number of arguments expected for the pointee.
          QualType ValType = cast_ValueDecl(ND).getType();
          if (ValType.$arrow().isAnyPointerType() || ValType.$arrow().isReferenceType()) {
            ValType.$assignMove(ValType.$arrow().getPointeeType());
          }
          {
            /*const*/ FunctionProtoType /*P*/ FPT = ValType.$arrow().getAs(FunctionProtoType.class);
            if ((FPT != null)) {
              if (FPT.getNumParams() == NumArgs) {
                return true;
              }
            }
          }
        }
      }
      
      // Skip the current candidate if it is not a FunctionDecl or does not accept
      // the current number of arguments.
      if (!(FD != null) || !($greatereq_uint(FD.getNumParams(), NumArgs)
         && $lesseq_uint(FD.getMinRequiredArguments(), NumArgs))) {
        continue;
      }
      {
        
        // If the current candidate is a non-static C++ method, skip the candidate
        // unless the method being corrected--or the current DeclContext, if the
        // function being corrected is not a method--is a method in the same class
        // or a descendent class of the candidate's parent class.
        CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
        if ((MD != null)) {
          if ((MemberFn != null) || !MD.isStatic()) {
            CXXMethodDecl /*P*/ CurMD = (MemberFn != null) ? dyn_cast_or_null_CXXMethodDecl(MemberFn.getMemberDecl()) : dyn_cast_or_null_CXXMethodDecl(CurContext);
            CXXRecordDecl /*P*/ CurRD = (CurMD != null) ? CurMD.getParent().getCanonicalDecl() : null;
            CXXRecordDecl /*P*/ RD = MD.getParent().getCanonicalDecl();
            if (!(CurRD != null) || (CurRD != RD && !CurRD.isDerivedFrom(RD))) {
              continue;
            }
          }
        }
      }
      return true;
    }
    return false;
  }

/*private:*/
  private /*uint*/int NumArgs;
  private boolean HasExplicitTemplateArgs;
  private DeclContext /*P*/ CurContext;
  private MemberExpr /*P*/ MemberFn;
  //<editor-fold defaultstate="collapsed" desc="clang::FunctionCallFilterCCC::~FunctionCallFilterCCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 333,
   FQN="clang::FunctionCallFilterCCC::~FunctionCallFilterCCC", NM="_ZN5clang21FunctionCallFilterCCCD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang21FunctionCallFilterCCCD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "NumArgs=" + NumArgs // NOI18N
              + ", HasExplicitTemplateArgs=" + HasExplicitTemplateArgs // NOI18N
              + ", CurContext=" + "[DeclContext]" // NOI18N
              + ", MemberFn=" + MemberFn // NOI18N
              + super.toString(); // NOI18N
  }
}
