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


/// \brief Wrapper for source info for arrays.
//<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1358,
 FQN="clang::ArrayTypeLoc", NM="_ZN5clang12ArrayTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN5clang12ArrayTypeLocE")
//</editor-fold>
public class ArrayTypeLoc extends /*public*/ Concrete$UnqualTypeLoc<ArrayTypeLoc, ArrayType, ArrayLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::getLBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1363,
   FQN="clang::ArrayTypeLoc::getLBracketLoc", NM="_ZNK5clang12ArrayTypeLoc14getLBracketLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK5clang12ArrayTypeLoc14getLBracketLocEv")
  //</editor-fold>
  public SourceLocation getLBracketLoc() /*const*/ {
    return new SourceLocation(getLocalData().LBracketLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::setLBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1366,
   FQN="clang::ArrayTypeLoc::setLBracketLoc", NM="_ZN5clang12ArrayTypeLoc14setLBracketLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN5clang12ArrayTypeLoc14setLBracketLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLBracketLoc(SourceLocation Loc) {
    getLocalData().LBracketLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::getRBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1370,
   FQN="clang::ArrayTypeLoc::getRBracketLoc", NM="_ZNK5clang12ArrayTypeLoc14getRBracketLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK5clang12ArrayTypeLoc14getRBracketLocEv")
  //</editor-fold>
  public SourceLocation getRBracketLoc() /*const*/ {
    return new SourceLocation(getLocalData().RBracketLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::setRBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1373,
   FQN="clang::ArrayTypeLoc::setRBracketLoc", NM="_ZN5clang12ArrayTypeLoc14setRBracketLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN5clang12ArrayTypeLoc14setRBracketLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRBracketLoc(SourceLocation Loc) {
    getLocalData().RBracketLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::getBracketsRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1377,
   FQN="clang::ArrayTypeLoc::getBracketsRange", NM="_ZNK5clang12ArrayTypeLoc16getBracketsRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK5clang12ArrayTypeLoc16getBracketsRangeEv")
  //</editor-fold>
  public SourceRange getBracketsRange() /*const*/ {
    return new SourceRange(getLBracketLoc(), getRBracketLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::getSizeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1381,
   FQN="clang::ArrayTypeLoc::getSizeExpr", NM="_ZNK5clang12ArrayTypeLoc11getSizeExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK5clang12ArrayTypeLoc11getSizeExprEv")
  //</editor-fold>
  public Expr /*P*/ getSizeExpr() /*const*/ {
    return getLocalData().Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::setSizeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1384,
   FQN="clang::ArrayTypeLoc::setSizeExpr", NM="_ZN5clang12ArrayTypeLoc11setSizeExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN5clang12ArrayTypeLoc11setSizeExprEPNS_4ExprE")
  //</editor-fold>
  public void setSizeExpr(Expr /*P*/ Size) {
    getLocalData().Size = Size;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::getElementLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1388,
   FQN="clang::ArrayTypeLoc::getElementLoc", NM="_ZNK5clang12ArrayTypeLoc13getElementLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK5clang12ArrayTypeLoc13getElementLocEv")
  //</editor-fold>
  public TypeLoc getElementLoc() /*const*/ {
    return getInnerTypeLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1392,
   FQN="clang::ArrayTypeLoc::getLocalSourceRange", NM="_ZNK5clang12ArrayTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK5clang12ArrayTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    return new SourceRange(getLBracketLoc(), getRBracketLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1396,
   FQN="clang::ArrayTypeLoc::initializeLocal", NM="_ZN5clang12ArrayTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN5clang12ArrayTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public final void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {
    setLBracketLoc(new SourceLocation(Loc));
    setRBracketLoc(new SourceLocation(Loc));
    setSizeExpr((Expr /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::getInnerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1402,
   FQN="clang::ArrayTypeLoc::getInnerType", NM="_ZNK5clang12ArrayTypeLoc12getInnerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK5clang12ArrayTypeLoc12getInnerTypeEv")
  //</editor-fold>
  public QualType getInnerType() /*const*/ {
    return getTypePtr().getElementType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::ArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1358,
   FQN="clang::ArrayTypeLoc::ArrayTypeLoc", NM="_ZN5clang12ArrayTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN5clang12ArrayTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ ArrayTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, ArrayTypeLoc, ArrayType, ArrayLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::ArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1358,
   FQN="clang::ArrayTypeLoc::ArrayTypeLoc", NM="_ZN5clang12ArrayTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN5clang12ArrayTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ArrayTypeLoc(final /*const*/ ArrayTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, ArrayTypeLoc, ArrayType, ArrayLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeLoc::ArrayTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1358,
   FQN="clang::ArrayTypeLoc::ArrayTypeLoc", NM="_ZN5clang12ArrayTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN5clang12ArrayTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ ArrayTypeLoc(JD$Move _dparam, final ArrayTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, ArrayTypeLoc, ArrayType, ArrayLocInfo>(static_cast<ArrayTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final ArrayLocInfo createJavaEmptyLocalTypeLocInfo() { return new ArrayLocInfo(); }
  
  @Override protected Class<? extends ArrayType> getTypeClass() { return ArrayType.class; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
