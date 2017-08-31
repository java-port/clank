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

package org.clang.ast.llvm;

import org.clank.support.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstMemberPointers.*;

//<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<LazyGenerationalUpdatePtr<type-parameter-0-0, type-parameter-0-1, Update> >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 462,
 FQN="llvm::PointerLikeTypeTraits<LazyGenerationalUpdatePtr<type-parameter-0-0, type-parameter-0-1, Update> >", NM="_ZN4llvm21PointerLikeTypeTraitsIN5clang25LazyGenerationalUpdatePtrIT_T0_XT1_EEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIN5clang25LazyGenerationalUpdatePtrIT_T0_XT1_EEEEE")
//</editor-fold>
public class/*struct*/ PointerLikeTypeTraitsLazyGenerationalUpdatePtr$T$T_0_1$Update {  
  /*typedef clang::LazyGenerationalUpdatePtr<Owner, T, Update> Ptr*/
//  public final class Ptr extends LazyGenerationalUpdatePtr<Owner, T, Update>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<LazyGenerationalUpdatePtr<type-parameter-0-0, type-parameter-0-1, Update> >::getAsVoidPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 467,
   FQN="llvm::PointerLikeTypeTraits<LazyGenerationalUpdatePtr<type-parameter-0-0, type-parameter-0-1, Update> >::getAsVoidPointer", NM="_ZN4llvm21PointerLikeTypeTraitsIN5clang25LazyGenerationalUpdatePtrIT_T0_XT1_EEEE16getAsVoidPointerES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIN5clang25LazyGenerationalUpdatePtrIT_T0_XT1_EEEE16getAsVoidPointerES5_")
  //</editor-fold>
  public static <Owner extends Decl, T extends Decl> Object getAsVoidPointer(LazyGenerationalUpdatePtr<Owner, T> P) {
    return P.getOpaqueValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<LazyGenerationalUpdatePtr<type-parameter-0-0, type-parameter-0-1, Update> >::getFromVoidPointer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 468,
   FQN="llvm::PointerLikeTypeTraits<LazyGenerationalUpdatePtr<type-parameter-0-0, type-parameter-0-1, Update> >::getFromVoidPointer", NM="_ZN4llvm21PointerLikeTypeTraitsIN5clang25LazyGenerationalUpdatePtrIT_T0_XT1_EEEE18getFromVoidPointerEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIN5clang25LazyGenerationalUpdatePtrIT_T0_XT1_EEEE18getFromVoidPointerEPv")
  //</editor-fold>
  public static <Owner extends Decl, T extends Decl> LazyGenerationalUpdatePtr<Owner, T> getFromVoidPointer(ExternalASTSource$Decl2Void Update, Object/*void P*/ P) {
    return LazyGenerationalUpdatePtr.getFromOpaqueValue(Update, P);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerLikeTypeTraits<LazyGenerationalUpdatePtr<type-parameter-0-0, type-parameter-0-1, Update> >::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*replaced field by function*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 469,
   FQN="llvm::PointerLikeTypeTraits<LazyGenerationalUpdatePtr<type-parameter-0-0, type-parameter-0-1, Update> >::(anonymous)", NM="_ZN4llvm21PointerLikeTypeTraitsIN5clang25LazyGenerationalUpdatePtrIT_T0_XT1_EEEEE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN4llvm21PointerLikeTypeTraitsIN5clang25LazyGenerationalUpdatePtrIT_T0_XT1_EEEEE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
  public static <T> int NumLowBitsAvailable(Class<T> cls) {
    return 0;
  }
  /*}*/;
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
