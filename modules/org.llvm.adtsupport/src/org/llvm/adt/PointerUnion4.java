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

package org.llvm.adt;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;


/// A pointer union of four pointer types. See documentation for PointerUnion
/// for usage.
/*template <typename PT1, typename PT2, typename PT3, typename PT4> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PointerUnion4">
@Converted(kind = Converted.Kind.DUMMY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", line = 344,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/PointerUnion.h", old_line = 361,
 FQN="llvm::PointerUnion4", NM="_ZN4llvm13PointerUnion4E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN4llvm13PointerUnion4E")
//</editor-fold>
public final class PointerUnion4</*typename*/ PT1, /*typename*/ PT2, /*typename*/ PT3, /*typename*/ PT4> extends PointerUnionBase<PointerUnion4<PT1, PT2, PT3, PT4>> {

  public PointerUnion4(Class<PT1> cls) {
    // null of the first class
    super(cls, (PT1)null);
  }

  public PointerUnion4(JD$T _diff, Class<PT1> cls, PT1 Val) {
    super(cls, Val);
  }
  
  public PointerUnion4(JD$T1 _diff, Class<PT2> cls, PT2 Val) {
    super(cls, Val);
  }
  
  public PointerUnion4(JD$T2 _diff, Class<PT3> cls, PT3 Val) {
    super(cls, Val);
  }

  public PointerUnion4(JD$T3 _diff, Class<PT4> cls, PT4 Val) {
    super(cls, Val);
  }

  public PointerUnion4<PT1, PT2, PT3, PT4> $assign_T$C$R(Class<PT1> cls, final /*const*/ PT1 /*&*/ RHS) {
    super.assign_impl(cls, RHS);
    return this;
  }

  public PointerUnion4<PT1, PT2, PT3, PT4> $assign_T1$C$R(Class<PT2> cls, final /*const*/ PT2 /*&*/ RHS) {
    super.assign_impl(cls, RHS);
    return this;  
  }
  
  public PointerUnion4<PT1, PT2, PT3, PT4> $assign_T2$C$R(Class<PT3> cls, final /*const*/ PT3 /*&*/ RHS) {
    super.assign_impl(cls, RHS);
    return this;
  }
  
  public PointerUnion4<PT1, PT2, PT3, PT4> $assign_T3$C$R(Class<PT4> cls, final /*const*/ PT4 /*&*/ RHS) {
    super.assign_impl(cls, RHS);
    return this;
  }
  
  public /*const*/ type$ptr<PT1 /*P*/> getAddrOfPtr1$Const(Class<PT1> cls) /*const*/ {
    return super.$getAddrOfPointer(cls);
  }
  
  public type$ptr<PT1 /*P*/> getAddrOfPtr1(Class<PT1> cls) {
    return super.$getAddrOfPointer(cls);
  }   
  
  public static <T1, T2, T3, T4> PointerUnion4<T1, T2, T3, T4> getFromOpaqueValue(Object Data){
    PointerUnion4<T1, T2, T3, T4> V = new PointerUnion4(Data);
    return V;
  };
  
  public PointerUnion4(PointerUnion4<PT1, PT2, PT3, PT4> /*&*/ RHS) {
    super(RHS);
  }

  public PointerUnion4(JD$Move _dparam, PointerUnion4<PT1, PT2, PT3, PT4> /*&*/ RHS) {
    super(_dparam, RHS);
  }  
  
  @Override
  public PointerUnion4<PT1, PT2, PT3, PT4> clone() {
    return new PointerUnion4(this);
  }
  
  private PointerUnion4(Object Data) { super(Data); }
}
