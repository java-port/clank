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
package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.cl.*;
import org.llvm.pass.*;
import org.llvm.cl.aliases.optBool;


//<editor-fold defaultstate="collapsed" desc="static type VerifierStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.VerifierStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__Z20isValidMetadataArrayRKN4llvm7MDTupleE;Tpl__Z24isValidMetadataArrayImplRKN4llvm7MDTupleEb;Tpl__Z24isValidMetadataNullArrayRKN4llvm7MDTupleE;_ZL10getSuccPadPN4llvm14TerminatorInstE;_ZL11forEachUserPKN4llvm5ValueERNS_11SmallPtrSetIS2_Lj32EEENS_12function_refIFbS2_EEE;_ZL12getParentPadPN4llvm5ValueE;_ZL12isContiguousRKN4llvm13ConstantRangeES2_;_ZL13getSubprogramPN4llvm8MetadataE;_ZL15VerifyDebugInfo;_ZL15getVariableSizeRKN4llvm15DILocalVariableE;_ZL15isTypeCongruentPN4llvm4TypeES1_;_ZL25getParameterABIAttributesiN4llvm12AttributeSetE;_ZL28hasConflictingReferenceFlagsj;_ZL36InitializeVerifierLegacyPassPassFlag;_ZL36initializeVerifierLegacyPassPassOnceRN4llvm12PassRegistryE;_ZL6isTypePKN4llvm8MetadataE;_ZL7isScopePKN4llvm8MetadataE;_ZL8isDINodePKN4llvm8MetadataE; -static-type=VerifierStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class VerifierStatics {

//<editor-fold defaultstate="collapsed" desc="VerifyDebugInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 83,
 FQN="VerifyDebugInfo", NM="_ZL15VerifyDebugInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL15VerifyDebugInfo")
//</editor-fold>
public static optBool VerifyDebugInfo/*J*/= new optBool(/*false, */$("verify-debug-info"), ClGlobals.init$Bool(true));

// Helper to recursively iterate over indirect users. By
// returning false, the callback can ask to stop recursing
// further.
//<editor-fold defaultstate="collapsed" desc="forEachUser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 489,
 FQN="forEachUser", NM="_ZL11forEachUserPKN4llvm5ValueERNS_11SmallPtrSetIS2_Lj32EEENS_12function_refIFbS2_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL11forEachUserPKN4llvm5ValueERNS_11SmallPtrSetIS2_Lj32EEENS_12function_refIFbS2_EEE")
//</editor-fold>
public static void forEachUser(/*const*/ Value /*P*/ User, 
           final SmallPtrSet</*const*/ Value /*P*/ > /*&*/ Visited, 
           BoolPredicate<Value> Callback) {
  if (!Visited.insert(User).second) {
    return;
  }
  for (/*const*/ Value /*P*/ TheNextUser : User.materialized_users$Const())  {
    if (Callback.$call(TheNextUser)) {
      forEachUser(TheNextUser, Visited, /*FuncArg*/Callback);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="isType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 767,
 FQN="isType", NM="_ZL6isTypePKN4llvm8MetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL6isTypePKN4llvm8MetadataE")
//</editor-fold>
public static boolean isType(/*const*/ Metadata /*P*/ MD) {
  return !(MD != null) || isa_DIType(MD);
}

//<editor-fold defaultstate="collapsed" desc="isScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 768,
 FQN="isScope", NM="_ZL7isScopePKN4llvm8MetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL7isScopePKN4llvm8MetadataE")
//</editor-fold>
public static boolean isScope(/*const*/ Metadata /*P*/ MD) {
  return !(MD != null) || isa_DIScope(MD);
}

//<editor-fold defaultstate="collapsed" desc="isDINode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 769,
 FQN="isDINode", NM="_ZL8isDINodePKN4llvm8MetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL8isDINodePKN4llvm8MetadataE")
//</editor-fold>
public static boolean isDINode(/*const*/ Metadata /*P*/ MD) {
  return !(MD != null) || isa_DINode(MD);
}

/*template <class Ty> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isValidMetadataArrayImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 772,
 FQN="isValidMetadataArrayImpl", NM="Tpl__Z24isValidMetadataArrayImplRKN4llvm7MDTupleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__Z24isValidMetadataArrayImplRKN4llvm7MDTupleEb")
//</editor-fold>
public static </*class*/ Ty extends MDNode> boolean isValidMetadataArrayImpl(Class<Ty> cls, final /*const*/ MDTuple /*&*/ N, boolean AllowNull) {
  for (MDOperand /*P*/ OP : N.operands()) {
    Metadata /*P*/ MD = OP.$Metadata$P();
    if ((MD != null)) {
      if (Native.$not(isa(cls, MD))) {
        return false;
      }
    } else {
      if (!AllowNull) {
        return false;
      }
    }
  }
  return true;
}

