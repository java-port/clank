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


/// \brief Wrapper for source info for ObjC interfaces.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 981,
 FQN="clang::ObjCInterfaceTypeLoc", NM="_ZN5clang20ObjCInterfaceTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20ObjCInterfaceTypeLocE")
//</editor-fold>
public class ObjCInterfaceTypeLoc extends /*public*/ Concrete$ObjCObjectTypeLoc<ObjCInterfaceTypeLoc, ObjCInterfaceType, ObjCInterfaceLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceTypeLoc::getIFaceDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 986,
   FQN="clang::ObjCInterfaceTypeLoc::getIFaceDecl", NM="_ZNK5clang20ObjCInterfaceTypeLoc12getIFaceDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20ObjCInterfaceTypeLoc12getIFaceDeclEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getIFaceDecl() /*const*/ {
    return ((ObjCInterfaceType)getTypePtr()).getDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceTypeLoc::getNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 990,
   FQN="clang::ObjCInterfaceTypeLoc::getNameLoc", NM="_ZNK5clang20ObjCInterfaceTypeLoc10getNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20ObjCInterfaceTypeLoc10getNameLocEv")
  //</editor-fold>
  public SourceLocation getNameLoc() /*const*/ {
    return new SourceLocation(getLocalData().NameLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceTypeLoc::setNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 994,
   FQN="clang::ObjCInterfaceTypeLoc::setNameLoc", NM="_ZN5clang20ObjCInterfaceTypeLoc10setNameLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20ObjCInterfaceTypeLoc10setNameLocENS_14SourceLocationE")
  //</editor-fold>
  public void setNameLoc(SourceLocation Loc) {
    getLocalData().NameLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 998,
   FQN="clang::ObjCInterfaceTypeLoc::getLocalSourceRange", NM="_ZNK5clang20ObjCInterfaceTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20ObjCInterfaceTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    return new SourceRange(getNameLoc(), getNameEndLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceTypeLoc::getNameEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1002,
   FQN="clang::ObjCInterfaceTypeLoc::getNameEndLoc", NM="_ZNK5clang20ObjCInterfaceTypeLoc13getNameEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20ObjCInterfaceTypeLoc13getNameEndLocEv")
  //</editor-fold>
  public SourceLocation getNameEndLoc() /*const*/ {
    return new SourceLocation(getLocalData().NameEndLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceTypeLoc::setNameEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1006,
   FQN="clang::ObjCInterfaceTypeLoc::setNameEndLoc", NM="_ZN5clang20ObjCInterfaceTypeLoc13setNameEndLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20ObjCInterfaceTypeLoc13setNameEndLocENS_14SourceLocationE")
  //</editor-fold>
  public void setNameEndLoc(SourceLocation Loc) {
    getLocalData().NameEndLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1010,
   FQN="clang::ObjCInterfaceTypeLoc::initializeLocal", NM="_ZN5clang20ObjCInterfaceTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20ObjCInterfaceTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {
    setNameLoc(/*NO_COPY*/Loc);
    setNameEndLoc(/*NO_COPY*/Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceTypeLoc::ObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 981,
   FQN="clang::ObjCInterfaceTypeLoc::ObjCInterfaceTypeLoc", NM="_ZN5clang20ObjCInterfaceTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20ObjCInterfaceTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ ObjCInterfaceTypeLoc() {
    // : ConcreteTypeLoc<ObjCObjectTypeLoc, ObjCInterfaceTypeLoc, ObjCInterfaceType, ObjCInterfaceLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceTypeLoc::ObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 981,
   FQN="clang::ObjCInterfaceTypeLoc::ObjCInterfaceTypeLoc", NM="_ZN5clang20ObjCInterfaceTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20ObjCInterfaceTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ObjCInterfaceTypeLoc(final /*const*/ ObjCInterfaceTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<ObjCObjectTypeLoc, ObjCInterfaceTypeLoc, ObjCInterfaceType, ObjCInterfaceLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceTypeLoc::ObjCInterfaceTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 981,
   FQN="clang::ObjCInterfaceTypeLoc::ObjCInterfaceTypeLoc", NM="_ZN5clang20ObjCInterfaceTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20ObjCInterfaceTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ ObjCInterfaceTypeLoc(JD$Move _dparam, final ObjCInterfaceTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<ObjCObjectTypeLoc, ObjCInterfaceTypeLoc, ObjCInterfaceType, ObjCInterfaceLocInfo>(static_cast<ObjCInterfaceTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final ObjCInterfaceLocInfo createJavaEmptyLocalTypeLocInfo() { return new ObjCInterfaceLocInfo(); }
  
  @Override protected Class<ObjCInterfaceType> getTypeClass() { return ObjCInterfaceType.class; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
