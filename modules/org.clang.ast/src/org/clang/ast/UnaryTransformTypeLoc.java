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
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1671,
 FQN="clang::UnaryTransformTypeLoc", NM="_ZN5clang21UnaryTransformTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang21UnaryTransformTypeLocE")
//</editor-fold>
public class UnaryTransformTypeLoc extends /*public*/ Concrete$UnqualTypeLoc<UnaryTransformTypeLoc, UnaryTransformType, UnaryTransformTypeLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::getKWLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1676,
   FQN="clang::UnaryTransformTypeLoc::getKWLoc", NM="_ZNK5clang21UnaryTransformTypeLoc8getKWLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang21UnaryTransformTypeLoc8getKWLocEv")
  //</editor-fold>
  public SourceLocation getKWLoc() /*const*/ {
    return new SourceLocation(getLocalData().KWLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::setKWLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1677,
   FQN="clang::UnaryTransformTypeLoc::setKWLoc", NM="_ZN5clang21UnaryTransformTypeLoc8setKWLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang21UnaryTransformTypeLoc8setKWLocENS_14SourceLocationE")
  //</editor-fold>
  public void setKWLoc(SourceLocation Loc) {
    getLocalData().KWLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1679,
   FQN="clang::UnaryTransformTypeLoc::getLParenLoc", NM="_ZNK5clang21UnaryTransformTypeLoc12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang21UnaryTransformTypeLoc12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(getLocalData().LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1680,
   FQN="clang::UnaryTransformTypeLoc::setLParenLoc", NM="_ZN5clang21UnaryTransformTypeLoc12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang21UnaryTransformTypeLoc12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation Loc) {
    getLocalData().LParenLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1682,
   FQN="clang::UnaryTransformTypeLoc::getRParenLoc", NM="_ZNK5clang21UnaryTransformTypeLoc12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang21UnaryTransformTypeLoc12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(getLocalData().RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1683,
   FQN="clang::UnaryTransformTypeLoc::setRParenLoc", NM="_ZN5clang21UnaryTransformTypeLoc12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang21UnaryTransformTypeLoc12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation Loc) {
    getLocalData().RParenLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::getUnderlyingTInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1685,
   FQN="clang::UnaryTransformTypeLoc::getUnderlyingTInfo", NM="_ZNK5clang21UnaryTransformTypeLoc18getUnderlyingTInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang21UnaryTransformTypeLoc18getUnderlyingTInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getUnderlyingTInfo() /*const*/ {
    return getLocalData().UnderlyingTInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::setUnderlyingTInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1688,
   FQN="clang::UnaryTransformTypeLoc::setUnderlyingTInfo", NM="_ZN5clang21UnaryTransformTypeLoc18setUnderlyingTInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang21UnaryTransformTypeLoc18setUnderlyingTInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setUnderlyingTInfo(TypeSourceInfo /*P*/ TInfo) {
    getLocalData().UnderlyingTInfo = TInfo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1692,
   FQN="clang::UnaryTransformTypeLoc::getLocalSourceRange", NM="_ZNK5clang21UnaryTransformTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang21UnaryTransformTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    return new SourceRange(getKWLoc(), getRParenLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::getParensRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1696,
   FQN="clang::UnaryTransformTypeLoc::getParensRange", NM="_ZNK5clang21UnaryTransformTypeLoc14getParensRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang21UnaryTransformTypeLoc14getParensRangeEv")
  //</editor-fold>
  public SourceRange getParensRange() /*const*/ {
    return new SourceRange(getLParenLoc(), getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::setParensRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1699,
   FQN="clang::UnaryTransformTypeLoc::setParensRange", NM="_ZN5clang21UnaryTransformTypeLoc14setParensRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang21UnaryTransformTypeLoc14setParensRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setParensRange(SourceRange Range) {
    setLParenLoc(Range.getBegin());
    setRParenLoc(Range.getEnd());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1704,
   FQN="clang::UnaryTransformTypeLoc::initializeLocal", NM="_ZN5clang21UnaryTransformTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang21UnaryTransformTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public final void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {
    setKWLoc(/*NO_COPY*/Loc);
    setRParenLoc(/*NO_COPY*/Loc);
    setLParenLoc(/*NO_COPY*/Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::UnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1671,
   FQN="clang::UnaryTransformTypeLoc::UnaryTransformTypeLoc", NM="_ZN5clang21UnaryTransformTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang21UnaryTransformTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ UnaryTransformTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, UnaryTransformTypeLoc, UnaryTransformType, UnaryTransformTypeLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::UnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1671,
   FQN="clang::UnaryTransformTypeLoc::UnaryTransformTypeLoc", NM="_ZN5clang21UnaryTransformTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang21UnaryTransformTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ UnaryTransformTypeLoc(final /*const*/ UnaryTransformTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, UnaryTransformTypeLoc, UnaryTransformType, UnaryTransformTypeLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryTransformTypeLoc::UnaryTransformTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1671,
   FQN="clang::UnaryTransformTypeLoc::UnaryTransformTypeLoc", NM="_ZN5clang21UnaryTransformTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang21UnaryTransformTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ UnaryTransformTypeLoc(JD$Move _dparam, final UnaryTransformTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, UnaryTransformTypeLoc, UnaryTransformType, UnaryTransformTypeLocInfo>(static_cast<UnaryTransformTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final UnaryTransformTypeLocInfo createJavaEmptyLocalTypeLocInfo() { return new UnaryTransformTypeLocInfo(); }
  
  @Override protected Class<UnaryTransformType> getTypeClass() { return UnaryTransformType.class; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
