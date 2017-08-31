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

package org.llvm.ir;

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.ir.*;


//===----------------------------------------------------------------------===//
/// \class
/// \brief Provide DenseMapInfo for AttributeSet.
//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<AttributeSet>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 420,
 FQN="llvm::DenseMapInfo<AttributeSet>", NM="_ZN4llvm12DenseMapInfoINS_12AttributeSetEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12DenseMapInfoINS_12AttributeSetEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoAttributeSet implements DenseMapInfo<AttributeSet> {
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<AttributeSet>::getEmptyKey">

  protected final Object/*P*/ emptyKey = new String("DenseMapInfoAttributeSet.emptyKey");
  protected final Object/*P*/ tombstoneKey = new String("DenseMapInfoAttributeSet.tombstoneKey");

  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 421,
   FQN="llvm::DenseMapInfo<AttributeSet>::getEmptyKey", NM="_ZN4llvm12DenseMapInfoINS_12AttributeSetEE11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12DenseMapInfoINS_12AttributeSetEE11getEmptyKeyEv")
  //</editor-fold>
  public /*inline*/ Object getEmptyKey() {
    return emptyKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<AttributeSet>::getTombstoneKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 426,
   FQN="llvm::DenseMapInfo<AttributeSet>::getTombstoneKey", NM="_ZN4llvm12DenseMapInfoINS_12AttributeSetEE15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12DenseMapInfoINS_12AttributeSetEE15getTombstoneKeyEv")
  //</editor-fold>
  public Object getTombstoneKey() {
    return tombstoneKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<AttributeSet>::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 431,
   FQN="llvm::DenseMapInfo<AttributeSet>::getHashValue", NM="_ZN4llvm12DenseMapInfoINS_12AttributeSetEE12getHashValueES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12DenseMapInfoINS_12AttributeSetEE12getHashValueES1_")
  //</editor-fold>
  public int getHashValue(AttributeSet AS) {
    return (System.identityHashCode(AS.pImpl) >>> 4)
       ^ (System.identityHashCode(AS.pImpl) >>> 9);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<AttributeSet>::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 435,
   FQN="llvm::DenseMapInfo<AttributeSet>::isEqual", NM="_ZN4llvm12DenseMapInfoINS_12AttributeSetEE7isEqualES1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm12DenseMapInfoINS_12AttributeSetEE7isEqualES1_S1_")
  //</editor-fold>
  public boolean isEqual(AttributeSet LHS, AttributeSet RHS) {
    return LHS.$eq(RHS);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static DenseMapInfoAttributeSet $INFO = new DenseMapInfoAttributeSet();

  public static DenseMapInfoAttributeSet $Info() {
    return $INFO;
  }

  @Override
  public boolean isKeyPointerLike() {
    return false;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return ""; // NOI18N
  }
}
