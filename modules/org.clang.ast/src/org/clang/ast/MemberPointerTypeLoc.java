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


/// \brief Wrapper for source info for member pointers.
//<editor-fold defaultstate="collapsed" desc="clang::MemberPointerTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1163,
 FQN="clang::MemberPointerTypeLoc", NM="_ZN5clang20MemberPointerTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20MemberPointerTypeLocE")
//</editor-fold>
public class MemberPointerTypeLoc extends /*public*/ PointerLikeTypeLoc<MemberPointerTypeLoc, MemberPointerType, MemberPointerLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerTypeLoc::getStarLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1167,
   FQN="clang::MemberPointerTypeLoc::getStarLoc", NM="_ZNK5clang20MemberPointerTypeLoc10getStarLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20MemberPointerTypeLoc10getStarLocEv")
  //</editor-fold>
  public SourceLocation getStarLoc() /*const*/ {
    return getSigilLoc();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerTypeLoc::setStarLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1170,
   FQN="clang::MemberPointerTypeLoc::setStarLoc", NM="_ZN5clang20MemberPointerTypeLoc10setStarLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20MemberPointerTypeLoc10setStarLocENS_14SourceLocationE")
  //</editor-fold>
  public void setStarLoc(SourceLocation Loc) {
    setSigilLoc(/*NO_COPY*/Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerTypeLoc::getClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1174,
   FQN="clang::MemberPointerTypeLoc::getClass", NM="_ZNK5clang20MemberPointerTypeLoc8getClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20MemberPointerTypeLoc8getClassEv")
  //</editor-fold>
  public /*const*/ Type /*P*/ __getClass() /*const*/ {
    return getTypePtr().__getClass();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerTypeLoc::getClassTInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1177,
   FQN="clang::MemberPointerTypeLoc::getClassTInfo", NM="_ZNK5clang20MemberPointerTypeLoc13getClassTInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20MemberPointerTypeLoc13getClassTInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getClassTInfo() /*const*/ {
    return getLocalData().ClassTInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerTypeLoc::setClassTInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1180,
   FQN="clang::MemberPointerTypeLoc::setClassTInfo", NM="_ZN5clang20MemberPointerTypeLoc13setClassTInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20MemberPointerTypeLoc13setClassTInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setClassTInfo(TypeSourceInfo /*P*/ TI) {
    getLocalData().ClassTInfo = TI;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1184,
   FQN="clang::MemberPointerTypeLoc::initializeLocal", NM="_ZN5clang20MemberPointerTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20MemberPointerTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {
    setSigilLoc(/*NO_COPY*/Loc);
    setClassTInfo((TypeSourceInfo /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1189,
   FQN="clang::MemberPointerTypeLoc::getLocalSourceRange", NM="_ZNK5clang20MemberPointerTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang20MemberPointerTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    {
      TypeSourceInfo /*P*/ TI = getClassTInfo();
      if ((TI != null)) {
        return new SourceRange(TI.getTypeLoc().getBeginLoc(), getStarLoc());
      } else {
        return new SourceRange(getStarLoc());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerTypeLoc::MemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1163,
   FQN="clang::MemberPointerTypeLoc::MemberPointerTypeLoc", NM="_ZN5clang20MemberPointerTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20MemberPointerTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ MemberPointerTypeLoc() {
    // : PointerLikeTypeLoc<MemberPointerTypeLoc, MemberPointerType, MemberPointerLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerTypeLoc::MemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1163,
   FQN="clang::MemberPointerTypeLoc::MemberPointerTypeLoc", NM="_ZN5clang20MemberPointerTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20MemberPointerTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MemberPointerTypeLoc(final /*const*/ MemberPointerTypeLoc /*&*/ $Prm0) {
    // : PointerLikeTypeLoc<MemberPointerTypeLoc, MemberPointerType, MemberPointerLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerTypeLoc::MemberPointerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1163,
   FQN="clang::MemberPointerTypeLoc::MemberPointerTypeLoc", NM="_ZN5clang20MemberPointerTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang20MemberPointerTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ MemberPointerTypeLoc(JD$Move _dparam, final MemberPointerTypeLoc /*&&*/$Prm0) {
    // : PointerLikeTypeLoc<MemberPointerTypeLoc, MemberPointerType, MemberPointerLocInfo>(static_cast<MemberPointerTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final MemberPointerLocInfo createJavaEmptyLocalTypeLocInfo() { return new MemberPointerLocInfo(); }
  
  @Override protected Class<MemberPointerType> getTypeClass() { return MemberPointerType.class; }

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
