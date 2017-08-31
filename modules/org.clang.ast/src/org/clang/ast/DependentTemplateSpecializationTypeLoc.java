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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import org.clang.basic.*;
import org.clang.ast.java.TemplateSpecializationTypeLocBase;
import static org.clank.support.Native.$toConst;
import static org.clank.support.Native.$tryClone;

//<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1834,
 FQN="clang::DependentTemplateSpecializationTypeLoc", NM="_ZN5clang38DependentTemplateSpecializationTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLocE")
//</editor-fold>
public class DependentTemplateSpecializationTypeLoc extends /*public*/ Concrete$UnqualTypeLoc<DependentTemplateSpecializationTypeLoc, DependentTemplateSpecializationType, DependentTemplateSpecializationLocInfo> implements TemplateSpecializationTypeLocBase {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getElaboratedKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1840,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getElaboratedKeywordLoc", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc23getElaboratedKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc23getElaboratedKeywordLocEv")
  //</editor-fold>
  public SourceLocation getElaboratedKeywordLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().ElaboratedKWLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::setElaboratedKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1843,
   FQN="clang::DependentTemplateSpecializationTypeLoc::setElaboratedKeywordLoc", NM="_ZN5clang38DependentTemplateSpecializationTypeLoc23setElaboratedKeywordLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLoc23setElaboratedKeywordLocENS_14SourceLocationE")
  //</editor-fold>
  public void setElaboratedKeywordLoc(SourceLocation Loc) {
    this.getLocalData().ElaboratedKWLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1847,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getQualifierLoc", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    if (!(getLocalData().QualifierData != null)) {
      return new NestedNameSpecifierLoc();
    }
    
    return new NestedNameSpecifierLoc(getTypePtr().getQualifier(), 
        getLocalData().QualifierData);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::setQualifierLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1855,
   FQN="clang::DependentTemplateSpecializationTypeLoc::setQualifierLoc", NM="_ZN5clang38DependentTemplateSpecializationTypeLoc15setQualifierLocENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLoc15setQualifierLocENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  public void setQualifierLoc(NestedNameSpecifierLoc QualifierLoc) {
    if (!QualifierLoc.$bool()) {
      // Even if we have a nested-name-specifier in the dependent
      // template specialization type, we won't record the nested-name-specifier
      // location information when this type-source location information is
      // part of a nested-name-specifier.
      getLocalData().QualifierData = null;
      return;
    }
    assert (QualifierLoc.getNestedNameSpecifier() == getTypePtr().getQualifier()) : "Inconsistent nested-name-specifier pointer";
    getLocalData().QualifierData = $toConst($tryClone(QualifierLoc.getOpaqueData()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1871,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getTemplateKeywordLoc", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc21getTemplateKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc21getTemplateKeywordLocEv")
  //</editor-fold>
  public SourceLocation getTemplateKeywordLoc() /*const*/ {
    return new SourceLocation(getLocalData().TemplateKWLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::setTemplateKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1874,
   FQN="clang::DependentTemplateSpecializationTypeLoc::setTemplateKeywordLoc", NM="_ZN5clang38DependentTemplateSpecializationTypeLoc21setTemplateKeywordLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLoc21setTemplateKeywordLocENS_14SourceLocationE")
  //</editor-fold>
  public void setTemplateKeywordLoc(SourceLocation Loc) {
    getLocalData().TemplateKWLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getTemplateNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1878,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getTemplateNameLoc", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc18getTemplateNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc18getTemplateNameLocEv")
  //</editor-fold>
  public SourceLocation getTemplateNameLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().NameLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::setTemplateNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1881,
   FQN="clang::DependentTemplateSpecializationTypeLoc::setTemplateNameLoc", NM="_ZN5clang38DependentTemplateSpecializationTypeLoc18setTemplateNameLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLoc18setTemplateNameLocENS_14SourceLocationE")
  //</editor-fold>
  public void setTemplateNameLoc(SourceLocation Loc) {
    this.getLocalData().NameLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getLAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1885,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getLAngleLoc", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc12getLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc12getLAngleLocEv")
  //</editor-fold>
  public SourceLocation getLAngleLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().LAngleLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::setLAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1888,
   FQN="clang::DependentTemplateSpecializationTypeLoc::setLAngleLoc", NM="_ZN5clang38DependentTemplateSpecializationTypeLoc12setLAngleLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLoc12setLAngleLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLAngleLoc(SourceLocation Loc) {
    this.getLocalData().LAngleLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getRAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1892,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getRAngleLoc", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc12getRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc12getRAngleLocEv")
  //</editor-fold>
  public SourceLocation getRAngleLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().RAngleLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::setRAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1895,
   FQN="clang::DependentTemplateSpecializationTypeLoc::setRAngleLoc", NM="_ZN5clang38DependentTemplateSpecializationTypeLoc12setRAngleLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLoc12setRAngleLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRAngleLoc(SourceLocation Loc) {
    this.getLocalData().RAngleLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1899,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getNumArgs", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return getTypePtr().getNumArgs();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::setArgLocInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1903,
   FQN="clang::DependentTemplateSpecializationTypeLoc::setArgLocInfo", NM="_ZN5clang38DependentTemplateSpecializationTypeLoc13setArgLocInfoEjNS_23TemplateArgumentLocInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLoc13setArgLocInfoEjNS_23TemplateArgumentLocInfoE")
  //</editor-fold>
  public void setArgLocInfo(/*uint*/int i, TemplateArgumentLocInfo AI) {
    getArgInfos().$at(i).$assign(AI);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getArgLocInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1906,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getArgLocInfo", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc13getArgLocInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc13getArgLocInfoEj")
  //</editor-fold>
  public TemplateArgumentLocInfo getArgLocInfo(/*uint*/int i) /*const*/ {
    return new TemplateArgumentLocInfo(getArgInfos().$at(i));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getArgLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1910,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getArgLoc", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc9getArgLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc9getArgLocEj")
  //</editor-fold>
  public TemplateArgumentLoc getArgLoc(/*uint*/int i) /*const*/ {
    return new TemplateArgumentLoc(getTypePtr().getArg(i), getArgLocInfo(i));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1914,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getLocalSourceRange", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    if (getElaboratedKeywordLoc().isValid()) {
      return new SourceRange(getElaboratedKeywordLoc(), getRAngleLoc());
    } else if (getQualifierLoc().$bool()) {
      return new SourceRange(getQualifierLoc().getBeginLoc(), getRAngleLoc());
    } else if (getTemplateKeywordLoc().isValid()) {
      return new SourceRange(getTemplateKeywordLoc(), getRAngleLoc());
    } else {
      return new SourceRange(getTemplateNameLoc(), getRAngleLoc());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::copy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1925,
   FQN="clang::DependentTemplateSpecializationTypeLoc::copy", NM="_ZN5clang38DependentTemplateSpecializationTypeLoc4copyES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLoc4copyES0_")
  //</editor-fold>
  public void copy(DependentTemplateSpecializationTypeLoc Loc) {
    /*uint*/int size = getFullDataSize();
    assert (size == Loc.getFullDataSize());
    memcpy(Data, Loc.Data, size, TypeLoc.DATA_DEEP_COPY);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 433,
   FQN="clang::DependentTemplateSpecializationTypeLoc::initializeLocal", NM="_ZN5clang38DependentTemplateSpecializationTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public final void initializeLocal(final ASTContext /*&*/ Context, 
                 SourceLocation Loc) {
    setElaboratedKeywordLoc(/*NO_COPY*/Loc);
    if ((getTypePtr().getQualifier() != null)) {
      NestedNameSpecifierLocBuilder Builder = null;
      try {
        Builder/*J*/= new NestedNameSpecifierLocBuilder();
        Builder.MakeTrivial(Context, getTypePtr().getQualifier(), new SourceRange(/*NO_COPY*/Loc));
        setQualifierLoc(Builder.getWithLocInContext(Context));
      } finally {
        if (Builder != null) { Builder.$destroy(); }
      }
    } else {
      setQualifierLoc(new NestedNameSpecifierLoc());
    }
    setTemplateKeywordLoc(/*NO_COPY*/Loc);
    setTemplateNameLoc(/*NO_COPY*/Loc);
    setLAngleLoc(/*NO_COPY*/Loc);
    setRAngleLoc(/*NO_COPY*/Loc);
    TemplateSpecializationTypeLoc.initializeArgLocs(Context, getNumArgs(), 
        getTypePtr().getArgs(), 
        getArgInfos(), /*NO_COPY*/Loc);
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getExtraLocalDataSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1933,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getExtraLocalDataSize", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc21getExtraLocalDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc21getExtraLocalDataSizeEv")
  //</editor-fold>
  public /*uint*/int getExtraLocalDataSize() /*const*/ {
    return getNumArgs() * $sizeof_TemplateArgumentLocInfo();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getExtraLocalDataAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1937,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getExtraLocalDataAlignment", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc26getExtraLocalDataAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc26getExtraLocalDataAlignmentEv")
  //</editor-fold>
  public /*uint*/int getExtraLocalDataAlignment() /*const*/ {
    return alignOf(TemplateArgumentLocInfo.class);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::getArgInfos">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1942,
   FQN="clang::DependentTemplateSpecializationTypeLoc::getArgInfos", NM="_ZNK5clang38DependentTemplateSpecializationTypeLoc11getArgInfosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang38DependentTemplateSpecializationTypeLoc11getArgInfosEv")
  //</editor-fold>
  private type$ptr<TemplateArgumentLocInfo /*P*/> getArgInfos() /*const*/ {
    return ((/*static_cast*/type$ptr<TemplateArgumentLocInfo /*P*/> )(getExtraLocalData()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::DependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1834,
   FQN="clang::DependentTemplateSpecializationTypeLoc::DependentTemplateSpecializationTypeLoc", NM="_ZN5clang38DependentTemplateSpecializationTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ DependentTemplateSpecializationTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, DependentTemplateSpecializationTypeLoc, DependentTemplateSpecializationType, DependentTemplateSpecializationLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::DependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1834,
   FQN="clang::DependentTemplateSpecializationTypeLoc::DependentTemplateSpecializationTypeLoc", NM="_ZN5clang38DependentTemplateSpecializationTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DependentTemplateSpecializationTypeLoc(final /*const*/ DependentTemplateSpecializationTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, DependentTemplateSpecializationTypeLoc, DependentTemplateSpecializationType, DependentTemplateSpecializationLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentTemplateSpecializationTypeLoc::DependentTemplateSpecializationTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1834,
   FQN="clang::DependentTemplateSpecializationTypeLoc::DependentTemplateSpecializationTypeLoc", NM="_ZN5clang38DependentTemplateSpecializationTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang38DependentTemplateSpecializationTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ DependentTemplateSpecializationTypeLoc(JD$Move _dparam, final DependentTemplateSpecializationTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, DependentTemplateSpecializationTypeLoc, DependentTemplateSpecializationType, DependentTemplateSpecializationLocInfo>(static_cast<DependentTemplateSpecializationTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final DependentTemplateSpecializationLocInfo createJavaEmptyLocalTypeLocInfo() { return new DependentTemplateSpecializationLocInfo(); }
  
  protected static int $sizeof_TemplateArgumentLocInfo() { return 1; }
  @Override protected Class<DependentTemplateSpecializationType> getTypeClass() { return DependentTemplateSpecializationType.class; }

  @Override protected final void initJavaExtraLocalData(type$ptr extraLocalData$Ptr, int NumExtra) {
    assert NumExtra == getNumArgs() : "expect request for extra data for arguments pointers only";
    // as extra data we keep TemplateArgumentLocInfo pointers, check that array size is enough and contains nulls
    for (int idx = 0; idx < NumExtra; idx++) {
      assert extraLocalData$Ptr.$at(idx) == null : "must be not occupied placeholder for TemplateArgumentLocInfo *";
      extraLocalData$Ptr.$set(idx, new TemplateArgumentLocInfo());
    }
  }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
