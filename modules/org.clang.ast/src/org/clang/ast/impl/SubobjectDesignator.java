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

package org.clang.ast.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.impl.ExprConstantStatics.*;


/// A path from a glvalue to a subobject of that glvalue.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 156,
 FQN="(anonymous namespace)::SubobjectDesignator", NM="_ZN12_GLOBAL__N_119SubobjectDesignatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignatorE")
//</editor-fold>
public class/*struct*/ SubobjectDesignator implements Destructors.ClassWithDestructor {
  /// True if the subobject was named in a manner not supported by C++11. Such
  /// lvalues can still be folded, but they are not core constant expressions
  /// and we cannot perform lvalue-to-rvalue conversions on them.
  public /*JBIT unsigned int*/ boolean Invalid /*: 1*/;
  
  /// Is this a pointer one past the end of an object?
  public /*JBIT unsigned int*/ boolean IsOnePastTheEnd /*: 1*/;
  
  /// Indicator of whether the most-derived object is an array element.
  public /*JBIT unsigned int*/ boolean MostDerivedIsArrayElement /*: 1*/;
  
  /// The length of the path to the most-derived object of which this is a
  /// subobject.
  public /*uint*/int MostDerivedPathLength /*: 29*/;
  
  /// The size of the array of which the most-derived object is an element.
  /// This will always be 0 if the most-derived object is not an array
  /// element. 0 is not an indicator of whether or not the most-derived object
  /// is an array, however, because 0-length arrays are allowed.
  public long/*uint64_t*/ MostDerivedArraySize;
  
  /// The type of the most derived object referred to by this address.
  public QualType MostDerivedType;
  
  /*typedef APValue::LValuePathEntry PathEntry*/
//  public final class PathEntry extends APValue.LValuePathEntry{ };
  
