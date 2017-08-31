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

package org.clang.sema.llvm.impl;

import org.clank.support.*;
import org.clang.ast.llvm.*;
import org.clang.sema.impl.*;
import static org.clang.sema.impl.CatchHandlerType.$eq_CatchHandlerType$C;

//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<(anonymous)::CatchHandlerType>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3581,
 FQN="llvm::DenseMapInfo<(anonymous)::CatchHandlerType>", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_116CatchHandlerTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_116CatchHandlerTypeEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoCatchHandlerType implements org.llvm.adt.DenseMapInfo<CatchHandlerType> {
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<(anonymous)::CatchHandlerType>::getEmptyKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3582,
   FQN="llvm::DenseMapInfo<(anonymous)::CatchHandlerType>::getEmptyKey", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_116CatchHandlerTypeEE11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_116CatchHandlerTypeEE11getEmptyKeyEv")
  //</editor-fold>
  public CatchHandlerType getEmptyKey() {
    return EMPTY_KEY;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<(anonymous)::CatchHandlerType>::getTombstoneKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3587,
   FQN="llvm::DenseMapInfo<(anonymous)::CatchHandlerType>::getTombstoneKey", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_116CatchHandlerTypeEE15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_116CatchHandlerTypeEE15getTombstoneKeyEv")
  //</editor-fold>
  public CatchHandlerType getTombstoneKey() {
    return TOMBSTONE_KEY;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<(anonymous)::CatchHandlerType>::getHashValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3592,
   FQN="llvm::DenseMapInfo<(anonymous)::CatchHandlerType>::getHashValue", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_116CatchHandlerTypeEE12getHashValueERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_116CatchHandlerTypeEE12getHashValueERKS2_")
  //</editor-fold>
  public /*uint*/int getHashValue(final /*const*/ CatchHandlerType /*&*/ Base) {
    return DenseMapInfoQualType.$Info().getHashValue(Base.underlying());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<(anonymous)::CatchHandlerType>::isEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3596,
   FQN="llvm::DenseMapInfo<(anonymous)::CatchHandlerType>::isEqual", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_116CatchHandlerTypeEE7isEqualERKS2_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_116CatchHandlerTypeEE7isEqualERKS2_S5_")
  //</editor-fold>
  public boolean isEqual(final /*const*/ CatchHandlerType /*&*/ LHS, 
         final /*const*/ CatchHandlerType /*&*/ RHS) {
    return $eq_CatchHandlerType$C(LHS, RHS);
  }
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static DenseMapInfoCatchHandlerType Info = new DenseMapInfoCatchHandlerType();

  public static DenseMapInfoCatchHandlerType Info() {
    return Info;
  }

  @Override
  public boolean isKeyPointerLike() {
    return false;
  }

  private final CatchHandlerType EMPTY_KEY = new CatchHandlerType(DenseMapInfoQualType.$Info().getEmptyKey(), 
          CatchHandlerType.Unique.ForDenseMap);

  private final CatchHandlerType TOMBSTONE_KEY = new CatchHandlerType(DenseMapInfoQualType.$Info().getTombstoneKey(), 
      CatchHandlerType.Unique.ForDenseMap);
    
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return ""; // NOI18N
  }
}
