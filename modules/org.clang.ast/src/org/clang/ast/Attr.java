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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;


/// Attr - This represents one attribute.
//<editor-fold defaultstate="collapsed" desc="clang::Attr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 45,
 FQN="clang::Attr", NM="_ZN5clang4AttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang4AttrE")
//</editor-fold>
public class Attr {
/*private:*/
  private SourceRange Range;
  private /*JCHAR unsigned int*/ char AttrKind /*: 16*/;
/*protected:*/
  /// An index into the spelling list of an
  /// attribute defined in Attr.td file.
  protected /*JBYTE unsigned int*/ byte SpellingListIndex /*: 4*/;
  protected /*JBIT unsigned int*/ boolean Inherited /*: 1*/;
  protected /*JBIT unsigned int*/ boolean IsPackExpansion /*: 1*/;
  protected /*JBIT unsigned int*/ boolean Implicit /*: 1*/;
  protected /*JBIT unsigned int*/ boolean IsLateParsed /*: 1*/;
  protected /*JBIT unsigned int*/ boolean DuplicatesAllowed /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 60,
   FQN="clang::Attr::operator new", NM="_ZN5clang4AttrnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang4AttrnwEj")
  //</editor-fold>
  protected static Object/*void P*/ $new(/*size_t*/int bytes) {
    throw new llvm_unreachable("Attrs cannot be allocated with regular 'new'.");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Attr::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 63,
   FQN="clang::Attr::operator delete", NM="_ZN5clang4AttrdlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang4AttrdlEPv")
  //</editor-fold>
  protected static void $delete(Object/*void P*/ data) {
    throw new llvm_unreachable("Attrs cannot be released with regular 'delete'.");
  }

