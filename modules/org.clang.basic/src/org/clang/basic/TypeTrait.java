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

import org.clank.support.*;
import org.clang.basic.*;


/// \brief Names for traits that operate specifically on types.
//<editor-fold defaultstate="collapsed" desc="clang::TypeTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TypeTraits.h", line = 21,
 FQN="clang::TypeTrait", NM="_ZN5clang9TypeTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang9TypeTraitE")
//</editor-fold>
public enum TypeTrait implements Native.ComparableLower {
  UTT_HasNothrowAssign(0),
  UTT_HasNothrowMoveAssign(UTT_HasNothrowAssign.getValue() + 1),
  UTT_HasNothrowCopy(UTT_HasNothrowMoveAssign.getValue() + 1),
  UTT_HasNothrowConstructor(UTT_HasNothrowCopy.getValue() + 1),
  UTT_HasTrivialAssign(UTT_HasNothrowConstructor.getValue() + 1),
  UTT_HasTrivialMoveAssign(UTT_HasTrivialAssign.getValue() + 1),
  UTT_HasTrivialCopy(UTT_HasTrivialMoveAssign.getValue() + 1),
  UTT_HasTrivialDefaultConstructor(UTT_HasTrivialCopy.getValue() + 1),
  UTT_HasTrivialMoveConstructor(UTT_HasTrivialDefaultConstructor.getValue() + 1),
  UTT_HasTrivialDestructor(UTT_HasTrivialMoveConstructor.getValue() + 1),
  UTT_HasVirtualDestructor(UTT_HasTrivialDestructor.getValue() + 1),
  UTT_IsAbstract(UTT_HasVirtualDestructor.getValue() + 1),
  UTT_IsArithmetic(UTT_IsAbstract.getValue() + 1),
  UTT_IsArray(UTT_IsArithmetic.getValue() + 1),
  UTT_IsClass(UTT_IsArray.getValue() + 1),
  UTT_IsCompleteType(UTT_IsClass.getValue() + 1),
  UTT_IsCompound(UTT_IsCompleteType.getValue() + 1),
  UTT_IsConst(UTT_IsCompound.getValue() + 1),
  UTT_IsDestructible(UTT_IsConst.getValue() + 1),
  UTT_IsEmpty(UTT_IsDestructible.getValue() + 1),
  UTT_IsEnum(UTT_IsEmpty.getValue() + 1),
  UTT_IsFinal(UTT_IsEnum.getValue() + 1),
  UTT_IsFloatingPoint(UTT_IsFinal.getValue() + 1),
  UTT_IsFunction(UTT_IsFloatingPoint.getValue() + 1),
  UTT_IsFundamental(UTT_IsFunction.getValue() + 1),
  UTT_IsIntegral(UTT_IsFundamental.getValue() + 1),
  UTT_IsInterfaceClass(UTT_IsIntegral.getValue() + 1),
  UTT_IsLiteral(UTT_IsInterfaceClass.getValue() + 1),
  UTT_IsLvalueReference(UTT_IsLiteral.getValue() + 1),
  UTT_IsMemberFunctionPointer(UTT_IsLvalueReference.getValue() + 1),
  UTT_IsMemberObjectPointer(UTT_IsMemberFunctionPointer.getValue() + 1),
  UTT_IsMemberPointer(UTT_IsMemberObjectPointer.getValue() + 1),
  UTT_IsNothrowDestructible(UTT_IsMemberPointer.getValue() + 1),
  UTT_IsObject(UTT_IsNothrowDestructible.getValue() + 1),
  UTT_IsPOD(UTT_IsObject.getValue() + 1),
  UTT_IsPointer(UTT_IsPOD.getValue() + 1),
  UTT_IsPolymorphic(UTT_IsPointer.getValue() + 1),
  UTT_IsReference(UTT_IsPolymorphic.getValue() + 1),
  UTT_IsRvalueReference(UTT_IsReference.getValue() + 1),
  UTT_IsScalar(UTT_IsRvalueReference.getValue() + 1),
  UTT_IsSealed(UTT_IsScalar.getValue() + 1),
  UTT_IsSigned(UTT_IsSealed.getValue() + 1),
  UTT_IsStandardLayout(UTT_IsSigned.getValue() + 1),
  UTT_IsTrivial(UTT_IsStandardLayout.getValue() + 1),
  UTT_IsTriviallyCopyable(UTT_IsTrivial.getValue() + 1),
  UTT_IsUnion(UTT_IsTriviallyCopyable.getValue() + 1),
  UTT_IsUnsigned(UTT_IsUnion.getValue() + 1),
  UTT_IsVoid(UTT_IsUnsigned.getValue() + 1),
  UTT_IsVolatile(UTT_IsVoid.getValue() + 1),
  UTT_Last(TypeTrait.UTT_IsVolatile.getValue()),
  BTT_IsBaseOf(UTT_Last.getValue() + 1),
  BTT_IsConvertible(BTT_IsBaseOf.getValue() + 1),
  BTT_IsConvertibleTo(BTT_IsConvertible.getValue() + 1),
  BTT_IsSame(BTT_IsConvertibleTo.getValue() + 1),
  BTT_TypeCompatible(BTT_IsSame.getValue() + 1),
  BTT_IsAssignable(BTT_TypeCompatible.getValue() + 1),
  BTT_IsNothrowAssignable(BTT_IsAssignable.getValue() + 1),
  BTT_IsTriviallyAssignable(BTT_IsNothrowAssignable.getValue() + 1),
  BTT_Last(TypeTrait.BTT_IsTriviallyAssignable.getValue()),
  TT_IsConstructible(BTT_Last.getValue() + 1),
  TT_IsNothrowConstructible(TT_IsConstructible.getValue() + 1),
  TT_IsTriviallyConstructible(TT_IsNothrowConstructible.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static TypeTrait valueOf(int val) {
    TypeTrait out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final TypeTrait[] VALUES;
    private static final TypeTrait[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (TypeTrait kind : TypeTrait.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new TypeTrait[min < 0 ? (1-min) : 0];
      VALUES = new TypeTrait[max >= 0 ? (1+max) : 0];
      for (TypeTrait kind : TypeTrait.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private TypeTrait(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TypeTrait)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TypeTrait)obj).value);}
  //</editor-fold>
}
