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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.pass.*;


/// Analogous to CallSiteBase, this provides most of the actual
/// functionality for Statepoint and ImmutableStatepoint.  It is
/// templatized to allow easily specializing of const and non-const
/// concrete subtypes.  This is structured analogous to CallSite
/// rather than the IntrinsicInst.h helpers since we need to support
/// invokable statepoints.
/*template <typename FunTy, typename InstructionTy, typename ValueTy, typename CallSiteTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 58,
 FQN="llvm::StatepointBase", NM="_ZN4llvm14StatepointBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm14StatepointBaseE")
//</editor-fold>
public class StatepointBase</*typename*/ FunTy, /*typename*/ InstructionTy extends Instruction, /*typename*/ ValueTy, /*typename*/ CallSiteTy extends CallSiteBase>  implements Native.Native$Bool {
  private CallSiteTy StatepointCS;
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 62,
   FQN="llvm::StatepointBase::operator new", NM="_ZN4llvm14StatepointBasenwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm14StatepointBasenwEjj")
  //</editor-fold>
  protected/*private*/ static </*typename*/ FunTy, /*typename*/ InstructionTy, /*typename*/ ValueTy, /*typename*/ CallSiteTy> Object/*void P*/ $new(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 63,
   FQN="llvm::StatepointBase::operator new", NM="_ZN4llvm14StatepointBasenwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm14StatepointBasenwEj")
  //</editor-fold>
  protected/*private*/ static </*typename*/ FunTy, /*typename*/ InstructionTy, /*typename*/ ValueTy, /*typename*/ CallSiteTy> Object/*void P*/ $new(/*size_t*/int s) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::StatepointBase<FunTy, InstructionTy, ValueTy, CallSiteTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 66,
   FQN="llvm::StatepointBase::StatepointBase<FunTy, InstructionTy, ValueTy, CallSiteTy>", NM="_ZN4llvm14StatepointBaseC1EPT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm14StatepointBaseC1EPT0_")
  //</editor-fold>
  protected /*explicit*/ StatepointBase(Class<CallSiteTy> cls, JD$T1$P _dparam, InstructionTy /*P*/ I) {
    if (IrLlvmGlobals.isStatepoint_Value$C(I)) {
      if (cls == ImmutableCallSite.class) {
        StatepointCS = (CallSiteTy) new ImmutableCallSite(I);
      } else if (cls == CallSite.class) {
        StatepointCS = (CallSiteTy) new CallSite(I);
      } else {
        throw new UnsupportedOperationException("Unknown class "+cls.getName());
      }
      assert Native.$bool(StatepointCS) : "isStatepoint implies CallSite";
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::StatepointBase<FunTy, InstructionTy, ValueTy, CallSiteTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 72,
   FQN="llvm::StatepointBase::StatepointBase<FunTy, InstructionTy, ValueTy, CallSiteTy>", NM="_ZN4llvm14StatepointBaseC1ET2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm14StatepointBaseC1ET2_")
  //</editor-fold>
  protected /*explicit*/ StatepointBase(JD$T3 _dparam, CallSiteTy CS) {
    if (IrLlvmGlobals.isStatepoint((ImmutableCallSite)CS)) {
      StatepointCS = CS;
    }
  }

/*public:*/
  // JAVA: typedef typename CallSiteTy::arg_iterator arg_iterator
//  public final class arg_iterator extends type$ptr<Use /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 80,
   FQN="llvm::StatepointBase::(anonymous)", NM="_ZN4llvm14StatepointBaseE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm14StatepointBaseE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.NativeIntEnum {///*<dependent type>*/voidEnum {
    IDPos(0),
    NumPatchBytesPos(1),
    CalledFunctionPos(2),
    NumCallArgsPos(3),
    FlagsPos(4),
    CallArgsBeginPos(5);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
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

    private final /*<dependent type>*/int value;
    private Unnamed_enum(int val) { this.value = (/*<dependent type>*/int)val;}
    @Override public final /*<dependent type>*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::operator bool">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 89,
   FQN="llvm::StatepointBase::operator bool", NM="_ZNK4llvm14StatepointBasecvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBasecvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    // We do not assign non-statepoint CallSites to StatepointCS.
    return StatepointCS.$bool();
  }

  
  /// Return the underlying CallSite.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 95,
   FQN="llvm::StatepointBase::getCallSite", NM="_ZNK4llvm14StatepointBase11getCallSiteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase11getCallSiteEv")
  //</editor-fold>
  public CallSiteTy getCallSite() /*const*/ {
    assert Native.$bool(/*Deref*/this) : "check validity first!";
    return StatepointCS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getFlags">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 100,
   FQN="llvm::StatepointBase::getFlags", NM="_ZNK4llvm14StatepointBase8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase8getFlagsEv")
  //</editor-fold>
  public long/*uint64_t*/ getFlags() /*const*/ {
    return cast_ConstantInt(getCallSite().getArgument(Unnamed_enum.FlagsPos.getValue())).getZExtValue();
  }

  
  /// Return the ID associated with this statepoint.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 106,
   FQN="llvm::StatepointBase::getID", NM="_ZNK4llvm14StatepointBase5getIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase5getIDEv")
  //</editor-fold>
  public long/*uint64_t*/ getID() /*const*/ {
    /*const*/ Value /*P*/ IDVal = getCallSite().getArgument(Unnamed_enum.IDPos.getValue());
    return cast_ConstantInt(IDVal).getZExtValue();
  }

  
  /// Return the number of patchable bytes associated with this statepoint.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getNumPatchBytes">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 112,
   FQN="llvm::StatepointBase::getNumPatchBytes", NM="_ZNK4llvm14StatepointBase16getNumPatchBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase16getNumPatchBytesEv")
  //</editor-fold>
  public /*uint32_t*/int getNumPatchBytes() /*const*/ {
    /*const*/ Value /*P*/ NumPatchBytesVal = getCallSite().getArgument(Unnamed_enum.NumPatchBytesPos.getValue());
    long/*uint64_t*/ NumPatchBytes = cast_ConstantInt(NumPatchBytesVal).getZExtValue();
    assert (isInt(NumPatchBytes, 32)) : "should fit in 32 bits!";
    return $ulong2uint(NumPatchBytes);
  }

  
  /// Return the value actually being called or invoked.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getCalledValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 121,
   FQN="llvm::StatepointBase::getCalledValue", NM="_ZNK4llvm14StatepointBase14getCalledValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase14getCalledValueEv")
  //</editor-fold>
  public ValueTy /*P*/ getCalledValue() /*const*/ {
    return (ValueTy)getCallSite().getArgument(Unnamed_enum.CalledFunctionPos.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getInstruction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 125,
   FQN="llvm::StatepointBase::getInstruction", NM="_ZNK4llvm14StatepointBase14getInstructionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase14getInstructionEv")
  //</editor-fold>
  public InstructionTy /*P*/ getInstruction() /*const*/ {
    return (InstructionTy)getCallSite().getInstruction();
  }

  
  /// Return the function being called if this is a direct call, otherwise
  /// return null (if it's an indirect call).
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getCalledFunction">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 131,
   FQN="llvm::StatepointBase::getCalledFunction", NM="_ZNK4llvm14StatepointBase17getCalledFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase17getCalledFunctionEv")
  //</editor-fold>
  public FunTy /*P*/ getCalledFunction() /*const*/ {
    return (FunTy)dyn_cast_Function((Value)getCalledValue());
  }

  
  /// Return the caller function for this statepoint.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getCaller">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 136,
   FQN="llvm::StatepointBase::getCaller", NM="_ZNK4llvm14StatepointBase9getCallerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase9getCallerEv")
  //</editor-fold>
  public FunTy /*P*/ getCaller() /*const*/ {
    return (FunTy)getCallSite().getCaller();
  }

  
  /// Determine if the statepoint cannot unwind.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::doesNotThrow">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 139,
   FQN="llvm::StatepointBase::doesNotThrow", NM="_ZNK4llvm14StatepointBase12doesNotThrowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase12doesNotThrowEv")
  //</editor-fold>
  public boolean doesNotThrow() /*const*/ {
    Function /*P*/ F = (Function) getCalledFunction();
    return Native.$bool(getCallSite().doesNotThrow()) || ((F != null) ? F.doesNotThrow() : false);
  }

  
  /// Return the type of the value returned by the call underlying the
  /// statepoint.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getActualReturnType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 146,
   FQN="llvm::StatepointBase::getActualReturnType", NM="_ZNK4llvm14StatepointBase19getActualReturnTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase19getActualReturnTypeEv")
  //</editor-fold>
  public Type /*P*/ getActualReturnType() /*const*/ {
    FunctionType /*P*/ FTy = cast_FunctionType(cast_PointerType(((Value)getCalledValue()).getType()).getElementType());
    return FTy.getReturnType();
  }

  
  /// Number of arguments to be passed to the actual callee.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getNumCallArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 153,
   FQN="llvm::StatepointBase::getNumCallArgs", NM="_ZNK4llvm14StatepointBase14getNumCallArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase14getNumCallArgsEv")
  //</editor-fold>
  public int getNumCallArgs() /*const*/ {
    /*const*/ Value /*P*/ NumCallArgsVal = getCallSite().getArgument(Unnamed_enum.NumCallArgsPos.getValue());
    return $ulong2int(cast_ConstantInt(NumCallArgsVal).getZExtValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::arg_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 158,
   FQN="llvm::StatepointBase::arg_size", NM="_ZNK4llvm14StatepointBase8arg_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase8arg_sizeEv")
  //</editor-fold>
  public /*size_t*/int arg_size() /*const*/ {
    return getNumCallArgs();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::arg_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 159,
   FQN="llvm::StatepointBase::arg_begin", NM="_ZNK4llvm14StatepointBase9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase9arg_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> arg_begin() /*const*/ {
    assert Native.$bool(Native.$lesseq(Unnamed_enum.CallArgsBeginPos.getValue(), (int)getCallSite().arg_size()));
    return (type$ptr<Use>) getCallSite().arg_begin().$add(Unnamed_enum.CallArgsBeginPos.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::arg_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 163,
   FQN="llvm::StatepointBase::arg_end", NM="_ZNK4llvm14StatepointBase7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase7arg_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> arg_end() /*const*/ {
    type$ptr<Use> I = arg_begin().$add(arg_size());
    assert Native.$bool(Native.$greatereq((getCallSite().arg_end().$sub(I)), 0));
    return I;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 169,
   FQN="llvm::StatepointBase::getArgument", NM="_ZN4llvm14StatepointBase11getArgumentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm14StatepointBase11getArgumentEj")
  //</editor-fold>
  public ValueTy /*P*/ getArgument(/*uint*/int Index) {
    assert Native.$bool(Native.$less(Index, arg_size())) : "out of bounds!";
    return (ValueTy)$Deref(arg_begin().$add(Index));
  }

  
  /// range adapter for call arguments
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::call_args">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 175,
   FQN="llvm::StatepointBase::call_args", NM="_ZNK4llvm14StatepointBase9call_argsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase9call_argsEv")
  //</editor-fold>
  public iterator_range<Use> call_args() /*const*/ {
    return make_range(arg_begin(), arg_end());
  }

  
  /// \brief Return true if the call or the callee has the given attribute.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::paramHasAttr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 180,
   FQN="llvm::StatepointBase::paramHasAttr", NM="_ZNK4llvm14StatepointBase12paramHasAttrEjNS_9Attribute8AttrKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase12paramHasAttrEjNS_9Attribute8AttrKindE")
  //</editor-fold>
  public boolean paramHasAttr(/*uint*/int i, Attribute.AttrKind A) /*const*/ {
    Function /*P*/ F = (Function) getCalledFunction();
    return Native.$bool(getCallSite().paramHasAttr(i + Unnamed_enum.CallArgsBeginPos.getValue(), A))
       || ((F != null) ? F.getAttributes().hasAttribute(i, A) : false);
  }

  
  /// Number of GC transition args.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getNumTotalGCTransitionArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 187,
   FQN="llvm::StatepointBase::getNumTotalGCTransitionArgs", NM="_ZNK4llvm14StatepointBase27getNumTotalGCTransitionArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase27getNumTotalGCTransitionArgsEv")
  //</editor-fold>
  public int getNumTotalGCTransitionArgs() /*const*/ {
    /*const*/ Value /*P*/ NumGCTransitionArgs = $Deref(arg_end()).get();
    return $ulong2int(cast_ConstantInt(NumGCTransitionArgs).getZExtValue());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::gc_transition_args_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 191,
   FQN="llvm::StatepointBase::gc_transition_args_begin", NM="_ZNK4llvm14StatepointBase24gc_transition_args_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase24gc_transition_args_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> gc_transition_args_begin() /*const*/ {
    type$ptr<Use /*P*/> I = arg_end().$add(1);
    assert Native.$bool(Native.$greatereq((getCallSite().arg_end().$sub(I)), 0));
    return I;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::gc_transition_args_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 196,
   FQN="llvm::StatepointBase::gc_transition_args_end", NM="_ZNK4llvm14StatepointBase22gc_transition_args_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase22gc_transition_args_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> gc_transition_args_end() /*const*/ {
    type$ptr<Use /*P*/> I = gc_transition_args_begin().$add(getNumTotalGCTransitionArgs());
    assert Native.$bool(Native.$greatereq((getCallSite().arg_end().$sub(I)), 0));
    return I;
  }

  
  /// range adapter for GC transition arguments
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::gc_transition_args">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 203,
   FQN="llvm::StatepointBase::gc_transition_args", NM="_ZNK4llvm14StatepointBase18gc_transition_argsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase18gc_transition_argsEv")
  //</editor-fold>
  public iterator_range<Use /*P*/> gc_transition_args() /*const*/ {
    return make_range(gc_transition_args_begin(), gc_transition_args_end());
  }

  
  /// Number of additional arguments excluding those intended
  /// for garbage collection.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getNumTotalVMSArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 209,
   FQN="llvm::StatepointBase::getNumTotalVMSArgs", NM="_ZNK4llvm14StatepointBase18getNumTotalVMSArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase18getNumTotalVMSArgsEv")
  //</editor-fold>
  public int getNumTotalVMSArgs() /*const*/ {
    /*const*/ Value /*P*/ NumVMSArgs = $Deref(gc_transition_args_end()).get();
    return $ulong2int(cast_ConstantInt(NumVMSArgs).getZExtValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::vm_state_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 214,
   FQN="llvm::StatepointBase::vm_state_begin", NM="_ZNK4llvm14StatepointBase14vm_state_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase14vm_state_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> vm_state_begin() /*const*/ {
    type$ptr<Use /*P*/> I = gc_transition_args_end().$add(1);
    assert Native.$bool(Native.$greatereq((getCallSite().arg_end().$sub(I)), 0));
    return I;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::vm_state_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 219,
   FQN="llvm::StatepointBase::vm_state_end", NM="_ZNK4llvm14StatepointBase12vm_state_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase12vm_state_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> vm_state_end() /*const*/ {
    type$ptr<Use /*P*/> I = vm_state_begin().$add(getNumTotalVMSArgs());
    assert Native.$bool(Native.$greatereq((getCallSite().arg_end().$sub(I)), 0));
    return I;
  }

  
  /// range adapter for vm state arguments
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::vm_state_args">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 226,
   FQN="llvm::StatepointBase::vm_state_args", NM="_ZNK4llvm14StatepointBase13vm_state_argsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase13vm_state_argsEv")
  //</editor-fold>
  public iterator_range<Use /*P*/> vm_state_args() /*const*/ {
    return make_range(vm_state_begin(), vm_state_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::gc_args_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 230,
   FQN="llvm::StatepointBase::gc_args_begin", NM="_ZNK4llvm14StatepointBase13gc_args_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase13gc_args_beginEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> gc_args_begin() /*const*/ {
    return vm_state_end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::gc_args_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 233,
   FQN="llvm::StatepointBase::gc_args_end", NM="_ZNK4llvm14StatepointBase11gc_args_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase11gc_args_endEv")
  //</editor-fold>
  public type$ptr<Use /*P*/> gc_args_end() /*const*/ {
    return (type$ptr<Use>) getCallSite().arg_end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::gcArgsStartIdx">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 237,
   FQN="llvm::StatepointBase::gcArgsStartIdx", NM="_ZNK4llvm14StatepointBase14gcArgsStartIdxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase14gcArgsStartIdxEv")
  //</editor-fold>
  public /*uint*/int gcArgsStartIdx() /*const*/ {
    return std.distance(gc_args_begin(), getInstruction().op_begin());
  }

  
  /// range adapter for gc arguments
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::gc_args">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 242,
   FQN="llvm::StatepointBase::gc_args", NM="_ZNK4llvm14StatepointBase7gc_argsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase7gc_argsEv")
  //</editor-fold>
  public iterator_range<Use /*P*/> gc_args() /*const*/ {
    return make_range(gc_args_begin(), gc_args_end());
  }

  
  /// Get list of all gc reloactes linked to this statepoint
  /// May contain several relocations for the same base/derived pair.
  /// For example this could happen due to relocations on unwinding
  /// path of invoke.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getRelocates">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 396,
   FQN="llvm::StatepointBase::getRelocates", NM="_ZNK4llvm14StatepointBase12getRelocatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase12getRelocatesEv")
  //</editor-fold>
  public std.vector</*const*/ GCRelocateInst /*P*/ > getRelocates() /*const*/ {
    std.vector</*const*/ GCRelocateInst /*P*/ > Result = null;
    try {
      
      Result/*J*/= new std.vector</*const*/ GCRelocateInst /*P*/ >((/*const*/ GCRelocateInst /*P*/ )null);
      
      CallSiteTy StatepointCS = getCallSite();
      
      // Search for relocated pointers.  Note that working backwards from the
      // gc_relocates ensures that we only get pairs which are actually relocated
      // and used after the statepoint.
      for (/*const*/ User /*P*/ U : getInstruction().users())  {
        {
          /*const*/ GCRelocateInst /*P*/ Relocate = dyn_cast_GCRelocateInst(U);
          if ((Relocate != null)) {
            Result.push_back_T$C$R(Relocate);
          }
        }
      }
      if (Native.$not(StatepointCS.isInvoke())) {
        return new std.vector</*const*/ GCRelocateInst /*P*/ >(JD$Move.INSTANCE, Result);
      }
      
      // We need to scan thorough exceptional relocations if it is invoke statepoint
      LandingPadInst /*P*/ LandingPad = cast_InvokeInst(getInstruction()).getLandingPadInst();
      
      // Search for gc relocates that are attached to this landingpad.
      for (/*const*/ User /*P*/ LandingPadUser : LandingPad.users()) {
        {
          /*const*/ GCRelocateInst /*P*/ Relocate = dyn_cast_GCRelocateInst(LandingPadUser);
          if ((Relocate != null)) {
            Result.push_back_T$C$R(Relocate);
          }
        }
      }
      return new std.vector</*const*/ GCRelocateInst /*P*/ >(JD$Move.INSTANCE, Result);
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }

  
  /// Get the experimental_gc_result call tied to this statepoint.  Can be
  /// nullptr if there isn't a gc_result tied to this statepoint.  Guaranteed to
  /// be a CallInst if non-null.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::getGCResult">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 255,
   FQN="llvm::StatepointBase::getGCResult", NM="_ZNK4llvm14StatepointBase11getGCResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZNK4llvm14StatepointBase11getGCResultEv")
  //</editor-fold>
  public /*const*/ GCResultInst /*P*/ getGCResult() /*const*/ {
    for (User /*P*/ U : getInstruction().users())  {
      {
        GCResultInst /*P*/ GRI = dyn_cast_GCResultInst(U);
        if (GRI != null) {
          return GRI;
        }
      }
    }
    return null;
  }

  /// Asserts if this statepoint is malformed.  Common cases for failure
  /// include incorrect length prefixes for variable length sections or
  /// illegal values for parameters.
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointBase::verify">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 266,
   FQN="llvm::StatepointBase::verify", NM="_ZN4llvm14StatepointBase6verifyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm14StatepointBase6verifyEv")
  //</editor-fold>
  public void verify() {
    assert Native.$bool(Native.$greatereq(getNumCallArgs(), 0)) : "number of arguments to actually callee can't be negative";
    
    // The internal asserts in the iterator accessors do the rest.
    /*J:(void)*/arg_begin();
    /*J:(void)*/arg_end();
    /*J:(void)*/gc_transition_args_begin();
    /*J:(void)*/gc_transition_args_end();
    /*J:(void)*/vm_state_begin();
    /*J:(void)*/vm_state_end();
    /*J:(void)*/gc_args_begin();
    /*J:(void)*/gc_args_end();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public StatepointBase(JD$Move _dparam, StatepointBase<FunTy, InstructionTy, ValueTy, CallSiteTy> other) {
    this.StatepointCS = other.StatepointCS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "StatepointCS=" + StatepointCS; // NOI18N
  }
}
