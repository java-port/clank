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

package org.llvm.analysis.impl;

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
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemDepPrinter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 24,
 FQN="(anonymous namespace)::MemDepPrinter", NM="_ZN12_GLOBAL__N_113MemDepPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZN12_GLOBAL__N_113MemDepPrinterE")
//</editor-fold>
public class/*struct*/ MemDepPrinter extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
  public /*const*/ Function /*P*/ F;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemDepPrinter::DepType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 27,
   FQN="(anonymous namespace)::MemDepPrinter::DepType", NM="_ZN12_GLOBAL__N_113MemDepPrinter7DepTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZN12_GLOBAL__N_113MemDepPrinter7DepTypeE")
  //</editor-fold>
  public enum DepType implements Native.NativeUIntEnum {
    Clobber(0),
    Def(Clobber.getValue() + 1),
    NonFuncLocal(Def.getValue() + 1),
    Unknown(NonFuncLocal.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DepType valueOf(int val) {
      DepType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DepType[] VALUES;
      private static final DepType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DepType kind : DepType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DepType[min < 0 ? (1-min) : 0];
        VALUES = new DepType[max >= 0 ? (1+max) : 0];
        for (DepType kind : DepType.values()) {
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
    private DepType(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  public static type$ptr</*const*/char$ptr/*char P*//*const*//*[-1]*/> DepTypeStr = create_type$ptr(new /*const*/char$ptr/*char P*//*const*/ [/*4*/] {$("Clobber"), $("Def"), $("NonFuncLocal"), $("Unknown")});
  
  // JAVA: typedef PointerIntPair<const Instruction *, 2, DepType> InstTypePair
//  public final class InstTypePair extends PointerEnum2Pair</*const*/ Instruction /*P*/ , DepType>{ };
  // JAVA: typedef std::pair<InstTypePair, const BasicBlock *> Dep
//  public final class Dep extends std.pair<PointerEnum2Pair</*const*/ Instruction /*P*/ , DepType>, /*const*/ BasicBlock /*P*/ >{ };
  // JAVA: typedef SmallSetVector<Dep, 4> DepSet
//  public final class DepSet extends SmallSetVector<std.pair<PointerEnum2Pair</*const*/ Instruction /*P*/ , DepType>, /*const*/ BasicBlock /*P*/ >>{ };
  // JAVA: typedef DenseMap<const Instruction *, DepSet> DepSetMap
//  public final class DepSetMap extends DenseMap</*const*/ Instruction /*P*/ , SmallSetVector<std.pair<PointerEnum2Pair</*const*/ Instruction /*P*/ , DepType>, /*const*/ BasicBlock /*P*/ >>>{ };
  public DenseMap</*const*/ Instruction /*P*/ , SmallSetVector<std.pair<PointerEnum2Pair</*const*/ Instruction /*P*/ , DepType>, /*const*/ BasicBlock /*P*/ >>> Deps;
  
  public static final/*char*/Class<MemDepPrinter> ID = MemDepPrinter.class; // Pass identifcation, replacement for typeid
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemDepPrinter::MemDepPrinter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 43,
   FQN="(anonymous namespace)::MemDepPrinter::MemDepPrinter", NM="_ZN12_GLOBAL__N_113MemDepPrinterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZN12_GLOBAL__N_113MemDepPrinterC1Ev")
  //</editor-fold>
  public MemDepPrinter() {
    // : FunctionPass(ID), Deps() 
    super(ID);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemDepPrinter::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 93,
   FQN="(anonymous namespace)::MemDepPrinter::runOnFunction", NM="_ZN12_GLOBAL__N_113MemDepPrinter13runOnFunctionERN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZN12_GLOBAL__N_113MemDepPrinter13runOnFunctionERN4llvm8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemDepPrinter::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 135,
   FQN="(anonymous namespace)::MemDepPrinter::print", NM="_ZNK12_GLOBAL__N_113MemDepPrinter5printERN4llvm11raw_ostreamEPKNS1_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZNK12_GLOBAL__N_113MemDepPrinter5printERN4llvm11raw_ostreamEPKNS1_6ModuleE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    print(OS, (/*const*/ Module /*P*/ )null);
  }
  @Override public void print(final raw_ostream /*&*/ OS, /*const*/ Module /*P*/ M/*= null*/) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemDepPrinter::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 51,
   FQN="(anonymous namespace)::MemDepPrinter::getAnalysisUsage", NM="_ZNK12_GLOBAL__N_113MemDepPrinter16getAnalysisUsageERN4llvm13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZNK12_GLOBAL__N_113MemDepPrinter16getAnalysisUsageERN4llvm13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemDepPrinter::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 57,
   FQN="(anonymous namespace)::MemDepPrinter::releaseMemory", NM="_ZN12_GLOBAL__N_113MemDepPrinter13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZN12_GLOBAL__N_113MemDepPrinter13releaseMemoryEv")
  //</editor-fold>
  @Override public void releaseMemory()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemDepPrinter::getInstTypePair">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 63,
   FQN="(anonymous namespace)::MemDepPrinter::getInstTypePair", NM="_ZN12_GLOBAL__N_113MemDepPrinter15getInstTypePairEN4llvm12MemDepResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZN12_GLOBAL__N_113MemDepPrinter15getInstTypePairEN4llvm12MemDepResultE")
  //</editor-fold>
  private static PointerEnum2Pair</*const*/ Instruction /*P*/ , DepType> getInstTypePair(MemDepResult dep) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemDepPrinter::getInstTypePair">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 73,
   FQN="(anonymous namespace)::MemDepPrinter::getInstTypePair", NM="_ZN12_GLOBAL__N_113MemDepPrinter15getInstTypePairEPKN4llvm11InstructionENS0_7DepTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZN12_GLOBAL__N_113MemDepPrinter15getInstTypePairEPKN4llvm11InstructionENS0_7DepTypeE")
  //</editor-fold>
  private static PointerEnum2Pair</*const*/ Instruction /*P*/ , DepType> getInstTypePair(/*const*/ Instruction /*P*/ inst, DepType type) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MemDepPrinter::~MemDepPrinter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 24,
   FQN="(anonymous namespace)::MemDepPrinter::~MemDepPrinter", NM="_ZN12_GLOBAL__N_113MemDepPrinterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZN12_GLOBAL__N_113MemDepPrinterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "F=" + F // NOI18N
              + ", Deps=" + Deps // NOI18N
              + super.toString(); // NOI18N
  }
}
