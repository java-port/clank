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
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;

/*template <typename FunTy = const Function, typename BBTy = const BasicBlock, typename ValTy = const Value, typename UserTy = const User, typename UseTy = const Use, typename InstrTy = const Instruction, typename CallTy = const CallInst, typename InvokeTy = const InvokeInst, typename IterTy = User::const_op_iterator> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 40,
 FQN="llvm::CallSiteBase", NM="_ZN4llvm12CallSiteBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBaseE")
//</editor-fold>
public class CallSiteBase<
        /*typename*/ FunTy extends ValTy/* = const Function*/,
        /*typename*/ BBTy extends BasicBlock/* = const BasicBlock*/,
        /*typename*/ ValTy extends Value/* = const Value*/,
        /*typename*/ UserTy/* = const User*/,
        /*typename*/ UseTy extends Use/* = const Use*/,
        /*typename*/ InstrTy extends Instruction /* = const InstructioInstructionn*/,
        /*typename*/ CallTy extends CallInst/* = const CallInst*/,
        /*typename*/ InvokeTy/* = const InvokeInst*/,
        /*typename*/ IterTy extends type$iterator<IterTy, UseTy>/* = User::const_op_iterator*/>
        implements Native.Native$Bool {
/*protected:*/
  protected PointerBoolPair<InstrTy /*P*/> I;

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::CallSiteBase<FunTy, BBTy, ValTy, UserTy, UseTy, InstrTy, CallTy, InvokeTy, IterTy>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 53,
   FQN="llvm::CallSiteBase::CallSiteBase<FunTy, BBTy, ValTy, UserTy, UseTy, InstrTy, CallTy, InvokeTy, IterTy>", NM="_ZN4llvm12CallSiteBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBaseC1Ev")
  //</editor-fold>
  protected CallSiteBase() {
    // : I(null, false)
    //START JInit
    this.I = /*ParenListExpr*/new PointerBoolPair<InstrTy /*P*/>(null, false);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::CallSiteBase<FunTy, BBTy, ValTy, UserTy, UseTy, InstrTy, CallTy, InvokeTy, IterTy>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 54,
   FQN="llvm::CallSiteBase::CallSiteBase<FunTy, BBTy, ValTy, UserTy, UseTy, InstrTy, CallTy, InvokeTy, IterTy>", NM="_ZN4llvm12CallSiteBaseC1EPT5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBaseC1EPT5_")
  //</editor-fold>
  protected CallSiteBase(JD$T6$P _dparam, CallTy /*P*/ CI) {
    // : I(CI, true)
    //START JInit
    this.I = /*ParenListExpr*/new PointerBoolPair<InstrTy /*P*/>((InstrTy)CI, true);
    //END JInit
    assert Native.$bool(CI);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::CallSiteBase<FunTy, BBTy, ValTy, UserTy, UseTy, InstrTy, CallTy, InvokeTy, IterTy>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 55,
   FQN="llvm::CallSiteBase::CallSiteBase<FunTy, BBTy, ValTy, UserTy, UseTy, InstrTy, CallTy, InvokeTy, IterTy>", NM="_ZN4llvm12CallSiteBaseC1EPT6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBaseC1EPT6_")
  //</editor-fold>
  protected CallSiteBase(JD$T7$P _dparam, InvokeTy /*P*/ II) {
    // : I(II, false)
    //START JInit
    this.I = /*ParenListExpr*/new PointerBoolPair<InstrTy /*P*/>((InstrTy)II, false);
    //END JInit
    assert Native.$bool(II);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::CallSiteBase<FunTy, BBTy, ValTy, UserTy, UseTy, InstrTy, CallTy, InvokeTy, IterTy>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 56,
   FQN="llvm::CallSiteBase::CallSiteBase<FunTy, BBTy, ValTy, UserTy, UseTy, InstrTy, CallTy, InvokeTy, IterTy>", NM="_ZN4llvm12CallSiteBaseC1EPT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBaseC1EPT1_")
  //</editor-fold>
  protected /*explicit*/ CallSiteBase(JD$T2$P _dparam, ValTy /*P*/ II) {
    //JAVA: below I use JD$Move.INSTANCE since I know that CallSiteBase.get creates a new instance, so it isn't worth copying
    this(JD$Move.INSTANCE, CallSiteBase.get(II));
  }

/*private:*/
  /// CallSiteBase::get - This static method is sort of like a constructor.  It
  /// will create an appropriate call site for a Call or Invoke instruction, but
  /// it can also create a null initialized CallSiteBase object for something
  /// which is NOT a call site.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 64,
   FQN="llvm::CallSiteBase::get", NM="_ZN4llvm12CallSiteBase3getEPT1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase3getEPT1_")
  //</editor-fold>
  private static <
                /*typename*/ FunTy extends ValTy/* = const Function*/,
                /*typename*/ BBTy extends BasicBlock/* = const BasicBlock*/,
                /*typename*/ ValTy extends Value/* = const Value*/,
                /*typename*/ UserTy/* = const User*/,
                /*typename*/ UseTy extends Use/* = const Use*/,
                /*typename*/ InstrTy extends Instruction /* = const InstructioInstructionn*/,
                /*typename*/ CallTy extends CallInst/* = const CallInst*/,
                /*typename*/ InvokeTy/* = const InvokeInst*/,
                /*typename*/ IterTy extends type$iterator<IterTy, UseTy>/* = User::const_op_iterator*/>

        CallSiteBase<FunTy, BBTy, ValTy, UserTy, UseTy, InstrTy, CallTy, InvokeTy, IterTy> get(ValTy /*P*/ V) {
    {
      // JAVA: in theory, the line below is not correct (it checks instanceof Instruction, but casts to InstrTy
      // But C++ shows that there are only 2 instantiations, both with default value.
      // So InstrTy template parameter can be just removed... At least it doesn't make sense to pass Class<InstrTy> in ctors, etc...
      InstrTy /*P*/ II = /*dyn_cast_InstrTy*/(V instanceof Instruction) ? (InstrTy)(V) : null;
      if (II != null) {
        if (Native.$eq(II.getOpcode(), Instruction.OtherOps.Call)) {
          return new CallSiteBase<FunTy, BBTy, ValTy, UserTy, UseTy, InstrTy, CallTy, InvokeTy, IterTy>(JD$T6$P.INSTANCE, ((/*static_cast*/CallTy /*P*/ )(II)));
        } else if (Native.$eq(II.getOpcode(), Instruction.TermOps.Invoke)) {
          return new CallSiteBase<FunTy, BBTy, ValTy, UserTy, UseTy, InstrTy, CallTy, InvokeTy, IterTy>(JD$T7$P.INSTANCE, ((/*static_cast*/InvokeTy /*P*/ )(II)));
        }
      }
    }
    return new CallSiteBase<>();
  }

