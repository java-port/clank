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

//<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 32,
 FQN="llvm::InlineAsm", NM="_ZN4llvm9InlineAsmE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsmE")
//</editor-fold>
public class InlineAsm extends /*public*/ Value implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::AsmDialect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 34,
   FQN="llvm::InlineAsm::AsmDialect", NM="_ZN4llvm9InlineAsm10AsmDialectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm10AsmDialectE")
  //</editor-fold>
  public enum AsmDialect implements Native.NativeUIntEnum {
    AD_ATT(0),
    AD_Intel(AD_ATT.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AsmDialect valueOf(int val) {
      AsmDialect out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AsmDialect[] VALUES;
      private static final AsmDialect[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AsmDialect kind : AsmDialect.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AsmDialect[min < 0 ? (1-min) : 0];
        VALUES = new AsmDialect[max >= 0 ? (1+max) : 0];
        for (AsmDialect kind : AsmDialect.values()) {
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
    private AsmDialect(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  /*friend  struct InlineAsmKeyType*/
  /*friend  class ConstantUniqueMap<InlineAsm>*/

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::InlineAsm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 43,
   FQN="llvm::InlineAsm::InlineAsm", NM="_ZN4llvm9InlineAsmC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsmC1ERKS0_")
  //</editor-fold>
  protected/*private*/ InlineAsm(final /*const*/ InlineAsm /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 44,
   FQN="llvm::InlineAsm::operator=", NM="_ZN4llvm9InlineAsmaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsmaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ InlineAsm /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}


  private std.string AsmString;

  private std.string Constraints;
  private FunctionType /*P*/ FTy;
  private boolean HasSideEffects;
  private boolean IsAlignStack;
  private AsmDialect Dialect;

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::InlineAsm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp", line = 36,
   FQN="llvm::InlineAsm::InlineAsm", NM="_ZN4llvm9InlineAsmC1EPNS_12FunctionTypeERKSsS4_bbNS0_10AsmDialectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsmC1EPNS_12FunctionTypeERKSsS4_bbNS0_10AsmDialectE")
  //</editor-fold>
  /*friend*/public/*private*/ InlineAsm(FunctionType /*P*/ FTy, final /*const*/std.string/*&*/ asmString,
      final /*const*/std.string/*&*/ constraints, boolean hasSideEffects,
      boolean isAlignStack, AsmDialect asmDialect) {
    // : Value(PointerType::getUnqual(FTy), Value::InlineAsmVal), AsmString(asmString), Constraints(constraints), FTy(FTy), HasSideEffects(hasSideEffects), IsAlignStack(isAlignStack), Dialect(asmDialect)
    //START JInit
    super(PointerType.getUnqual(FTy), Value.ValueTy.InlineAsmVal.getValue());
    this.AsmString = new std.string(asmString);
    this.Constraints = new std.string(constraints);
    this.FTy = FTy;
    this.HasSideEffects = hasSideEffects;
    this.IsAlignStack = isAlignStack;
    this.Dialect = asmDialect;
    //END JInit

    // Do various checks on the constraint string and type.
    assert (Verify(getFunctionType(), new StringRef(constraints))) : "Function type not legal for constraints!";
  }


  // Implement the first virtual method in this class in this file so the
  // InlineAsm vtable is emitted here.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::~InlineAsm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp", line = 24,
   FQN="llvm::InlineAsm::~InlineAsm", NM="_ZN4llvm9InlineAsmD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsmD0Ev")
  //</editor-fold>
  @Override public/*private*/ void $destroy()/* override*/ {
    //START JDestroy
    Constraints.$destroy();
    AsmString.$destroy();
    super.$destroy();
    //END JDestroy
  }


  /// When the ConstantUniqueMap merges two types and makes two InlineAsms
  /// identical, it destroys one of them with this method.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::destroyConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp", line = 49,
   FQN="llvm::InlineAsm::destroyConstant", NM="_ZN4llvm9InlineAsm15destroyConstantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm15destroyConstantEv")
  //</editor-fold>
  private void destroyConstant() {
    getType().getContext().pImpl.InlineAsms.remove(this);
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)this);
  }

/*public:*/
  /// InlineAsm::get - Return the specified uniqued inline asm string.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp", line = 27,
   FQN="llvm::InlineAsm::get", NM="_ZN4llvm9InlineAsm3getEPNS_12FunctionTypeENS_9StringRefES3_bbNS0_10AsmDialectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm3getEPNS_12FunctionTypeENS_9StringRefES3_bbNS0_10AsmDialectE")
  //</editor-fold>
  public static InlineAsm /*P*/ get(FunctionType /*P*/ FTy, StringRef AsmString,
     StringRef Constraints, boolean hasSideEffects) {
    return get(FTy, AsmString,
     Constraints, hasSideEffects,
     false, AsmDialect.AD_ATT);
  }
  public static InlineAsm /*P*/ get(FunctionType /*P*/ FTy, StringRef AsmString,
     StringRef Constraints, boolean hasSideEffects,
     boolean isAlignStack/*= false*/) {
    return get(FTy, AsmString,
     Constraints, hasSideEffects,
     isAlignStack, AsmDialect.AD_ATT);
  }
  public static InlineAsm /*P*/ get(FunctionType /*P*/ FTy, StringRef AsmString,
     StringRef Constraints, boolean hasSideEffects,
     boolean isAlignStack/*= false*/, AsmDialect asmDialect/*= AD_ATT*/) {
    InlineAsmKeyType Key/*J*/= new InlineAsmKeyType(new StringRef(AsmString), new StringRef(Constraints), FTy, hasSideEffects,
        isAlignStack, asmDialect);
    LLVMContextImpl /*P*/ pImpl = FTy.getContext().pImpl;
    return pImpl.InlineAsms.getOrCreate(PointerType.getUnqual(FTy), new InlineAsmKeyType(Key));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::hasSideEffects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 69,
   FQN="llvm::InlineAsm::hasSideEffects", NM="_ZNK4llvm9InlineAsm14hasSideEffectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm9InlineAsm14hasSideEffectsEv")
  //</editor-fold>
  public boolean hasSideEffects() /*const*/ {
    return HasSideEffects;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::isAlignStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 70,
   FQN="llvm::InlineAsm::isAlignStack", NM="_ZNK4llvm9InlineAsm12isAlignStackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm9InlineAsm12isAlignStackEv")
  //</editor-fold>
  public boolean isAlignStack() /*const*/ {
    return IsAlignStack;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::getDialect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 71,
   FQN="llvm::InlineAsm::getDialect", NM="_ZNK4llvm9InlineAsm10getDialectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm9InlineAsm10getDialectEv")
  //</editor-fold>
  public AsmDialect getDialect() /*const*/ {
    return Dialect;
  }


  /// getType - InlineAsm's are always pointers.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 75,
   FQN="llvm::InlineAsm::getType", NM="_ZNK4llvm9InlineAsm7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm9InlineAsm7getTypeEv")
  //</editor-fold>
  public PointerType /*P*/ getType() /*const*/ {
    return reinterpret_cast(PointerType /*P*/ .class, super.getType());
  }


  /// getFunctionType - InlineAsm's are always pointers to functions.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::getFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp", line = 54,
   FQN="llvm::InlineAsm::getFunctionType", NM="_ZNK4llvm9InlineAsm15getFunctionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm9InlineAsm15getFunctionTypeEv")
  //</editor-fold>
  public FunctionType /*P*/ getFunctionType() /*const*/ {
    return FTy;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::getAsmString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 83,
   FQN="llvm::InlineAsm::getAsmString", NM="_ZNK4llvm9InlineAsm12getAsmStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm9InlineAsm12getAsmStringEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getAsmString() /*const*/ {
    return AsmString;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::getConstraintString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 84,
   FQN="llvm::InlineAsm::getConstraintString", NM="_ZNK4llvm9InlineAsm19getConstraintStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm9InlineAsm19getConstraintStringEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getConstraintString() /*const*/ {
    return Constraints;
  }


  /// Verify - This static method can be used by the parser to check to see if
  /// the specified constraint string is legal for the type.  This returns true
  /// if legal, false if not.
  ///

  /// Verify - Verify that the specified constraint string is reasonable for the
  /// specified function type, and otherwise validate the constraint string.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::Verify">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp", line = 247,
   FQN="llvm::InlineAsm::Verify", NM="_ZN4llvm9InlineAsm6VerifyEPNS_12FunctionTypeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm6VerifyEPNS_12FunctionTypeENS_9StringRefE")
  //</editor-fold>
  public static boolean Verify(FunctionType /*P*/ Ty, StringRef ConstStr) {
    std.vector<ConstraintInfo> Constraints = null;
    try {
      if (Ty.isVarArg()) {
        return false;
      }

      Constraints = ParseConstraints(new StringRef(ConstStr));

      // Error parsing constraints.
      if (Constraints.empty() && !ConstStr.empty()) {
        return false;
      }

      /*uint*/int NumOutputs = 0;
      /*uint*/int NumInputs = 0;
      /*uint*/int NumClobbers = 0;
      /*uint*/int NumIndirect = 0;

      for (/*uint*/int i = 0, e = Constraints.size(); i != e; ++i) {
        switch (Constraints.$at(i).Type) {
         case isOutput:
          if ((NumInputs - NumIndirect) != 0 || NumClobbers != 0) {
            return false; // outputs before inputs and clobbers.
          }
          if (!Constraints.$at(i).isIndirect) {
            ++NumOutputs;
            break;
          }
          ++NumIndirect;
         case isInput:
          // FALLTHROUGH for Indirect Outputs.
          if ((NumClobbers != 0)) {
            return false; // inputs before clobbers.
          }
          ++NumInputs;
          break;
         case isClobber:
          ++NumClobbers;
          break;
        }
      }
      switch (NumOutputs) {
       case 0:
        if (!Ty.getReturnType().isVoidTy()) {
          return false;
        }
        break;
       case 1:
        if (Ty.getReturnType().isStructTy()) {
          return false;
        }
        break;
       default:
        StructType /*P*/ STy = dyn_cast_StructType(Ty.getReturnType());
        if (!(STy != null) || STy.getNumElements() != NumOutputs) {
          return false;
        }
        break;
      }
      if (Ty.getNumParams() != NumInputs) {
        return false;
      }
      return true;
    } finally {
      if (Constraints != null) { Constraints.$destroy(); }
    }
  }


  // Constraint String Parsing
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::ConstraintPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 93,
   FQN="llvm::InlineAsm::ConstraintPrefix", NM="_ZN4llvm9InlineAsm16ConstraintPrefixE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm16ConstraintPrefixE")
  //</editor-fold>
  public enum ConstraintPrefix implements Native.NativeUIntEnum {
    isInput(0), // 'x'
    isOutput(isInput.getValue() + 1), // '=x'
    isClobber(isOutput.getValue() + 1); // '~x'

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ConstraintPrefix valueOf(int val) {
      ConstraintPrefix out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ConstraintPrefix[] VALUES;
      private static final ConstraintPrefix[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ConstraintPrefix kind : ConstraintPrefix.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ConstraintPrefix[min < 0 ? (1-min) : 0];
        VALUES = new ConstraintPrefix[max >= 0 ? (1+max) : 0];
        for (ConstraintPrefix kind : ConstraintPrefix.values()) {
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
    private ConstraintPrefix(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };

  // JAVA: typedef std::vector<std::string> ConstraintCodeVector
//  public final class ConstraintCodeVector extends std.vectorString{ };

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::SubConstraintInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 101,
   FQN="llvm::InlineAsm::SubConstraintInfo", NM="_ZN4llvm9InlineAsm17SubConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm17SubConstraintInfoE")
  //</editor-fold>
  public static class/*struct*/ SubConstraintInfo implements Destructors.ClassWithDestructor {
    /// MatchingInput - If this is not -1, this is an output constraint where an
    /// input constraint is required to match it (e.g. "0").  The value is the
    /// constraint number that matches this one (for example, if this is
    /// constraint #0 and constraint #4 has the value "0", this will be 4).
    public /*schar*/byte MatchingInput;
    /// Code - The constraint code, either the register name (in braces) or the
    /// constraint letter/number.
    public std.vectorString Codes;
    /// Default constructor.
    //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::SubConstraintInfo::SubConstraintInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 111,
     FQN="llvm::InlineAsm::SubConstraintInfo::SubConstraintInfo", NM="_ZN4llvm9InlineAsm17SubConstraintInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm17SubConstraintInfoC1Ev")
    //</editor-fold>
    public SubConstraintInfo() {
      // : MatchingInput(-1), Codes()
      //START JInit
      this.MatchingInput = $int2schar(-1);
      this.Codes = new std.vectorString(std.string.EMPTY);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::SubConstraintInfo::SubConstraintInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 101,
     FQN="llvm::InlineAsm::SubConstraintInfo::SubConstraintInfo", NM="_ZN4llvm9InlineAsm17SubConstraintInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm17SubConstraintInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ SubConstraintInfo(JD$Move _dparam, final SubConstraintInfo /*&&*/$Prm0) {
      // : MatchingInput(static_cast<SubConstraintInfo &&>().MatchingInput), Codes(static_cast<SubConstraintInfo &&>().Codes)
      //START JInit
      this.MatchingInput = $Prm0.MatchingInput;
      this.Codes = new std.vectorString(JD$Move.INSTANCE, $Prm0.Codes);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::SubConstraintInfo::~SubConstraintInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 101,
     FQN="llvm::InlineAsm::SubConstraintInfo::~SubConstraintInfo", NM="_ZN4llvm9InlineAsm17SubConstraintInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm17SubConstraintInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Codes.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::SubConstraintInfo::SubConstraintInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 101,
     FQN="llvm::InlineAsm::SubConstraintInfo::SubConstraintInfo", NM="_ZN4llvm9InlineAsm17SubConstraintInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm17SubConstraintInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ SubConstraintInfo(final /*const*/ SubConstraintInfo /*&*/ $Prm0) {
      // : MatchingInput(.MatchingInput), Codes(.Codes)
      //START JInit
      this.MatchingInput = $Prm0.MatchingInput;
      this.Codes = new std.vectorString($Prm0.Codes);
      //END JInit
    }


    @Override public String toString() {
      return "" + "MatchingInput=" + MatchingInput // NOI18N
                + ", Codes=" + Codes; // NOI18N
    }
  };

  // JAVA: typedef std::vector<SubConstraintInfo> SubConstraintInfoVector
//  public final class SubConstraintInfoVector extends std.vector<SubConstraintInfo>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::ConstraintInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 118,
   FQN="llvm::InlineAsm::ConstraintInfo", NM="_ZN4llvm9InlineAsm14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm14ConstraintInfoE")
  //</editor-fold>
  public static class/*struct*/ ConstraintInfo implements NativeCloneable<ConstraintInfo>, Destructors.ClassWithDestructor {
    /// Type - The basic type of the constraint: input/output/clobber
    ///
    public ConstraintPrefix Type;

    /// isEarlyClobber - "&": output operand writes result before inputs are all
    /// read.  This is only ever set for an output operand.
    public boolean isEarlyClobber;

    /// MatchingInput - If this is not -1, this is an output constraint where an
    /// input constraint is required to match it (e.g. "0").  The value is the
    /// constraint number that matches this one (for example, if this is
    /// constraint #0 and constraint #4 has the value "0", this will be 4).
    public /*schar*/byte MatchingInput;

    /// hasMatchingInput - Return true if this is an output constraint that has
    /// a matching input constraint.
    //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::ConstraintInfo::hasMatchingInput">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 135,
     FQN="llvm::InlineAsm::ConstraintInfo::hasMatchingInput", NM="_ZNK4llvm9InlineAsm14ConstraintInfo16hasMatchingInputEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm9InlineAsm14ConstraintInfo16hasMatchingInputEv")
    //</editor-fold>
    public boolean hasMatchingInput() /*const*/ {
      return MatchingInput != -1;
    }


    /// isCommutative - This is set to true for a constraint that is commutative
    /// with the next operand.
    public boolean isCommutative;

    /// isIndirect - True if this operand is an indirect operand.  This means
    /// that the address of the source or destination is present in the call
    /// instruction, instead of it being returned or passed in explicitly.  This
    /// is represented with a '*' in the asm string.
    public boolean isIndirect;

    /// Code - The constraint code, either the register name (in braces) or the
    /// constraint letter/number.
    public std.vectorString Codes;

    /// isMultipleAlternative - '|': has multiple-alternative constraints.
    public boolean isMultipleAlternative;

    /// multipleAlternatives - If there are multiple alternative constraints,
    /// this array will contain them.  Otherwise it will be empty.
    public std.vector<SubConstraintInfo> multipleAlternatives;

    /// The currently selected alternative constraint index.
    public /*uint*/int currentAlternativeIndex;

    /// Default constructor.

    ///Default constructor.
    //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::ConstraintInfo::ConstraintInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp", line = 59,
     FQN="llvm::InlineAsm::ConstraintInfo::ConstraintInfo", NM="_ZN4llvm9InlineAsm14ConstraintInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm14ConstraintInfoC1Ev")
    //</editor-fold>
    public ConstraintInfo() {
      // : Type(isInput), isEarlyClobber(false), MatchingInput(-1), isCommutative(false), isIndirect(false), Codes(), isMultipleAlternative(false), multipleAlternatives(), currentAlternativeIndex(0)
      //START JInit
      this.Type = ConstraintPrefix.isInput;
      this.isEarlyClobber = false;
      this.MatchingInput = $int2schar(-1);
      this.isCommutative = false;
      this.isIndirect = false;
      this.Codes = new std.vectorString(std.string.EMPTY);
      this.isMultipleAlternative = false;
      this.multipleAlternatives = new std.vector<SubConstraintInfo>(new SubConstraintInfo());
      this.currentAlternativeIndex = 0;
      //END JInit
    }


    /// Parse - Analyze the specified string (e.g. "=*&{eax}") and fill in the
    /// fields in this structure.  If the constraint string is not understood,
    /// return true, otherwise return false.

    /// Parse - Analyze the specified string (e.g. "==&{eax}") and fill in the
    /// fields in this structure.  If the constraint string is not understood,
    /// return true, otherwise return false.
    //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::ConstraintInfo::Parse">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp", line = 69,
     FQN="llvm::InlineAsm::ConstraintInfo::Parse", NM="_ZN4llvm9InlineAsm14ConstraintInfo5ParseENS_9StringRefERSt6vectorIS1_SaIS1_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm14ConstraintInfo5ParseENS_9StringRefERSt6vectorIS1_SaIS1_EE")
    //</editor-fold>
    public boolean Parse(StringRef Str,
         final std.vector<ConstraintInfo> /*&*/ ConstraintsSoFar) {
      char$ptr I = $tryClone(Str.begin());
      char$ptr E = $tryClone(Str.end());
      /*uint*/int multipleAlternativeCount = Str.count($$PIPE) + 1;
      /*uint*/int multipleAlternativeIndex = 0;
      std.vectorString/*P*/ pCodes = $AddrOf(Codes);

      // Initialize
      isMultipleAlternative = $greater_uint(multipleAlternativeCount, 1);
      if (isMultipleAlternative) {
        multipleAlternatives.resize(multipleAlternativeCount);
        pCodes = $AddrOf(multipleAlternatives.$at(0).Codes);
      }
      Type = ConstraintPrefix.isInput;
      isEarlyClobber = false;
      MatchingInput = $int2schar(-1);
      isCommutative = false;
      isIndirect = false;
      currentAlternativeIndex = 0;

      // Parse prefixes.
      if (I.$star() == $$TILDE) {
        Type = ConstraintPrefix.isClobber;
        I.$preInc();

        // '{' must immediately follow '~'.
        if ($noteq_ptr(I, E) && I.$star() != $$LCURLY) {
          return true;
        }
      } else if (I.$star() == $$EQ) {
        I.$preInc();
        Type = ConstraintPrefix.isOutput;
      }
      if (I.$star() == $$STAR) {
        isIndirect = true;
        I.$preInc();
      }
      if ($eq_ptr(I, E)) {
        return true; // Just a prefix, like "==" or "~".
      }

      // Parse the modifiers.
      boolean DoneWithModifiers = false;
      while (!DoneWithModifiers) {
        switch (I.$star()) {
         default:
          DoneWithModifiers = true;
          break;
         case '&': // Early clobber.
          if (Type != ConstraintPrefix.isOutput // Cannot early clobber anything but output.
             || isEarlyClobber) { // Reject &&&&&&
            return true;
          }
          isEarlyClobber = true;
          break;
         case '%': // Commutative.
          if (Type == ConstraintPrefix.isClobber // Cannot commute clobbers.
             || isCommutative) { // Reject %%%%%
            return true;
          }
          isCommutative = true;
          break;
         case '#': // Comment.
         case '*': // Register preferencing.
          return true; // Not supported.
        }
        if (!DoneWithModifiers) {
          I.$preInc();
          if ($eq_ptr(I, E)) {
            return true; // Just prefixes and modifiers!
          }
        }
      }

      // Parse the various constraints.
      while ($noteq_ptr(I, E)) {
        if (I.$star() == $$LCURLY) { // Physical register reference.
          // Find the end of the register name.
          char$ptr ConstraintEnd = $tryClone(std.find(I.$add(1), E, $$RCURLY));
          if ($eq_ptr(ConstraintEnd, E)) {
            return true; // "{foo"
          }
          pCodes.push_back_T$RR(new StringRef(I, ConstraintEnd.$add(1).$sub(I)).$string());
          I = $tryClone(ConstraintEnd.$add(1));
        } else if ((isdigit($uchar2int(((/*static_cast*//*uchar*/byte)(I.$star())))) != 0)) { // Matching Constraint
          // Maximal munch numbers.
          char$ptr NumStart = $tryClone(I);
          while ($noteq_ptr(I, E) && (isdigit($uchar2int(((/*static_cast*//*uchar*/byte)(I.$star())))) != 0)) {
            I.$preInc();
          }
          pCodes.push_back_T$RR(new StringRef(NumStart, I.$sub(NumStart)).$string());
          /*uint*/int N = atoi(pCodes.back().c_str());
          // Check that this is a valid matching constraint!
          if ($greatereq_uint(N, ConstraintsSoFar.size()) || ConstraintsSoFar.$at(N).Type != ConstraintPrefix.isOutput
             || Type != ConstraintPrefix.isInput) {
            return true; // Invalid constraint number.
          }

          // If Operand N already has a matching input, reject this.  An output
          // can't be constrained to the same value as multiple inputs.
          if (isMultipleAlternative) {
            if ($greatereq_uint(multipleAlternativeIndex
              , ConstraintsSoFar.$at(N).multipleAlternatives.size())) {
              return true;
            }
            final InlineAsm.SubConstraintInfo /*&*/ scInfo = ConstraintsSoFar.$at(N).multipleAlternatives.$at(multipleAlternativeIndex);
            if (scInfo.MatchingInput != -1) {
              return true;
            }
            // Note that operand #n has a matching input.
            scInfo.MatchingInput = $uint2schar(ConstraintsSoFar.size());
          } else {
            if (ConstraintsSoFar.$at(N).hasMatchingInput()
               && (/*size_t*/int)$schar2uint(ConstraintsSoFar.$at(N).MatchingInput)
               != ConstraintsSoFar.size()) {
              return true;
            }
            // Note that operand #n has a matching input.
            ConstraintsSoFar.$at(N).MatchingInput = $uint2schar(ConstraintsSoFar.size());
          }
        } else if (I.$star() == $$PIPE) {
          multipleAlternativeIndex++;
          pCodes = $AddrOf(multipleAlternatives.$at(multipleAlternativeIndex).Codes);
          I.$preInc();
        } else if (I.$star() == $$CARET) {
          // Multi-letter constraint
          // FIXME: For now assuming these are 2-character constraints.
          pCodes.push_back_T$RR(new StringRef(I.$add(1), 2).$string());
          I.$inc(3);
        } else {
          // Single letter constraint.
          pCodes.push_back_T$RR(new StringRef(I, 1).$string());
          I.$preInc();
        }
      }

      return false;
    }


    /// selectAlternative - Point this constraint to the alternative constraint
    /// indicated by the index.

    /// selectAlternative - Point this constraint to the alternative constraint
    /// indicated by the index.
    //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::ConstraintInfo::selectAlternative">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp", line = 200,
     FQN="llvm::InlineAsm::ConstraintInfo::selectAlternative", NM="_ZN4llvm9InlineAsm14ConstraintInfo17selectAlternativeEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm14ConstraintInfo17selectAlternativeEj")
    //</editor-fold>
    public void selectAlternative(/*uint*/int index) {
      if ($less_uint(index, multipleAlternatives.size())) {
        currentAlternativeIndex = index;
        final InlineAsm.SubConstraintInfo /*&*/ scInfo = multipleAlternatives.$at(currentAlternativeIndex);
        MatchingInput = scInfo.MatchingInput;
        Codes.$assign(scInfo.Codes);
      }
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::ConstraintInfo::ConstraintInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 118,
     FQN="llvm::InlineAsm::ConstraintInfo::ConstraintInfo", NM="_ZN4llvm9InlineAsm14ConstraintInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm14ConstraintInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ ConstraintInfo(JD$Move _dparam, final ConstraintInfo /*&&*/$Prm0) {
      // : Type(static_cast<ConstraintInfo &&>().Type), isEarlyClobber(static_cast<ConstraintInfo &&>().isEarlyClobber), MatchingInput(static_cast<ConstraintInfo &&>().MatchingInput), isCommutative(static_cast<ConstraintInfo &&>().isCommutative), isIndirect(static_cast<ConstraintInfo &&>().isIndirect), Codes(static_cast<ConstraintInfo &&>().Codes), isMultipleAlternative(static_cast<ConstraintInfo &&>().isMultipleAlternative), multipleAlternatives(static_cast<ConstraintInfo &&>().multipleAlternatives), currentAlternativeIndex(static_cast<ConstraintInfo &&>().currentAlternativeIndex)
      //START JInit
      this.Type = $Prm0.Type;
      this.isEarlyClobber = $Prm0.isEarlyClobber;
      this.MatchingInput = $Prm0.MatchingInput;
      this.isCommutative = $Prm0.isCommutative;
      this.isIndirect = $Prm0.isIndirect;
      this.Codes = new std.vectorString(JD$Move.INSTANCE, $Prm0.Codes);
      this.isMultipleAlternative = $Prm0.isMultipleAlternative;
      this.multipleAlternatives = new std.vector<SubConstraintInfo>(JD$Move.INSTANCE, $Prm0.multipleAlternatives);
      this.currentAlternativeIndex = $Prm0.currentAlternativeIndex;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::ConstraintInfo::~ConstraintInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 118,
     FQN="llvm::InlineAsm::ConstraintInfo::~ConstraintInfo", NM="_ZN4llvm9InlineAsm14ConstraintInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm14ConstraintInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      multipleAlternatives.$destroy();
      Codes.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::ConstraintInfo::ConstraintInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 118,
     FQN="llvm::InlineAsm::ConstraintInfo::ConstraintInfo", NM="_ZN4llvm9InlineAsm14ConstraintInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm14ConstraintInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ConstraintInfo(final /*const*/ ConstraintInfo /*&*/ $Prm0) {
      // : Type(.Type), isEarlyClobber(.isEarlyClobber), MatchingInput(.MatchingInput), isCommutative(.isCommutative), isIndirect(.isIndirect), Codes(.Codes), isMultipleAlternative(.isMultipleAlternative), multipleAlternatives(.multipleAlternatives), currentAlternativeIndex(.currentAlternativeIndex)
      //START JInit
      this.Type = $Prm0.Type;
      this.isEarlyClobber = $Prm0.isEarlyClobber;
      this.MatchingInput = $Prm0.MatchingInput;
      this.isCommutative = $Prm0.isCommutative;
      this.isIndirect = $Prm0.isIndirect;
      this.Codes = new std.vectorString($Prm0.Codes);
      this.isMultipleAlternative = $Prm0.isMultipleAlternative;
      this.multipleAlternatives = new std.vector<SubConstraintInfo>($Prm0.multipleAlternatives);
      this.currentAlternativeIndex = $Prm0.currentAlternativeIndex;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public ConstraintInfo clone() { return new ConstraintInfo(this); }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "Type=" + Type // NOI18N
                + ", isEarlyClobber=" + isEarlyClobber // NOI18N
                + ", MatchingInput=" + MatchingInput // NOI18N
                + ", isCommutative=" + isCommutative // NOI18N
                + ", isIndirect=" + isIndirect // NOI18N
                + ", Codes=" + Codes // NOI18N
                + ", isMultipleAlternative=" + isMultipleAlternative // NOI18N
                + ", multipleAlternatives=" + multipleAlternatives // NOI18N
                + ", currentAlternativeIndex=" + currentAlternativeIndex; // NOI18N
    }
  };
  // JAVA: typedef std::vector<ConstraintInfo> ConstraintInfoVector