/*public:*/
  // Forward so that the regular new and delete do not hide global ones.
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 69,
   FQN="clang::Attr::operator new", NM="_ZN5clang4AttrnwEjRNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang4AttrnwEjRNS_10ASTContextEj")
  //</editor-fold>
  public static Object/*void P*/ $new(/*size_t*/int Bytes, final ASTContext /*&*/ C) {
    return $new(Bytes, C, 
      8);
  }
  public static Object/*void P*/ $new(/*size_t*/int Bytes, final ASTContext /*&*/ C, 
      /*size_t*/int Alignment/*= 8*/) {
    return ASTContextGlobals./*::*/$new_uint_ASTContext$C_uint(Bytes, C, Alignment);
  }
  public static <T extends Attr> T $new(final ASTContext /*&*/ C, NativeCallback.New$ConstructorCallback<T> supplier) {
    return supplier.$call(null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Attr::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 73,
   FQN="clang::Attr::operator delete", NM="_ZN5clang4AttrdlEPvRNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang4AttrdlEPvRNS_10ASTContextEj")
  //</editor-fold>
  public static void $delete(Object/*void P*/ Ptr, final ASTContext /*&*/ C, 
         /*size_t*/int Alignment) {
    ASTContextGlobals./*::*/$delete_voidPtr_ASTContext$C_uint(Ptr, C, Alignment);
    return;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::Attr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 79,
   FQN="clang::Attr::Attr", NM="_ZN5clang4AttrC1ENS_4attr4KindENS_11SourceRangeEjbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang4AttrC1ENS_4attr4KindENS_11SourceRangeEjbb")
  //</editor-fold>
  protected Attr(attr.Kind AK, SourceRange R, /*uint*/int SpellingListIndex, 
      boolean IsLateParsed, boolean DuplicatesAllowed) {
    // : Range(R), AttrKind(AK), SpellingListIndex(SpellingListIndex), Inherited(false), IsPackExpansion(false), Implicit(false), IsLateParsed(IsLateParsed), DuplicatesAllowed(DuplicatesAllowed) 
    //START JInit
    this.Range = new SourceRange(R);
    this.AttrKind = $uint2uint_16bits(AK.getValue());
    this.SpellingListIndex = $uint2uint_4bits(SpellingListIndex);
    this.Inherited = false;
    this.IsPackExpansion = false;
    this.Implicit = false;
    this.IsLateParsed = IsLateParsed;
    this.DuplicatesAllowed = DuplicatesAllowed;
    //END JInit
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 87,
   FQN="clang::Attr::getKind", NM="_ZNK5clang4Attr7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang4Attr7getKindEv")
  //</editor-fold>
  public attr.Kind getKind() /*const*/ {
    return /*static_cast*/attr.Kind.valueOf(AttrKind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::getSpellingListIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 91,
   FQN="clang::Attr::getSpellingListIndex", NM="_ZNK5clang4Attr20getSpellingListIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang4Attr20getSpellingListIndexEv")
  //</editor-fold>
  public /*uint*/int getSpellingListIndex() /*const*/ {
    return SpellingListIndex;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Attr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 7039,
   FQN="clang::Attr::getSpelling", NM="_ZNK5clang4Attr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang4Attr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (getKind()) {
     case AMDGPUNumSGPR:
      return cast(AMDGPUNumSGPRAttr.class, this).getSpelling();
     case AMDGPUNumVGPR:
      return cast(AMDGPUNumVGPRAttr.class, this).getSpelling();
     case ARMInterrupt:
      return cast(ARMInterruptAttr.class, this).getSpelling();
     case AbiTag:
      return cast(AbiTagAttr.class, this).getSpelling();
     case AcquireCapability:
      return cast(AcquireCapabilityAttr.class, this).getSpelling();
     case AcquiredAfter:
      return cast(AcquiredAfterAttr.class, this).getSpelling();
     case AcquiredBefore:
      return cast(AcquiredBeforeAttr.class, this).getSpelling();
     case Alias:
      return cast(AliasAttr.class, this).getSpelling();
     case AlignMac68k:
      return cast(AlignMac68kAttr.class, this).getSpelling();
     case AlignValue:
      return cast(AlignValueAttr.class, this).getSpelling();
     case Aligned:
      return cast(AlignedAttr.class, this).getSpelling();
     case AlwaysInline:
      return cast(AlwaysInlineAttr.class, this).getSpelling();
     case AnalyzerNoReturn:
      return cast(AnalyzerNoReturnAttr.class, this).getSpelling();
     case Annotate:
      return cast(AnnotateAttr.class, this).getSpelling();
     case AnyX86Interrupt:
      return cast(AnyX86InterruptAttr.class, this).getSpelling();
     case ArcWeakrefUnavailable:
      return cast(ArcWeakrefUnavailableAttr.class, this).getSpelling();
     case ArgumentWithTypeTag:
      return cast(ArgumentWithTypeTagAttr.class, this).getSpelling();
     case AsmLabel:
      return cast(AsmLabelAttr.class, this).getSpelling();
     case AssertCapability:
      return cast(AssertCapabilityAttr.class, this).getSpelling();
     case AssertExclusiveLock:
      return cast(AssertExclusiveLockAttr.class, this).getSpelling();
     case AssertSharedLock:
      return cast(AssertSharedLockAttr.class, this).getSpelling();
     case AssumeAligned:
      return cast(AssumeAlignedAttr.class, this).getSpelling();
     case Availability:
      return cast(AvailabilityAttr.class, this).getSpelling();
     case Blocks:
      return cast(BlocksAttr.class, this).getSpelling();
     case C11NoReturn:
      return cast(C11NoReturnAttr.class, this).getSpelling();
     case CDecl:
      return cast(CDeclAttr.class, this).getSpelling();
     case CFAuditedTransfer:
      return cast(CFAuditedTransferAttr.class, this).getSpelling();
     case CFConsumed:
      return cast(CFConsumedAttr.class, this).getSpelling();
     case CFReturnsNotRetained:
      return cast(CFReturnsNotRetainedAttr.class, this).getSpelling();
     case CFReturnsRetained:
      return cast(CFReturnsRetainedAttr.class, this).getSpelling();
     case CFUnknownTransfer:
      return cast(CFUnknownTransferAttr.class, this).getSpelling();
     case CUDAConstant:
      return cast(CUDAConstantAttr.class, this).getSpelling();
     case CUDADevice:
      return cast(CUDADeviceAttr.class, this).getSpelling();
     case CUDAGlobal:
      return cast(CUDAGlobalAttr.class, this).getSpelling();
     case CUDAHost:
      return cast(CUDAHostAttr.class, this).getSpelling();
     case CUDAInvalidTarget:
      return cast(CUDAInvalidTargetAttr.class, this).getSpelling();
     case CUDALaunchBounds:
      return cast(CUDALaunchBoundsAttr.class, this).getSpelling();
     case CUDAShared:
      return cast(CUDASharedAttr.class, this).getSpelling();
     case CXX11NoReturn:
      return cast(CXX11NoReturnAttr.class, this).getSpelling();
     case CallableWhen:
      return cast(CallableWhenAttr.class, this).getSpelling();
     case Capability:
      return cast(CapabilityAttr.class, this).getSpelling();
     case CapturedRecord:
      return cast(CapturedRecordAttr.class, this).getSpelling();
     case CarriesDependency:
      return cast(CarriesDependencyAttr.class, this).getSpelling();
     case Cleanup:
      return cast(CleanupAttr.class, this).getSpelling();
     case Cold:
      return cast(ColdAttr.class, this).getSpelling();
     case Common:
      return cast(CommonAttr.class, this).getSpelling();
     case Const:
      return cast(ConstAttr.class, this).getSpelling();
     case Constructor:
      return cast(ConstructorAttr.class, this).getSpelling();
     case Consumable:
      return cast(ConsumableAttr.class, this).getSpelling();
     case ConsumableAutoCast:
      return cast(ConsumableAutoCastAttr.class, this).getSpelling();
     case ConsumableSetOnRead:
      return cast(ConsumableSetOnReadAttr.class, this).getSpelling();
     case DLLExport:
      return cast(DLLExportAttr.class, this).getSpelling();
     case DLLImport:
      return cast(DLLImportAttr.class, this).getSpelling();
     case Deprecated:
      return cast(DeprecatedAttr.class, this).getSpelling();
     case Destructor:
      return cast(DestructorAttr.class, this).getSpelling();
     case DisableTailCalls:
      return cast(DisableTailCallsAttr.class, this).getSpelling();
     case EmptyBases:
      return cast(EmptyBasesAttr.class, this).getSpelling();
     case EnableIf:
      return cast(EnableIfAttr.class, this).getSpelling();
     case ExclusiveTrylockFunction:
      return cast(ExclusiveTrylockFunctionAttr.class, this).getSpelling();
     case FallThrough:
      return cast(FallThroughAttr.class, this).getSpelling();
     case FastCall:
      return cast(FastCallAttr.class, this).getSpelling();
     case Final:
      return cast(FinalAttr.class, this).getSpelling();
     case FlagEnum:
      return cast(FlagEnumAttr.class, this).getSpelling();
     case Flatten:
      return cast(FlattenAttr.class, this).getSpelling();
     case Format:
      return cast(FormatAttr.class, this).getSpelling();
     case FormatArg:
      return cast(FormatArgAttr.class, this).getSpelling();
     case GNUInline:
      return cast(GNUInlineAttr.class, this).getSpelling();
     case GuardedBy:
      return cast(GuardedByAttr.class, this).getSpelling();
     case GuardedVar:
      return cast(GuardedVarAttr.class, this).getSpelling();
     case Hot:
      return cast(HotAttr.class, this).getSpelling();
     case IBAction:
      return cast(IBActionAttr.class, this).getSpelling();
     case IBOutlet:
      return cast(IBOutletAttr.class, this).getSpelling();
     case IBOutletCollection:
      return cast(IBOutletCollectionAttr.class, this).getSpelling();
     case IFunc:
      return cast(IFuncAttr.class, this).getSpelling();
     case InitPriority:
      return cast(InitPriorityAttr.class, this).getSpelling();
     case InitSeg:
      return cast(InitSegAttr.class, this).getSpelling();
     case IntelOclBicc:
      return cast(IntelOclBiccAttr.class, this).getSpelling();
     case InternalLinkage:
      return cast(InternalLinkageAttr.class, this).getSpelling();
     case LTOVisibilityPublic:
      return cast(LTOVisibilityPublicAttr.class, this).getSpelling();
     case LayoutVersion:
      return cast(LayoutVersionAttr.class, this).getSpelling();
     case LockReturned:
      return cast(LockReturnedAttr.class, this).getSpelling();
     case LocksExcluded:
      return cast(LocksExcludedAttr.class, this).getSpelling();
     case LoopHint:
      return cast(LoopHintAttr.class, this).getSpelling();
     case MSABI:
      return cast(MSABIAttr.class, this).getSpelling();
     case MSInheritance:
      return cast(MSInheritanceAttr.class, this).getSpelling();
     case MSNoVTable:
      return cast(MSNoVTableAttr.class, this).getSpelling();
     case MSP430Interrupt:
      return cast(MSP430InterruptAttr.class, this).getSpelling();
     case MSStruct:
      return cast(MSStructAttr.class, this).getSpelling();
     case MSVtorDisp:
      return cast(MSVtorDispAttr.class, this).getSpelling();
     case MaxFieldAlignment:
      return cast(MaxFieldAlignmentAttr.class, this).getSpelling();
     case MayAlias:
      return cast(MayAliasAttr.class, this).getSpelling();
     case MinSize:
      return cast(MinSizeAttr.class, this).getSpelling();
     case Mips16:
      return cast(Mips16Attr.class, this).getSpelling();
     case MipsInterrupt:
      return cast(MipsInterruptAttr.class, this).getSpelling();
     case Mode:
      return cast(ModeAttr.class, this).getSpelling();
     case NSConsumed:
      return cast(NSConsumedAttr.class, this).getSpelling();
     case NSConsumesSelf:
      return cast(NSConsumesSelfAttr.class, this).getSpelling();
     case NSReturnsAutoreleased:
      return cast(NSReturnsAutoreleasedAttr.class, this).getSpelling();
     case NSReturnsNotRetained:
      return cast(NSReturnsNotRetainedAttr.class, this).getSpelling();
     case NSReturnsRetained:
      return cast(NSReturnsRetainedAttr.class, this).getSpelling();
     case Naked:
      return cast(NakedAttr.class, this).getSpelling();
     case NoAlias:
      return cast(NoAliasAttr.class, this).getSpelling();
     case NoCommon:
      return cast(NoCommonAttr.class, this).getSpelling();
     case NoDebug:
      return cast(NoDebugAttr.class, this).getSpelling();
     case NoDuplicate:
      return cast(NoDuplicateAttr.class, this).getSpelling();
     case NoInline:
      return cast(NoInlineAttr.class, this).getSpelling();
     case NoInstrumentFunction:
      return cast(NoInstrumentFunctionAttr.class, this).getSpelling();
     case NoMips16:
      return cast(NoMips16Attr.class, this).getSpelling();
     case NoReturn:
      return cast(NoReturnAttr.class, this).getSpelling();
     case NoSanitize:
      return cast(NoSanitizeAttr.class, this).getSpelling();
     case NoSplitStack:
      return cast(NoSplitStackAttr.class, this).getSpelling();
     case NoThreadSafetyAnalysis:
      return cast(NoThreadSafetyAnalysisAttr.class, this).getSpelling();
     case NoThrow:
      return cast(NoThrowAttr.class, this).getSpelling();
     case NonNull:
      return cast(NonNullAttr.class, this).getSpelling();
     case NotTailCalled:
      return cast(NotTailCalledAttr.class, this).getSpelling();
     case OMPCaptureNoInit:
      return cast(OMPCaptureNoInitAttr.class, this).getSpelling();
     case OMPDeclareSimdDecl:
      return cast(OMPDeclareSimdDeclAttr.class, this).getSpelling();
     case OMPDeclareTargetDecl:
      return cast(OMPDeclareTargetDeclAttr.class, this).getSpelling();
     case OMPThreadPrivateDecl:
      return cast(OMPThreadPrivateDeclAttr.class, this).getSpelling();
     case ObjCBoxable:
      return cast(ObjCBoxableAttr.class, this).getSpelling();
     case ObjCBridge:
      return cast(ObjCBridgeAttr.class, this).getSpelling();
     case ObjCBridgeMutable:
      return cast(ObjCBridgeMutableAttr.class, this).getSpelling();
     case ObjCBridgeRelated:
      return cast(ObjCBridgeRelatedAttr.class, this).getSpelling();
     case ObjCDesignatedInitializer:
      return cast(ObjCDesignatedInitializerAttr.class, this).getSpelling();
     case ObjCException:
      return cast(ObjCExceptionAttr.class, this).getSpelling();
     case ObjCExplicitProtocolImpl:
      return cast(ObjCExplicitProtocolImplAttr.class, this).getSpelling();
     case ObjCIndependentClass:
      return cast(ObjCIndependentClassAttr.class, this).getSpelling();
     case ObjCMethodFamily:
      return cast(ObjCMethodFamilyAttr.class, this).getSpelling();
     case ObjCNSObject:
      return cast(ObjCNSObjectAttr.class, this).getSpelling();
     case ObjCPreciseLifetime:
      return cast(ObjCPreciseLifetimeAttr.class, this).getSpelling();
     case ObjCRequiresPropertyDefs:
      return cast(ObjCRequiresPropertyDefsAttr.class, this).getSpelling();
     case ObjCRequiresSuper:
      return cast(ObjCRequiresSuperAttr.class, this).getSpelling();
     case ObjCReturnsInnerPointer:
      return cast(ObjCReturnsInnerPointerAttr.class, this).getSpelling();
     case ObjCRootClass:
      return cast(ObjCRootClassAttr.class, this).getSpelling();
     case ObjCRuntimeName:
      return cast(ObjCRuntimeNameAttr.class, this).getSpelling();
     case ObjCRuntimeVisible:
      return cast(ObjCRuntimeVisibleAttr.class, this).getSpelling();
     case OpenCLAccess:
      return cast(OpenCLAccessAttr.class, this).getSpelling();
     case OpenCLKernel:
      return cast(OpenCLKernelAttr.class, this).getSpelling();
     case OpenCLUnrollHint:
      return cast(OpenCLUnrollHintAttr.class, this).getSpelling();
     case OptimizeNone:
      return cast(OptimizeNoneAttr.class, this).getSpelling();
     case Overloadable:
      return cast(OverloadableAttr.class, this).getSpelling();
     case Override:
      return cast(OverrideAttr.class, this).getSpelling();
     case Ownership:
      return cast(OwnershipAttr.class, this).getSpelling();
     case Packed:
      return cast(PackedAttr.class, this).getSpelling();
     case ParamTypestate:
      return cast(ParamTypestateAttr.class, this).getSpelling();
     case Pascal:
      return cast(PascalAttr.class, this).getSpelling();
     case PassObjectSize:
      return cast(PassObjectSizeAttr.class, this).getSpelling();
     case Pcs:
      return cast(PcsAttr.class, this).getSpelling();
     case PreserveAll:
      return cast(PreserveAllAttr.class, this).getSpelling();
     case PreserveMost:
      return cast(PreserveMostAttr.class, this).getSpelling();
     case PtGuardedBy:
      return cast(PtGuardedByAttr.class, this).getSpelling();
     case PtGuardedVar:
      return cast(PtGuardedVarAttr.class, this).getSpelling();
     case Pure:
      return cast(PureAttr.class, this).getSpelling();
     case ReleaseCapability:
      return cast(ReleaseCapabilityAttr.class, this).getSpelling();
     case RenderScriptKernel:
      return cast(RenderScriptKernelAttr.class, this).getSpelling();
     case ReqdWorkGroupSize:
      return cast(ReqdWorkGroupSizeAttr.class, this).getSpelling();
     case RequiresCapability:
      return cast(RequiresCapabilityAttr.class, this).getSpelling();
     case Restrict:
      return cast(RestrictAttr.class, this).getSpelling();
     case ReturnTypestate:
      return cast(ReturnTypestateAttr.class, this).getSpelling();
     case ReturnsNonNull:
      return cast(ReturnsNonNullAttr.class, this).getSpelling();
     case ReturnsTwice:
      return cast(ReturnsTwiceAttr.class, this).getSpelling();
     case ScopedLockable:
      return cast(ScopedLockableAttr.class, this).getSpelling();
     case Section:
      return cast(SectionAttr.class, this).getSpelling();
     case SelectAny:
      return cast(SelectAnyAttr.class, this).getSpelling();
     case Sentinel:
      return cast(SentinelAttr.class, this).getSpelling();
     case SetTypestate:
      return cast(SetTypestateAttr.class, this).getSpelling();
     case SharedTrylockFunction:
      return cast(SharedTrylockFunctionAttr.class, this).getSpelling();
     case StdCall:
      return cast(StdCallAttr.class, this).getSpelling();
     case SwiftCall:
      return cast(SwiftCallAttr.class, this).getSpelling();
     case SwiftContext:
      return cast(SwiftContextAttr.class, this).getSpelling();
     case SwiftErrorResult:
      return cast(SwiftErrorResultAttr.class, this).getSpelling();
     case SwiftIndirectResult:
      return cast(SwiftIndirectResultAttr.class, this).getSpelling();
     case SysVABI:
      return cast(SysVABIAttr.class, this).getSpelling();
     case TLSModel:
      return cast(TLSModelAttr.class, this).getSpelling();
     case Target:
      return cast(TargetAttr.class, this).getSpelling();
     case TestTypestate:
      return cast(TestTypestateAttr.class, this).getSpelling();
     case ThisCall:
      return cast(ThisCallAttr.class, this).getSpelling();
     case Thread:
      return cast(ThreadAttr.class, this).getSpelling();
     case TransparentUnion:
      return cast(TransparentUnionAttr.class, this).getSpelling();
     case TryAcquireCapability:
      return cast(TryAcquireCapabilityAttr.class, this).getSpelling();
     case TypeTagForDatatype:
      return cast(TypeTagForDatatypeAttr.class, this).getSpelling();
     case TypeVisibility:
      return cast(TypeVisibilityAttr.class, this).getSpelling();
     case Unavailable:
      return cast(UnavailableAttr.class, this).getSpelling();
     case Unused:
      return cast(UnusedAttr.class, this).getSpelling();
     case Used:
      return cast(UsedAttr.class, this).getSpelling();
     case Uuid:
      return cast(UuidAttr.class, this).getSpelling();
     case VecReturn:
      return cast(VecReturnAttr.class, this).getSpelling();
     case VecTypeHint:
      return cast(VecTypeHintAttr.class, this).getSpelling();
     case VectorCall:
      return cast(VectorCallAttr.class, this).getSpelling();
     case Visibility:
      return cast(VisibilityAttr.class, this).getSpelling();
     case WarnUnused:
      return cast(WarnUnusedAttr.class, this).getSpelling();
     case WarnUnusedResult:
      return cast(WarnUnusedResultAttr.class, this).getSpelling();
     case Weak:
      return cast(WeakAttr.class, this).getSpelling();
     case WeakImport:
      return cast(WeakImportAttr.class, this).getSpelling();
     case WeakRef:
      return cast(WeakRefAttr.class, this).getSpelling();
     case WorkGroupSizeHint:
      return cast(WorkGroupSizeHintAttr.class, this).getSpelling();
     case X86ForceAlignArgPointer:
      return cast(X86ForceAlignArgPointerAttr.class, this).getSpelling();
     case XRayInstrument:
      return cast(XRayInstrumentAttr.class, this).getSpelling();
    }
    throw new llvm_unreachable("Unexpected attribute kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 94,
   FQN="clang::Attr::getLocation", NM="_ZNK5clang4Attr11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang4Attr11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Attr::getRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 95,
   FQN="clang::Attr::getRange", NM="_ZNK5clang4Attr8getRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang4Attr8getRangeEv")
  //</editor-fold>
  public SourceRange getRange() /*const*/ {
    return new SourceRange(Range);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Attr::setRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 96,
   FQN="clang::Attr::setRange", NM="_ZN5clang4Attr8setRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang4Attr8setRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setRange(SourceRange R) {
    Range.$assign(R);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::isInherited">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 98,
   FQN="clang::Attr::isInherited", NM="_ZNK5clang4Attr11isInheritedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang4Attr11isInheritedEv")
  //</editor-fold>
  public boolean isInherited() /*const*/ {
    return Inherited;
  }

  
  /// \brief Returns true if the attribute has been implicitly created instead
  /// of explicitly written by the user.
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::isImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 102,
   FQN="clang::Attr::isImplicit", NM="_ZNK5clang4Attr10isImplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang4Attr10isImplicitEv")
  //</editor-fold>
  public boolean isImplicit() /*const*/ {
    return Implicit;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Attr::setImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 103,
   FQN="clang::Attr::setImplicit", NM="_ZN5clang4Attr11setImplicitEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang4Attr11setImplicitEb")
  //</editor-fold>
  public void setImplicit(boolean I) {
    Implicit = I;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::setPackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 105,
   FQN="clang::Attr::setPackExpansion", NM="_ZN5clang4Attr16setPackExpansionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang4Attr16setPackExpansionEb")
  //</editor-fold>
  public void setPackExpansion(boolean PE) {
    IsPackExpansion = PE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Attr::isPackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 106,
   FQN="clang::Attr::isPackExpansion", NM="_ZNK5clang4Attr15isPackExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang4Attr15isPackExpansionEv")
  //</editor-fold>
  public boolean isPackExpansion() /*const*/ {
    return IsPackExpansion;
  }

  
  // Clone this attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 7441,
   FQN="clang::Attr::clone", NM="_ZNK5clang4Attr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang4Attr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public Attr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    switch (getKind()) {
     case AMDGPUNumSGPR:
      return cast(AMDGPUNumSGPRAttr.class, this).clone(C);
     case AMDGPUNumVGPR:
      return cast(AMDGPUNumVGPRAttr.class, this).clone(C);
     case ARMInterrupt:
      return cast(ARMInterruptAttr.class, this).clone(C);
     case AbiTag:
      return cast(AbiTagAttr.class, this).clone(C);
     case AcquireCapability:
      return cast(AcquireCapabilityAttr.class, this).clone(C);
     case AcquiredAfter:
      return cast(AcquiredAfterAttr.class, this).clone(C);
     case AcquiredBefore:
      return cast(AcquiredBeforeAttr.class, this).clone(C);
     case Alias:
      return cast(AliasAttr.class, this).clone(C);
     case AlignMac68k:
      return cast(AlignMac68kAttr.class, this).clone(C);
     case AlignValue:
      return cast(AlignValueAttr.class, this).clone(C);
     case Aligned:
      return cast(AlignedAttr.class, this).clone(C);
     case AlwaysInline:
      return cast(AlwaysInlineAttr.class, this).clone(C);
     case AnalyzerNoReturn:
      return cast(AnalyzerNoReturnAttr.class, this).clone(C);
     case Annotate:
      return cast(AnnotateAttr.class, this).clone(C);
     case AnyX86Interrupt:
      return cast(AnyX86InterruptAttr.class, this).clone(C);
     case ArcWeakrefUnavailable:
      return cast(ArcWeakrefUnavailableAttr.class, this).clone(C);
     case ArgumentWithTypeTag:
      return cast(ArgumentWithTypeTagAttr.class, this).clone(C);
     case AsmLabel:
      return cast(AsmLabelAttr.class, this).clone(C);
     case AssertCapability:
      return cast(AssertCapabilityAttr.class, this).clone(C);
     case AssertExclusiveLock:
      return cast(AssertExclusiveLockAttr.class, this).clone(C);
     case AssertSharedLock:
      return cast(AssertSharedLockAttr.class, this).clone(C);
     case AssumeAligned:
      return cast(AssumeAlignedAttr.class, this).clone(C);
     case Availability:
      return cast(AvailabilityAttr.class, this).clone(C);
     case Blocks:
      return cast(BlocksAttr.class, this).clone(C);
     case C11NoReturn:
      return cast(C11NoReturnAttr.class, this).clone(C);
     case CDecl:
      return cast(CDeclAttr.class, this).clone(C);
     case CFAuditedTransfer:
      return cast(CFAuditedTransferAttr.class, this).clone(C);
     case CFConsumed:
      return cast(CFConsumedAttr.class, this).clone(C);
     case CFReturnsNotRetained:
      return cast(CFReturnsNotRetainedAttr.class, this).clone(C);
     case CFReturnsRetained:
      return cast(CFReturnsRetainedAttr.class, this).clone(C);
     case CFUnknownTransfer:
      return cast(CFUnknownTransferAttr.class, this).clone(C);
     case CUDAConstant:
      return cast(CUDAConstantAttr.class, this).clone(C);
     case CUDADevice:
      return cast(CUDADeviceAttr.class, this).clone(C);
     case CUDAGlobal:
      return cast(CUDAGlobalAttr.class, this).clone(C);
     case CUDAHost:
      return cast(CUDAHostAttr.class, this).clone(C);
     case CUDAInvalidTarget:
      return cast(CUDAInvalidTargetAttr.class, this).clone(C);
     case CUDALaunchBounds:
      return cast(CUDALaunchBoundsAttr.class, this).clone(C);
     case CUDAShared:
      return cast(CUDASharedAttr.class, this).clone(C);
     case CXX11NoReturn:
      return cast(CXX11NoReturnAttr.class, this).clone(C);
     case CallableWhen:
      return cast(CallableWhenAttr.class, this).clone(C);
     case Capability:
      return cast(CapabilityAttr.class, this).clone(C);
     case CapturedRecord:
      return cast(CapturedRecordAttr.class, this).clone(C);
     case CarriesDependency:
      return cast(CarriesDependencyAttr.class, this).clone(C);
     case Cleanup:
      return cast(CleanupAttr.class, this).clone(C);
     case Cold:
      return cast(ColdAttr.class, this).clone(C);
     case Common:
      return cast(CommonAttr.class, this).clone(C);
     case Const:
      return cast(ConstAttr.class, this).clone(C);
     case Constructor:
      return cast(ConstructorAttr.class, this).clone(C);
     case Consumable:
      return cast(ConsumableAttr.class, this).clone(C);
     case ConsumableAutoCast:
      return cast(ConsumableAutoCastAttr.class, this).clone(C);
     case ConsumableSetOnRead:
      return cast(ConsumableSetOnReadAttr.class, this).clone(C);
     case DLLExport:
      return cast(DLLExportAttr.class, this).clone(C);
     case DLLImport:
      return cast(DLLImportAttr.class, this).clone(C);
     case Deprecated:
      return cast(DeprecatedAttr.class, this).clone(C);
     case Destructor:
      return cast(DestructorAttr.class, this).clone(C);
     case DisableTailCalls:
      return cast(DisableTailCallsAttr.class, this).clone(C);
     case EmptyBases:
      return cast(EmptyBasesAttr.class, this).clone(C);
     case EnableIf:
      return cast(EnableIfAttr.class, this).clone(C);
     case ExclusiveTrylockFunction:
      return cast(ExclusiveTrylockFunctionAttr.class, this).clone(C);
     case FallThrough:
      return cast(FallThroughAttr.class, this).clone(C);
     case FastCall:
      return cast(FastCallAttr.class, this).clone(C);
     case Final:
      return cast(FinalAttr.class, this).clone(C);
     case FlagEnum:
      return cast(FlagEnumAttr.class, this).clone(C);
     case Flatten:
      return cast(FlattenAttr.class, this).clone(C);
     case Format:
      return cast(FormatAttr.class, this).clone(C);
     case FormatArg:
      return cast(FormatArgAttr.class, this).clone(C);
     case GNUInline:
      return cast(GNUInlineAttr.class, this).clone(C);
     case GuardedBy:
      return cast(GuardedByAttr.class, this).clone(C);
     case GuardedVar:
      return cast(GuardedVarAttr.class, this).clone(C);
     case Hot:
      return cast(HotAttr.class, this).clone(C);
     case IBAction:
      return cast(IBActionAttr.class, this).clone(C);
     case IBOutlet:
      return cast(IBOutletAttr.class, this).clone(C);
     case IBOutletCollection:
      return cast(IBOutletCollectionAttr.class, this).clone(C);
     case IFunc:
      return cast(IFuncAttr.class, this).clone(C);
     case InitPriority:
      return cast(InitPriorityAttr.class, this).clone(C);
     case InitSeg:
      return cast(InitSegAttr.class, this).clone(C);
     case IntelOclBicc:
      return cast(IntelOclBiccAttr.class, this).clone(C);
     case InternalLinkage:
      return cast(InternalLinkageAttr.class, this).clone(C);
     case LTOVisibilityPublic:
      return cast(LTOVisibilityPublicAttr.class, this).clone(C);
     case LayoutVersion:
      return cast(LayoutVersionAttr.class, this).clone(C);
     case LockReturned:
      return cast(LockReturnedAttr.class, this).clone(C);
     case LocksExcluded:
      return cast(LocksExcludedAttr.class, this).clone(C);
     case LoopHint:
      return cast(LoopHintAttr.class, this).clone(C);
     case MSABI:
      return cast(MSABIAttr.class, this).clone(C);
     case MSInheritance:
      return cast(MSInheritanceAttr.class, this).clone(C);
     case MSNoVTable:
      return cast(MSNoVTableAttr.class, this).clone(C);
     case MSP430Interrupt:
      return cast(MSP430InterruptAttr.class, this).clone(C);
     case MSStruct:
      return cast(MSStructAttr.class, this).clone(C);
     case MSVtorDisp:
      return cast(MSVtorDispAttr.class, this).clone(C);
     case MaxFieldAlignment:
      return cast(MaxFieldAlignmentAttr.class, this).clone(C);
     case MayAlias:
      return cast(MayAliasAttr.class, this).clone(C);
     case MinSize:
      return cast(MinSizeAttr.class, this).clone(C);
     case Mips16:
      return cast(Mips16Attr.class, this).clone(C);
     case MipsInterrupt:
      return cast(MipsInterruptAttr.class, this).clone(C);
     case Mode:
      return cast(ModeAttr.class, this).clone(C);
     case NSConsumed:
      return cast(NSConsumedAttr.class, this).clone(C);
     case NSConsumesSelf:
      return cast(NSConsumesSelfAttr.class, this).clone(C);
     case NSReturnsAutoreleased:
      return cast(NSReturnsAutoreleasedAttr.class, this).clone(C);
     case NSReturnsNotRetained:
      return cast(NSReturnsNotRetainedAttr.class, this).clone(C);
     case NSReturnsRetained:
      return cast(NSReturnsRetainedAttr.class, this).clone(C);
     case Naked:
      return cast(NakedAttr.class, this).clone(C);
     case NoAlias:
      return cast(NoAliasAttr.class, this).clone(C);
     case NoCommon:
      return cast(NoCommonAttr.class, this).clone(C);
     case NoDebug:
      return cast(NoDebugAttr.class, this).clone(C);
     case NoDuplicate:
      return cast(NoDuplicateAttr.class, this).clone(C);
     case NoInline:
      return cast(NoInlineAttr.class, this).clone(C);
     case NoInstrumentFunction:
      return cast(NoInstrumentFunctionAttr.class, this).clone(C);
     case NoMips16:
      return cast(NoMips16Attr.class, this).clone(C);
     case NoReturn:
      return cast(NoReturnAttr.class, this).clone(C);
     case NoSanitize:
      return cast(NoSanitizeAttr.class, this).clone(C);
     case NoSplitStack:
      return cast(NoSplitStackAttr.class, this).clone(C);
     case NoThreadSafetyAnalysis:
      return cast(NoThreadSafetyAnalysisAttr.class, this).clone(C);
     case NoThrow:
      return cast(NoThrowAttr.class, this).clone(C);
     case NonNull:
      return cast(NonNullAttr.class, this).clone(C);
     case NotTailCalled:
      return cast(NotTailCalledAttr.class, this).clone(C);
     case OMPCaptureNoInit:
      return cast(OMPCaptureNoInitAttr.class, this).clone(C);
     case OMPDeclareSimdDecl:
      return cast(OMPDeclareSimdDeclAttr.class, this).clone(C);
     case OMPDeclareTargetDecl:
      return cast(OMPDeclareTargetDeclAttr.class, this).clone(C);
     case OMPThreadPrivateDecl:
      return cast(OMPThreadPrivateDeclAttr.class, this).clone(C);
     case ObjCBoxable:
      return cast(ObjCBoxableAttr.class, this).clone(C);
     case ObjCBridge:
      return cast(ObjCBridgeAttr.class, this).clone(C);
     case ObjCBridgeMutable:
      return cast(ObjCBridgeMutableAttr.class, this).clone(C);
     case ObjCBridgeRelated:
      return cast(ObjCBridgeRelatedAttr.class, this).clone(C);
     case ObjCDesignatedInitializer:
      return cast(ObjCDesignatedInitializerAttr.class, this).clone(C);
     case ObjCException:
      return cast(ObjCExceptionAttr.class, this).clone(C);
     case ObjCExplicitProtocolImpl:
      return cast(ObjCExplicitProtocolImplAttr.class, this).clone(C);
     case ObjCIndependentClass:
      return cast(ObjCIndependentClassAttr.class, this).clone(C);
     case ObjCMethodFamily:
      return cast(ObjCMethodFamilyAttr.class, this).clone(C);
     case ObjCNSObject:
      return cast(ObjCNSObjectAttr.class, this).clone(C);
     case ObjCPreciseLifetime:
      return cast(ObjCPreciseLifetimeAttr.class, this).clone(C);
     case ObjCRequiresPropertyDefs:
      return cast(ObjCRequiresPropertyDefsAttr.class, this).clone(C);
     case ObjCRequiresSuper:
      return cast(ObjCRequiresSuperAttr.class, this).clone(C);
     case ObjCReturnsInnerPointer:
      return cast(ObjCReturnsInnerPointerAttr.class, this).clone(C);
     case ObjCRootClass:
      return cast(ObjCRootClassAttr.class, this).clone(C);
     case ObjCRuntimeName:
      return cast(ObjCRuntimeNameAttr.class, this).clone(C);
     case ObjCRuntimeVisible:
      return cast(ObjCRuntimeVisibleAttr.class, this).clone(C);
     case OpenCLAccess:
      return cast(OpenCLAccessAttr.class, this).clone(C);
     case OpenCLKernel:
      return cast(OpenCLKernelAttr.class, this).clone(C);
     case OpenCLUnrollHint:
      return cast(OpenCLUnrollHintAttr.class, this).clone(C);
     case OptimizeNone:
      return cast(OptimizeNoneAttr.class, this).clone(C);
     case Overloadable:
      return cast(OverloadableAttr.class, this).clone(C);
     case Override:
      return cast(OverrideAttr.class, this).clone(C);
     case Ownership:
      return cast(OwnershipAttr.class, this).clone(C);
     case Packed:
      return cast(PackedAttr.class, this).clone(C);
     case ParamTypestate:
      return cast(ParamTypestateAttr.class, this).clone(C);
     case Pascal:
      return cast(PascalAttr.class, this).clone(C);
     case PassObjectSize:
      return cast(PassObjectSizeAttr.class, this).clone(C);
     case Pcs:
      return cast(PcsAttr.class, this).clone(C);
     case PreserveAll:
      return cast(PreserveAllAttr.class, this).clone(C);
     case PreserveMost:
      return cast(PreserveMostAttr.class, this).clone(C);
     case PtGuardedBy:
      return cast(PtGuardedByAttr.class, this).clone(C);
     case PtGuardedVar:
      return cast(PtGuardedVarAttr.class, this).clone(C);
     case Pure:
      return cast(PureAttr.class, this).clone(C);
     case ReleaseCapability:
      return cast(ReleaseCapabilityAttr.class, this).clone(C);
     case RenderScriptKernel:
      return cast(RenderScriptKernelAttr.class, this).clone(C);
     case ReqdWorkGroupSize:
      return cast(ReqdWorkGroupSizeAttr.class, this).clone(C);
     case RequiresCapability:
      return cast(RequiresCapabilityAttr.class, this).clone(C);
     case Restrict:
      return cast(RestrictAttr.class, this).clone(C);
     case ReturnTypestate:
      return cast(ReturnTypestateAttr.class, this).clone(C);
     case ReturnsNonNull:
      return cast(ReturnsNonNullAttr.class, this).clone(C);
     case ReturnsTwice:
      return cast(ReturnsTwiceAttr.class, this).clone(C);
     case ScopedLockable:
      return cast(ScopedLockableAttr.class, this).clone(C);
     case Section:
      return cast(SectionAttr.class, this).clone(C);
     case SelectAny:
      return cast(SelectAnyAttr.class, this).clone(C);
     case Sentinel:
      return cast(SentinelAttr.class, this).clone(C);
     case SetTypestate:
      return cast(SetTypestateAttr.class, this).clone(C);
     case SharedTrylockFunction:
      return cast(SharedTrylockFunctionAttr.class, this).clone(C);
     case StdCall:
      return cast(StdCallAttr.class, this).clone(C);
     case SwiftCall:
      return cast(SwiftCallAttr.class, this).clone(C);
     case SwiftContext:
      return cast(SwiftContextAttr.class, this).clone(C);
     case SwiftErrorResult:
      return cast(SwiftErrorResultAttr.class, this).clone(C);
     case SwiftIndirectResult:
      return cast(SwiftIndirectResultAttr.class, this).clone(C);
     case SysVABI:
      return cast(SysVABIAttr.class, this).clone(C);
     case TLSModel:
      return cast(TLSModelAttr.class, this).clone(C);
     case Target:
      return cast(TargetAttr.class, this).clone(C);
     case TestTypestate:
      return cast(TestTypestateAttr.class, this).clone(C);
     case ThisCall:
      return cast(ThisCallAttr.class, this).clone(C);
     case Thread:
      return cast(ThreadAttr.class, this).clone(C);
     case TransparentUnion:
      return cast(TransparentUnionAttr.class, this).clone(C);
     case TryAcquireCapability:
      return cast(TryAcquireCapabilityAttr.class, this).clone(C);
     case TypeTagForDatatype:
      return cast(TypeTagForDatatypeAttr.class, this).clone(C);
     case TypeVisibility:
      return cast(TypeVisibilityAttr.class, this).clone(C);
     case Unavailable:
      return cast(UnavailableAttr.class, this).clone(C);
     case Unused:
      return cast(UnusedAttr.class, this).clone(C);
     case Used:
      return cast(UsedAttr.class, this).clone(C);
     case Uuid:
      return cast(UuidAttr.class, this).clone(C);
     case VecReturn:
      return cast(VecReturnAttr.class, this).clone(C);
     case VecTypeHint:
      return cast(VecTypeHintAttr.class, this).clone(C);
     case VectorCall:
      return cast(VectorCallAttr.class, this).clone(C);
     case Visibility:
      return cast(VisibilityAttr.class, this).clone(C);
     case WarnUnused:
      return cast(WarnUnusedAttr.class, this).clone(C);
     case WarnUnusedResult:
      return cast(WarnUnusedResultAttr.class, this).clone(C);
     case Weak:
      return cast(WeakAttr.class, this).clone(C);
     case WeakImport:
      return cast(WeakImportAttr.class, this).clone(C);
     case WeakRef:
      return cast(WeakRefAttr.class, this).clone(C);
     case WorkGroupSizeHint:
      return cast(WorkGroupSizeHintAttr.class, this).clone(C);
     case X86ForceAlignArgPointer:
      return cast(X86ForceAlignArgPointerAttr.class, this).clone(C);
     case XRayInstrument:
      return cast(XRayInstrumentAttr.class, this).clone(C);
    }
    throw new llvm_unreachable("Unexpected attribute kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::isLateParsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 111,
   FQN="clang::Attr::isLateParsed", NM="_ZNK5clang4Attr12isLateParsedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang4Attr12isLateParsedEv")
  //</editor-fold>
  public boolean isLateParsed() /*const*/ {
    return IsLateParsed;
  }

  
  // Pretty print this attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 7843,
   FQN="clang::Attr::printPretty", NM="_ZNK5clang4Attr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang4Attr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (getKind()) {
     case AMDGPUNumSGPR:
      cast(AMDGPUNumSGPRAttr.class, this).printPretty(OS, Policy);
      return;
     case AMDGPUNumVGPR:
      cast(AMDGPUNumVGPRAttr.class, this).printPretty(OS, Policy);
      return;
     case ARMInterrupt:
      cast(ARMInterruptAttr.class, this).printPretty(OS, Policy);
      return;
     case AbiTag:
      cast(AbiTagAttr.class, this).printPretty(OS, Policy);
      return;
     case AcquireCapability:
      cast(AcquireCapabilityAttr.class, this).printPretty(OS, Policy);
      return;
     case AcquiredAfter:
      cast(AcquiredAfterAttr.class, this).printPretty(OS, Policy);
      return;
     case AcquiredBefore:
      cast(AcquiredBeforeAttr.class, this).printPretty(OS, Policy);
      return;
     case Alias:
      cast(AliasAttr.class, this).printPretty(OS, Policy);
      return;
     case AlignMac68k:
      cast(AlignMac68kAttr.class, this).printPretty(OS, Policy);
      return;
     case AlignValue:
      cast(AlignValueAttr.class, this).printPretty(OS, Policy);
      return;
     case Aligned:
      cast(AlignedAttr.class, this).printPretty(OS, Policy);
      return;
     case AlwaysInline:
      cast(AlwaysInlineAttr.class, this).printPretty(OS, Policy);
      return;
     case AnalyzerNoReturn:
      cast(AnalyzerNoReturnAttr.class, this).printPretty(OS, Policy);
      return;
     case Annotate:
      cast(AnnotateAttr.class, this).printPretty(OS, Policy);
      return;
     case AnyX86Interrupt:
      cast(AnyX86InterruptAttr.class, this).printPretty(OS, Policy);
      return;
     case ArcWeakrefUnavailable:
      cast(ArcWeakrefUnavailableAttr.class, this).printPretty(OS, Policy);
      return;
     case ArgumentWithTypeTag:
      cast(ArgumentWithTypeTagAttr.class, this).printPretty(OS, Policy);
      return;
     case AsmLabel:
      cast(AsmLabelAttr.class, this).printPretty(OS, Policy);
      return;
     case AssertCapability:
      cast(AssertCapabilityAttr.class, this).printPretty(OS, Policy);
      return;
     case AssertExclusiveLock:
      cast(AssertExclusiveLockAttr.class, this).printPretty(OS, Policy);
      return;
     case AssertSharedLock:
      cast(AssertSharedLockAttr.class, this).printPretty(OS, Policy);
      return;
     case AssumeAligned:
      cast(AssumeAlignedAttr.class, this).printPretty(OS, Policy);
      return;
     case Availability:
      cast(AvailabilityAttr.class, this).printPretty(OS, Policy);
      return;
     case Blocks:
      cast(BlocksAttr.class, this).printPretty(OS, Policy);
      return;
     case C11NoReturn:
      cast(C11NoReturnAttr.class, this).printPretty(OS, Policy);
      return;
     case CDecl:
      cast(CDeclAttr.class, this).printPretty(OS, Policy);
      return;
     case CFAuditedTransfer:
      cast(CFAuditedTransferAttr.class, this).printPretty(OS, Policy);
      return;
     case CFConsumed:
      cast(CFConsumedAttr.class, this).printPretty(OS, Policy);
      return;
     case CFReturnsNotRetained:
      cast(CFReturnsNotRetainedAttr.class, this).printPretty(OS, Policy);
      return;
     case CFReturnsRetained:
      cast(CFReturnsRetainedAttr.class, this).printPretty(OS, Policy);
      return;
     case CFUnknownTransfer:
      cast(CFUnknownTransferAttr.class, this).printPretty(OS, Policy);
      return;
     case CUDAConstant:
      cast(CUDAConstantAttr.class, this).printPretty(OS, Policy);
      return;
     case CUDADevice:
      cast(CUDADeviceAttr.class, this).printPretty(OS, Policy);
      return;
     case CUDAGlobal:
      cast(CUDAGlobalAttr.class, this).printPretty(OS, Policy);
      return;
     case CUDAHost:
      cast(CUDAHostAttr.class, this).printPretty(OS, Policy);
      return;
     case CUDAInvalidTarget:
      cast(CUDAInvalidTargetAttr.class, this).printPretty(OS, Policy);
      return;
     case CUDALaunchBounds:
      cast(CUDALaunchBoundsAttr.class, this).printPretty(OS, Policy);
      return;
     case CUDAShared:
      cast(CUDASharedAttr.class, this).printPretty(OS, Policy);
      return;
     case CXX11NoReturn:
      cast(CXX11NoReturnAttr.class, this).printPretty(OS, Policy);
      return;
     case CallableWhen:
      cast(CallableWhenAttr.class, this).printPretty(OS, Policy);
      return;
     case Capability:
      cast(CapabilityAttr.class, this).printPretty(OS, Policy);
      return;
     case CapturedRecord:
      cast(CapturedRecordAttr.class, this).printPretty(OS, Policy);
      return;
     case CarriesDependency:
      cast(CarriesDependencyAttr.class, this).printPretty(OS, Policy);
      return;
     case Cleanup:
      cast(CleanupAttr.class, this).printPretty(OS, Policy);
      return;
     case Cold:
      cast(ColdAttr.class, this).printPretty(OS, Policy);
      return;
     case Common:
      cast(CommonAttr.class, this).printPretty(OS, Policy);
      return;
     case Const:
      cast(ConstAttr.class, this).printPretty(OS, Policy);
      return;
     case Constructor:
      cast(ConstructorAttr.class, this).printPretty(OS, Policy);
      return;
     case Consumable:
      cast(ConsumableAttr.class, this).printPretty(OS, Policy);
      return;
     case ConsumableAutoCast:
      cast(ConsumableAutoCastAttr.class, this).printPretty(OS, Policy);
      return;
     case ConsumableSetOnRead:
      cast(ConsumableSetOnReadAttr.class, this).printPretty(OS, Policy);
      return;
     case DLLExport:
      cast(DLLExportAttr.class, this).printPretty(OS, Policy);
      return;
     case DLLImport:
      cast(DLLImportAttr.class, this).printPretty(OS, Policy);
      return;
     case Deprecated:
      cast(DeprecatedAttr.class, this).printPretty(OS, Policy);
      return;
     case Destructor:
      cast(DestructorAttr.class, this).printPretty(OS, Policy);
      return;
     case DisableTailCalls:
      cast(DisableTailCallsAttr.class, this).printPretty(OS, Policy);
      return;
     case EmptyBases:
      cast(EmptyBasesAttr.class, this).printPretty(OS, Policy);
      return;
     case EnableIf:
      cast(EnableIfAttr.class, this).printPretty(OS, Policy);
      return;
     case ExclusiveTrylockFunction:
      cast(ExclusiveTrylockFunctionAttr.class, this).printPretty(OS, Policy);
      return;
     case FallThrough:
      cast(FallThroughAttr.class, this).printPretty(OS, Policy);
      return;
     case FastCall:
      cast(FastCallAttr.class, this).printPretty(OS, Policy);
      return;
     case Final:
      cast(FinalAttr.class, this).printPretty(OS, Policy);
      return;
     case FlagEnum:
      cast(FlagEnumAttr.class, this).printPretty(OS, Policy);
      return;
     case Flatten:
      cast(FlattenAttr.class, this).printPretty(OS, Policy);
      return;
     case Format:
      cast(FormatAttr.class, this).printPretty(OS, Policy);
      return;
     case FormatArg:
      cast(FormatArgAttr.class, this).printPretty(OS, Policy);
      return;
     case GNUInline:
      cast(GNUInlineAttr.class, this).printPretty(OS, Policy);
      return;
     case GuardedBy:
      cast(GuardedByAttr.class, this).printPretty(OS, Policy);
      return;
     case GuardedVar:
      cast(GuardedVarAttr.class, this).printPretty(OS, Policy);
      return;
     case Hot:
      cast(HotAttr.class, this).printPretty(OS, Policy);
      return;
     case IBAction:
      cast(IBActionAttr.class, this).printPretty(OS, Policy);
      return;
     case IBOutlet:
      cast(IBOutletAttr.class, this).printPretty(OS, Policy);
      return;
     case IBOutletCollection:
      cast(IBOutletCollectionAttr.class, this).printPretty(OS, Policy);
      return;
     case IFunc:
      cast(IFuncAttr.class, this).printPretty(OS, Policy);
      return;
     case InitPriority:
      cast(InitPriorityAttr.class, this).printPretty(OS, Policy);
      return;
     case InitSeg:
      cast(InitSegAttr.class, this).printPretty(OS, Policy);
      return;
     case IntelOclBicc:
      cast(IntelOclBiccAttr.class, this).printPretty(OS, Policy);
      return;
     case InternalLinkage:
      cast(InternalLinkageAttr.class, this).printPretty(OS, Policy);
      return;
     case LTOVisibilityPublic:
      cast(LTOVisibilityPublicAttr.class, this).printPretty(OS, Policy);
      return;
     case LayoutVersion:
      cast(LayoutVersionAttr.class, this).printPretty(OS, Policy);
      return;
     case LockReturned:
      cast(LockReturnedAttr.class, this).printPretty(OS, Policy);
      return;
     case LocksExcluded:
      cast(LocksExcludedAttr.class, this).printPretty(OS, Policy);
      return;
     case LoopHint:
      cast(LoopHintAttr.class, this).printPretty(OS, Policy);
      return;
     case MSABI:
      cast(MSABIAttr.class, this).printPretty(OS, Policy);
      return;
     case MSInheritance:
      cast(MSInheritanceAttr.class, this).printPretty(OS, Policy);
      return;
     case MSNoVTable:
      cast(MSNoVTableAttr.class, this).printPretty(OS, Policy);
      return;
     case MSP430Interrupt:
      cast(MSP430InterruptAttr.class, this).printPretty(OS, Policy);
      return;
     case MSStruct:
      cast(MSStructAttr.class, this).printPretty(OS, Policy);
      return;
     case MSVtorDisp:
      cast(MSVtorDispAttr.class, this).printPretty(OS, Policy);
      return;
     case MaxFieldAlignment:
      cast(MaxFieldAlignmentAttr.class, this).printPretty(OS, Policy);
      return;
     case MayAlias:
      cast(MayAliasAttr.class, this).printPretty(OS, Policy);
      return;
     case MinSize:
      cast(MinSizeAttr.class, this).printPretty(OS, Policy);
      return;
     case Mips16:
      cast(Mips16Attr.class, this).printPretty(OS, Policy);
      return;
     case MipsInterrupt:
      cast(MipsInterruptAttr.class, this).printPretty(OS, Policy);
      return;
     case Mode:
      cast(ModeAttr.class, this).printPretty(OS, Policy);
      return;
     case NSConsumed:
      cast(NSConsumedAttr.class, this).printPretty(OS, Policy);
      return;
     case NSConsumesSelf:
      cast(NSConsumesSelfAttr.class, this).printPretty(OS, Policy);
      return;
     case NSReturnsAutoreleased:
      cast(NSReturnsAutoreleasedAttr.class, this).printPretty(OS, Policy);
      return;
     case NSReturnsNotRetained:
      cast(NSReturnsNotRetainedAttr.class, this).printPretty(OS, Policy);
      return;
     case NSReturnsRetained:
      cast(NSReturnsRetainedAttr.class, this).printPretty(OS, Policy);
      return;
     case Naked:
      cast(NakedAttr.class, this).printPretty(OS, Policy);
      return;
     case NoAlias:
      cast(NoAliasAttr.class, this).printPretty(OS, Policy);
      return;
     case NoCommon:
      cast(NoCommonAttr.class, this).printPretty(OS, Policy);
      return;
     case NoDebug:
      cast(NoDebugAttr.class, this).printPretty(OS, Policy);
      return;
     case NoDuplicate:
      cast(NoDuplicateAttr.class, this).printPretty(OS, Policy);
      return;
     case NoInline:
      cast(NoInlineAttr.class, this).printPretty(OS, Policy);
      return;
     case NoInstrumentFunction:
      cast(NoInstrumentFunctionAttr.class, this).printPretty(OS, Policy);
      return;
     case NoMips16:
      cast(NoMips16Attr.class, this).printPretty(OS, Policy);
      return;
     case NoReturn:
      cast(NoReturnAttr.class, this).printPretty(OS, Policy);
      return;
     case NoSanitize:
      cast(NoSanitizeAttr.class, this).printPretty(OS, Policy);
      return;
     case NoSplitStack:
      cast(NoSplitStackAttr.class, this).printPretty(OS, Policy);
      return;
     case NoThreadSafetyAnalysis:
      cast(NoThreadSafetyAnalysisAttr.class, this).printPretty(OS, Policy);
      return;
     case NoThrow:
      cast(NoThrowAttr.class, this).printPretty(OS, Policy);
      return;
     case NonNull:
      cast(NonNullAttr.class, this).printPretty(OS, Policy);
      return;
     case NotTailCalled:
      cast(NotTailCalledAttr.class, this).printPretty(OS, Policy);
      return;
     case OMPCaptureNoInit:
      cast(OMPCaptureNoInitAttr.class, this).printPretty(OS, Policy);
      return;
     case OMPDeclareSimdDecl:
      cast(OMPDeclareSimdDeclAttr.class, this).printPretty(OS, Policy);
      return;
     case OMPDeclareTargetDecl:
      cast(OMPDeclareTargetDeclAttr.class, this).printPretty(OS, Policy);
      return;
     case OMPThreadPrivateDecl:
      cast(OMPThreadPrivateDeclAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCBoxable:
      cast(ObjCBoxableAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCBridge:
      cast(ObjCBridgeAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCBridgeMutable:
      cast(ObjCBridgeMutableAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCBridgeRelated:
      cast(ObjCBridgeRelatedAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCDesignatedInitializer:
      cast(ObjCDesignatedInitializerAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCException:
      cast(ObjCExceptionAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCExplicitProtocolImpl:
      cast(ObjCExplicitProtocolImplAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCIndependentClass:
      cast(ObjCIndependentClassAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCMethodFamily:
      cast(ObjCMethodFamilyAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCNSObject:
      cast(ObjCNSObjectAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCPreciseLifetime:
      cast(ObjCPreciseLifetimeAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCRequiresPropertyDefs:
      cast(ObjCRequiresPropertyDefsAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCRequiresSuper:
      cast(ObjCRequiresSuperAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCReturnsInnerPointer:
      cast(ObjCReturnsInnerPointerAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCRootClass:
      cast(ObjCRootClassAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCRuntimeName:
      cast(ObjCRuntimeNameAttr.class, this).printPretty(OS, Policy);
      return;
     case ObjCRuntimeVisible:
      cast(ObjCRuntimeVisibleAttr.class, this).printPretty(OS, Policy);
      return;
     case OpenCLAccess:
      cast(OpenCLAccessAttr.class, this).printPretty(OS, Policy);
      return;
     case OpenCLKernel:
      cast(OpenCLKernelAttr.class, this).printPretty(OS, Policy);
      return;
     case OpenCLUnrollHint:
      cast(OpenCLUnrollHintAttr.class, this).printPretty(OS, Policy);
      return;
     case OptimizeNone:
      cast(OptimizeNoneAttr.class, this).printPretty(OS, Policy);
      return;
     case Overloadable:
      cast(OverloadableAttr.class, this).printPretty(OS, Policy);
      return;
     case Override:
      cast(OverrideAttr.class, this).printPretty(OS, Policy);
      return;
     case Ownership:
      cast(OwnershipAttr.class, this).printPretty(OS, Policy);
      return;
     case Packed:
      cast(PackedAttr.class, this).printPretty(OS, Policy);
      return;
     case ParamTypestate:
      cast(ParamTypestateAttr.class, this).printPretty(OS, Policy);
      return;
     case Pascal:
      cast(PascalAttr.class, this).printPretty(OS, Policy);
      return;
     case PassObjectSize:
      cast(PassObjectSizeAttr.class, this).printPretty(OS, Policy);
      return;
     case Pcs:
      cast(PcsAttr.class, this).printPretty(OS, Policy);
      return;
     case PreserveAll:
      cast(PreserveAllAttr.class, this).printPretty(OS, Policy);
      return;
     case PreserveMost:
      cast(PreserveMostAttr.class, this).printPretty(OS, Policy);
      return;
     case PtGuardedBy:
      cast(PtGuardedByAttr.class, this).printPretty(OS, Policy);
      return;
     case PtGuardedVar:
      cast(PtGuardedVarAttr.class, this).printPretty(OS, Policy);
      return;
     case Pure:
      cast(PureAttr.class, this).printPretty(OS, Policy);
      return;
     case ReleaseCapability:
      cast(ReleaseCapabilityAttr.class, this).printPretty(OS, Policy);
      return;
     case RenderScriptKernel:
      cast(RenderScriptKernelAttr.class, this).printPretty(OS, Policy);
      return;
     case ReqdWorkGroupSize:
      cast(ReqdWorkGroupSizeAttr.class, this).printPretty(OS, Policy);
      return;
     case RequiresCapability:
      cast(RequiresCapabilityAttr.class, this).printPretty(OS, Policy);
      return;
     case Restrict:
      cast(RestrictAttr.class, this).printPretty(OS, Policy);
      return;
     case ReturnTypestate:
      cast(ReturnTypestateAttr.class, this).printPretty(OS, Policy);
      return;
     case ReturnsNonNull:
      cast(ReturnsNonNullAttr.class, this).printPretty(OS, Policy);
      return;
     case ReturnsTwice:
      cast(ReturnsTwiceAttr.class, this).printPretty(OS, Policy);
      return;
     case ScopedLockable:
      cast(ScopedLockableAttr.class, this).printPretty(OS, Policy);
      return;
     case Section:
      cast(SectionAttr.class, this).printPretty(OS, Policy);
      return;
     case SelectAny:
      cast(SelectAnyAttr.class, this).printPretty(OS, Policy);
      return;
     case Sentinel:
      cast(SentinelAttr.class, this).printPretty(OS, Policy);
      return;
     case SetTypestate:
      cast(SetTypestateAttr.class, this).printPretty(OS, Policy);
      return;
     case SharedTrylockFunction:
      cast(SharedTrylockFunctionAttr.class, this).printPretty(OS, Policy);
      return;
     case StdCall:
      cast(StdCallAttr.class, this).printPretty(OS, Policy);
      return;
     case SwiftCall:
      cast(SwiftCallAttr.class, this).printPretty(OS, Policy);
      return;
     case SwiftContext:
      cast(SwiftContextAttr.class, this).printPretty(OS, Policy);
      return;
     case SwiftErrorResult:
      cast(SwiftErrorResultAttr.class, this).printPretty(OS, Policy);
      return;
     case SwiftIndirectResult:
      cast(SwiftIndirectResultAttr.class, this).printPretty(OS, Policy);
      return;
     case SysVABI:
      cast(SysVABIAttr.class, this).printPretty(OS, Policy);
      return;
     case TLSModel:
      cast(TLSModelAttr.class, this).printPretty(OS, Policy);
      return;
     case Target:
      cast(TargetAttr.class, this).printPretty(OS, Policy);
      return;
     case TestTypestate:
      cast(TestTypestateAttr.class, this).printPretty(OS, Policy);
      return;
     case ThisCall:
      cast(ThisCallAttr.class, this).printPretty(OS, Policy);
      return;
     case Thread:
      cast(ThreadAttr.class, this).printPretty(OS, Policy);
      return;
     case TransparentUnion:
      cast(TransparentUnionAttr.class, this).printPretty(OS, Policy);
      return;
     case TryAcquireCapability:
      cast(TryAcquireCapabilityAttr.class, this).printPretty(OS, Policy);
      return;
     case TypeTagForDatatype:
      cast(TypeTagForDatatypeAttr.class, this).printPretty(OS, Policy);
      return;
     case TypeVisibility:
      cast(TypeVisibilityAttr.class, this).printPretty(OS, Policy);
      return;
     case Unavailable:
      cast(UnavailableAttr.class, this).printPretty(OS, Policy);
      return;
     case Unused:
      cast(UnusedAttr.class, this).printPretty(OS, Policy);
      return;
     case Used:
      cast(UsedAttr.class, this).printPretty(OS, Policy);
      return;
     case Uuid:
      cast(UuidAttr.class, this).printPretty(OS, Policy);
      return;
     case VecReturn:
      cast(VecReturnAttr.class, this).printPretty(OS, Policy);
      return;
     case VecTypeHint:
      cast(VecTypeHintAttr.class, this).printPretty(OS, Policy);
      return;
     case VectorCall:
      cast(VectorCallAttr.class, this).printPretty(OS, Policy);
      return;
     case Visibility:
      cast(VisibilityAttr.class, this).printPretty(OS, Policy);
      return;
     case WarnUnused:
      cast(WarnUnusedAttr.class, this).printPretty(OS, Policy);
      return;
     case WarnUnusedResult:
      cast(WarnUnusedResultAttr.class, this).printPretty(OS, Policy);
      return;
     case Weak:
      cast(WeakAttr.class, this).printPretty(OS, Policy);
      return;
     case WeakImport:
      cast(WeakImportAttr.class, this).printPretty(OS, Policy);
      return;
     case WeakRef:
      cast(WeakRefAttr.class, this).printPretty(OS, Policy);
      return;
     case WorkGroupSizeHint:
      cast(WorkGroupSizeHintAttr.class, this).printPretty(OS, Policy);
      return;
     case X86ForceAlignArgPointer:
      cast(X86ForceAlignArgPointerAttr.class, this).printPretty(OS, Policy);
      return;
     case XRayInstrument:
      cast(XRayInstrumentAttr.class, this).printPretty(OS, Policy);
      return;
    }
    throw new llvm_unreachable("Unexpected attribute kind!");
  }

  
  /// \brief By default, attributes cannot be duplicated when being merged;
  /// however, an attribute can override this. Returns true if the attribute
  /// can be duplicated when merging.
  //<editor-fold defaultstate="collapsed" desc="clang::Attr::duplicatesAllowed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 119,
   FQN="clang::Attr::duplicatesAllowed", NM="_ZNK5clang4Attr17duplicatesAllowedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang4Attr17duplicatesAllowedEv")
  //</editor-fold>
  public boolean duplicatesAllowed() /*const*/ {
    return DuplicatesAllowed;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Attr::Attr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 45,
   FQN="clang::Attr::Attr", NM="_ZN5clang4AttrC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4AttrC1ERKS0_")
  //</editor-fold>
  public /*inline*/ Attr(final /*const*/ Attr /*&*/ $Prm0) {
    // : Range(.Range), AttrKind(.AttrKind), SpellingListIndex(.SpellingListIndex), Inherited(.Inherited), IsPackExpansion(.IsPackExpansion), Implicit(.Implicit), IsLateParsed(.IsLateParsed), DuplicatesAllowed(.DuplicatesAllowed) 
    //START JInit
    this.Range = new SourceRange($Prm0.Range);
    this.AttrKind = $uint2uint_16bits($Prm0.AttrKind);
    this.SpellingListIndex = $uint2uint_4bits($Prm0.SpellingListIndex);
    this.Inherited = $Prm0.Inherited;
    this.IsPackExpansion = $Prm0.IsPackExpansion;
    this.Implicit = $Prm0.Implicit;
    this.IsLateParsed = $Prm0.IsLateParsed;
    this.DuplicatesAllowed = $Prm0.DuplicatesAllowed;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Range=" + Range // NOI18N
              + ", AttrKind=" + $ushort2uint(AttrKind) // NOI18N
              + ", SpellingListIndex=" + $uchar2uint(SpellingListIndex) // NOI18N
              + ", Inherited=" + Inherited // NOI18N
              + ", IsPackExpansion=" + IsPackExpansion // NOI18N
              + ", Implicit=" + Implicit // NOI18N
              + ", IsLateParsed=" + IsLateParsed // NOI18N
              + ", DuplicatesAllowed=" + DuplicatesAllowed; // NOI18N
  }
}