/*public:*/
  /// isCall - true if a CallInst is enclosed.
  /// Note that !isCall() does not mean it is an InvokeInst enclosed,
  /// it also could signify a NULL Instruction pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 78,
   FQN="llvm::CallSiteBase::isCall", NM="_ZNK4llvm12CallSiteBase6isCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase6isCallEv")
  //</editor-fold>
  public boolean isCall() /*const*/ {
    return I.getInt();
  }


  /// isInvoke - true if a InvokeInst is enclosed.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isInvoke">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 82,
   FQN="llvm::CallSiteBase::isInvoke", NM="_ZNK4llvm12CallSiteBase8isInvokeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase8isInvokeEv")
  //</editor-fold>
  public boolean isInvoke() /*const*/ {
    return Native.$bool(getInstruction()) && Native.$not(I.getInt());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 84,
   FQN="llvm::CallSiteBase::getInstruction", NM="_ZNK4llvm12CallSiteBase14getInstructionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase14getInstructionEv")
  //</editor-fold>
  public InstrTy /*P*/ getInstruction() /*const*/ {
    return I.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 85,
   FQN="llvm::CallSiteBase::operator->", NM="_ZNK4llvm12CallSiteBaseptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBaseptEv")
  //</editor-fold>
  public InstrTy /*P*/ $arrow() /*const*/ {
    return I.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::operator bool">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 86,
   FQN="llvm::CallSiteBase::operator bool", NM="_ZNK4llvm12CallSiteBasecvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBasecvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return I.getPointer() != null;
  }


  /// Get the basic block containing the call site
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getParent">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 89,
   FQN="llvm::CallSiteBase::getParent", NM="_ZNK4llvm12CallSiteBase9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase9getParentEv")
  //</editor-fold>
  public BBTy /*P*/ getParent() /*const*/ {
    return (BBTy) getInstruction().getParent();
  }


  /// getCalledValue - Return the pointer to function that is being called.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getCalledValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 93,
   FQN="llvm::CallSiteBase::getCalledValue", NM="_ZNK4llvm12CallSiteBase14getCalledValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase14getCalledValueEv")
  //</editor-fold>
  public ValTy /*P*/ getCalledValue() /*const*/ {
    assert Native.$bool(getInstruction()) : "Not a call or invoke instruction!";
    return (ValTy) $Deref(getCallee()).$Value$P();
  }


  /// getCalledFunction - Return the function being called if this is a direct
  /// call, otherwise return null (if it's an indirect call).
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getCalledFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 101,
   FQN="llvm::CallSiteBase::getCalledFunction", NM="_ZNK4llvm12CallSiteBase17getCalledFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase17getCalledFunctionEv")
  //</editor-fold>
  public FunTy /*P*/ getCalledFunction() /*const*/ {
    return /*dyn_cast_FunTy*/(FunTy)(getCalledValue());
  }


  /// setCalledFunction - Set the callee to the specified value.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setCalledFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 107,
   FQN="llvm::CallSiteBase::setCalledFunction", NM="_ZN4llvm12CallSiteBase17setCalledFunctionEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase17setCalledFunctionEPNS_5ValueE")
  //</editor-fold>
  public void setCalledFunction(Value /*P*/ V) {
    assert Native.$bool(getInstruction()) : "Not a call or invoke instruction!";
    getCallee().$star().$assign(V);
  }


  /// isCallee - Determine whether the passed iterator points to the
  /// callee operand's Use.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isCallee">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 114,
   FQN="llvm::CallSiteBase::isCallee", NM="_ZNK4llvm12CallSiteBase8isCalleeENS_5Value18user_iterator_implIKNS_4UserEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase8isCalleeENS_5Value18user_iterator_implIKNS_4UserEEE")
  //</editor-fold>
  public boolean isCallee(Value.user_iterator_impl</*const*/ User> UI) /*const*/ {
    return isCallee($AddrOf(UI.getUse()));
  }


  /// Determine whether this Use is the callee operand's Use.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isCallee">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 119,
   FQN="llvm::CallSiteBase::isCallee", NM="_ZNK4llvm12CallSiteBase8isCalleeEPKNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase8isCalleeEPKNS_3UseE")
  //</editor-fold>
  public boolean isCallee(/*const*/type$ptr<Use /*P*/> U) /*const*/ {
    return Native.$eq(getCallee(), U);
  }


  /// \brief Determine whether the passed iterator points to an argument
  /// operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isArgOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 123,
   FQN="llvm::CallSiteBase::isArgOperand", NM="_ZNK4llvm12CallSiteBase12isArgOperandENS_5Value18user_iterator_implIKNS_4UserEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase12isArgOperandENS_5Value18user_iterator_implIKNS_4UserEEE")
  //</editor-fold>
  public boolean isArgOperand(Value.user_iterator_impl</*const*/ User> UI) /*const*/ {
    return isArgOperand($AddrOf(UI.getUsePtr()));
  }


  /// \brief Determine whether the passed use points to an argument operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isArgOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 128,
   FQN="llvm::CallSiteBase::isArgOperand", NM="_ZNK4llvm12CallSiteBase12isArgOperandEPKNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase12isArgOperandEPKNS_3UseE")
  //</editor-fold>
  public boolean isArgOperand(/*const*/type$iterator<?, Use /*P*/> U) /*const*/ {
    assert Native.$bool(Native.$eq(getInstruction(), U./*->*/$star().getUser()));
    return Native.$bool(Native.$lesseq(arg_begin(), U)) && Native.$bool(Native.$less(U, arg_end()));
  }


  /// \brief Determine whether the passed iterator points to a bundle operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isBundleOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 134,
   FQN="llvm::CallSiteBase::isBundleOperand", NM="_ZNK4llvm12CallSiteBase15isBundleOperandENS_5Value18user_iterator_implIKNS_4UserEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase15isBundleOperandENS_5Value18user_iterator_implIKNS_4UserEEE")
  //</editor-fold>
  public boolean isBundleOperand(Value.user_iterator_impl</*const*/ User> UI) /*const*/ {
    return isBundleOperand($AddrOf(UI.getUsePtr()));
  }


  /// \brief Determine whether the passed use points to a bundle operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isBundleOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 139,
   FQN="llvm::CallSiteBase::isBundleOperand", NM="_ZNK4llvm12CallSiteBase15isBundleOperandEPKNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase15isBundleOperandEPKNS_3UseE")
  //</editor-fold>
  public boolean isBundleOperand(/*const*/type$ptr<Use /*P*/> U) /*const*/ {
    assert Native.$bool(Native.$eq(getInstruction(), U./*->*/$star().getUser()));
    if (Native.$not(hasOperandBundles())) {
      return false;
    }
    /*uint*/int OperandNo = U.$sub((/*Deref*/this).$arrow().op_begin());
    return Native.$bool(Native.$lesseq(getBundleOperandsStartIndex(), OperandNo))
       && Native.$bool(Native.$less(OperandNo, getBundleOperandsEndIndex()));
  }
  public boolean isBundleOperand(Value.use_iterator_impl<Use> U) /*const*/ {
    assert Native.$bool(Native.$eq(getInstruction(), U./*->*/$star().getUser()));
    if (Native.$not(hasOperandBundles())) {
      return false;
    }
    /*uint*/int OperandNo = U.$sub((/*Deref*/this).$arrow().op_begin());
    return Native.$bool(Native.$lesseq(getBundleOperandsStartIndex(), OperandNo))
       && Native.$bool(Native.$less(OperandNo, getBundleOperandsEndIndex()));
  }


  /// \brief Determine whether the passed iterator points to a data operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isDataOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 149,
   FQN="llvm::CallSiteBase::isDataOperand", NM="_ZNK4llvm12CallSiteBase13isDataOperandENS_5Value18user_iterator_implIKNS_4UserEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase13isDataOperandENS_5Value18user_iterator_implIKNS_4UserEEE")
  //</editor-fold>
  public boolean isDataOperand(Value.user_iterator_impl</*const*/ User> UI) /*const*/ {
    return isDataOperand($AddrOf(UI.getUsePtr()));
  }


  /// \brief Determine whether the passed use points to a data operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isDataOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 154,
   FQN="llvm::CallSiteBase::isDataOperand", NM="_ZNK4llvm12CallSiteBase13isDataOperandEPKNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase13isDataOperandEPKNS_3UseE")
  //</editor-fold>
  public boolean isDataOperand(/*const*/type$iterator<?, Use /*P*/> U) /*const*/ {
    return Native.$bool(Native.$lesseq(data_operands_begin(), U)) && Native.$bool(Native.$less(U, data_operands_end()));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getArgument">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 158,
   FQN="llvm::CallSiteBase::getArgument", NM="_ZNK4llvm12CallSiteBase11getArgumentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase11getArgumentEj")
  //</editor-fold>
  public ValTy /*P*/ getArgument(/*uint*/int ArgNo) /*const*/ {
    assert Native.$bool(Native.$less(Native.$add(arg_begin(), ArgNo), arg_end())) : "Argument # out of range!";
    UseTy $Deref = $Deref((Native.$add(arg_begin(), ArgNo)));
    return (ValTy) $Deref((Native.$add(arg_begin(), ArgNo))).$Value$P();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setArgument">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 163,
   FQN="llvm::CallSiteBase::setArgument", NM="_ZN4llvm12CallSiteBase11setArgumentEjPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase11setArgumentEjPNS_5ValueE")
  //</editor-fold>
  public void setArgument(/*uint*/int ArgNo, Value /*P*/ newVal) {
    assert Native.$bool(getInstruction()) : "Not a call or invoke instruction!";
    assert Native.$bool(Native.$less(Native.$add(arg_begin(), ArgNo), arg_end())) : "Argument # out of range!";
    getInstruction().setOperand(ArgNo, newVal);
  }


  /// Given a value use iterator, returns the argument that corresponds to it.
  /// Iterator must actually correspond to an argument.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getArgumentNo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 171,
   FQN="llvm::CallSiteBase::getArgumentNo", NM="_ZNK4llvm12CallSiteBase13getArgumentNoENS_5Value18user_iterator_implIKNS_4UserEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase13getArgumentNoENS_5Value18user_iterator_implIKNS_4UserEEE")
  //</editor-fold>
  public /*uint*/int getArgumentNo(Value.user_iterator_impl</*const*/ User> I) /*const*/ {
    return getArgumentNo($AddrOf(I.getUsePtr()));
  }


  /// Given a use for an argument, get the argument number that corresponds to
  /// it.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getArgumentNo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 177,
   FQN="llvm::CallSiteBase::getArgumentNo", NM="_ZNK4llvm12CallSiteBase13getArgumentNoEPKNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase13getArgumentNoEPKNS_3UseE")
  //</editor-fold>
  public /*uint*/int getArgumentNo(/*const*/type$iterator<?, Use /*P*/> U) /*const*/ {
    assert Native.$bool(getInstruction()) : "Not a call or invoke instruction!";
    assert Native.$bool(isArgOperand(U)) : "Argument # out of range!";
    return /*U.$sub(arg_begin())*/ std.distance(arg_begin(), U);
  }


  /// arg_iterator - The type of iterator to use when looping over actual
  /// arguments at this call site.
  // JAVA: typedef IterTy arg_iterator
