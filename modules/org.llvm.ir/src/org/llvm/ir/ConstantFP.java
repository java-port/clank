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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
/// ConstantFP - Floating Point Values [float, double]
///
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 254,
 FQN="llvm::ConstantFP", NM="_ZN4llvm10ConstantFPE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFPE")
//</editor-fold>
public final class ConstantFP extends /*public*/ ConstantData implements Destructors.ClassWithDestructor {
  private APFloat Val;
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 623,
   FQN="llvm::ConstantFP::anchor", NM="_ZN4llvm10ConstantFP6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFP6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::ConstantFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 257,
   FQN="llvm::ConstantFP::ConstantFP", NM="_ZN4llvm10ConstantFPC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFPC1ERKS0_")
  //</editor-fold>
  protected/*private*/ ConstantFP(final /*const*/ ConstantFP /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  
  /*friend  class Constant*/
  
  /// Remove the constant from the constant table.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::destroyConstantImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 736,
   FQN="llvm::ConstantFP::destroyConstantImpl", NM="_ZN4llvm10ConstantFP19destroyConstantImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFP19destroyConstantImplEv")
  //</editor-fold>
  /*friend*//*package*/void destroyConstantImpl() {
    throw new llvm_unreachable("You can't ConstantInt->destroyConstantImpl()!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::ConstantFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 725,
   FQN="llvm::ConstantFP::ConstantFP", NM="_ZN4llvm10ConstantFPC1EPNS_4TypeERKNS_7APFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFPC1EPNS_4TypeERKNS_7APFloatE")
  //</editor-fold>
  private ConstantFP(Type /*P*/ Ty, final /*const*/ APFloat /*&*/ V) {
    // : ConstantData(Ty, ConstantFPVal), Val(V) 
    //START JInit
    super(Ty, ValueTy.ConstantFPVal);
    this.Val = new APFloat(V);
    //END JInit
    assert ($AddrOf(V.getSemantics()) == ConstantsStatics.TypeToFloatSemantics(Ty)) : "FP type Mismatch";
  }

/*public:*/
  /// Floating point negation must be implemented with f(x) = -0.0 - x. This
  /// method returns the negative zero constant for floating point or vector
  /// floating point types; for all other types, it returns the null value.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::getZeroValueForNegation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 678,
   FQN="llvm::ConstantFP::getZeroValueForNegation", NM="_ZN4llvm10ConstantFP23getZeroValueForNegationEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFP23getZeroValueForNegationEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getZeroValueForNegation(Type /*P*/ Ty) {
    if (Ty.isFPOrFPVectorTy()) {
      return getNegativeZero(Ty);
    }
    
    return Constant.getNullValue(Ty);
  }

  
  /// This returns a ConstantFP, or a vector containing a splat of a ConstantFP,
  /// for the specified value in the specified type. This should only be used
  /// for simple constant values like 2.0/1.0 etc, that are known-valid both as
  /// host double and as the target format.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 625,
   FQN="llvm::ConstantFP::get", NM="_ZN4llvm10ConstantFP3getEPNS_4TypeEd",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFP3getEPNS_4TypeEd")
  //</editor-fold>
  public static Constant /*P*/ get(Type /*P*/ Ty, double V) {
    final LLVMContext /*&*/ Context = Ty.getContext();
    
    APFloat FV/*J*/= new APFloat(V);
    bool$ptr ignored = create_bool$ptr();
    FV.convert($Deref(ConstantsStatics.TypeToFloatSemantics(Ty.getScalarType())), 
        APFloat.roundingMode.rmNearestTiesToEven, $AddrOf(ignored));
    Constant /*P*/ C = ConstantFP.get(Context, FV);
    {
      
      // For vectors, broadcast the value.
      VectorType /*P*/ VTy = dyn_cast_VectorType(Ty);
      if ((VTy != null)) {
        return ConstantVector.getSplat(VTy.getNumElements(), C);
      }
    }
    
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 642,
   FQN="llvm::ConstantFP::get", NM="_ZN4llvm10ConstantFP3getEPNS_4TypeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFP3getEPNS_4TypeENS_9StringRefE")
  //</editor-fold>
  public static Constant /*P*/ get(Type /*P*/ Ty, StringRef Str) {
    final LLVMContext /*&*/ Context = Ty.getContext();
    
    APFloat FV/*J*/= new APFloat($Deref(ConstantsStatics.TypeToFloatSemantics(Ty.getScalarType())), new StringRef(Str));
    Constant /*P*/ C = ConstantFP.get(Context, FV);
    {
      
      // For vectors, broadcast the value.
      VectorType /*P*/ VTy = dyn_cast_VectorType(Ty);
      if ((VTy != null)) {
        return ConstantVector.getSplat(VTy.getNumElements(), C);
      }
    }
    
    return C;
  }

  
  // ConstantFP accessors.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 687,
   FQN="llvm::ConstantFP::get", NM="_ZN4llvm10ConstantFP3getERNS_11LLVMContextERKNS_7APFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFP3getERNS_11LLVMContextERKNS_7APFloatE")
  //</editor-fold>
  public static ConstantFP /*P*/ get(final LLVMContext /*&*/ Context, final /*const*/ APFloat /*&*/ V) {
    LLVMContextImpl /*P*/ pImpl = Context.pImpl;
    
    final type$ref<ConstantFP /*P*/ /*&*/> Slot = pImpl.FPConstants.ref$at(V);
    if (!(Slot.$deref() != null)) {
      Type /*P*/ Ty;
      if ($AddrOf(V.getSemantics()) == $AddrOf(APFloat.IEEEhalf)) {
        Ty = Type.getHalfTy(Context);
      } else if ($AddrOf(V.getSemantics()) == $AddrOf(APFloat.IEEEsingle)) {
        Ty = Type.getFloatTy(Context);
      } else if ($AddrOf(V.getSemantics()) == $AddrOf(APFloat.IEEEdouble)) {
        Ty = Type.getDoubleTy(Context);
      } else if ($AddrOf(V.getSemantics()) == $AddrOf(APFloat.x87DoubleExtended)) {
        Ty = Type.getX86_FP80Ty(Context);
      } else if ($AddrOf(V.getSemantics()) == $AddrOf(APFloat.IEEEquad)) {
        Ty = Type.getFP128Ty(Context);
      } else {
        assert ($AddrOf(V.getSemantics()) == $AddrOf(APFloat.PPCDoubleDouble)) : "Unknown FP format";
        Ty = Type.getPPC_FP128Ty(Context);
      }
      Slot.$set(/*NEW_EXPR [ConstantData::new]*/ConstantData.$new_ConstantData((type$ptr<?> New$Mem)->{
          return new ConstantFP(Ty, V);
       }));
    }
    
    return Slot.$deref();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::getNaN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 655,
   FQN="llvm::ConstantFP::getNaN", NM="_ZN4llvm10ConstantFP6getNaNEPNS_4TypeEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFP6getNaNEPNS_4TypeEbj")
  //</editor-fold>
  public static Constant /*P*/ getNaN(Type /*P*/ Ty) {
    return getNaN(Ty, false, 0);
  }
  public static Constant /*P*/ getNaN(Type /*P*/ Ty, boolean Negative/*= false*/) {
    return getNaN(Ty, Negative, 0);
  }
  public static Constant /*P*/ getNaN(Type /*P*/ Ty, boolean Negative/*= false*/, /*uint*/int Type/*= 0*/) {
    final /*const*/ fltSemantics /*&*/ Semantics = $Deref(ConstantsStatics.TypeToFloatSemantics(Ty.getScalarType()));
    APFloat NaN = APFloat.getNaN(Semantics, Negative, Type);
    Constant /*P*/ C = ConstantFP.get(Ty.getContext(), NaN);
    {
      
      VectorType /*P*/ VTy = dyn_cast_VectorType(Ty);
      if ((VTy != null)) {
        return ConstantVector.getSplat(VTy.getNumElements(), C);
      }
    }
    
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::getNegativeZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 666,
   FQN="llvm::ConstantFP::getNegativeZero", NM="_ZN4llvm10ConstantFP15getNegativeZeroEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFP15getNegativeZeroEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getNegativeZero(Type /*P*/ Ty) {
    final /*const*/ fltSemantics /*&*/ Semantics = $Deref(ConstantsStatics.TypeToFloatSemantics(Ty.getScalarType()));
    APFloat NegZero = APFloat.getZero(Semantics, /*Negative=*/ true);
    Constant /*P*/ C = ConstantFP.get(Ty.getContext(), NegZero);
    {
      
      VectorType /*P*/ VTy = dyn_cast_VectorType(Ty);
      if ((VTy != null)) {
        return ConstantVector.getSplat(VTy.getNumElements(), C);
      }
    }
    
    return C;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::getInfinity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 715,
   FQN="llvm::ConstantFP::getInfinity", NM="_ZN4llvm10ConstantFP11getInfinityEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFP11getInfinityEPNS_4TypeEb")
  //</editor-fold>
  public static Constant /*P*/ getInfinity(Type /*P*/ Ty) {
    return getInfinity(Ty, false);
  }
  public static Constant /*P*/ getInfinity(Type /*P*/ Ty, boolean Negative/*= false*/) {
    final /*const*/ fltSemantics /*&*/ Semantics = $Deref(ConstantsStatics.TypeToFloatSemantics(Ty.getScalarType()));
    Constant /*P*/ C = get(Ty.getContext(), APFloat.getInf(Semantics, Negative));
    {
      
      VectorType /*P*/ VTy = dyn_cast_VectorType(Ty);
      if ((VTy != null)) {
        return ConstantVector.getSplat(VTy.getNumElements(), C);
      }
    }
    
    return C;
  }

  
  /// Return true if Ty is big enough to represent V.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::isValueValidForType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1210,
   FQN="llvm::ConstantFP::isValueValidForType", NM="_ZN4llvm10ConstantFP19isValueValidForTypeEPNS_4TypeERKNS_7APFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFP19isValueValidForTypeEPNS_4TypeERKNS_7APFloatE")
  //</editor-fold>
  public static boolean isValueValidForType(Type /*P*/ Ty, final /*const*/ APFloat /*&*/ Val) {
    // convert modifies in place, so make a copy.
    APFloat Val2 = new APFloat(Val);
    bool$ptr losesInfo = create_bool$ptr();
    switch (Ty.getTypeID()) {
     default:
      return false; // These can't be represented as floating point!
     case HalfTyID:
      {
        if ($AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEhalf)) {
          return true;
        }
        Val2.convert(APFloat.IEEEhalf, APFloat.roundingMode.rmNearestTiesToEven, $AddrOf(losesInfo));
        return !losesInfo.$star();
      }
     case FloatTyID:
      {
        if ($AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEsingle)) {
          return true;
        }
        Val2.convert(APFloat.IEEEsingle, APFloat.roundingMode.rmNearestTiesToEven, $AddrOf(losesInfo));
        return !losesInfo.$star();
      }
     case DoubleTyID:
      {
        if ($AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEhalf)
           || $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEsingle)
           || $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEdouble)) {
          return true;
        }
        Val2.convert(APFloat.IEEEdouble, APFloat.roundingMode.rmNearestTiesToEven, $AddrOf(losesInfo));
        return !losesInfo.$star();
      }
     case X86_FP80TyID:
      return $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEhalf)
         || $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEsingle)
         || $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEdouble)
         || $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.x87DoubleExtended);
     case FP128TyID:
      return $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEhalf)
         || $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEsingle)
         || $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEdouble)
         || $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEquad);
     case PPC_FP128TyID:
      return $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEhalf)
         || $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEsingle)
         || $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.IEEEdouble)
         || $AddrOf(Val2.getSemantics()) == $AddrOf(APFloat.PPCDoubleDouble);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::getValueAPF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 283,
   FQN="llvm::ConstantFP::getValueAPF", NM="_ZNK4llvm10ConstantFP11getValueAPFEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm10ConstantFP11getValueAPFEv")
  //</editor-fold>
  public /*inline*/ /*const*/ APFloat /*&*/ getValueAPF() /*const*/ {
    return Val;
  }

  
  /// Return true if the value is positive or negative zero.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::isZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 286,
   FQN="llvm::ConstantFP::isZero", NM="_ZNK4llvm10ConstantFP6isZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm10ConstantFP6isZeroEv")
  //</editor-fold>
  public boolean isZero() /*const*/ {
    return Val.isZero();
  }

  
  /// Return true if the sign bit is set.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::isNegative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 289,
   FQN="llvm::ConstantFP::isNegative", NM="_ZNK4llvm10ConstantFP10isNegativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm10ConstantFP10isNegativeEv")
  //</editor-fold>
  public boolean isNegative() /*const*/ {
    return Val.isNegative();
  }

  
  /// Return true if the value is infinity
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::isInfinity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 292,
   FQN="llvm::ConstantFP::isInfinity", NM="_ZNK4llvm10ConstantFP10isInfinityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm10ConstantFP10isInfinityEv")
  //</editor-fold>
  public boolean isInfinity() /*const*/ {
    return Val.isInfinity();
  }

  
  /// Return true if the value is a NaN.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::isNaN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 295,
   FQN="llvm::ConstantFP::isNaN", NM="_ZNK4llvm10ConstantFP5isNaNEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm10ConstantFP5isNaNEv")
  //</editor-fold>
  public boolean isNaN() /*const*/ {
    return Val.isNaN();
  }

  
  /// We don't rely on operator== working on double values, as it returns true
  /// for things that are clearly not equal, like -0.0 and 0.0.
  /// As such, this method can be used to do an exact bit-for-bit comparison of
  /// two floating point values.  The version with a double operand is retained
  /// because it's so convenient to write isExactlyValue(2.0), but please use
  /// it only for simple constants.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::isExactlyValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 731,
   FQN="llvm::ConstantFP::isExactlyValue", NM="_ZNK4llvm10ConstantFP14isExactlyValueERKNS_7APFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm10ConstantFP14isExactlyValueERKNS_7APFloatE")
  //</editor-fold>
  public boolean isExactlyValue(final /*const*/ APFloat /*&*/ V) /*const*/ {
    return Val.bitwiseIsEqual(V);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::isExactlyValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 305,
   FQN="llvm::ConstantFP::isExactlyValue", NM="_ZNK4llvm10ConstantFP14isExactlyValueEd",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm10ConstantFP14isExactlyValueEd")
  //</editor-fold>
  public boolean isExactlyValue(double V) /*const*/ {
    bool$ptr ignored = create_bool$ptr();
    APFloat FV/*J*/= new APFloat(V);
    FV.convert(Val.getSemantics(), APFloat.roundingMode.rmNearestTiesToEven, $AddrOf(ignored));
    return isExactlyValue(FV);
  }

  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 312,
   FQN="llvm::ConstantFP::classof", NM="_ZN4llvm10ConstantFP7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFP7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.ConstantFPVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantFP::~ConstantFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 254,
   FQN="llvm::ConstantFP::~ConstantFP", NM="_ZN4llvm10ConstantFPD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10ConstantFPD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Val.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Val=" + Val // NOI18N
              + super.toString(); // NOI18N
  }
}
