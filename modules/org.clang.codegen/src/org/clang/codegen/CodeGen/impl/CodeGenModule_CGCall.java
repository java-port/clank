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
package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.clang.basic.target.TargetInfo;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.codegen.impl.CGCallStatics.AddAttributesFromFunctionProtoType;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_CGCall">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_CGCall",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_CGCXX ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen13CodeGenModule18ReturnTypeUsesSRetERKNS0_14CGFunctionInfoE;_ZN5clang7CodeGen13CodeGenModule19ReturnTypeUsesFPRetENS_8QualTypeE;_ZN5clang7CodeGen13CodeGenModule20ReturnTypeUsesFP2RetENS_8QualTypeE;_ZN5clang7CodeGen13CodeGenModule22ConstructAttributeListEN4llvm9StringRefERKNS0_14CGFunctionInfoENS0_12CGCalleeInfoERNS2_11SmallVectorINS2_12AttributeSetELj8EEERjb;_ZN5clang7CodeGen13CodeGenModule28ReturnSlotInterferesWithArgsERKNS0_14CGFunctionInfoE; -static-type=CodeGenModule_CGCall -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_CGCall extends CodeGenModule_CGCXX {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }


/// Return true iff the given type uses 'sret' when used as a return type.
// namespace

/***/
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::ReturnTypeUsesSRet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1423,
 FQN="clang::CodeGen::CodeGenModule::ReturnTypeUsesSRet", NM="_ZN5clang7CodeGen13CodeGenModule18ReturnTypeUsesSRetERKNS0_14CGFunctionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen13CodeGenModule18ReturnTypeUsesSRetERKNS0_14CGFunctionInfoE")
//</editor-fold>
public final boolean ReturnTypeUsesSRet(final /*const*/ CGFunctionInfo /*&*/ FI) {
  return FI.getReturnInfo$Const().isIndirect();
}


/// Return true iff the given type uses an argument slot when 'sret' is used
/// as a return type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::ReturnSlotInterferesWithArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1427,
 FQN="clang::CodeGen::CodeGenModule::ReturnSlotInterferesWithArgs", NM="_ZN5clang7CodeGen13CodeGenModule28ReturnSlotInterferesWithArgsERKNS0_14CGFunctionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen13CodeGenModule28ReturnSlotInterferesWithArgsERKNS0_14CGFunctionInfoE")
//</editor-fold>
public final boolean ReturnSlotInterferesWithArgs(final /*const*/ CGFunctionInfo /*&*/ FI) {
  return $this().ReturnTypeUsesSRet(FI)
     && $this().getTargetCodeGenInfo().doesReturnSlotInterfereWithArgs();
}


/// Return true iff the given type uses 'fpret' when used as a return type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::ReturnTypeUsesFPRet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1432,
 FQN="clang::CodeGen::CodeGenModule::ReturnTypeUsesFPRet", NM="_ZN5clang7CodeGen13CodeGenModule19ReturnTypeUsesFPRetENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19ReturnTypeUsesFPRetENS_8QualTypeE")
//</editor-fold>
public final boolean ReturnTypeUsesFPRet(QualType ResultType) {
  {
    /*const*/ BuiltinType /*P*/ BT = ResultType.$arrow().getAs$BuiltinType();
    if ((BT != null)) {
      switch (BT.getKind()) {
       default:
        return false;
       case Float:
        return $this().getTarget().useObjCFPRetForRealType(TargetInfo.RealType.Float);
       case Double:
        return $this().getTarget().useObjCFPRetForRealType(TargetInfo.RealType.Double);
       case LongDouble:
        return $this().getTarget().useObjCFPRetForRealType(TargetInfo.RealType.LongDouble);
      }
    }
  }
  
  return false;
}


/// Return true iff the given type uses 'fp2ret' when used as a return type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::ReturnTypeUsesFP2Ret">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1449,
 FQN="clang::CodeGen::CodeGenModule::ReturnTypeUsesFP2Ret", NM="_ZN5clang7CodeGen13CodeGenModule20ReturnTypeUsesFP2RetENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20ReturnTypeUsesFP2RetENS_8QualTypeE")
