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
import org.llvm.adt.aliases.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::CharUnits>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 215,
 FQN="llvm::DenseMapInfo<clang::CharUnits>", NM="_ZN4llvm12DenseMapInfoIN5clang9CharUnitsEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang9CharUnitsEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoCharUnits implements org.llvm.adt.DenseMapInfo<CharUnits> {
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::CharUnits>::getEmptyKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 216,
   FQN="llvm::DenseMapInfo<clang::CharUnits>::getEmptyKey", NM="_ZN4llvm12DenseMapInfoIN5clang9CharUnitsEE11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang9CharUnitsEE11getEmptyKeyEv")
  //</editor-fold>
  public CharUnits getEmptyKey() {
    return EmptyKey;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::CharUnits>::getTombstoneKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 223,
   FQN="llvm::DenseMapInfo<clang::CharUnits>::getTombstoneKey", NM="_ZN4llvm12DenseMapInfoIN5clang9CharUnitsEE15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang9CharUnitsEE15getTombstoneKeyEv")
  //</editor-fold>
  public CharUnits getTombstoneKey() {
    return TombstoneKey;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::CharUnits>::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 230,
   FQN="llvm::DenseMapInfo<clang::CharUnits>::getHashValue", NM="_ZN4llvm12DenseMapInfoIN5clang9CharUnitsEE12getHashValueERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang9CharUnitsEE12getHashValueERKS2_")
  //</editor-fold>
  public /*uint*/int getHashValue(/*const*/ CharUnits /*&*/ CU) {
    assert CU != EmptyKey : "must not be called for emptyKey";
    assert CU != TombstoneKey : "must not be called for tombstoneKey";
    long Quantity = CU.getQuantity();
    return DenseMapInfoLong.$Info().getHashValue(Quantity);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::CharUnits>::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CharUnits.h", line = 235,
   FQN="llvm::DenseMapInfo<clang::CharUnits>::isEqual", NM="_ZN4llvm12DenseMapInfoIN5clang9CharUnitsEE7isEqualERKS2_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang9CharUnitsEE7isEqualERKS2_S5_")
  //</editor-fold>
  public boolean isEqual(/*const*/ CharUnits /*&*/ LHS, 
         /*const*/ CharUnits /*&*/ RHS) {
    assert LHS != EmptyKey : "LHS: must not be called for emptyKey";
    assert LHS != TombstoneKey : "LHS: must not be called for tombstoneKey";    
    assert RHS != EmptyKey : "RHS: must not be called for emptyKey";
    assert RHS != TombstoneKey : "RHS: must not be called for tombstoneKey";           
    return LHS.$eq(RHS);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private DenseMapInfoCharUnits() {
  }

  @Override
  public boolean isKeyPointerLike() {
    return false;
  }

  private static final DenseMapInfoCharUnits $INFO = new DenseMapInfoCharUnits();
  private static final CharUnits EmptyKey = CharUnits.fromQuantity(DenseMapInfoLong.$Info().getEmptyKey());
  private static final CharUnits TombstoneKey = CharUnits.fromQuantity(DenseMapInfoLong.$Info().getTombstoneKey());
  public static DenseMapInfoCharUnits $Info() {
    return $INFO;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
