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
package org.llvm.ir.impl.gen;

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type AttributesCompatFuncStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.gen.AttributesCompatFuncStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_ZL12mergeFnAttrsRN4llvm8FunctionERKS0_;_ZL19getAttrKindFromNameN4llvm9StringRefE;_ZL20hasCompatibleFnAttrsRKN4llvm8FunctionES2_; -static-type=AttributesCompatFuncStatics -package=org.llvm.ir.impl.gen")
//</editor-fold>
public final class AttributesCompatFuncStatics {

//<editor-fold defaultstate="collapsed" desc="hasCompatibleFnAttrs">
@Converted(kind = Converted.Kind.AUTO,
 source = "/export1/home/alsimon/LLVM39/build/lib/IR/AttributesCompatFunc.inc", line = 435,
 FQN="hasCompatibleFnAttrs", NM="_ZL20hasCompatibleFnAttrsRKN4llvm8FunctionES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZL20hasCompatibleFnAttrsRKN4llvm8FunctionES2_")
//</editor-fold>
public static /*inline*/ boolean hasCompatibleFnAttrs(final /*const*/ Function /*&*/ Caller, 
                    final /*const*/ Function /*&*/ Callee) {
  boolean Ret = true;
  
  Ret &= AttributesStatics.<SanitizeAddressAttr>isEqual(SanitizeAddressAttr.getKind(), Caller, Callee);
  Ret &= AttributesStatics.<SanitizeThreadAttr>isEqual(SanitizeThreadAttr.getKind(), Caller, Callee);
  Ret &= AttributesStatics.<SanitizeMemoryAttr>isEqual(SanitizeMemoryAttr.getKind(), Caller, Callee);
  Ret &= AttributesStatics.<SafeStackAttr>isEqual(SafeStackAttr.getKind(), Caller, Callee);
  
  return Ret;
}

//<editor-fold defaultstate="collapsed" desc="mergeFnAttrs">
@Converted(kind = Converted.Kind.AUTO,
 source = "/export1/home/alsimon/LLVM39/build/lib/IR/AttributesCompatFunc.inc", line = 447,
 FQN="mergeFnAttrs", NM="_ZL12mergeFnAttrsRN4llvm8FunctionERKS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Attributes.cpp -nm=_ZL12mergeFnAttrsRN4llvm8FunctionERKS0_")
//</editor-fold>
public static /*inline*/ void mergeFnAttrs(final Function /*&*/ Caller, 
            final /*const*/ Function /*&*/ Callee) {
  AttributesStatics.adjustCallerSSPLevel(Caller, Callee);
  AttributesStatics.<LessPreciseFPMADAttr>setAND(LessPreciseFPMADAttr.getKind(), Caller, Callee);
  AttributesStatics.<NoInfsFPMathAttr>setAND(NoInfsFPMathAttr.getKind(), Caller, Callee);
  AttributesStatics.<NoNansFPMathAttr>setAND(NoNansFPMathAttr.getKind(), Caller, Callee);
  AttributesStatics.<UnsafeFPMathAttr>setAND(UnsafeFPMathAttr.getKind(), Caller, Callee);
  AttributesStatics.<NoImplicitFloatAttr>setOR(NoImplicitFloatAttr.getKind(), Caller, Callee);
  AttributesStatics.<NoJumpTablesAttr>setOR(NoJumpTablesAttr.getKind(), Caller, Callee);
}

//<editor-fold defaultstate="collapsed" desc="getAttrKindFromName">
@Converted(kind = Converted.Kind.AUTO,
 source = "/export1/home/alsimon/LLVM39/build/lib/IR/AttributesCompatFunc.inc", line = 58,
 FQN="getAttrKindFromName", NM="_ZL19getAttrKindFromNameN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Core.cpp -nm=_ZL19getAttrKindFromNameN4llvm9StringRefE")
//</editor-fold>
public static Attribute.AttrKind getAttrKindFromName(StringRef AttrName) {
  return new StringSwitch<Attribute.AttrKind>(/*NO_COPY*/AttrName).
      Case(/*KEEP_STR*/"align", Attribute.AttrKind.Alignment).
      Case(/*KEEP_STR*/"allocsize", Attribute.AttrKind.AllocSize).
      Case(/*KEEP_STR*/"alwaysinline", Attribute.AttrKind.AlwaysInline).
      Case(/*KEEP_STR*/"argmemonly", Attribute.AttrKind.ArgMemOnly).
      Case(/*KEEP_STR*/"builtin", Attribute.AttrKind.Builtin).
      Case(/*KEEP_STR*/"byval", Attribute.AttrKind.ByVal).
      Case(/*KEEP_STR*/"cold", Attribute.AttrKind.Cold).
      Case(/*KEEP_STR*/"convergent", Attribute.AttrKind.Convergent).
      Case(/*KEEP_STR*/"dereferenceable", Attribute.AttrKind.Dereferenceable).
      Case(/*KEEP_STR*/"dereferenceable_or_null", Attribute.AttrKind.DereferenceableOrNull).
      Case(/*KEEP_STR*/"inalloca", Attribute.AttrKind.InAlloca).
      Case(/*KEEP_STR*/"inreg", Attribute.AttrKind.InReg).
      Case(/*KEEP_STR*/"inaccessiblememonly", Attribute.AttrKind.InaccessibleMemOnly).
      Case(/*KEEP_STR*/"inaccessiblemem_or_argmemonly", Attribute.AttrKind.InaccessibleMemOrArgMemOnly).
      Case(/*KEEP_STR*/"inlinehint", Attribute.AttrKind.InlineHint).
      Case(/*KEEP_STR*/"jumptable", Attribute.AttrKind.JumpTable).
      Case(/*KEEP_STR*/"minsize", Attribute.AttrKind.MinSize).
      Case(/*KEEP_STR*/"naked", Attribute.AttrKind.Naked).
      Case(/*KEEP_STR*/"nest", Attribute.AttrKind.Nest).
      Case(/*KEEP_STR*/"noalias", Attribute.AttrKind.NoAlias).
      Case(/*KEEP_STR*/"nobuiltin", Attribute.AttrKind.NoBuiltin).
      Case(/*KEEP_STR*/"nocapture", Attribute.AttrKind.NoCapture).
      Case(/*KEEP_STR*/"noduplicate", Attribute.AttrKind.NoDuplicate).
      Case(/*KEEP_STR*/"noimplicitfloat", Attribute.AttrKind.NoImplicitFloat).
      Case(/*KEEP_STR*/"noinline", Attribute.AttrKind.NoInline).
      Case(/*KEEP_STR*/"norecurse", Attribute.AttrKind.NoRecurse).
      Case(/*KEEP_STR*/"noredzone", Attribute.AttrKind.NoRedZone).
      Case(/*KEEP_STR*/"noreturn", Attribute.AttrKind.NoReturn).
      Case(/*KEEP_STR*/"nounwind", Attribute.AttrKind.NoUnwind).
      Case(/*KEEP_STR*/"nonlazybind", Attribute.AttrKind.NonLazyBind).
      Case(/*KEEP_STR*/"nonnull", Attribute.AttrKind.NonNull).
      Case(/*KEEP_STR*/"optsize", Attribute.AttrKind.OptimizeForSize).
      Case(/*KEEP_STR*/"optnone", Attribute.AttrKind.OptimizeNone).
      Case(/*KEEP_STR*/"readnone", Attribute.AttrKind.ReadNone).
      Case(/*KEEP_STR*/"readonly", Attribute.AttrKind.ReadOnly).
      Case(/*KEEP_STR*/"returned", Attribute.AttrKind.Returned).
      Case(/*KEEP_STR*/"returns_twice", Attribute.AttrKind.ReturnsTwice).
      Case(/*KEEP_STR*/"signext", Attribute.AttrKind.SExt).
      Case(/*KEEP_STR*/"safestack", Attribute.AttrKind.SafeStack).
      Case(/*KEEP_STR*/"sanitize_address", Attribute.AttrKind.SanitizeAddress).
      Case(/*KEEP_STR*/"sanitize_memory", Attribute.AttrKind.SanitizeMemory).
      Case(/*KEEP_STR*/"sanitize_thread", Attribute.AttrKind.SanitizeThread).
      Case(/*KEEP_STR*/"alignstack", Attribute.AttrKind.StackAlignment).
      Case(/*KEEP_STR*/"ssp", Attribute.AttrKind.StackProtect).
      Case(/*KEEP_STR*/"sspreq", Attribute.AttrKind.StackProtectReq).
      Case(/*KEEP_STR*/"sspstrong", Attribute.AttrKind.StackProtectStrong).
      Case(/*KEEP_STR*/"sret", Attribute.AttrKind.StructRet).
      Case(/*KEEP_STR*/"swifterror", Attribute.AttrKind.SwiftError).
      Case(/*KEEP_STR*/"swiftself", Attribute.AttrKind.SwiftSelf).
      Case(/*KEEP_STR*/"uwtable", Attribute.AttrKind.UWTable).
      Case(/*KEEP_STR*/"writeonly", Attribute.AttrKind.WriteOnly).
      Case(/*KEEP_STR*/"zeroext", Attribute.AttrKind.ZExt).
      Default(Attribute.AttrKind.None);
}

} // END OF class AttributesCompatFuncStatics