//</editor-fold>
public final boolean ReturnTypeUsesFP2Ret(QualType ResultType) {
  {
    /*const*/ ComplexType /*P*/ CT = ResultType.$arrow().getAs(ComplexType.class);
    if ((CT != null)) {
      {
        /*const*/ BuiltinType /*P*/ BT = CT.getElementType().$arrow().getAs$BuiltinType();
        if ((BT != null)) {
          if (BT.getKind() == BuiltinType.Kind.LongDouble) {
            return $this().getTarget().useObjCFP2RetForComplexLongDouble();
          }
        }
      }
    }
  }
  
  return false;
}


/// Get the LLVM attributes and calling convention to use for a particular
/// function type.
///
/// \param Name - The function name.
/// \param Info - The function type information.
/// \param CalleeInfo - The callee information these attributes are being
/// constructed for. If valid, the attributes applied to this decl may
/// contribute to the function attributes and calling convention.
/// \param PAL [out] - On return, the attribute list to use.
/// \param CallingConv [out] - On return, the LLVM calling convention to use.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::ConstructAttributeList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1620,
 FQN="clang::CodeGen::CodeGenModule::ConstructAttributeList", NM="_ZN5clang7CodeGen13CodeGenModule22ConstructAttributeListEN4llvm9StringRefERKNS0_14CGFunctionInfoENS0_12CGCalleeInfoERNS2_11SmallVectorINS2_12AttributeSetELj8EEERjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen13CodeGenModule22ConstructAttributeListEN4llvm9StringRefERKNS0_14CGFunctionInfoENS0_12CGCalleeInfoERNS2_11SmallVectorINS2_12AttributeSetELj8EEERjb")
