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
import static org.clank.support.Native.$tryClone;


/// UnionOpaquePtr - A version of OpaquePtr suitable for membership
/// in a union.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::UnionOpaquePtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 91,
 FQN="clang::UnionOpaquePtr", NM="_ZN5clang14UnionOpaquePtrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang14UnionOpaquePtrE")
//</editor-fold>
public class/*struct*/ UnionOpaquePtr</*class*/ T>  {
  public Object/*void P*/ Ptr;
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnionOpaquePtr::make">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 94,
   FQN="clang::UnionOpaquePtr::make", NM="_ZN5clang14UnionOpaquePtr4makeENS_9OpaquePtrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang14UnionOpaquePtr4makeENS_9OpaquePtrIT_EE")
  //</editor-fold>
  public static </*class*/ T> UnionOpaquePtr<T> make(OpaquePtr<T> P) {
    UnionOpaquePtr<T> OP = (UnionOpaquePtr<T>)new UnionOpaquePtr<T>();
    OP.Ptr = $tryClone(P.getAsOpaquePtr());
    return OP;
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  UnionOpaquePtr(UnionOpaquePtr<T> $Prm0) {
    this.Ptr = $tryClone($Prm0.Ptr);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnionOpaquePtr::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 99,
   FQN="clang::UnionOpaquePtr::get", NM="_ZNK5clang14UnionOpaquePtr3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang14UnionOpaquePtr3getEv")
  //</editor-fold>
  public OpaquePtr<T> get() /*const*/ {
    return OpaquePtr.<T>getFromOpaquePtr(Ptr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnionOpaquePtr::operator OpaquePtr<type-parameter-0-0>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 100,
   FQN="clang::UnionOpaquePtr::operator OpaquePtr<type-parameter-0-0>", NM="_ZNK5clang14UnionOpaquePtrcvNS_9OpaquePtrIT_EEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang14UnionOpaquePtrcvNS_9OpaquePtrIT_EEEv")
  //</editor-fold>
  public OpaquePtr<T> $OpaquePtr$T() /*const*/ {
    return get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnionOpaquePtr::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 102,
   FQN="clang::UnionOpaquePtr::operator=", NM="_ZN5clang14UnionOpaquePtraSENS_9OpaquePtrIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang14UnionOpaquePtraSENS_9OpaquePtrIT_EE")
  //</editor-fold>
  public UnionOpaquePtr<T> /*&*/ $assign(OpaquePtr<T> P) {
    Ptr = $tryClone(P.getAsOpaquePtr());
    return Native.$star(this);
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  void $assign(UnionOpaquePtr<T> TrailingReturnType) {
    this.Ptr = $tryClone(TrailingReturnType.Ptr);
  }
  
  @Override public String toString() {
    return "" + "Ptr=" + Ptr; // NOI18N
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public UnionOpaquePtr<T> $assignMove(UnionOpaquePtr<T> TrailingReturnType) {
    this.Ptr = TrailingReturnType.Ptr;
    TrailingReturnType.Ptr = null;
    return this;
  }
  
  protected UnionOpaquePtr() {}
}
