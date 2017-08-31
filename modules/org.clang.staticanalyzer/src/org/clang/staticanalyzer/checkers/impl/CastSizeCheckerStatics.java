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
package org.clang.staticanalyzer.checkers.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;


//<editor-fold defaultstate="collapsed" desc="static type CastSizeCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp -nm=_ZL21evenFlexibleArraySizeRN5clang10ASTContextENS_9CharUnitsES2_NS_8QualTypeE; -static-type=CastSizeCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class CastSizeCheckerStatics {


/// Check if we are casting to a struct with a flexible array at the end.
/// \code
/// struct foo {
///   size_t len;
///   struct bar data[];
/// };
/// \endcode
/// or
/// \code
/// struct foo {
///   size_t len;
///   struct bar data[0];
/// }
/// \endcode
/// In these cases it is also valid to allocate size of struct foo + a multiple
/// of struct bar.
//<editor-fold defaultstate="collapsed" desc="evenFlexibleArraySize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp", line = 49,
 FQN="evenFlexibleArraySize", NM="_ZL21evenFlexibleArraySizeRN5clang10ASTContextENS_9CharUnitsES2_NS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp -nm=_ZL21evenFlexibleArraySizeRN5clang10ASTContextENS_9CharUnitsES2_NS_8QualTypeE")
//</editor-fold>
public static boolean evenFlexibleArraySize(final ASTContext /*&*/ Ctx, CharUnits RegionSize, 
                     CharUnits TypeSize, QualType ToPointeeTy) {
  /*const*/ RecordType /*P*/ RT = ToPointeeTy.$arrow().getAs$RecordType();
  if (!(RT != null)) {
    return false;
  }
  
  /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
  specific_decl_iterator<FieldDecl> Iter/*J*/= RD.field_begin();
  specific_decl_iterator<FieldDecl> End/*J*/= RD.field_end();
  /*const*/ FieldDecl /*P*/ Last = null;
  for (; $noteq_specific_decl_iterator$SpecificDecl$C(Iter, End); Iter.$preInc())  {
    Last = Iter.$star();
  }
  assert ((Last != null)) : "empty structs should already be handled";
  
  /*const*/ Type /*P*/ ElemType = Last.getType().$arrow().getArrayElementTypeNoTypeQual();
  CharUnits FlexSize/*J*/= new CharUnits();
  {
    /*const*/ ConstantArrayType /*P*/ ArrayTy = Ctx.getAsConstantArrayType(Last.getType());
    if ((ArrayTy != null)) {
      FlexSize.$assignMove(Ctx.getTypeSizeInChars(ElemType));
      if (ArrayTy.getSize().$eq($int2ulong(1)) && TypeSize.$greater(FlexSize)) {
        TypeSize.$minusassign(FlexSize);
      } else if (ArrayTy.getSize().$noteq($int2ulong(0))) {
        return false;
      }
    } else if (RD.hasFlexibleArrayMember()) {
      FlexSize.$assignMove(Ctx.getTypeSizeInChars(ElemType));
    } else {
      return false;
    }
  }
  if (FlexSize.isZero()) {
    return false;
  }
  
  CharUnits Left = RegionSize.$sub(TypeSize);
  if (Left.isNegative()) {
    return false;
  }
  
  return Left.$mod(FlexSize) == 0;
}

} // END OF class CastSizeCheckerStatics
