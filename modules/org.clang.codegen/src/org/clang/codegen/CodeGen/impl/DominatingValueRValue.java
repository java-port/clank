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

package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;


/// A specialization of DominatingValue for RValue.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3478,
 FQN="clang::CodeGen::DominatingValue<RValue>", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEEE")
//</editor-fold>
public class/*struct*/ DominatingValueRValue {
  // JAVA: typedef RValue type
//  public final class type extends RValue{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>::saved_type">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3480,
   FQN="clang::CodeGen::DominatingValue<RValue>::saved_type", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_typeE")
  //</editor-fold>
  public static class saved_type<T> {
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>::saved_type::Kind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3481,
     FQN="clang::CodeGen::DominatingValue<RValue>::saved_type::Kind", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_type4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_type4KindE")
    //</editor-fold>
    private enum Kind implements Native.NativeUIntEnum {
      ScalarLiteral(0),
      ScalarAddress(ScalarLiteral.getValue() + 1),
      AggregateLiteral(ScalarAddress.getValue() + 1),
      AggregateAddress(AggregateLiteral.getValue() + 1),
      ComplexAddress(AggregateAddress.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static Kind valueOf(int val) {
        Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final Kind[] VALUES;
        private static final Kind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (Kind kind : Kind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new Kind[min < 0 ? (1-min) : 0];
          VALUES = new Kind[max >= 0 ? (1+max) : 0];
          for (Kind kind : Kind.values()) {
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
      private Kind(int val) { this.value = (/*uint*/int)val;}
      @Override public final /*uint*/int getValue() { return value;}
      //</editor-fold>
    };
    
    private Value /*P*/ Value;
    private /*JBYTE unsigned int*/ byte K /*: 3*/;
    private /*uint*/int Align /*: 29*/;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>::saved_type::saved_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3487,
     FQN="clang::CodeGen::DominatingValue<RValue>::saved_type::saved_type", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_typeC1EPN4llvm5ValueENS4_4KindEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_typeC1EPN4llvm5ValueENS4_4KindEj")
    //</editor-fold>
    private saved_type(Value /*P*/ v, Kind k) {
      this(v, k, 0);
    }
    private saved_type(Value /*P*/ v, Kind k, /*uint*/int a/*= 0*/) {
      // : Value(v), K(k), Align(a) 
      //START JInit
      this.Value = v;
      this.K = $uint2uint_3bits(k.getValue());
      this.Align = a;
      //END JInit
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>::saved_type::needsSaving">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 27,
     FQN="clang::CodeGen::DominatingValue<RValue>::saved_type::needsSaving", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_type11needsSavingES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_type11needsSavingES2_")
    //</editor-fold>
    public static boolean needsSaving(RValue rv) {
      if (rv.isScalar()) {
        return DominatingLLVMValue.needsSaving(rv.getScalarVal());
      }
      if (rv.isAggregate()) {
        return DominatingLLVMValue.needsSaving(rv.getAggregatePointer());
      }
      return true;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>::saved_type::save">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 35,
     FQN="clang::CodeGen::DominatingValue<RValue>::saved_type::save", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_type4saveERNS0_15CodeGenFunctionES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_type4saveERNS0_15CodeGenFunctionES2_")
    //</editor-fold>
    public static DominatingValueRValue.saved_type<RValue> save(final CodeGenFunction /*&*/ CGF, RValue rv) {
      if (rv.isScalar()) {
        Value /*P*/ V = rv.getScalarVal();
        
        // These automatically dominate and don't need to be saved.
        if (!DominatingLLVMValue.needsSaving(V)) {
          return new saved_type(V, Kind.ScalarLiteral);
        }
        
        // Everything else needs an alloca.
        Address addr = CGF.CreateDefaultAlignTempAlloca(V.getType(), new Twine(/*KEEP_STR*/"saved-rvalue"));
        CGF.Builder.CreateStore(V, new Address(addr));
        return new saved_type(addr.getPointer(), Kind.ScalarAddress);
      }
      if (rv.isComplex()) {
        std.pair<Value /*P*/ , Value /*P*/ > V = rv.getComplexVal();
        org.llvm.ir.Type /*P*/ ComplexTy = StructType.get(V.first.getType(), V.second.getType(), 
            reinterpret_cast(Object/*void P*/ .class, (Object/*void P*/ )null));
        Address addr = CGF.CreateDefaultAlignTempAlloca(ComplexTy, new Twine(/*KEEP_STR*/"saved-complex"));
        CGF.Builder.CreateStore(V.first, 
            CGF.Builder.CreateStructGEP(new Address(addr), 0, new CharUnits()));
        CharUnits offset = CharUnits.fromQuantity(CGF.CGM.getDataLayout().getTypeAllocSize(V.first.getType()));
        CGF.Builder.CreateStore(V.second, 
            CGF.Builder.CreateStructGEP(new Address(addr), 1, new CharUnits(offset)));
        return new saved_type(addr.getPointer(), Kind.ComplexAddress);
      }
      assert (rv.isAggregate());
      Address V = rv.getAggregateAddress(); // TODO: volatile?
      if (!DominatingLLVMValue.needsSaving(V.getPointer())) {
        return new saved_type(V.getPointer(), Kind.AggregateLiteral, 
            $long2uint(V.getAlignment().getQuantity()));
      }
      
      Address addr = CGF.CreateTempAlloca(V.getType(), CGF.getPointerAlign(), new Twine(/*KEEP_STR*/"saved-rvalue"));
      CGF.Builder.CreateStore(V.getPointer(), new Address(addr));
      return new saved_type(addr.getPointer(), Kind.AggregateAddress, 
          $long2uint(V.getAlignment().getQuantity()));
    }

    
    /// Given a saved r-value produced by SaveRValue, perform the code
    /// necessary to restore it to usability at the current insertion
    /// point.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>::saved_type::restore">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 82,
     FQN="clang::CodeGen::DominatingValue<RValue>::saved_type::restore", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_type7restoreERNS0_15CodeGenFunctionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_type7restoreERNS0_15CodeGenFunctionE")
    //</editor-fold>
    public RValue restore(final CodeGenFunction /*&*/ CGF) {
      Value2Address getSavingAddress = /*[&]*/ (Value /*P*/ value) -> {
            /*uint*/int alignment = cast_AllocaInst(value).getAlignment();
            return new Address(value, CharUnits.fromQuantity($uint2long(alignment)));
          };
      switch (DominatingValueRValue.saved_type.Kind.valueOf($3bits_uint2uint(K))) {
       case ScalarLiteral:
        return RValue.get(Value);
       case ScalarAddress:
        return RValue.get(CGF.Builder.CreateLoad(getSavingAddress.$call(Value)));
       case AggregateLiteral:
        return RValue.getAggregate(new Address(Value, CharUnits.fromQuantity($uint2long(Align))));
       case AggregateAddress:
        {
          LoadInst /*P*/ addr = CGF.Builder.CreateLoad(getSavingAddress.$call(Value));
          return RValue.getAggregate(new Address(addr, CharUnits.fromQuantity($uint2long(Align))));
        }
       case ComplexAddress:
        {
          Address address = getSavingAddress.$call(Value);
          Value /*P*/ real = CGF.Builder.CreateLoad(CGF.Builder.CreateStructGEP(new Address(address), 0, new CharUnits()));
          CharUnits offset = CharUnits.fromQuantity(CGF.CGM.getDataLayout().getTypeAllocSize(real.getType()));
          Value /*P*/ imag = CGF.Builder.CreateLoad(CGF.Builder.CreateStructGEP(new Address(address), 1, new CharUnits(offset)));
          return RValue.getComplex(real, imag);
        }
      }
      throw new llvm_unreachable("bad saved r-value kind");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>::saved_type::saved_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3480,
     FQN="clang::CodeGen::DominatingValue<RValue>::saved_type::saved_type", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_typeC1EOS4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_typeC1EOS4_")
    //</editor-fold>
    public /*inline*/ saved_type(JD$Move _dparam, final saved_type /*&&*/$Prm0) {
      // : Value(static_cast<saved_type &&>().Value), K(static_cast<saved_type &&>().K), Align(static_cast<saved_type &&>().Align) 
      //START JInit
      this.Value = $Prm0.Value;
      this.K = $uint2uint_3bits($3bits_uint2uint($Prm0.K));
      this.Align = $Prm0.Align;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>::saved_type::saved_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3480,
     FQN="clang::CodeGen::DominatingValue<RValue>::saved_type::saved_type", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_typeC1ERKS4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_typeC1ERKS4_")
    //</editor-fold>
    public /*inline*/ saved_type(final /*const*/ saved_type /*&*/ $Prm0) {
      // : Value(.Value), K(.K), Align(.Align) 
      //START JInit
      this.Value = $Prm0.Value;
      this.K = $uint2uint_3bits($3bits_uint2uint($Prm0.K));
      this.Align = $Prm0.Align;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>::saved_type::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3480,
     FQN="clang::CodeGen::DominatingValue<RValue>::saved_type::operator=", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_typeaSERKS4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE10saved_typeaSERKS4_")
    //</editor-fold>
    public /*inline*/ saved_type /*&*/ $assign(final /*const*/ saved_type /*&*/ $Prm0) {
      this.Value = $Prm0.Value;
      this.K = $uint2uint_3bits($3bits_uint2uint($Prm0.K));
      this.Align = $Prm0.Align;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Value=" + Value // NOI18N
                + ", K=" + $uchar2uint(K) // NOI18N
                + ", Align=" + Align; // NOI18N
    }
  // implementations in CGCleanup.cpp
    };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>::needsSaving">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3498,
   FQN="clang::CodeGen::DominatingValue<RValue>::needsSaving", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE11needsSavingES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE11needsSavingES2_")
  //</editor-fold>
  public static boolean needsSaving(RValue value) {
    return saved_type.needsSaving(new RValue(value));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>::save">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3501,
   FQN="clang::CodeGen::DominatingValue<RValue>::save", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE4saveERNS0_15CodeGenFunctionES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE4saveERNS0_15CodeGenFunctionES2_")
  //</editor-fold>
  public static saved_type save(final CodeGenFunction /*&*/ CGF, RValue value) {
    return saved_type.save(CGF, new RValue(value));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<RValue>::restore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3504,
   FQN="clang::CodeGen::DominatingValue<RValue>::restore", NM="_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE7restoreERNS0_15CodeGenFunctionENS3_10saved_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_6RValueEE7restoreERNS0_15CodeGenFunctionENS3_10saved_typeE")
  //</editor-fold>
  public static RValue restore(final CodeGenFunction /*&*/ CGF, saved_type value) {
    return value.restore(CGF);
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
