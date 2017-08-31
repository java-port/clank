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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;
import org.llvm.ir.mdconst.MdconstGlobals;


/// Utility class for floating point operations which can have
/// information about relaxed accuracy requirements attached to them.
//<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 216,
 FQN="llvm::FPMathOperator", NM="_ZN4llvm14FPMathOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FPMathOperatorE")
//</editor-fold>
public class FPMathOperator extends /*public*/ Operator implements Destructors.ClassWithDestructor {
/*private:*/
  /*friend  class Instruction*/

  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::setHasUnsafeAlgebra">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 220,
   FQN="llvm::FPMathOperator::setHasUnsafeAlgebra", NM="_ZN4llvm14FPMathOperator19setHasUnsafeAlgebraEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FPMathOperator19setHasUnsafeAlgebraEb")
  //</editor-fold>
  /*friend*/public/*private*/ void setHasUnsafeAlgebra(boolean B) {
    SubclassOptionalData
       = $uchar2uchar_7bits($int2uchar(($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & ~FastMathFlags.UnsafeAlgebra)
       | ($bool2uint(B) * FastMathFlags.UnsafeAlgebra)));

    // Unsafe algebra implies all the others
    if (B) {
      setHasNoNaNs(true);
      setHasNoInfs(true);
      setHasNoSignedZeros(true);
      setHasAllowReciprocal(true);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::setHasNoNaNs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 233,
   FQN="llvm::FPMathOperator::setHasNoNaNs", NM="_ZN4llvm14FPMathOperator12setHasNoNaNsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FPMathOperator12setHasNoNaNsEb")
  //</editor-fold>
  /*friend*/public/*private*/ void setHasNoNaNs(boolean B) {
    SubclassOptionalData
       = $uchar2uchar_7bits($int2uchar(($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & ~FastMathFlags.NoNaNs)
       | ($bool2uint(B) * FastMathFlags.NoNaNs)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::setHasNoInfs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 238,
   FQN="llvm::FPMathOperator::setHasNoInfs", NM="_ZN4llvm14FPMathOperator12setHasNoInfsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FPMathOperator12setHasNoInfsEb")
  //</editor-fold>
  /*friend*/public/*private*/ void setHasNoInfs(boolean B) {
    SubclassOptionalData
       = $uchar2uchar_7bits($int2uchar(($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & ~FastMathFlags.NoInfs)
       | ($bool2uint(B) * FastMathFlags.NoInfs)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::setHasNoSignedZeros">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 243,
   FQN="llvm::FPMathOperator::setHasNoSignedZeros", NM="_ZN4llvm14FPMathOperator19setHasNoSignedZerosEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FPMathOperator19setHasNoSignedZerosEb")
  //</editor-fold>
  /*friend*/public/*private*/ void setHasNoSignedZeros(boolean B) {
    SubclassOptionalData
       = $uchar2uchar_7bits($int2uchar(($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & ~FastMathFlags.NoSignedZeros)
       | ($bool2uint(B) * FastMathFlags.NoSignedZeros)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::setHasAllowReciprocal">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 248,
   FQN="llvm::FPMathOperator::setHasAllowReciprocal", NM="_ZN4llvm14FPMathOperator21setHasAllowReciprocalEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FPMathOperator21setHasAllowReciprocalEb")
  //</editor-fold>
  /*friend*/public/*private*/ void setHasAllowReciprocal(boolean B) {
    SubclassOptionalData
       = $uchar2uchar_7bits($int2uchar(($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & ~FastMathFlags.AllowReciprocal)
       | ($bool2uint(B) * FastMathFlags.AllowReciprocal)));
  }


  /// Convenience function for setting multiple fast-math flags.
  /// FMF is a mask of the bits to set.
  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::setFastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 256,
   FQN="llvm::FPMathOperator::setFastMathFlags", NM="_ZN4llvm14FPMathOperator16setFastMathFlagsENS_13FastMathFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FPMathOperator16setFastMathFlagsENS_13FastMathFlagsE")
  //</editor-fold>
  /*friend*/public/*private*/ void setFastMathFlags(FastMathFlags FMF) {
    SubclassOptionalData |= $uint2uchar_7bits(FMF.Flags);
  }


  /// Convenience function for copying all fast-math flags.
  /// All values in FMF are transferred to this operator.
  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::copyFastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 262,
   FQN="llvm::FPMathOperator::copyFastMathFlags", NM="_ZN4llvm14FPMathOperator17copyFastMathFlagsENS_13FastMathFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FPMathOperator17copyFastMathFlagsENS_13FastMathFlagsE")
  //</editor-fold>
  /*friend*/public/*private*/ void copyFastMathFlags(FastMathFlags FMF) {
    SubclassOptionalData = $uchar2uchar_7bits($uint2uchar(FMF.Flags));
  }

/*public:*/
  /// Test whether this operation is permitted to be
  /// algebraically transformed, aka the 'A' fast-math property.
  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::hasUnsafeAlgebra">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 269,
   FQN="llvm::FPMathOperator::hasUnsafeAlgebra", NM="_ZNK4llvm14FPMathOperator16hasUnsafeAlgebraEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FPMathOperator16hasUnsafeAlgebraEv")
  //</editor-fold>
  public boolean hasUnsafeAlgebra() /*const*/ {
    return ($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & FastMathFlags.UnsafeAlgebra) != 0;
  }


  /// Test whether this operation's arguments and results are to be
  /// treated as non-NaN, aka the 'N' fast-math property.
  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::hasNoNaNs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 275,
   FQN="llvm::FPMathOperator::hasNoNaNs", NM="_ZNK4llvm14FPMathOperator9hasNoNaNsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FPMathOperator9hasNoNaNsEv")
  //</editor-fold>
  public boolean hasNoNaNs() /*const*/ {
    return ($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & FastMathFlags.NoNaNs) != 0;
  }


  /// Test whether this operation's arguments and results are to be
  /// treated as NoN-Inf, aka the 'I' fast-math property.
  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::hasNoInfs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 281,
   FQN="llvm::FPMathOperator::hasNoInfs", NM="_ZNK4llvm14FPMathOperator9hasNoInfsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FPMathOperator9hasNoInfsEv")
  //</editor-fold>
  public boolean hasNoInfs() /*const*/ {
    return ($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & FastMathFlags.NoInfs) != 0;
  }


  /// Test whether this operation can treat the sign of zero
  /// as insignificant, aka the 'S' fast-math property.
  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::hasNoSignedZeros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 287,
   FQN="llvm::FPMathOperator::hasNoSignedZeros", NM="_ZNK4llvm14FPMathOperator16hasNoSignedZerosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FPMathOperator16hasNoSignedZerosEv")
  //</editor-fold>
  public boolean hasNoSignedZeros() /*const*/ {
    return ($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & FastMathFlags.NoSignedZeros) != 0;
  }


  /// Test whether this operation is permitted to use
  /// reciprocal instead of division, aka the 'R' fast-math property.
  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::hasAllowReciprocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 293,
   FQN="llvm::FPMathOperator::hasAllowReciprocal", NM="_ZNK4llvm14FPMathOperator18hasAllowReciprocalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FPMathOperator18hasAllowReciprocalEv")
  //</editor-fold>
  public boolean hasAllowReciprocal() /*const*/ {
    return ($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & FastMathFlags.AllowReciprocal) != 0;
  }


  /// Convenience function for getting all the fast-math flags
  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::getFastMathFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 298,
   FQN="llvm::FPMathOperator::getFastMathFlags", NM="_ZNK4llvm14FPMathOperator16getFastMathFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FPMathOperator16getFastMathFlagsEv")
  //</editor-fold>
  public FastMathFlags getFastMathFlags() /*const*/ {
    return new FastMathFlags($uchar2uint($7bits_uchar2uchar(SubclassOptionalData)));
  }


  /// \brief Get the maximum error permitted by this operation in ULPs.  An
  /// accuracy of 0.0 means that the operation should be performed with the
  /// default precision.

  //===----------------------------------------------------------------------===//
  //                             FPMathOperator Class
  //===----------------------------------------------------------------------===//

  /// getFPAccuracy - Get the maximum error permitted by this operation in ULPs.
  /// An accuracy of 0.0 means that the operation should be performed with the
  /// default precision.
  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::getFPAccuracy">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 2312,
   FQN="llvm::FPMathOperator::getFPAccuracy", NM="_ZNK4llvm14FPMathOperator13getFPAccuracyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14FPMathOperator13getFPAccuracyEv")
  //</editor-fold>
  public float getFPAccuracy() /*const*/ {
    /*const*/ MDNode /*P*/ MD = cast_Instruction(this).getMetadata(LLVMContext.Unnamed_enum.MD_fpmath.getValue());
    if (!(MD != null)) {
      return (float) 0.0;
    }
    ConstantFP /*P*/ Accuracy = MdconstGlobals.<ConstantFP, /*const*/ MDOperand /*&*/ >extract$ValidPointer(ConstantFP.class, MD.getOperand(0));
    return Accuracy.getValueAPF().convertToFloat();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 307,
   FQN="llvm::FPMathOperator::classof", NM="_ZN4llvm14FPMathOperator7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FPMathOperator7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getType().isFPOrFPVectorTy()
       || I.getOpcode() == Instruction.OtherOps.FCmp;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 311,
   FQN="llvm::FPMathOperator::classof", NM="_ZN4llvm14FPMathOperator7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FPMathOperator7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && FPMathOperator.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FPMathOperator::~FPMathOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 216,
   FQN="llvm::FPMathOperator::~FPMathOperator", NM="_ZN4llvm14FPMathOperatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14FPMathOperatorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }



  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