/*template <class Ty> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isValidMetadataArray">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 786,
 FQN="isValidMetadataArray", NM="Tpl__Z20isValidMetadataArrayRKN4llvm7MDTupleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__Z20isValidMetadataArrayRKN4llvm7MDTupleE")
//</editor-fold>
public static </*class*/ Ty extends MDNode> boolean isValidMetadataArray(Class<Ty> cls, final /*const*/ MDTuple /*&*/ N) {
  return isValidMetadataArrayImpl(cls, N, /* AllowNull */ false);
}

/*template <class Ty> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isValidMetadataNullArray">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 791,
 FQN="isValidMetadataNullArray", NM="Tpl__Z24isValidMetadataNullArrayRKN4llvm7MDTupleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__Z24isValidMetadataNullArrayRKN4llvm7MDTupleE")
//</editor-fold>
public static </*class*/ Ty extends MDNode> boolean isValidMetadataNullArray(Class<Ty> cls, final /*const*/ MDTuple /*&*/ N) {
  return isValidMetadataArrayImpl(cls, N, /* AllowNull */ true);
}

//<editor-fold defaultstate="collapsed" desc="hasConflictingReferenceFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 852,
 FQN="hasConflictingReferenceFlags", NM="_ZL28hasConflictingReferenceFlagsj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL28hasConflictingReferenceFlagsj")
//</editor-fold>
public static boolean hasConflictingReferenceFlags(/*uint*/int Flags) {
  return ((Flags & DINode.DIFlags.FlagLValueReference) != 0)
     && ((Flags & DINode.DIFlags.FlagRValueReference) != 0);
}

//<editor-fold defaultstate="collapsed" desc="getSuccPad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 1821,
 FQN="getSuccPad", NM="_ZL10getSuccPadPN4llvm14TerminatorInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL10getSuccPadPN4llvm14TerminatorInstE")
//</editor-fold>
public static Instruction /*P*/ getSuccPad(TerminatorInst /*P*/ Terminator) {
  BasicBlock /*P*/ UnwindDest;
  {
    InvokeInst /*P*/ II = dyn_cast_InvokeInst(Terminator);
    if ((II != null)) {
      UnwindDest = II.getUnwindDest();
    } else {
      CatchSwitchInst /*P*/ CSI = dyn_cast_CatchSwitchInst(Terminator);
      if ((CSI != null)) {
        UnwindDest = CSI.getUnwindDest();
      } else {
        UnwindDest = cast_CleanupReturnInst(Terminator).getUnwindDest();
      }
    }
  }
  return UnwindDest.getFirstNonPHI();
}


/// Two types are "congruent" if they are identical, or if they are both pointer
/// types with different pointee types and the same address space.
//<editor-fold defaultstate="collapsed" desc="isTypeCongruent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2654,
 FQN="isTypeCongruent", NM="_ZL15isTypeCongruentPN4llvm4TypeES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL15isTypeCongruentPN4llvm4TypeES1_")
//</editor-fold>
public static boolean isTypeCongruent(Type /*P*/ L, Type /*P*/ R) {
  if (L == R) {
    return true;
  }
  PointerType /*P*/ PL = dyn_cast_PointerType(L);
  PointerType /*P*/ PR = dyn_cast_PointerType(R);
  if (!(PL != null) || !(PR != null)) {
    return false;
  }
  return PL.getAddressSpace() == PR.getAddressSpace();
}

//<editor-fold defaultstate="collapsed" desc="getParameterABIAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2664,
 FQN="getParameterABIAttributes", NM="_ZL25getParameterABIAttributesiN4llvm12AttributeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL25getParameterABIAttributesiN4llvm12AttributeSetE")
//</editor-fold>
public static AttrBuilder getParameterABIAttributes(int I, AttributeSet Attrs) {
  AttrBuilder Copy = null;
  try {
    final/*static*/ /*const*/ Attribute.AttrKind ABIAttrs[/*7*/] = getParameterABIAttributes$$.ABIAttrs;
    Copy/*J*/= new AttrBuilder();
    for (Attribute.AttrKind AK : ABIAttrs) {
      if (Attrs.hasAttribute(I + 1, AK)) {
        Copy.addAttribute(AK);
      }
    }
    if (Attrs.hasAttribute(I + 1, Attribute.AttrKind.Alignment)) {
      Copy.addAlignmentAttr(Attrs.getParamAlignment(I + 1));
    }
    return new AttrBuilder(JD$Move.INSTANCE, Copy);
  } finally {
    if (Copy != null) { Copy.$destroy(); }
  }
}
private static final class getParameterABIAttributes$$ {
  static final/*static*/ /*const*/ Attribute.AttrKind ABIAttrs[/*7*/] = new /*const*/ Attribute.AttrKind [/*7*/] {
    Attribute.AttrKind.StructRet, Attribute.AttrKind.ByVal, Attribute.AttrKind.InAlloca, 
    Attribute.AttrKind.InReg, Attribute.AttrKind.Returned, Attribute.AttrKind.SwiftSelf, 
    Attribute.AttrKind.SwiftError};
}

