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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Move;
import static org.clank.support.literal_constants.$$LF;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.java.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


// This is a Name X SelectionKind pair. The reason for having this be an
// independent object instead of just adding the name and the SelectionKind
// to a GlobalObject is that it is invalid to have two Comdats with the same
// name but different SelectionKind. This structure makes that unrepresentable.
//<editor-fold defaultstate="collapsed" desc="llvm::Comdat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Comdat.h", line = 29,
 FQN="llvm::Comdat", NM="_ZN4llvm6ComdatE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6ComdatE")
//</editor-fold>
public class Comdat implements NativeCloneable<Comdat>, NativeMoveable<Comdat> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Comdat::SelectionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Comdat.h", line = 31,
   FQN="llvm::Comdat::SelectionKind", NM="_ZN4llvm6Comdat13SelectionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Comdat13SelectionKindE")
  //</editor-fold>
  public enum SelectionKind implements Native.NativeUIntEnum {
    Any(0), ///< The linker may choose any COMDAT.
    ExactMatch(Any.getValue() + 1), ///< The data referenced by the COMDAT must be the same.
    Largest(ExactMatch.getValue() + 1), ///< The linker will choose the largest COMDAT.
    NoDuplicates(Largest.getValue() + 1), ///< No other Module may specify this COMDAT.
    SameSize(NoDuplicates.getValue() + 1); ///< The data referenced by the COMDAT must be the same size.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SelectionKind valueOf(int val) {
      SelectionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SelectionKind[] VALUES;
      private static final SelectionKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SelectionKind kind : SelectionKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SelectionKind[min < 0 ? (1-min) : 0];
        VALUES = new SelectionKind[max >= 0 ? (1+max) : 0];
        for (SelectionKind kind : SelectionKind.values()) {
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
    private SelectionKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::Comdat::Comdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Comdat.cpp", line = 18,
   FQN="llvm::Comdat::Comdat", NM="_ZN4llvm6ComdatC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Comdat.cpp -nm=_ZN4llvm6ComdatC1EOS0_")
  //</editor-fold>
  /*friend*//*public*/ Comdat(JD$Move _dparam, final Comdat /*&&*/C) {
    // : Name(C.Name), SK(C.SK) 
    //START JInit
    this.Name = C.Name;
    this.SK = C.SK;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Comdat::getSelectionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Comdat.h", line = 40,
   FQN="llvm::Comdat::getSelectionKind", NM="_ZNK4llvm6Comdat16getSelectionKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Comdat16getSelectionKindEv")
  //</editor-fold>
  public SelectionKind getSelectionKind() /*const*/ {
    return SK;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Comdat::setSelectionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Comdat.h", line = 41,
   FQN="llvm::Comdat::setSelectionKind", NM="_ZN4llvm6Comdat16setSelectionKindENS0_13SelectionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6Comdat16setSelectionKindENS0_13SelectionKindE")
  //</editor-fold>
  public void setSelectionKind(SelectionKind Val) {
    SK = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Comdat::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Comdat.cpp", line = 22,
   FQN="llvm::Comdat::getName", NM="_ZNK4llvm6Comdat7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Comdat.cpp -nm=_ZNK4llvm6Comdat7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return Name.first();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Comdat::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3338,
   FQN="llvm::Comdat::print", NM="_ZNK4llvm6Comdat5printERNS_11raw_ostreamEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Comdat5printERNS_11raw_ostreamEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ ROS) /*const*/ {
    print(ROS, false);
  }
  public void print(final raw_ostream /*&*/ ROS, boolean $Prm1/*= false*//*IsForDebug*/) /*const*/ {
    AsmWriterStatics.PrintLLVMName(ROS, getName(), PrefixType.ComdatPrefix);
    ROS.$out(/*KEEP_STR*/" = comdat ");
    switch (getSelectionKind()) {
     case Any:
      ROS.$out(/*KEEP_STR*/"any");
      break;
     case ExactMatch:
      ROS.$out(/*KEEP_STR*/"exactmatch");
      break;
     case Largest:
      ROS.$out(/*KEEP_STR*/"largest");
      break;
     case NoDuplicates:
      ROS.$out(/*KEEP_STR*/"noduplicates");
      break;
     case SameSize:
      ROS.$out(/*KEEP_STR*/"samesize");
      break;
    }
    
    ROS.$out_char($$LF);
  }

  
  // \brief Allow printing of Comdats from the debugger.
  //<editor-fold defaultstate="collapsed" desc="llvm::Comdat::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3549,
   FQN="llvm::Comdat::dump", NM="_ZNK4llvm6Comdat4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm6Comdat4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs(), /*IsForDebug=*/ true);
  }

/*private:*/
  /*friend  class Module*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Comdat::Comdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Comdat.cpp", line = 20,
   FQN="llvm::Comdat::Comdat", NM="_ZN4llvm6ComdatC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Comdat.cpp -nm=_ZN4llvm6ComdatC1Ev")
  //</editor-fold>
  /*friend*//*private*/ Comdat() {
    // : Name(null), SK(Comdat::Any) 
    //START JInit
    this.Name = null;
    this.SK = Comdat.SelectionKind.Any;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Comdat::Comdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Comdat.h", line = 49,
   FQN="llvm::Comdat::Comdat", NM="_ZN4llvm6ComdatC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm6ComdatC1ERKS0_")
  //</editor-fold>
  private delete/*private*/ Comdat(final /*const*/ Comdat /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  // Points to the map in Module.
  /*friend*//*private*/ StringMapEntry<Comdat> /*P*/ Name;
  /*friend*//*private*/ SelectionKind SK;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Comdat clone() {
    assert this.Name == null;
    assert this.SK == Comdat.SelectionKind.Any;
    return new Comdat();
  }

  @Override
  public Comdat move() {
    return new Comdat(JD$Move.INSTANCE, this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", SK=" + SK; // NOI18N
  }
}
