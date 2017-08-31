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
package org.clang.basic;

import org.clank.support.*;


//<editor-fold defaultstate="collapsed" desc="static type attr">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang4attr4KindE; -static-type=attr -package=org.clang.basic")
//</editor-fold>
public final class attr {


// \brief A list of all the recognized kinds of attributes.
//<editor-fold defaultstate="collapsed" desc="clang::attr::Kind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/AttrKinds.h", line = 23,
 FQN="clang::attr::Kind", NM="_ZN5clang4attr4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang4attr4KindE")
//</editor-fold>
public enum Kind implements Native.ComparableLower {
  FallThrough(0),
  SwiftContext(FallThrough.getValue() + 1),
  SwiftErrorResult(SwiftContext.getValue() + 1),
  SwiftIndirectResult(SwiftErrorResult.getValue() + 1),
  Annotate(SwiftIndirectResult.getValue() + 1),
  CFConsumed(Annotate.getValue() + 1),
  CarriesDependency(CFConsumed.getValue() + 1),
  NSConsumed(CarriesDependency.getValue() + 1),
  PassObjectSize(NSConsumed.getValue() + 1),
  AMDGPUNumSGPR(PassObjectSize.getValue() + 1),
  AMDGPUNumVGPR(AMDGPUNumSGPR.getValue() + 1),
  ARMInterrupt(AMDGPUNumVGPR.getValue() + 1),
  AcquireCapability(ARMInterrupt.getValue() + 1),
  AcquiredAfter(AcquireCapability.getValue() + 1),
  AcquiredBefore(AcquiredAfter.getValue() + 1),
  AlignMac68k(AcquiredBefore.getValue() + 1),
  Aligned(AlignMac68k.getValue() + 1),
  AlwaysInline(Aligned.getValue() + 1),
  AnalyzerNoReturn(AlwaysInline.getValue() + 1),
  AnyX86Interrupt(AnalyzerNoReturn.getValue() + 1),
  ArcWeakrefUnavailable(AnyX86Interrupt.getValue() + 1),
  ArgumentWithTypeTag(ArcWeakrefUnavailable.getValue() + 1),
  AsmLabel(ArgumentWithTypeTag.getValue() + 1),
  AssertCapability(AsmLabel.getValue() + 1),
  AssertExclusiveLock(AssertCapability.getValue() + 1),
  AssertSharedLock(AssertExclusiveLock.getValue() + 1),
  AssumeAligned(AssertSharedLock.getValue() + 1),
  Availability(AssumeAligned.getValue() + 1),
  Blocks(Availability.getValue() + 1),
  C11NoReturn(Blocks.getValue() + 1),
  CDecl(C11NoReturn.getValue() + 1),
  CFAuditedTransfer(CDecl.getValue() + 1),
  CFReturnsNotRetained(CFAuditedTransfer.getValue() + 1),
  CFReturnsRetained(CFReturnsNotRetained.getValue() + 1),
  CFUnknownTransfer(CFReturnsRetained.getValue() + 1),
  CUDAConstant(CFUnknownTransfer.getValue() + 1),
  CUDADevice(CUDAConstant.getValue() + 1),
  CUDAGlobal(CUDADevice.getValue() + 1),
  CUDAHost(CUDAGlobal.getValue() + 1),
  CUDAInvalidTarget(CUDAHost.getValue() + 1),
  CUDALaunchBounds(CUDAInvalidTarget.getValue() + 1),
  CUDAShared(CUDALaunchBounds.getValue() + 1),
  CXX11NoReturn(CUDAShared.getValue() + 1),
  CallableWhen(CXX11NoReturn.getValue() + 1),
  Capability(CallableWhen.getValue() + 1),
  CapturedRecord(Capability.getValue() + 1),
  Cleanup(CapturedRecord.getValue() + 1),
  Cold(Cleanup.getValue() + 1),
  Common(Cold.getValue() + 1),
  Const(Common.getValue() + 1),
  Constructor(Const.getValue() + 1),
  Consumable(Constructor.getValue() + 1),
  ConsumableAutoCast(Consumable.getValue() + 1),
  ConsumableSetOnRead(ConsumableAutoCast.getValue() + 1),
  DLLExport(ConsumableSetOnRead.getValue() + 1),
  DLLImport(DLLExport.getValue() + 1),
  Deprecated(DLLImport.getValue() + 1),
  Destructor(Deprecated.getValue() + 1),
  DisableTailCalls(Destructor.getValue() + 1),
  EmptyBases(DisableTailCalls.getValue() + 1),
  EnableIf(EmptyBases.getValue() + 1),
  ExclusiveTrylockFunction(EnableIf.getValue() + 1),
  FastCall(ExclusiveTrylockFunction.getValue() + 1),
  Final(FastCall.getValue() + 1),
  FlagEnum(Final.getValue() + 1),
  Flatten(FlagEnum.getValue() + 1),
  Format(Flatten.getValue() + 1),
  FormatArg(Format.getValue() + 1),
  GNUInline(FormatArg.getValue() + 1),
  GuardedBy(GNUInline.getValue() + 1),
  GuardedVar(GuardedBy.getValue() + 1),
  Hot(GuardedVar.getValue() + 1),
  IBAction(Hot.getValue() + 1),
  IBOutlet(IBAction.getValue() + 1),
  IBOutletCollection(IBOutlet.getValue() + 1),
  InitPriority(IBOutletCollection.getValue() + 1),
  IntelOclBicc(InitPriority.getValue() + 1),
  InternalLinkage(IntelOclBicc.getValue() + 1),
  LTOVisibilityPublic(InternalLinkage.getValue() + 1),
  LayoutVersion(LTOVisibilityPublic.getValue() + 1),
  LockReturned(LayoutVersion.getValue() + 1),
  LocksExcluded(LockReturned.getValue() + 1),
  MSABI(LocksExcluded.getValue() + 1),
  MSInheritance(MSABI.getValue() + 1),
  MSNoVTable(MSInheritance.getValue() + 1),
  MSP430Interrupt(MSNoVTable.getValue() + 1),
  MSStruct(MSP430Interrupt.getValue() + 1),
  MSVtorDisp(MSStruct.getValue() + 1),
  MaxFieldAlignment(MSVtorDisp.getValue() + 1),
  MayAlias(MaxFieldAlignment.getValue() + 1),
  MinSize(MayAlias.getValue() + 1),
  Mips16(MinSize.getValue() + 1),
  MipsInterrupt(Mips16.getValue() + 1),
  NSConsumesSelf(MipsInterrupt.getValue() + 1),
  NSReturnsAutoreleased(NSConsumesSelf.getValue() + 1),
  NSReturnsNotRetained(NSReturnsAutoreleased.getValue() + 1),
  NSReturnsRetained(NSReturnsNotRetained.getValue() + 1),
  Naked(NSReturnsRetained.getValue() + 1),
  NoAlias(Naked.getValue() + 1),
  NoCommon(NoAlias.getValue() + 1),
  NoDebug(NoCommon.getValue() + 1),
  NoDuplicate(NoDebug.getValue() + 1),
  NoInline(NoDuplicate.getValue() + 1),
  NoInstrumentFunction(NoInline.getValue() + 1),
  NoMips16(NoInstrumentFunction.getValue() + 1),
  NoReturn(NoMips16.getValue() + 1),
  NoSanitize(NoReturn.getValue() + 1),
  NoSplitStack(NoSanitize.getValue() + 1),
  NoThreadSafetyAnalysis(NoSplitStack.getValue() + 1),
  NoThrow(NoThreadSafetyAnalysis.getValue() + 1),
  NonNull(NoThrow.getValue() + 1),
  NotTailCalled(NonNull.getValue() + 1),
  OMPCaptureNoInit(NotTailCalled.getValue() + 1),
  OMPThreadPrivateDecl(OMPCaptureNoInit.getValue() + 1),
  ObjCBridge(OMPThreadPrivateDecl.getValue() + 1),
  ObjCBridgeMutable(ObjCBridge.getValue() + 1),
  ObjCBridgeRelated(ObjCBridgeMutable.getValue() + 1),
  ObjCException(ObjCBridgeRelated.getValue() + 1),
  ObjCExplicitProtocolImpl(ObjCException.getValue() + 1),
  ObjCIndependentClass(ObjCExplicitProtocolImpl.getValue() + 1),
  ObjCMethodFamily(ObjCIndependentClass.getValue() + 1),
  ObjCNSObject(ObjCMethodFamily.getValue() + 1),
  ObjCPreciseLifetime(ObjCNSObject.getValue() + 1),
  ObjCRequiresPropertyDefs(ObjCPreciseLifetime.getValue() + 1),
  ObjCRequiresSuper(ObjCRequiresPropertyDefs.getValue() + 1),
  ObjCReturnsInnerPointer(ObjCRequiresSuper.getValue() + 1),
  ObjCRootClass(ObjCReturnsInnerPointer.getValue() + 1),
  OpenCLKernel(ObjCRootClass.getValue() + 1),
  OpenCLUnrollHint(OpenCLKernel.getValue() + 1),
  OptimizeNone(OpenCLUnrollHint.getValue() + 1),
  Override(OptimizeNone.getValue() + 1),
  Ownership(Override.getValue() + 1),
  Packed(Ownership.getValue() + 1),
  ParamTypestate(Packed.getValue() + 1),
  Pascal(ParamTypestate.getValue() + 1),
  Pcs(Pascal.getValue() + 1),
  PreserveAll(Pcs.getValue() + 1),
  PreserveMost(PreserveAll.getValue() + 1),
  PtGuardedBy(PreserveMost.getValue() + 1),
  PtGuardedVar(PtGuardedBy.getValue() + 1),
  Pure(PtGuardedVar.getValue() + 1),
  ReleaseCapability(Pure.getValue() + 1),
  ReqdWorkGroupSize(ReleaseCapability.getValue() + 1),
  RequiresCapability(ReqdWorkGroupSize.getValue() + 1),
  Restrict(RequiresCapability.getValue() + 1),
  ReturnTypestate(Restrict.getValue() + 1),
  ReturnsNonNull(ReturnTypestate.getValue() + 1),
  ReturnsTwice(ReturnsNonNull.getValue() + 1),
  ScopedLockable(ReturnsTwice.getValue() + 1),
  Section(ScopedLockable.getValue() + 1),
  SelectAny(Section.getValue() + 1),
  Sentinel(SelectAny.getValue() + 1),
  SetTypestate(Sentinel.getValue() + 1),
  SharedTrylockFunction(SetTypestate.getValue() + 1),
  StdCall(SharedTrylockFunction.getValue() + 1),
  SwiftCall(StdCall.getValue() + 1),
  SysVABI(SwiftCall.getValue() + 1),
  TLSModel(SysVABI.getValue() + 1),
  Target(TLSModel.getValue() + 1),
  TestTypestate(Target.getValue() + 1),
  ThisCall(TestTypestate.getValue() + 1),
  TransparentUnion(ThisCall.getValue() + 1),
  TryAcquireCapability(TransparentUnion.getValue() + 1),
  TypeTagForDatatype(TryAcquireCapability.getValue() + 1),
  TypeVisibility(TypeTagForDatatype.getValue() + 1),
  Unavailable(TypeVisibility.getValue() + 1),
  Unused(Unavailable.getValue() + 1),
  Used(Unused.getValue() + 1),
  Uuid(Used.getValue() + 1),
  VecReturn(Uuid.getValue() + 1),
  VecTypeHint(VecReturn.getValue() + 1),
  VectorCall(VecTypeHint.getValue() + 1),
  Visibility(VectorCall.getValue() + 1),
  WarnUnused(Visibility.getValue() + 1),
  WarnUnusedResult(WarnUnused.getValue() + 1),
  Weak(WarnUnusedResult.getValue() + 1),
  WeakImport(Weak.getValue() + 1),
  WeakRef(WeakImport.getValue() + 1),
  WorkGroupSizeHint(WeakRef.getValue() + 1),
  X86ForceAlignArgPointer(WorkGroupSizeHint.getValue() + 1),
  XRayInstrument(X86ForceAlignArgPointer.getValue() + 1),
  AbiTag(XRayInstrument.getValue() + 1),
  Alias(AbiTag.getValue() + 1),
  AlignValue(Alias.getValue() + 1),
  IFunc(AlignValue.getValue() + 1),
  InitSeg(IFunc.getValue() + 1),
  LoopHint(InitSeg.getValue() + 1),
  Mode(LoopHint.getValue() + 1),
  OMPDeclareSimdDecl(Mode.getValue() + 1),
  OMPDeclareTargetDecl(OMPDeclareSimdDecl.getValue() + 1),
  ObjCBoxable(OMPDeclareTargetDecl.getValue() + 1),
  ObjCDesignatedInitializer(ObjCBoxable.getValue() + 1),
  ObjCRuntimeName(ObjCDesignatedInitializer.getValue() + 1),
  ObjCRuntimeVisible(ObjCRuntimeName.getValue() + 1),
  OpenCLAccess(ObjCRuntimeVisible.getValue() + 1),
  Overloadable(OpenCLAccess.getValue() + 1),
  RenderScriptKernel(Overloadable.getValue() + 1),
  Thread(RenderScriptKernel.getValue() + 1),
  FirstAttr(Kind.FallThrough.getValue()),
  LastAttr(Kind.Thread.getValue()),
  FirstStmtAttr(Kind.FallThrough.getValue()),
  LastStmtAttr(Kind.FallThrough.getValue()),
  FirstInheritableAttr(Kind.SwiftContext.getValue()),
  LastInheritableAttr(Kind.XRayInstrument.getValue()),
  FirstInheritableParamAttr(Kind.SwiftContext.getValue()),
  LastInheritableParamAttr(Kind.PassObjectSize.getValue()),
  FirstParameterABIAttr(Kind.SwiftContext.getValue()),
  LastParameterABIAttr(Kind.SwiftIndirectResult.getValue());

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static Kind valueOf(int val) {
    Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final Kind[] VALUES;
    private static final Kind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (Kind kind : Kind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new Kind[min < 0 ? (1-min) : 0];
      VALUES = new Kind[max >= 0 ? (1+max) : 0];
      for (Kind kind : Kind.values()) {
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
  private Kind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
  //</editor-fold>
}
} // END OF class attr
