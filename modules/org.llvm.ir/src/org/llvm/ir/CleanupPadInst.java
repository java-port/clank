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
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;


//===----------------------------------------------------------------------===//
//                               CleanupPadInst Class
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::CleanupPadInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4118,
 FQN="llvm::CleanupPadInst", NM="_ZN4llvm14CleanupPadInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14CleanupPadInstE")
//</editor-fold>
public class CleanupPadInst extends /*public*/ FuncletPadInst implements Destructors.ClassWithDestructor {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupPadInst::CleanupPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4120,
   FQN="llvm::CleanupPadInst::CleanupPadInst", NM="_ZN4llvm14CleanupPadInstC1EPNS_5ValueENS_8ArrayRefIS2_EEjRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14CleanupPadInstC1EPNS_5ValueENS_8ArrayRefIS2_EEjRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private /*explicit*/ CleanupPadInst(JD$Value$P_ArrayRef$Value$P_UInt_Twine$C_Instruction$P _dparam, Value /*P*/ ParentPad, ArrayRef<Value /*P*/ > Args,
      /*uint*/int Values, final /*const*/ Twine /*&*/ NameStr,
      Instruction /*P*/ InsertBefore) {
    // : FuncletPadInst(Instruction::CleanupPad, ParentPad, Args, Values, NameStr, InsertBefore)
    //START JInit
    super(JD$FuncletPadOps_Value$P_ArrayRef$Value$P_UInt_Twine$C_Instruction$P.INSTANCE, Instruction.FuncletPadOps.CleanupPad, ParentPad, new ArrayRef<Value /*P*/ >(Args), Values,
        NameStr, InsertBefore);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupPadInst::CleanupPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4125,
   FQN="llvm::CleanupPadInst::CleanupPadInst", NM="_ZN4llvm14CleanupPadInstC1EPNS_5ValueENS_8ArrayRefIS2_EEjRKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14CleanupPadInstC1EPNS_5ValueENS_8ArrayRefIS2_EEjRKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  private /*explicit*/ CleanupPadInst(JD$Value$P_ArrayRef$Value$P_UInt_Twine$C_BasicBlock$P _dparam, Value /*P*/ ParentPad, ArrayRef<Value /*P*/ > Args,
      /*uint*/int Values, final /*const*/ Twine /*&*/ NameStr,
      BasicBlock /*P*/ InsertAtEnd) {
    // : FuncletPadInst(Instruction::CleanupPad, ParentPad, Args, Values, NameStr, InsertAtEnd)
    //START JInit
    super(JD$FuncletPadOps_Value$P_ArrayRef$Value$P_UInt_Twine$C_BasicBlock$P.INSTANCE, Instruction.FuncletPadOps.CleanupPad, ParentPad, new ArrayRef<Value /*P*/ >(Args), Values,
        NameStr, InsertAtEnd);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupPadInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4132,
   FQN="llvm::CleanupPadInst::Create", NM="_ZN4llvm14CleanupPadInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14CleanupPadInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static CleanupPadInst /*P*/ Create_Value$P_ArrayRef$Value$P_Twine$C_Instruction$P(Value /*P*/ ParentPad) {
    return Create_Value$P_ArrayRef$Value$P_Twine$C_Instruction$P(ParentPad, new ArrayRef<Value /*P*/ >(None, true),
                                                       new Twine(/*KEEP_STR*/$EMPTY),
                                                       (Instruction /*P*/ )null);
  }
  public static CleanupPadInst /*P*/ Create_Value$P_ArrayRef$Value$P_Twine$C_Instruction$P(Value /*P*/ ParentPad, ArrayRef<Value /*P*/ > Args/*= None*/) {
    return Create_Value$P_ArrayRef$Value$P_Twine$C_Instruction$P(ParentPad, Args,
                                                       new Twine(/*KEEP_STR*/$EMPTY),
                                                       (Instruction /*P*/ )null);
  }
  public static CleanupPadInst /*P*/ Create_Value$P_ArrayRef$Value$P_Twine$C_Instruction$P(Value /*P*/ ParentPad, ArrayRef<Value /*P*/ > Args/*= None*/,
                                                       final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create_Value$P_ArrayRef$Value$P_Twine$C_Instruction$P(ParentPad, Args,
                                                       NameStr,
                                                       (Instruction /*P*/ )null);
  }
  public static CleanupPadInst /*P*/ Create_Value$P_ArrayRef$Value$P_Twine$C_Instruction$P(Value /*P*/ ParentPad, ArrayRef<Value /*P*/ > Args/*= None*/,
                                                       final /*const*/ Twine /*&*/ NameStr/*= ""*/,
                                                       Instruction /*P*/ InsertBefore/*= null*/) {
    /*uint*/int Values = 1 + Args.size();
    return ((/*JCast*/CleanupPadInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (Values)*/ User.$new_FixedUses(Values, (type$ptr<?> New$Mem)->{
        return new CleanupPadInst(JD$Value$P_ArrayRef$Value$P_UInt_Twine$C_Instruction$P.INSTANCE, ParentPad, new ArrayRef<Value /*P*/ >(Args), Values, NameStr, InsertBefore);
     })));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupPadInst::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4139,
   FQN="llvm::CleanupPadInst::Create", NM="_ZN4llvm14CleanupPadInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14CleanupPadInst6CreateEPNS_5ValueENS_8ArrayRefIS2_EERKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static CleanupPadInst /*P*/ Create_Value$P_ArrayRef$Value$P_Twine$C_BasicBlock$P(Value /*P*/ ParentPad, ArrayRef<Value /*P*/ > Args,
                                                      final /*const*/ Twine /*&*/ NameStr, BasicBlock /*P*/ InsertAtEnd) {
    /*uint*/int Values = 1 + Args.size();
    return ((/*JCast*/CleanupPadInst /*P*/ )(/*NEW_EXPR [User::new]*//*new (Values)*/ User.$new_FixedUses(Values, (type$ptr<?> New$Mem)->{
        return new CleanupPadInst(JD$Value$P_ArrayRef$Value$P_UInt_Twine$C_BasicBlock$P.INSTANCE, ParentPad, new ArrayRef<Value /*P*/ >(Args), Values, NameStr, InsertAtEnd);
     })));
  }


  /// \brief Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupPadInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4147,
   FQN="llvm::CleanupPadInst::classof", NM="_ZN4llvm14CleanupPadInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14CleanupPadInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.FuncletPadOps.CleanupPad;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupPadInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4150,
   FQN="llvm::CleanupPadInst::classof", NM="_ZN4llvm14CleanupPadInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14CleanupPadInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && CleanupPadInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CleanupPadInst::~CleanupPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 4118,
   FQN="llvm::CleanupPadInst::~CleanupPadInst", NM="_ZN4llvm14CleanupPadInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14CleanupPadInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
