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
import org.clang.basic.*;


// This ActionResult partial specialization places the "invalid"
// flag into the low bit of the pointer.
//<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 178,
 FQN="clang::ActionResult<type-parameter-0-0, true>", NM="_ZN5clang12ActionResultIT_Lb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultIT_Lb1EEE")
//</editor-fold>
public class ActionResultTTrue</*class*/ PtrTy> extends ActionResult<PtrTy> implements NativeCloneable<ActionResultTTrue> {
  // A pointer whose low bit is 1 if this result is invalid, 0
  // otherwise.
  private PtrTy/*uintptr_t*/ Val;

  // Added manually
  private boolean Invalid;
  
  /*typedef llvm::PointerLikeTypeTraits<PtrTy> PtrTraits*/
//  public final class PtrTraits extends PointerLikeTypeTraits<PtrTy>{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::ActionResult<type-parameter-0-0, true>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 185,
   FQN="clang::ActionResult<type-parameter-0-0, true>::ActionResult<type-parameter-0-0, true>", NM="_ZN5clang12ActionResultIT_Lb1EEC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultIT_Lb1EEC1Eb")
  //</editor-fold>
  public ActionResultTTrue() {
    this(false);
  }
  public ActionResultTTrue(boolean Invalid/*= false*/) {
    // : PtrWithInvalid(static_cast<uintptr_t>(Invalid)) 
    //START JInit
    this.Val = null;
    this.Invalid = Invalid;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::ActionResult<type-parameter-0-0, true>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 188,
   FQN="clang::ActionResult<type-parameter-0-0, true>::ActionResult<type-parameter-0-0, true>", NM="_ZN5clang12ActionResultIT_Lb1EEC1ES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultIT_Lb1EEC1ES1_")
  //</editor-fold>
  public ActionResultTTrue(JD$T _dparam, PtrTy V) {
    Val = V;
    Invalid = false;
  }
  public ActionResultTTrue(JD$T _dparam, type$ptr<PtrTy> V) {
    Val = V.$star();
    Invalid = false;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::ActionResult<type-parameter-0-0, true>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 193,
   FQN="clang::ActionResult<type-parameter-0-0, true>::ActionResult<type-parameter-0-0, true>", NM="_ZN5clang12ActionResultIT_Lb1EEC1ERKNS_17DiagnosticBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultIT_Lb1EEC1ERKNS_17DiagnosticBuilderE")
  //</editor-fold>
  public ActionResultTTrue(final /*const*/ DiagnosticBuilder /*&*/ $Prm0) {
    // : PtrWithInvalid(0x01) 
    //START JInit
    this.Val = $ActionResultTTrue$PtrTy();
    this.Invalid = true;
    //END JInit
  }

  
  // These two overloads prevent void* -> bool conversions.
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::ActionResult<type-parameter-0-0, true>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 196,
   FQN="clang::ActionResult<type-parameter-0-0, true>::ActionResult<type-parameter-0-0, true>", NM="_ZN5clang12ActionResultIT_Lb1EEC1EPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultIT_Lb1EEC1EPKv")
  //</editor-fold>
  public ActionResultTTrue(JD$ConstVoidPtr _dparam, /*const*/Object/*void P*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::ActionResult<type-parameter-0-0, true>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 197,
   FQN="clang::ActionResult<type-parameter-0-0, true>::ActionResult<type-parameter-0-0, true>", NM="_ZN5clang12ActionResultIT_Lb1EEC1EPVv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultIT_Lb1EEC1EPVv")
  //</editor-fold>
  public ActionResultTTrue(JD$VolatileVoidPtr _dparam, /*volatile*/Object/*void P*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

//  public <PtrTy> ActionResultTTrue(ActionResultTTrue<PtrTy> LHS) {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//  }
//
//  public <PtrTy> ActionResultTTrue(JD$Move INSTANCE, ActionResultTTrue<PtrTy> LHS) {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//  }


  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::isInvalid">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 199,
   FQN="clang::ActionResult<type-parameter-0-0, true>::isInvalid", NM="_ZNK5clang12ActionResultIT_Lb1EE9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang12ActionResultIT_Lb1EE9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return Invalid;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::isUsable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 200,
   FQN="clang::ActionResult<type-parameter-0-0, true>::isUsable", NM="_ZNK5clang12ActionResultIT_Lb1EE8isUsableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang12ActionResultIT_Lb1EE8isUsableEv")
  //</editor-fold>
  public boolean isUsable() /*const*/ {
    return !Invalid && $bool(Val);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::isUnset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 201,
   FQN="clang::ActionResult<type-parameter-0-0, true>::isUnset", NM="_ZNK5clang12ActionResultIT_Lb1EE7isUnsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang12ActionResultIT_Lb1EE7isUnsetEv")
  //</editor-fold>
  public boolean isUnset() /*const*/ {
    return !Invalid && !$bool(Val);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 203,
   FQN="clang::ActionResult<type-parameter-0-0, true>::get", NM="_ZNK5clang12ActionResultIT_Lb1EE3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang12ActionResultIT_Lb1EE3getEv")
  //</editor-fold>
  public PtrTy get() /*const*/ {
    return Val;
  }

  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::getAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*template param as input param*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 207,
   FQN="clang::ActionResult<type-parameter-0-0, true>::getAs", NM="Tpl__ZN5clang12ActionResultIT_Lb1EE5getAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=Tpl__ZN5clang12ActionResultIT_Lb1EE5getAsEv")
  //</editor-fold>
  public </*typename*/ T> T /*P*/ getAs(Class<T> clazz) {
    return clazz.cast(/*static_cast<T *>*/ (get()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 209,
   FQN="clang::ActionResult<type-parameter-0-0, true>::set", NM="_ZN5clang12ActionResultIT_Lb1EE3setES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultIT_Lb1EE3setES1_")
  //</editor-fold>
  public void set(PtrTy V) {
    Val = V;
    Invalid = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 215,
   FQN="clang::ActionResult<type-parameter-0-0, true>::operator=", NM="_ZN5clang12ActionResultIT_Lb1EEaSES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultIT_Lb1EEaSES1_")
  //</editor-fold>
  public /*const*/ ActionResultTTrue<PtrTy> /*&*/ $assign(PtrTy RHS) {
    Val = RHS;
    Invalid = false;
    return Native.$star(this);
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public /*const*/ ActionResultTTrue<PtrTy> /*&*/ $assign(ActionResultTTrue<PtrTy> RHS) {
    Val = RHS.Val;
    Invalid = RHS.Invalid;
    return this;
  }
  
  // For types where we can fit a flag in with the pointer, provide
  // conversions to/from pointer type.
  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::getFromOpaquePointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 224,
   FQN="clang::ActionResult<type-parameter-0-0, true>::getFromOpaquePointer", NM="_ZN5clang12ActionResultIT_Lb1EE20getFromOpaquePointerEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang12ActionResultIT_Lb1EE20getFromOpaquePointerEPv")
  //</editor-fold>
  public static <PtrTy> ActionResultTTrue<PtrTy> getFromOpaquePointer(Object /*void P*/ P) {
    // JAVA: for now as opaque value use copy of this
      return P != null ? 
              new ActionResultTTrue((ActionResultTTrue)P)
              : 
              new ActionResultTTrue(JD$T.INSTANCE, (PtrTy)P);
//    return new ActionResultTTrue(JD$T.INSTANCE, (PtrTy)P);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ActionResult<type-parameter-0-0, true>::getAsOpaquePointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 229,
   FQN="clang::ActionResult<type-parameter-0-0, true>::getAsOpaquePointer", NM="_ZNK5clang12ActionResultIT_Lb1EE18getAsOpaquePointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang12ActionResultIT_Lb1EE18getAsOpaquePointerEv")
  //</editor-fold>
  public Object/*void P*/ getAsOpaquePointer() /*const*/ {
    // JAVA: for now as opaque value use copy of this
    // May be it's better to introduce markers for invalids and use inner pointer instead of new object creation
    return (Object/*void P*/ )new ActionResultTTrue(this);
    // return (Object/*void P*/ )PtrWithInvalid;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  protected PtrTy $ActionResultTTrue$PtrTy() { 
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
  
  public /*const*/ ActionResultTTrue<PtrTy/*, CompressInvalid*/> /*&*/ $assignMove(ActionResultTTrue<? extends PtrTy/*, CompressInvalid*/> Other) {
    assert this != Other;
    this.Invalid = Other.Invalid;
    this.Val = Other.Val;
    Other.Val = null;
    return this;
  }
  
  public ActionResultTTrue(JD$Move INSTANCE, ActionResultTTrue<PtrTy> LHS) {
    assert this != LHS;
    this.Invalid = LHS.Invalid;
    this.Val = LHS.Val;
    LHS.Val = null;
  }  
  
  public ActionResultTTrue(ActionResultTTrue<? extends PtrTy> $Prm0) {
    // : Val(val), Invalid(false) 
    //START JInit
    this.Val = /*ParenListExpr*/$Prm0.Val;//new PtrTy(val);
    this.Invalid = $Prm0.Invalid;
    //END JInit
  }

  @Override public ActionResultTTrue clone() { return new ActionResultTTrue(this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "Val[" + (Invalid ? "INVALID " : "") + NativeTrace.getIdentityStr(Val) + "]=" + Val; // NOI18N
  }
}
