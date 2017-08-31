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
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type MallocSizeofCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_1L15typesCompatibleERN5clang10ASTContextENS0_8QualTypeES3_;_ZN12_GLOBAL__N_1L23compatibleWithArrayTypeERN5clang10ASTContextENS0_8QualTypeES3_; -static-type=MallocSizeofCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class MallocSizeofCheckerStatics {


// Determine if the pointee and sizeof types are compatible.  Here
// we ignore constness of pointer types.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::typesCompatible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 138,
 FQN="(anonymous namespace)::typesCompatible", NM="_ZN12_GLOBAL__N_1L15typesCompatibleERN5clang10ASTContextENS0_8QualTypeES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_1L15typesCompatibleERN5clang10ASTContextENS0_8QualTypeES3_")
//</editor-fold>
public static boolean typesCompatible(final ASTContext /*&*/ C, QualType A, QualType B) {
  // sizeof(void*) is compatible with any other pointer.
  if (B.$arrow().isVoidPointerType() && (A.$arrow().getAs(PointerType.class) != null)) {
    return true;
  }
  while (true) {
    A.$assignMove(A.getCanonicalType());
    B.$assignMove(B.getCanonicalType());
    if (A.getTypePtr() == B.getTypePtr()) {
      return true;
    }
    {
      
      /*const*/ PointerType /*P*/ ptrA = A.$arrow().getAs(PointerType.class);
      if ((ptrA != null)) {
        {
          /*const*/ PointerType /*P*/ ptrB = B.$arrow().getAs(PointerType.class);
          if ((ptrB != null)) {
            A.$assignMove(ptrA.getPointeeType());
            B.$assignMove(ptrB.getPointeeType());
            continue;
          }
        }
      }
    }
    
    break;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::compatibleWithArrayType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 163,
 FQN="(anonymous namespace)::compatibleWithArrayType", NM="_ZN12_GLOBAL__N_1L23compatibleWithArrayTypeERN5clang10ASTContextENS0_8QualTypeES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_1L23compatibleWithArrayTypeERN5clang10ASTContextENS0_8QualTypeES3_")
//</editor-fold>
public static boolean compatibleWithArrayType(final ASTContext /*&*/ C, QualType PT, QualType T) {
  {
    // Ex: 'int a[10][2]' is compatible with 'int', 'int[2]', 'int[10][2]'.
    /*const*/ ArrayType /*P*/ AT;
    while (((/*P*/ AT = T.$arrow().getAsArrayTypeUnsafe()) != null)) {
      QualType ElemType = AT.getElementType();
      if (typesCompatible(C, new QualType(PT), AT.getElementType())) {
        return true;
      }
      T.$assign(ElemType);
    }
  }
  
  return false;
}

} // END OF class MallocSizeofCheckerStatics
