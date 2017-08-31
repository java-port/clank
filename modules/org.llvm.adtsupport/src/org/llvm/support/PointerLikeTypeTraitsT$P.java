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


// Provide PointerLikeTypeTraits for non-cvr pointers.
//<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<type-parameter-0-0 * >">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", line = 40,
 FQN="llvm::PointerLikeTypeTraits<type-parameter-0-0 * >", NM="_ZN4llvm21PointerLikeTypeTraitsIPT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPT_EE")
//</editor-fold>
public class PointerLikeTypeTraitsT$P<T> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<type-parameter-0-0 * >::getAsVoidPointer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", line = 42,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", old_line = 41,
   FQN="llvm::PointerLikeTypeTraits<type-parameter-0-0 * >::getAsVoidPointer", NM="_ZN4llvm21PointerLikeTypeTraitsIPT_E16getAsVoidPointerES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPT_E16getAsVoidPointerES2_")
  //</editor-fold>
  public static <T>/*inline*/ Object/*void P*/ getAsVoidPointer(T /*P*/ P) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<type-parameter-0-0 * >::getFromVoidPointer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", line = 43,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", old_line = 42,
   FQN="llvm::PointerLikeTypeTraits<type-parameter-0-0 * >::getFromVoidPointer", NM="_ZN4llvm21PointerLikeTypeTraitsIPT_E18getFromVoidPointerEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPT_E18getFromVoidPointerEPv")
  //</editor-fold>
  public static <T> /*inline*/ T /*P*/ getFromVoidPointer(Object/*void P*/ P) {
    throw new UnsupportedOperationException("EmptyBody");
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<type-parameter-0-0 * >::(anonymous)">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", line = 45,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/PointerLikeTypeTraits.h", old_line = 44,
//   FQN="llvm::PointerLikeTypeTraits<type-parameter-0-0 * >::(anonymous)", NM="_ZN4llvm21PointerLikeTypeTraitsIPT_EE_Unnamed_enum",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPT_EE_Unnamed_enum")
//  //</editor-fold>
//  /*enum ANONYMOUS_INT_CONSTANTS {*/
//    public static final /*<dependent type>*/void NumLowBitsAvailable = detail.ConstantLog2<AlignOf<T>.Alignment>.value;
//  /*}*/;
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
