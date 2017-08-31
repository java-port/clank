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
import static org.clank.support.Native.$tryClone;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.ast.java.TemplateSpecializationTypeLocBase;

//<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1442,
 FQN="clang::TemplateSpecializationTypeLoc", NM="_ZN5clang29TemplateSpecializationTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang29TemplateSpecializationTypeLocE")
//</editor-fold>
public class TemplateSpecializationTypeLoc extends /*public*/ Concrete$UnqualTypeLoc<TemplateSpecializationTypeLoc, TemplateSpecializationType, TemplateSpecializationLocInfo> implements TemplateSpecializationTypeLocBase {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::getTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1448,
   FQN="clang::TemplateSpecializationTypeLoc::getTemplateKeywordLoc", NM="_ZNK5clang29TemplateSpecializationTypeLoc21getTemplateKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang29TemplateSpecializationTypeLoc21getTemplateKeywordLocEv")
  //</editor-fold>
  public SourceLocation getTemplateKeywordLoc() /*const*/ {
    return new SourceLocation(getLocalData().TemplateKWLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::setTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1451,
   FQN="clang::TemplateSpecializationTypeLoc::setTemplateKeywordLoc", NM="_ZN5clang29TemplateSpecializationTypeLoc21setTemplateKeywordLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang29TemplateSpecializationTypeLoc21setTemplateKeywordLocENS_14SourceLocationE")
  //</editor-fold>
  public void setTemplateKeywordLoc(SourceLocation Loc) {
    getLocalData().TemplateKWLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::getLAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1455,
   FQN="clang::TemplateSpecializationTypeLoc::getLAngleLoc", NM="_ZNK5clang29TemplateSpecializationTypeLoc12getLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang29TemplateSpecializationTypeLoc12getLAngleLocEv")
  //</editor-fold>
  public SourceLocation getLAngleLoc() /*const*/ {
    return new SourceLocation(getLocalData().LAngleLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::setLAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1458,
   FQN="clang::TemplateSpecializationTypeLoc::setLAngleLoc", NM="_ZN5clang29TemplateSpecializationTypeLoc12setLAngleLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang29TemplateSpecializationTypeLoc12setLAngleLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLAngleLoc(SourceLocation Loc) {
    getLocalData().LAngleLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::getRAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1462,
   FQN="clang::TemplateSpecializationTypeLoc::getRAngleLoc", NM="_ZNK5clang29TemplateSpecializationTypeLoc12getRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang29TemplateSpecializationTypeLoc12getRAngleLocEv")
  //</editor-fold>
  public SourceLocation getRAngleLoc() /*const*/ {
    return new SourceLocation(getLocalData().RAngleLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::setRAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1465,
   FQN="clang::TemplateSpecializationTypeLoc::setRAngleLoc", NM="_ZN5clang29TemplateSpecializationTypeLoc12setRAngleLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang29TemplateSpecializationTypeLoc12setRAngleLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRAngleLoc(SourceLocation Loc) {
    getLocalData().RAngleLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1469,
   FQN="clang::TemplateSpecializationTypeLoc::getNumArgs", NM="_ZNK5clang29TemplateSpecializationTypeLoc10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang29TemplateSpecializationTypeLoc10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return getTypePtr().getNumArgs();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::setArgLocInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1472,
   FQN="clang::TemplateSpecializationTypeLoc::setArgLocInfo", NM="_ZN5clang29TemplateSpecializationTypeLoc13setArgLocInfoEjNS_23TemplateArgumentLocInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang29TemplateSpecializationTypeLoc13setArgLocInfoEjNS_23TemplateArgumentLocInfoE")
  //</editor-fold>
  public void setArgLocInfo(/*uint*/int i, TemplateArgumentLocInfo AI) {
    getArgInfos().$set(i, $tryClone(AI));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::getArgLocInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1475,
   FQN="clang::TemplateSpecializationTypeLoc::getArgLocInfo", NM="_ZNK5clang29TemplateSpecializationTypeLoc13getArgLocInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang29TemplateSpecializationTypeLoc13getArgLocInfoEj")
  //</editor-fold>
  public TemplateArgumentLocInfo getArgLocInfo(/*uint*/int i) /*const*/ {
    return new TemplateArgumentLocInfo(getArgInfos().$at(i));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::getArgLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1479,
   FQN="clang::TemplateSpecializationTypeLoc::getArgLoc", NM="_ZNK5clang29TemplateSpecializationTypeLoc9getArgLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang29TemplateSpecializationTypeLoc9getArgLocEj")
  //</editor-fold>
  public TemplateArgumentLoc getArgLoc(/*uint*/int i) /*const*/ {
    return new TemplateArgumentLoc(getTypePtr().getArg(i), getArgLocInfo(i));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::getTemplateNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1483,
   FQN="clang::TemplateSpecializationTypeLoc::getTemplateNameLoc", NM="_ZNK5clang29TemplateSpecializationTypeLoc18getTemplateNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang29TemplateSpecializationTypeLoc18getTemplateNameLocEv")
  //</editor-fold>
  public SourceLocation getTemplateNameLoc() /*const*/ {
    return new SourceLocation(getLocalData().NameLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::setTemplateNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1486,
   FQN="clang::TemplateSpecializationTypeLoc::setTemplateNameLoc", NM="_ZN5clang29TemplateSpecializationTypeLoc18setTemplateNameLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang29TemplateSpecializationTypeLoc18setTemplateNameLocENS_14SourceLocationE")
  //</editor-fold>
  public void setTemplateNameLoc(SourceLocation Loc) {
    getLocalData().NameLoc.$assign(Loc);
  }

  
  /// \brief - Copy the location information from the given info.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::copy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1491,
   FQN="clang::TemplateSpecializationTypeLoc::copy", NM="_ZN5clang29TemplateSpecializationTypeLoc4copyES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang29TemplateSpecializationTypeLoc4copyES0_")
  //</editor-fold>
  public void copy(TemplateSpecializationTypeLoc Loc) {
    /*uint*/int size = getFullDataSize();
    assert (size == Loc.getFullDataSize());
    
    // We're potentially copying Expr references here.  We don't
    // bother retaining them because TypeSourceInfos live forever, so
    // as long as the Expr was retained when originally written into
    // the TypeLoc, we're okay.
    memcpy(Data, Loc.Data, size, TypeLoc.DATA_DEEP_COPY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1502,
   FQN="clang::TemplateSpecializationTypeLoc::getLocalSourceRange", NM="_ZNK5clang29TemplateSpecializationTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang29TemplateSpecializationTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    if (getTemplateKeywordLoc().isValid()) {
      return new SourceRange(getTemplateKeywordLoc(), getRAngleLoc());
    } else {
      return new SourceRange(getTemplateNameLoc(), getRAngleLoc());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1509,
   FQN="clang::TemplateSpecializationTypeLoc::initializeLocal", NM="_ZN5clang29TemplateSpecializationTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang29TemplateSpecializationTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {
    setTemplateKeywordLoc(/*NO_COPY*/Loc);
    setTemplateNameLoc(/*NO_COPY*/Loc);
    setLAngleLoc(/*NO_COPY*/Loc);
    setRAngleLoc(/*NO_COPY*/Loc);
    initializeArgLocs(Context, getNumArgs(), getTypePtr().getArgs(), 
        getArgInfos(), /*NO_COPY*/Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::initializeArgLocs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 453,
   FQN="clang::TemplateSpecializationTypeLoc::initializeArgLocs", NM="_ZN5clang29TemplateSpecializationTypeLoc17initializeArgLocsERNS_10ASTContextEjPKNS_16TemplateArgumentEPNS_23TemplateArgumentLocInfoENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang29TemplateSpecializationTypeLoc17initializeArgLocsERNS_10ASTContextEjPKNS_16TemplateArgumentEPNS_23TemplateArgumentLocInfoENS_14SourceLocationE")
  //</editor-fold>
  public static void initializeArgLocs(final ASTContext /*&*/ Context, 
                   /*uint*/int NumArgs, 
                   /*const*/type$ptr<TemplateArgument/*P*/> Args, 
                   type$ptr<TemplateArgumentLocInfo /*P*/> ArgInfos, 
                   SourceLocation Loc) {
    for (/*uint*/int i = 0, e = NumArgs; i != e; ++i) {
      switch (Args.$at(i).getKind()) {
       case Null:
        throw new llvm_unreachable("Impossible TemplateArgument");
       case Integral:
       case Declaration:
       case NullPtr:
        ArgInfos.$at(i).$assignMove(new TemplateArgumentLocInfo());
              //[i].$assignMove(new TemplateArgumentLocInfo());
        break;
       case Expression:
        ArgInfos.$at(i).$assignMove(new TemplateArgumentLocInfo(Args.$at(i).getAsExpr()));
              //[i].$assignMove(new TemplateArgumentLocInfo(Args.$at(i).getAsExpr()));
        break;
       case Type:
        ArgInfos.$at(i).$assignMove(new TemplateArgumentLocInfo(Context.getTrivialTypeSourceInfo(Args.$at(i).getAsType(), new SourceLocation(Loc))));
              //[i].$assignMove(new TemplateArgumentLocInfo(Context.getTrivialTypeSourceInfo(Args.$at(i).getAsType(), new SourceLocation(Loc))));
        break;
       case Template:
       case TemplateExpansion:
        {
          NestedNameSpecifierLocBuilder Builder = null;
          try {
            Builder/*J*/= new NestedNameSpecifierLocBuilder();
            TemplateName Template = Args.$at(i).getAsTemplateOrTemplatePattern();
            {
              DependentTemplateName /*P*/ DTN = Template.getAsDependentTemplateName();
              if ((DTN != null)) {
                Builder.MakeTrivial(Context, DTN.getQualifier(), new SourceRange(/*NO_COPY*/Loc));
              } else {
                QualifiedTemplateName /*P*/ QTN = Template.getAsQualifiedTemplateName();
                if ((QTN != null)) {
                  Builder.MakeTrivial(Context, QTN.getQualifier(), new SourceRange(/*NO_COPY*/Loc));
                }
              }
            }
            
            ArgInfos.$at(i).$assignMove(new TemplateArgumentLocInfo(Builder.getWithLocInContext(Context), new SourceLocation(Loc), Args.$at(i).getKind() == TemplateArgument.ArgKind.Template ? new SourceLocation() : new SourceLocation(Loc)));
                  //[i].$assignMove(new TemplateArgumentLocInfo(Builder.getWithLocInContext(Context), new SourceLocation(Loc), Args.$at(i).getKind() == TemplateArgument.ArgKind.Template ? new SourceLocation() : new SourceLocation(Loc)));
            break;
          } finally {
            if (Builder != null) { Builder.$destroy(); }
          }
        }
       case Pack:
        ArgInfos.$at(i).$assignMove(new TemplateArgumentLocInfo());
              //[i].$assignMove(new TemplateArgumentLocInfo());
        break;
      }
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::getExtraLocalDataSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1523,
   FQN="clang::TemplateSpecializationTypeLoc::getExtraLocalDataSize", NM="_ZNK5clang29TemplateSpecializationTypeLoc21getExtraLocalDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang29TemplateSpecializationTypeLoc21getExtraLocalDataSizeEv")
  //</editor-fold>
  public /*uint*/int getExtraLocalDataSize() /*const*/ {
    return getNumArgs() * $sizeof_TemplateArgumentLocInfo();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::getExtraLocalDataAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1527,
   FQN="clang::TemplateSpecializationTypeLoc::getExtraLocalDataAlignment", NM="_ZNK5clang29TemplateSpecializationTypeLoc26getExtraLocalDataAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang29TemplateSpecializationTypeLoc26getExtraLocalDataAlignmentEv")
  //</editor-fold>
  public /*uint*/int getExtraLocalDataAlignment() /*const*/ {
    return alignOf(TemplateArgumentLocInfo.class);
  }
  
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::getArgInfos">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1532,
   FQN="clang::TemplateSpecializationTypeLoc::getArgInfos", NM="_ZNK5clang29TemplateSpecializationTypeLoc11getArgInfosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang29TemplateSpecializationTypeLoc11getArgInfosEv")
  //</editor-fold>
  private type$ptr<TemplateArgumentLocInfo /*P*/> getArgInfos() /*const*/ {
    return ((/*static_cast*/type$ptr<TemplateArgumentLocInfo /*P*/>  )(getExtraLocalData()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::TemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1442,
   FQN="clang::TemplateSpecializationTypeLoc::TemplateSpecializationTypeLoc", NM="_ZN5clang29TemplateSpecializationTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang29TemplateSpecializationTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ TemplateSpecializationTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, TemplateSpecializationTypeLoc, TemplateSpecializationType, TemplateSpecializationLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::TemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1442,
   FQN="clang::TemplateSpecializationTypeLoc::TemplateSpecializationTypeLoc", NM="_ZN5clang29TemplateSpecializationTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang29TemplateSpecializationTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TemplateSpecializationTypeLoc(final /*const*/ TemplateSpecializationTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, TemplateSpecializationTypeLoc, TemplateSpecializationType, TemplateSpecializationLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateSpecializationTypeLoc::TemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1442,
   FQN="clang::TemplateSpecializationTypeLoc::TemplateSpecializationTypeLoc", NM="_ZN5clang29TemplateSpecializationTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang29TemplateSpecializationTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ TemplateSpecializationTypeLoc(JD$Move _dparam, final TemplateSpecializationTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, TemplateSpecializationTypeLoc, TemplateSpecializationType, TemplateSpecializationLocInfo>(static_cast<TemplateSpecializationTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  protected void initJavaExtraLocalData(type$ptr extraLocalData$Ptr, int NumExtra) {
    assert NumExtra == getNumArgs() : "expect request for extra data for arguments pointers only";
    // as extra data we keep TemplateArgumentLocInfo pointers, check that array size is enough and contains nulls
    for (int idx = 0; idx < NumExtra; idx++) {
      assert extraLocalData$Ptr.$at(idx) == null : "must be not occupied placeholder for TemplateArgumentLocInfo *";
      extraLocalData$Ptr.$set(idx, new TemplateArgumentLocInfo());
    }
  }
  
  protected static int $sizeof_TemplateArgumentLocInfo() { 
    return 1; 
  }
  
  @Override
  protected TemplateSpecializationLocInfo createJavaEmptyLocalTypeLocInfo() {
    return new TemplateSpecializationLocInfo();
  }
  
  @Override
  protected Class<TemplateSpecializationType> getTypeClass() {
    return TemplateSpecializationType.class;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