//<editor-fold defaultstate="collapsed" desc="isContiguous">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 2914,
 FQN="isContiguous", NM="_ZL12isContiguousRKN4llvm13ConstantRangeES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL12isContiguousRKN4llvm13ConstantRangeES2_")
//</editor-fold>
public static boolean isContiguous(final /*const*/ ConstantRange /*&*/ A, final /*const*/ ConstantRange /*&*/ B) {
  return A.getUpper().$eq(B.getLower()) || A.getLower().$eq(B.getUpper());
}

//<editor-fold defaultstate="collapsed" desc="getParentPad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 3170,
 FQN="getParentPad", NM="_ZL12getParentPadPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL12getParentPadPN4llvm5ValueE")
//</editor-fold>
public static Value /*P*/ getParentPad(Value /*P*/ EHPad) {
  {
    FuncletPadInst /*P*/ FPI = dyn_cast_FuncletPadInst(EHPad);
    if ((FPI != null)) {
      return FPI.getParentPad();
    }
  }
  
  return cast_CatchSwitchInst(EHPad).getParentPad();
}


/// \brief Carefully grab the subprogram from a local scope.
///
/// This carefully grabs the subprogram from a local scope, avoiding the
/// built-in assertions that would typically fire.
//<editor-fold defaultstate="collapsed" desc="getSubprogram">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4137,
 FQN="getSubprogram", NM="_ZL13getSubprogramPN4llvm8MetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL13getSubprogramPN4llvm8MetadataE")
//</editor-fold>
public static DISubprogram /*P*/ getSubprogram(Metadata /*P*/ LocalScope) {
  if (!(LocalScope != null)) {
    return null;
  }
  {
    
    DISubprogram /*P*/ SP = dyn_cast_DISubprogram(LocalScope);
    if ((SP != null)) {
      return SP;
    }
  }
  {
    
    DILexicalBlockBase /*P*/ LB = dyn_cast_DILexicalBlockBase(LocalScope);
    if ((LB != null)) {
      return getSubprogram(LB.getRawScope());
    }
  }
  
  // Just return null; broken scope chains are checked elsewhere.
  assert (!isa_DILocalScope(LocalScope)) : "Unknown type of local scope";
  return null;
}

//<editor-fold defaultstate="collapsed" desc="getVariableSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4190,
 FQN="getVariableSize", NM="_ZL15getVariableSizeRKN4llvm15DILocalVariableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL15getVariableSizeRKN4llvm15DILocalVariableE")
//</editor-fold>
public static long/*uint64_t*/ getVariableSize(final /*const*/ DILocalVariable /*&*/ V) {
  // Be careful of broken types (checked elsewhere).
  /*const*/ Metadata /*P*/ RawType = V.getRawType();
  while ((RawType != null)) {
    {
      // Try to get the size directly.
      /*const*/ DIType /*P*/ T = dyn_cast_DIType(RawType);
      if ((T != null)) {
        {
          long/*uint64_t*/ Size = T.getSizeInBits();
          if ((Size != 0)) {
            return Size;
          }
        }
      }
    }
    {
      
      /*const*/ DIDerivedType /*P*/ DT = dyn_cast_DIDerivedType(RawType);
      if ((DT != null)) {
        // Look at the base type.
        RawType = DT.getRawBaseType();
        continue;
      }
    }
    
    // Missing type or size.
    break;
  }
  
  // Fail gracefully.
  return $int2ulong(0);
}

//<editor-fold defaultstate="collapsed" desc="initializeVerifierLegacyPassPassOnce">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4368,
 FQN="initializeVerifierLegacyPassPassOnce", NM="_ZL36initializeVerifierLegacyPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL36initializeVerifierLegacyPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeVerifierLegacyPassPassOnce(final PassRegistry /*&*/ Registry) {
  PassInfo /*P*/ PI = new PassInfo($("Module Verifier"), $("verify"), $AddrOf(VerifierLegacyPass.ID), () -> new VerifierLegacyPass(),
          //((type$ptr<Pass /*P*/ (/*P*/ )()>)(/*FuncRef*/IrLlvmGlobals.<VerifierLegacyPass>callDefaultCtor)),
          false, false);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeVerifierLegacyPassPassFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4368,
 FQN="InitializeVerifierLegacyPassPassFlag", NM="_ZL36InitializeVerifierLegacyPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZL36InitializeVerifierLegacyPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeVerifierLegacyPassPassFlag/*J*/= new std.once_flag();
} // END OF class VerifierStatics
