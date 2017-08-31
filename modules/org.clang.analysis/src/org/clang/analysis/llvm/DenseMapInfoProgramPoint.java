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

package org.clang.analysis.llvm;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.analysis.*;

// Traits specialization for DenseMap
//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::ProgramPoint>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 681,
 FQN="llvm::DenseMapInfo<clang::ProgramPoint>", NM="_ZN4llvm12DenseMapInfoIN5clang12ProgramPointEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ProgramPoint.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang12ProgramPointEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoProgramPoint implements DenseMapInfo<ProgramPoint> {
  private static final DenseMapInfoProgramPoint $INFO = new DenseMapInfoProgramPoint();
  public static DenseMapInfo<ProgramPoint> $Info() { return $INFO; }
  private static final ProgramPoint emptyKey = ProgramPoint.getEmptyKey();
  private static final ProgramPoint tombstoneKey = ProgramPoint.getTombstoneKey();
    
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::ProgramPoint>::getEmptyKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 683,
   FQN="llvm::DenseMapInfo<clang::ProgramPoint>::getEmptyKey", NM="_ZN4llvm12DenseMapInfoIN5clang12ProgramPointEE11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ProgramPoint.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang12ProgramPointEE11getEmptyKeyEv")
  //</editor-fold>
  public /*inline*/ ProgramPoint getEmptyKey() {
    return emptyKey;
//    Object/*uintptr_t*/ x = reinterpret_cast_Object/*uintptr_t*/(DenseMapInfoT$P.<Object/*void P*/ >getEmptyKey()) & ~0x7;
//    return new ProgramPoint(JD$Move.INSTANCE, new BlockEntrance(reinterpret_cast(CFGBlock /*P*/ .class, x), (/*const*/ LocationContext /*P*/ )null));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::ProgramPoint>::getTombstoneKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 689,
   FQN="llvm::DenseMapInfo<clang::ProgramPoint>::getTombstoneKey", NM="_ZN4llvm12DenseMapInfoIN5clang12ProgramPointEE15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ProgramPoint.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang12ProgramPointEE15getTombstoneKeyEv")
  //</editor-fold>
  public /*inline*/ ProgramPoint getTombstoneKey() {
    return tombstoneKey;
//    Object/*uintptr_t*/ x = reinterpret_cast_Object/*uintptr_t*/(DenseMapInfoT$P.<Object/*void P*/ >getTombstoneKey()) & ~0x7;
//    return new ProgramPoint(JD$Move.INSTANCE, new BlockEntrance(reinterpret_cast(CFGBlock /*P*/ .class, x), (/*const*/ LocationContext /*P*/ )null));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::ProgramPoint>::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 695,
   FQN="llvm::DenseMapInfo<clang::ProgramPoint>::getHashValue", NM="_ZN4llvm12DenseMapInfoIN5clang12ProgramPointEE12getHashValueERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ProgramPoint.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang12ProgramPointEE12getHashValueERKS2_")
  //</editor-fold>
  public /*uint*/int getHashValue(final /*const*/ ProgramPoint /*&*/ Loc) {
    return Loc.getHashValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::ProgramPoint>::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 699,
   FQN="llvm::DenseMapInfo<clang::ProgramPoint>::isEqual", NM="_ZN4llvm12DenseMapInfoIN5clang12ProgramPointEE7isEqualERKS2_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ProgramPoint.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang12ProgramPointEE7isEqualERKS2_S5_")
  //</editor-fold>
  public boolean isEqual(final /*const*/ ProgramPoint /*&*/ L, 
         final /*const*/ ProgramPoint /*&*/ R) {
    return L.$eq(R);
  }

  @Override
  public boolean isKeyPointerLike() {
    return true;
  }

  @Override public String toString() {
    return "DenseMapInfo<ProgramPoint>"; // NOI18N
  }
}
