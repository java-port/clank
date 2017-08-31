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
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.gen.EnumAttr;
import org.llvm.ir.impl.gen.StrBoolAttr;


//<editor-fold defaultstate="collapsed" desc="static type AttributesStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.AttributesStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=Tpl__ZL5setORRN4llvm8FunctionERKS0_;Tpl__ZL6setANDRN4llvm8FunctionERKS0_;Tpl__ZL7isEqualRKN4llvm8FunctionES2_;_ZL17packAllocSizeArgsjRKN4llvm8OptionalIjEE;_ZL19unpackAllocSizeArgsy;_ZL20adjustCallerSSPLevelRN4llvm8FunctionERKS0_;_ZL27AllocSizeNumElemsNotPresent; -static-type=AttributesStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class AttributesStatics {


//===----------------------------------------------------------------------===//
// Attribute Construction Methods
//===----------------------------------------------------------------------===//

// allocsize has two integer arguments, but because they're both 32 bits, we can
// pack them into one 64-bit value, at the cost of making said value
// nonsensical.
//
// In order to do this, we need to reserve one value of the second (optional)
// allocsize argument to signify "not present."
//<editor-fold defaultstate="collapsed" desc="AllocSizeNumElemsNotPresent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 41,
 FQN="AllocSizeNumElemsNotPresent", NM="_ZL27AllocSizeNumElemsNotPresent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZL27AllocSizeNumElemsNotPresent")
//</editor-fold>
public static /*const*//*uint*/int AllocSizeNumElemsNotPresent = -1;
//<editor-fold defaultstate="collapsed" desc="packAllocSizeArgs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 43,
 FQN="packAllocSizeArgs", NM="_ZL17packAllocSizeArgsjRKN4llvm8OptionalIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZL17packAllocSizeArgsjRKN4llvm8OptionalIjEE")
//</editor-fold>
public static long/*uint64_t*/ packAllocSizeArgs(/*uint*/int ElemSizeArg, 
                 final /*const*/OptionalUInt /*&*/ NumElemsArg) {
  assert ((!NumElemsArg.hasValue() || NumElemsArg.$star/*$Const*/() != AllocSizeNumElemsNotPresent)) : "Attempting to pack a reserved value";
  
  return ((long/*uint64_t*/)($uint2ulong(ElemSizeArg))) << 32
     | $uint2ullong(NumElemsArg.getValueOr_T$RR/*$Const*/(AllocSizeNumElemsNotPresent));
}

//<editor-fold defaultstate="collapsed" desc="unpackAllocSizeArgs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 53,
 FQN="unpackAllocSizeArgs", NM="_ZL19unpackAllocSizeArgsy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZL19unpackAllocSizeArgsy")
//</editor-fold>
public static std.pairUIntType<OptionalUInt> unpackAllocSizeArgs(long/*uint64_t*/ Num) {
  /*uint*/int NumElems = $ullong2uint(Num & $uint2ullong(std.numeric_limitsUInt.max()));
  /*uint*/int ElemSizeArg = $ulong2uint(Num >>> 32);
  
  OptionalUInt NumElemsArg/*J*/= new OptionalUInt();
  if (NumElems != AllocSizeNumElemsNotPresent) {
    NumElemsArg.$assign_T$C$R(NumElems);
  }
  return std.make_pair_uint_T(ElemSizeArg, /*$Clone(*/NumElemsArg/*)*/);
}

/*template <typename AttrClass> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isEqual">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1572,
 FQN="isEqual", NM="Tpl__ZL7isEqualRKN4llvm8FunctionES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=Tpl__ZL7isEqualRKN4llvm8FunctionES2_")
//</editor-fold>
public static </*typename*/ AttrClass> boolean isEqual(Attribute.AttrKind attrKind, final /*const*/ Function /*&*/ Caller, final /*const*/ Function /*&*/ Callee) {
  return Native.$eq(Caller.getFnAttribute(attrKind), 
      Callee.getFnAttribute(attrKind));
}


