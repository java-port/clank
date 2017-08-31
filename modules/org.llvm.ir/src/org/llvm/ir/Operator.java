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


/// This is a utility class that provides an abstraction for the common
/// functionality between Instructions and ConstantExprs.
//<editor-fold defaultstate="collapsed" desc="llvm::Operator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 32,
 FQN="llvm::Operator", NM="_ZN4llvm8OperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm8OperatorE")
//</editor-fold>
public class Operator extends /*public*/ User implements Destructors.ClassWithDestructor {
/*private:*/
  // The Operator class is intended to be used as a utility, and is never itself
  // instantiated.
  //<editor-fold defaultstate="collapsed" desc="llvm::Operator::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 36,
   FQN="llvm::Operator::operator new", NM="_ZN4llvm8OperatornwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm8OperatornwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_Operator(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::Operator::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 37,
   FQN="llvm::Operator::operator new", NM="_ZN4llvm8OperatornwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm8OperatornwEj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_Operator(/*size_t*/int s) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::Operator::Operator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 38,
   FQN="llvm::Operator::Operator", NM="_ZN4llvm8OperatorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm8OperatorC1Ev")
  //</editor-fold>
  protected/*private*/ Operator() { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  // NOTE: Cannot use = delete because it's not legal to delete
  // an overridden method that's not deleted in the base class. Cannot leave
  // this unimplemented because that leads to an ODR-violation.

  //===----------------------------------------------------------------------===//
  //                             Operator Class
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::Operator::~Operator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 201,
   FQN="llvm::Operator::~Operator", NM="_ZN4llvm8OperatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm8OperatorD0Ev")
  //</editor-fold>
  @Override public/*protected*/ void $destroy()/* override*/ {
    throw new llvm_unreachable("should never destroy an Operator");
  }

/*public:*/
  /// Return the opcode for this Instruction or ConstantExpr.
  //<editor-fold defaultstate="collapsed" desc="llvm::Operator::getOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 48,
   FQN="llvm::Operator::getOpcode", NM="_ZNK4llvm8Operator9getOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZNK4llvm8Operator9getOpcodeEv")
  //</editor-fold>
  public /*uint*/int getOpcode() /*const*/ {
    {
      /*const*/ Instruction /*P*/ I = dyn_cast_Instruction(this);
      if ((I != null)) {
        return I.getOpcode();
      }
    }
    return cast_ConstantExpr(this).getOpcode();
  }


  /// If V is an Instruction or ConstantExpr, return its opcode.
  /// Otherwise return UserOp1.
  //<editor-fold defaultstate="collapsed" desc="llvm::Operator::getOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 56,
   FQN="llvm::Operator::getOpcode", NM="_ZN4llvm8Operator9getOpcodeEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm8Operator9getOpcodeEPKNS_5ValueE")
  //</editor-fold>
  public static /*uint*/int getOpcode(/*const*/ Value /*P*/ V) {
    {
      /*const*/ Instruction /*P*/ I = dyn_cast_Instruction(V);
      if ((I != null)) {
        return I.getOpcode();
      }
    }
    {
      /*const*/ ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(V);
      if ((CE != null)) {
        return CE.getOpcode();
      }
    }
    return Instruction.OtherOps.UserOp1;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Operator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 64,
   FQN="llvm::Operator::classof", NM="_ZN4llvm8Operator7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm8Operator7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ $Prm0) {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Operator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 65,
   FQN="llvm::Operator::classof", NM="_ZN4llvm8Operator7classofEPKNS_12ConstantExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm8Operator7classofEPKNS_12ConstantExprE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ ConstantExpr /*P*/ $Prm0) {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Operator::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Operator.h", line = 66,
   FQN="llvm::Operator::classof", NM="_ZN4llvm8Operator7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm8Operator7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) || isa_ConstantExpr(V);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected Operator(Type ty, int vty, type$ptr<Use> $Prm2, int NumOps) { super(ty, vty, $Prm2, NumOps); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