//</editor-fold>
public final void ConstructAttributeList(StringRef Name, final /*const*/ CGFunctionInfo /*&*/ FI, CGCalleeInfo CalleeInfo, 
                      final SmallVector<AttributeSet> /*&*/ PAL, final uint$ref/*uint &*/ CallingConv, boolean AttrOnCallSite) {
  AttrBuilder FuncAttrs = null;
  AttrBuilder RetAttrs = null;
  ClangToLLVMArgMapping IRFunctionArgs = null;
  try {
    FuncAttrs/*J*/= new AttrBuilder();
    RetAttrs/*J*/= new AttrBuilder();
    boolean HasOptnone = false;
    
    CallingConv.$set(FI.getEffectiveCallingConvention());
    if (FI.isNoReturn()) {
      FuncAttrs.addAttribute(Attribute.AttrKind.NoReturn);
    }
    
    // If we have information about the function prototype, we can learn
    // attributes form there.
    AddAttributesFromFunctionProtoType($this().getContext(), FuncAttrs, 
        CalleeInfo.getCalleeFunctionProtoType());
    
    /*const*/ Decl /*P*/ TargetDecl = CalleeInfo.getCalleeDecl();
    
    boolean HasAnyX86InterruptAttr = false;
    // FIXME: handle sseregparm someday...
    if ((TargetDecl != null)) {
      if (TargetDecl.hasAttr(ReturnsTwiceAttr.class)) {
        FuncAttrs.addAttribute(Attribute.AttrKind.ReturnsTwice);
      }
      if (TargetDecl.hasAttr(NoThrowAttr.class)) {
        FuncAttrs.addAttribute(Attribute.AttrKind.NoUnwind);
      }
      if (TargetDecl.hasAttr(NoReturnAttr.class)) {
        FuncAttrs.addAttribute(Attribute.AttrKind.NoReturn);
      }
      if (TargetDecl.hasAttr(NoDuplicateAttr.class)) {
        FuncAttrs.addAttribute(Attribute.AttrKind.NoDuplicate);
      }
      {
        
        /*const*/ FunctionDecl /*P*/ Fn = dyn_cast_FunctionDecl(TargetDecl);
        if ((Fn != null)) {
          AddAttributesFromFunctionProtoType($this().getContext(), FuncAttrs, Fn.getType().$arrow().getAs(FunctionProtoType.class));
          // Don't use [[noreturn]] or _Noreturn for a call to a virtual function.
          // These attributes are not inherited by overloads.
          /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(Fn);
          if (Fn.isNoReturn() && !(AttrOnCallSite && (MD != null) && MD.isVirtual())) {
            FuncAttrs.addAttribute(Attribute.AttrKind.NoReturn);
          }
        }
      }
      
      // 'const', 'pure' and 'noalias' attributed functions are also nounwind.
      if (TargetDecl.hasAttr(ConstAttr.class)) {
        FuncAttrs.addAttribute(Attribute.AttrKind.ReadNone);
        FuncAttrs.addAttribute(Attribute.AttrKind.NoUnwind);
      } else if (TargetDecl.hasAttr(PureAttr.class)) {
        FuncAttrs.addAttribute(Attribute.AttrKind.ReadOnly);
        FuncAttrs.addAttribute(Attribute.AttrKind.NoUnwind);
      } else if (TargetDecl.hasAttr(NoAliasAttr.class)) {
        FuncAttrs.addAttribute(Attribute.AttrKind.ArgMemOnly);
        FuncAttrs.addAttribute(Attribute.AttrKind.NoUnwind);
      }
      if (TargetDecl.hasAttr(RestrictAttr.class)) {
        RetAttrs.addAttribute(Attribute.AttrKind.NoAlias);
      }
      if (TargetDecl.hasAttr(ReturnsNonNullAttr.class)) {
        RetAttrs.addAttribute(Attribute.AttrKind.NonNull);
      }
      
      HasAnyX86InterruptAttr = TargetDecl.hasAttr(AnyX86InterruptAttr.class);
      HasOptnone = TargetDecl.hasAttr(OptimizeNoneAttr.class);
    }
    
    // OptimizeNoneAttr takes precedence over -Os or -Oz. No warning needed.
    if (!HasOptnone) {
      if (($2bits_uint2uint($this().CodeGenOpts.OptimizeSize) != 0)) {
        FuncAttrs.addAttribute(Attribute.AttrKind.OptimizeForSize);
      }
      if ($2bits_uint2uint($this().CodeGenOpts.OptimizeSize) == 2) {
        FuncAttrs.addAttribute(Attribute.AttrKind.MinSize);
      }
    }
    if ($this().CodeGenOpts.DisableRedZone) {
      FuncAttrs.addAttribute(Attribute.AttrKind.NoRedZone);
    }
    if ($this().CodeGenOpts.NoImplicitFloat) {
      FuncAttrs.addAttribute(Attribute.AttrKind.NoImplicitFloat);
    }
    if ($this().CodeGenOpts.EnableSegmentedStacks
       && !((TargetDecl != null) && TargetDecl.hasAttr(NoSplitStackAttr.class))) {
      FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"split-stack"));
    }
    if (AttrOnCallSite) {
      // Attributes that should go on the call site only.
      if (!$this().CodeGenOpts.SimplifyLibCalls
         || $this().CodeGenOpts.isNoBuiltinFunc(Name.data())) {
        FuncAttrs.addAttribute(Attribute.AttrKind.NoBuiltin);
      }
      if (!$this().CodeGenOpts.TrapFuncName.empty()) {
        FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"trap-func-name"), new StringRef($this().CodeGenOpts.TrapFuncName));
      }
    } else {
      // Attributes that should go on the function, but not the call site.
      if (!$this().CodeGenOpts.DisableFPElim) {
        FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"no-frame-pointer-elim"), new StringRef(/*KEEP_STR*/$false));
      } else if ($this().CodeGenOpts.OmitLeafFramePointer) {
        FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"no-frame-pointer-elim"), new StringRef(/*KEEP_STR*/$false));
        FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"no-frame-pointer-elim-non-leaf"));
      } else {
        FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"no-frame-pointer-elim"), new StringRef(/*KEEP_STR*/$true));
        FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"no-frame-pointer-elim-non-leaf"));
      }
      
      boolean DisableTailCalls = $this().CodeGenOpts.DisableTailCalls || HasAnyX86InterruptAttr
         || ((TargetDecl != null) && TargetDecl.hasAttr(DisableTailCallsAttr.class));
      FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"disable-tail-calls"), 
          llvm.toStringRef(DisableTailCalls));
      
      FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"less-precise-fpmad"), 
          llvm.toStringRef($this().CodeGenOpts.LessPreciseFPMAD));
      FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"no-infs-fp-math"), 
          llvm.toStringRef($this().CodeGenOpts.NoInfsFPMath));
      FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"no-nans-fp-math"), 
          llvm.toStringRef($this().CodeGenOpts.NoNaNsFPMath));
      FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"unsafe-fp-math"), 
          llvm.toStringRef($this().CodeGenOpts.UnsafeFPMath));
      FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"use-soft-float"), 
          llvm.toStringRef($this().CodeGenOpts.SoftFloat));
      FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"stack-protector-buffer-size"), 
          new StringRef(llvm.utostr($uint2ulong($this().CodeGenOpts.SSPBufferSize))));
      FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"no-signed-zeros-fp-math"), 
          llvm.toStringRef($this().CodeGenOpts.NoSignedZeros));
      if ($this().CodeGenOpts.StackRealignment) {
        FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"stackrealign"));
      }
      if ($this().CodeGenOpts.Backchain) {
        FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"backchain"));
      }
      
      // Add target-cpu and target-features attributes to functions. If
      // we have a decl for the function and it has a target attribute then
      // parse that and add it to the feature set.
      StringRef TargetCPU = new StringRef($this().getTarget().getTargetOpts().CPU);
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(TargetDecl);
      if ((FD != null) && FD.hasAttr(TargetAttr.class)) {
        StringMapBool FeatureMap = null;
        std.vectorString Features = null;
        std.pair<std.vectorString, StringRef> ParsedAttr = null;
        try {
          FeatureMap/*J*/= new StringMapBool(false);
          $this().getFunctionFeatureMap(FeatureMap, FD);
          
          // Produce the canonical string for this set of features.
          Features/*J*/= new std.vectorString(std.string.EMPTY);
          for (StringMapIteratorBool it = new StringMapIteratorBool(JD$Move.INSTANCE, FeatureMap.begin()), 
              ie = new StringMapIteratorBool(JD$Move.INSTANCE, FeatureMap.end());
               it.$noteq(ie); it.$preInc())  {
            Features.push_back_T$RR($add_T$C$P_string((it.$arrow().second ? $PLUS : $MINUS), it.$arrow().first().str()));
          }
          
          // Now add the target-cpu and target-features to the function.
          // While we populated the feature map above, we still need to
          // get and parse the target attribute so we can get the cpu for
          // the function.
          /*const*/ TargetAttr /*P*/ TD = FD.getAttr(TargetAttr.class);
          ParsedAttr = TD.parse();
          if ($noteq_StringRef(/*NO_COPY*/ParsedAttr.second, /*STRINGREF_STR*/"")) {
            TargetCPU.$assign(ParsedAttr.second);
          }
          if ($noteq_StringRef(/*NO_COPY*/TargetCPU, /*STRINGREF_STR*/"")) {
            FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"target-cpu"), new StringRef(TargetCPU));
          }
          if (!Features.empty()) {
            std.sort(Features.begin(), Features.end());
            FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"target-features"), 
                new StringRef(llvm.join(Features.begin(), Features.end(), new StringRef(/*KEEP_STR*/$COMMA))));
          }
        } finally {
          if (ParsedAttr != null) { ParsedAttr.$destroy(); }
          if (Features != null) { Features.$destroy(); }
          if (FeatureMap != null) { FeatureMap.$destroy(); }
        }
      } else {
        // Otherwise just add the existing target cpu and target features to the
        // function.
        final std.vectorString/*&*/ Features = $this().getTarget().getTargetOpts().Features;
        if ($noteq_StringRef(/*NO_COPY*/TargetCPU, /*STRINGREF_STR*/"")) {
          FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"target-cpu"), new StringRef(TargetCPU));
        }
        if (!Features.empty()) {
          std.sort(Features.begin(), Features.end());
          FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"target-features"), 
              new StringRef(llvm.join(Features.begin(), Features.end(), new StringRef(/*KEEP_STR*/$COMMA))));
        }
      }
    }
    if ($this().getLangOpts().CUDA && $this().getLangOpts().CUDAIsDevice) {
      // Conservatively, mark all functions and calls in CUDA as convergent
      // (meaning, they may call an intrinsically convergent op, such as
      // __syncthreads(), and so can't have certain optimizations applied around
      // them).  LLVM will remove this attribute where it safely can.
      FuncAttrs.addAttribute(Attribute.AttrKind.Convergent);
      
      // Respect -fcuda-flush-denormals-to-zero.
      if ($this().getLangOpts().CUDADeviceFlushDenormalsToZero) {
        FuncAttrs.addAttribute(new StringRef(/*KEEP_STR*/"nvptx-f32ftz"), new StringRef(/*KEEP_STR*/$true));
      }
    }
    
    IRFunctionArgs/*J*/= new ClangToLLVMArgMapping($this().getContext(), FI);
    
    QualType RetTy = FI.getReturnType().$QualType();
    final /*const*/ ABIArgInfo /*&*/ RetAI = FI.getReturnInfo$Const();
    switch (RetAI.getKind()) {
     case Extend:
      if (RetTy.$arrow().hasSignedIntegerRepresentation()) {
        RetAttrs.addAttribute(Attribute.AttrKind.SExt);
      } else if (RetTy.$arrow().hasUnsignedIntegerRepresentation()) {
        RetAttrs.addAttribute(Attribute.AttrKind.ZExt);
      }
     case Direct:
      // FALL THROUGH
      if (RetAI.getInReg()) {
        RetAttrs.addAttribute(Attribute.AttrKind.InReg);
      }
      break;
     case Ignore:
      break;
     case InAlloca:
     case Indirect:
      {
        // inalloca and sret disable readnone and readonly
        FuncAttrs.removeAttribute(Attribute.AttrKind.ReadOnly).
            removeAttribute(Attribute.AttrKind.ReadNone);
        break;
      }
     case CoerceAndExpand:
      break;
     case Expand:
      throw new llvm_unreachable("Invalid ABI kind for return argument");
    }
    {
      
      /*const*/ ReferenceType /*P*/ RefTy = RetTy.$arrow().getAs(ReferenceType.class);
      if ((RefTy != null)) {
        QualType PTy = RefTy.getPointeeType();
        if (!PTy.$arrow().isIncompleteType() && PTy.$arrow().isConstantSizeType()) {
          RetAttrs.addDereferenceableAttr($this().getContext().getTypeSizeInChars(/*NO_COPY*/PTy).
                  getQuantity());
        } else if ($this().getContext().getTargetAddressSpace(new QualType(PTy)) == 0) {
          RetAttrs.addAttribute(Attribute.AttrKind.NonNull);
        }
      }
    }
    
    // Attach return attributes.
    if (RetAttrs.hasAttributes()) {
      PAL.push_back(AttributeSet.get($this().getLLVMContext(), AttributeSet.AttrIndex.ReturnIndex.getValue(), RetAttrs));
    }
    
    boolean hasUsedSRet = false;
    
    // Attach attributes to sret.
    if (IRFunctionArgs.hasSRetArg()) {
      AttrBuilder SRETAttrs = null;
      try {
        SRETAttrs/*J*/= new AttrBuilder();
        SRETAttrs.addAttribute(Attribute.AttrKind.StructRet);
        hasUsedSRet = true;
        if (RetAI.getInReg()) {
          SRETAttrs.addAttribute(Attribute.AttrKind.InReg);
        }
        PAL.push_back(AttributeSet.get($this().getLLVMContext(), IRFunctionArgs.getSRetArgNo() + 1, SRETAttrs));
      } finally {
        if (SRETAttrs != null) { SRETAttrs.$destroy(); }
      }
    }
    
    // Attach attributes to inalloca argument.
    if (IRFunctionArgs.hasInallocaArg()) {
      AttrBuilder Attrs = null;
      try {
        Attrs/*J*/= new AttrBuilder();
        Attrs.addAttribute(Attribute.AttrKind.InAlloca);
        PAL.push_back(AttributeSet.get($this().getLLVMContext(), IRFunctionArgs.getInallocaArgNo() + 1, Attrs));
      } finally {
        if (Attrs != null) { Attrs.$destroy(); }
      }
    }
    
    /*uint*/int ArgNo = 0;
    for (type$ptr</*const*/ CGFunctionInfoArgInfo /*P*/ > I = $tryClone(FI.arg_begin$Const()), 
        /*P*/ E = $tryClone(FI.arg_end$Const());
         $noteq_ptr(I, E); I.$preInc() , ++ArgNo) {
      AttrBuilder Attrs = null;
      try {
        QualType ParamType = I./*->*/$star().type.$QualType();
        final /*const*/ ABIArgInfo /*&*/ AI = I./*->*/$star().info;
        Attrs/*J*/= new AttrBuilder();
        
        // Add attribute for padding argument, if necessary.
        if (IRFunctionArgs.hasPaddingArg(ArgNo)) {
          if (AI.getPaddingInReg()) {
            PAL.push_back(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind($this().getLLVMContext(), IRFunctionArgs.getPaddingArgNo(ArgNo) + 1, 
                    new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.InReg)));
          }
        }
        
        // 'restrict' -> 'noalias' is done in EmitFunctionProlog when we
        // have the corresponding parameter variable.  It doesn't make
        // sense to do it here because parameters are so messed up.
        switch (AI.getKind()) {
         case Extend:
          if (ParamType.$arrow().isSignedIntegerOrEnumerationType()) {
            Attrs.addAttribute(Attribute.AttrKind.SExt);
          } else if (ParamType.$arrow().isUnsignedIntegerOrEnumerationType()) {
            if ($this().getTypes().getABIInfo().shouldSignExtUnsignedType(new QualType(ParamType))) {
              Attrs.addAttribute(Attribute.AttrKind.SExt);
            } else {
              Attrs.addAttribute(Attribute.AttrKind.ZExt);
            }
          }
         case Direct:
          // FALL THROUGH
          if (ArgNo == 0 && FI.isChainCall()) {
            Attrs.addAttribute(Attribute.AttrKind.Nest);
          } else if (AI.getInReg()) {
            Attrs.addAttribute(Attribute.AttrKind.InReg);
          }
          break;
         case Indirect:
          {
            if (AI.getInReg()) {
              Attrs.addAttribute(Attribute.AttrKind.InReg);
            }
            if (AI.getIndirectByVal()) {
              Attrs.addAttribute(Attribute.AttrKind.ByVal);
            }
            
            CharUnits Align = AI.getIndirectAlign();
            
            // In a byval argument, it is important that the required
            // alignment of the type is honored, as LLVM might be creating a
            // *new* stack object, and needs to know what alignment to give
            // it. (Sometimes it can deduce a sensible alignment on its own,
            // but not if clang decides it must emit a packed struct, or the
            // user specifies increased alignment requirements.)
            //
            // This is different from indirect *not* byval, where the object
            // exists already, and the align attribute is purely
            // informative.
            assert (!Align.isZero());
            
            // For now, only add this when we have a byval argument.
            // TODO: be less lazy about updating test cases.
            if (AI.getIndirectByVal()) {
              Attrs.addAlignmentAttr($long2uint(Align.getQuantity()));
            }
            
            // byval disables readnone and readonly.
            FuncAttrs.removeAttribute(Attribute.AttrKind.ReadOnly).
                removeAttribute(Attribute.AttrKind.ReadNone);
            break;
          }
         case Ignore:
         case Expand:
         case CoerceAndExpand:
          break;
         case InAlloca:
          // inalloca disables readnone and readonly.
          FuncAttrs.removeAttribute(Attribute.AttrKind.ReadOnly).
              removeAttribute(Attribute.AttrKind.ReadNone);
          continue;
        }
        {
          
          /*const*/ ReferenceType /*P*/ RefTy = ParamType.$arrow().getAs(ReferenceType.class);
          if ((RefTy != null)) {
            QualType PTy = RefTy.getPointeeType();
            if (!PTy.$arrow().isIncompleteType() && PTy.$arrow().isConstantSizeType()) {
              Attrs.addDereferenceableAttr($this().getContext().getTypeSizeInChars(/*NO_COPY*/PTy).
                      getQuantity());
            } else if ($this().getContext().getTargetAddressSpace(new QualType(PTy)) == 0) {
              Attrs.addAttribute(Attribute.AttrKind.NonNull);
            }
          }
        }
        switch (FI.getExtParameterInfo(ArgNo).getABI()) {
         case Ordinary:
          break;
         case SwiftIndirectResult:
          {
            // Add 'sret' if we haven't already used it for something, but
            // only if the result is void.
            if (!hasUsedSRet && RetTy.$arrow().isVoidType()) {
              Attrs.addAttribute(Attribute.AttrKind.StructRet);
              hasUsedSRet = true;
            }
            
            // Add 'noalias' in either case.
            Attrs.addAttribute(Attribute.AttrKind.NoAlias);
            
            // Add 'dereferenceable' and 'alignment'.
            QualType PTy = ParamType.$arrow().getPointeeType();
            if (!PTy.$arrow().isIncompleteType() && PTy.$arrow().isConstantSizeType()) {
              std.pairTypeType<CharUnits, CharUnits> info = $this().getContext().getTypeInfoInChars(new QualType(PTy));
              Attrs.addDereferenceableAttr(info.first.getQuantity());
              Attrs.addAttribute(Attribute.getWithAlignment($this().getLLVMContext(), 
                      info.second.getQuantity()));
            }
            break;
          }
         case SwiftErrorResult:
          Attrs.addAttribute(Attribute.AttrKind.SwiftError);
          break;
         case SwiftContext:
          Attrs.addAttribute(Attribute.AttrKind.SwiftSelf);
          break;
        }
        if (Attrs.hasAttributes()) {
          //std.tie(FirstIRArg, NumIRArgs).$assign(tmp);
          final pairUIntUInt tmp = IRFunctionArgs.getIRArgs(ArgNo);
          /*uint*/int FirstIRArg = tmp.first;
          /*uint*/int NumIRArgs = tmp.second;
          for (/*uint*/int i = 0; $less_uint(i, NumIRArgs); i++)  {
            PAL.push_back(AttributeSet.get($this().getLLVMContext(), 
                    FirstIRArg + i + 1, Attrs));
          }
        }
      } finally {
        if (Attrs != null) { Attrs.$destroy(); }
      }
    }
    assert (ArgNo == FI.arg_size());
    if (FuncAttrs.hasAttributes()) {
      PAL.push_back(AttributeSet.get($this().getLLVMContext(), 
              AttributeSet.AttrIndex.FunctionIndex.getValue(), 
              FuncAttrs));
    }
  } finally {
    if (IRFunctionArgs != null) { IRFunctionArgs.$destroy(); }
    if (RetAttrs != null) { RetAttrs.$destroy(); }
    if (FuncAttrs != null) { FuncAttrs.$destroy(); }
  }
}

} // END OF class CodeGenModule_CGCall
