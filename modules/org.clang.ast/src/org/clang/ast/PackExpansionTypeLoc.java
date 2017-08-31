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

//<editor-fold defaultstate="collapsed" desc="clang::PackExpansionTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1952,
 FQN="clang::PackExpansionTypeLoc", NM="_ZN5clang20PackExpansionTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20PackExpansionTypeLocE")
//</editor-fold>
public class PackExpansionTypeLoc extends /*public*/ Concrete$UnqualTypeLoc<PackExpansionTypeLoc, PackExpansionType, PackExpansionTypeLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionTypeLoc::getEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1956,
   FQN="clang::PackExpansionTypeLoc::getEllipsisLoc", NM="_ZNK5clang20PackExpansionTypeLoc14getEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20PackExpansionTypeLoc14getEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getEllipsisLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().EllipsisLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionTypeLoc::setEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1960,
   FQN="clang::PackExpansionTypeLoc::setEllipsisLoc", NM="_ZN5clang20PackExpansionTypeLoc14setEllipsisLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20PackExpansionTypeLoc14setEllipsisLocENS_14SourceLocationE")
  //</editor-fold>
  public void setEllipsisLoc(SourceLocation Loc) {
    this.getLocalData().EllipsisLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1964,
   FQN="clang::PackExpansionTypeLoc::getLocalSourceRange", NM="_ZNK5clang20PackExpansionTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20PackExpansionTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    return new SourceRange(getEllipsisLoc(), getEllipsisLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1968,
   FQN="clang::PackExpansionTypeLoc::initializeLocal", NM="_ZN5clang20PackExpansionTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20PackExpansionTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {
    setEllipsisLoc(/*NO_COPY*/Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionTypeLoc::getPatternLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1972,
   FQN="clang::PackExpansionTypeLoc::getPatternLoc", NM="_ZNK5clang20PackExpansionTypeLoc13getPatternLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20PackExpansionTypeLoc13getPatternLocEv")
  //</editor-fold>
  public TypeLoc getPatternLoc() /*const*/ {
    return getInnerTypeLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionTypeLoc::getInnerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1976,
   FQN="clang::PackExpansionTypeLoc::getInnerType", NM="_ZNK5clang20PackExpansionTypeLoc12getInnerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20PackExpansionTypeLoc12getInnerTypeEv")
  //</editor-fold>
  public QualType getInnerType() /*const*/ {
    return this.getTypePtr().getPattern();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionTypeLoc::PackExpansionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1952,
   FQN="clang::PackExpansionTypeLoc::PackExpansionTypeLoc", NM="_ZN5clang20PackExpansionTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20PackExpansionTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ PackExpansionTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, PackExpansionTypeLoc, PackExpansionType, PackExpansionTypeLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionTypeLoc::PackExpansionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1952,
   FQN="clang::PackExpansionTypeLoc::PackExpansionTypeLoc", NM="_ZN5clang20PackExpansionTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20PackExpansionTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PackExpansionTypeLoc(final /*const*/ PackExpansionTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, PackExpansionTypeLoc, PackExpansionType, PackExpansionTypeLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PackExpansionTypeLoc::PackExpansionTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1952,
   FQN="clang::PackExpansionTypeLoc::PackExpansionTypeLoc", NM="_ZN5clang20PackExpansionTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20PackExpansionTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ PackExpansionTypeLoc(JD$Move _dparam, final PackExpansionTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, PackExpansionTypeLoc, PackExpansionType, PackExpansionTypeLocInfo>(static_cast<PackExpansionTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final PackExpansionTypeLocInfo createJavaEmptyLocalTypeLocInfo() { return new PackExpansionTypeLocInfo(); }
  
  @Override protected Class<PackExpansionType> getTypeClass() { return PackExpansionType.class; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
