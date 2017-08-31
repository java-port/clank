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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.pass.IrLlvmGlobals.$out_raw_ostream_Value$C;


/// This is an important base class in LLVM. It provides the common facilities
/// of all constant values in an LLVM program. A constant is a value that is
/// immutable at runtime. Functions are constants because their address is
/// immutable. Same with global variables.
///
/// All constants share the capabilities provided in this class. All constants
/// can have a null value. They can have an operand list. Constants can be
/// simple (integer and floating point values), complex (arrays and structures),
/// or expression based (computations yielding a constant value composed of
/// only certain operators and other constant values).
///
/// Note that Constants are immutable (once created they never change)
/// and are fully shared by structural equivalence.  This means that two
/// structurally equivalent constants will always have the same address.
/// Constants are created on demand as needed and never deleted: thus clients
/// don't have to worry about the lifetime of the objects.
/// @brief LLVM Constant Representation
//<editor-fold defaultstate="collapsed" desc="llvm::Constant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constant.h", line = 41,
 FQN="llvm::Constant", NM="_ZN4llvm8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8ConstantE")
//</editor-fold>
public class Constant extends /*public*/ User implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constant.h", line = 42,
   FQN="llvm::Constant::operator=", NM="_ZN4llvm8ConstantaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8ConstantaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ Constant /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::Constant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constant.h", line = 43,
   FQN="llvm::Constant::Constant", NM="_ZN4llvm8ConstantC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8ConstantC1ERKS0_")
  //</editor-fold>
  protected/*private*/ Constant(final /*const*/ Constant /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}


  //===----------------------------------------------------------------------===//
  //                              Constant Class
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 40,
   FQN="llvm::Constant::anchor", NM="_ZN4llvm8Constant6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8Constant6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::Constant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constant.h", line = 47,
   FQN="llvm::Constant::Constant", NM="_ZN4llvm8ConstantC1EPNS_4TypeENS_5Value7ValueTyEPNS_3UseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8ConstantC1EPNS_4TypeENS_5Value7ValueTyEPNS_3UseEj")
  //</editor-fold>
  protected Constant(Type /*P*/ ty, Value.ValueTy vty, type$ptr<Use /*P*/> Ops, /*uint*/int NumOps) {
    // : User(ty, vty, Ops, NumOps)
    //START JInit
    super(ty, vty.getValue(), Ops, NumOps);
    //END JInit
  }

