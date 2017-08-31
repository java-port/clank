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

package org.clang.analysis;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;


/// CFGMemberDtor - Represents C++ object destructor implicitly generated for
/// member object in destructor.
//<editor-fold defaultstate="collapsed" desc="clang::CFGMemberDtor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 261,
 FQN="clang::CFGMemberDtor", NM="_ZN5clang13CFGMemberDtorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGMemberDtorE")
//</editor-fold>
public class CFGMemberDtor extends /*public*/ CFGImplicitDtor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGMemberDtor::CFGMemberDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 263,
   FQN="clang::CFGMemberDtor::CFGMemberDtor", NM="_ZN5clang13CFGMemberDtorC1EPKNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGMemberDtorC1EPKNS_9FieldDeclE")
  //</editor-fold>
  public CFGMemberDtor(/*const*/ FieldDecl /*P*/ field) {
    // : CFGImplicitDtor(MemberDtor, field, null) 
    //START JInit
    super(Kind.MemberDtor, field, (/*const*/Object/*void P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGMemberDtor::getFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 266,
   FQN="clang::CFGMemberDtor::getFieldDecl", NM="_ZNK5clang13CFGMemberDtor12getFieldDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang13CFGMemberDtor12getFieldDeclEv")
  //</editor-fold>
  public /*const*/ FieldDecl /*P*/ getFieldDecl() /*const*/ {
    return ((/*static_cast*//*const*/ FieldDecl /*P*/ )(Data1.getPointer()));
  }

/*private:*/
  /*friend  class CFGElement*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGMemberDtor::CFGMemberDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 272,
   FQN="clang::CFGMemberDtor::CFGMemberDtor", NM="_ZN5clang13CFGMemberDtorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGMemberDtorC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ CFGMemberDtor() {
    // : CFGImplicitDtor() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGMemberDtor::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 273,
   FQN="clang::CFGMemberDtor::isKind", NM="_ZN5clang13CFGMemberDtor6isKindERKNS_10CFGElementE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGMemberDtor6isKindERKNS_10CFGElementE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ CFGElement /*&*/ E) {
    return E.getKind() == Kind.MemberDtor;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGMemberDtor::CFGMemberDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 261,
   FQN="clang::CFGMemberDtor::CFGMemberDtor", NM="_ZN5clang13CFGMemberDtorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGMemberDtorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CFGMemberDtor(final /*const*/ CFGMemberDtor /*&*/ $Prm0) {
    // : CFGImplicitDtor() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGMemberDtor::CFGMemberDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 261,
   FQN="clang::CFGMemberDtor::CFGMemberDtor", NM="_ZN5clang13CFGMemberDtorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang13CFGMemberDtorC1EOS0_")
  //</editor-fold>
  public /*inline*/ CFGMemberDtor(JD$Move _dparam, final CFGMemberDtor /*&&*/$Prm0) {
    // : CFGImplicitDtor(static_cast<CFGMemberDtor &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public CFGMemberDtor clone() {
    assert this.getClass() == CFGMemberDtor.class : "must be overridden in " + this.getClass();
    return new CFGMemberDtor(this);
  }
  
  @Override public CFGMemberDtor move() {
    assert this.getClass() == CFGMemberDtor.class : "must be overridden in " + this.getClass();
    return new CFGMemberDtor(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  ////////////////////////////////////////////////////////////// 
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
