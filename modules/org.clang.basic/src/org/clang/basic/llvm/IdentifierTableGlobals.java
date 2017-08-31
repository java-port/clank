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

package org.clang.basic.llvm;

import org.clank.support.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type IdentifierTableGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPKN5clang14IdentifierInfoEEE;_ZN4llvm21PointerLikeTypeTraitsIPN5clang14IdentifierInfoEEE; -static-type=IdentifierTableGlobals")
//</editor-fold>
public final class IdentifierTableGlobals {


// Provide PointerLikeTypeTraits for IdentifierInfo pointers, which
// are not guaranteed to be 8-byte aligned.
//<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<clang::IdentifierInfo * >">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 866,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 851,
 FQN="llvm::PointerLikeTypeTraits<clang::IdentifierInfo * >", NM="_ZN4llvm21PointerLikeTypeTraitsIPN5clang14IdentifierInfoEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPN5clang14IdentifierInfoEEE")
//</editor-fold>
public static class PointerLikeTypeTraitsIdentifierInfo$P {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<clang::IdentifierInfo * >::getAsVoidPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 869,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 854,
   FQN="llvm::PointerLikeTypeTraits<clang::IdentifierInfo * >::getAsVoidPointer", NM="_ZN4llvm21PointerLikeTypeTraitsIPN5clang14IdentifierInfoEE16getAsVoidPointerES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPN5clang14IdentifierInfoEE16getAsVoidPointerES3_")
  //</editor-fold>
  public static /*inline*/ Object/*void P*/ getAsVoidPointer(IdentifierInfo /*P*/ P) {
    return P;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<clang::IdentifierInfo * >::getFromVoidPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 872,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 857,
   FQN="llvm::PointerLikeTypeTraits<clang::IdentifierInfo * >::getFromVoidPointer", NM="_ZN4llvm21PointerLikeTypeTraitsIPN5clang14IdentifierInfoEE18getFromVoidPointerEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPN5clang14IdentifierInfoEE18getFromVoidPointerEPv")
  //</editor-fold>
  public static /*inline*/ IdentifierInfo /*P*/ getFromVoidPointer(Object/*void P*/ P) {
    return ((/*static_cast*/IdentifierInfo /*P*/ )(P));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<clang::IdentifierInfo * >::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 875,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 860,
   FQN="llvm::PointerLikeTypeTraits<clang::IdentifierInfo * >::(anonymous)", NM="_ZN4llvm21PointerLikeTypeTraitsIPN5clang14IdentifierInfoEEE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPN5clang14IdentifierInfoEEE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumLowBitsAvailable = 1;
  /*}*/;
  
  public String toString() {
    return ""; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<const clang::IdentifierInfo * >">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 878,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 863,
 FQN="llvm::PointerLikeTypeTraits<const clang::IdentifierInfo * >", NM="_ZN4llvm21PointerLikeTypeTraitsIPKN5clang14IdentifierInfoEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPKN5clang14IdentifierInfoEEE")
//</editor-fold>
public static class PointerLikeTypeTraitsIdentifierInfo$C$P {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<const clang::IdentifierInfo * >::getAsVoidPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 881,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 866,
   FQN="llvm::PointerLikeTypeTraits<const clang::IdentifierInfo * >::getAsVoidPointer", NM="_ZN4llvm21PointerLikeTypeTraitsIPKN5clang14IdentifierInfoEE16getAsVoidPointerES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPKN5clang14IdentifierInfoEE16getAsVoidPointerES4_")
  //</editor-fold>
  public static /*inline*/ /*const*/Object/*void P*/ getAsVoidPointer(/*const*/ IdentifierInfo /*P*/ P) {
    return P;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<const clang::IdentifierInfo * >::getFromVoidPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 884,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 869,
   FQN="llvm::PointerLikeTypeTraits<const clang::IdentifierInfo * >::getFromVoidPointer", NM="_ZN4llvm21PointerLikeTypeTraitsIPKN5clang14IdentifierInfoEE18getFromVoidPointerEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPKN5clang14IdentifierInfoEE18getFromVoidPointerEPKv")
  //</editor-fold>
  public static /*inline*/ /*const*/ IdentifierInfo /*P*/ getFromVoidPointer(/*const*/Object/*void P*/ P) {
    return ((/*static_cast*//*const*/ IdentifierInfo /*P*/ )(P));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<const clang::IdentifierInfo * >::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 887,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 872,
   FQN="llvm::PointerLikeTypeTraits<const clang::IdentifierInfo * >::(anonymous)", NM="_ZN4llvm21PointerLikeTypeTraitsIPKN5clang14IdentifierInfoEEE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIPKN5clang14IdentifierInfoEEE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumLowBitsAvailable = 1;
  /*}*/;
  
  public String toString() {
    return ""; // NOI18N
  }
}
} // END OF class IdentifierTableGlobals