//  public final class arg_iterator extends IterTy{ };

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::args">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 187,
   FQN="llvm::CallSiteBase::args", NM="_ZNK4llvm12CallSiteBase4argsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase4argsEv")
  //</editor-fold>
  public iterator_range<UseTy> args() /*const*/ {
    return make_range(arg_begin(), arg_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::arg_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 190,
   FQN="llvm::CallSiteBase::arg_empty", NM="_ZNK4llvm12CallSiteBase9arg_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase9arg_emptyEv")
  //</editor-fold>
  public boolean arg_empty() /*const*/ {
    return Native.$eq(arg_end(), arg_begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::arg_size">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 191,
   FQN="llvm::CallSiteBase::arg_size", NM="_ZNK4llvm12CallSiteBase8arg_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase8arg_sizeEv")
  //</editor-fold>
  public /*uint*/int arg_size() /*const*/ {
    return /*uint*/(int)(arg_end().$sub(arg_begin()));
  }


  /// Given a value use iterator, returns the data operand that corresponds to
  /// it.
  /// Iterator must actually correspond to a data operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getDataOperandNo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 196,
   FQN="llvm::CallSiteBase::getDataOperandNo", NM="_ZNK4llvm12CallSiteBase16getDataOperandNoENS_5Value18user_iterator_implIKNS_4UserEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase16getDataOperandNoENS_5Value18user_iterator_implIKNS_4UserEEE")
  //</editor-fold>
  public /*uint*/int getDataOperandNo(Value.user_iterator_impl</*const*/ User> UI) /*const*/ {
    return getDataOperandNo($AddrOf(UI.getUsePtr()));
  }


  /// Given a use for a data operand, get the data operand number that
  /// corresponds to it.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getDataOperandNo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 202,
   FQN="llvm::CallSiteBase::getDataOperandNo", NM="_ZNK4llvm12CallSiteBase16getDataOperandNoEPKNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase16getDataOperandNoEPKNS_3UseE")
  //</editor-fold>
  public /*uint*/int getDataOperandNo(/*const*/type$ptr<Use /*P*/> U) /*const*/ {
    assert Native.$bool(getInstruction()) : "Not a call or invoke instruction!";
    assert Native.$bool(isDataOperand(U)) : "Data operand # out of range!";
    return /*U.$sub(data_operands_begin())*/std.distance(data_operands_begin(), U);
  }


  /// Type of iterator to use when looping over data operands at this call site
  /// (see below).
  // JAVA: typedef IterTy data_operand_iterator
