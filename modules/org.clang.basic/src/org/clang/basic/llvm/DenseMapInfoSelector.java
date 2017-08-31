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
import org.llvm.adt.*;
import org.clang.basic.*;

/// Define DenseMapInfo so that Selectors can be used as keys in DenseMap and
/// DenseSets.
//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::Selector>">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 831,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 816,
 FQN="llvm::DenseMapInfo<clang::Selector>", NM="_ZN4llvm12DenseMapInfoIN5clang8SelectorEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang8SelectorEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoSelector implements DenseMapInfo<Selector> {
  private static final DenseMapInfoSelector $INFO = new DenseMapInfoSelector();
  public static DenseMapInfoSelector $Info() { return $INFO; }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::Selector>::getEmptyKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 833,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 818,
   FQN="llvm::DenseMapInfo<clang::Selector>::getEmptyKey", NM="_ZN4llvm12DenseMapInfoIN5clang8SelectorEE11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang8SelectorEE11getEmptyKeyEv")
  //</editor-fold>
  private static final Selector emptyKey = Selector.getEmptyMarker();

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::Selector>::getTombstoneKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 836,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 821,
   FQN="llvm::DenseMapInfo<clang::Selector>::getTombstoneKey", NM="_ZN4llvm12DenseMapInfoIN5clang8SelectorEE15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang8SelectorEE15getTombstoneKeyEv")
  //</editor-fold>
  private static final Selector tombstoneKey = Selector.getTombstoneMarker();

  private DenseMapInfoSelector() {
  }

  @Override
  public Selector getEmptyKey() {
    return emptyKey;
  }

  @Override
  public Selector getTombstoneKey() {
    return tombstoneKey;
  }
  
  //===----------------------------------------------------------------------===//
  // SelectorTable Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::Selector>::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 345,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 344,
   FQN="llvm::DenseMapInfo<clang::Selector>::getHashValue", NM="_ZN4llvm12DenseMapInfoIN5clang8SelectorEE12getHashValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang8SelectorEE12getHashValueES2_")
  //</editor-fold>
  @Override
  public /*uint*/int getHashValue(Selector Obj) {
    assert Obj != emptyKey : "must not be called for emptyKey";
    assert Obj != tombstoneKey : "must not be called for tombstoneKey";    
    Selector S = (Selector)Obj;
    return System.identityHashCode(S.$InfoPtr) | S.$InfoPtrBits;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::Selector>::isEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 842,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 827,
   FQN="llvm::DenseMapInfo<clang::Selector>::isEqual", NM="_ZN4llvm12DenseMapInfoIN5clang8SelectorEE7isEqualES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang8SelectorEE7isEqualES2_S2_")
  //</editor-fold>
  @Override
  public boolean isEqual(Selector LHS, Selector RHS) {
    assert LHS != emptyKey : "LHS: must not be called for emptyKey";
    assert LHS != tombstoneKey : "LHS: must not be called for tombstoneKey";    
    assert RHS != emptyKey : "RHS: must not be called for emptyKey";
    assert RHS != tombstoneKey : "RHS: must not be called for tombstoneKey";      
    return ((Selector)LHS).$eq(/*NO_COPY*/(Selector)RHS);
  }

  @Override
  public boolean isKeyPointerLike() {
    return false;
  }

  public String toString() {
    return "DenseMapInfoSelector"; // NOI18N
  }
}
