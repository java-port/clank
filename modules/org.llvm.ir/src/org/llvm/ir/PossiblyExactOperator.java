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


/// A udiv or sdiv instruction, which can be marked as "exact",
/// indicating that no bits are destroyed.
//<editor-fold defaultstate="collapsed" desc="llvm::PossiblyExactOperator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 126,
 FQN="llvm::PossiblyExactOperator", NM="_ZN4llvm21PossiblyExactOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21PossiblyExactOperatorE")
//</editor-fold>
public class PossiblyExactOperator extends /*public*/ Operator implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PossiblyExactOperator::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 128,
   FQN="llvm::PossiblyExactOperator::(anonymous)", NM="_ZN4llvm21PossiblyExactOperatorE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21PossiblyExactOperatorE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int IsExact = (1 << 0);
  /*}*/;
/*private:*/
  /*friend  class Instruction*/
  /*friend  class ConstantExpr*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PossiblyExactOperator::setIsExact">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 135,
   FQN="llvm::PossiblyExactOperator::setIsExact", NM="_ZN4llvm21PossiblyExactOperator10setIsExactEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21PossiblyExactOperator10setIsExactEb")
  //</editor-fold>
  /*friend*/public/*private*/ void setIsExact(boolean B) {
    SubclassOptionalData = $uchar2uchar_7bits($int2uchar(($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & ~IsExact) | ((B ? 1 : 0) * IsExact)));
  }

/*public:*/
  /// Test whether this division is known to be exact, with zero remainder.
  //<editor-fold defaultstate="collapsed" desc="llvm::PossiblyExactOperator::isExact">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 141,
   FQN="llvm::PossiblyExactOperator::isExact", NM="_ZNK4llvm21PossiblyExactOperator7isExactEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZNK4llvm21PossiblyExactOperator7isExactEv")
  //</editor-fold>
  public boolean isExact() /*const*/ {
    return (($uchar2int($7bits_uchar2uchar(SubclassOptionalData)) & IsExact) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PossiblyExactOperator::isPossiblyExactOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 145,
   FQN="llvm::PossiblyExactOperator::isPossiblyExactOpcode", NM="_ZN4llvm21PossiblyExactOperator21isPossiblyExactOpcodeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21PossiblyExactOperator21isPossiblyExactOpcodeEj")
  //</editor-fold>
  public static boolean isPossiblyExactOpcode(/*uint*/int OpC) {
    return OpC == Instruction.BinaryOps.SDiv
       || OpC == Instruction.BinaryOps.UDiv
       || OpC == Instruction.BinaryOps.AShr
       || OpC == Instruction.BinaryOps.LShr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PossiblyExactOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 151,
   FQN="llvm::PossiblyExactOperator::classof", NM="_ZN4llvm21PossiblyExactOperator7classofEPKNS_12ConstantExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21PossiblyExactOperator7classofEPKNS_12ConstantExprE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ ConstantExpr /*P*/ CE) {
    return PossiblyExactOperator.isPossiblyExactOpcode(CE.getOpcode());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PossiblyExactOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 154,
   FQN="llvm::PossiblyExactOperator::classof", NM="_ZN4llvm21PossiblyExactOperator7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21PossiblyExactOperator7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return PossiblyExactOperator.isPossiblyExactOpcode(I.getOpcode());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PossiblyExactOperator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 157,
   FQN="llvm::PossiblyExactOperator::classof", NM="_ZN4llvm21PossiblyExactOperator7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21PossiblyExactOperator7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return (isa_Instruction(V) && PossiblyExactOperator.classof(cast_Instruction(V)))
       || (isa_ConstantExpr(V) && PossiblyExactOperator.classof(cast_ConstantExpr(V)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PossiblyExactOperator::~PossiblyExactOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 126,
   FQN="llvm::PossiblyExactOperator::~PossiblyExactOperator", NM="_ZN4llvm21PossiblyExactOperatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Operator.cpp -nm=_ZN4llvm21PossiblyExactOperatorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public PossiblyExactOperator(Type ty, int vty, type$ptr<Use> $Prm2, int NumOps) { super(ty, vty, $Prm2, NumOps); }
  
  public PossiblyExactOperator() { /*for descendants deleted ctors*/ }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
