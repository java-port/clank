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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;


/// Struct to hold value either by GUID or Value*, depending on whether this
/// is a combined or per-module index, respectively.
//<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 50,
 FQN="llvm::ValueInfo", NM="_ZN4llvm9ValueInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfoE")
//</editor-fold>
public class/*struct*/ ValueInfo {
  /// The value representation used in this instance.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::ValueInfoKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 52,
   FQN="llvm::ValueInfo::ValueInfoKind", NM="_ZN4llvm9ValueInfo13ValueInfoKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfo13ValueInfoKindE")
  //</editor-fold>
  public enum ValueInfoKind implements Native.NativeUIntEnum {
    VI_GUID(0),
    VI_Value(VI_GUID.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ValueInfoKind valueOf(int val) {
      ValueInfoKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ValueInfoKind[] VALUES;
      private static final ValueInfoKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ValueInfoKind kind : ValueInfoKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ValueInfoKind[min < 0 ? (1-min) : 0];
        VALUES = new ValueInfoKind[max >= 0 ? (1+max) : 0];
        for (ValueInfoKind kind : ValueInfoKind.values()) {
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
    private ValueInfoKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// Union of the two possible value types.
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::ValueUnion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 58,
   FQN="llvm::ValueInfo::ValueUnion", NM="_ZN4llvm9ValueInfo10ValueUnionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfo10ValueUnionE")
  //</editor-fold>
  public static class/*union*/ ValueUnion {
    public long/*uint64_t*/ Id;
    public /*const*/ Value /*P*/ V;
    //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::ValueUnion::ValueUnion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 61,
     FQN="llvm::ValueInfo::ValueUnion::ValueUnion", NM="_ZN4llvm9ValueInfo10ValueUnionC1Ey",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfo10ValueUnionC1Ey")
    //</editor-fold>
    public ValueUnion(long/*uint64_t*/ Id) {
      // : Id(Id) 
      //START JInit
      this.Id = Id;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::ValueUnion::ValueUnion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 62,
     FQN="llvm::ValueInfo::ValueUnion::ValueUnion", NM="_ZN4llvm9ValueInfo10ValueUnionC1EPKNS_5ValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfo10ValueUnionC1EPKNS_5ValueE")
    //</editor-fold>
    public ValueUnion(/*const*/ Value /*P*/ V) {
      // : V(V) 
      //START JInit
      this.V = V;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::ValueUnion::ValueUnion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 58,
     FQN="llvm::ValueInfo::ValueUnion::ValueUnion", NM="_ZN4llvm9ValueInfo10ValueUnionC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfo10ValueUnionC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ValueUnion(final /*const*/ ValueUnion /*&*/ $Prm0) {
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::ValueUnion::ValueUnion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 58,
     FQN="llvm::ValueInfo::ValueUnion::ValueUnion", NM="_ZN4llvm9ValueInfo10ValueUnionC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfo10ValueUnionC1EOS1_")
    //</editor-fold>
    public /*inline*/ ValueUnion(JD$Move _dparam, final ValueUnion /*&&*/$Prm0) {
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::ValueUnion::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 58,
     FQN="llvm::ValueInfo::ValueUnion::operator=", NM="_ZN4llvm9ValueInfo10ValueUnionaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfo10ValueUnionaSEOS1_")
    //</editor-fold>
    public /*inline*/ ValueUnion /*&*/ $assignMove(final ValueUnion /*&&*/$Prm0) {
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Id=" + Id // NOI18N
                + ", V=" + V; // NOI18N
    }
  };
  
  /// The value being represented.
  public ValueUnion TheValue;
  /// The value representation.
  public ValueInfoKind Kind;
  /// Constructor for a GUID value
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::ValueInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 70,
   FQN="llvm::ValueInfo::ValueInfo", NM="_ZN4llvm9ValueInfoC1Ey",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfoC1Ey")
  //</editor-fold>
  public ValueInfo() {
    this($int2ulong(0));
  }
  public ValueInfo(long/*uint64_t*/ Id/*= 0*/) {
    // : TheValue(Id), Kind(VI_GUID) 
    //START JInit
    this.TheValue = new ValueUnion(Id);
    this.Kind = ValueInfoKind.VI_GUID;
    //END JInit
  }

  /// Constructor for a Value* value
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::ValueInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 72,
   FQN="llvm::ValueInfo::ValueInfo", NM="_ZN4llvm9ValueInfoC1EPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfoC1EPKNS_5ValueE")
  //</editor-fold>
  public ValueInfo(/*const*/ Value /*P*/ V) {
    // : TheValue(V), Kind(VI_Value) 
    //START JInit
    this.TheValue = new ValueUnion(V);
    this.Kind = ValueInfoKind.VI_Value;
    //END JInit
  }

  /// Accessor for GUID value
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::getGUID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 74,
   FQN="llvm::ValueInfo::getGUID", NM="_ZNK4llvm9ValueInfo7getGUIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm9ValueInfo7getGUIDEv")
  //</editor-fold>
  public long/*uint64_t*/ getGUID() /*const*/ {
    assert (Kind == ValueInfoKind.VI_GUID) : "Not a GUID type";
    return TheValue.Id;
  }

  /// Accessor for Value* value
  //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 79,
   FQN="llvm::ValueInfo::getValue", NM="_ZNK4llvm9ValueInfo8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm9ValueInfo8getValueEv")
  //</editor-fold>
  public /*const*/ Value /*P*/ getValue() /*const*/ {
    assert (Kind == ValueInfoKind.VI_Value) : "Not a Value type";
    return TheValue.V;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::isGUID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 83,
   FQN="llvm::ValueInfo::isGUID", NM="_ZNK4llvm9ValueInfo6isGUIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZNK4llvm9ValueInfo6isGUIDEv")
  //</editor-fold>
  public boolean isGUID() /*const*/ {
    return Kind == ValueInfoKind.VI_GUID;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::ValueInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 50,
   FQN="llvm::ValueInfo::ValueInfo", NM="_ZN4llvm9ValueInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ValueInfo(final /*const*/ ValueInfo /*&*/ $Prm0) {
    // : TheValue(.TheValue), Kind(.Kind) 
    //START JInit
    this.TheValue = new ValueUnion($Prm0.TheValue);
    this.Kind = $Prm0.Kind;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::ValueInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 50,
   FQN="llvm::ValueInfo::ValueInfo", NM="_ZN4llvm9ValueInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ ValueInfo(JD$Move _dparam, final ValueInfo /*&&*/$Prm0) {
    // : TheValue(static_cast<ValueInfo &&>().TheValue), Kind(static_cast<ValueInfo &&>().Kind) 
    //START JInit
    this.TheValue = new ValueUnion(JD$Move.INSTANCE, $Prm0.TheValue);
    this.Kind = $Prm0.Kind;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ValueInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 50,
   FQN="llvm::ValueInfo::operator=", NM="_ZN4llvm9ValueInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriter.cpp -nm=_ZN4llvm9ValueInfoaSEOS0_")
  //</editor-fold>
  public /*inline*/ ValueInfo /*&*/ $assignMove(final ValueInfo /*&&*/$Prm0) {
    this.TheValue.$assignMove($Prm0.TheValue);
    this.Kind = $Prm0.Kind;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "TheValue=" + TheValue // NOI18N
              + ", Kind=" + Kind; // NOI18N
  }
}
