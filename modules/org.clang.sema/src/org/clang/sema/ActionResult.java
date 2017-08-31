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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.basic.*;


/// ActionResult - This structure is used while parsing/acting on
/// expressions, stmts, etc.  It encapsulates both the object returned by
/// the action, plus a sense of whether or not it is valid.
/// When CompressInvalid is true, the "invalid" flag will be
/// stored in the low bit of the Val pointer.
/*template <class PtrTy, bool CompressInvalid = IsResultPtrLowBitFree<PtrTy>::value> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ActionResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 144,
 FQN="clang::ActionResult", NM="_ZN5clang12ActionResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultE")
//</editor-fold>
public class ActionResult</*class*/ PtrTy/*, boolean CompressInvalid = IsResultPtrLowBitFree<PtrTy>.value*/>  {
  private PtrTy Val;
  private boolean Invalid;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult::ActionResult<PtrTy, CompressInvalid>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 151,
   FQN="clang::ActionResult::ActionResult<PtrTy, CompressInvalid>", NM="_ZN5clang12ActionResultC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultC1Eb")
  //</editor-fold>
  public ActionResult() {
    this(false);
  }
  public ActionResult(boolean Invalid/*= false*/) {
    // : Val(PtrTy()), Invalid(Invalid) 
    //START JInit
    this.Val = /*ParenListExpr*/$ActionResult$PtrTy();
    this.Invalid = Invalid;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult::ActionResult<PtrTy, CompressInvalid>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 153,
   FQN="clang::ActionResult::ActionResult<PtrTy, CompressInvalid>", NM="_ZN5clang12ActionResultC1ET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultC1ET_")
  //</editor-fold>
  public ActionResult(JD$T _dparam, PtrTy val) {
    // : Val(val), Invalid(false) 
    //START JInit
    this.Val = /*ParenListExpr*/$tryClone(val);
    this.Invalid = false;
    //END JInit
  }
  public ActionResult(JD$T _dparam, type$ptr<PtrTy> val) {
    // : Val(val), Invalid(false) 
    //START JInit
    this.Val = /*ParenListExpr*/$tryClone(val.$star());
    this.Invalid = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult::ActionResult<PtrTy, CompressInvalid>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 154,
   FQN="clang::ActionResult::ActionResult<PtrTy, CompressInvalid>", NM="_ZN5clang12ActionResultC1ERKNS_17DiagnosticBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultC1ERKNS_17DiagnosticBuilderE")
  //</editor-fold>
  public ActionResult(final /*const*/ DiagnosticBuilder /*&*/ $Prm0) {
    // : Val(PtrTy()), Invalid(true) 
    //START JInit
    this.Val = /*ParenListExpr*/$tryClone($ActionResult$PtrTy());
    this.Invalid = true;
    //END JInit
  }

  
  // These two overloads prevent void* -> bool conversions.
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult::ActionResult<PtrTy, CompressInvalid>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 157,
   FQN="clang::ActionResult::ActionResult<PtrTy, CompressInvalid>", NM="_ZN5clang12ActionResultC1EPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultC1EPKv")
  //</editor-fold>
  public ActionResult(JD$ConstVoidPtr _dparam, /*const*/Object/*void P*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult::ActionResult<PtrTy, CompressInvalid>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 158,
   FQN="clang::ActionResult::ActionResult<PtrTy, CompressInvalid>", NM="_ZN5clang12ActionResultC1EPVv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultC1EPVv")
  //</editor-fold>
  public ActionResult(JD$VolatileVoidPtr _dparam, /*volatile*/Object/*void P*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 160,
   FQN="clang::ActionResult::isInvalid", NM="_ZNK5clang12ActionResult9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang12ActionResult9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return Invalid;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult::isUsable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 161,
   FQN="clang::ActionResult::isUsable", NM="_ZNK5clang12ActionResult8isUsableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang12ActionResult8isUsableEv")
  //</editor-fold>
  public boolean isUsable() /*const*/ {
    return !Invalid && $bool(Val);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult::isUnset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 162,
   FQN="clang::ActionResult::isUnset", NM="_ZNK5clang12ActionResult7isUnsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang12ActionResult7isUnsetEv")
  //</editor-fold>
  public boolean isUnset() /*const*/ {
    return !Invalid && !$bool(Val);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 164,
   FQN="clang::ActionResult::get", NM="_ZNK5clang12ActionResult3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang12ActionResult3getEv")
  //</editor-fold>
  public PtrTy get() /*const*/ {
    return Val;
  }

  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult::getAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*template param as input param*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 165,
   FQN="clang::ActionResult::getAs", NM="Tpl__ZN5clang12ActionResult5getAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=Tpl__ZN5clang12ActionResult5getAsEv")
  //</editor-fold>
  public </*typename*/ T> T /*P*/ getAs(Class<T> clazz) {
    return clazz.cast(/*static_cast<T *>*/ (get()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 167,
   FQN="clang::ActionResult::set", NM="_ZN5clang12ActionResult3setET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResult3setET_")
  //</editor-fold>
  public void set(PtrTy V) {
    Val = V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 169,
   FQN="clang::ActionResult::operator=", NM="_ZN5clang12ActionResultaSET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultaSET_")
  //</editor-fold>
  public /*const*/ ActionResult<PtrTy/*, CompressInvalid*/> /*&*/ $assign(PtrTy RHS) {
    Val = RHS;
    Invalid = false;
    return Native.$star(this);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected PtrTy $ActionResult$PtrTy() { 
    return (PtrTy)null;
  }

  private boolean $bool(PtrTy Val) { 
    if (Val == null) {
      return false;
    } else if (Val instanceof OpaquePtr) {
      return ((OpaquePtr) Val).$bool();
    } else {
      return true;
    }
  }

  public /*const*/ ActionResult<PtrTy/*, CompressInvalid*/> /*&*/ $assignMove(ActionResult<? extends PtrTy/*, CompressInvalid*/> Other) {
    assert this != Other;
    this.Invalid = Other.Invalid;
    this.Val = Other.Val;
    Other.Val = null;
    return this;
  }

  public ActionResult(ActionResult<? extends PtrTy> $Prm0) {
    // : Val(val), Invalid(false) 
    //START JInit
    this.Val = /*ParenListExpr*/$tryClone($Prm0.Val);//new PtrTy(val);
    this.Invalid = $Prm0.Invalid;
    //END JInit
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public ActionResult(JD$T _dparam, boolean Invalid, PtrTy val) {
    // : Val(PtrTy()), Invalid(Invalid) 
    //START JInit
    this.Val = /*ParenListExpr*/val; // do not clone here because in this constructor val is default value
    this.Invalid = Invalid;
    //END JInit
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Val=" + Val // NOI18N
              + ", Invalid=" + Invalid; // NOI18N
  }
}