//  public final class ConstraintInfoVector extends std.vector<ConstraintInfo>{ };

  ;

  /// ParseConstraints - Split up the constraint string into the specific
  /// constraints and their prefixes.  If this returns an empty vector, and if
  /// the constraint string itself isn't empty, there was an error parsing.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::ParseConstraints">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp", line = 210,
   FQN="llvm::InlineAsm::ParseConstraints", NM="_ZN4llvm9InlineAsm16ParseConstraintsENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm16ParseConstraintsENS_9StringRefE")
  //</editor-fold>
  public static std.vector<ConstraintInfo> ParseConstraints(StringRef Constraints) {
    std.vector<ConstraintInfo> Result = null;
    try {
      Result/*J*/= new std.vector<ConstraintInfo>(new ConstraintInfo());

      // Scan the constraints string.
      for (char$ptr I = $tryClone(Constraints.begin()),
          /*P*/ E = $tryClone(Constraints.end()); $noteq_ptr(I, E);) {
        ConstraintInfo Info = null;
        try {
          Info/*J*/= new ConstraintInfo();

          // Find the end of this constraint.
          char$ptr ConstraintEnd = $tryClone(std.find(I, E, $$COMMA));
          if ($eq_ptr(ConstraintEnd, I) // Empty constraint like ",,"
             || Info.Parse(new StringRef(I, ConstraintEnd.$sub(I)), Result)) {
            Result.clear(); // Erroneous constraint?
            break;
          }

          Result.push_back_T$C$R(Info);

          // ConstraintEnd may be either the next comma or the end of the string.  In
          // the former case, we skip the comma.
          I = $tryClone(ConstraintEnd);
          if ($noteq_ptr(I, E)) {
            I.$preInc();
            if ($eq_ptr(I, E)) {
              Result.clear();
              break;
            } // don't allow "xyz,"
          }
        } finally {
          if (Info != null) { Info.$destroy(); }
        }
      }

      return new std.vector<ConstraintInfo>(JD$Move.INSTANCE, Result);
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }


  /// ParseConstraints - Parse the constraints of this inlineasm object,
  /// returning them the same way that ParseConstraints(str) does.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::ParseConstraints">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 181,
   FQN="llvm::InlineAsm::ParseConstraints", NM="_ZNK4llvm9InlineAsm16ParseConstraintsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm9InlineAsm16ParseConstraintsEv")
  //</editor-fold>
  public std.vector<ConstraintInfo> ParseConstraints() /*const*/ {
    return ParseConstraints(new StringRef(Constraints));
  }


  // Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 186,
   FQN="llvm::InlineAsm::classof", NM="_ZN4llvm9InlineAsm7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm7classofEPKNS_5ValueE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == Value.ValueTy.InlineAsmVal.getValue();
  }


  // These are helper methods for dealing with flags in the INLINEASM SDNode
  // in the backend.
  //
  // The encoding of the flag word is currently:
  //   Bits 2-0 - A Kind_* value indicating the kind of the operand.
  //   Bits 15-3 - The number of SDNode operands associated with this inline
  //               assembly operand.
  //   If bit 31 is set:
  //     Bit 30-16 - The operand number that this operand must match.
  //                 When bits 2-0 are Kind_Mem, the Constraint_* value must be
  //                 obtained from the flags for this operand number.
  //   Else if bits 2-0 are Kind_Mem:
  //     Bit 30-16 - A Constraint_* value indicating the original constraint
  //                 code.
  //   Else:
  //     Bit 30-16 - The register class ID to use for the operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 207,
   FQN="llvm::InlineAsm::(anonymous)", NM="_ZN4llvm9InlineAsmE_Unnamed_enum2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsmE_Unnamed_enum2")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS : uint32_t {*/
    // Fixed operands on an INLINEASM SDNode.
    public static final /*uint32_t*/int Op_InputChain = 0;
    public static final /*uint32_t*/int Op_AsmString = 1;
    public static final /*uint32_t*/int Op_MDNode = 2;
    public static final /*uint32_t*/int Op_ExtraInfo = 3; // HasSideEffects, IsAlignStack, AsmDialect.
    public static final /*uint32_t*/int Op_FirstOperand = 4;

    // Fixed operands on an INLINEASM MachineInstr.
    public static final /*uint32_t*/int MIOp_AsmString = 0;
    public static final /*uint32_t*/int MIOp_ExtraInfo = 1; // HasSideEffects, IsAlignStack, AsmDialect.
    public static final /*uint32_t*/int MIOp_FirstOperand = 2;

    // Interpretation of the MIOp_ExtraInfo bit field.
    public static final /*uint32_t*/int Extra_HasSideEffects = 1;
    public static final /*uint32_t*/int Extra_IsAlignStack = 2;
    public static final /*uint32_t*/int Extra_AsmDialect = 4;
    public static final /*uint32_t*/int Extra_MayLoad = 8;
    public static final /*uint32_t*/int Extra_MayStore = 16;
    public static final /*uint32_t*/int Extra_IsConvergent = 32;

    // Inline asm operands map to multiple SDNode / MachineInstr operands.
    // The first operand is an immediate describing the asm operand, the low
    // bits is the kind:
    public static final /*uint32_t*/int Kind_RegUse = 1; // Input register, "r".
    public static final /*uint32_t*/int Kind_RegDef = 2; // Output register, "=r".
    public static final /*uint32_t*/int Kind_RegDefEarlyClobber = 3; // Early-clobber output register, "=&r".
    public static final /*uint32_t*/int Kind_Clobber = 4; // Clobbered register, "~r".
    public static final /*uint32_t*/int Kind_Imm = 5; // Immediate.
    public static final /*uint32_t*/int Kind_Mem = 6; // Memory operand, "m".

    // Memory constraint codes.
    // These could be tablegenerated but there's little need to do that since
    // there's plenty of space in the encoding to support the union of all
    // constraint codes for all targets.
    public static final /*uint32_t*/int Constraint_Unknown = 0;
    public static final /*uint32_t*/int Constraint_es = 0x1;
    public static final /*uint32_t*/int Constraint_i = 0x2;
    public static final /*uint32_t*/int Constraint_m = 0x3;
    public static final /*uint32_t*/int Constraint_o = 0x4;
    public static final /*uint32_t*/int Constraint_v = 0x5;
    public static final /*uint32_t*/int Constraint_Q = 0x6;
    public static final /*uint32_t*/int Constraint_R = 0x7;
    public static final /*uint32_t*/int Constraint_S = 0x8;
    public static final /*uint32_t*/int Constraint_T = 0x9;
    public static final /*uint32_t*/int Constraint_Um = 0xA;
    public static final /*uint32_t*/int Constraint_Un = 0xB;
    public static final /*uint32_t*/int Constraint_Uq = 0xC;
    public static final /*uint32_t*/int Constraint_Us = 0xD;
    public static final /*uint32_t*/int Constraint_Ut = 0xE;
    public static final /*uint32_t*/int Constraint_Uv = 0xF;
    public static final /*uint32_t*/int Constraint_Uy = 0x10;
    public static final /*uint32_t*/int Constraint_X = 0x11;
    public static final /*uint32_t*/int Constraint_Z = 0x12;
    public static final /*uint32_t*/int Constraint_ZC = 0x13;
    public static final /*uint32_t*/int Constraint_Zy = 0x14;
    public static final /*uint32_t*/int Constraints_Max = Constraint_Zy;
    public static final /*uint32_t*/int Constraints_ShiftAmount = 16;

    public static final /*uint32_t*/int Flag_MatchingOperand = 0x80000000/*U*/;
  /*}*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::getFlagWord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 269,
   FQN="llvm::InlineAsm::getFlagWord", NM="_ZN4llvm9InlineAsm11getFlagWordEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm11getFlagWordEjj")
  //</editor-fold>
  public static /*uint*/int getFlagWord(/*uint*/int Kind, /*uint*/int NumOps) {
    assert (((NumOps << 3) & ~0xFFFF) == 0) : "Too many inline asm operands!";
    assert ($greatereq_uint(Kind, Kind_RegUse) && $lesseq_uint(Kind, Kind_Mem)) : "Invalid Kind";
    return Kind | (NumOps << 3);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::isRegDefKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 275,
   FQN="llvm::InlineAsm::isRegDefKind", NM="_ZN4llvm9InlineAsm12isRegDefKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm12isRegDefKindEj")
  //</editor-fold>
  public static boolean isRegDefKind(/*uint*/int Flag) {
    return InlineAsm.getKind(Flag) == Kind_RegDef;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::isImmKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 276,
   FQN="llvm::InlineAsm::isImmKind", NM="_ZN4llvm9InlineAsm9isImmKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm9isImmKindEj")
  //</editor-fold>
  public static boolean isImmKind(/*uint*/int Flag) {
    return InlineAsm.getKind(Flag) == Kind_Imm;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::isMemKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 277,
   FQN="llvm::InlineAsm::isMemKind", NM="_ZN4llvm9InlineAsm9isMemKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm9isMemKindEj")
  //</editor-fold>
  public static boolean isMemKind(/*uint*/int Flag) {
    return InlineAsm.getKind(Flag) == Kind_Mem;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::isRegDefEarlyClobberKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 278,
   FQN="llvm::InlineAsm::isRegDefEarlyClobberKind", NM="_ZN4llvm9InlineAsm24isRegDefEarlyClobberKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm24isRegDefEarlyClobberKindEj")
  //</editor-fold>
  public static boolean isRegDefEarlyClobberKind(/*uint*/int Flag) {
    return InlineAsm.getKind(Flag) == Kind_RegDefEarlyClobber;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::isClobberKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 281,
   FQN="llvm::InlineAsm::isClobberKind", NM="_ZN4llvm9InlineAsm13isClobberKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm13isClobberKindEj")
  //</editor-fold>
  public static boolean isClobberKind(/*uint*/int Flag) {
    return InlineAsm.getKind(Flag) == Kind_Clobber;
  }


  /// getFlagWordForMatchingOp - Augment an existing flag word returned by
  /// getFlagWord with information indicating that this input operand is tied
  /// to a previous output operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::getFlagWordForMatchingOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 288,
   FQN="llvm::InlineAsm::getFlagWordForMatchingOp", NM="_ZN4llvm9InlineAsm24getFlagWordForMatchingOpEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm24getFlagWordForMatchingOpEjj")
  //</editor-fold>
  public static /*uint*/int getFlagWordForMatchingOp(/*uint*/int InputFlag,
                          /*uint*/int MatchedOperandNo) {
    assert ($lesseq_uint(MatchedOperandNo, 0x7FFF)) : "Too big matched operand";
    assert ((InputFlag & ~0xFFFF) == 0) : "High bits already contain data";
    return InputFlag | Flag_MatchingOperand | (MatchedOperandNo << 16);
  }


  /// getFlagWordForRegClass - Augment an existing flag word returned by
  /// getFlagWord with the required register class for the following register
  /// operands.
  /// A tied use operand cannot have a register class, use the register class
  /// from the def operand instead.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::getFlagWordForRegClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 300,
   FQN="llvm::InlineAsm::getFlagWordForRegClass", NM="_ZN4llvm9InlineAsm22getFlagWordForRegClassEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm22getFlagWordForRegClassEjj")
  //</editor-fold>
  public static /*uint*/int getFlagWordForRegClass(/*uint*/int InputFlag, /*uint*/int RC) {
    // Store RC + 1, reserve the value 0 to mean 'no register class'.
    ++RC;
    assert (!InlineAsm.isImmKind(InputFlag)) : "Immediates cannot have a register class";
    assert (!InlineAsm.isMemKind(InputFlag)) : "Memory operand cannot have a register class";
    assert ($lesseq_uint(RC, 0x7FFF)) : "Too large register class ID";
    assert ((InputFlag & ~0xFFFF) == 0) : "High bits already contain data";
    return InputFlag | (RC << 16);
  }


  /// Augment an existing flag word returned by getFlagWord with the constraint
  /// code for a memory constraint.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::getFlagWordForMem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 312,
   FQN="llvm::InlineAsm::getFlagWordForMem", NM="_ZN4llvm9InlineAsm17getFlagWordForMemEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm17getFlagWordForMemEjj")
  //</editor-fold>
  public static /*uint*/int getFlagWordForMem(/*uint*/int InputFlag, /*uint*/int Constraint) {
    assert (InlineAsm.isMemKind(InputFlag)) : "InputFlag is not a memory constraint!";
    assert ($lesseq_uint(Constraint, 0x7FFF)) : "Too large a memory constraint ID";
    assert ($lesseq_uint(Constraint, Constraints_Max)) : "Unknown constraint ID";
    assert ((InputFlag & ~0xFFFF) == 0) : "High bits already contain data";
    return InputFlag | (Constraint << Constraints_ShiftAmount);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::convertMemFlagWordToMatchingFlagWord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 320,
   FQN="llvm::InlineAsm::convertMemFlagWordToMatchingFlagWord", NM="_ZN4llvm9InlineAsm36convertMemFlagWordToMatchingFlagWordEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm36convertMemFlagWordToMatchingFlagWordEj")
  //</editor-fold>
  public static /*uint*/int convertMemFlagWordToMatchingFlagWord(/*uint*/int InputFlag) {
    assert (InlineAsm.isMemKind(InputFlag));
    return InputFlag & ~(0x7fff << Constraints_ShiftAmount);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 325,
   FQN="llvm::InlineAsm::getKind", NM="_ZN4llvm9InlineAsm7getKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm7getKindEj")
  //</editor-fold>
  public static /*uint*/int getKind(/*uint*/int Flags) {
    return Flags & 7;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::getMemoryConstraintID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 329,
   FQN="llvm::InlineAsm::getMemoryConstraintID", NM="_ZN4llvm9InlineAsm21getMemoryConstraintIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm21getMemoryConstraintIDEj")
  //</editor-fold>
  public static /*uint*/int getMemoryConstraintID(/*uint*/int Flag) {
    assert (InlineAsm.isMemKind(Flag));
    return (Flag >>> Constraints_ShiftAmount) & 0x7fff;
  }


  /// getNumOperandRegisters - Extract the number of registers field from the
  /// inline asm operand flag.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::getNumOperandRegisters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 336,
   FQN="llvm::InlineAsm::getNumOperandRegisters", NM="_ZN4llvm9InlineAsm22getNumOperandRegistersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm22getNumOperandRegistersEj")
  //</editor-fold>
  public static /*uint*/int getNumOperandRegisters(/*uint*/int Flag) {
    return (Flag & 0xffff) >>> 3;
  }


  /// isUseOperandTiedToDef - Return true if the flag of the inline asm
  /// operand indicates it is an use operand that's matched to a def operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::isUseOperandTiedToDef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 342,
   FQN="llvm::InlineAsm::isUseOperandTiedToDef", NM="_ZN4llvm9InlineAsm21isUseOperandTiedToDefEjRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm21isUseOperandTiedToDefEjRj")
  //</editor-fold>
  public static boolean isUseOperandTiedToDef(/*uint*/int Flag, final uint$ref/*uint &*/ Idx) {
    if ((Flag & Flag_MatchingOperand) == 0) {
      return false;
    }
    Idx.$set((Flag & ~Flag_MatchingOperand) >>> 16);
    return true;
  }


  /// hasRegClassConstraint - Returns true if the flag contains a register
  /// class constraint.  Sets RC to the register class ID.
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsm::hasRegClassConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/InlineAsm.h", line = 351,
   FQN="llvm::InlineAsm::hasRegClassConstraint", NM="_ZN4llvm9InlineAsm21hasRegClassConstraintEjRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm9InlineAsm21hasRegClassConstraintEjRj")
  //</editor-fold>
  public static boolean hasRegClassConstraint(/*uint*/int Flag, final uint$ref/*uint &*/ RC) {
    if (((Flag & Flag_MatchingOperand) != 0)) {
      return false;
    }
    /*uint*/int High = Flag >>> 16;
    // getFlagWordForRegClass() uses 0 to mean no register class, and otherwise
    // stores RC + 1.
    if (!(High != 0)) {
      return false;
    }
    RC.$set(High - 1);
    return true;
  }


  @Override public String toString() {
    return "" + "AsmString=" + AsmString // NOI18N
              + ", Constraints=" + Constraints // NOI18N
              + ", FTy=" + FTy // NOI18N
              + ", HasSideEffects=" + HasSideEffects // NOI18N
              + ", IsAlignStack=" + IsAlignStack // NOI18N
              + ", Dialect=" + Dialect // NOI18N
              + super.toString(); // NOI18N
  }
}
