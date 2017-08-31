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

package org.clang.codegen.CodeGen.impl;

import org.clank.java.std;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.clank.support.Native.NativePOD;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::OrderGlobalInits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 97,
 FQN="clang::CodeGen::OrderGlobalInits", NM="_ZN5clang7CodeGen16OrderGlobalInitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen16OrderGlobalInitsE")
//</editor-fold>
public class/*struct*/ OrderGlobalInits implements Native.NativeComparable<OrderGlobalInits>, NativePOD<OrderGlobalInits> {
  public /*uint*/int priority;
  public /*uint*/int lex_order;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::OrderGlobalInits::OrderGlobalInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 100,
   FQN="clang::CodeGen::OrderGlobalInits::OrderGlobalInits", NM="_ZN5clang7CodeGen16OrderGlobalInitsC1Ejj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen16OrderGlobalInitsC1Ejj")
  //</editor-fold>
  public OrderGlobalInits(/*uint*/int p, /*uint*/int l) {
    // : priority(p), lex_order(l) 
    //START JInit
    this.priority = p;
    this.lex_order = l;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::OrderGlobalInits::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 103,
   FQN="clang::CodeGen::OrderGlobalInits::operator==", NM="_ZNK5clang7CodeGen16OrderGlobalInitseqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZNK5clang7CodeGen16OrderGlobalInitseqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ OrderGlobalInits /*&*/ RHS) /*const*/ {
    return priority == RHS.priority && lex_order == RHS.lex_order;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::OrderGlobalInits::operator<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 107,
   FQN="clang::CodeGen::OrderGlobalInits::operator<", NM="_ZNK5clang7CodeGen16OrderGlobalInitsltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZNK5clang7CodeGen16OrderGlobalInitsltERKS1_")
  //</editor-fold>
  public boolean $less(final /*const*/ OrderGlobalInits /*&*/ RHS) /*const*/ {
    return $less_tuple_int$C(new std.pairIntInt(priority, lex_order), 
        new std.pairIntInt(RHS.priority, RHS.lex_order));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::OrderGlobalInits::OrderGlobalInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 97,
   FQN="clang::CodeGen::OrderGlobalInits::OrderGlobalInits", NM="_ZN5clang7CodeGen16OrderGlobalInitsC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen16OrderGlobalInitsC1ERKS1_")
  //</editor-fold>
  public /*inline*/ OrderGlobalInits(final /*const*/ OrderGlobalInits /*&*/ $Prm0) {
    // : priority(.priority), lex_order(.lex_order) 
    //START JInit
    this.priority = $Prm0.priority;
    this.lex_order = $Prm0.lex_order;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::OrderGlobalInits::OrderGlobalInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 97,
   FQN="clang::CodeGen::OrderGlobalInits::OrderGlobalInits", NM="_ZN5clang7CodeGen16OrderGlobalInitsC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen16OrderGlobalInitsC1EOS1_")
  //</editor-fold>
  public /*inline*/ OrderGlobalInits(JD$Move _dparam, final OrderGlobalInits /*&&*/$Prm0) {
    // : priority(static_cast<OrderGlobalInits &&>().priority), lex_order(static_cast<OrderGlobalInits &&>().lex_order) 
    //START JInit
    this.priority = $Prm0.priority;
    this.lex_order = $Prm0.lex_order;
    //END JInit
  }

  public OrderGlobalInits() {
    this.priority = 0;
    this.lex_order = 0;
  }

  @Override public OrderGlobalInits $assign(OrderGlobalInits $Prm0) {
    this.priority = $Prm0.priority;
    this.lex_order = $Prm0.lex_order;
    return this;
  }

  @Override public OrderGlobalInits clone() {
    return new OrderGlobalInits(this);
  }
  
  @Override public String toString() {
    return "" + "priority=" + priority // NOI18N
              + ", lex_order=" + lex_order; // NOI18N
  }
}
