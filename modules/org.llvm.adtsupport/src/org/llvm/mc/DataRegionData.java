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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;


// FIXME: Ditto this. Purely so the Streamer and the ObjectWriter can talk
// to one another.
//<editor-fold defaultstate="collapsed" desc="llvm::DataRegionData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 48,
 FQN="llvm::DataRegionData", NM="_ZN4llvm14DataRegionDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachOStreamer.cpp -nm=_ZN4llvm14DataRegionDataE")
//</editor-fold>
public class/*struct*/ DataRegionData {
  // This enum should be kept in sync w/ the mach-o definition in
  // llvm/Object/MachOFormat.h.
  //<editor-fold defaultstate="collapsed" desc="llvm::DataRegionData::KindTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 51,
   FQN="llvm::DataRegionData::KindTy", NM="_ZN4llvm14DataRegionData6KindTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachOStreamer.cpp -nm=_ZN4llvm14DataRegionData6KindTyE")
  //</editor-fold>
  public enum KindTy implements Native.NativeUIntEnum {
    Data(1),
    JumpTable8(Data.getValue() + 1),
    JumpTable16(JumpTable8.getValue() + 1),
    JumpTable32(JumpTable16.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static KindTy valueOf(int val) {
      KindTy out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final KindTy[] VALUES;
      private static final KindTy[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (KindTy kind : KindTy.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new KindTy[min < 0 ? (1-min) : 0];
        VALUES = new KindTy[max >= 0 ? (1+max) : 0];
        for (KindTy kind : KindTy.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private KindTy(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  public  KindTy Kind;
  public MCSymbol /*P*/ Start;
  public MCSymbol /*P*/ End;
  //<editor-fold defaultstate="collapsed" desc="llvm::DataRegionData::DataRegionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 48,
   FQN="llvm::DataRegionData::DataRegionData", NM="_ZN4llvm14DataRegionDataC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachOStreamer.cpp -nm=_ZN4llvm14DataRegionDataC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DataRegionData(final /*const*/ DataRegionData /*&*/ $Prm0) {
    // : Kind(.Kind), Start(.Start), End(.End) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Start = $Prm0.Start;
    this.End = $Prm0.End;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DataRegionData::DataRegionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAssembler.h", line = 48,
   FQN="llvm::DataRegionData::DataRegionData", NM="_ZN4llvm14DataRegionDataC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachOStreamer.cpp -nm=_ZN4llvm14DataRegionDataC1EOS0_")
  //</editor-fold>
  public /*inline*/ DataRegionData(JD$Move _dparam, final DataRegionData /*&&*/$Prm0) {
    // : Kind(static_cast<DataRegionData &&>().Kind), Start(static_cast<DataRegionData &&>().Start), End(static_cast<DataRegionData &&>().End) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Start = $Prm0.Start;
    this.End = $Prm0.End;
    //END JInit
  }

  public DataRegionData() {
  }
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Start=" + Start // NOI18N
              + ", End=" + End; // NOI18N
  }
}
