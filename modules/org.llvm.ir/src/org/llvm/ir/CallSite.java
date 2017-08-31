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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.ir.java.IrRTTI.*;

//<editor-fold defaultstate="collapsed" desc="llvm::CallSite">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 601,
 FQN="llvm::CallSite", NM="_ZN4llvm8CallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallSiteE")
//</editor-fold>
public class CallSite extends /*public*/ CallSiteBase<Function, BasicBlock, Value, User, Use, Instruction, CallInst, InvokeInst, type$ptr<Use/*P*/> > implements NativeCloneable<CallSite>, Native.NativeComparable<CallSite> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::CallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 605,
   FQN="llvm::CallSite::CallSite", NM="_ZN4llvm8CallSiteC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallSiteC1Ev")
  //</editor-fold>
  public CallSite() {
    // : CallSiteBase<Function, BasicBlock, Value, User, Use, Instruction, CallInst, InvokeInst, User::op_iterator>()
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::CallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 606,
   FQN="llvm::CallSite::CallSite", NM="_ZN4llvm8CallSiteC1ENS_12CallSiteBaseINS_8FunctionENS_10BasicBlockENS_5ValueENS_4UserENS_3UseENS_11InstructionENS_8CallInstENS_10InvokeInstEPS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallSiteC1ENS_12CallSiteBaseINS_8FunctionENS_10BasicBlockENS_5ValueENS_4UserENS_3UseENS_11InstructionENS_8CallInstENS_10InvokeInstEPS6_EE")
  //</editor-fold>
  public CallSite(CallSiteBase<Function, BasicBlock, Value, User, Use, Instruction, CallInst, InvokeInst, type$ptr<Use /*P*/> > B) {
    // : CallSiteBase<Function, BasicBlock, Value, User, Use, Instruction, CallInst, InvokeInst, Use * >(B)
    //START JInit
    super(B);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::CallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 607,
   FQN="llvm::CallSite::CallSite", NM="_ZN4llvm8CallSiteC1EPNS_8CallInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallSiteC1EPNS_8CallInstE")
  //</editor-fold>
  public CallSite(CallInst /*P*/ CI) {
    // : CallSiteBase<Function, BasicBlock, Value, User, Use, Instruction, CallInst, InvokeInst, Use * >(CI)
    //START JInit
    super(JD$T6$P.INSTANCE, CI);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::CallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 608,
   FQN="llvm::CallSite::CallSite", NM="_ZN4llvm8CallSiteC1EPNS_10InvokeInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallSiteC1EPNS_10InvokeInstE")
  //</editor-fold>
  public CallSite(InvokeInst /*P*/ II) {
    // : CallSiteBase<Function, BasicBlock, Value, User, Use, Instruction, CallInst, InvokeInst, Use * >(II)
    //START JInit
    super(JD$T7$P.INSTANCE, II);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::CallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 609,
   FQN="llvm::CallSite::CallSite", NM="_ZN4llvm8CallSiteC1EPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallSiteC1EPNS_11InstructionE")
  //</editor-fold>
  public /*explicit*/ CallSite(Instruction /*P*/ II) {
    // : CallSiteBase<Function, BasicBlock, Value, User, Use, Instruction, CallInst, InvokeInst, Use * >(II)
    //START JInit
    super(JD$T2$P.INSTANCE, II);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::CallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 610,
   FQN="llvm::CallSite::CallSite", NM="_ZN4llvm8CallSiteC1EPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm8CallSiteC1EPNS_5ValueE")
  //</editor-fold>
  public /*explicit*/ CallSite(Value /*P*/ V) {
    // : CallSiteBase<Function, BasicBlock, Value, User, Use, Instruction, CallInst, InvokeInst, Use * >(V)
    //START JInit
    super(JD$T2$P.INSTANCE, V);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 612,
   FQN="llvm::CallSite::operator==", NM="_ZNK4llvm8CallSiteeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallSiteeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ CallSite /*&*/ CS) /*const*/ {
    return I.$eq(CS.I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 613,
   FQN="llvm::CallSite::operator!=", NM="_ZNK4llvm8CallSiteneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallSiteneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ CallSite /*&*/ CS) /*const*/ {
    return I.$noteq(CS.I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 614,
   FQN="llvm::CallSite::operator<", NM="_ZNK4llvm8CallSiteltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallSiteltERKS0_")
  //</editor-fold>
  public boolean $less(final /*const*/ CallSite /*&*/ CS) /*const*/ {
    // JAVA: TODO: think over how top convert this. In native 2 pointers are compared.
    // most likely getInstruction() needs to return a pointer
    throw new UnsupportedOperationException("EmptyBody");
    //return getInstruction() < CS.getInstruction();
  }

/*private:*/

  //===----------------------------------------------------------------------===//
  //                            CallSite Class
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::getCallee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 33,
   FQN="llvm::CallSite::getCallee", NM="_ZNK4llvm8CallSite9getCalleeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm8CallSite9getCalleeEv")
  //</editor-fold>
  private type$ptr<Use/*P*/> getCallee() /*const*/ {
    Instruction /*P*/ II/*J*/= getInstruction();
    return isCall() ? cast_CallInst(II).op_end().$sub(1) : cast_InvokeInst(II).op_end().$sub(3); // Skip BB, BB, Callee
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::CallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 601,
   FQN="llvm::CallSite::CallSite", NM="_ZN4llvm8CallSiteC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm8CallSiteC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CallSite(final /*const*/ CallSite /*&*/ $Prm0) {
    // : CallSiteBase<Function, BasicBlock, Value, User, Use, Instruction, CallInst, InvokeInst, User::op_iterator>()
    //START JInit
    super($Prm0);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::CallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 601,
   FQN="llvm::CallSite::CallSite", NM="_ZN4llvm8CallSiteC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm8CallSiteC1EOS0_")
  //</editor-fold>
  public /*inline*/ CallSite(JD$Move _dparam, final CallSite /*&&*/$Prm0) {
    // : CallSiteBase<Function, BasicBlock, Value, User, Use, Instruction, CallInst, InvokeInst, User::op_iterator>(static_cast<CallSite &&>())
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 601,
   FQN="llvm::CallSite::operator=", NM="_ZN4llvm8CallSiteaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm8CallSiteaSERKS0_")
  //</editor-fold>
  public /*inline*/ CallSite /*&*/ $assign(final /*const*/ CallSite /*&*/ $Prm0) {
    /*J:ToBase*/super.$assign($Prm0);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSite::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 601,
   FQN="llvm::CallSite::operator=", NM="_ZN4llvm8CallSiteaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm8CallSiteaSEOS0_")
  //</editor-fold>
  public /*inline*/ CallSite /*&*/ $assignMove(final CallSite /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override  public CallSite clone() { return new CallSite(this);  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
