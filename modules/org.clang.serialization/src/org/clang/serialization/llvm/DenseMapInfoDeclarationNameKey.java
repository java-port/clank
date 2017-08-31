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

package org.clang.serialization.llvm;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.serialization.*;
import org.llvm.adt.DenseMapInfo;

//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<DeclarationNameKey>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1618,
 FQN="llvm::DenseMapInfo<DeclarationNameKey>", NM="_ZN4llvm12DenseMapInfoIN5clang13serialization18DeclarationNameKeyEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang13serialization18DeclarationNameKeyEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoDeclarationNameKey implements DenseMapInfo<DeclarationNameKey> {
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<DeclarationNameKey>::getEmptyKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1619,
   FQN="llvm::DenseMapInfo<DeclarationNameKey>::getEmptyKey", NM="_ZN4llvm12DenseMapInfoIN5clang13serialization18DeclarationNameKeyEE11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang13serialization18DeclarationNameKeyEE11getEmptyKeyEv")
  //</editor-fold>
  public DeclarationNameKey getEmptyKey() {
    return EmptyKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<DeclarationNameKey>::getTombstoneKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1622,
   FQN="llvm::DenseMapInfo<DeclarationNameKey>::getTombstoneKey", NM="_ZN4llvm12DenseMapInfoIN5clang13serialization18DeclarationNameKeyEE15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang13serialization18DeclarationNameKeyEE15getTombstoneKeyEv")
  //</editor-fold>
  public DeclarationNameKey getTombstoneKey() {
    return TombstoneKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<DeclarationNameKey>::getHashValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1625,
   FQN="llvm::DenseMapInfo<DeclarationNameKey>::getHashValue", NM="_ZN4llvm12DenseMapInfoIN5clang13serialization18DeclarationNameKeyEE12getHashValueERKS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang13serialization18DeclarationNameKeyEE12getHashValueERKS3_")
  //</editor-fold>
  public /*uint*/int getHashValue(final /*const*/ DeclarationNameKey /*&*/ Key) {
    return Key.getHash();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<DeclarationNameKey>::isEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1629,
   FQN="llvm::DenseMapInfo<DeclarationNameKey>::isEqual", NM="_ZN4llvm12DenseMapInfoIN5clang13serialization18DeclarationNameKeyEE7isEqualERKS3_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang13serialization18DeclarationNameKeyEE7isEqualERKS3_S6_")
  //</editor-fold>
  public boolean isEqual(final /*const*/ DeclarationNameKey /*&*/ L, 
         final /*const*/ DeclarationNameKey /*&*/ R) {
    return DeclarationNameKey.$eq_DeclarationNameKey$C(L, R);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final DeclarationNameKey EmptyKey = new DeclarationNameKey(-1, $int2ulong(1));
  public static final DeclarationNameKey TombstoneKey = new DeclarationNameKey(-1, $int2ulong(2));

  @Override
  public boolean isKeyPointerLike() {
    return false; // DeclarationNameKey is cloneable Value-type
  }
  
  private static DenseMapInfoDeclarationNameKey INFO = new DenseMapInfoDeclarationNameKey();
  public static DenseMapInfoDeclarationNameKey $Info() {
    return INFO;
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
