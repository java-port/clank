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
import static org.clank.java.std.*;
import org.clang.basic.*;
import static org.clank.support.Native.$toConst;
import static org.clank.support.Native.$tryClone;

//<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1722,
 FQN="clang::ElaboratedTypeLoc", NM="_ZN5clang17ElaboratedTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ElaboratedTypeLocE")
//</editor-fold>
public class ElaboratedTypeLoc extends /*public*/ Concrete$UnqualTypeLoc<ElaboratedTypeLoc, ElaboratedType, ElaboratedLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc::getElaboratedKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1727,
   FQN="clang::ElaboratedTypeLoc::getElaboratedKeywordLoc", NM="_ZNK5clang17ElaboratedTypeLoc23getElaboratedKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ElaboratedTypeLoc23getElaboratedKeywordLocEv")
  //</editor-fold>
  public SourceLocation getElaboratedKeywordLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().ElaboratedKWLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc::setElaboratedKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1730,
   FQN="clang::ElaboratedTypeLoc::setElaboratedKeywordLoc", NM="_ZN5clang17ElaboratedTypeLoc23setElaboratedKeywordLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ElaboratedTypeLoc23setElaboratedKeywordLocENS_14SourceLocationE")
  //</editor-fold>
  public void setElaboratedKeywordLoc(SourceLocation Loc) {
    this.getLocalData().ElaboratedKWLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1734,
   FQN="clang::ElaboratedTypeLoc::getQualifierLoc", NM="_ZNK5clang17ElaboratedTypeLoc15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ElaboratedTypeLoc15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(getTypePtr().getQualifier(), 
        getLocalData().QualifierData);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc::setQualifierLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1739,
   FQN="clang::ElaboratedTypeLoc::setQualifierLoc", NM="_ZN5clang17ElaboratedTypeLoc15setQualifierLocENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ElaboratedTypeLoc15setQualifierLocENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  public void setQualifierLoc(NestedNameSpecifierLoc QualifierLoc) {
    assert (QualifierLoc.getNestedNameSpecifier() == getTypePtr().getQualifier()) : "Inconsistent nested-name-specifier pointer";
    getLocalData().QualifierData = $toConst($tryClone(QualifierLoc.getOpaqueData()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1746,
   FQN="clang::ElaboratedTypeLoc::getLocalSourceRange", NM="_ZNK5clang17ElaboratedTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ElaboratedTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    if (getElaboratedKeywordLoc().isValid()) {
      if (getQualifierLoc().$bool()) {
        return new SourceRange(getElaboratedKeywordLoc(), 
            getQualifierLoc().getEndLoc());
      } else {
        return new SourceRange(getElaboratedKeywordLoc());
      }
    } else {
      return getQualifierLoc().getSourceRange();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 416,
   FQN="clang::ElaboratedTypeLoc::initializeLocal", NM="_ZN5clang17ElaboratedTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang17ElaboratedTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public final void initializeLocal(final ASTContext /*&*/ Context, 
                 SourceLocation Loc) {
    NestedNameSpecifierLocBuilder Builder = null;
    try {
      setElaboratedKeywordLoc(/*NO_COPY*/Loc);
      Builder/*J*/= new NestedNameSpecifierLocBuilder();
      Builder.MakeTrivial(Context, getTypePtr().getQualifier(), new SourceRange(/*NO_COPY*/Loc));
      setQualifierLoc(Builder.getWithLocInContext(Context));
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc::getNamedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1759,
   FQN="clang::ElaboratedTypeLoc::getNamedTypeLoc", NM="_ZNK5clang17ElaboratedTypeLoc15getNamedTypeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ElaboratedTypeLoc15getNamedTypeLocEv")
  //</editor-fold>
  public TypeLoc getNamedTypeLoc() /*const*/ {
    return getInnerTypeLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc::getInnerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1763,
   FQN="clang::ElaboratedTypeLoc::getInnerType", NM="_ZNK5clang17ElaboratedTypeLoc12getInnerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17ElaboratedTypeLoc12getInnerTypeEv")
  //</editor-fold>
  public QualType getInnerType() /*const*/ {
    return getTypePtr().getNamedType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc::copy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1767,
   FQN="clang::ElaboratedTypeLoc::copy", NM="_ZN5clang17ElaboratedTypeLoc4copyES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ElaboratedTypeLoc4copyES0_")
  //</editor-fold>
  public void copy(ElaboratedTypeLoc Loc) {
    /*uint*/int size = getFullDataSize();
    assert (size == Loc.getFullDataSize());
    memcpy(Data, Loc.Data, size, TypeLoc.DATA_DEEP_COPY);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc::ElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1722,
   FQN="clang::ElaboratedTypeLoc::ElaboratedTypeLoc", NM="_ZN5clang17ElaboratedTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ElaboratedTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ ElaboratedTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, ElaboratedTypeLoc, ElaboratedType, ElaboratedLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc::ElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1722,
   FQN="clang::ElaboratedTypeLoc::ElaboratedTypeLoc", NM="_ZN5clang17ElaboratedTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ElaboratedTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ElaboratedTypeLoc(final /*const*/ ElaboratedTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, ElaboratedTypeLoc, ElaboratedType, ElaboratedLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ElaboratedTypeLoc::ElaboratedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1722,
   FQN="clang::ElaboratedTypeLoc::ElaboratedTypeLoc", NM="_ZN5clang17ElaboratedTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17ElaboratedTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ ElaboratedTypeLoc(JD$Move _dparam, final ElaboratedTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, ElaboratedTypeLoc, ElaboratedType, ElaboratedLocInfo>(static_cast<ElaboratedTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final ElaboratedLocInfo createJavaEmptyLocalTypeLocInfo() { return new ElaboratedLocInfo(); }
  
  @Override protected Class<ElaboratedType> getTypeClass() { return ElaboratedType.class; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
