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
package org.clang.codegen.impl;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.codegen.impl.*;
import org.llvm.ir.Type;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGExprComplexStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZL12getComplexOpN5clang18BinaryOperatorKindE;_ZL14getComplexTypeN5clang8QualTypeE;_ZL29getComplexMultiplyLibCallNamePN4llvm4TypeE; -static-type=CGExprComplexStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGExprComplexStatics {


/// Return the complex type that we are meant to emit.
//<editor-fold defaultstate="collapsed" desc="getComplexType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 36,
 FQN="getComplexType", NM="_ZL14getComplexTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZL14getComplexTypeN5clang8QualTypeE")
//</editor-fold>
public static /*const*/ ComplexType /*P*/ getComplexType(QualType type) {
  type.$assignMove(type.getCanonicalType());
  {
    /*const*/ ComplexType /*P*/ comp = dyn_cast_ComplexType(type);
    if ((comp != null)) {
      return comp;
    } else {
      return cast_ComplexType(cast_AtomicType(type).getValueType());
    }
  }
}


/// \brief Lookup the libcall name for a given floating point type complex
/// multiply.
//<editor-fold defaultstate="collapsed" desc="getComplexMultiplyLibCallName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 613,
 FQN="getComplexMultiplyLibCallName", NM="_ZL29getComplexMultiplyLibCallNamePN4llvm4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZL29getComplexMultiplyLibCallNamePN4llvm4TypeE")
//</editor-fold>
public static StringRef getComplexMultiplyLibCallName(Type /*P*/ Ty) {
  switch (Ty.getTypeID()) {
   default:
    throw new llvm_unreachable("Unsupported floating point type!");
   case HalfTyID:
    return new StringRef(/*KEEP_STR*/"__mulhc3");
   case FloatTyID:
    return new StringRef(/*KEEP_STR*/"__mulsc3");
   case DoubleTyID:
    return new StringRef(/*KEEP_STR*/"__muldc3");
   case PPC_FP128TyID:
    return new StringRef(/*KEEP_STR*/"__multc3");
   case X86_FP80TyID:
    return new StringRef(/*KEEP_STR*/"__mulxc3");
   case FP128TyID:
    return new StringRef(/*KEEP_STR*/"__multc3");
  }
}

//<editor-fold defaultstate="collapsed" desc="getComplexOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp", line = 1083,
 FQN="getComplexOp", NM="_ZL12getComplexOpN5clang18BinaryOperatorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprComplex.cpp -nm=_ZL12getComplexOpN5clang18BinaryOperatorKindE")
//</editor-fold>
public static ComplexExprEmitter.BinOpInfo2ComplexPairTy getComplexOp(BinaryOperatorKind Op) {
  switch (Op) {
   case BO_MulAssign:
    return /*AddrOf*//*FPtr*/ComplexExprEmitter::EmitBinMul;
   case BO_DivAssign:
    return /*AddrOf*//*FPtr*/ComplexExprEmitter::EmitBinDiv;
   case BO_SubAssign:
    return /*AddrOf*//*FPtr*/ComplexExprEmitter::EmitBinSub;
   case BO_AddAssign:
    return /*AddrOf*//*FPtr*/ComplexExprEmitter::EmitBinAdd;
   default:
    throw new llvm_unreachable("unexpected complex compound assignment");
  }
}

} // END OF class CGExprComplexStatics
