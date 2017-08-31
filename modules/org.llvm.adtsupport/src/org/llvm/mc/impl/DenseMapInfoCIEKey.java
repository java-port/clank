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

package org.llvm.mc.impl;

import org.clank.support.*;
import org.llvm.adt.DenseMapInfo;
import static org.llvm.adt.HashingGlobals.hash_combine;

//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<CIEKey>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1468,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1466,
 FQN="llvm::DenseMapInfo<CIEKey>", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_16CIEKeyEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_16CIEKeyEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoCIEKey implements DenseMapInfo<CIEKey> {
  private static DenseMapInfoCIEKey INFO = new DenseMapInfoCIEKey();
  public static DenseMapInfoCIEKey $Info() {
    return INFO;
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<CIEKey>::getEmptyKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1469,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1467,
   FQN="llvm::DenseMapInfo<CIEKey>::getEmptyKey", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_16CIEKeyEE11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_16CIEKeyEE11getEmptyKeyEv")
  //</editor-fold>
  public CIEKey getEmptyKey() {
    return CIEKey.getEmptyKey();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<CIEKey>::getTombstoneKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1470,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1468,
   FQN="llvm::DenseMapInfo<CIEKey>::getTombstoneKey", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_16CIEKeyEE15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_16CIEKeyEE15getTombstoneKeyEv")
  //</editor-fold>
  public CIEKey getTombstoneKey() {
    return CIEKey.getTombstoneKey();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<CIEKey>::getHashValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1471,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1469,
   FQN="llvm::DenseMapInfo<CIEKey>::getHashValue", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_16CIEKeyEE12getHashValueERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_16CIEKeyEE12getHashValueERKS2_")
  //</editor-fold>
  public /*uint*/int getHashValue(final /*const*/ CIEKey /*&*/ Key) {
    return ((/*static_cast*//*uint*/int)(hash_combine(Key.Personality, Key.PersonalityEncoding, Key.LsdaEncoding, 
        Key.IsSignalFrame, Key.IsSimple).$uint()));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<CIEKey>::isEqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1476,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1474,
   FQN="llvm::DenseMapInfo<CIEKey>::isEqual", NM="_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_16CIEKeyEE7isEqualERKS2_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm12DenseMapInfoIN12_GLOBAL__N_16CIEKeyEE7isEqualERKS2_S5_")
  //</editor-fold>
  public boolean isEqual(final /*const*/ CIEKey /*&*/ LHS, final /*const*/ CIEKey /*&*/ RHS) {
    return LHS.Personality == RHS.Personality
       && LHS.PersonalityEncoding == RHS.PersonalityEncoding
       && LHS.LsdaEncoding == RHS.LsdaEncoding
       && LHS.IsSignalFrame == RHS.IsSignalFrame
       && LHS.IsSimple == RHS.IsSimple;
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }

  @Override
  public boolean isKeyPointerLike() {
    return false;
  }
}
