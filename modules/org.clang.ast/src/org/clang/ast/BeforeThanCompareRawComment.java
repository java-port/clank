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

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.NativeCallback.*;
import org.clang.basic.*;


/// \brief Compare comments' source locations.
//<editor-fold defaultstate="collapsed" desc="clang::BeforeThanCompare<clang::RawComment>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 164,
 FQN="clang::BeforeThanCompare<clang::RawComment>", NM="_ZN5clang17BeforeThanCompareINS_10RawCommentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang17BeforeThanCompareINS_10RawCommentEEE")
//</editor-fold>
public class BeforeThanCompareRawComment implements TypeType2Bool<RawComment>, Native.ComparatorLower<RawComment, RawComment> {
  private final /*const*/ SourceManager /*&*/ SM;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BeforeThanCompare<clang::RawComment>::BeforeThanCompare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 169,
   FQN="clang::BeforeThanCompare<clang::RawComment>::BeforeThanCompare", NM="_ZN5clang17BeforeThanCompareINS_10RawCommentEEC1ERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang17BeforeThanCompareINS_10RawCommentEEC1ERKNS_13SourceManagerE")
  //</editor-fold>
  public /*explicit*/ BeforeThanCompareRawComment(final /*const*/ SourceManager /*&*/ SM) {
    // : SM(SM) 
    //START JInit
    this./*&*/SM=/*&*/SM;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BeforeThanCompare<clang::RawComment>::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 171,
   FQN="clang::BeforeThanCompare<clang::RawComment>::operator()", NM="_ZN5clang17BeforeThanCompareINS_10RawCommentEEclERKS1_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang17BeforeThanCompareINS_10RawCommentEEclERKS1_S4_")
  //</editor-fold>
  public boolean $call$Ref(final /*const*/ RawComment /*&*/ LHS, final /*const*/ RawComment /*&*/ RHS) {
    return SM.isBeforeInTranslationUnit(LHS.getLocStart(), RHS.getLocStart());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BeforeThanCompare<clang::RawComment>::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 175,
   FQN="clang::BeforeThanCompare<clang::RawComment>::operator()", NM="_ZN5clang17BeforeThanCompareINS_10RawCommentEEclEPKS1_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang17BeforeThanCompareINS_10RawCommentEEclEPKS1_S4_")
  //</editor-fold>
  public boolean $call$Ptr(/*const*/ RawComment /*P*/ LHS, /*const*/ RawComment /*P*/ RHS) {
    return $call$Ref($Deref(LHS), $Deref(RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BeforeThanCompare<clang::RawComment>::BeforeThanCompare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 165,
   FQN="clang::BeforeThanCompare<clang::RawComment>::BeforeThanCompare", NM="_ZN5clang17BeforeThanCompareINS_10RawCommentEEC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang17BeforeThanCompareINS_10RawCommentEEC1ERKS2_")
  //</editor-fold>
  public /*inline*/ BeforeThanCompareRawComment(final /*const*/ BeforeThanCompareRawComment /*&*/ $Prm0) {
    // : SM(.SM) 
    //START JInit
    this./*&*/SM=/*&*/$Prm0.SM;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BeforeThanCompare<clang::RawComment>::BeforeThanCompare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 165,
   FQN="clang::BeforeThanCompare<clang::RawComment>::BeforeThanCompare", NM="_ZN5clang17BeforeThanCompareINS_10RawCommentEEC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang17BeforeThanCompareINS_10RawCommentEEC1EOS2_")
  //</editor-fold>
  public /*inline*/ BeforeThanCompareRawComment(JD$Move _dparam, final BeforeThanCompareRawComment /*&&*/$Prm0) {
    // : SM(static_cast<BeforeThanCompareRawComment &&>().SM) 
    //START JInit
    this./*&*/SM=/*&*/$Prm0.SM;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public boolean $less(RawComment one, RawComment other) { return $call(one, other); }
  
  @Override public boolean $call(final /*const*/ RawComment /*&*/ LHS, final /*const*/ RawComment /*&*/ RHS) {return $call$Ref(LHS, RHS);}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "SM=" + "[SourceManager]"; // NOI18N
  }
}
