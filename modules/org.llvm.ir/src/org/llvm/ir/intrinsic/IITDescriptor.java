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

package org.llvm.ir.intrinsic;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;


/// This is a type descriptor which explains the type requirements of an
/// intrinsic. This is returned by getIntrinsicInfoTableEntries.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::IITDescriptor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 89,
 FQN="llvm::Intrinsic::IITDescriptor", NM="_ZN4llvm9Intrinsic13IITDescriptorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic13IITDescriptorE")
//</editor-fold>
public class/*struct*/ IITDescriptor {
  //<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::IITDescriptor::IITDescriptorKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 90,
   FQN="llvm::Intrinsic::IITDescriptor::IITDescriptorKind", NM="_ZN4llvm9Intrinsic13IITDescriptor17IITDescriptorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic13IITDescriptor17IITDescriptorKindE")
  //</editor-fold>
  public enum IITDescriptorKind implements Native.NativeUIntEnum {
    Void(0),
    VarArg(Void.getValue() + 1),
    MMX(VarArg.getValue() + 1),
    Token(MMX.getValue() + 1),
    Metadata(Token.getValue() + 1),
    Half(Metadata.getValue() + 1),
    Float(Half.getValue() + 1),
    Double(Float.getValue() + 1),
    Integer(Double.getValue() + 1),
    Vector(Integer.getValue() + 1),
    Pointer(Vector.getValue() + 1),
    Struct(Pointer.getValue() + 1),
    Argument(Struct.getValue() + 1),
    ExtendArgument(Argument.getValue() + 1),
    TruncArgument(ExtendArgument.getValue() + 1),
    HalfVecArgument(TruncArgument.getValue() + 1),
    SameVecWidthArgument(HalfVecArgument.getValue() + 1),
    PtrToArgument(SameVecWidthArgument.getValue() + 1),
    VecOfPtrsToElt(PtrToArgument.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static IITDescriptorKind valueOf(int val) {
      IITDescriptorKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final IITDescriptorKind[] VALUES;
      private static final IITDescriptorKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (IITDescriptorKind kind : IITDescriptorKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new IITDescriptorKind[min < 0 ? (1-min) : 0];
        VALUES = new IITDescriptorKind[max >= 0 ? (1+max) : 0];
        for (IITDescriptorKind kind : IITDescriptorKind.values()) {
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
    private IITDescriptorKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  public final IITDescriptorKind Kind;
  //<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::IITDescriptor::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 97,
   FQN="llvm::Intrinsic::IITDescriptor::(anonymous)", NM="_ZN4llvm9Intrinsic13IITDescriptorE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic13IITDescriptorE_Unnamed_union1")
  //</editor-fold>
  public static class/*union*/ Unnamed_union1 {
    public /*uint*/int Integer_Width;
    public /*uint*/int Float_Width;
    public /*uint*/int Vector_Width;
    public /*uint*/int Pointer_AddressSpace;
    public /*uint*/int Struct_NumElements;
    public /*uint*/int Argument_Info;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::IITDescriptor::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 97,
     FQN="llvm::Intrinsic::IITDescriptor::(anonymous union)::", NM="_ZN4llvm9Intrinsic13IITDescriptorUt_C1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic13IITDescriptorUt_C1ERKS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(final Unnamed_union1 $Prm0) {
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::IITDescriptor::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 97,
     FQN="llvm::Intrinsic::IITDescriptor::(anonymous union)::", NM="_ZN4llvm9Intrinsic13IITDescriptorUt_C1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic13IITDescriptorUt_C1EOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(JD$Move _dparam, final Unnamed_union1 $Prm0) {
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public Unnamed_union1(int Field) {
      this.Integer_Width = Field;
      this.Float_Width = Field;
      this.Vector_Width = Field;
      this.Pointer_AddressSpace = Field;
      this.Struct_NumElements = Field;
      this.Argument_Info = Field;
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Integer_Width=" + Integer_Width // NOI18N
                + ", Float_Width=" + Float_Width // NOI18N
                + ", Vector_Width=" + Vector_Width // NOI18N
                + ", Pointer_AddressSpace=" + Pointer_AddressSpace // NOI18N
                + ", Struct_NumElements=" + Struct_NumElements // NOI18N
                + ", Argument_Info=" + Argument_Info; // NOI18N
    }
  };
  public final Unnamed_union1 Unnamed_field1;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::IITDescriptor::ArgKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 106,
   FQN="llvm::Intrinsic::IITDescriptor::ArgKind", NM="_ZN4llvm9Intrinsic13IITDescriptor7ArgKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic13IITDescriptor7ArgKindE")
  //</editor-fold>
  public enum ArgKind implements Native.NativeUIntEnum {
    AK_Any(0),
    AK_AnyInteger(AK_Any.getValue() + 1),
    AK_AnyFloat(AK_AnyInteger.getValue() + 1),
    AK_AnyVector(AK_AnyFloat.getValue() + 1),
    AK_AnyPointer(AK_AnyVector.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ArgKind valueOf(int val) {
      ArgKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ArgKind[] VALUES;
      private static final ArgKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ArgKind kind : ArgKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ArgKind[min < 0 ? (1-min) : 0];
        VALUES = new ArgKind[max >= 0 ? (1+max) : 0];
        for (ArgKind kind : ArgKind.values()) {
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
    private ArgKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::IITDescriptor::getArgumentNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 113,
   FQN="llvm::Intrinsic::IITDescriptor::getArgumentNumber", NM="_ZNK4llvm9Intrinsic13IITDescriptor17getArgumentNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm9Intrinsic13IITDescriptor17getArgumentNumberEv")
  //</editor-fold>
  public /*uint*/int getArgumentNumber() /*const*/ {
    assert (Kind == IITDescriptorKind.Argument || Kind == IITDescriptorKind.ExtendArgument || Kind == IITDescriptorKind.TruncArgument || Kind == IITDescriptorKind.HalfVecArgument || Kind == IITDescriptorKind.SameVecWidthArgument || Kind == IITDescriptorKind.PtrToArgument || Kind == IITDescriptorKind.VecOfPtrsToElt);
    return Unnamed_field1.Argument_Info >>> 3;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::IITDescriptor::getArgumentKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 120,
   FQN="llvm::Intrinsic::IITDescriptor::getArgumentKind", NM="_ZNK4llvm9Intrinsic13IITDescriptor15getArgumentKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZNK4llvm9Intrinsic13IITDescriptor15getArgumentKindEv")
  //</editor-fold>
  public ArgKind getArgumentKind() /*const*/ {
    assert (Kind == IITDescriptorKind.Argument || Kind == IITDescriptorKind.ExtendArgument || Kind == IITDescriptorKind.TruncArgument || Kind == IITDescriptorKind.HalfVecArgument || Kind == IITDescriptorKind.SameVecWidthArgument || Kind == IITDescriptorKind.PtrToArgument || Kind == IITDescriptorKind.VecOfPtrsToElt);
    return ArgKind.valueOf((Unnamed_field1.Argument_Info & 7));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::IITDescriptor::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 128,
   FQN="llvm::Intrinsic::IITDescriptor::get", NM="_ZN4llvm9Intrinsic13IITDescriptor3getENS1_17IITDescriptorKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic13IITDescriptor3getENS1_17IITDescriptorKindEj")
  //</editor-fold>
  public static IITDescriptor get(IITDescriptorKind K, /*uint*/int Field) {
    IITDescriptor Result = new IITDescriptor(K, Field);
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::IITDescriptor::IITDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 89,
   FQN="llvm::Intrinsic::IITDescriptor::IITDescriptor", NM="_ZN4llvm9Intrinsic13IITDescriptorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic13IITDescriptorC1ERKS1_")
  //</editor-fold>
  public /*inline*/ IITDescriptor(final /*const*/ IITDescriptor /*&*/ $Prm0) {
    // : Kind(.Kind), Unnamed_field1(.) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Unnamed_field1 = new Unnamed_union1($Prm0.Unnamed_field1);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::IITDescriptor::IITDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Intrinsics.h", line = 89,
   FQN="llvm::Intrinsic::IITDescriptor::IITDescriptor", NM="_ZN4llvm9Intrinsic13IITDescriptorC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic13IITDescriptorC1EOS1_")
  //</editor-fold>
  public /*inline*/ IITDescriptor(JD$Move _dparam, final IITDescriptor /*&&*/$Prm0) {
    // : Kind(static_cast<IITDescriptor &&>().Kind), Unnamed_field1(static_cast<IITDescriptor &&>().) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Unnamed_field1 = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field1);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  public IITDescriptor() {
    this.Kind = IITDescriptorKind.Void; 
    this.Unnamed_field1 = new Unnamed_union1(0);
  }

  public IITDescriptor(IITDescriptorKind Kind, int Field) {
    this.Kind = Kind;
    this.Unnamed_field1 = new Unnamed_union1(Field);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Unnamed_field1=" + Unnamed_field1; // NOI18N
  }
}
