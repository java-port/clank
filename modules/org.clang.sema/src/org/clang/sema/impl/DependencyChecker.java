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
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// A class which looks for a use of a certain level of template
/// parameter.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1529,
 FQN="(anonymous namespace)::DependencyChecker", NM="_ZN12_GLOBAL__N_117DependencyCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_117DependencyCheckerE")
//</editor-fold>
public class/*struct*/ DependencyChecker implements RecursiveASTVisitor<DependencyChecker> {
  /*typedef RecursiveASTVisitor<DependencyChecker> super*/
//  public final class super extends RecursiveASTVisitor<DependencyChecker>{ };
  
  public /*uint*/int Depth;
  public boolean Match;
  public SourceLocation MatchLoc;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyChecker::DependencyChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1536,
   FQN="(anonymous namespace)::DependencyChecker::DependencyChecker", NM="_ZN12_GLOBAL__N_117DependencyCheckerC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_117DependencyCheckerC1Ej")
  //</editor-fold>
  public DependencyChecker(/*uint*/int Depth) {
    // : RecursiveASTVisitor<DependencyChecker>(), Depth(Depth), Match(false), MatchLoc() 
    //START JInit
    $RecursiveASTVisitor();
    this.Depth = Depth;
    this.Match = false;
    this.MatchLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyChecker::DependencyChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1538,
   FQN="(anonymous namespace)::DependencyChecker::DependencyChecker", NM="_ZN12_GLOBAL__N_117DependencyCheckerC1EPN5clang21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_117DependencyCheckerC1EPN5clang21TemplateParameterListE")
  //</editor-fold>
  public DependencyChecker(TemplateParameterList /*P*/ Params) {
    // : RecursiveASTVisitor<DependencyChecker>(), Match(false), MatchLoc() 
    //START JInit
    $RecursiveASTVisitor();
    this.Match = false;
    this.MatchLoc = new SourceLocation();
    //END JInit
    NamedDecl/*P*/ ND = Params.getParam(0);
    {
      TemplateTypeParmDecl /*P*/ PD = dyn_cast_TemplateTypeParmDecl(ND);
      if ((PD != null)) {
        Depth = PD.getDepth();
      } else {
        NonTypeTemplateParmDecl /*P*/ PD$1 = dyn_cast_NonTypeTemplateParmDecl(ND);
        if ((PD$1 != null)) {
          Depth = PD$1.getDepth();
        } else {
          Depth = cast_TemplateTemplateParmDecl(ND).getDepth();
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyChecker::Matches">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1550,
   FQN="(anonymous namespace)::DependencyChecker::Matches", NM="_ZN12_GLOBAL__N_117DependencyChecker7MatchesEjN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_117DependencyChecker7MatchesEjN5clang14SourceLocationE")
  //</editor-fold>
  public boolean Matches(/*uint*/int ParmDepth) {
    return Matches(ParmDepth, new SourceLocation());
  }
  public boolean Matches(/*uint*/int ParmDepth, SourceLocation Loc/*= SourceLocation()*/) {
    if ($greatereq_uint(ParmDepth, Depth)) {
      Match = true;
      MatchLoc.$assign(Loc);
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyChecker::VisitTemplateTypeParmTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1559,
   FQN="(anonymous namespace)::DependencyChecker::VisitTemplateTypeParmTypeLoc", NM="_ZN12_GLOBAL__N_117DependencyChecker28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_117DependencyChecker28VisitTemplateTypeParmTypeLocEN5clang23TemplateTypeParmTypeLocE")
  //</editor-fold>
  public boolean VisitTemplateTypeParmTypeLoc(TemplateTypeParmTypeLoc TL) {
    return !Matches(TL.getTypePtr().getDepth(), TL.getNameLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyChecker::VisitTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1563,
   FQN="(anonymous namespace)::DependencyChecker::VisitTemplateTypeParmType", NM="_ZN12_GLOBAL__N_117DependencyChecker25VisitTemplateTypeParmTypeEPKN5clang20TemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_117DependencyChecker25VisitTemplateTypeParmTypeEPKN5clang20TemplateTypeParmTypeE")
  //</editor-fold>
  public boolean VisitTemplateTypeParmType(/*const*/ TemplateTypeParmType /*P*/ T) {
    return !Matches(T.getDepth());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyChecker::TraverseTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1567,
   FQN="(anonymous namespace)::DependencyChecker::TraverseTemplateName", NM="_ZN12_GLOBAL__N_117DependencyChecker20TraverseTemplateNameEN5clang12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_117DependencyChecker20TraverseTemplateNameEN5clang12TemplateNameE")
  //</editor-fold>
  public boolean TraverseTemplateName(TemplateName N) {
    {
      TemplateTemplateParmDecl /*P*/ PD = dyn_cast_or_null_TemplateTemplateParmDecl(N.getAsTemplateDecl());
      if ((PD != null)) {
        if (Matches(PD.getDepth())) {
          return false;
        }
      }
    }
    return RecursiveASTVisitor.super.TraverseTemplateName(new TemplateName(N));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyChecker::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1575,
   FQN="(anonymous namespace)::DependencyChecker::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_117DependencyChecker16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_117DependencyChecker16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public boolean VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    {
      NonTypeTemplateParmDecl /*P*/ PD = dyn_cast_NonTypeTemplateParmDecl(E.getDecl());
      if ((PD != null)) {
        if (Matches(PD.getDepth(), E.getExprLoc())) {
          return false;
        }
      }
    }
    return RecursiveASTVisitor.super.VisitDeclRefExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyChecker::VisitSubstTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1583,
   FQN="(anonymous namespace)::DependencyChecker::VisitSubstTemplateTypeParmType", NM="_ZN12_GLOBAL__N_117DependencyChecker30VisitSubstTemplateTypeParmTypeEPKN5clang25SubstTemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_117DependencyChecker30VisitSubstTemplateTypeParmTypeEPKN5clang25SubstTemplateTypeParmTypeE")
  //</editor-fold>
  public boolean VisitSubstTemplateTypeParmType(/*const*/ SubstTemplateTypeParmType /*P*/ T) {
    return TraverseType(T.getReplacementType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyChecker::VisitSubstTemplateTypeParmPackType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1587,
   FQN="(anonymous namespace)::DependencyChecker::VisitSubstTemplateTypeParmPackType", NM="_ZN12_GLOBAL__N_117DependencyChecker34VisitSubstTemplateTypeParmPackTypeEPKN5clang29SubstTemplateTypeParmPackTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_117DependencyChecker34VisitSubstTemplateTypeParmPackTypeEPKN5clang29SubstTemplateTypeParmPackTypeE")
  //</editor-fold>
  public boolean VisitSubstTemplateTypeParmPackType(/*const*/ SubstTemplateTypeParmPackType /*P*/ T) {
    return TraverseTemplateArgument(T.getArgumentPack());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyChecker::TraverseInjectedClassNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1592,
   FQN="(anonymous namespace)::DependencyChecker::TraverseInjectedClassNameType", NM="_ZN12_GLOBAL__N_117DependencyChecker29TraverseInjectedClassNameTypeEPKN5clang21InjectedClassNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_117DependencyChecker29TraverseInjectedClassNameTypeEPKN5clang21InjectedClassNameTypeE")
  //</editor-fold>
  public boolean TraverseInjectedClassNameType(/*const*/ InjectedClassNameType /*P*/ T) {
    return TraverseType(T.getInjectedSpecializationType());
  }

  @Override
  public boolean has_overridden_traverse_with_queue_method(String TraverseMethodName) {
    return false;
  }
  
  @Override public String toString() {
    return "" + "Depth=" + Depth // NOI18N
              + ", Match=" + Match // NOI18N
              + ", MatchLoc=" + MatchLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
