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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.mc.MCSymbol;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CIEKey">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1446,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1444,
 FQN="(anonymous namespace)::CIEKey", NM="_ZN12_GLOBAL__N_16CIEKeyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_16CIEKeyE")
//</editor-fold>
public class/*struct*/ CIEKey {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CIEKey::getEmptyKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1447,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1445,
   FQN="(anonymous namespace)::CIEKey::getEmptyKey", NM="_ZN12_GLOBAL__N_16CIEKey11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_16CIEKey11getEmptyKeyEv")
  //</editor-fold>
  public static /*const*/ CIEKey getEmptyKey() {
    return new CIEKey((/*const*/ MCSymbol /*P*/ )null, 0, -1, false, false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CIEKey::getTombstoneKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1450,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1448,
   FQN="(anonymous namespace)::CIEKey::getTombstoneKey", NM="_ZN12_GLOBAL__N_16CIEKey15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_16CIEKey15getTombstoneKeyEv")
  //</editor-fold>
  public static /*const*/ CIEKey getTombstoneKey() {
    return new CIEKey((/*const*/ MCSymbol /*P*/ )null, -1, 0, false, false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CIEKey::CIEKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1454,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1452,
   FQN="(anonymous namespace)::CIEKey::CIEKey", NM="_ZN12_GLOBAL__N_16CIEKeyC1EPKN4llvm8MCSymbolEjjbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_16CIEKeyC1EPKN4llvm8MCSymbolEjjbb")
  //</editor-fold>
  public CIEKey(/*const*/ MCSymbol /*P*/ Personality, /*uint*/int PersonalityEncoding, 
      /*uint*/int LsdaEncoding, boolean IsSignalFrame, boolean IsSimple) {
    // : Personality(Personality), PersonalityEncoding(PersonalityEncoding), LsdaEncoding(LsdaEncoding), IsSignalFrame(IsSignalFrame), IsSimple(IsSimple) 
    //START JInit
    this.Personality = Personality;
    this.PersonalityEncoding = PersonalityEncoding;
    this.LsdaEncoding = LsdaEncoding;
    this.IsSignalFrame = IsSignalFrame;
    this.IsSimple = IsSimple;
    //END JInit
  }

  public /*const*/ MCSymbol /*P*/ Personality;
  public /*uint*/int PersonalityEncoding;
  public /*uint*/int LsdaEncoding;
  public boolean IsSignalFrame;
  public boolean IsSimple;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CIEKey::CIEKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1446,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1444,
   FQN="(anonymous namespace)::CIEKey::CIEKey", NM="_ZN12_GLOBAL__N_16CIEKeyC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_16CIEKeyC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CIEKey(final /*const*/ CIEKey /*&*/ $Prm0) {
    // : Personality(.Personality), PersonalityEncoding(.PersonalityEncoding), LsdaEncoding(.LsdaEncoding), IsSignalFrame(.IsSignalFrame), IsSimple(.IsSimple) 
    //START JInit
    this.Personality = $Prm0.Personality;
    this.PersonalityEncoding = $Prm0.PersonalityEncoding;
    this.LsdaEncoding = $Prm0.LsdaEncoding;
    this.IsSignalFrame = $Prm0.IsSignalFrame;
    this.IsSimple = $Prm0.IsSimple;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CIEKey::CIEKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1446,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1444,
   FQN="(anonymous namespace)::CIEKey::CIEKey", NM="_ZN12_GLOBAL__N_16CIEKeyC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_16CIEKeyC1EOS0_")
  //</editor-fold>
  public /*inline*/ CIEKey(JD$Move _dparam, final CIEKey /*&&*/$Prm0) {
    // : Personality(static_cast<CIEKey &&>().Personality), PersonalityEncoding(static_cast<CIEKey &&>().PersonalityEncoding), LsdaEncoding(static_cast<CIEKey &&>().LsdaEncoding), IsSignalFrame(static_cast<CIEKey &&>().IsSignalFrame), IsSimple(static_cast<CIEKey &&>().IsSimple) 
    //START JInit
    this.Personality = $Prm0.Personality;
    this.PersonalityEncoding = $Prm0.PersonalityEncoding;
    this.LsdaEncoding = $Prm0.LsdaEncoding;
    this.IsSignalFrame = $Prm0.IsSignalFrame;
    this.IsSimple = $Prm0.IsSimple;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CIEKey::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1446,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1444,
   FQN="(anonymous namespace)::CIEKey::operator=", NM="_ZN12_GLOBAL__N_16CIEKeyaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_16CIEKeyaSERKS0_")
  //</editor-fold>
  public /*inline*/ CIEKey /*&*/ $assign(final /*const*/ CIEKey /*&*/ $Prm0) {
    this.Personality = $Prm0.Personality;
    this.PersonalityEncoding = $Prm0.PersonalityEncoding;
    this.LsdaEncoding = $Prm0.LsdaEncoding;
    this.IsSignalFrame = $Prm0.IsSignalFrame;
    this.IsSimple = $Prm0.IsSimple;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CIEKey::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", line = 1446,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp", old_line = 1444,
   FQN="(anonymous namespace)::CIEKey::operator=", NM="_ZN12_GLOBAL__N_16CIEKeyaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN12_GLOBAL__N_16CIEKeyaSEOS0_")
  //</editor-fold>
  public /*inline*/ CIEKey /*&*/ $assignMove(final CIEKey /*&&*/$Prm0) {
    this.Personality = $Prm0.Personality;
    this.PersonalityEncoding = $Prm0.PersonalityEncoding;
    this.LsdaEncoding = $Prm0.LsdaEncoding;
    this.IsSignalFrame = $Prm0.IsSignalFrame;
    this.IsSimple = $Prm0.IsSimple;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Personality=" + Personality // NOI18N
              + ", PersonalityEncoding=" + PersonalityEncoding // NOI18N
              + ", LsdaEncoding=" + LsdaEncoding // NOI18N
              + ", IsSignalFrame=" + IsSignalFrame // NOI18N
              + ", IsSimple=" + IsSimple; // NOI18N
  }
}
