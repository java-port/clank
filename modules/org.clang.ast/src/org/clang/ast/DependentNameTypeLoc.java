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

//<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1780,
 FQN="clang::DependentNameTypeLoc", NM="_ZN5clang20DependentNameTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20DependentNameTypeLocE")
//</editor-fold>
public class DependentNameTypeLoc extends /*public*/ Concrete$UnqualTypeLoc<DependentNameTypeLoc, DependentNameType, DependentNameLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc::getElaboratedKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1785,
   FQN="clang::DependentNameTypeLoc::getElaboratedKeywordLoc", NM="_ZNK5clang20DependentNameTypeLoc23getElaboratedKeywordLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20DependentNameTypeLoc23getElaboratedKeywordLocEv")
  //</editor-fold>
  public SourceLocation getElaboratedKeywordLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().ElaboratedKWLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc::setElaboratedKeywordLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1788,
   FQN="clang::DependentNameTypeLoc::setElaboratedKeywordLoc", NM="_ZN5clang20DependentNameTypeLoc23setElaboratedKeywordLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20DependentNameTypeLoc23setElaboratedKeywordLocENS_14SourceLocationE")
  //</editor-fold>
  public void setElaboratedKeywordLoc(SourceLocation Loc) {
    this.getLocalData().ElaboratedKWLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc::getQualifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1792,
   FQN="clang::DependentNameTypeLoc::getQualifierLoc", NM="_ZNK5clang20DependentNameTypeLoc15getQualifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20DependentNameTypeLoc15getQualifierLocEv")
  //</editor-fold>
  public NestedNameSpecifierLoc getQualifierLoc() /*const*/ {
    return new NestedNameSpecifierLoc(getTypePtr().getQualifier(), 
        getLocalData().QualifierData);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc::setQualifierLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1797,
   FQN="clang::DependentNameTypeLoc::setQualifierLoc", NM="_ZN5clang20DependentNameTypeLoc15setQualifierLocENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20DependentNameTypeLoc15setQualifierLocENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  public void setQualifierLoc(NestedNameSpecifierLoc QualifierLoc) {
    assert (QualifierLoc.getNestedNameSpecifier() == getTypePtr().getQualifier()) : "Inconsistent nested-name-specifier pointer";
    getLocalData().QualifierData = $toConst($tryClone(QualifierLoc.getOpaqueData()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc::getNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1804,
   FQN="clang::DependentNameTypeLoc::getNameLoc", NM="_ZNK5clang20DependentNameTypeLoc10getNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20DependentNameTypeLoc10getNameLocEv")
  //</editor-fold>
  public SourceLocation getNameLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().NameLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc::setNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1807,
   FQN="clang::DependentNameTypeLoc::setNameLoc", NM="_ZN5clang20DependentNameTypeLoc10setNameLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20DependentNameTypeLoc10setNameLocENS_14SourceLocationE")
  //</editor-fold>
  public void setNameLoc(SourceLocation Loc) {
    this.getLocalData().NameLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1811,
   FQN="clang::DependentNameTypeLoc::getLocalSourceRange", NM="_ZNK5clang20DependentNameTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20DependentNameTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    if (getElaboratedKeywordLoc().isValid()) {
      return new SourceRange(getElaboratedKeywordLoc(), getNameLoc());
    } else {
      return new SourceRange(getQualifierLoc().getBeginLoc(), getNameLoc());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc::copy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1818,
   FQN="clang::DependentNameTypeLoc::copy", NM="_ZN5clang20DependentNameTypeLoc4copyES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20DependentNameTypeLoc4copyES0_")
  //</editor-fold>
  public void copy(DependentNameTypeLoc Loc) {
    /*uint*/int size = getFullDataSize();
    assert (size == Loc.getFullDataSize());
    memcpy(Data, Loc.Data, size, TypeLoc.DATA_DEEP_COPY);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 424,
   FQN="clang::DependentNameTypeLoc::initializeLocal", NM="_ZN5clang20DependentNameTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang20DependentNameTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public final void initializeLocal(final ASTContext /*&*/ Context, 
                 SourceLocation Loc) {
    NestedNameSpecifierLocBuilder Builder = null;
    try {
      setElaboratedKeywordLoc(/*NO_COPY*/Loc);
      Builder/*J*/= new NestedNameSpecifierLocBuilder();
      Builder.MakeTrivial(Context, getTypePtr().getQualifier(), new SourceRange(/*NO_COPY*/Loc));
      setQualifierLoc(Builder.getWithLocInContext(Context));
      setNameLoc(/*NO_COPY*/Loc);
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc::DependentNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1780,
   FQN="clang::DependentNameTypeLoc::DependentNameTypeLoc", NM="_ZN5clang20DependentNameTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20DependentNameTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ DependentNameTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, DependentNameTypeLoc, DependentNameType, DependentNameLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc::DependentNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1780,
   FQN="clang::DependentNameTypeLoc::DependentNameTypeLoc", NM="_ZN5clang20DependentNameTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20DependentNameTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DependentNameTypeLoc(final /*const*/ DependentNameTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, DependentNameTypeLoc, DependentNameType, DependentNameLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentNameTypeLoc::DependentNameTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1780,
   FQN="clang::DependentNameTypeLoc::DependentNameTypeLoc", NM="_ZN5clang20DependentNameTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20DependentNameTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ DependentNameTypeLoc(JD$Move _dparam, final DependentNameTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, DependentNameTypeLoc, DependentNameType, DependentNameLocInfo>(static_cast<DependentNameTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final DependentNameLocInfo createJavaEmptyLocalTypeLocInfo() { return new DependentNameLocInfo(); }
  
  @Override protected Class<DependentNameType> getTypeClass() { return DependentNameType.class; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
