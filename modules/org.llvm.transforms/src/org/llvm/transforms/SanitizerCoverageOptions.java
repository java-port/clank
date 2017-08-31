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

package org.llvm.transforms;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.legacy.*;
import org.llvm.transforms.*;
import org.llvm.transforms.java.TransformFunctionPointers.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.*;


// Options for sanitizer coverage instrumentation.
//<editor-fold defaultstate="collapsed" desc="llvm::SanitizerCoverageOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Instrumentation.h", line = 136,
 FQN="llvm::SanitizerCoverageOptions", NM="_ZN4llvm24SanitizerCoverageOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp -nm=_ZN4llvm24SanitizerCoverageOptionsE")
//</editor-fold>
public class/*struct*/ SanitizerCoverageOptions {
  //<editor-fold defaultstate="collapsed" desc="llvm::SanitizerCoverageOptions::SanitizerCoverageOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Instrumentation.h", line = 137,
   FQN="llvm::SanitizerCoverageOptions::SanitizerCoverageOptions", NM="_ZN4llvm24SanitizerCoverageOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp -nm=_ZN4llvm24SanitizerCoverageOptionsC1Ev")
  //</editor-fold>
  public SanitizerCoverageOptions() {
    // : CoverageType(SCK_None), IndirectCalls(false), TraceBB(false), TraceCmp(false), Use8bitCounters(false), TracePC(false) 
    //START JInit
    this.CoverageType = Type.SCK_None;
    this.IndirectCalls = false;
    this.TraceBB = false;
    this.TraceCmp = false;
    this.Use8bitCounters = false;
    this.TracePC = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SanitizerCoverageOptions::Type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Instrumentation.h", line = 141,
   FQN="llvm::SanitizerCoverageOptions::Type", NM="_ZN4llvm24SanitizerCoverageOptions4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp -nm=_ZN4llvm24SanitizerCoverageOptions4TypeE")
  //</editor-fold>
  public enum Type implements Native.NativeUIntEnum {
    SCK_None(0),
    SCK_Function(SCK_None.getValue() + 1),
    SCK_BB(SCK_Function.getValue() + 1),
    SCK_Edge(SCK_BB.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Type valueOf(int val) {
      Type out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Type[] VALUES;
      private static final Type[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Type kind : Type.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Type[min < 0 ? (1-min) : 0];
        VALUES = new Type[max >= 0 ? (1+max) : 0];
        for (Type kind : Type.values()) {
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
    private Type(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  public  Type CoverageType;
  public boolean IndirectCalls;
  public boolean TraceBB;
  public boolean TraceCmp;
  public boolean Use8bitCounters;
  public boolean TracePC;
  //<editor-fold defaultstate="collapsed" desc="llvm::SanitizerCoverageOptions::SanitizerCoverageOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Instrumentation.h", line = 136,
   FQN="llvm::SanitizerCoverageOptions::SanitizerCoverageOptions", NM="_ZN4llvm24SanitizerCoverageOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp -nm=_ZN4llvm24SanitizerCoverageOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SanitizerCoverageOptions(final /*const*/ SanitizerCoverageOptions /*&*/ $Prm0) {
    // : CoverageType(.CoverageType), IndirectCalls(.IndirectCalls), TraceBB(.TraceBB), TraceCmp(.TraceCmp), Use8bitCounters(.Use8bitCounters), TracePC(.TracePC) 
    //START JInit
    this.CoverageType = $Prm0.CoverageType;
    this.IndirectCalls = $Prm0.IndirectCalls;
    this.TraceBB = $Prm0.TraceBB;
    this.TraceCmp = $Prm0.TraceCmp;
    this.Use8bitCounters = $Prm0.Use8bitCounters;
    this.TracePC = $Prm0.TracePC;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SanitizerCoverageOptions::SanitizerCoverageOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Instrumentation.h", line = 136,
   FQN="llvm::SanitizerCoverageOptions::SanitizerCoverageOptions", NM="_ZN4llvm24SanitizerCoverageOptionsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp -nm=_ZN4llvm24SanitizerCoverageOptionsC1EOS0_")
  //</editor-fold>
  public /*inline*/ SanitizerCoverageOptions(JD$Move _dparam, final SanitizerCoverageOptions /*&&*/$Prm0) {
    // : CoverageType(static_cast<SanitizerCoverageOptions &&>().CoverageType), IndirectCalls(static_cast<SanitizerCoverageOptions &&>().IndirectCalls), TraceBB(static_cast<SanitizerCoverageOptions &&>().TraceBB), TraceCmp(static_cast<SanitizerCoverageOptions &&>().TraceCmp), Use8bitCounters(static_cast<SanitizerCoverageOptions &&>().Use8bitCounters), TracePC(static_cast<SanitizerCoverageOptions &&>().TracePC) 
    //START JInit
    this.CoverageType = $Prm0.CoverageType;
    this.IndirectCalls = $Prm0.IndirectCalls;
    this.TraceBB = $Prm0.TraceBB;
    this.TraceCmp = $Prm0.TraceCmp;
    this.Use8bitCounters = $Prm0.Use8bitCounters;
    this.TracePC = $Prm0.TracePC;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "CoverageType=" + CoverageType // NOI18N
              + ", IndirectCalls=" + IndirectCalls // NOI18N
              + ", TraceBB=" + TraceBB // NOI18N
              + ", TraceCmp=" + TraceCmp // NOI18N
              + ", Use8bitCounters=" + Use8bitCounters // NOI18N
              + ", TracePC=" + TracePC; // NOI18N
  }
}
