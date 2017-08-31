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

/*template <class Derived, class TypeClass, class LocalData = TypeofLocInfo> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::TypeofLikeTypeLoc">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1583,
 FQN="clang::TypeofLikeTypeLoc", NM="_ZN5clang17TypeofLikeTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang17TypeofLikeTypeLocE")
//</editor-fold>
public abstract class TypeofLikeTypeLoc</*class*/ Derived extends TypeofLikeTypeLoc, /*class*/ TypeClass extends Type, /*class*/ LocalData extends TypeofLocInfo/* = TypeofLocInfo*/>  extends /*public*/ Concrete$UnqualTypeLoc<Derived, TypeClass, LocalData> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeofLikeTypeLoc::getTypeofLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1587,
   FQN="clang::TypeofLikeTypeLoc::getTypeofLoc", NM="_ZNK5clang17TypeofLikeTypeLoc12getTypeofLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang17TypeofLikeTypeLoc12getTypeofLocEv")
  //</editor-fold>
  public SourceLocation getTypeofLoc() /*const*/ {
    return this.getLocalData().TypeofLoc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeofLikeTypeLoc::setTypeofLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1590,
   FQN="clang::TypeofLikeTypeLoc::setTypeofLoc", NM="_ZN5clang17TypeofLikeTypeLoc12setTypeofLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang17TypeofLikeTypeLoc12setTypeofLocENS_14SourceLocationE")
  //</editor-fold>
  public void setTypeofLoc(SourceLocation Loc) {
    this.getLocalData().TypeofLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeofLikeTypeLoc::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1594,
   FQN="clang::TypeofLikeTypeLoc::getLParenLoc", NM="_ZNK5clang17TypeofLikeTypeLoc12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang17TypeofLikeTypeLoc12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return this.getLocalData().LParenLoc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeofLikeTypeLoc::setLParenLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1597,
   FQN="clang::TypeofLikeTypeLoc::setLParenLoc", NM="_ZN5clang17TypeofLikeTypeLoc12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang17TypeofLikeTypeLoc12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation Loc) {
    this.getLocalData().LParenLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeofLikeTypeLoc::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1601,
   FQN="clang::TypeofLikeTypeLoc::getRParenLoc", NM="_ZNK5clang17TypeofLikeTypeLoc12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang17TypeofLikeTypeLoc12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return this.getLocalData().RParenLoc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeofLikeTypeLoc::setRParenLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1604,
   FQN="clang::TypeofLikeTypeLoc::setRParenLoc", NM="_ZN5clang17TypeofLikeTypeLoc12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang17TypeofLikeTypeLoc12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation Loc) {
    this.getLocalData().RParenLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeofLikeTypeLoc::getParensRange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1608,
   FQN="clang::TypeofLikeTypeLoc::getParensRange", NM="_ZNK5clang17TypeofLikeTypeLoc14getParensRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang17TypeofLikeTypeLoc14getParensRangeEv")
  //</editor-fold>
  public SourceRange getParensRange() /*const*/ {
    return new SourceRange(getLParenLoc(), getRParenLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeofLikeTypeLoc::setParensRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1611,
   FQN="clang::TypeofLikeTypeLoc::setParensRange", NM="_ZN5clang17TypeofLikeTypeLoc14setParensRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang17TypeofLikeTypeLoc14setParensRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setParensRange(SourceRange range) {
    setLParenLoc(range.getBegin());
    setRParenLoc(range.getEnd());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeofLikeTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1616,
   FQN="clang::TypeofLikeTypeLoc::getLocalSourceRange", NM="_ZNK5clang17TypeofLikeTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang17TypeofLikeTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    return new SourceRange(getTypeofLoc(), getRParenLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeofLikeTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1620,
   FQN="clang::TypeofLikeTypeLoc::initializeLocal", NM="_ZN5clang17TypeofLikeTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang17TypeofLikeTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {
    setTypeofLoc(Loc);
    setLParenLoc(Loc);
    setRParenLoc(Loc);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected TypeofLikeTypeLoc() {
    super();
  }
  protected TypeofLikeTypeLoc(Derived $Prm0) {
    super($Prm0);
  }
  protected TypeofLikeTypeLoc(JD$Move _dparam, Derived $Prm0) {
    super(JD$Move.INSTANCE, $Prm0);
  }  

  @Override protected abstract LocalData createJavaEmptyLocalTypeLocInfo();
  
  @Override protected abstract Class<? extends TypeClass> getTypeClass();
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