  /// The entries on the path from the glvalue to the designated subobject.
  public SmallVector<APValue.LValuePathEntry> Entries;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::SubobjectDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 186,
   FQN="(anonymous namespace)::SubobjectDesignator::SubobjectDesignator", NM="_ZN12_GLOBAL__N_119SubobjectDesignatorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignatorC1Ev")
  //</editor-fold>
  public SubobjectDesignator() {
    // : Invalid(true), MostDerivedType(), Entries() 
    //START JInit
    this.Invalid = true;
    this.MostDerivedType = new QualType();
    this.Entries = new SmallVector<APValue.LValuePathEntry>(8, new APValue.LValuePathEntry());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::SubobjectDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 188,
   FQN="(anonymous namespace)::SubobjectDesignator::SubobjectDesignator", NM="_ZN12_GLOBAL__N_119SubobjectDesignatorC1EN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignatorC1EN5clang8QualTypeE")
  //</editor-fold>
  public /*explicit*/ SubobjectDesignator(QualType T) {
    // : Invalid(false), IsOnePastTheEnd(false), MostDerivedIsArrayElement(false), MostDerivedPathLength(0), MostDerivedArraySize(0), MostDerivedType(T), Entries() 
    //START JInit
    this.Invalid = false;
    this.IsOnePastTheEnd = false;
    this.MostDerivedIsArrayElement = false;
    this.MostDerivedPathLength = 0;
    this.MostDerivedArraySize = $int2ulong(0);
    this.MostDerivedType = new QualType(T);
    this.Entries = new SmallVector<APValue.LValuePathEntry>(8, new APValue.LValuePathEntry());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::SubobjectDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 193,
   FQN="(anonymous namespace)::SubobjectDesignator::SubobjectDesignator", NM="_ZN12_GLOBAL__N_119SubobjectDesignatorC1ERN5clang10ASTContextERKNS1_7APValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignatorC1ERN5clang10ASTContextERKNS1_7APValueE")
  //</editor-fold>
  public SubobjectDesignator(final ASTContext /*&*/ Ctx, final /*const*/ APValue /*&*/ V) {
    // : Invalid(!V.isLValue() || !V.hasLValuePath()), IsOnePastTheEnd(false), MostDerivedIsArrayElement(false), MostDerivedPathLength(0), MostDerivedArraySize(0), MostDerivedType(), Entries() 
    //START JInit
    this.Invalid = !V.isLValue() || !V.hasLValuePath();
    this.IsOnePastTheEnd = false;
    this.MostDerivedIsArrayElement = false;
    this.MostDerivedPathLength = 0;
    this.MostDerivedArraySize = $int2ulong(0);
    this.MostDerivedType = new QualType();
    this.Entries = new SmallVector<APValue.LValuePathEntry>(8, new APValue.LValuePathEntry());
    //END JInit
    if (!Invalid) {
      IsOnePastTheEnd = V.isLValueOnePastTheEnd();
      ArrayRef<APValue.LValuePathEntry> VEntries = V.getLValuePath();
      Entries.insert$T$value_T(Entries.end(), VEntries.begin(), VEntries.end());
      if (V.getLValueBase().$bool()) {
        bool$ref IsArray = create_bool$ref(false);
        MostDerivedPathLength
           = findMostDerivedSubobject(Ctx, getType(V.getLValueBase()), 
            V.getLValuePath(), MostDerivedArraySize$Ref, 
            MostDerivedType, IsArray);
        MostDerivedIsArrayElement = IsArray.$deref();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::setInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 212,
   FQN="(anonymous namespace)::SubobjectDesignator::setInvalid", NM="_ZN12_GLOBAL__N_119SubobjectDesignator10setInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignator10setInvalidEv")
  //</editor-fold>
  public void setInvalid() {
    Invalid = true;
    Entries.clear();
  }

  
  /// Determine whether this is a one-past-the-end pointer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::isOnePastTheEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 218,
   FQN="(anonymous namespace)::SubobjectDesignator::isOnePastTheEnd", NM="_ZNK12_GLOBAL__N_119SubobjectDesignator15isOnePastTheEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_119SubobjectDesignator15isOnePastTheEndEv")
  //</editor-fold>
  public boolean isOnePastTheEnd() /*const*/ {
    assert (!Invalid);
    if (IsOnePastTheEnd) {
      return true;
    }
    if (MostDerivedIsArrayElement
       && Entries.$at$Const(MostDerivedPathLength - $int2uint_29bits(1)).ArrayIndex == MostDerivedArraySize) {
      return true;
    }
    return false;
  }

  
  /// Check that this refers to a valid subobject.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::isValidSubobject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 229,
   FQN="(anonymous namespace)::SubobjectDesignator::isValidSubobject", NM="_ZNK12_GLOBAL__N_119SubobjectDesignator16isValidSubobjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_119SubobjectDesignator16isValidSubobjectEv")
  //</editor-fold>
  public boolean isValidSubobject() /*const*/ {
    if (Invalid) {
      return false;
    }
    return !isOnePastTheEnd();
  }

  /// Check that this refers to a valid subobject, and if not, produce a
  /// relevant diagnostic and set the designator as invalid.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::checkSubobject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 936,
   FQN="(anonymous namespace)::SubobjectDesignator::checkSubobject", NM="_ZN12_GLOBAL__N_119SubobjectDesignator14checkSubobjectERNS_8EvalInfoEPKN5clang4ExprENS_18CheckSubobjectKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignator14checkSubobjectERNS_8EvalInfoEPKN5clang4ExprENS_18CheckSubobjectKindE")
  //</editor-fold>
  public boolean checkSubobject(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, 
                CheckSubobjectKind CSK) {
    if (Invalid) {
      return false;
    }
    if (isOnePastTheEnd()) {
      Info.CCEDiag(E, diag.note_constexpr_past_end_subobject).$out$T(
          CSK
      );
      setInvalid();
      return false;
    }
    return true;
  }

  
  /// Update this designator to refer to the first element within this array.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::addArrayUnchecked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 239,
   FQN="(anonymous namespace)::SubobjectDesignator::addArrayUnchecked", NM="_ZN12_GLOBAL__N_119SubobjectDesignator17addArrayUncheckedEPKN5clang17ConstantArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignator17addArrayUncheckedEPKN5clang17ConstantArrayTypeE")
  //</editor-fold>
  public void addArrayUnchecked(/*const*/ ConstantArrayType /*P*/ CAT) {
    APValue.LValuePathEntry Entry/*J*/= new APValue.LValuePathEntry();
    Entry.ArrayIndex = $int2ulong(0);
    Entries.push_back(Entry);
    
    // This is a most-derived object.
    MostDerivedType.$assignMove(CAT.getElementType());
    MostDerivedIsArrayElement = true;
    MostDerivedArraySize = CAT.getSize().getZExtValue();
    MostDerivedPathLength = Entries.size();
  }

  /// Update this designator to refer to the given base or member of this
  /// object.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::addDeclUnchecked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 252,
   FQN="(anonymous namespace)::SubobjectDesignator::addDeclUnchecked", NM="_ZN12_GLOBAL__N_119SubobjectDesignator16addDeclUncheckedEPKN5clang4DeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignator16addDeclUncheckedEPKN5clang4DeclEb")
  //</editor-fold>
  public void addDeclUnchecked(/*const*/ Decl /*P*/ D) {
    addDeclUnchecked(D, false);
  }
  public void addDeclUnchecked(/*const*/ Decl /*P*/ D, boolean Virtual/*= false*/) {
    APValue.LValuePathEntry Entry/*J*/= new APValue.LValuePathEntry();
    PointerBoolPair</*const*/ Decl/*P*/> Value/*J*/= new PointerBoolPair</*const*/ Decl/*P*/>(D, Virtual);
    Entry.BaseOrMember = Value.getOpaqueValue();
    Entries.push_back(Entry);
    {
      
      // If this isn't a base class, it's a new most-derived object.
      /*const*/ FieldDecl /*P*/ FD = dyn_cast_FieldDecl(D);
      if ((FD != null)) {
        MostDerivedType.$assignMove(FD.getType());
        MostDerivedIsArrayElement = false;
        MostDerivedArraySize = $int2ulong(0);
        MostDerivedPathLength = Entries.size();
      }
    }
  }

  /// Update this designator to refer to the given complex component.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::addComplexUnchecked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 267,
   FQN="(anonymous namespace)::SubobjectDesignator::addComplexUnchecked", NM="_ZN12_GLOBAL__N_119SubobjectDesignator19addComplexUncheckedEN5clang8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignator19addComplexUncheckedEN5clang8QualTypeEb")
  //</editor-fold>
  public void addComplexUnchecked(QualType EltTy, boolean Imag) {
    APValue.LValuePathEntry Entry/*J*/= new APValue.LValuePathEntry();
    Entry.ArrayIndex = (Imag ? 1 : 0);
    Entries.push_back(Entry);
    
    // This is technically a most-derived object, though in practice this
    // is unlikely to matter.
    MostDerivedType.$assign(EltTy);
    MostDerivedIsArrayElement = true;
    MostDerivedArraySize = $int2ulong(2);
    MostDerivedPathLength = Entries.size();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::diagnosePointerArithmetic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 949,
   FQN="(anonymous namespace)::SubobjectDesignator::diagnosePointerArithmetic", NM="_ZN12_GLOBAL__N_119SubobjectDesignator25diagnosePointerArithmeticERNS_8EvalInfoEPKN5clang4ExprEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignator25diagnosePointerArithmeticERNS_8EvalInfoEPKN5clang4ExprEy")
  //</editor-fold>
  public void diagnosePointerArithmetic(final EvalInfo /*&*/ Info, 
                           /*const*/ Expr /*P*/ E, long/*uint64_t*/ N) {
    if (MostDerivedPathLength == Entries.size() && MostDerivedIsArrayElement) {
      Info.CCEDiag(E, diag.note_constexpr_array_index).$out_int(
          ((/*static_cast*/int)($ulong2int(N)))
      ).$out_int(/*array*/ 0).$out_uint(
          ((/*static_cast*//*uint*/int)($ulong2uint(MostDerivedArraySize)))
      );
    } else {
      Info.CCEDiag(E, diag.note_constexpr_array_index).$out_int(
          ((/*static_cast*/int)($ulong2int(N)))
      ).$out_int(/*non-array*/ 1);
    }
    setInvalid();
  }

  /// Add N to the address of this subobject.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::adjustIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 281,
   FQN="(anonymous namespace)::SubobjectDesignator::adjustIndex", NM="_ZN12_GLOBAL__N_119SubobjectDesignator11adjustIndexERNS_8EvalInfoEPKN5clang4ExprEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignator11adjustIndexERNS_8EvalInfoEPKN5clang4ExprEy")
  //</editor-fold>
  public void adjustIndex(final EvalInfo /*&*/ Info, /*const*/ Expr /*P*/ E, long/*uint64_t*/ N) {
    if (Invalid) {
      return;
    }
    if (MostDerivedPathLength == Entries.size()
       && MostDerivedIsArrayElement) {
      Entries.back().ArrayIndex += N;
      if ($greater_ulong(Entries.back().ArrayIndex, MostDerivedArraySize)) {
        diagnosePointerArithmetic(Info, E, Entries.back().ArrayIndex);
        setInvalid();
      }
      return;
    }
    // [expr.add]p4: For the purposes of these operators, a pointer to a
    // nonarray object behaves the same as a pointer to the first element of
    // an array of length one with the type of the object as its element type.
    if (IsOnePastTheEnd && N == (long/*uint64_t*/)$int2ulong(-1)) {
      IsOnePastTheEnd = false;
    } else if (!IsOnePastTheEnd && N == $int2ullong(1)) {
      IsOnePastTheEnd = true;
    } else if (N != $int2ullong(0)) {
      diagnosePointerArithmetic(Info, E, ((long/*uint64_t*/)(IsOnePastTheEnd ? 1 : 0)) + N);
      setInvalid();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 156,
   FQN="(anonymous namespace)::SubobjectDesignator::operator=", NM="_ZN12_GLOBAL__N_119SubobjectDesignatoraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignatoraSEOS0_")
  //</editor-fold>
  public /*inline*/ SubobjectDesignator /*&*/ $assignMove(final SubobjectDesignator /*&&*/$Prm0) {
    this.Invalid = $Prm0.Invalid;
    this.IsOnePastTheEnd = $Prm0.IsOnePastTheEnd;
    this.MostDerivedIsArrayElement = $Prm0.MostDerivedIsArrayElement;
    this.MostDerivedPathLength = $Prm0.MostDerivedPathLength;
    this.MostDerivedArraySize = $Prm0.MostDerivedArraySize;
    this.MostDerivedType.$assignMove($Prm0.MostDerivedType);
    this.Entries.$assignMove($Prm0.Entries);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::SubobjectDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 156,
   FQN="(anonymous namespace)::SubobjectDesignator::SubobjectDesignator", NM="_ZN12_GLOBAL__N_119SubobjectDesignatorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignatorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SubobjectDesignator(final /*const*/ SubobjectDesignator /*&*/ $Prm0) {
    // : Invalid(.Invalid), IsOnePastTheEnd(.IsOnePastTheEnd), MostDerivedIsArrayElement(.MostDerivedIsArrayElement), MostDerivedPathLength(.MostDerivedPathLength), MostDerivedArraySize(.MostDerivedArraySize), MostDerivedType(.MostDerivedType), Entries(.Entries) 
    //START JInit
    this.Invalid = $Prm0.Invalid;
    this.IsOnePastTheEnd = $Prm0.IsOnePastTheEnd;
    this.MostDerivedIsArrayElement = $Prm0.MostDerivedIsArrayElement;
    this.MostDerivedPathLength = $Prm0.MostDerivedPathLength;
    this.MostDerivedArraySize = $Prm0.MostDerivedArraySize;
    this.MostDerivedType = new QualType($Prm0.MostDerivedType);
    this.Entries = new SmallVector<APValue.LValuePathEntry>($Prm0.Entries);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::~SubobjectDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 156,
   FQN="(anonymous namespace)::SubobjectDesignator::~SubobjectDesignator", NM="_ZN12_GLOBAL__N_119SubobjectDesignatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignatorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Entries.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubobjectDesignator::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 156,
   FQN="(anonymous namespace)::SubobjectDesignator::operator=", NM="_ZN12_GLOBAL__N_119SubobjectDesignatoraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119SubobjectDesignatoraSERKS0_")
  //</editor-fold>
  public /*inline*/ SubobjectDesignator /*&*/ $assign(final /*const*/ SubobjectDesignator /*&*/ $Prm0) {
    this.Invalid = $Prm0.Invalid;
    this.IsOnePastTheEnd = $Prm0.IsOnePastTheEnd;
    this.MostDerivedIsArrayElement = $Prm0.MostDerivedIsArrayElement;
    this.MostDerivedPathLength = $Prm0.MostDerivedPathLength;
    this.MostDerivedArraySize = $Prm0.MostDerivedArraySize;
    this.MostDerivedType.$assign($Prm0.MostDerivedType);
    this.Entries.$assign($Prm0.Entries);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private ulong$ref MostDerivedArraySize$Ref = new ulong$ref() {
    @Override
    public long $deref() {
      return MostDerivedArraySize;
    }
    @Override
    public long $set(long value) {
      MostDerivedArraySize = value;
      return MostDerivedArraySize;
    }
  };

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Invalid=" + Invalid // NOI18N
              + ", IsOnePastTheEnd=" + IsOnePastTheEnd // NOI18N
              + ", MostDerivedIsArrayElement=" + MostDerivedIsArrayElement // NOI18N
              + ", MostDerivedPathLength=" + MostDerivedPathLength // NOI18N
              + ", MostDerivedArraySize=" + MostDerivedArraySize // NOI18N
              + ", MostDerivedType=" + MostDerivedType // NOI18N
              + ", Entries=" + Entries; // NOI18N
  }
}