/// \brief Compute the logical AND of the attributes of the caller and the
/// callee.
///
/// This function sets the caller's attribute to false if the callee's attribute
/// is false.
/*template <typename AttrClass> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="setAND">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1583,
 FQN="setAND", NM="Tpl__ZL6setANDRN4llvm8FunctionERKS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=Tpl__ZL6setANDRN4llvm8FunctionERKS0_")
//</editor-fold>
public static </*typename*/ AttrClass extends StrBoolAttr> void setAND(char$ptr attrKind, final Function /*&*/ Caller, final /*const*/ Function /*&*/ Callee) {
  if (Native.$bool(AttrClass.isSet(Caller, new StringRef(attrKind)))
     && Native.$not(AttrClass.isSet(Callee, new StringRef(attrKind)))) {
    AttrClass.set(Caller, new StringRef(attrKind), false);
  }
}


/// \brief Compute the logical OR of the attributes of the caller and the
/// callee.
///
/// This function sets the caller's attribute to true if the callee's attribute
/// is true.
/*template <typename AttrClass> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="setOR">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1595,
 FQN="setOR", NM="Tpl__ZL5setORRN4llvm8FunctionERKS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=Tpl__ZL5setORRN4llvm8FunctionERKS0_")
//</editor-fold>
public static </*typename*/ AttrClass extends StrBoolAttr> void setOR(char$ptr attrKind, final Function /*&*/ Caller, final /*const*/ Function /*&*/ Callee) {
  if (Native.$not(AttrClass.isSet(Caller, new StringRef(attrKind)))
     && Native.$bool(AttrClass.isSet(Callee, new StringRef(attrKind)))) {
    AttrClass.set(Caller, new StringRef(attrKind), true);
  }
}
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION)
public static </*typename*/ AttrClass extends EnumAttr> void setOR(Attribute.AttrKind attrKind, final Function /*&*/ Caller, final /*const*/ Function /*&*/ Callee) {
  if (Native.$not(AttrClass.isSet(Caller, attrKind))
     && Native.$bool(AttrClass.isSet(Callee, attrKind))) {
    AttrClass.set(Caller, attrKind, true);
  }
}


/// \brief If the inlined function had a higher stack protection level than the
/// calling function, then bump up the caller's stack protection level.
//<editor-fold defaultstate="collapsed" desc="adjustCallerSSPLevel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1603,
 FQN="adjustCallerSSPLevel", NM="_ZL20adjustCallerSSPLevelRN4llvm8FunctionERKS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZL20adjustCallerSSPLevelRN4llvm8FunctionERKS0_")
//</editor-fold>
public static void adjustCallerSSPLevel(final Function /*&*/ Caller, final /*const*/ Function /*&*/ Callee) {
  AttrBuilder B = null;
  try {
    // If upgrading the SSP attribute, clear out the old SSP Attributes first.
    // Having multiple SSP attributes doesn't actually hurt, but it adds useless
    // clutter to the IR.
    B/*J*/= new AttrBuilder();
    B.addAttribute(Attribute.AttrKind.StackProtect).
        addAttribute(Attribute.AttrKind.StackProtectStrong).
        addAttribute(Attribute.AttrKind.StackProtectReq);
    AttributeSet OldSSPAttr = AttributeSet.get(Caller.getContext(), 
        AttributeSet.AttrIndex.FunctionIndex.getValue(), 
        B);
    if (Callee.hasFnAttribute(Attribute.AttrKind.StackProtectReq)) {
      Caller.removeAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue(), new AttributeSet(OldSSPAttr));
      Caller.addFnAttr(Attribute.AttrKind.StackProtectReq);
    } else if (Callee.hasFnAttribute(Attribute.AttrKind.StackProtectStrong)
       && !Caller.hasFnAttribute(Attribute.AttrKind.StackProtectReq)) {
      Caller.removeAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue(), new AttributeSet(OldSSPAttr));
      Caller.addFnAttr(Attribute.AttrKind.StackProtectStrong);
    } else if (Callee.hasFnAttribute(Attribute.AttrKind.StackProtect)
       && !Caller.hasFnAttribute(Attribute.AttrKind.StackProtectReq)
       && !Caller.hasFnAttribute(Attribute.AttrKind.StackProtectStrong)) {
      Caller.addFnAttr(Attribute.AttrKind.StackProtect);
    }
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

} // END OF class AttributesStatics
