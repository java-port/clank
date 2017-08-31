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
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
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


/// Utility class for integer arithmetic operators which may exhibit overflow -
/// Add, Sub, and Mul. It does not include SDiv, despite that operator having
/// the potential for overflow.
//<editor-fold defaultstate="collapsed" desc="llvm::OverflowingBinaryOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 74,
 FQN="llvm::OverflowingBinaryOperator", NM="_ZN4llvm25OverflowingBinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm25OverflowingBinaryOperatorE")
//</editor-fold>
public class OverflowingBinaryOperator extends /*public*/ Operator implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::OverflowingBinaryOperator::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 76,
   FQN="llvm::OverflowingBinaryOperator::(anonymous)", NM="_ZN4llvm25OverflowingBinaryOperatorE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm25OverflowingBinaryOperatorE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NoUnsignedWrap = (1 << 0);
    public static final /*uint*/int NoSignedWrap = (1 << 1);
  /*}*/;
/*private:*/
  /*friend  class Instruction*/
  /*friend  class ConstantExpr*/
  //<editor-fold defaultstate="collapsed" desc="llvm::OverflowingBinaryOperator::setHasNoUnsignedWrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 84,
   FQN="llvm::OverflowingBinaryOperator::setHasNoUnsignedWrap", NM="_ZN4llvm25OverflowingBinaryOperator20setHasNoUnsignedWrapEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm25OverflowingBinaryOperator20setHasNoUnsignedWrapEb")
  //</editor-fold>
  /*friend*/public/*private*/ void setHasNoUnsignedWrap(boolean B) {
    SubclassOptionalData
       = $uchar2uchar_7bits($int2uchar(($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & ~NoUnsignedWrap) | ((B ? 1 : 0) * NoUnsignedWrap)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OverflowingBinaryOperator::setHasNoSignedWrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 88,
   FQN="llvm::OverflowingBinaryOperator::setHasNoSignedWrap", NM="_ZN4llvm25OverflowingBinaryOperator18setHasNoSignedWrapEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm25OverflowingBinaryOperator18setHasNoSignedWrapEb")
  //</editor-fold>
  /*friend*/public/*private*/ void setHasNoSignedWrap(boolean B) {
    SubclassOptionalData
       = $uchar2uchar_7bits($int2uchar(($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & ~NoSignedWrap) | ((B ? 1 : 0) * NoSignedWrap)));
  }

/*public:*/
  /// Test whether this operation is known to never
  /// undergo unsigned overflow, aka the nuw property.
  //<editor-fold defaultstate="collapsed" desc="llvm::OverflowingBinaryOperator::hasNoUnsignedWrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 96,
   FQN="llvm::OverflowingBinaryOperator::hasNoUnsignedWrap", NM="_ZNK4llvm25OverflowingBinaryOperator17hasNoUnsignedWrapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm25OverflowingBinaryOperator17hasNoUnsignedWrapEv")
  //</editor-fold>
  public boolean hasNoUnsignedWrap() /*const*/ {
    return (($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & NoUnsignedWrap) != 0);
  }


  /// Test whether this operation is known to never
  /// undergo signed overflow, aka the nsw property.
  //<editor-fold defaultstate="collapsed" desc="llvm::OverflowingBinaryOperator::hasNoSignedWrap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 102,
   FQN="llvm::OverflowingBinaryOperator::hasNoSignedWrap", NM="_ZNK4llvm25OverflowingBinaryOperator15hasNoSignedWrapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm25OverflowingBinaryOperator15hasNoSignedWrapEv")
  //</editor-fold>
  public boolean hasNoSignedWrap() /*const*/ {
    return ($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & NoSignedWrap) != 0;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::OverflowingBinaryOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 106,
   FQN="llvm::OverflowingBinaryOperator::classof", NM="_ZN4llvm25OverflowingBinaryOperator7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm25OverflowingBinaryOperator7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.BinaryOps.Add
       || I.getOpcode() == Instruction.BinaryOps.Sub
       || I.getOpcode() == Instruction.BinaryOps.Mul
       || I.getOpcode() == Instruction.BinaryOps.Shl;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OverflowingBinaryOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 112,
   FQN="llvm::OverflowingBinaryOperator::classof", NM="_ZN4llvm25OverflowingBinaryOperator7classofEPKNS_12ConstantExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm25OverflowingBinaryOperator7classofEPKNS_12ConstantExprE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ ConstantExpr /*P*/ CE) {
    return CE.getOpcode() == Instruction.BinaryOps.Add
       || CE.getOpcode() == Instruction.BinaryOps.Sub
       || CE.getOpcode() == Instruction.BinaryOps.Mul
       || CE.getOpcode() == Instruction.BinaryOps.Shl;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OverflowingBinaryOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 118,
   FQN="llvm::OverflowingBinaryOperator::classof", NM="_ZN4llvm25OverflowingBinaryOperator7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm25OverflowingBinaryOperator7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return (isa_Instruction(V) && OverflowingBinaryOperator.classof(cast_Instruction(V)))
       || (isa_ConstantExpr(V) && OverflowingBinaryOperator.classof(cast_ConstantExpr(V)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OverflowingBinaryOperator::~OverflowingBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 74,
   FQN="llvm::OverflowingBinaryOperator::~OverflowingBinaryOperator", NM="_ZN4llvm25OverflowingBinaryOperatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm25OverflowingBinaryOperatorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public OverflowingBinaryOperator(Type ty, int vty, type$ptr<Use> $Prm2, int NumOps) { super(ty, vty, $Prm2, NumOps); }

  public OverflowingBinaryOperator() { /*for descendants deleted ctors*/ }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
