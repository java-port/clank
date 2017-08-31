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


//===----------------------------------------------------------------------===//
//                           LandingPadInst Class
//===----------------------------------------------------------------------===//

//===---------------------------------------------------------------------------
/// LandingPadInst - The landingpad instruction holds all of the information
/// necessary to generate correct exception handling. The landingpad instruction
/// cannot be moved from the top of a landing pad block, which itself is
/// accessible only from the 'unwind' edge of an invoke. This uses the
/// SubclassData field in Value to store whether or not the landingpad is a
/// cleanup.
///
//<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2703,
 FQN="llvm::LandingPadInst", NM="_ZN4llvm14LandingPadInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInstE")
//</editor-fold>
public class LandingPadInst extends /*public*/ Instruction implements Destructors.ClassWithDestructor {
  /// ReservedSpace - The number of operands actually allocated.  NumOperands is
  /// the number actually in use.
  private /*uint*/int ReservedSpace;
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::LandingPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 191,
   FQN="llvm::LandingPadInst::LandingPadInst", NM="_ZN4llvm14LandingPadInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInstC1ERKS0_")
  //</editor-fold>
  private LandingPadInst(final /*const*/ LandingPadInst /*&*/ LP) {
    // : Instruction(LP.getType(), Instruction::LandingPad, null, LP.getNumOperands()), ReservedSpace(LP.getNumOperands())
    //START JInit
    super(LP.getType(), Instruction.OtherOps.LandingPad, (type$ptr<Use /*P*/> )null,
        LP.getNumOperands());
    this.ReservedSpace = LP.getNumOperands();
    //END JInit
    allocHungoffUses(LP.getNumOperands());
    type$ptr<Use /*P*/> OL = $tryClone(getOperandList());
    /*const*/type$ptr<Use /*P*/> InOL = $tryClone(LP.getOperandList$Const());
    for (/*uint*/int I = 0, E = ReservedSpace; I != E; ++I)  {
      OL.$at(I).$assign(InOL.$at(I));
    }

    setCleanup(LP.isCleanup());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::ClauseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2710,
   FQN="llvm::LandingPadInst::ClauseType", NM="_ZN4llvm14LandingPadInst10ClauseTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst10ClauseTypeE")
  //</editor-fold>
  public enum ClauseType implements Native.NativeUIntEnum {
    Catch(0),
    Filter(Catch.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ClauseType valueOf(int val) {
      ClauseType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ClauseType[] VALUES;
      private static final ClauseType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ClauseType kind : ClauseType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ClauseType[min < 0 ? (1-min) : 0];
        VALUES = new ClauseType[max >= 0 ? (1+max) : 0];
        for (ClauseType kind : ClauseType.values()) {
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
    private ClauseType(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2713,
   FQN="llvm::LandingPadInst::operator new", NM="_ZN4llvm14LandingPadInstnwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInstnwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_LandingPadInst(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  // Allocate space for exactly zero operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2715,
   FQN="llvm::LandingPadInst::operator new", NM="_ZN4llvm14LandingPadInstnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInstnwEj")
  //</editor-fold>
  private static <T extends LandingPadInst> T/*void P*/ $new_LandingPadInst(New$ConstructorCallback<T> $Ctor) {
    return User.$new_HangOffUses(/*s, */ $Ctor);
  }


  /// growOperands - grow operands - This grows the operand list in response to a
  /// push_back style of operation. This grows the number of ops by 2 times.
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::growOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 226,
   FQN="llvm::LandingPadInst::growOperands", NM="_ZN4llvm14LandingPadInst12growOperandsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst12growOperandsEj")
  //</editor-fold>
  private void growOperands(/*uint*/int Size) {
    /*uint*/int e = getNumOperands();
    if ($greatereq_uint(ReservedSpace, e + Size)) {
      return;
    }
    ReservedSpace = (std.max(e, 1/*U*/) + $div_uint(Size, 2)) * 2;
    growHungoffUses(ReservedSpace);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 216,
   FQN="llvm::LandingPadInst::init", NM="_ZN4llvm14LandingPadInst4initEjRKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst4initEjRKNS_5TwineE")
  //</editor-fold>
  private void init(/*uint*/int NumReservedValues, final /*const*/ Twine /*&*/ NameStr) {
    ReservedSpace = NumReservedValues;
    setNumHungOffUseOperands(0);
    allocHungoffUses(ReservedSpace);
    setName(NameStr);
    setCleanup(false);
  }



  //===----------------------------------------------------------------------===//
  //                       LandingPadInst Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::LandingPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 179,
   FQN="llvm::LandingPadInst::LandingPadInst", NM="_ZN4llvm14LandingPadInstC1EPNS_4TypeEjRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInstC1EPNS_4TypeEjRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  private LandingPadInst(Type /*P*/ RetTy, /*uint*/int NumReservedValues,
      final /*const*/ Twine /*&*/ NameStr, Instruction /*P*/ InsertBefore) {
    // : Instruction(RetTy, Instruction::LandingPad, null, 0, InsertBefore)
    //START JInit
    super(RetTy, Instruction.OtherOps.LandingPad, (type$ptr<Use /*P*/> )null, 0, InsertBefore);
    //END JInit
    init(NumReservedValues, NameStr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::LandingPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 185,
   FQN="llvm::LandingPadInst::LandingPadInst", NM="_ZN4llvm14LandingPadInstC1EPNS_4TypeEjRKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInstC1EPNS_4TypeEjRKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  private LandingPadInst(Type /*P*/ RetTy, /*uint*/int NumReservedValues,
      final /*const*/ Twine /*&*/ NameStr, BasicBlock /*P*/ InsertAtEnd) {
    // : Instruction(RetTy, Instruction::LandingPad, null, 0, InsertAtEnd)
    //START JInit
    super(RetTy, Instruction.OtherOps.LandingPad, (type$ptr<Use /*P*/> )null, 0, InsertAtEnd);
    //END JInit
    init(NumReservedValues, NameStr);
  }

/*protected:*/
  // Note: Instruction needs to be a friend here to call cloneImpl.
  /*friend  class Instruction*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 4037,
   FQN="llvm::LandingPadInst::cloneImpl", NM="_ZNK4llvm14LandingPadInst9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14LandingPadInst9cloneImplEv")
  //</editor-fold>
  protected LandingPadInst /*P*/ cloneImpl() /*const*/ {
    return /*NEW_EXPR [LandingPadInst::new]*/LandingPadInst.$new_LandingPadInst((type$ptr<?> New$Mem)->{
        return new LandingPadInst(/*Deref*/this);
     });
  }

/*public:*/
  /// Constructors - NumReservedClauses is a hint for the number of incoming
  /// clauses that this landingpad will have (use 0 if you really have no idea).
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 204,
   FQN="llvm::LandingPadInst::Create", NM="_ZN4llvm14LandingPadInst6CreateEPNS_4TypeEjRKNS_5TwineEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst6CreateEPNS_4TypeEjRKNS_5TwineEPNS_11InstructionE")
  //</editor-fold>
  public static LandingPadInst /*P*/ Create(Type /*P*/ RetTy, /*uint*/int NumReservedClauses) {
    return Create(RetTy, NumReservedClauses,
        new Twine(/*KEEP_STR*/$EMPTY),
        (Instruction /*P*/ )null);
  }
  public static LandingPadInst /*P*/ Create(Type /*P*/ RetTy, /*uint*/int NumReservedClauses,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/) {
    return Create(RetTy, NumReservedClauses,
        NameStr,
        (Instruction /*P*/ )null);
  }
  public static LandingPadInst /*P*/ Create(Type /*P*/ RetTy, /*uint*/int NumReservedClauses,
        final /*const*/ Twine /*&*/ NameStr/*= ""*/,
        Instruction /*P*/ InsertBefore/*= null*/) {
    return /*NEW_EXPR [LandingPadInst::new]*/LandingPadInst.$new_LandingPadInst((type$ptr<?> New$Mem)->{
        return new LandingPadInst(RetTy, NumReservedClauses, NameStr, InsertBefore);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 210,
   FQN="llvm::LandingPadInst::Create", NM="_ZN4llvm14LandingPadInst6CreateEPNS_4TypeEjRKNS_5TwineEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst6CreateEPNS_4TypeEjRKNS_5TwineEPNS_10BasicBlockE")
  //</editor-fold>
  public static LandingPadInst /*P*/ Create(Type /*P*/ RetTy, /*uint*/int NumReservedClauses,
        final /*const*/ Twine /*&*/ NameStr,
        BasicBlock /*P*/ InsertAtEnd) {
    return /*NEW_EXPR [LandingPadInst::new]*/LandingPadInst.$new_LandingPadInst((type$ptr<?> New$Mem)->{
        return new LandingPadInst(RetTy, NumReservedClauses, NameStr, InsertAtEnd);
     });
  }


  /// Provide fast operand accessors
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2793,
   FQN="llvm::LandingPadInst::getOperand", NM="_ZNK4llvm14LandingPadInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14LandingPadInst10getOperandEj")
  //</editor-fold>
  public Value /*P*/ getOperand(/*uint*/int i_nocapture) /*const*/ {
    assert ($less_uint(i_nocapture, OperandTraitsLandingPadInst.operands(this))) : "getOperand() out of range!";
    return cast_or_null_Value(OperandTraitsLandingPadInst.op_begin(((/*const_cast*/LandingPadInst /*P*/ )(this))).$at(i_nocapture).get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2793,
   FQN="llvm::LandingPadInst::setOperand", NM="_ZN4llvm14LandingPadInst10setOperandEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst10setOperandEjPNS_5ValueE")
  //</editor-fold>
  public void setOperand(/*uint*/int i_nocapture, Value /*P*/ Val_nocapture) {
    assert ($less_uint(i_nocapture, OperandTraitsLandingPadInst.operands(this))) : "setOperand() out of range!";
    OperandTraitsLandingPadInst.op_begin(this).$at(i_nocapture).$assign(Val_nocapture);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2793,
   FQN="llvm::LandingPadInst::op_begin", NM="_ZN4llvm14LandingPadInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst8op_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_begin() {
    return OperandTraitsLandingPadInst.op_begin(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2793,
   FQN="llvm::LandingPadInst::op_begin", NM="_ZNK4llvm14LandingPadInst8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14LandingPadInst8op_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_begin$Const() /*const*/ {
    return OperandTraitsLandingPadInst.op_begin(((/*const_cast*/LandingPadInst /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2793,
   FQN="llvm::LandingPadInst::op_end", NM="_ZN4llvm14LandingPadInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst6op_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> op_end() {
    return OperandTraitsLandingPadInst.op_end(this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2793,
   FQN="llvm::LandingPadInst::op_end", NM="_ZNK4llvm14LandingPadInst6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14LandingPadInst6op_endEv")
  //</editor-fold>
  public /*const*/type$ptr<Use /*P*/> op_end$Const() /*const*/ {
    return OperandTraitsLandingPadInst.op_end(((/*const_cast*/LandingPadInst /*P*/ )(this)));
  }

/*protected:*/
  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2793,
   FQN="llvm::LandingPadInst::Op", NM="Tpl__ZN4llvm14LandingPadInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZN4llvm14LandingPadInst2OpEv")
  //</editor-fold>
  protected Use /*&*/ Op(int Idx_nocapture) {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

  /*template <int> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::Op">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2793,
   FQN="llvm::LandingPadInst::Op", NM="Tpl__ZNK4llvm14LandingPadInst2OpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=Tpl__ZNK4llvm14LandingPadInst2OpEv")
  //</editor-fold>
  protected /*const*/ Use /*&*/ Op$Const(int Idx_nocapture) /*const*/ {
    return this./*<Idx_nocapture>*/OpFrom(Idx_nocapture, this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2793,
   FQN="llvm::LandingPadInst::getNumOperands", NM="_ZNK4llvm14LandingPadInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14LandingPadInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return OperandTraitsLandingPadInst.operands(this);
  }


  /// isCleanup - Return 'true' if this landingpad instruction is a
  /// cleanup. I.e., it should be run when unwinding even if its landing pad
  /// doesn't catch the exception.
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::isCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2746,
   FQN="llvm::LandingPadInst::isCleanup", NM="_ZNK4llvm14LandingPadInst9isCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14LandingPadInst9isCleanupEv")
  //</editor-fold>
  public boolean isCleanup() /*const*/ {
    return ((getSubclassDataFromInstruction() & 1) != 0);
  }


  /// setCleanup - Indicate that this landingpad instruction is a cleanup.
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::setCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2749,
   FQN="llvm::LandingPadInst::setCleanup", NM="_ZN4llvm14LandingPadInst10setCleanupEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst10setCleanupEb")
  //</editor-fold>
  public void setCleanup(boolean V) {
    setInstructionSubclassData($uint2ushort((getSubclassDataFromInstruction() & ~1)
           | (V ? 1 : 0)));
  }


  /// Add a catch or filter clause to the landing pad.
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::addClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Instructions.cpp", line = 233,
   FQN="llvm::LandingPadInst::addClause", NM="_ZN4llvm14LandingPadInst9addClauseEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst9addClauseEPNS_8ConstantE")
  //</editor-fold>
  public void addClause(Constant /*P*/ Val) {
    /*uint*/int OpNo = getNumOperands();
    growOperands(1);
    assert ($less_uint(OpNo, ReservedSpace)) : "Growing didn't work!";
    setNumHungOffUseOperands(getNumOperands() + 1);
    getOperandList().$at(OpNo).$assign(Val);
  }


  /// Get the value of the clause at index Idx. Use isCatch/isFilter to
  /// determine what type of clause this is.
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::getClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2759,
   FQN="llvm::LandingPadInst::getClause", NM="_ZNK4llvm14LandingPadInst9getClauseEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14LandingPadInst9getClauseEj")
  //</editor-fold>
  public Constant /*P*/ getClause(/*uint*/int Idx) /*const*/ {
    return cast_Constant(getOperandList$Const().$at(Idx));
  }


  /// isCatch - Return 'true' if the clause and index Idx is a catch clause.
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::isCatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2764,
   FQN="llvm::LandingPadInst::isCatch", NM="_ZNK4llvm14LandingPadInst7isCatchEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14LandingPadInst7isCatchEj")
  //</editor-fold>
  public boolean isCatch(/*uint*/int Idx) /*const*/ {
    return !isa_ArrayType(getOperandList$Const().$at(Idx).$arrow$Const().getType());
  }


  /// isFilter - Return 'true' if the clause and index Idx is a filter clause.
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::isFilter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2769,
   FQN="llvm::LandingPadInst::isFilter", NM="_ZNK4llvm14LandingPadInst8isFilterEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14LandingPadInst8isFilterEj")
  //</editor-fold>
  public boolean isFilter(/*uint*/int Idx) /*const*/ {
    return isa_ArrayType(getOperandList$Const().$at(Idx).$arrow$Const().getType());
  }


  /// getNumClauses - Get the number of clauses for this landing pad.
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::getNumClauses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2774,
   FQN="llvm::LandingPadInst::getNumClauses", NM="_ZNK4llvm14LandingPadInst13getNumClausesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZNK4llvm14LandingPadInst13getNumClausesEv")
  //</editor-fold>
  public /*uint*/int getNumClauses() /*const*/ {
    return getNumOperands();
  }


  /// reserveClauses - Grow the size of the operand list to accommodate the new
  /// number of clauses.
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::reserveClauses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2778,
   FQN="llvm::LandingPadInst::reserveClauses", NM="_ZN4llvm14LandingPadInst14reserveClausesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst14reserveClausesEj")
  //</editor-fold>
  public void reserveClauses(/*uint*/int Size) {
    growOperands(Size);
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2781,
   FQN="llvm::LandingPadInst::classof", NM="_ZN4llvm14LandingPadInst7classofEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst7classofEPKNS_11InstructionE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Instruction /*P*/ I) {
    return I.getOpcode() == Instruction.OtherOps.LandingPad;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2784,
   FQN="llvm::LandingPadInst::classof", NM="_ZN4llvm14LandingPadInst7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInst7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return isa_Instruction(V) && LandingPadInst.classof(cast_Instruction(V));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LandingPadInst::~LandingPadInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 2703,
   FQN="llvm::LandingPadInst::~LandingPadInst", NM="_ZN4llvm14LandingPadInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Instructions.cpp -nm=_ZN4llvm14LandingPadInstD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + "ReservedSpace=" + ReservedSpace // NOI18N
              + super.toString(); // NOI18N
  }
}
