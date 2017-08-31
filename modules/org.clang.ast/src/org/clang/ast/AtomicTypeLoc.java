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

//<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1985,
 FQN="clang::AtomicTypeLoc", NM="_ZN5clang13AtomicTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13AtomicTypeLocE")
//</editor-fold>
public class AtomicTypeLoc extends /*public*/ Concrete$UnqualTypeLoc<AtomicTypeLoc, AtomicType, AtomicTypeLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::getValueLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1988,
   FQN="clang::AtomicTypeLoc::getValueLoc", NM="_ZNK5clang13AtomicTypeLoc11getValueLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang13AtomicTypeLoc11getValueLocEv")
  //</editor-fold>
  public TypeLoc getValueLoc() /*const*/ {
    return this.getInnerTypeLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1992,
   FQN="clang::AtomicTypeLoc::getLocalSourceRange", NM="_ZNK5clang13AtomicTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang13AtomicTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    return new SourceRange(getKWLoc(), getRParenLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::getKWLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1996,
   FQN="clang::AtomicTypeLoc::getKWLoc", NM="_ZNK5clang13AtomicTypeLoc8getKWLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang13AtomicTypeLoc8getKWLocEv")
  //</editor-fold>
  public SourceLocation getKWLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().KWLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::setKWLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1999,
   FQN="clang::AtomicTypeLoc::setKWLoc", NM="_ZN5clang13AtomicTypeLoc8setKWLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13AtomicTypeLoc8setKWLocENS_14SourceLocationE")
  //</editor-fold>
  public void setKWLoc(SourceLocation Loc) {
    this.getLocalData().KWLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 2003,
   FQN="clang::AtomicTypeLoc::getLParenLoc", NM="_ZNK5clang13AtomicTypeLoc12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang13AtomicTypeLoc12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 2006,
   FQN="clang::AtomicTypeLoc::setLParenLoc", NM="_ZN5clang13AtomicTypeLoc12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13AtomicTypeLoc12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation Loc) {
    this.getLocalData().LParenLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 2010,
   FQN="clang::AtomicTypeLoc::getRParenLoc", NM="_ZNK5clang13AtomicTypeLoc12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang13AtomicTypeLoc12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 2013,
   FQN="clang::AtomicTypeLoc::setRParenLoc", NM="_ZN5clang13AtomicTypeLoc12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13AtomicTypeLoc12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation Loc) {
    this.getLocalData().RParenLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::getParensRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 2017,
   FQN="clang::AtomicTypeLoc::getParensRange", NM="_ZNK5clang13AtomicTypeLoc14getParensRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang13AtomicTypeLoc14getParensRangeEv")
  //</editor-fold>
  public SourceRange getParensRange() /*const*/ {
    return new SourceRange(getLParenLoc(), getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::setParensRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 2020,
   FQN="clang::AtomicTypeLoc::setParensRange", NM="_ZN5clang13AtomicTypeLoc14setParensRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13AtomicTypeLoc14setParensRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setParensRange(SourceRange Range) {
    setLParenLoc(Range.getBegin());
    setRParenLoc(Range.getEnd());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 2025,
   FQN="clang::AtomicTypeLoc::initializeLocal", NM="_ZN5clang13AtomicTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13AtomicTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public final void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {
    setKWLoc(/*NO_COPY*/Loc);
    setLParenLoc(/*NO_COPY*/Loc);
    setRParenLoc(/*NO_COPY*/Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::getInnerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 2031,
   FQN="clang::AtomicTypeLoc::getInnerType", NM="_ZNK5clang13AtomicTypeLoc12getInnerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang13AtomicTypeLoc12getInnerTypeEv")
  //</editor-fold>
  public QualType getInnerType() /*const*/ {
    return this.getTypePtr().getValueType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::AtomicTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1985,
   FQN="clang::AtomicTypeLoc::AtomicTypeLoc", NM="_ZN5clang13AtomicTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13AtomicTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ AtomicTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, AtomicTypeLoc, AtomicType, AtomicTypeLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::AtomicTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1985,
   FQN="clang::AtomicTypeLoc::AtomicTypeLoc", NM="_ZN5clang13AtomicTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13AtomicTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ AtomicTypeLoc(final /*const*/ AtomicTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, AtomicTypeLoc, AtomicType, AtomicTypeLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicTypeLoc::AtomicTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1985,
   FQN="clang::AtomicTypeLoc::AtomicTypeLoc", NM="_ZN5clang13AtomicTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13AtomicTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ AtomicTypeLoc(JD$Move _dparam, final AtomicTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, AtomicTypeLoc, AtomicType, AtomicTypeLocInfo>(static_cast<AtomicTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final AtomicTypeLocInfo createJavaEmptyLocalTypeLocInfo() { return new AtomicTypeLocInfo(); }
  
  @Override protected Class<AtomicType> getTypeClass() { return AtomicType.class; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
