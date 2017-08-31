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
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.adt.HashingGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<BasicBlockEdge>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 58,
 FQN="llvm::DenseMapInfo<BasicBlockEdge>", NM="_ZN4llvm12DenseMapInfoINS_14BasicBlockEdgeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm12DenseMapInfoINS_14BasicBlockEdgeEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoBasicBlockEdge implements DenseMapInfo<BasicBlockEdge> {
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<BasicBlockEdge>::getHashValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 59,
   FQN="llvm::DenseMapInfo<BasicBlockEdge>::getHashValue", NM="_ZN4llvm12DenseMapInfoINS_14BasicBlockEdgeEE12getHashValueEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm12DenseMapInfoINS_14BasicBlockEdgeEE12getHashValueEPKS1_")
  //</editor-fold>
  public /*uint*/int getHashValue_BasicBlockEdge$C$P(/*const*/ BasicBlockEdge /*P*/ V) {
    return getHashValue(V);
  }


  // JAVA: typedef DenseMapInfo<const BasicBlock *> BBInfo
//  public final class BBInfo extends DenseMapInfoT$P</*const*/ BasicBlock>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<BasicBlockEdge>::getEmptyKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 61,
   FQN="llvm::DenseMapInfo<BasicBlockEdge>::getEmptyKey", NM="_ZN4llvm12DenseMapInfoINS_14BasicBlockEdgeEE11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm12DenseMapInfoINS_14BasicBlockEdgeEE11getEmptyKeyEv")
  //</editor-fold>
  public BasicBlockEdge getEmptyKey() {
    return emptyKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<BasicBlockEdge>::getTombstoneKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 64,
   FQN="llvm::DenseMapInfo<BasicBlockEdge>::getTombstoneKey", NM="_ZN4llvm12DenseMapInfoINS_14BasicBlockEdgeEE15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm12DenseMapInfoINS_14BasicBlockEdgeEE15getTombstoneKeyEv")
  //</editor-fold>
  public Object getTombstoneKey() {
    return tombstoneKey;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<BasicBlockEdge>::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 68,
   FQN="llvm::DenseMapInfo<BasicBlockEdge>::getHashValue", NM="_ZN4llvm12DenseMapInfoINS_14BasicBlockEdgeEE12getHashValueERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm12DenseMapInfoINS_14BasicBlockEdgeEE12getHashValueERKS1_")
  //</editor-fold>
  public /*uint*/int getHashValue_BasicBlockEdge$C(final /*const*/ BasicBlockEdge /*&*/ Edge) {
    return hash_combine(DenseMapInfo$LikePtr.$Info().getHashValue(Edge.getStart()),
        DenseMapInfo$LikePtr.$Info().getHashValue(Edge.getEnd())).$uint();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<BasicBlockEdge>::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 72,
   FQN="llvm::DenseMapInfo<BasicBlockEdge>::isEqual", NM="_ZN4llvm12DenseMapInfoINS_14BasicBlockEdgeEE7isEqualERKS1_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm12DenseMapInfoINS_14BasicBlockEdgeEE7isEqualERKS1_S4_")
  //</editor-fold>
  public boolean isEqual(final /*const*/ BasicBlockEdge /*&*/ LHS, final /*const*/ BasicBlockEdge /*&*/ RHS) {
    return DenseMapInfo$LikePtr.$Info().isEqual(LHS.getStart(), RHS.getStart())
       && DenseMapInfo$LikePtr.$Info().isEqual(LHS.getEnd(), RHS.getEnd());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static DenseMapInfoBasicBlockEdge $INFO = new DenseMapInfoBasicBlockEdge();

  public static DenseMapInfoBasicBlockEdge $Info() {
    return $INFO;
  }

  @Override
  public boolean isKeyPointerLike() {
    return false;
  }

  public /*uint*/int getHashValue(final /*const*/ BasicBlockEdge /*&*/ Edge) {
    //return hash_combine(DenseMapInfo$LikePtr.$Info().getHashValue(Edge.getStart()),
    //    DenseMapInfo$LikePtr.$Info().getHashValue(Edge.getEnd())).$uint();
    return getHashValue_BasicBlockEdge$C(Edge);
  }

  private final BasicBlockEdge emptyKey = new BasicBlockEdge((BasicBlock) null, (BasicBlock) null);

  private final BasicBlockEdge tombstoneKey = new BasicBlockEdge((BasicBlock) null, (BasicBlock) null);

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return ""; // NOI18N
  }
}