//  public final class data_operand_iterator extends IterTy{ };

  /// data_operands_begin/data_operands_end - Return iterators iterating over
  /// the call / invoke argument list and bundle operands.  For invokes, this is
  /// the set of instruction operands except the invoke target and the two
  /// successor blocks; and for calls this is the set of instruction operands
  /// except the call target.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::data_operands_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 218,
   FQN="llvm::CallSiteBase::data_operands_begin", NM="_ZNK4llvm12CallSiteBase19data_operands_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase19data_operands_beginEv")
  //</editor-fold>
  public IterTy data_operands_begin() /*const*/ {
    assert Native.$bool(getInstruction()) : "Not a call or invoke instruction!";
    // JAVA IterTy is in fact always type$ptr<Use>, so cast is ok
    return (IterTy)(/*Deref*/this).$arrow().op_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::data_operands_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 222,
   FQN="llvm::CallSiteBase::data_operands_end", NM="_ZNK4llvm12CallSiteBase17data_operands_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase17data_operands_endEv")
  //</editor-fold>
  public IterTy data_operands_end() /*const*/ {
    assert Native.$bool(getInstruction()) : "Not a call or invoke instruction!";
    // JAVA IterTy is in fact always type$ptr<Use>, so cast is ok
    return (IterTy)(/*Deref*/this).$arrow().op_end().$sub(isCall() ? 1 : 3);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::data_ops">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 226,
   FQN="llvm::CallSiteBase::data_ops", NM="_ZNK4llvm12CallSiteBase8data_opsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase8data_opsEv")
  //</editor-fold>
  public iterator_range<UseTy> data_ops() /*const*/ {
    return make_range(data_operands_begin(), data_operands_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::data_operands_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 229,
   FQN="llvm::CallSiteBase::data_operands_empty", NM="_ZNK4llvm12CallSiteBase19data_operands_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase19data_operands_emptyEv")
  //</editor-fold>
  public boolean data_operands_empty() /*const*/ {
    return Native.$eq(data_operands_end(), data_operands_begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::data_operands_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 232,
   FQN="llvm::CallSiteBase::data_operands_size", NM="_ZNK4llvm12CallSiteBase18data_operands_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase18data_operands_sizeEv")
  //</editor-fold>
  public /*uint*/int data_operands_size() /*const*/ {
    return std.distance(data_operands_begin(), data_operands_end());
  }


  /// getType - Return the type of the instruction that generated this call site
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 238,
   FQN="llvm::CallSiteBase::getType", NM="_ZNK4llvm12CallSiteBase7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase7getTypeEv")
  //</editor-fold>
  public Type /*P*/ getType() /*const*/ {
    return (/*Deref*/this).getType();
  }


  /// getCaller - Return the caller function for this call site
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getCaller">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 242,
   FQN="llvm::CallSiteBase::getCaller", NM="_ZNK4llvm12CallSiteBase9getCallerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase9getCallerEv")
  //</editor-fold>
  public FunTy /*P*/ getCaller() /*const*/ {
    return (FunTy)(/*Deref*/this).getParent().getParent();
  }


  /// \brief Tests if this call site must be tail call optimized.  Only a
  /// CallInst can be tail call optimized.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isMustTailCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 246,
   FQN="llvm::CallSiteBase::isMustTailCall", NM="_ZNK4llvm12CallSiteBase14isMustTailCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase14isMustTailCallEv")
  //</editor-fold>
  public boolean isMustTailCall() /*const*/ {
    return Native.$bool(isCall()) && Native.$bool(cast_CallInst(getInstruction()).isMustTailCall());
  }


  /// \brief Tests if this call site is marked as a tail call.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isTailCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 251,
   FQN="llvm::CallSiteBase::isTailCall", NM="_ZNK4llvm12CallSiteBase10isTailCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase10isTailCallEv")
  //</editor-fold>
  public boolean isTailCall() /*const*/ {
    return Native.$bool(isCall()) && Native.$bool(cast_CallInst(getInstruction()).isTailCall());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getNumArgOperands">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 268,
   FQN="llvm::CallSiteBase::getNumArgOperands", NM="_ZNK4llvm12CallSiteBase17getNumArgOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase17getNumArgOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumArgOperands() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getNumArgOperands() : cast_InvokeInst(II).getNumArgOperands();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getArgOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 272,
   FQN="llvm::CallSiteBase::getArgOperand", NM="_ZNK4llvm12CallSiteBase13getArgOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase13getArgOperandEj")
  //</editor-fold>
  public ValTy /*P*/ getArgOperand(/*uint*/int i) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return (ValTy) (isCall() ? cast_CallInst(II).getArgOperand(i) : cast_InvokeInst(II).getArgOperand(i));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getReturnedArgOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 276,
   FQN="llvm::CallSiteBase::getReturnedArgOperand", NM="_ZNK4llvm12CallSiteBase21getReturnedArgOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase21getReturnedArgOperandEv")
  //</editor-fold>
  public ValTy /*P*/ getReturnedArgOperand() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return (ValTy) (isCall() ? cast_CallInst(II).getReturnedArgOperand() : cast_InvokeInst(II).getReturnedArgOperand());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isInlineAsm">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 280,
   FQN="llvm::CallSiteBase::isInlineAsm", NM="_ZNK4llvm12CallSiteBase11isInlineAsmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase11isInlineAsmEv")
  //</editor-fold>
  public boolean isInlineAsm() /*const*/ {
    if (isCall()) {
      return cast_CallInst(getInstruction()).isInlineAsm();
    }
    return false;
  }


  /// getCallingConv/setCallingConv - get or set the calling convention of the
  /// call.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getCallingConv">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 288,
   FQN="llvm::CallSiteBase::getCallingConv", NM="_ZNK4llvm12CallSiteBase14getCallingConvEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase14getCallingConvEv")
  //</editor-fold>
  public /*uint*/int getCallingConv() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getCallingConv() : cast_InvokeInst(II).getCallingConv();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setCallingConv">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 291,
   FQN="llvm::CallSiteBase::setCallingConv", NM="_ZN4llvm12CallSiteBase14setCallingConvEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase14setCallingConvEj")
  //</editor-fold>
  public void setCallingConv(/*uint*/int CC) {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).setCallingConv(CC);
    } else {
      cast_InvokeInst(II).setCallingConv(CC);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getFunctionType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 295,
   FQN="llvm::CallSiteBase::getFunctionType", NM="_ZNK4llvm12CallSiteBase15getFunctionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase15getFunctionTypeEv")
  //</editor-fold>
  public FunctionType /*P*/ getFunctionType() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getFunctionType() : cast_InvokeInst(II).getFunctionType();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::mutateFunctionType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 299,
   FQN="llvm::CallSiteBase::mutateFunctionType", NM="_ZNK4llvm12CallSiteBase18mutateFunctionTypeEPNS_12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase18mutateFunctionTypeEPNS_12FunctionTypeE")
  //</editor-fold>
  public void mutateFunctionType(FunctionType /*P*/ Ty) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).mutateFunctionType(Ty);
    } else {
      cast_InvokeInst(II).mutateFunctionType(Ty);
    }
  }


  /// getAttributes/setAttributes - get or set the parameter attributes of
  /// the call.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getAttributes">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 305,
   FQN="llvm::CallSiteBase::getAttributes", NM="_ZNK4llvm12CallSiteBase13getAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase13getAttributesEv")
  //</editor-fold>
  public /*const*/ AttributeSet /*&*/ getAttributes() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getAttributes() : cast_InvokeInst(II).getAttributes();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setAttributes">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 308,
   FQN="llvm::CallSiteBase::setAttributes", NM="_ZN4llvm12CallSiteBase13setAttributesERKNS_12AttributeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase13setAttributesERKNS_12AttributeSetE")
  //</editor-fold>
  public void setAttributes(final /*const*/ AttributeSet /*&*/ PAL) {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).setAttributes(PAL);
    } else {
      cast_InvokeInst(II).setAttributes(PAL);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::addAttribute">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 312,
   FQN="llvm::CallSiteBase::addAttribute", NM="_ZN4llvm12CallSiteBase12addAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase12addAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public void addAttribute(/*uint*/int i, Attribute.AttrKind Kind) {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).addAttribute(i, Kind);
    } else {
      cast_InvokeInst(II).addAttribute(i, Kind);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::addAttribute">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 316,
   FQN="llvm::CallSiteBase::addAttribute", NM="_ZN4llvm12CallSiteBase12addAttributeEjNS_9StringRefES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase12addAttributeEjNS_9StringRefES1_")
  //</editor-fold>
  public void addAttribute(/*uint*/int i, StringRef Kind, StringRef Value) {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).addAttribute(i, Kind, Value);
    } else {
      cast_InvokeInst(II).addAttribute(i, Kind, Value);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::addAttribute">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 320,
   FQN="llvm::CallSiteBase::addAttribute", NM="_ZN4llvm12CallSiteBase12addAttributeEjNS_9AttributeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase12addAttributeEjNS_9AttributeE")
  //</editor-fold>
  public void addAttribute(/*uint*/int i, Attribute Attr) {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).addAttribute(i, Attr);
    } else {
      cast_InvokeInst(II).addAttribute(i, Attr);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::removeAttribute">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 324,
   FQN="llvm::CallSiteBase::removeAttribute", NM="_ZN4llvm12CallSiteBase15removeAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase15removeAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public void removeAttribute(/*uint*/int i, Attribute.AttrKind Kind) {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).removeAttribute(i, Kind);
    } else {
      cast_InvokeInst(II).removeAttribute(i, Kind);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::removeAttribute">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 328,
   FQN="llvm::CallSiteBase::removeAttribute", NM="_ZN4llvm12CallSiteBase15removeAttributeEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase15removeAttributeEjNS_9StringRefE")
  //</editor-fold>
  public void removeAttribute(/*uint*/int i, StringRef Kind) {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).removeAttribute(i, Kind);
    } else {
      cast_InvokeInst(II).removeAttribute(i, Kind);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::removeAttribute">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 332,
   FQN="llvm::CallSiteBase::removeAttribute", NM="_ZN4llvm12CallSiteBase15removeAttributeEjNS_9AttributeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase15removeAttributeEjNS_9AttributeE")
  //</editor-fold>
  public void removeAttribute(/*uint*/int i, Attribute Attr) {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).removeAttribute(i, Attr);
    } else {
      cast_InvokeInst(II).removeAttribute(i, Attr);
    }
  }


  /// \brief Return true if this function has the given attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::hasFnAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 337,
   FQN="llvm::CallSiteBase::hasFnAttr", NM="_ZNK4llvm12CallSiteBase9hasFnAttrENS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase9hasFnAttrENS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean hasFnAttr(Attribute.AttrKind Kind) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).hasFnAttr(Kind) : cast_InvokeInst(II).hasFnAttr(Kind);
  }


  /// \brief Return true if this function has the given attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::hasFnAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 342,
   FQN="llvm::CallSiteBase::hasFnAttr", NM="_ZNK4llvm12CallSiteBase9hasFnAttrENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase9hasFnAttrENS_9StringRefE")
  //</editor-fold>
  public boolean hasFnAttr(StringRef Kind) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).hasFnAttr(Kind) : cast_InvokeInst(II).hasFnAttr(Kind);
  }


  /// \brief Return true if the call or the callee has the given attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::paramHasAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 347,
   FQN="llvm::CallSiteBase::paramHasAttr", NM="_ZNK4llvm12CallSiteBase12paramHasAttrEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase12paramHasAttrEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean paramHasAttr(/*uint*/int i, Attribute.AttrKind Kind) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).paramHasAttr(i, Kind) : cast_InvokeInst(II).paramHasAttr(i, Kind);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getAttribute">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 351,
   FQN="llvm::CallSiteBase::getAttribute", NM="_ZNK4llvm12CallSiteBase12getAttributeEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase12getAttributeEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public Attribute getAttribute(/*uint*/int i, Attribute.AttrKind Kind) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getAttribute(i, Kind) : cast_InvokeInst(II).getAttribute(i, Kind);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getAttribute">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 355,
   FQN="llvm::CallSiteBase::getAttribute", NM="_ZNK4llvm12CallSiteBase12getAttributeEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase12getAttributeEjNS_9StringRefE")
  //</editor-fold>
  public Attribute getAttribute(/*uint*/int i, StringRef Kind) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getAttribute(i, Kind) : cast_InvokeInst(II).getAttribute(i, Kind);
  }


  /// \brief Return true if the data operand at index \p i directly or
  /// indirectly has the attribute \p A.
  ///
  /// Normal call or invoke arguments have per operand attributes, as specified
  /// in the attribute set attached to this instruction, while operand bundle
  /// operands may have some attributes implied by the type of its containing
  /// operand bundle.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::dataOperandHasImpliedAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 366,
   FQN="llvm::CallSiteBase::dataOperandHasImpliedAttr", NM="_ZNK4llvm12CallSiteBase25dataOperandHasImpliedAttrEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase25dataOperandHasImpliedAttrEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean dataOperandHasImpliedAttr(/*uint*/int i, Attribute.AttrKind Kind) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).dataOperandHasImpliedAttr(i, Kind) : cast_InvokeInst(II).dataOperandHasImpliedAttr(i, Kind);
  }


  /// @brief Extract the alignment for a call or parameter (0=unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getParamAlignment">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 371,
   FQN="llvm::CallSiteBase::getParamAlignment", NM="_ZNK4llvm12CallSiteBase17getParamAlignmentEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase17getParamAlignmentEt")
  //</editor-fold>
  public /*uint16_t*/char getParamAlignment(/*uint16_t*/char i) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return (char) (isCall() ? cast_CallInst(II).getParamAlignment(i) : cast_InvokeInst(II).getParamAlignment(i));
  }


  /// @brief Extract the number of dereferenceable bytes for a call or
  /// parameter (0=unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getDereferenceableBytes">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 377,
   FQN="llvm::CallSiteBase::getDereferenceableBytes", NM="_ZNK4llvm12CallSiteBase23getDereferenceableBytesEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase23getDereferenceableBytesEt")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableBytes(/*uint16_t*/char i) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getDereferenceableBytes(i) : cast_InvokeInst(II).getDereferenceableBytes(i);
  }


  /// @brief Extract the number of dereferenceable_or_null bytes for a call or
  /// parameter (0=unknown).
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getDereferenceableOrNullBytes">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 383,
   FQN="llvm::CallSiteBase::getDereferenceableOrNullBytes", NM="_ZNK4llvm12CallSiteBase29getDereferenceableOrNullBytesEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase29getDereferenceableOrNullBytesEt")
  //</editor-fold>
  public long/*uint64_t*/ getDereferenceableOrNullBytes(/*uint16_t*/char i) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getDereferenceableOrNullBytes(i) : cast_InvokeInst(II).getDereferenceableOrNullBytes(i);
  }


  /// @brief Determine if the parameter or return value is marked with NoAlias
  /// attribute.
  /// @param n The parameter to check. 1 is the first parameter, 0 is the return
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::doesNotAlias">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 390,
   FQN="llvm::CallSiteBase::doesNotAlias", NM="_ZNK4llvm12CallSiteBase12doesNotAliasEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase12doesNotAliasEj")
  //</editor-fold>
  public boolean doesNotAlias(/*uint*/int n) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).doesNotAlias(n) : cast_InvokeInst(II).doesNotAlias(n);
  }


  /// \brief Return true if the call should not be treated as a call to a
  /// builtin.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isNoBuiltin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 396,
   FQN="llvm::CallSiteBase::isNoBuiltin", NM="_ZNK4llvm12CallSiteBase11isNoBuiltinEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase11isNoBuiltinEv")
  //</editor-fold>
  public boolean isNoBuiltin() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).isNoBuiltin() : cast_InvokeInst(II).isNoBuiltin();
  }


  /// @brief Return true if the call should not be inlined.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isNoInline">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 401,
   FQN="llvm::CallSiteBase::isNoInline", NM="_ZNK4llvm12CallSiteBase10isNoInlineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase10isNoInlineEv")
  //</editor-fold>
  public boolean isNoInline() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).isNoInline() : cast_InvokeInst(II).isNoInline();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setIsNoInline">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 404,
   FQN="llvm::CallSiteBase::setIsNoInline", NM="_ZN4llvm12CallSiteBase13setIsNoInlineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase13setIsNoInlineEb")
  //</editor-fold>
  public void setIsNoInline() {
    setIsNoInline(true);
  }
  public void setIsNoInline(boolean Value/*= true*/) {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).setIsNoInline(/*Value*/);
    } else {
      cast_InvokeInst(II).setIsNoInline(/*Value*/);
    }
  }


  /// @brief Determine if the call does not access memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::doesNotAccessMemory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 409,
   FQN="llvm::CallSiteBase::doesNotAccessMemory", NM="_ZNK4llvm12CallSiteBase19doesNotAccessMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase19doesNotAccessMemoryEv")
  //</editor-fold>
  public boolean doesNotAccessMemory() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).doesNotAccessMemory() : cast_InvokeInst(II).doesNotAccessMemory();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setDoesNotAccessMemory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 412,
   FQN="llvm::CallSiteBase::setDoesNotAccessMemory", NM="_ZN4llvm12CallSiteBase22setDoesNotAccessMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase22setDoesNotAccessMemoryEv")
  //</editor-fold>
  public void setDoesNotAccessMemory() {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).setDoesNotAccessMemory();
    } else {
      cast_InvokeInst(II).setDoesNotAccessMemory();
    }
  }


  /// @brief Determine if the call does not access or only reads memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::onlyReadsMemory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 417,
   FQN="llvm::CallSiteBase::onlyReadsMemory", NM="_ZNK4llvm12CallSiteBase15onlyReadsMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase15onlyReadsMemoryEv")
  //</editor-fold>
  public boolean onlyReadsMemory() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).onlyReadsMemory() : cast_InvokeInst(II).onlyReadsMemory();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setOnlyReadsMemory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 420,
   FQN="llvm::CallSiteBase::setOnlyReadsMemory", NM="_ZN4llvm12CallSiteBase18setOnlyReadsMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase18setOnlyReadsMemoryEv")
  //</editor-fold>
  public void setOnlyReadsMemory() {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).setOnlyReadsMemory();
    } else {
      cast_InvokeInst(II).setOnlyReadsMemory();
    }
  }


  /// @brief Determine if the call does not access or only writes memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::doesNotReadMemory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 425,
   FQN="llvm::CallSiteBase::doesNotReadMemory", NM="_ZNK4llvm12CallSiteBase17doesNotReadMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase17doesNotReadMemoryEv")
  //</editor-fold>
  public boolean doesNotReadMemory() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).doesNotReadMemory() : cast_InvokeInst(II).doesNotReadMemory();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setDoesNotReadMemory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 428,
   FQN="llvm::CallSiteBase::setDoesNotReadMemory", NM="_ZN4llvm12CallSiteBase20setDoesNotReadMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase20setDoesNotReadMemoryEv")
  //</editor-fold>
  public void setDoesNotReadMemory() {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).setDoesNotReadMemory();
    } else {
      cast_InvokeInst(II).setDoesNotReadMemory();
    }
  }


  /// @brief Determine if the call can access memmory only using pointers based
  /// on its arguments.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::onlyAccessesArgMemory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 434,
   FQN="llvm::CallSiteBase::onlyAccessesArgMemory", NM="_ZNK4llvm12CallSiteBase21onlyAccessesArgMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase21onlyAccessesArgMemoryEv")
  //</editor-fold>
  public boolean onlyAccessesArgMemory() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).onlyAccessesArgMemory() : cast_InvokeInst(II).onlyAccessesArgMemory();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setOnlyAccessesArgMemory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 437,
   FQN="llvm::CallSiteBase::setOnlyAccessesArgMemory", NM="_ZN4llvm12CallSiteBase24setOnlyAccessesArgMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase24setOnlyAccessesArgMemoryEv")
  //</editor-fold>
  public void setOnlyAccessesArgMemory() {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).setOnlyAccessesArgMemory();
    } else {
      cast_InvokeInst(II).setOnlyAccessesArgMemory();
    }
  }


  /// @brief Determine if the call cannot return.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::doesNotReturn">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 442,
   FQN="llvm::CallSiteBase::doesNotReturn", NM="_ZNK4llvm12CallSiteBase13doesNotReturnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase13doesNotReturnEv")
  //</editor-fold>
  public boolean doesNotReturn() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).doesNotReturn() : cast_InvokeInst(II).doesNotReturn();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setDoesNotReturn">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 445,
   FQN="llvm::CallSiteBase::setDoesNotReturn", NM="_ZN4llvm12CallSiteBase16setDoesNotReturnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase16setDoesNotReturnEv")
  //</editor-fold>
  public void setDoesNotReturn() {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).setDoesNotReturn();
    } else {
      cast_InvokeInst(II).setDoesNotReturn();
    }
  }


  /// @brief Determine if the call cannot unwind.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::doesNotThrow">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 450,
   FQN="llvm::CallSiteBase::doesNotThrow", NM="_ZNK4llvm12CallSiteBase12doesNotThrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase12doesNotThrowEv")
  //</editor-fold>
  public boolean doesNotThrow() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).doesNotThrow() : cast_InvokeInst(II).doesNotThrow();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setDoesNotThrow">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 453,
   FQN="llvm::CallSiteBase::setDoesNotThrow", NM="_ZN4llvm12CallSiteBase15setDoesNotThrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase15setDoesNotThrowEv")
  //</editor-fold>
  public void setDoesNotThrow() {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).setDoesNotThrow();
    } else {
      cast_InvokeInst(II).setDoesNotThrow();
    }
  }


  /// @brief Determine if the call can be duplicated.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::cannotDuplicate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 458,
   FQN="llvm::CallSiteBase::cannotDuplicate", NM="_ZNK4llvm12CallSiteBase15cannotDuplicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase15cannotDuplicateEv")
  //</editor-fold>
  public boolean cannotDuplicate() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).cannotDuplicate() : cast_InvokeInst(II).cannotDuplicate();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setCannotDuplicate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 461,
   FQN="llvm::CallSiteBase::setCannotDuplicate", NM="_ZN4llvm12CallSiteBase18setCannotDuplicateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase18setCannotDuplicateEv")
  //</editor-fold>
  public void setCannotDuplicate() {
    InstrTy /*P*/ II = getInstruction();
    if(isCall()) cast_CallInst(II).setCannotDuplicate(); else cast_InvokeInst(II).setCannotDuplicate();
    /*JAVA:return*/return;
  }


  /// @brief Determine if the call is convergent.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isConvergent">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 466,
   FQN="llvm::CallSiteBase::isConvergent", NM="_ZNK4llvm12CallSiteBase12isConvergentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase12isConvergentEv")
  //</editor-fold>
  public boolean isConvergent() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).isConvergent() : cast_InvokeInst(II).isConvergent();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setConvergent">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 469,
   FQN="llvm::CallSiteBase::setConvergent", NM="_ZN4llvm12CallSiteBase13setConvergentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase13setConvergentEv")
  //</editor-fold>
  public void setConvergent() {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).setConvergent();
    } else {
      cast_InvokeInst(II).setConvergent();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::setNotConvergent">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 472,
   FQN="llvm::CallSiteBase::setNotConvergent", NM="_ZN4llvm12CallSiteBase16setNotConvergentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm12CallSiteBase16setNotConvergentEv")
  //</editor-fold>
  public void setNotConvergent() {
    InstrTy /*P*/ II = getInstruction();
    if (isCall()) {
      cast_CallInst(II).setNotConvergent();
    } else {
      cast_InvokeInst(II).setNotConvergent();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getNumOperandBundles">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 476,
   FQN="llvm::CallSiteBase::getNumOperandBundles", NM="_ZNK4llvm12CallSiteBase20getNumOperandBundlesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase20getNumOperandBundlesEv")
  //</editor-fold>
  public /*uint*/int getNumOperandBundles() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getNumOperandBundles() : cast_InvokeInst(II).getNumOperandBundles();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::hasOperandBundles">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 480,
   FQN="llvm::CallSiteBase::hasOperandBundles", NM="_ZNK4llvm12CallSiteBase17hasOperandBundlesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase17hasOperandBundlesEv")
  //</editor-fold>
  public boolean hasOperandBundles() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).hasOperandBundles() : cast_InvokeInst(II).hasOperandBundles();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getBundleOperandsStartIndex">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 484,
   FQN="llvm::CallSiteBase::getBundleOperandsStartIndex", NM="_ZNK4llvm12CallSiteBase27getBundleOperandsStartIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase27getBundleOperandsStartIndexEv")
  //</editor-fold>
  public /*uint*/int getBundleOperandsStartIndex() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getBundleOperandsStartIndex() : cast_InvokeInst(II).getBundleOperandsStartIndex();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getBundleOperandsEndIndex">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 488,
   FQN="llvm::CallSiteBase::getBundleOperandsEndIndex", NM="_ZNK4llvm12CallSiteBase25getBundleOperandsEndIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase25getBundleOperandsEndIndexEv")
  //</editor-fold>
  public /*uint*/int getBundleOperandsEndIndex() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getBundleOperandsEndIndex() : cast_InvokeInst(II).getBundleOperandsEndIndex();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getNumTotalBundleOperands">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 492,
   FQN="llvm::CallSiteBase::getNumTotalBundleOperands", NM="_ZNK4llvm12CallSiteBase25getNumTotalBundleOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase25getNumTotalBundleOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumTotalBundleOperands() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getNumTotalBundleOperands() : cast_InvokeInst(II).getNumTotalBundleOperands();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getOperandBundleAt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 496,
   FQN="llvm::CallSiteBase::getOperandBundleAt", NM="_ZNK4llvm12CallSiteBase18getOperandBundleAtEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase18getOperandBundleAtEj")
  //</editor-fold>
  public OperandBundleUse getOperandBundleAt(/*uint*/int Index) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getOperandBundleAt(Index) : cast_InvokeInst(II).getOperandBundleAt(Index);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getOperandBundle">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 500,
   FQN="llvm::CallSiteBase::getOperandBundle", NM="_ZNK4llvm12CallSiteBase16getOperandBundleENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase16getOperandBundleENS_9StringRefE")
  //</editor-fold>
  public Optional<OperandBundleUse> getOperandBundle(StringRef Name) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getOperandBundle(Name) : cast_InvokeInst(II).getOperandBundle(Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getOperandBundle">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 504,
   FQN="llvm::CallSiteBase::getOperandBundle", NM="_ZNK4llvm12CallSiteBase16getOperandBundleEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase16getOperandBundleEj")
  //</editor-fold>
  public Optional<OperandBundleUse> getOperandBundle(/*uint32_t*/int ID) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).getOperandBundle(ID) : cast_InvokeInst(II).getOperandBundle(ID);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::countOperandBundlesOfType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 508,
   FQN="llvm::CallSiteBase::countOperandBundlesOfType", NM="_ZNK4llvm12CallSiteBase25countOperandBundlesOfTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase25countOperandBundlesOfTypeEj")
  //</editor-fold>
  public /*uint*/int countOperandBundlesOfType(/*uint32_t*/int ID) /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return isCall() ? cast_CallInst(II).countOperandBundlesOfType(ID) : cast_InvokeInst(II).countOperandBundlesOfType(ID);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::arg_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 512,
   FQN="llvm::CallSiteBase::arg_begin", NM="_ZNK4llvm12CallSiteBase9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase9arg_beginEv")
  //</editor-fold>
  public /*IterTy*/IterTy arg_begin() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return (IterTy) (isCall() ? cast_CallInst(II).arg_begin() : cast_InvokeInst(II).arg_begin());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::arg_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 516,
   FQN="llvm::CallSiteBase::arg_end", NM="_ZNK4llvm12CallSiteBase7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase7arg_endEv")
  //</editor-fold>
  public IterTy arg_end() /*const*/ {
    InstrTy /*P*/ II = getInstruction();
    return (IterTy) (isCall() ? cast_CallInst(II).arg_end() : cast_InvokeInst(II).arg_end());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getOperandBundlesAsDefs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 523,
   FQN="llvm::CallSiteBase::getOperandBundlesAsDefs", NM="_ZNK4llvm12CallSiteBase23getOperandBundlesAsDefsERNS_15SmallVectorImplINS_17OperandBundleDefTIPNS_5ValueEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase23getOperandBundlesAsDefsERNS_15SmallVectorImplINS_17OperandBundleDefTIPNS_5ValueEEEEE")
  //</editor-fold>
  public void getOperandBundlesAsDefs(final SmallVectorImpl<OperandBundleDefT<Value /*P*/ > > /*&*/ Defs) /*const*/ {
    /*const*/ Instruction /*P*/ II = getInstruction();
    // Since this is actually a getter that "looks like" a setter, don't use the
    // above macros to avoid confusion.
    if (isCall()) {
      cast_CallInst(II).getOperandBundlesAsDefs(Defs);
    } else {
      cast_InvokeInst(II).getOperandBundlesAsDefs(Defs);
    }
  }


  /// @brief Determine whether this data operand is not captured.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::doesNotCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 534,
   FQN="llvm::CallSiteBase::doesNotCapture", NM="_ZNK4llvm12CallSiteBase14doesNotCaptureEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase14doesNotCaptureEj")
  //</editor-fold>
  public boolean doesNotCapture(/*uint*/int OpNo) /*const*/ {
    return dataOperandHasImpliedAttr(OpNo + 1, Attribute.AttrKind.NoCapture);
  }


  /// @brief Determine whether this argument is passed by value.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isByValArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 539,
   FQN="llvm::CallSiteBase::isByValArgument", NM="_ZNK4llvm12CallSiteBase15isByValArgumentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase15isByValArgumentEj")
  //</editor-fold>
  public boolean isByValArgument(/*uint*/int ArgNo) /*const*/ {
    return paramHasAttr(ArgNo + 1, Attribute.AttrKind.ByVal);
  }


  /// @brief Determine whether this argument is passed in an alloca.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isInAllocaArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 544,
   FQN="llvm::CallSiteBase::isInAllocaArgument", NM="_ZNK4llvm12CallSiteBase18isInAllocaArgumentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase18isInAllocaArgumentEj")
  //</editor-fold>
  public boolean isInAllocaArgument(/*uint*/int ArgNo) /*const*/ {
    return paramHasAttr(ArgNo + 1, Attribute.AttrKind.InAlloca);
  }


  /// @brief Determine whether this argument is passed by value or in an alloca.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isByValOrInAllocaArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 549,
   FQN="llvm::CallSiteBase::isByValOrInAllocaArgument", NM="_ZNK4llvm12CallSiteBase25isByValOrInAllocaArgumentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase25isByValOrInAllocaArgumentEj")
  //</editor-fold>
  public boolean isByValOrInAllocaArgument(/*uint*/int ArgNo) /*const*/ {
    return Native.$bool(paramHasAttr(ArgNo + 1, Attribute.AttrKind.ByVal))
       || Native.$bool(paramHasAttr(ArgNo + 1, Attribute.AttrKind.InAlloca));
  }


  /// @brief Determine if there are is an inalloca argument.  Only the last
  /// argument can have the inalloca attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::hasInAllocaArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 556,
   FQN="llvm::CallSiteBase::hasInAllocaArgument", NM="_ZNK4llvm12CallSiteBase19hasInAllocaArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase19hasInAllocaArgumentEv")
  //</editor-fold>
  public boolean hasInAllocaArgument() /*const*/ {
    return paramHasAttr(arg_size(), Attribute.AttrKind.InAlloca);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::doesNotAccessMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 560,
   FQN="llvm::CallSiteBase::doesNotAccessMemory", NM="_ZNK4llvm12CallSiteBase19doesNotAccessMemoryEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase19doesNotAccessMemoryEj")
  //</editor-fold>
  public boolean doesNotAccessMemory(/*uint*/int OpNo) /*const*/ {
    return dataOperandHasImpliedAttr(OpNo + 1, Attribute.AttrKind.ReadNone);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::onlyReadsMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 564,
   FQN="llvm::CallSiteBase::onlyReadsMemory", NM="_ZNK4llvm12CallSiteBase15onlyReadsMemoryEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase15onlyReadsMemoryEj")
  //</editor-fold>
  public boolean onlyReadsMemory(/*uint*/int OpNo) /*const*/ {
    return Native.$bool(dataOperandHasImpliedAttr(OpNo + 1, Attribute.AttrKind.ReadOnly))
       || Native.$bool(dataOperandHasImpliedAttr(OpNo + 1, Attribute.AttrKind.ReadNone));
  }


  /// @brief Return true if the return value is known to be not null.
  /// This may be because it has the nonnull attribute, or because at least
  /// one byte is dereferenceable and the pointer is in addrspace(0).
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isReturnNonNull">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 572,
   FQN="llvm::CallSiteBase::isReturnNonNull", NM="_ZNK4llvm12CallSiteBase15isReturnNonNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase15isReturnNonNullEv")
  //</editor-fold>
  public boolean isReturnNonNull() /*const*/ {
    if (paramHasAttr(0, Attribute.AttrKind.NonNull)) {
      return true;
    } else if (Native.$bool(Native.$greater(getDereferenceableBytes((char)0), 0))
       && Native.$bool(Native.$eq(getType().getPointerAddressSpace(), 0))) {
      return true;
    }

    return false;
  }


  /// hasArgument - Returns true if this CallSite passes the given Value* as an
  /// argument to the called function.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::hasArgument">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 584,
   FQN="llvm::CallSiteBase::hasArgument", NM="_ZNK4llvm12CallSiteBase11hasArgumentEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase11hasArgumentEPKNS_5ValueE")
  //</editor-fold>
  public boolean hasArgument(/*const*/ Value /*P*/ Arg) /*const*/ {
    for (IterTy AI = this.arg_begin(), E = this.arg_end(); Native.$noteq(AI, E);
         AI.$preInc())  {
      if (Native.$eq(AI.$arrow().get(), Arg)) {
        return true;
      }
    }
    return false;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::getCallee">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 593,
   FQN="llvm::CallSiteBase::getCallee", NM="_ZNK4llvm12CallSiteBase9getCalleeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZNK4llvm12CallSiteBase9getCalleeEv")
  //</editor-fold>
  private IterTy getCallee() /*const*/ {
    if (isCall()) { // Skip Callee
      return (IterTy)cast_CallInst(getInstruction()).op_end().$sub(1);
    } else { // Skip BB, BB, Callee
      return (IterTy) cast_InvokeInst(getInstruction()).op_end().$sub(3);
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public CallSiteBase(CallSiteBase</*typename*/ FunTy/* = const Function*/, /*typename*/ BBTy/* = const BasicBlock*/, /*typename*/ ValTy/* = const Value*/, /*typename*/ UserTy/* = const User*/, /*typename*/ UseTy/* = const Use*/, /*typename*/ InstrTy/* = const Instruction*/, /*typename*/ CallTy/* = const CallInst*/, /*typename*/ InvokeTy/* = const InvokeInst*/, /*typename*/ IterTy/* = User::const_op_iterator*/> BB) {
    this.I = new PointerBoolPair<>(BB.I);
  }

  public CallSiteBase(JD$Move $prm, CallSiteBase</*typename*/ FunTy/* = const Function*/, /*typename*/ BBTy/* = const BasicBlock*/, /*typename*/ ValTy/* = const Value*/, /*typename*/ UserTy/* = const User*/, /*typename*/ UseTy/* = const Use*/, /*typename*/ InstrTy/* = const Instruction*/, /*typename*/ CallTy/* = const CallInst*/, /*typename*/ InvokeTy/* = const InvokeInst*/, /*typename*/ IterTy/* = User::const_op_iterator*/> BB) {
    this.I = BB.I;
    BB.I = null;
  }

  /// Determine whether this Use is the callee operand's Use.
  //<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isCallee">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 119,
   FQN="llvm::CallSiteBase::isCallee", NM="_ZNK4llvm12CallSiteBase8isCalleeEPKNS_3UseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK4llvm12CallSiteBase8isCalleeEPKNS_3UseE")
  //</editor-fold>
  public boolean isCallee(/*const*/Use /*P*/ U) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  CallSiteBase $assign(CallSiteBase $Prm0) {
    this.I = $Prm0.I.clone();
    return this;
  }

  CallSiteBase $assignMove(CallSiteBase $Prm0) {
    this.I = $Prm0.I;
    $Prm0.I = null;
    return this;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "I=" + I; // NOI18N
  }
}
