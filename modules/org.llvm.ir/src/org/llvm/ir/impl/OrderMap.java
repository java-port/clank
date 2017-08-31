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

package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OrderMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 58,
 FQN="(anonymous namespace)::OrderMap", NM="_ZN12_GLOBAL__N_18OrderMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_18OrderMapE")
//</editor-fold>
public class/*struct*/ OrderMap implements Destructors.ClassWithDestructor {
  public DenseMap</*const*/ Value /*P*/ , std.pairUIntBool> IDs;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OrderMap::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 61,
   FQN="(anonymous namespace)::OrderMap::size", NM="_ZNK12_GLOBAL__N_18OrderMap4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK12_GLOBAL__N_18OrderMap4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return IDs.size();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OrderMap::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 62,
   FQN="(anonymous namespace)::OrderMap::operator[]", NM="_ZN12_GLOBAL__N_18OrderMapixEPKN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_18OrderMapixEPKN4llvm5ValueE")
  //</editor-fold>
  public std.pairUIntBool/*&*/ $at(/*const*/ Value /*P*/ V) {
    return IDs.$at_T1$C$R(V);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OrderMap::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 63,
   FQN="(anonymous namespace)::OrderMap::lookup", NM="_ZNK12_GLOBAL__N_18OrderMap6lookupEPKN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK12_GLOBAL__N_18OrderMap6lookupEPKN4llvm5ValueE")
  //</editor-fold>
  public std.pairUIntBool lookup(/*const*/ Value /*P*/ V) /*const*/ {
    return IDs.lookup(V);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OrderMap::index">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 66,
   FQN="(anonymous namespace)::OrderMap::index", NM="_ZN12_GLOBAL__N_18OrderMap5indexEPKN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_18OrderMap5indexEPKN4llvm5ValueE")
  //</editor-fold>
  public void index(/*const*/ Value /*P*/ V) {
    // Explicitly sequence get-size and insert-value operations to avoid UB.
    /*uint*/int ID = IDs.size() + 1;
    IDs.$at_T1$C$R(V).first = ID;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OrderMap::OrderMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 58,
   FQN="(anonymous namespace)::OrderMap::OrderMap", NM="_ZN12_GLOBAL__N_18OrderMapC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_18OrderMapC1EOS0_")
  //</editor-fold>
  public /*inline*/ OrderMap(JD$Move _dparam, final OrderMap /*&&*/$Prm0) {
    // : IDs(static_cast<OrderMap &&>().IDs) 
    //START JInit
    this.IDs = new DenseMap</*const*/ Value /*P*/ , std.pairUIntBool>(JD$Move.INSTANCE, $Prm0.IDs);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OrderMap::~OrderMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 58,
   FQN="(anonymous namespace)::OrderMap::~OrderMap", NM="_ZN12_GLOBAL__N_18OrderMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_18OrderMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    IDs.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OrderMap::OrderMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 58,
   FQN="(anonymous namespace)::OrderMap::OrderMap", NM="_ZN12_GLOBAL__N_18OrderMapC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_18OrderMapC1Ev")
  //</editor-fold>
  public /*inline*/ OrderMap() {
    // : IDs() 
    //START JInit
    this.IDs = new DenseMap</*const*/ Value /*P*/ , std.pairUIntBool>(DenseMapInfo$LikePtr.$Info(), new std.pairUIntBool());
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "IDs=" + IDs; // NOI18N
  }
}
