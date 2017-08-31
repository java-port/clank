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

package org.clang.basic;

import org.clang.basic.java.CXXMethodDeclImplementation;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;

import static org.clang.basic.ReturnAdjustment.*;
import static org.clang.basic.ThisAdjustment.*;


/// \brief The \c this pointer adjustment as well as an optional return
/// adjustment for a thunk.
//<editor-fold defaultstate="collapsed" desc="clang::ThunkInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 179,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 176,
 FQN="clang::ThunkInfo", NM="_ZN5clang9ThunkInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang9ThunkInfoE")
//</editor-fold>
public class/*struct*/ ThunkInfo {
  /// \brief The \c this pointer adjustment.
  public ThisAdjustment This;
  
  /// \brief The return adjustment.
  public ReturnAdjustment Return;
  
  /// \brief Holds a pointer to the overridden method this thunk is for,
  /// if needed by the ABI to distinguish different thunks with equal
  /// adjustments. Otherwise, null.
  /// CAUTION: In the unlikely event you need to sort ThunkInfos, consider using
  /// an ABI-specific comparator.
  public /*const*/ CXXMethodDeclImplementation /*P*/ Method; // JAVA MANUAL_SEMANTIC: added pointer to implementation for AST
  
  //<editor-fold defaultstate="collapsed" desc="clang::ThunkInfo::ThunkInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 193,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 190,
   FQN="clang::ThunkInfo::ThunkInfo", NM="_ZN5clang9ThunkInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang9ThunkInfoC1Ev")
  //</editor-fold>
  public ThunkInfo() {
    /* : This(), Return(), Method(null)*/ 
    //START JInit
    this.This = new ThisAdjustment();
    this.Return = new ReturnAdjustment();
    this.Method = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ThunkInfo::ThunkInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 195,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 192,
   FQN="clang::ThunkInfo::ThunkInfo", NM="_ZN5clang9ThunkInfoC1ERKNS_14ThisAdjustmentERKNS_16ReturnAdjustmentEPKNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang9ThunkInfoC1ERKNS_14ThisAdjustmentERKNS_16ReturnAdjustmentEPKNS_13CXXMethodDeclE")
  //</editor-fold>
  public ThunkInfo(/*const*/ ThisAdjustment /*&*/ This, /*const*/ ReturnAdjustment /*&*/ Return) {
    this(This, Return, 
      (/*const*/ CXXMethodDeclImplementation /*P*/ )null);
  }
  public ThunkInfo(/*const*/ ThisAdjustment /*&*/ This, /*const*/ ReturnAdjustment /*&*/ Return, 
      /*const*/ CXXMethodDeclImplementation /*P*/ Method/*= null*/) {
    /* : This(This), Return(Return), Method(Method)*/ 
    //START JInit
    this.This = new ThisAdjustment(This);
    this.Return = new ReturnAdjustment(Return);
    this.Method = Method;
    //END JInit
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 199,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 196,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_9ThunkInfoES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clangeqERKNS_9ThunkInfoES2_")
  //</editor-fold>
  public static boolean $eq_ThunkInfo$C(/*const*/ ThunkInfo /*&*/ LHS, /*const*/ ThunkInfo /*&*/ RHS) {
    return $eq_ThisAdjustment$C(LHS.This, RHS.This) && $eq_ReturnAdjustment$C(LHS.Return, RHS.Return)
       && LHS.Method == RHS.Method;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ThunkInfo::isEmpty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 204,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 201,
   FQN="clang::ThunkInfo::isEmpty", NM="_ZNK5clang9ThunkInfo7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang9ThunkInfo7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return This.isEmpty() && Return.isEmpty() && Method == null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ThunkInfo::ThunkInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 176,
   FQN="clang::ThunkInfo::ThunkInfo", NM="_ZN5clang9ThunkInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang9ThunkInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ThunkInfo(/*const*/ ThunkInfo /*&*/ $Prm0) {
    /* : This(.This), Return(.Return), Method(.Method)*/ 
    //START JInit
    this.This = new ThisAdjustment($Prm0.This);
    this.Return = new ReturnAdjustment($Prm0.Return);
    this.Method = $Prm0.Method;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ThunkInfo::ThunkInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 176,
   FQN="clang::ThunkInfo::ThunkInfo", NM="_ZN5clang9ThunkInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang9ThunkInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ ThunkInfo(JD$Move _dparam, ThunkInfo /*&&*/$Prm0) {
    /* : This(static_cast<ThunkInfo &&>().This), Return(static_cast<ThunkInfo &&>().Return), Method(static_cast<ThunkInfo &&>().Method)*/ 
    //START JInit
    this.This = new ThisAdjustment(JD$Move.INSTANCE, $Prm0.This);
    this.Return = new ReturnAdjustment(JD$Move.INSTANCE, $Prm0.Return);
    this.Method = $Prm0.Method;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ThunkInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 176,
   FQN="clang::ThunkInfo::operator=", NM="_ZN5clang9ThunkInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang9ThunkInfoaSERKS0_")
  //</editor-fold>
  public /*inline*/ ThunkInfo /*&*/ $assign(/*const*/ ThunkInfo /*&*/ $Prm0) {
    this.This.$assign($Prm0.This);
    this.Return.$assign($Prm0.Return);
    this.Method = $Prm0.Method;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ThunkInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ABI.h", old_line = 176,
   FQN="clang::ThunkInfo::operator=", NM="_ZN5clang9ThunkInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang9ThunkInfoaSEOS0_")
  //</editor-fold>
  public /*inline*/ ThunkInfo /*&*/ $assignMove(ThunkInfo /*&&*/$Prm0) {
    this.This.$assignMove($Prm0.This);
    this.Return.$assignMove($Prm0.Return);
    this.Method = $Prm0.Method;
    return /*Deref*/this;
  }

  
  public String toString() {
    return "" + "This=" + This // NOI18N
              + ", Return=" + Return // NOI18N
              + ", Method=" + Method; // NOI18N
  }
}
