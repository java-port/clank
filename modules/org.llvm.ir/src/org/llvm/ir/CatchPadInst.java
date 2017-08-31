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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;


//===----------------------------------------------------------------------===//
//                               CatchPadInst Class
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::CatchPadInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4158,
 FQN="llvm::CatchPadInst", NM="_ZN4llvm12CatchPadInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm12CatchPadInstE")
//</editor-fold>
public class CatchPadInst extends /*public*/ FuncletPadInst implements Destructors.ClassWithDestructor {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchPadInst::CatchPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4160,
   FQN="llvm::CatchPadInst::CatchPadInst", NM="_ZN4llvm12CatchPadInstC1EPNS_5ValueENS_8ArrayRefIS2_EEjRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm12CatchPadInstC1EPNS_5ValueENS_8ArrayRefIS2_EEjRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private /*explicit*/ CatchPadInst(JD$Value$P_ArrayRef$Value$P_UInt_Twine$C_Instruction$P _dparam, Value /*P*/ CatchSwitch, ArrayRef<Value /*P*/ > Args,
      /*uint*/int Values, final /*const*/ Twine /*&*/ NameStr,
      Instruction /*P*/ InsertBefore) {
    // : FuncletPadInst(Instruction::CatchPad, CatchSwitch, Args, Values, NameStr, InsertBefore)
    //START JInit
    super(JD$FuncletPadOps_Value$P_ArrayRef$Value$P_UInt_Twine$C_Instruction$P.INSTANCE, Instruction.FuncletPadOps.CatchPad, CatchSwitch, new ArrayRef<Value /*P*/ >(Args), Values,
        NameStr, InsertBefore);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchPadInst::CatchPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4165,
   FQN="llvm::CatchPadInst::CatchPadInst", NM="_ZN4llvm12CatchPadInstC1EPNS_5ValueENS_8ArrayRefIS2_EEjRKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm12CatchPadInstC1EPNS_5ValueENS_8ArrayRefIS2_EEjRKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  private /*explicit*/ CatchPadInst(JD$Value$P_ArrayRef$Value$P_UInt_Twine$C_BasicBlock$P _dparam, Value /*P*/ CatchSwitch, ArrayRef<Value /*P*/ > Args,
      /*uint*/int Values, final /*const*/ Twine /*&*/ NameStr,
      BasicBlock /*P*/ InsertAtEnd) {
    // : FuncletPadInst(Instruction::CatchPad, CatchSwitch, Args, Values, NameStr, InsertAtEnd)
    //START JInit
    super(JD$FuncletPadOps_Value$P_ArrayRef$Value$P_UInt_Twine$C_BasicBlock$P.INSTANCE, Instruction.FuncletPadOps.CatchPad, CatchSwitch, new ArrayRef<Value /*P*/ >(Args), Values,
        NameStr, InsertAtEnd);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchPadInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4172,
   FQN="llvm::CatchPadInst::Create", NM="_ZN4llvm12CatchPadInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm12CatchPadInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CatchPadInst /*P*/ Create_Value1(Value /*P*/ CatchSwitch, ArrayRef<Value /*P*/ > Args) {
    return Create_Value1(CatchSwitch, Args,
               new Twine(/*KEEP_STR*/$EMPTY),
               (Instruction /*P*/ )null);
  }
  public static CatchPadInst /*P*/ Create_Value1(Value /*P*/ CatchSwitch, ArrayRef<Value /*P*/ > Args,
               final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create_Value1(CatchSwitch, Args,
               NameStr,
               (Instruction /*P*/ )null);
  }
  public static CatchPadInst /*P*/ Create_Value1(Value /*P*/ CatchSwitch, ArrayRef<Value /*P*/ > Args,
               final /*const*/ Twine /*&*/ NameStr/*= ""*/,
               Instruction /*P*/ InsertBefore/*= null*/) {
    /*uint*/int Values = 1 + Args.size();
    return ((/*JCast*/CatchPadInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (Values)*/ User.$new_FixedUses(Values, (type$ptr<?> New$Mem)->{
        return new CatchPadInst(JD$Value$P_ArrayRef$Value$P_UInt_Twine$C_Instruction$P.INSTANCE, CatchSwitch, new ArrayRef<Value /*P*/ >(Args), Values, NameStr, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchPadInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4179,
   FQN="llvm::CatchPadInst::Create", NM="_ZN4llvm12CatchPadInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm12CatchPadInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CatchPadInst /*P*/ Create_Value2(Value /*P*/ CatchSwitch, ArrayRef<Value /*P*/ > Args,
               final /*const*/ Twine /*&*/ NameStr, BasicBlock /*P*/ InsertAtEnd) {
    /*uint*/int Values = 1 + Args.size();
    return ((/*JCast*/CatchPadInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (Values)*/ User.$new_FixedUses(Values, (type$ptr<?> New$Mem)->{
        return new CatchPadInst(JD$Value$P_ArrayRef$Value$P_UInt_Twine$C_BasicBlock$P.INSTANCE, CatchSwitch, new ArrayRef<Value /*P*/ >(Args), Values, NameStr, InsertAtEnd);
     })));
  }


  /// Convenience accessors
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchPadInst::getCatchSwitch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4187,
   FQN="llvm::CatchPadInst::getCatchSwitch", NM="_ZNK4llvm12CatchPadInst14getCatchSwitchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm12CatchPadInst14getCatchSwitchEv")
  //</editor-fold>
  public CatchSwitchInst /*P*/ getCatchSwitch() /*const*/ {
    return cast_CatchSwitchInst(this./*<-1>*/Op$Const(-1));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchPadInst::setCatchSwitch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4190,
   FQN="llvm::CatchPadInst::setCatchSwitch", NM="_ZN4llvm12CatchPadInst14setCatchSwitchEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm12CatchPadInst14setCatchSwitchEPNS_5ValueE")
  //</editor-fold>
  public void setCatchSwitch(Value /*P*/ CatchSwitch) {
    assert Native.$bool(CatchSwitch);
    this./*<-1>*/Op(-1).$assign(CatchSwitch);
  }


  /// \brief Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::CatchPadInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4196,
   FQN="llvm::CatchPadInst::classof", NM="_ZN4llvm12CatchPadInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm12CatchPadInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.FuncletPadOps.CatchPad;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchPadInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4199,
   FQN="llvm::CatchPadInst::classof", NM="_ZN4llvm12CatchPadInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm12CatchPadInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && CatchPadInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CatchPadInst::~CatchPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4158,
   FQN="llvm::CatchPadInst::~CatchPadInst", NM="_ZN4llvm12CatchPadInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm12CatchPadInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
