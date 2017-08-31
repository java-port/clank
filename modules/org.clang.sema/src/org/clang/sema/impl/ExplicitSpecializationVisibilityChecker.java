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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// \brief Walk the path from which a declaration was instantiated, and check
/// that every explicit specialization along that path is visible. This enforces
/// C++ [temp.expl.spec]/6:
///
///   If a template, a member template or a member of a class template is
///   explicitly specialized then that specialization shall be declared before
///   the first use of that specialization that would cause an implicit
///   instantiation to take place, in every translation unit in which such a
///   use occurs; no diagnostic is required.
///
/// and also C++ [temp.class.spec]/1:
///
///   A partial specialization shall be declared before the first use of a
///   class template specialization that would make use of the partial
///   specialization as the result of an implicit or explicit instantiation
///   in every translation unit in which such a use occurs; no diagnostic is
///   required.
//<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8628,
 FQN="ExplicitSpecializationVisibilityChecker", NM="_Z39ExplicitSpecializationVisibilityChecker",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_Z39ExplicitSpecializationVisibilityChecker")
//</editor-fold>
public class ExplicitSpecializationVisibilityChecker implements Destructors.ClassWithDestructor {
  private final Sema /*&*/ S;
  private SourceLocation Loc;
  private SmallVector<Module /*P*/> Modules;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::ExplicitSpecializationVisibilityChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8634,
   FQN="ExplicitSpecializationVisibilityChecker::ExplicitSpecializationVisibilityChecker", NM="_ZN39ExplicitSpecializationVisibilityCheckerC1ERN5clang4SemaENS0_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityCheckerC1ERN5clang4SemaENS0_14SourceLocationE")
  //</editor-fold>
  public ExplicitSpecializationVisibilityChecker(final Sema /*&*/ S, SourceLocation Loc) {
    // : S(S), Loc(Loc), Modules() 
    //START JInit
    this./*&*/S=/*&*/S;
    this.Loc = new SourceLocation(Loc);
    this.Modules = new SmallVector<Module /*P*/>(8, (Module /*P*/)null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::check">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8637,
   FQN="ExplicitSpecializationVisibilityChecker::check", NM="_ZN39ExplicitSpecializationVisibilityChecker5checkEPN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker5checkEPN5clang9NamedDeclE")
  //</editor-fold>
  public void check(NamedDecl /*P*/ ND) {
    {
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
      if ((FD != null)) {
        checkImpl(FD);
        /*JAVA:return*/return;
      }
    }
    {
      CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(ND);
      if ((RD != null)) {
        checkImpl(RD);
        /*JAVA:return*/return;
      }
    }
    {
      VarDecl /*P*/ VD = dyn_cast_VarDecl(ND);
      if ((VD != null)) {
        checkImpl(VD);
        /*JAVA:return*/return;
      }
    }
    {
      EnumDecl /*P*/ ED = dyn_cast_EnumDecl(ND);
      if ((ED != null)) {
        checkImpl(ED);
        /*JAVA:return*/return;
      }
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::diagnose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8649,
   FQN="ExplicitSpecializationVisibilityChecker::diagnose", NM="_ZN39ExplicitSpecializationVisibilityChecker8diagnoseEPN5clang9NamedDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker8diagnoseEPN5clang9NamedDeclEb")
  //</editor-fold>
  private void diagnose(NamedDecl /*P*/ D, boolean IsPartialSpec) {
    MissingImportKind Kind = IsPartialSpec ? Sema.MissingImportKind.PartialSpecialization : Sema.MissingImportKind.ExplicitSpecialization;
    /*const*/boolean Recover = true;
    
    // If we got a custom set of modules (because only a subset of the
    // declarations are interesting), use them, otherwise let
    // diagnoseMissingImport intelligently pick some.
    if (Modules.empty()) {
      S.diagnoseMissingImport(new SourceLocation(Loc), D, Kind, Recover);
    } else {
      S.diagnoseMissingImport(new SourceLocation(Loc), D, D.getLocation(), new ArrayRef<Module /*P*/ >(Modules, true), Kind, Recover);
    }
  }

  
  // Check a specific declaration. There are three problematic cases:
  //
  //  1) The declaration is an explicit specialization of a template
  //     specialization.
  //  2) The declaration is an explicit specialization of a member of an
  //     templated class.
  //  3) The declaration is an instantiation of a template, and that template
  //     is an explicit specialization of a member of a templated class.
  //
  // We don't need to go any deeper than that, as the instantiation of the
  // surrounding class / etc is not triggered by whatever triggered this
  // instantiation, and thus should be checked elsewhere.
  /*template <typename SpecDecl> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*replaced by specializations*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8676,
   FQN="ExplicitSpecializationVisibilityChecker::checkImpl", NM="Tpl__ZN39ExplicitSpecializationVisibilityChecker9checkImplEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=Tpl__ZN39ExplicitSpecializationVisibilityChecker9checkImplEPT_")
  //</editor-fold>
  private </*typename*/ SpecDecl extends NamedDecl> void checkImpl(SpecDecl /*P*/ Spec) {
    throw new UnsupportedOperationException("Specialization checkImpl$... must be used. Or generate new specialization");
  }

  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkImpl">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8676,
   FQN="ExplicitSpecializationVisibilityChecker::checkImpl", NM="_ZN39ExplicitSpecializationVisibilityChecker9checkImplIN5clang12FunctionDeclEEEvPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker9checkImplIN5clang12FunctionDeclEEEvPT_")
  //</editor-fold>
  private void checkImpl(FunctionDecl /*P*/ Spec) {
    boolean IsHiddenExplicitSpecialization = false;
    if (Native.$eq(Spec.getTemplateSpecializationKind(), TemplateSpecializationKind.TSK_ExplicitSpecialization)) {
      IsHiddenExplicitSpecialization
         = $bool(Spec.getMemberSpecializationInfo()) ? Native.$not(S.hasVisibleMemberSpecialization(Spec, $AddrOf(Modules))) : Native.$not(S.hasVisibleDeclaration(Spec));
    } else {
      checkInstantiated(Spec);
    }
    if (IsHiddenExplicitSpecialization) {
      diagnose(Spec.getMostRecentDecl(), false);
    }
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkImpl">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8676,
   FQN="ExplicitSpecializationVisibilityChecker::checkImpl", NM="_ZN39ExplicitSpecializationVisibilityChecker9checkImplIN5clang13CXXRecordDeclEEEvPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker9checkImplIN5clang13CXXRecordDeclEEEvPT_")
  //</editor-fold>
  private void checkImpl(CXXRecordDecl /*P*/ Spec) {
    boolean IsHiddenExplicitSpecialization = false;
    if (Native.$eq(Spec.getTemplateSpecializationKind(), TemplateSpecializationKind.TSK_ExplicitSpecialization)) {
      IsHiddenExplicitSpecialization
         = $bool(Spec.getMemberSpecializationInfo()) ? Native.$not(S.hasVisibleMemberSpecialization(Spec, $AddrOf(Modules))) : Native.$not(S.hasVisibleDeclaration(Spec));
    } else {
      checkInstantiated(Spec);
    }
    if (IsHiddenExplicitSpecialization) {
      diagnose(Spec.getMostRecentDecl(), false);
    }
  }
    
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkImpl">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8676,
   FQN="ExplicitSpecializationVisibilityChecker::checkImpl", NM="_ZN39ExplicitSpecializationVisibilityChecker9checkImplIN5clang7VarDeclEEEvPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker9checkImplIN5clang7VarDeclEEEvPT_")
  //</editor-fold>
  private void checkImpl(VarDecl /*P*/ Spec) {
    boolean IsHiddenExplicitSpecialization = false;
    if (Native.$eq(Spec.getTemplateSpecializationKind(), TemplateSpecializationKind.TSK_ExplicitSpecialization)) {
      IsHiddenExplicitSpecialization
         = $bool(Spec.getMemberSpecializationInfo()) ? Native.$not(S.hasVisibleMemberSpecialization(Spec, $AddrOf(Modules))) : Native.$not(S.hasVisibleDeclaration(Spec));
    } else {
      checkInstantiated(Spec);
    }
    if (IsHiddenExplicitSpecialization) {
      diagnose(Spec.getMostRecentDecl(), false);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkImpl">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8676,
   FQN="ExplicitSpecializationVisibilityChecker::checkImpl", NM="_ZN39ExplicitSpecializationVisibilityChecker9checkImplIN5clang8EnumDeclEEEvPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker9checkImplIN5clang8EnumDeclEEEvPT_")
  //</editor-fold>
  private void checkImpl(EnumDecl /*P*/ Spec) {
    boolean IsHiddenExplicitSpecialization = false;
    if (Native.$eq(Spec.getTemplateSpecializationKind(), TemplateSpecializationKind.TSK_ExplicitSpecialization)) {
      IsHiddenExplicitSpecialization
         = $bool(Spec.getMemberSpecializationInfo()) ? Native.$not(S.hasVisibleMemberSpecialization(Spec, $AddrOf(Modules))) : Native.$not(S.hasVisibleDeclaration(Spec));
    } else {
      checkInstantiated(Spec);
    }
    if (IsHiddenExplicitSpecialization) {
      diagnose(Spec.getMostRecentDecl(), false);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8691,
   FQN="ExplicitSpecializationVisibilityChecker::checkInstantiated", NM="_ZN39ExplicitSpecializationVisibilityChecker17checkInstantiatedEPN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker17checkInstantiatedEPN5clang12FunctionDeclE")
  //</editor-fold>
  private void checkInstantiated(FunctionDecl /*P*/ FD) {
    {
      FunctionTemplateDecl /*P*/ TD = FD.getPrimaryTemplate();
      if ((TD != null)) {
        checkTemplate(TD);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8696,
   FQN="ExplicitSpecializationVisibilityChecker::checkInstantiated", NM="_ZN39ExplicitSpecializationVisibilityChecker17checkInstantiatedEPN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker17checkInstantiatedEPN5clang13CXXRecordDeclE")
  //</editor-fold>
  private void checkInstantiated(CXXRecordDecl /*P*/ RD) {
    ClassTemplateSpecializationDecl /*P*/ SD = dyn_cast_ClassTemplateSpecializationDecl(RD);
    if (!(SD != null)) {
      return;
    }
    
    PointerUnion<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ > From = SD.getSpecializedTemplateOrPartial();
    {
      ClassTemplateDecl /*P*/ TD = From.dyn_cast(ClassTemplateDecl /*P*/.class);
      if ((TD != null)) {
        checkTemplate(TD);
      } else {
        ClassTemplatePartialSpecializationDecl /*P*/ TD$1 = From.dyn_cast(ClassTemplatePartialSpecializationDecl /*P*/.class);
        if ((TD$1 != null)) {
          if (!S.hasVisibleDeclaration(TD$1)) {
            diagnose(TD$1, true);
          }
          checkTemplate(TD$1);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8712,
   FQN="ExplicitSpecializationVisibilityChecker::checkInstantiated", NM="_ZN39ExplicitSpecializationVisibilityChecker17checkInstantiatedEPN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker17checkInstantiatedEPN5clang7VarDeclE")
  //</editor-fold>
  private void checkInstantiated(VarDecl /*P*/ RD) {
    VarTemplateSpecializationDecl /*P*/ SD = dyn_cast_VarTemplateSpecializationDecl(RD);
    if (!(SD != null)) {
      return;
    }
    
    PointerUnion<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ > From = SD.getSpecializedTemplateOrPartial();
    {
      VarTemplateDecl /*P*/ TD = From.dyn_cast(VarTemplateDecl /*P*/.class);
      if ((TD != null)) {
        checkTemplate(TD);
      } else {
        VarTemplatePartialSpecializationDecl /*P*/ TD$1 = From.dyn_cast(VarTemplatePartialSpecializationDecl /*P*/.class);
        if ((TD$1 != null)) {
          if (!S.hasVisibleDeclaration(TD$1)) {
            diagnose(TD$1, true);
          }
          checkTemplate(TD$1);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkInstantiated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8728,
   FQN="ExplicitSpecializationVisibilityChecker::checkInstantiated", NM="_ZN39ExplicitSpecializationVisibilityChecker17checkInstantiatedEPN5clang8EnumDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker17checkInstantiatedEPN5clang8EnumDeclE")
  //</editor-fold>
  private void checkInstantiated(EnumDecl /*P*/ FD) {
  }

  
  /*template <typename TemplDecl> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8731,
   FQN="ExplicitSpecializationVisibilityChecker::checkTemplate", NM="Tpl__ZN39ExplicitSpecializationVisibilityChecker13checkTemplateEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=Tpl__ZN39ExplicitSpecializationVisibilityChecker13checkTemplateEPT_")
  //</editor-fold>
  private </*typename*/ TemplDecl extends NamedDecl> void checkTemplate(TemplDecl /*P*/ TD) {
    throw new UnsupportedOperationException("Specialization checkImpl$... must be used. Or generate new specialization");
  }
  
    //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkTemplate">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8731,
   FQN="ExplicitSpecializationVisibilityChecker::checkTemplate", NM="_ZN39ExplicitSpecializationVisibilityChecker13checkTemplateIN5clang17ClassTemplateDeclEEEvPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker13checkTemplateIN5clang17ClassTemplateDeclEEEvPT_")
  //</editor-fold>
  private void checkTemplate(RedeclarableTemplateDecl /*P*/ TD) {
    if (TD.isMemberSpecialization()) {
      if (Native.$not(S.hasVisibleMemberSpecialization(TD, $AddrOf(Modules)))) {
        diagnose(TD.getMostRecentDecl(), false);
      }
    }
  }
  
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkTemplate">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8731,
   FQN="ExplicitSpecializationVisibilityChecker::checkTemplate", NM="_ZN39ExplicitSpecializationVisibilityChecker13checkTemplateIN5clang38ClassTemplatePartialSpecializationDeclEEEvPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker13checkTemplateIN5clang38ClassTemplatePartialSpecializationDeclEEEvPT_")
  //</editor-fold>
  private void checkTemplate(ClassTemplatePartialSpecializationDecl /*P*/ TD) {
    if (TD.isMemberSpecialization()) {
      if (Native.$not(S.hasVisibleMemberSpecialization(TD, $AddrOf(Modules)))) {
        diagnose(TD.getMostRecentDecl(), false);
      }
    }
  }
  
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::checkTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8731,
   FQN="ExplicitSpecializationVisibilityChecker::checkTemplate", NM="_ZN39ExplicitSpecializationVisibilityChecker13checkTemplateIN5clang36VarTemplatePartialSpecializationDeclEEEvPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityChecker13checkTemplateIN5clang36VarTemplatePartialSpecializationDeclEEEvPT_")
  //</editor-fold>
  private void checkTemplate(VarTemplatePartialSpecializationDecl /*P*/ TD) {
    if (TD.isMemberSpecialization()) {
      if (Native.$not(S.hasVisibleMemberSpecialization(TD, $AddrOf(Modules)))) {
        diagnose(TD.getMostRecentDecl(), false);
      }
    }
  }
  
  //<editor-fold defaultstate="collapsed" desc="ExplicitSpecializationVisibilityChecker::~ExplicitSpecializationVisibilityChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8628,
   FQN="ExplicitSpecializationVisibilityChecker::~ExplicitSpecializationVisibilityChecker", NM="_ZN39ExplicitSpecializationVisibilityCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN39ExplicitSpecializationVisibilityCheckerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Modules.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", Modules=" + Modules; // NOI18N
  }
}
