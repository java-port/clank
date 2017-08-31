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

package org.llvm.support;

import org.clank.support.*;


// Provide PointerLikeTypeTraits for const pointers.
//<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<const type-parameter-0-0 * >">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", line = 66,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", old_line = 64,
 FQN="llvm::PointerLikeTypeTraits<const type-parameter-0-0 * >", NM="_ZN4llvm21PointerLikeTypeTraitsIPKT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPKT_EE")
//</editor-fold>
public class PointerLikeTypeTraitsT$C$P<T> {
  /*typedef PointerLikeTypeTraits<T *> NonConst*/
//  public final class NonConst extends PointerLikeTypeTraits<T /*P*/ >{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<const type-parameter-0-0 * >::getAsVoidPointer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", line = 70,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", old_line = 68,
   FQN="llvm::PointerLikeTypeTraits<const type-parameter-0-0 * >::getAsVoidPointer", NM="_ZN4llvm21PointerLikeTypeTraitsIPKT_E16getAsVoidPointerES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPKT_E16getAsVoidPointerES3_")
  //</editor-fold>
  public static <T>/*inline*/ /*const*/Object/*void P*/ getAsVoidPointer(/*const*/ T /*P*/ P) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<const type-parameter-0-0 * >::getFromVoidPointer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", line = 73,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", old_line = 71,
   FQN="llvm::PointerLikeTypeTraits<const type-parameter-0-0 * >::getFromVoidPointer", NM="_ZN4llvm21PointerLikeTypeTraitsIPKT_E18getFromVoidPointerEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPKT_E18getFromVoidPointerEPKv")
  //</editor-fold>
  public static <T>/*inline*/ /*const*/ T /*P*/ getFromVoidPointer(/*const*/Object/*void P*/ P) {
    throw new UnsupportedOperationException("EmptyBody");
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<const type-parameter-0-0 * >::(anonymous)">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", line = 76,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", old_line = 74,
//   FQN="llvm::PointerLikeTypeTraits<const type-parameter-0-0 * >::(anonymous)", NM="_ZN4llvm21PointerLikeTypeTraitsIPKT_EE_Unnamed_enum",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPKT_EE_Unnamed_enum")
//  //</editor-fold>
//  /*enum ANONYMOUS_INT_CONSTANTS {*/
//    public static final /*<dependent type>*/void NumLowBitsAvailable = PointerLikeTypeTraits<T /*P*/ >.NumLowBitsAvailable;
//  /*}*/;
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
