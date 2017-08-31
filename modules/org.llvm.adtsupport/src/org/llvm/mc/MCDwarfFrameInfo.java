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

package org.llvm.mc;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFrameInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 490,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 492,
 FQN="llvm::MCDwarfFrameInfo", NM="_ZN4llvm16MCDwarfFrameInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCDwarfFrameInfoE")
//</editor-fold>
public class/*struct*/ MCDwarfFrameInfo implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFrameInfo::MCDwarfFrameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 491,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 493,
   FQN="llvm::MCDwarfFrameInfo::MCDwarfFrameInfo", NM="_ZN4llvm16MCDwarfFrameInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCDwarfFrameInfoC1Ev")
  //</editor-fold>
  public MCDwarfFrameInfo() {
    // : Begin(null), End(null), Personality(null), Lsda(null), Instructions(), CurrentCfaRegister(0), PersonalityEncoding(implicit unsigned int()), LsdaEncoding(0), CompactUnwindEncoding(0), IsSignalFrame(false), IsSimple(false) 
    //START JInit
    this.Begin = null;
    this.End = null;
    this.Personality = null;
    this.Lsda = null;
    this.Instructions = new std.vector<MCCFIInstruction>(new MCCFIInstruction());
    this.CurrentCfaRegister = 0;
    this.PersonalityEncoding = /*implicit-init*/((/*uint*/int)/*zero-init*/0);
    this.LsdaEncoding = 0;
    this.CompactUnwindEncoding = 0;
    this.IsSignalFrame = false;
    this.IsSimple = false;
    //END JInit
  }

  public MCSymbol /*P*/ Begin;
  public MCSymbol /*P*/ End;
  public /*const*/ MCSymbol /*P*/ Personality;
  public /*const*/ MCSymbol /*P*/ Lsda;
  public std.vector<MCCFIInstruction> Instructions;
  public /*uint*/int CurrentCfaRegister;
  public /*uint*/int PersonalityEncoding;
  public /*uint*/int LsdaEncoding;
  public /*uint32_t*/int CompactUnwindEncoding;
  public boolean IsSignalFrame;
  public boolean IsSimple;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFrameInfo::MCDwarfFrameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 490,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 492,
   FQN="llvm::MCDwarfFrameInfo::MCDwarfFrameInfo", NM="_ZN4llvm16MCDwarfFrameInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCDwarfFrameInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCDwarfFrameInfo(JD$Move _dparam, final MCDwarfFrameInfo /*&&*/$Prm0) {
    // : Begin(static_cast<MCDwarfFrameInfo &&>().Begin), End(static_cast<MCDwarfFrameInfo &&>().End), Personality(static_cast<MCDwarfFrameInfo &&>().Personality), Lsda(static_cast<MCDwarfFrameInfo &&>().Lsda), Instructions(static_cast<MCDwarfFrameInfo &&>().Instructions), CurrentCfaRegister(static_cast<MCDwarfFrameInfo &&>().CurrentCfaRegister), PersonalityEncoding(static_cast<MCDwarfFrameInfo &&>().PersonalityEncoding), LsdaEncoding(static_cast<MCDwarfFrameInfo &&>().LsdaEncoding), CompactUnwindEncoding(static_cast<MCDwarfFrameInfo &&>().CompactUnwindEncoding), IsSignalFrame(static_cast<MCDwarfFrameInfo &&>().IsSignalFrame), IsSimple(static_cast<MCDwarfFrameInfo &&>().IsSimple) 
    //START JInit
    this.Begin = $Prm0.Begin;
    this.End = $Prm0.End;
    this.Personality = $Prm0.Personality;
    this.Lsda = $Prm0.Lsda;
    this.Instructions = new std.vector<MCCFIInstruction>(JD$Move.INSTANCE, $Prm0.Instructions);
    this.CurrentCfaRegister = $Prm0.CurrentCfaRegister;
    this.PersonalityEncoding = $Prm0.PersonalityEncoding;
    this.LsdaEncoding = $Prm0.LsdaEncoding;
    this.CompactUnwindEncoding = $Prm0.CompactUnwindEncoding;
    this.IsSignalFrame = $Prm0.IsSignalFrame;
    this.IsSimple = $Prm0.IsSimple;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFrameInfo::~MCDwarfFrameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 490,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 492,
   FQN="llvm::MCDwarfFrameInfo::~MCDwarfFrameInfo", NM="_ZN4llvm16MCDwarfFrameInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCDwarfFrameInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Instructions.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfFrameInfo::MCDwarfFrameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 490,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 492,
   FQN="llvm::MCDwarfFrameInfo::MCDwarfFrameInfo", NM="_ZN4llvm16MCDwarfFrameInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm16MCDwarfFrameInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MCDwarfFrameInfo(final /*const*/ MCDwarfFrameInfo /*&*/ $Prm0) {
    // : Begin(.Begin), End(.End), Personality(.Personality), Lsda(.Lsda), Instructions(.Instructions), CurrentCfaRegister(.CurrentCfaRegister), PersonalityEncoding(.PersonalityEncoding), LsdaEncoding(.LsdaEncoding), CompactUnwindEncoding(.CompactUnwindEncoding), IsSignalFrame(.IsSignalFrame), IsSimple(.IsSimple) 
    //START JInit
    this.Begin = $Prm0.Begin;
    this.End = $Prm0.End;
    this.Personality = $Prm0.Personality;
    this.Lsda = $Prm0.Lsda;
    this.Instructions = new std.vector<MCCFIInstruction>($Prm0.Instructions);
    this.CurrentCfaRegister = $Prm0.CurrentCfaRegister;
    this.PersonalityEncoding = $Prm0.PersonalityEncoding;
    this.LsdaEncoding = $Prm0.LsdaEncoding;
    this.CompactUnwindEncoding = $Prm0.CompactUnwindEncoding;
    this.IsSignalFrame = $Prm0.IsSignalFrame;
    this.IsSimple = $Prm0.IsSimple;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Begin=" + Begin // NOI18N
              + ", End=" + End // NOI18N
              + ", Personality=" + Personality // NOI18N
              + ", Lsda=" + Lsda // NOI18N
              + ", Instructions=" + Instructions // NOI18N
              + ", CurrentCfaRegister=" + CurrentCfaRegister // NOI18N
              + ", PersonalityEncoding=" + PersonalityEncoding // NOI18N
              + ", LsdaEncoding=" + LsdaEncoding // NOI18N
              + ", CompactUnwindEncoding=" + CompactUnwindEncoding // NOI18N
              + ", IsSignalFrame=" + IsSignalFrame // NOI18N
              + ", IsSimple=" + IsSimple; // NOI18N
  }
}
