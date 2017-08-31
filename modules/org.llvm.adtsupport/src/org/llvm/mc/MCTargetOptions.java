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
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MCTargetOptions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", line = 19,
 FQN="llvm::MCTargetOptions", NM="_ZN4llvm15MCTargetOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCParser/MCTargetAsmParser.cpp -nm=_ZN4llvm15MCTargetOptionsE")
//</editor-fold>
public class MCTargetOptions implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetOptions::AsmInstrumentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", line = 21,
   FQN="llvm::MCTargetOptions::AsmInstrumentation", NM="_ZN4llvm15MCTargetOptions18AsmInstrumentationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCParser/MCTargetAsmParser.cpp -nm=_ZN4llvm15MCTargetOptions18AsmInstrumentationE")
  //</editor-fold>
  public enum AsmInstrumentation implements Native.NativeUIntEnum {
    AsmInstrumentationNone(0),
    AsmInstrumentationAddress(AsmInstrumentationNone.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AsmInstrumentation valueOf(int val) {
      AsmInstrumentation out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AsmInstrumentation[] VALUES;
      private static final AsmInstrumentation[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AsmInstrumentation kind : AsmInstrumentation.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AsmInstrumentation[min < 0 ? (1-min) : 0];
        VALUES = new AsmInstrumentation[max >= 0 ? (1+max) : 0];
        for (AsmInstrumentation kind : AsmInstrumentation.values()) {
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
    private AsmInstrumentation(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// Enables AddressSanitizer instrumentation at machine level.
  public /*JBIT bool*/ boolean SanitizeAddress /*: 1*/;
  
  public /*JBIT bool*/ boolean MCRelaxAll /*: 1*/;
  public /*JBIT bool*/ boolean MCNoExecStack /*: 1*/;
  public /*JBIT bool*/ boolean MCFatalWarnings /*: 1*/;
  public /*JBIT bool*/ boolean MCNoWarn /*: 1*/;
  public /*JBIT bool*/ boolean MCSaveTempLabels /*: 1*/;
  public /*JBIT bool*/ boolean MCUseDwarfDirectory /*: 1*/;
  public /*JBIT bool*/ boolean MCIncrementalLinkerCompatible /*: 1*/;
  public /*JBIT bool*/ boolean ShowMCEncoding /*: 1*/;
  public /*JBIT bool*/ boolean ShowMCInst /*: 1*/;
  public /*JBIT bool*/ boolean AsmVerbose /*: 1*/;
  
  /// Preserve Comments in Assembly.
  public /*JBIT bool*/ boolean PreserveAsmComments /*: 1*/;
  
  public int DwarfVersion;
  /// getABIName - If this returns a non-empty string this represents the
  /// textual name of the ABI that we want the backend to use, e.g. o32, or
  /// aapcs-linux.
  /// getABIName - If this returns a non-empty string this represents the
  /// textual name of the ABI that we want the backend to use, e.g. o32, or
  /// aapcs-linux.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetOptions::getABIName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCTargetOptions.cpp", line = 22,
   FQN="llvm::MCTargetOptions::getABIName", NM="_ZNK4llvm15MCTargetOptions10getABINameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCTargetOptions.cpp -nm=_ZNK4llvm15MCTargetOptions10getABINameEv")
  //</editor-fold>
  public StringRef getABIName() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  public std.string ABIName;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetOptions::MCTargetOptions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCTargetOptions.cpp", line = 15,
   FQN="llvm::MCTargetOptions::MCTargetOptions", NM="_ZN4llvm15MCTargetOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCTargetOptions.cpp -nm=_ZN4llvm15MCTargetOptionsC1Ev")
  //</editor-fold>
  public MCTargetOptions() {
    // : SanitizeAddress(false), MCRelaxAll(false), MCNoExecStack(false), MCFatalWarnings(false), MCNoWarn(false), MCSaveTempLabels(false), MCUseDwarfDirectory(false), MCIncrementalLinkerCompatible(false), ShowMCEncoding(false), ShowMCInst(false), AsmVerbose(false), DwarfVersion(0), ABIName() 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetOptions::MCTargetOptions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", line = 19,
   FQN="llvm::MCTargetOptions::MCTargetOptions", NM="_ZN4llvm15MCTargetOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCParser/MCTargetAsmParser.cpp -nm=_ZN4llvm15MCTargetOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MCTargetOptions(final /*const*/ MCTargetOptions /*&*/ $Prm0) {
    // : SanitizeAddress(.SanitizeAddress), MCRelaxAll(.MCRelaxAll), MCNoExecStack(.MCNoExecStack), MCFatalWarnings(.MCFatalWarnings), MCNoWarn(.MCNoWarn), MCSaveTempLabels(.MCSaveTempLabels), MCUseDwarfDirectory(.MCUseDwarfDirectory), MCIncrementalLinkerCompatible(.MCIncrementalLinkerCompatible), ShowMCEncoding(.ShowMCEncoding), ShowMCInst(.ShowMCInst), AsmVerbose(.AsmVerbose), PreserveAsmComments(.PreserveAsmComments), DwarfVersion(.DwarfVersion), ABIName(.ABIName) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetOptions::~MCTargetOptions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCTargetOptions.h", line = 19,
   FQN="llvm::MCTargetOptions::~MCTargetOptions", NM="_ZN4llvm15MCTargetOptionsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCParser/MCTargetAsmParser.cpp -nm=_ZN4llvm15MCTargetOptionsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "SanitizeAddress=" + SanitizeAddress // NOI18N
              + ", MCRelaxAll=" + MCRelaxAll // NOI18N
              + ", MCNoExecStack=" + MCNoExecStack // NOI18N
              + ", MCFatalWarnings=" + MCFatalWarnings // NOI18N
              + ", MCNoWarn=" + MCNoWarn // NOI18N
              + ", MCSaveTempLabels=" + MCSaveTempLabels // NOI18N
              + ", MCUseDwarfDirectory=" + MCUseDwarfDirectory // NOI18N
              + ", MCIncrementalLinkerCompatible=" + MCIncrementalLinkerCompatible // NOI18N
              + ", ShowMCEncoding=" + ShowMCEncoding // NOI18N
              + ", ShowMCInst=" + ShowMCInst // NOI18N
              + ", AsmVerbose=" + AsmVerbose // NOI18N
              + ", PreserveAsmComments=" + PreserveAsmComments // NOI18N
              + ", DwarfVersion=" + DwarfVersion // NOI18N
              + ", ABIName=" + ABIName; // NOI18N
  }
}
