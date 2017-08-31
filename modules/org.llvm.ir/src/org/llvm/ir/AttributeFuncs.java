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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.ir.impl.gen.AttributesCompatFuncStatics;


//<editor-fold defaultstate="collapsed" desc="static type AttributeFuncs">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.AttributeFuncs",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm14AttributeFuncs16typeIncompatibleEPNS_4TypeE;_ZN4llvm14AttributeFuncs19areInlineCompatibleERKNS_8FunctionES3_;_ZN4llvm14AttributeFuncs26mergeAttributesForInliningERNS_8FunctionERKS1_; -static-type=AttributeFuncs -package=org.llvm.ir")
//</editor-fold>
public final class AttributeFuncs {


/// \brief Which attributes cannot be applied to a type.

//===----------------------------------------------------------------------===//
// AttributeFuncs Function Defintions
//===----------------------------------------------------------------------===//

/// \brief Which attributes cannot be applied to a type.
//<editor-fold defaultstate="collapsed" desc="llvm::AttributeFuncs::typeIncompatible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1546,
 FQN="llvm::AttributeFuncs::typeIncompatible", NM="_ZN4llvm14AttributeFuncs16typeIncompatibleEPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm14AttributeFuncs16typeIncompatibleEPNS_4TypeE")
//</editor-fold>
public static AttrBuilder typeIncompatible(Type /*P*/ Ty) {
  AttrBuilder Incompatible = null;
  try {
    Incompatible/*J*/= new AttrBuilder();
    if (!Ty.isIntegerTy()) {
      // Attribute that only apply to integers.
      Incompatible.addAttribute(Attribute.AttrKind.SExt).
          addAttribute(Attribute.AttrKind.ZExt);
    }
    if (!Ty.isPointerTy()) {
      // Attribute that only apply to pointers.
      Incompatible.addAttribute(Attribute.AttrKind.ByVal).
          addAttribute(Attribute.AttrKind.Nest).
          addAttribute(Attribute.AttrKind.NoAlias).
          addAttribute(Attribute.AttrKind.NoCapture).
          addAttribute(Attribute.AttrKind.NonNull).
          addDereferenceableAttr($int2ulong(1)). // the int here is ignored
          addDereferenceableOrNullAttr($int2ulong(1)). // the int here is ignored
          addAttribute(Attribute.AttrKind.ReadNone).
          addAttribute(Attribute.AttrKind.ReadOnly).
          addAttribute(Attribute.AttrKind.StructRet).
          addAttribute(Attribute.AttrKind.InAlloca);
    }
    
    return new AttrBuilder(JD$Move.INSTANCE, Incompatible);
  } finally {
    if (Incompatible != null) { Incompatible.$destroy(); }
  }
}


/// \returns Return true if the two functions have compatible target-independent
/// attributes for inlining purposes.
//<editor-fold defaultstate="collapsed" desc="llvm::AttributeFuncs::areInlineCompatible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1631,
 FQN="llvm::AttributeFuncs::areInlineCompatible", NM="_ZN4llvm14AttributeFuncs19areInlineCompatibleERKNS_8FunctionES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm14AttributeFuncs19areInlineCompatibleERKNS_8FunctionES3_")
//</editor-fold>
public static boolean areInlineCompatible(final /*const*/ Function /*&*/ Caller, 
                   final /*const*/ Function /*&*/ Callee) {
  return AttributesCompatFuncStatics.hasCompatibleFnAttrs(Caller, Callee);
}


/// \brief Merge caller's and callee's attributes.
//<editor-fold defaultstate="collapsed" desc="llvm::AttributeFuncs::mergeAttributesForInlining">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Attributes.cpp", line = 1637,
 FQN="llvm::AttributeFuncs::mergeAttributesForInlining", NM="_ZN4llvm14AttributeFuncs26mergeAttributesForInliningERNS_8FunctionERKS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZN4llvm14AttributeFuncs26mergeAttributesForInliningERNS_8FunctionERKS1_")
//</editor-fold>
public static void mergeAttributesForInlining(final Function /*&*/ Caller, 
                          final /*const*/ Function /*&*/ Callee) {
  AttributesCompatFuncStatics.mergeFnAttrs(Caller, Callee);
}

} // END OF class AttributeFuncs
