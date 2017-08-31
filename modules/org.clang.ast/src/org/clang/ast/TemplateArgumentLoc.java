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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.basic.*;


/// Location wrapper for a TemplateArgument.  TemplateArgument is to
/// TemplateArgumentLoc as Type is to TypeLoc.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 427,
 FQN="clang::TemplateArgumentLoc", NM="_ZN5clang19TemplateArgumentLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang19TemplateArgumentLocE")
//</editor-fold>
public class TemplateArgumentLoc implements NativePOD<TemplateArgumentLoc> {
  private TemplateArgument Argument;
  private TemplateArgumentLocInfo LocInfo;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::TemplateArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 432,
   FQN="clang::TemplateArgumentLoc::TemplateArgumentLoc", NM="_ZN5clang19TemplateArgumentLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang19TemplateArgumentLocC1Ev")
  //</editor-fold>
  public TemplateArgumentLoc() {
    // : Argument(), LocInfo() 
    //START JInit
    this.Argument = new TemplateArgument();
    this.LocInfo = new TemplateArgumentLocInfo();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::TemplateArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 434,
   FQN="clang::TemplateArgumentLoc::TemplateArgumentLoc", NM="_ZN5clang19TemplateArgumentLocC1ERKNS_16TemplateArgumentENS_23TemplateArgumentLocInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang19TemplateArgumentLocC1ERKNS_16TemplateArgumentENS_23TemplateArgumentLocInfoE")
  //</editor-fold>
  public TemplateArgumentLoc(final /*const*/ TemplateArgument /*&*/ Argument, 
      TemplateArgumentLocInfo Opaque) {
    // : Argument(Argument), LocInfo(Opaque) 
    //START JInit
    this.Argument = new TemplateArgument(Argument);
    this.LocInfo = new TemplateArgumentLocInfo(Opaque);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::TemplateArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 439,
   FQN="clang::TemplateArgumentLoc::TemplateArgumentLoc", NM="_ZN5clang19TemplateArgumentLocC1ERKNS_16TemplateArgumentEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang19TemplateArgumentLocC1ERKNS_16TemplateArgumentEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public TemplateArgumentLoc(final /*const*/ TemplateArgument /*&*/ Argument, TypeSourceInfo /*P*/ TInfo) {
    // : Argument(Argument), LocInfo(TInfo) 
    //START JInit
    this.Argument = new TemplateArgument(Argument);
    this.LocInfo = new TemplateArgumentLocInfo(TInfo);
    //END JInit
    assert (Argument.getKind() == TemplateArgument.ArgKind.Type);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::TemplateArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 444,
   FQN="clang::TemplateArgumentLoc::TemplateArgumentLoc", NM="_ZN5clang19TemplateArgumentLocC1ERKNS_16TemplateArgumentEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang19TemplateArgumentLocC1ERKNS_16TemplateArgumentEPNS_4ExprE")
  //</editor-fold>
  public TemplateArgumentLoc(final /*const*/ TemplateArgument /*&*/ Argument, Expr /*P*/ E) {
    // : Argument(Argument), LocInfo(E) 
    //START JInit
    this.Argument = new TemplateArgument(Argument);
    this.LocInfo = new TemplateArgumentLocInfo(E);
    //END JInit
    assert (Argument.getKind() == TemplateArgument.ArgKind.Expression);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::TemplateArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 449,
   FQN="clang::TemplateArgumentLoc::TemplateArgumentLoc", NM="_ZN5clang19TemplateArgumentLocC1ERKNS_16TemplateArgumentENS_22NestedNameSpecifierLocENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang19TemplateArgumentLocC1ERKNS_16TemplateArgumentENS_22NestedNameSpecifierLocENS_14SourceLocationES5_")
  //</editor-fold>
  public TemplateArgumentLoc(final /*const*/ TemplateArgument /*&*/ Argument, 
      NestedNameSpecifierLoc QualifierLoc, 
      SourceLocation TemplateNameLoc) {
    this(Argument, 
      QualifierLoc, 
      TemplateNameLoc, 
      new SourceLocation());
  }
  public TemplateArgumentLoc(final /*const*/ TemplateArgument /*&*/ Argument, 
      NestedNameSpecifierLoc QualifierLoc, 
      SourceLocation TemplateNameLoc, 
      SourceLocation EllipsisLoc/*= SourceLocation()*/) {
    // : Argument(Argument), LocInfo(QualifierLoc, TemplateNameLoc, EllipsisLoc) 
    //START JInit
    this.Argument = new TemplateArgument(Argument);
    this.LocInfo = new TemplateArgumentLocInfo(new NestedNameSpecifierLoc(QualifierLoc), new SourceLocation(TemplateNameLoc), new SourceLocation(EllipsisLoc));
    //END JInit
    assert (Argument.getKind() == TemplateArgument.ArgKind.Template || Argument.getKind() == TemplateArgument.ArgKind.TemplateExpansion);
  }

  
  /// \brief - Fetches the primary location of the argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 459,
   FQN="clang::TemplateArgumentLoc::getLocation", NM="_ZNK5clang19TemplateArgumentLoc11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang19TemplateArgumentLoc11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    if (Argument.getKind() == TemplateArgument.ArgKind.Template
       || Argument.getKind() == TemplateArgument.ArgKind.TemplateExpansion) {
      return getTemplateNameLoc();
    }
    
    return getSourceRange().getBegin();
  }

  
  /// \brief - Fetches the full source range of the argument.
  
  /// \brief - Fetches the full source range of the argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 435,
   FQN="clang::TemplateArgumentLoc::getSourceRange", NM="_ZNK5clang19TemplateArgumentLoc14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang19TemplateArgumentLoc14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    switch (Argument.getKind()) {
     case Expression:
      return getSourceExpression().getSourceRange();
     case Declaration:
      return getSourceDeclExpression().getSourceRange();
     case NullPtr:
      return getSourceNullPtrExpression().getSourceRange();
     case Type:
      {
        TypeSourceInfo /*P*/ TSI = getTypeSourceInfo();
        if ((TSI != null)) {
          return TSI.getTypeLoc().getSourceRange();
        } else {
          return new SourceRange();
        }
      }
     case Template:
      if (getTemplateQualifierLoc().$bool()) {
        return new SourceRange(getTemplateQualifierLoc().getBeginLoc(), 
            getTemplateNameLoc());
      }
      return new SourceRange(getTemplateNameLoc());
     case TemplateExpansion:
      if (getTemplateQualifierLoc().$bool()) {
        return new SourceRange(getTemplateQualifierLoc().getBeginLoc(), 
            getTemplateEllipsisLoc());
      }
      return new SourceRange(getTemplateNameLoc(), getTemplateEllipsisLoc());
     case Integral:
      return getSourceIntegralExpression().getSourceRange();
     case Pack:
     case Null:
      return new SourceRange();
    }
    throw new llvm_unreachable("Invalid TemplateArgument Kind!");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::getArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 470,
   FQN="clang::TemplateArgumentLoc::getArgument", NM="_ZNK5clang19TemplateArgumentLoc11getArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang19TemplateArgumentLoc11getArgumentEv")
  //</editor-fold>
  public /*const*/ TemplateArgument /*&*/ getArgument() /*const*/ {
    return Argument;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::getLocInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 474,
   FQN="clang::TemplateArgumentLoc::getLocInfo", NM="_ZNK5clang19TemplateArgumentLoc10getLocInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang19TemplateArgumentLoc10getLocInfoEv")
  //</editor-fold>
  public TemplateArgumentLocInfo getLocInfo() /*const*/ {
    return new TemplateArgumentLocInfo(LocInfo);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 478,
   FQN="clang::TemplateArgumentLoc::getTypeSourceInfo", NM="_ZNK5clang19TemplateArgumentLoc17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang19TemplateArgumentLoc17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    assert (Argument.getKind() == TemplateArgument.ArgKind.Type);
    return LocInfo.getAsTypeSourceInfo();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::getSourceExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 483,
   FQN="clang::TemplateArgumentLoc::getSourceExpression", NM="_ZNK5clang19TemplateArgumentLoc19getSourceExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang19TemplateArgumentLoc19getSourceExpressionEv")
  //</editor-fold>
  public Expr /*P*/ getSourceExpression() /*const*/ {
    assert (Argument.getKind() == TemplateArgument.ArgKind.Expression);
    return LocInfo.getAsExpr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::getSourceDeclExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 488,
   FQN="clang::TemplateArgumentLoc::getSourceDeclExpression", NM="_ZNK5clang19TemplateArgumentLoc23getSourceDeclExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang19TemplateArgumentLoc23getSourceDeclExpressionEv")
  //</editor-fold>
  public Expr /*P*/ getSourceDeclExpression() /*const*/ {
    assert (Argument.getKind() == TemplateArgument.ArgKind.Declaration);
    return LocInfo.getAsExpr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::getSourceNullPtrExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 493,
   FQN="clang::TemplateArgumentLoc::getSourceNullPtrExpression", NM="_ZNK5clang19TemplateArgumentLoc26getSourceNullPtrExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang19TemplateArgumentLoc26getSourceNullPtrExpressionEv")
  //</editor-fold>
  public Expr /*P*/ getSourceNullPtrExpression() /*const*/ {
    assert (Argument.getKind() == TemplateArgument.ArgKind.NullPtr);
    return LocInfo.getAsExpr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::getSourceIntegralExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 498,
   FQN="clang::TemplateArgumentLoc::getSourceIntegralExpression", NM="_ZNK5clang19TemplateArgumentLoc27getSourceIntegralExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang19TemplateArgumentLoc27getSourceIntegralExpressionEv")
  //</editor-fold>
  public Expr /*P*/ getSourceIntegralExpression() /*const*/ {
    assert (Argument.getKind() == TemplateArgument.ArgKind.Integral);
    return LocInfo.getAsExpr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::getTemplateQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 503,
   FQN="clang::TemplateArgumentLoc::getTemplateQualifierLoc", NM="_ZNK5clang19TemplateArgumentLoc23getTemplateQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang19TemplateArgumentLoc23getTemplateQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getTemplateQualifierLoc() /*const*/ {
    assert (Argument.getKind() == TemplateArgument.ArgKind.Template || Argument.getKind() == TemplateArgument.ArgKind.TemplateExpansion);
    return LocInfo.getTemplateQualifierLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::getTemplateNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 509,
   FQN="clang::TemplateArgumentLoc::getTemplateNameLoc", NM="_ZNK5clang19TemplateArgumentLoc18getTemplateNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang19TemplateArgumentLoc18getTemplateNameLocEv")
  //</editor-fold>
  public SourceLocation getTemplateNameLoc() /*const*/ {
    assert (Argument.getKind() == TemplateArgument.ArgKind.Template || Argument.getKind() == TemplateArgument.ArgKind.TemplateExpansion);
    return LocInfo.getTemplateNameLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::getTemplateEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 515,
   FQN="clang::TemplateArgumentLoc::getTemplateEllipsisLoc", NM="_ZNK5clang19TemplateArgumentLoc22getTemplateEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang19TemplateArgumentLoc22getTemplateEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getTemplateEllipsisLoc() /*const*/ {
    assert (Argument.getKind() == TemplateArgument.ArgKind.TemplateExpansion);
    return LocInfo.getTemplateEllipsisLoc();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::TemplateArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 427,
   FQN="clang::TemplateArgumentLoc::TemplateArgumentLoc", NM="_ZN5clang19TemplateArgumentLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang19TemplateArgumentLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgumentLoc(final /*const*/ TemplateArgumentLoc /*&*/ $Prm0) {
    // : Argument(.Argument), LocInfo(.LocInfo) 
    //START JInit
    this.Argument = new TemplateArgument($Prm0.Argument);
    this.LocInfo = new TemplateArgumentLocInfo($Prm0.LocInfo);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::TemplateArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 427,
   FQN="clang::TemplateArgumentLoc::TemplateArgumentLoc", NM="_ZN5clang19TemplateArgumentLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang19TemplateArgumentLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgumentLoc(JD$Move _dparam, final TemplateArgumentLoc /*&&*/$Prm0) {
    // : Argument(static_cast<TemplateArgumentLoc &&>().Argument), LocInfo(static_cast<TemplateArgumentLoc &&>().LocInfo) 
    //START JInit
    this.Argument = new TemplateArgument(JD$Move.INSTANCE, $Prm0.Argument);
    this.LocInfo = new TemplateArgumentLocInfo(JD$Move.INSTANCE, $Prm0.LocInfo);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 427,
   FQN="clang::TemplateArgumentLoc::operator=", NM="_ZN5clang19TemplateArgumentLocaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang19TemplateArgumentLocaSERKS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgumentLoc /*&*/ $assign(final /*const*/ TemplateArgumentLoc /*&*/ $Prm0) {
    this.Argument.$assign($Prm0.Argument);
    this.LocInfo.$assign($Prm0.LocInfo);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 427,
   FQN="clang::TemplateArgumentLoc::operator=", NM="_ZN5clang19TemplateArgumentLocaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang19TemplateArgumentLocaSEOS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgumentLoc /*&*/ $assignMove(final TemplateArgumentLoc /*&&*/$Prm0) {
    this.Argument.$assignMove($Prm0.Argument);
    this.LocInfo.$assignMove($Prm0.LocInfo);
    return /*Deref*/this;
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public TemplateArgumentLoc clone() { return new TemplateArgumentLoc(this); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Argument=" + Argument // NOI18N
              + ", LocInfo=" + LocInfo; // NOI18N
  }
}