/*public:*/
  /// Return true if this is the value that would be returned by getNullValue.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::isNullValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 90,
   FQN="llvm::Constant::isNullValue", NM="_ZNK4llvm8Constant11isNullValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant11isNullValueEv")
  //</editor-fold>
  public boolean isNullValue() /*const*/ {
    {
      // 0 is null.
      /*const*/ ConstantInt /*P*/ CI = dyn_cast_ConstantInt(this);
      if ((CI != null)) {
        return CI.isZero();
      }
    }
    {

      // +0.0 is null.
      /*const*/ ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(this);
      if ((CFP != null)) {
        return CFP.isZero() && !CFP.isNegative();
      }
    }

    // constant zero is zero for aggregates, cpnull is null for pointers, none for
    // tokens.
    return isa_ConstantAggregateZero(this) || isa_ConstantPointerNull(this)
       || isa_ConstantTokenNone(this);
  }


  /// Returns true if the value is one.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::isOneValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 127,
   FQN="llvm::Constant::isOneValue", NM="_ZNK4llvm8Constant10isOneValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant10isOneValueEv")
  //</editor-fold>
  public boolean isOneValue() /*const*/ {
    {
      // Check for 1 integers
      /*const*/ ConstantInt /*P*/ CI = dyn_cast_ConstantInt(this);
      if ((CI != null)) {
        return CI.isOne();
      }
    }
    {

      // Check for FP which are bitcasted from 1 integers
      /*const*/ ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(this);
      if ((CFP != null)) {
        return CFP.getValueAPF().bitcastToAPInt().$eq($int2ulong(1));
      }
    }
    {

      // Check for constant vectors which are splats of 1 values.
      /*const*/ ConstantVector /*P*/ CV = dyn_cast_ConstantVector(this);
      if ((CV != null)) {
        {
          Constant /*P*/ Splat = CV.getSplatValue();
          if ((Splat != null)) {
            return Splat.isOneValue();
          }
        }
      }
    }
    {

      // Check for constant vectors which are splats of 1 values.
      /*const*/ ConstantDataVector /*P*/ CV = dyn_cast_ConstantDataVector(this);
      if ((CV != null)) {
        {
          Constant /*P*/ Splat = CV.getSplatValue();
          if ((Splat != null)) {
            return Splat.isOneValue();
          }
        }
      }
    }

    return false;
  }


  /// Return true if this is the value that would be returned by
  /// getAllOnesValue.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::isAllOnesValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 105,
   FQN="llvm::Constant::isAllOnesValue", NM="_ZNK4llvm8Constant14isAllOnesValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant14isAllOnesValueEv")
  //</editor-fold>
  public boolean isAllOnesValue() /*const*/ {
    {
      // Check for -1 integers
      /*const*/ ConstantInt /*P*/ CI = dyn_cast_ConstantInt(this);
      if ((CI != null)) {
        return CI.isMinusOne();
      }
    }
    {

      // Check for FP which are bitcasted from -1 integers
      /*const*/ ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(this);
      if ((CFP != null)) {
        return CFP.getValueAPF().bitcastToAPInt().isAllOnesValue();
      }
    }
    {

      // Check for constant vectors which are splats of -1 values.
      /*const*/ ConstantVector /*P*/ CV = dyn_cast_ConstantVector(this);
      if ((CV != null)) {
        {
          Constant /*P*/ Splat = CV.getSplatValue();
          if ((Splat != null)) {
            return Splat.isAllOnesValue();
          }
        }
      }
    }
    {

      // Check for constant vectors which are splats of -1 values.
      /*const*/ ConstantDataVector /*P*/ CV = dyn_cast_ConstantDataVector(this);
      if ((CV != null)) {
        {
          Constant /*P*/ Splat = CV.getSplatValue();
          if ((Splat != null)) {
            return Splat.isAllOnesValue();
          }
        }
      }
    }

    return false;
  }


  /// Return true if the value is what would be returned by
  /// getZeroValueForNegation.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::isNegativeZeroValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 44,
   FQN="llvm::Constant::isNegativeZeroValue", NM="_ZNK4llvm8Constant19isNegativeZeroValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant19isNegativeZeroValueEv")
  //</editor-fold>
  public boolean isNegativeZeroValue() /*const*/ {
    {
      // Floating point values have an explicit -0.0 value.
      /*const*/ ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(this);
      if ((CFP != null)) {
        return CFP.isZero() && CFP.isNegative();
      }
    }
    {

      // Equivalent for a vector of -0.0's.
      /*const*/ ConstantDataVector /*P*/ CV = dyn_cast_ConstantDataVector(this);
      if ((CV != null)) {
        {
          ConstantFP /*P*/ SplatCFP = dyn_cast_or_null_ConstantFP(CV.getSplatValue());
          if ((SplatCFP != null)) {
            if ((SplatCFP != null) && SplatCFP.isZero() && SplatCFP.isNegative()) {
              return true;
            }
          }
        }
      }
    }
    {

      /*const*/ ConstantVector /*P*/ CV = dyn_cast_ConstantVector(this);
      if ((CV != null)) {
        {
          ConstantFP /*P*/ SplatCFP = dyn_cast_or_null_ConstantFP(CV.getSplatValue());
          if ((SplatCFP != null)) {
            if ((SplatCFP != null) && SplatCFP.isZero() && SplatCFP.isNegative()) {
              return true;
            }
          }
        }
      }
    }

    // We've already handled true FP case; any other FP vectors can't represent -0.0.
    if (getType().isFPOrFPVectorTy()) {
      return false;
    }

    // Otherwise, just use +0.0.
    return isNullValue();
  }


  /// Return true if the value is negative zero or null value.

  // Return true iff this constant is positive zero (floating point), negative
  // zero (floating point), or a null value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::isZeroValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 70,
   FQN="llvm::Constant::isZeroValue", NM="_ZNK4llvm8Constant11isZeroValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant11isZeroValueEv")
  //</editor-fold>
  public boolean isZeroValue() /*const*/ {
    {
      // Floating point values have an explicit -0.0 value.
      /*const*/ ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(this);
      if ((CFP != null)) {
        return CFP.isZero();
      }
    }
    {

      // Equivalent for a vector of -0.0's.
      /*const*/ ConstantDataVector /*P*/ CV = dyn_cast_ConstantDataVector(this);
      if ((CV != null)) {
        {
          ConstantFP /*P*/ SplatCFP = dyn_cast_or_null_ConstantFP(CV.getSplatValue());
          if ((SplatCFP != null)) {
            if ((SplatCFP != null) && SplatCFP.isZero()) {
              return true;
            }
          }
        }
      }
    }
    {

      /*const*/ ConstantVector /*P*/ CV = dyn_cast_ConstantVector(this);
      if ((CV != null)) {
        {
          ConstantFP /*P*/ SplatCFP = dyn_cast_or_null_ConstantFP(CV.getSplatValue());
          if ((SplatCFP != null)) {
            if ((SplatCFP != null) && SplatCFP.isZero()) {
              return true;
            }
          }
        }
      }
    }

    // Otherwise, just use +0.0.
    return isNullValue();
  }


  /// Return true if the value is not the smallest signed value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::isNotMinSignedValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 171,
   FQN="llvm::Constant::isNotMinSignedValue", NM="_ZNK4llvm8Constant19isNotMinSignedValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant19isNotMinSignedValueEv")
  //</editor-fold>
  public boolean isNotMinSignedValue() /*const*/ {
    {
      // Check for INT_MIN integers
      /*const*/ ConstantInt /*P*/ CI = dyn_cast_ConstantInt(this);
      if ((CI != null)) {
        return !CI.isMinValue(/*isSigned=*/ true);
      }
    }
    {

      // Check for FP which are bitcasted from INT_MIN integers
      /*const*/ ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(this);
      if ((CFP != null)) {
        return !CFP.getValueAPF().bitcastToAPInt().isMinSignedValue();
      }
    }
    {

      // Check for constant vectors which are splats of INT_MIN values.
      /*const*/ ConstantVector /*P*/ CV = dyn_cast_ConstantVector(this);
      if ((CV != null)) {
        {
          Constant /*P*/ Splat = CV.getSplatValue();
          if ((Splat != null)) {
            return Splat.isNotMinSignedValue();
          }
        }
      }
    }
    {

      // Check for constant vectors which are splats of INT_MIN values.
      /*const*/ ConstantDataVector /*P*/ CV = dyn_cast_ConstantDataVector(this);
      if ((CV != null)) {
        {
          Constant /*P*/ Splat = CV.getSplatValue();
          if ((Splat != null)) {
            return Splat.isNotMinSignedValue();
          }
        }
      }
    }

    // It *may* contain INT_MIN, we can't tell.
    return false;
  }


  /// Return true if the value is the smallest signed value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::isMinSignedValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 149,
   FQN="llvm::Constant::isMinSignedValue", NM="_ZNK4llvm8Constant16isMinSignedValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant16isMinSignedValueEv")
  //</editor-fold>
  public boolean isMinSignedValue() /*const*/ {
    {
      // Check for INT_MIN integers
      /*const*/ ConstantInt /*P*/ CI = dyn_cast_ConstantInt(this);
      if ((CI != null)) {
        return CI.isMinValue(/*isSigned=*/ true);
      }
    }
    {

      // Check for FP which are bitcasted from INT_MIN integers
      /*const*/ ConstantFP /*P*/ CFP = dyn_cast_ConstantFP(this);
      if ((CFP != null)) {
        return CFP.getValueAPF().bitcastToAPInt().isMinSignedValue();
      }
    }
    {

      // Check for constant vectors which are splats of INT_MIN values.
      /*const*/ ConstantVector /*P*/ CV = dyn_cast_ConstantVector(this);
      if ((CV != null)) {
        {
          Constant /*P*/ Splat = CV.getSplatValue();
          if ((Splat != null)) {
            return Splat.isMinSignedValue();
          }
        }
      }
    }
    {

      // Check for constant vectors which are splats of INT_MIN values.
      /*const*/ ConstantDataVector /*P*/ CV = dyn_cast_ConstantDataVector(this);
      if ((CV != null)) {
        {
          Constant /*P*/ Splat = CV.getSplatValue();
          if ((Splat != null)) {
            return Splat.isMinSignedValue();
          }
        }
      }
    }

    return false;
  }


  /// Return true if evaluation of this constant could trap. This is true for
  /// things like constant expressions that could divide by zero.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::canTrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 361,
   FQN="llvm::Constant::canTrap", NM="_ZNK4llvm8Constant7canTrapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant7canTrapEv")
  //</editor-fold>
  public boolean canTrap() /*const*/ {
    SmallPtrSet</*const*/ ConstantExpr /*P*/ > NonTrappingOps/*J*/= new SmallPtrSet</*const*/ ConstantExpr /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    return ConstantsStatics.canTrapImpl(this, NonTrappingOps);
  }


  /// Return true if the value can vary between threads.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::isThreadDependent">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 391,
   FQN="llvm::Constant::isThreadDependent", NM="_ZNK4llvm8Constant17isThreadDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant17isThreadDependentEv")
  //</editor-fold>
  public boolean isThreadDependent() /*const*/ {
    BoolPredicate<GlobalValue> DLLImportPredicate = /*[]*/ (/*const*/ GlobalValue /*P*/ GV) -> {
          return GV.isThreadLocal();
        };
    return ConstantsStatics.ConstHasGlobalValuePredicate(this, DLLImportPredicate);
  }


  /// Return true if the value is dependent on a dllimport variable.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::isDLLImportDependent">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 398,
   FQN="llvm::Constant::isDLLImportDependent", NM="_ZNK4llvm8Constant20isDLLImportDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant20isDLLImportDependentEv")
  //</editor-fold>
  public boolean isDLLImportDependent() /*const*/ {
    BoolPredicate<GlobalValue> DLLImportPredicate = /*[]*/ (/*const*/ GlobalValue /*P*/ GV) -> {
          return GV.hasDLLImportStorageClass();
        };
    return ConstantsStatics.ConstHasGlobalValuePredicate(this, DLLImportPredicate);
  }


  /// Return true if the constant has users other than constant expressions and
  /// other dangling things.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::isConstantUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 405,
   FQN="llvm::Constant::isConstantUsed", NM="_ZNK4llvm8Constant14isConstantUsedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant14isConstantUsedEv")
  //</editor-fold>
  public boolean isConstantUsed() /*const*/ {
    for (/*const*/ User /*P*/ U : users$Const()) {
      /*const*/ Constant /*P*/ UC = dyn_cast_Constant(U);
      if (!(UC != null) || isa_GlobalValue(UC)) {
        return true;
      }
      if (UC.isConstantUsed()) {
        return true;
      }
    }
    return false;
  }


  /// This method classifies the entry according to whether or not it may
  /// generate a relocation entry.  This must be conservative, so if it might
  /// codegen to a relocatable entry, it should say so.
  ///
  /// FIXME: This really should not be in IR.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::needsRelocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 417,
   FQN="llvm::Constant::needsRelocation", NM="_ZNK4llvm8Constant15needsRelocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant15needsRelocationEv")
  //</editor-fold>
  public boolean needsRelocation() /*const*/ {
    if (isa_GlobalValue(this)) {
      return true; // Global reference.
    }
    {

      /*const*/ BlockAddress /*P*/ BA = dyn_cast_BlockAddress(this);
      if ((BA != null)) {
        return BA.getFunction().needsRelocation();
      }
    }
    {

      // While raw uses of blockaddress need to be relocated, differences between
      // two of them don't when they are for labels in the same function.  This is a
      // common idiom when creating a table for the indirect goto extension, so we
      // handle it efficiently here.
      /*const*/ ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(this);
      if ((CE != null)) {
        if (CE.getOpcode() == Instruction.BinaryOps.Sub) {
          ConstantExpr /*P*/ LHS = dyn_cast_ConstantExpr(CE.getOperand_Constant(0));
          ConstantExpr /*P*/ RHS = dyn_cast_ConstantExpr(CE.getOperand_Constant(1));
          if ((LHS != null) && (RHS != null) && LHS.getOpcode() == Instruction.CastOps.PtrToInt
             && RHS.getOpcode() == Instruction.CastOps.PtrToInt
             && isa_BlockAddress(LHS.getOperand_Constant(0))
             && isa_BlockAddress(RHS.getOperand_Constant(0))
             && cast_BlockAddress(LHS.getOperand_Constant(0)).getFunction()
             == cast_BlockAddress(RHS.getOperand_Constant(0)).getFunction()) {
            return false;
          }
        }
      }
    }

    boolean Result = false;
    for (/*uint*/int i = 0, e = getNumOperands(); i != e; ++i)  {
      Result |= cast_Constant(getOperand(i)).needsRelocation();
    }

    return Result;
  }


  /// For aggregates (struct/array/vector) return the constant that corresponds
  /// to the specified element if possible, or null if not. This can return null
  /// if the element index is a ConstantExpr, or if 'this' is a constant expr.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::getAggregateElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 265,
   FQN="llvm::Constant::getAggregateElement", NM="_ZNK4llvm8Constant19getAggregateElementEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant19getAggregateElementEj")
  //</editor-fold>
  public Constant /*P*/ getAggregateElement(/*uint*/int Elt) /*const*/ {
    {
      /*const*/ ConstantAggregate /*P*/ CC = dyn_cast_ConstantAggregate(this);
      if ((CC != null)) {
        return $less_uint(Elt, CC.getNumOperands()) ? CC.getOperand(Elt) : null;
      }
    }
    {

      /*const*/ ConstantAggregateZero /*P*/ CAZ = dyn_cast_ConstantAggregateZero(this);
      if ((CAZ != null)) {
        return $less_uint(Elt, CAZ.getNumElements()) ? CAZ.getElementValue(Elt) : null;
      }
    }
    {

      /*const*/ UndefValue /*P*/ UV = dyn_cast_UndefValue(this);
      if ((UV != null)) {
        return $less_uint(Elt, UV.getNumElements()) ? UV.getElementValue(Elt) : null;
      }
    }
    {

      /*const*/ ConstantDataSequential /*P*/ CDS = dyn_cast_ConstantDataSequential(this);
      if ((CDS != null)) {
        return $less_uint(Elt, CDS.getNumElements()) ? CDS.getElementAsConstant(Elt) : null;
      }
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::getAggregateElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 281,
   FQN="llvm::Constant::getAggregateElement", NM="_ZNK4llvm8Constant19getAggregateElementEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant19getAggregateElementEPS0_")
  //</editor-fold>
  public Constant /*P*/ getAggregateElement(Constant /*P*/ Elt) /*const*/ {
    assert (isa_IntegerType(Elt.getType())) : "Index must be an integer";
    {
      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(Elt);
      if ((CI != null)) {
        return getAggregateElement($ulong2uint(CI.getZExtValue()));
      }
    }
    return null;
  }


  /// If this is a splat vector constant, meaning that all of the elements have
  /// the same value, return that value. Otherwise return 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::getSplatValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1296,
   FQN="llvm::Constant::getSplatValue", NM="_ZNK4llvm8Constant13getSplatValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant13getSplatValueEv")
  //</editor-fold>
  public Constant /*P*/ getSplatValue() /*const*/ {
    assert (/*J:ToBase*/super.getType().isVectorTy()) : "Only valid for vectors!";
    if (isa_ConstantAggregateZero(this)) {
      return getNullValue(/*J:ToBase*/super.getType().getVectorElementType());
    }
    {
      /*const*/ ConstantDataVector /*P*/ CV = dyn_cast_ConstantDataVector(this);
      if ((CV != null)) {
        return CV.getSplatValue();
      }
    }
    {
      /*const*/ ConstantVector /*P*/ CV = dyn_cast_ConstantVector(this);
      if ((CV != null)) {
        return CV.getSplatValue();
      }
    }
    return null;
  }


  /// If C is a constant integer then return its value, otherwise C must be a
  /// vector of constant integers, all equal, and the common value is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::getUniqueInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1317,
   FQN="llvm::Constant::getUniqueInteger", NM="_ZNK4llvm8Constant16getUniqueIntegerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant16getUniqueIntegerEv")
  //</editor-fold>
  public /*const*/ APInt /*&*/ getUniqueInteger() /*const*/ {
    {
      /*const*/ ConstantInt /*P*/ CI = dyn_cast_ConstantInt(this);
      if ((CI != null)) {
        return CI.getValue();
      }
    }
    assert ((this.getSplatValue() != null)) : "Doesn't contain a unique integer!";
    /*const*/ Constant /*P*/ C = this.getAggregateElement(0/*U*/);
    assert ((C != null) && isa_ConstantInt(C)) : "Not a vector of numbers!";
    return cast_ConstantInt(C).getValue();
  }


  /// Called if some element of this constant is no longer valid.
  /// At this point only other constants may be on the use_list for this
  /// constant.  Any constants on our Use list must also be destroy'd.  The
  /// implementation must be sure to remove the constant from the list of
  /// available cached constants.  Implementations should implement
  /// destroyConstantImpl to remove constants from any pools/maps they are
  /// contained it.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::destroyConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 288,
   FQN="llvm::Constant::destroyConstant", NM="_ZN4llvm8Constant15destroyConstantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8Constant15destroyConstantEv")
  //</editor-fold>
  public void destroyConstant() {
    /// First call destroyConstantImpl on the subclass.  This gives the subclass
    /// a chance to remove the constant from any maps/pools it's contained in.
    switch (Value.ValueTy.valueOf(getValueID())) {
     default:
      throw new llvm_unreachable("Not a constant!");
     case FunctionVal:
      cast_Function(this).destroyConstantImpl();
      break;
     case GlobalAliasVal:
      cast_GlobalAlias(this).destroyConstantImpl();
      break;
     case GlobalIFuncVal:
      cast_GlobalIFunc(this).destroyConstantImpl();
      break;
     case GlobalVariableVal:
      cast_GlobalVariable(this).destroyConstantImpl();
      break;
     case BlockAddressVal:
      cast_BlockAddress(this).destroyConstantImpl();
      break;
     case ConstantExprVal:
      cast_ConstantExpr(this).destroyConstantImpl();
      break;
     case ConstantArrayVal:

      // ConstantAggregate.
      cast_ConstantArray(this).destroyConstantImpl();
      break;
     case ConstantStructVal:
      cast_ConstantStruct(this).destroyConstantImpl();
      break;
     case ConstantVectorVal:
      cast_ConstantVector(this).destroyConstantImpl();
      break;
     case UndefValueVal:

      // ConstantData.
      cast_UndefValue(this).destroyConstantImpl();
      break;
     case ConstantAggregateZeroVal:
      cast_ConstantAggregateZero(this).destroyConstantImpl();
      break;
     case ConstantDataArrayVal:
      cast_ConstantDataArray(this).destroyConstantImpl();
      break;
     case ConstantDataVectorVal:
      cast_ConstantDataVector(this).destroyConstantImpl();
      break;
     case ConstantIntVal:
      cast_ConstantInt(this).destroyConstantImpl();
      break;
     case ConstantFPVal:
      cast_ConstantFP(this).destroyConstantImpl();
      break;
     case ConstantPointerNullVal:
      cast_ConstantPointerNull(this).destroyConstantImpl();
      break;
     case ConstantTokenNoneVal:
      cast_ConstantTokenNone(this).destroyConstantImpl();
      break;
    }

    // When a Constant is destroyed, there may be lingering
    // references to the constant by other constants in the constant pool.  These
    // constants are implicitly dependent on the module that is being deleted,
    // but they don't know that.  Because we only find out when the CPV is
    // deleted, we must now notify all of our users (that should only be
    // Constants) that they are, in fact, invalid now and should be deleted.
    //
    while (!use_empty()) {
      Value /*P*/ V = user_back$Value();
      // Only in -g mode...
      if (!isa_Constant(V)) {
        $out_raw_ostream_Value$C($out_raw_ostream_Value$C(dbgs().$out(/*KEEP_STR*/"While deleting: "), /*Deref*/this).$out(
                /*KEEP_STR*/"\n\nUse still stuck around after Def is destroyed: "
            ), $Deref(V)).$out(
            /*KEEP_STR*/"\n\n"
        );
      }
      assert (isa_Constant(V)) : "References remain to Constant being destroyed";
      cast_Constant(V).destroyConstant();

      // The constant should remove itself from our use list...
      assert ((use_empty() || user_back$Value() != V)) : "Constant not removed!";
    }

    // Value has no outstanding references it is safe to delete it now...
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)this);
  }


  //// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constant.h", line = 119,
   FQN="llvm::Constant::classof", NM="_ZN4llvm8Constant7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8Constant7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return $greatereq_uint(V.getValueID(), ValueTy.ConstantFirstVal.getValue())
       && $lesseq_uint(V.getValueID(), ValueTy.ConstantLastVal.getValue());
  }


  /// This method is a special form of User::replaceUsesOfWith
  /// (which does not work on constants) that does work
  /// on constants.  Basically this method goes through the trouble of building
  /// a new constant that is equivalent to the current one, with all uses of
  /// From replaced with uses of To.  After this construction is completed, all
  /// of the users of 'this' are replaced to use the new constant, and then
  /// 'this' is deleted.  In general, you should not call this method, instead,
  /// use Value::replaceAllUsesWith, which automatically dispatches to this
  /// method as needed.
  ///

  //===----------------------------------------------------------------------===//
  //                handleOperandChange implementations

  /// Update this constant array to change uses of
  /// 'From' to be uses of 'To'.  This must update the uniquing data structures
  /// etc.
  ///
  /// Note that we intentionally replace all uses of From with To here.  Consider
  /// a large array that uses 'From' 1000 times.  By handling this case all here,
  /// ConstantArray::handleOperandChange is only invoked once, and that
  /// single invocation handles all 1000 uses.  Handling them one at a time would
  /// work, but would be really slow because it would have to unique each updated
  /// array instance.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::handleOperandChange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 2693,
   FQN="llvm::Constant::handleOperandChange", NM="_ZN4llvm8Constant19handleOperandChangeEPNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8Constant19handleOperandChangeEPNS_5ValueES2_")
  //</editor-fold>
  public void handleOperandChange(Value /*P*/ From, Value /*P*/ To) {
    Value /*P*/ Replacement = null;
    switch (Value.ValueTy.valueOf(getValueID())) {
     default:
      throw new llvm_unreachable("Not a constant!");
     case FunctionVal:
      Replacement = cast_Function(this).handleOperandChangeImpl(From, To);
      break;
     case GlobalAliasVal:
      Replacement = cast_GlobalAlias(this).handleOperandChangeImpl(From, To);
      break;
     case GlobalIFuncVal:
      Replacement = cast_GlobalIFunc(this).handleOperandChangeImpl(From, To);
      break;
     case GlobalVariableVal:
      Replacement = cast_GlobalVariable(this).handleOperandChangeImpl(From, To);
      break;
     case BlockAddressVal:
      Replacement = cast_BlockAddress(this).handleOperandChangeImpl(From, To);
      break;
     case ConstantExprVal:
      Replacement = cast_ConstantExpr(this).handleOperandChangeImpl(From, To);
      break;
     case ConstantArrayVal:

      // ConstantAggregate.
      Replacement = cast_ConstantArray(this).handleOperandChangeImpl(From, To);
      break;
     case ConstantStructVal:
      Replacement = cast_ConstantStruct(this).handleOperandChangeImpl(From, To);
      break;
     case ConstantVectorVal:
      Replacement = cast_ConstantVector(this).handleOperandChangeImpl(From, To);
      break;
     case UndefValueVal:

      // ConstantData.
      Replacement = cast_UndefValue(this).handleOperandChangeImpl(From, To);
      break;
     case ConstantAggregateZeroVal:
      Replacement = cast_ConstantAggregateZero(this).handleOperandChangeImpl(From, To);
      break;
     case ConstantDataArrayVal:
      Replacement = cast_ConstantDataArray(this).handleOperandChangeImpl(From, To);
      break;
     case ConstantDataVectorVal:
      Replacement = cast_ConstantDataVector(this).handleOperandChangeImpl(From, To);
      break;
     case ConstantIntVal:
      Replacement = cast_ConstantInt(this).handleOperandChangeImpl(From, To);
      break;
     case ConstantFPVal:
      Replacement = cast_ConstantFP(this).handleOperandChangeImpl(From, To);
      break;
     case ConstantPointerNullVal:
      Replacement = cast_ConstantPointerNull(this).handleOperandChangeImpl(From, To);
      break;
     case ConstantTokenNoneVal:
      Replacement = cast_ConstantTokenNone(this).handleOperandChangeImpl(From, To);
      break;
    }

    // If handleOperandChangeImpl returned nullptr, then it handled
    // replacing itself and we don't want to delete or replace anything else here.
    if (!(Replacement != null)) {
      return;
    }

    // I do need to replace this with an existing value.
    assert (Replacement != this) : "I didn't contain From!";

    // Everyone using this now uses the replacement.
    replaceAllUsesWith(Replacement);

    // Delete the old constant!
    destroyConstant();
  }



  /// Constructor to create a '0' constant of arbitrary type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::getNullValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 195,
   FQN="llvm::Constant::getNullValue", NM="_ZN4llvm8Constant12getNullValueEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8Constant12getNullValueEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getNullValue(Type /*P*/ Ty) {
    switch (Ty.getTypeID()) {
     case IntegerTyID:
      return ConstantInt.get(Ty, $int2ulong(0));
     case HalfTyID:
      return ConstantFP.get(Ty.getContext(),
          APFloat.getZero(APFloat.IEEEhalf));
     case FloatTyID:
      return ConstantFP.get(Ty.getContext(),
          APFloat.getZero(APFloat.IEEEsingle));
     case DoubleTyID:
      return ConstantFP.get(Ty.getContext(),
          APFloat.getZero(APFloat.IEEEdouble));
     case X86_FP80TyID:
      return ConstantFP.get(Ty.getContext(),
          APFloat.getZero(APFloat.x87DoubleExtended));
     case FP128TyID:
      return ConstantFP.get(Ty.getContext(),
          APFloat.getZero(APFloat.IEEEquad));
     case PPC_FP128TyID:
      return ConstantFP.get(Ty.getContext(),
          new APFloat(APFloat.PPCDoubleDouble,
              APInt.getNullValue(128)));
     case PointerTyID:
      return ConstantPointerNull.get(cast_PointerType(Ty));
     case StructTyID:
     case ArrayTyID:
     case VectorTyID:
      return ConstantAggregateZero.get(Ty);
     case TokenTyID:
      return ConstantTokenNone.get(Ty.getContext());
     default:
      // Function, Label, or Opaque type?
      throw new llvm_unreachable("Cannot create a null constant of that type!");
    }
  }


  /// @returns the value for an integer or vector of integer constant of the
  /// given type that has all its bits set to true.
  /// @brief Get the all ones value
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::getAllOnesValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 249,
   FQN="llvm::Constant::getAllOnesValue", NM="_ZN4llvm8Constant15getAllOnesValueEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8Constant15getAllOnesValueEPNS_4TypeE")
  //</editor-fold>
  public static Constant /*P*/ getAllOnesValue(Type /*P*/ Ty) {
    {
      IntegerType /*P*/ ITy = dyn_cast_IntegerType(Ty);
      if ((ITy != null)) {
        return ConstantInt.get(Ty.getContext(),
            APInt.getAllOnesValue(ITy.getBitWidth()));
      }
    }
    if (Ty.isFloatingPointTy()) {
      APFloat FL = APFloat.getAllOnesValue(Ty.getPrimitiveSizeInBits(),
          !Ty.isPPC_FP128Ty());
      return ConstantFP.get(Ty.getContext(), FL);
    }

    VectorType /*P*/ VTy = cast_VectorType(Ty);
    return ConstantVector.getSplat(VTy.getNumElements(),
        getAllOnesValue(VTy.getElementType()));
  }


  /// Return the value for an integer or pointer constant, or a vector thereof,
  /// with the given scalar value.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::getIntegerValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 232,
   FQN="llvm::Constant::getIntegerValue", NM="_ZN4llvm8Constant15getIntegerValueEPNS_4TypeERKNS_5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8Constant15getIntegerValueEPNS_4TypeERKNS_5APIntE")
  //</editor-fold>
  public static Constant /*P*/ getIntegerValue(Type /*P*/ Ty, final /*const*/ APInt /*&*/ V) {
    Type /*P*/ ScalarTy = Ty.getScalarType();

    // Create the base integer constant.
    Constant /*P*/ C = ConstantInt.get(Ty.getContext(), V);
    {

      // Convert an integer to a pointer, if necessary.
      PointerType /*P*/ PTy = dyn_cast_PointerType(ScalarTy);
      if ((PTy != null)) {
        C = ConstantExpr.getIntToPtr(C, PTy);
      }
    }
    {

      // Broadcast a scalar to a vector, if necessary.
      VectorType /*P*/ VTy = dyn_cast_VectorType(Ty);
      if ((VTy != null)) {
        C = ConstantVector.getSplat(VTy.getNumElements(), C);
      }
    }

    return C;
  }


  /// If there are any dead constant users dangling off of this constant, remove
  /// them. This method is useful for clients that want to check to see if a
  /// global is unused, but don't want to deal with potentially dead constants
  /// hanging off of the globals.
  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::removeDeadConstantUsers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 465,
   FQN="llvm::Constant::removeDeadConstantUsers", NM="_ZNK4llvm8Constant23removeDeadConstantUsersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant23removeDeadConstantUsersEv")
  //</editor-fold>
  public void removeDeadConstantUsers() /*const*/ {
    Value.user_iterator_impl</*const*/ User> I = user_begin$Const();
    Value.user_iterator_impl</*const*/ User> E = user_end$Const();
    Value.user_iterator_impl</*const*/ User> LastNonDeadUser = new Value.user_iterator_impl</*const*/ User>(E);
    while (I.$noteq(E)) {
      /*const*/ Constant /*P*/ User = dyn_cast_Constant(I.$star());
      if (!(User != null)) {
        LastNonDeadUser.$assign(I);
        I.$preInc();
        continue;
      }
      if (!ConstantsStatics.removeDeadUsersOfConstant(User)) {
        // If the constant wasn't dead, remember that this was the last live use
        // and move on to the next constant.
        LastNonDeadUser.$assign(I);
        I.$preInc();
        continue;
      }

      // If the constant was dead, then the iterator is invalidated.
      if (LastNonDeadUser.$eq(E)) {
        I.$assignMove(user_begin$Const());
        if (I.$eq(E)) {
          break;
        }
      } else {
        I.$assign(LastNonDeadUser);
        I.$preInc();
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::stripPointerCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constant.h", line = 153,
   FQN="llvm::Constant::stripPointerCasts", NM="_ZN4llvm8Constant17stripPointerCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8Constant17stripPointerCastsEv")
  //</editor-fold>
  public Constant /*P*/ stripPointerCasts() {
    return cast_Constant(super.stripPointerCasts());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::stripPointerCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constant.h", line = 157,
   FQN="llvm::Constant::stripPointerCasts", NM="_ZNK4llvm8Constant17stripPointerCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm8Constant17stripPointerCastsEv")
  //</editor-fold>
  public /*const*/ Constant /*P*/ stripPointerCasts$Const() /*const*/ {
    return ((/*const_cast*/Constant /*P*/ )(this)).stripPointerCasts();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Constant::~Constant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constant.h", line = 41,
   FQN="llvm::Constant::~Constant", NM="_ZN4llvm8ConstantD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm8ConstantD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected Constant() { /* for sentinels */ }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
