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


/// A base class for
/*template <class Derived, class TypeClass, class LocalData = PointerLikeLocInfo> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::PointerLikeTypeLoc">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1104,
 FQN="clang::PointerLikeTypeLoc", NM="_ZN5clang18PointerLikeTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang18PointerLikeTypeLocE")
//</editor-fold>
public abstract class PointerLikeTypeLoc</*class*/ Derived extends PointerLikeTypeLoc, /*class*/ TypeClass extends Type, /*class*/ LocalData extends PointerLikeLocInfo/* = PointerLikeLocInfo*/>  extends /*public*/ Concrete$UnqualTypeLoc<Derived, TypeClass, LocalData> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PointerLikeTypeLoc::getSigilLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1108,
   FQN="clang::PointerLikeTypeLoc::getSigilLoc", NM="_ZNK5clang18PointerLikeTypeLoc11getSigilLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang18PointerLikeTypeLoc11getSigilLocEv")
  //</editor-fold>
  public SourceLocation getSigilLoc() /*const*/ {
    return this.getLocalData().StarLoc;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PointerLikeTypeLoc::setSigilLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1111,
   FQN="clang::PointerLikeTypeLoc::setSigilLoc", NM="_ZN5clang18PointerLikeTypeLoc11setSigilLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang18PointerLikeTypeLoc11setSigilLocENS_14SourceLocationE")
  //</editor-fold>
  public void setSigilLoc(SourceLocation Loc) {
    this.getLocalData().StarLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PointerLikeTypeLoc::getPointeeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1115,
   FQN="clang::PointerLikeTypeLoc::getPointeeLoc", NM="_ZNK5clang18PointerLikeTypeLoc13getPointeeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang18PointerLikeTypeLoc13getPointeeLocEv")
  //</editor-fold>
  public TypeLoc getPointeeLoc() /*const*/ {
    return this.getInnerTypeLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PointerLikeTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1119,
   FQN="clang::PointerLikeTypeLoc::getLocalSourceRange", NM="_ZNK5clang18PointerLikeTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang18PointerLikeTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    return new SourceRange(getSigilLoc(), getSigilLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PointerLikeTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1123,
   FQN="clang::PointerLikeTypeLoc::initializeLocal", NM="_ZN5clang18PointerLikeTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang18PointerLikeTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {
    setSigilLoc(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PointerLikeTypeLoc::getInnerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1127,
   FQN="clang::PointerLikeTypeLoc::getInnerType", NM="_ZNK5clang18PointerLikeTypeLoc12getInnerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang18PointerLikeTypeLoc12getInnerTypeEv")
  //</editor-fold>
  public QualType getInnerType() /*const*/ {
    return this.getTypePtr().getPointeeType();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected PointerLikeTypeLoc() {
    super();
  }
  protected PointerLikeTypeLoc(Derived $Prm0) {
    super($Prm0);
  }
  protected PointerLikeTypeLoc(JD$Move _dparam, Derived $Prm0) {
    super(_dparam, $Prm0);
  }

  @Override protected abstract LocalData createJavaEmptyLocalTypeLocInfo();
  
  @Override protected abstract Class<? extends TypeClass> getTypeClass();
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
