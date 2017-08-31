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
import static org.clank.support.NativePointer.*;
import org.clang.ast.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.sema.impl.SemaDeclCXXStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UsingValidatorCCC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8149,
 FQN="(anonymous namespace)::UsingValidatorCCC", NM="_ZN12_GLOBAL__N_117UsingValidatorCCCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_117UsingValidatorCCCE")
//</editor-fold>
public class UsingValidatorCCC extends /*public*/ CorrectionCandidateCallback implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UsingValidatorCCC::UsingValidatorCCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8151,
   FQN="(anonymous namespace)::UsingValidatorCCC::UsingValidatorCCC", NM="_ZN12_GLOBAL__N_117UsingValidatorCCCC1EbbPN5clang19NestedNameSpecifierEPNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_117UsingValidatorCCCC1EbbPN5clang19NestedNameSpecifierEPNS1_13CXXRecordDeclE")
  //</editor-fold>
  public UsingValidatorCCC(boolean HasTypenameKeyword, boolean IsInstantiation, 
      NestedNameSpecifier /*P*/ NNS, CXXRecordDecl /*P*/ RequireMemberOf) {
    // : CorrectionCandidateCallback(), HasTypenameKeyword(HasTypenameKeyword), IsInstantiation(IsInstantiation), OldNNS(NNS), RequireMemberOf(RequireMemberOf) 
    //START JInit
    super();
    this.HasTypenameKeyword = HasTypenameKeyword;
    this.IsInstantiation = IsInstantiation;
    this.OldNNS = NNS;
    this.RequireMemberOf = RequireMemberOf;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UsingValidatorCCC::ValidateCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8157,
   FQN="(anonymous namespace)::UsingValidatorCCC::ValidateCandidate", NM="_ZN12_GLOBAL__N_117UsingValidatorCCC17ValidateCandidateERKN5clang14TypoCorrectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_117UsingValidatorCCC17ValidateCandidateERKN5clang14TypoCorrectionE")
  //</editor-fold>
  @Override public boolean ValidateCandidate(final /*const*/ TypoCorrection /*&*/ Candidate)/* override*/ {
    NamedDecl /*P*/ ND = Candidate.getCorrectionDecl();
    
    // Keywords are not valid here.
    if (!(ND != null) || isa_NamespaceDecl(ND)) {
      return false;
    }
    
    // Completely unqualified names are invalid for a 'using' declaration.
    if (Candidate.WillReplaceSpecifier() && !(Candidate.getCorrectionSpecifier() != null)) {
      return false;
    }
    
    // FIXME: Don't correct to a name that CheckUsingDeclRedeclaration would
    // reject.
    if ((RequireMemberOf != null)) {
      CXXRecordDecl /*P*/ FoundRecord = dyn_cast_CXXRecordDecl(ND);
      if ((FoundRecord != null) && FoundRecord.isInjectedClassName()) {
        // No-one ever wants a using-declaration to name an injected-class-name
        // of a base class, unless they're declaring an inheriting constructor.
        final ASTContext /*&*/ Ctx = ND.getASTContext();
        if (!Ctx.getLangOpts().CPlusPlus11) {
          return false;
        }
        QualType FoundType = Ctx.getRecordType(FoundRecord);
        
        // Check that the injected-class-name is named as a member of its own
        // type; we don't want to suggest 'using Derived::Base;', since that
        // means something else.
        NestedNameSpecifier /*P*/ Specifier = Candidate.WillReplaceSpecifier() ? Candidate.getCorrectionSpecifier() : OldNNS;
        if (!(Specifier.getAsType() != null)
           || !Ctx.hasSameType(new QualType(Specifier.getAsType(), 0), new QualType(FoundType))) {
          return false;
        }
        
        // Check that this inheriting constructor declaration actually names a
        // direct base class of the current class.
        bool$ref AnyDependentBases = create_bool$ref(false);
        if (!(findDirectBaseWithType(RequireMemberOf, 
            Ctx.getRecordType(FoundRecord), 
            AnyDependentBases) != null)
           && !AnyDependentBases.$deref()) {
          return false;
        }
      } else {
        CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(ND.getDeclContext());
        if (!(RD != null) || RequireMemberOf.isProvablyNotDerivedFrom(RD)) {
          return false;
        }
        // FIXME: Check that the base class member is accessible?
      }
    } else {
      CXXRecordDecl /*P*/ FoundRecord = dyn_cast_CXXRecordDecl(ND);
      if ((FoundRecord != null) && FoundRecord.isInjectedClassName()) {
        return false;
      }
    }
    if (isa_TypeDecl(ND)) {
      return HasTypenameKeyword || !IsInstantiation;
    }
    
    return !HasTypenameKeyword;
  }

/*private:*/
  private boolean HasTypenameKeyword;
  private boolean IsInstantiation;
  private NestedNameSpecifier /*P*/ OldNNS;
  private CXXRecordDecl /*P*/ RequireMemberOf;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UsingValidatorCCC::~UsingValidatorCCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8149,
   FQN="(anonymous namespace)::UsingValidatorCCC::~UsingValidatorCCC", NM="_ZN12_GLOBAL__N_117UsingValidatorCCCD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_117UsingValidatorCCCD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "HasTypenameKeyword=" + HasTypenameKeyword // NOI18N
              + ", IsInstantiation=" + IsInstantiation // NOI18N
              + ", OldNNS=" + OldNNS // NOI18N
              + ", RequireMemberOf=" + RequireMemberOf // NOI18N
              + super.toString(); // NOI18N
  }
}
