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
package org.clang.staticanalyzer.checkers.llvm.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.checkers.llvm.impl.*;
import org.clang.basic.llvm.DenseMapInfoIdentifierInfo$Ptr;
import org.clang.basic.llvm.DenseMapInfoSelector;

//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<(anonymous)::ObjCSummaryKey>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 492,
 FQN="llvm::DenseMapInfo<(anonymous)::ObjCSummaryKey>", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_114ObjCSummaryKeyEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_114ObjCSummaryKeyEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoObjCSummaryKey implements org.llvm.adt.DenseMapInfo<ObjCSummaryKey> {
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<(anonymous)::ObjCSummaryKey>::getEmptyKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 493,
   FQN="llvm::DenseMapInfo<(anonymous)::ObjCSummaryKey>::getEmptyKey", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_114ObjCSummaryKeyEE11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_114ObjCSummaryKeyEE11getEmptyKeyEv")
  //</editor-fold>
  @Override public /*inline*/ ObjCSummaryKey getEmptyKey() {
    return EmptyKey;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<(anonymous)::ObjCSummaryKey>::getTombstoneKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 498,
   FQN="llvm::DenseMapInfo<(anonymous)::ObjCSummaryKey>::getTombstoneKey", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_114ObjCSummaryKeyEE15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_114ObjCSummaryKeyEE15getTombstoneKeyEv")
  //</editor-fold>
  @Override public /*inline*/ ObjCSummaryKey getTombstoneKey() {
    return TombstoneKey;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<(anonymous)::ObjCSummaryKey>::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 503,
   FQN="llvm::DenseMapInfo<(anonymous)::ObjCSummaryKey>::getHashValue", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_114ObjCSummaryKeyEE12getHashValueERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_114ObjCSummaryKeyEE12getHashValueERKS2_")
  //</editor-fold>
  @Override public /*uint*/int getHashValue(final /*const*/ ObjCSummaryKey /*&*/ V) {
    assert V != EmptyKey : "must not be called for emptyKey";
    assert V != TombstoneKey : "must not be called for tombstoneKey";    
    /*typedef std::pair<IdentifierInfo *, Selector> PairTy*/
//    final class PairTy extends std.pair<IdentifierInfo /*P*/ , Selector>{ };
    return DenseMapInfoPair.combineTwoHashes(
            DenseMapInfoIdentifierInfo$Ptr.$Info().getHashValue(V.getIdentifier()),
            DenseMapInfoSelector.$Info().getHashValue(V.getSelector()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<(anonymous)::ObjCSummaryKey>::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 509,
   FQN="llvm::DenseMapInfo<(anonymous)::ObjCSummaryKey>::isEqual", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_114ObjCSummaryKeyEE7isEqualERKS2_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_114ObjCSummaryKeyEE7isEqualERKS2_S5_")
  //</editor-fold>
  @Override public boolean isEqual(final /*const*/ ObjCSummaryKey /*&*/ LHS, final /*const*/ ObjCSummaryKey /*&*/ RHS) {
    assert LHS != EmptyKey : "LHS: must not be called for emptyKey";
    assert LHS != TombstoneKey : "LHS: must not be called for tombstoneKey";    
    assert RHS != EmptyKey : "RHS: must not be called for emptyKey";
    assert RHS != TombstoneKey : "RHS: must not be called for tombstoneKey";    
    return LHS.getIdentifier() == RHS.getIdentifier()
       && LHS.getSelector().$eq(RHS.getSelector());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public boolean isKeyPointerLike() {
    return false;
  }

  private static final DenseMapInfoObjCSummaryKey $INFO = new DenseMapInfoObjCSummaryKey();

  private static final ObjCSummaryKey EmptyKey = new ObjCSummaryKey();

  private static final ObjCSummaryKey TombstoneKey = new ObjCSummaryKey();

  public static DenseMapInfoObjCSummaryKey $Info() {
    return $INFO;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
