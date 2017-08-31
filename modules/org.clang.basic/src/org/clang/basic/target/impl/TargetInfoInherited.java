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

package org.clang.basic.target.impl;

import org.clang.basic.*;
import org.clang.basic.target.TargetCXXABI;
import org.clang.basic.target.TargetInfo;
import org.clang.basic.target.TargetOptions;
import org.clank.java.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.DataLayout;
import org.llvm.support.*;

// JAVA: special class used to emulate interitance from template parameter
// where template parameter is subclass of TargetInfo real implementation; 
// uses delegation for emulation of inheritance;
// the base for this class is special TargetInfoImpl which exposes protected methods
// to be visible by this class for delegation

/**
 * 
 * @author Vladimir Voskresensky
 */
public abstract class TargetInfoInherited</*typename*/  T extends org.clang.basic.target.impl.TargetInfo>
                                          extends org.clang.basic.target.impl.TargetInfoImpl {
  protected final T tgt;

  public TargetInfoInherited(T Tgt, org.llvm.adt.Triple T) {
    super(NoneType.None);
    this.tgt = Tgt;
    assert tgt.getTriple().$eq(T);
    assert ((Object)this) instanceof org.clang.basic.target.impl.OSTargetInfo : 
            "Unexpected class " + Tgt.getClass().getSimpleName();
    assert ((Object)tgt) instanceof org.clang.basic.target.impl.TargetInfo : 
            "Unexpected class " + Tgt.getClass().getSimpleName();
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // JAVA: emulation of multiple inheritance of this class from TargetInfo
  // we use field tgt for that. Base TargetInfo must be already upgraded (at least in empty-body mode)
  // To generate delegating methods use the following:
  // Refactor->Introduce->Local Extension: Wrapper/Delegate, uncheck Replace original
  // use Preview and copy all methods from $destroy till toString
  // then in static methods replace OSTargetInfo class to TargetInfo
  // 
  // Use completion to "implement" abstract methods from TargetInfo as well and delegate  

  @Override
  protected void resetDataLayout(StringRef DL) {
    tgt.resetDataLayout(DL);
  }

  @Override public ArrayRef<char$ptr> getGCCRegNames() {
    return tgt.getGCCRegNames();
  }

  @Override public ArrayRef<GCCRegAlias> getGCCRegAliases() {
    return tgt.getGCCRegAliases();
  }
  
  @Override public void $destroy() {
    tgt.$destroy();
  }

  @Override public TargetOptions getTargetOpts() {
    return tgt.getTargetOpts();
  }

  @Override public IntType getSizeType() {
    return tgt.getSizeType();
  }

  @Override public IntType getIntMaxType() {
    return tgt.getIntMaxType();
  }

  @Override public IntType getUIntMaxType() {
    return tgt.getUIntMaxType();
  }

  @Override public IntType getPtrDiffType(int AddrSpace) {
    return tgt.getPtrDiffType(AddrSpace);
  }

  @Override public IntType getIntPtrType() {
    return tgt.getIntPtrType();
  }

  @Override public IntType getUIntPtrType() {
    return tgt.getUIntPtrType();
  }

  @Override public IntType getWCharType() {
    return tgt.getWCharType();
  }

  @Override public IntType getWIntType() {
    return tgt.getWIntType();
  }

  @Override public IntType getChar16Type() {
    return tgt.getChar16Type();
  }

  @Override public IntType getChar32Type() {
    return tgt.getChar32Type();
  }

  @Override public IntType getInt64Type() {
    return tgt.getInt64Type();
  }

  @Override public IntType getUInt64Type() {
    return tgt.getUInt64Type();
  }

  @Override public IntType getSigAtomicType() {
    return tgt.getSigAtomicType();
  }

  @Override public IntType getProcessIDType() {
    return tgt.getProcessIDType();
  }

  public static IntType getCorrespondingUnsignedType(IntType T) {
    return TargetInfo.getCorrespondingUnsignedType(T);
  }

  @Override public int getTypeWidth(IntType T) {
    return tgt.getTypeWidth(T);
  }

  @Override public IntType getIntTypeByWidth(int BitWidth, boolean IsSigned) {
    return tgt.getIntTypeByWidth(BitWidth, IsSigned);
  }

  @Override public IntType getLeastIntTypeByWidth(int BitWidth, boolean IsSigned) {
    return tgt.getLeastIntTypeByWidth(BitWidth, IsSigned);
  }

  @Override public RealType getRealTypeByWidth(int BitWidth) {
    return tgt.getRealTypeByWidth(BitWidth);
  }

  @Override public int getTypeAlign(IntType T) {
    return tgt.getTypeAlign(T);
  }

  public static boolean isTypeSigned(IntType T) {
    return TargetInfo.isTypeSigned(T);
  }

  @Override public long getPointerWidth(int AddrSpace) {
    return tgt.getPointerWidth(AddrSpace);
  }

  @Override public long getPointerAlign(int AddrSpace) {
    return tgt.getPointerAlign(AddrSpace);
  }

  @Override public int getBoolWidth() {
    return tgt.getBoolWidth();
  }

  @Override public int getBoolAlign() {
    return tgt.getBoolAlign();
  }

  @Override public int getCharWidth() {
    return tgt.getCharWidth();
  }

  @Override public int getCharAlign() {
    return tgt.getCharAlign();
  }

  @Override public int getShortWidth() {
    return tgt.getShortWidth();
  }

  @Override public int getShortAlign() {
    return tgt.getShortAlign();
  }

  @Override public int getIntWidth() {
    return tgt.getIntWidth();
  }

  @Override public int getIntAlign() {
    return tgt.getIntAlign();
  }

  @Override public int getLongWidth() {
    return tgt.getLongWidth();
  }

  @Override public int getLongAlign() {
    return tgt.getLongAlign();
  }

  @Override public int getLongLongWidth() {
    return tgt.getLongLongWidth();
  }

  @Override public int getLongLongAlign() {
    return tgt.getLongLongAlign();
  }

  @Override public boolean hasInt128Type() {
    return tgt.hasInt128Type();
  }

  @Override
  public boolean hasFloat128Type() {
    return tgt.hasFloat128Type();
  }
  
  @Override public int getSuitableAlign() {
    return tgt.getSuitableAlign();
  }

  @Override public int getDefaultAlignForAttributeAligned() {
    return tgt.getDefaultAlignForAttributeAligned();
  }

  @Override public int getMinGlobalAlign() {
    return tgt.getMinGlobalAlign();
  }

  @Override public int getWCharWidth() {
    return tgt.getWCharWidth();
  }

  @Override public int getWCharAlign() {
    return tgt.getWCharAlign();
  }

  @Override public int getChar16Width() {
    return tgt.getChar16Width();
  }

  @Override public int getChar16Align() {
    return tgt.getChar16Align();
  }

  @Override public int getChar32Width() {
    return tgt.getChar32Width();
  }

  @Override public int getChar32Align() {
    return tgt.getChar32Align();
  }

  @Override public int getHalfWidth() {
    return tgt.getHalfWidth();
  }

  @Override public int getHalfAlign() {
    return tgt.getHalfAlign();
  }

  @Override public fltSemantics getHalfFormat() {
    return tgt.getHalfFormat();
  }

  @Override public int getFloatWidth() {
    return tgt.getFloatWidth();
  }

  @Override public int getFloatAlign() {
    return tgt.getFloatAlign();
  }

  @Override public fltSemantics getFloatFormat() {
    return tgt.getFloatFormat();
  }

  @Override public int getDoubleWidth() {
    return tgt.getDoubleWidth();
  }

  @Override public int getDoubleAlign() {
    return tgt.getDoubleAlign();
  }

  @Override public fltSemantics getDoubleFormat() {
    return tgt.getDoubleFormat();
  }

  @Override public int getLongDoubleWidth() {
    return tgt.getLongDoubleWidth();
  }

  @Override public int getLongDoubleAlign() {
    return tgt.getLongDoubleAlign();
  }

  @Override public fltSemantics getLongDoubleFormat() {
    return tgt.getLongDoubleFormat();
  }

  @Override
  public int getFloat128Width() {
    return tgt.getFloat128Width();
  }

  @Override
  public int getFloat128Align() {
    return tgt.getFloat128Align();
  }

  @Override
  public fltSemantics getFloat128Format() {
    return tgt.getFloat128Format();
  }

  @Override public boolean useFloat128ManglingForLongDouble() {
    return tgt.useFloat128ManglingForLongDouble();
  }

  @Override public int getFloatEvalMethod() {
    return tgt.getFloatEvalMethod();
  }

  @Override public int getLargeArrayMinWidth() {
    return tgt.getLargeArrayMinWidth();
  }

  @Override public int getLargeArrayAlign() {
    return tgt.getLargeArrayAlign();
  }

  @Override public int getMaxAtomicPromoteWidth() {
    return tgt.getMaxAtomicPromoteWidth();
  }

  @Override public int getMaxAtomicInlineWidth() {
    return tgt.getMaxAtomicInlineWidth();
  }

  @Override public boolean hasBuiltinAtomic(long AtomicSizeInBits, long AlignmentInBits) {
    return tgt.hasBuiltinAtomic(AtomicSizeInBits, AlignmentInBits);
  }

  @Override public int getMaxVectorAlign() {
    return tgt.getMaxVectorAlign();
  }

  @Override public int getSimdDefaultAlign() {
    return tgt.getSimdDefaultAlign();
  }

  @Override
  public int getExnObjectAlignment() {
    return tgt.getExnObjectAlignment();
  }

  @Override public int getIntMaxTWidth() {
    return tgt.getIntMaxTWidth();
  }

  @Override public int getUnwindWordWidth() {
    return tgt.getUnwindWordWidth();
  }

  @Override public int getRegisterWidth() {
    return tgt.getRegisterWidth();
  }

  @Override public char$ptr getMCountName() {
    return tgt.getMCountName();
  }

  @Override public boolean useSignedCharForObjCBool() {
    return tgt.useSignedCharForObjCBool();
  }

  @Override public void noSignedCharForObjCBool() {
    tgt.noSignedCharForObjCBool();
  }

  @Override public boolean useBitFieldTypeAlignment() {
    return tgt.useBitFieldTypeAlignment();
  }

  @Override public boolean useZeroLengthBitfieldAlignment() {
    return tgt.useZeroLengthBitfieldAlignment();
  }

  @Override public int getZeroLengthBitfieldBoundary() {
    return tgt.getZeroLengthBitfieldBoundary();
  }

  @Override
  public boolean useExplicitBitFieldAlignment() {
    return tgt.useExplicitBitFieldAlignment();
  }

  @Override public boolean hasAlignMac68kSupport() {
    return tgt.hasAlignMac68kSupport();
  }

  public static char$ptr getTypeName(IntType T) {
    return TargetInfo.getTypeName(T);
  }

  @Override public char$ptr getTypeConstantSuffix(IntType T) {
    return tgt.getTypeConstantSuffix(T);
  }

  public static char$ptr getTypeFormatModifier(IntType T) {
    return TargetInfo.getTypeFormatModifier(T);
  }

  @Override public boolean useObjCFPRetForRealType(RealType T) {
    return tgt.useObjCFPRetForRealType(T);
  }

  @Override public boolean useObjCFP2RetForComplexLongDouble() {
    return tgt.useObjCFP2RetForComplexLongDouble();
  }

  @Override public boolean useAddressSpaceMapMangling() {
    return tgt.useAddressSpaceMapMangling();
  }

  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) {
    tgt.getTargetDefines(Opts, Builder);
  }

  @Override public ArrayRef<Builtin.Info> getTargetBuiltins() {
    return tgt.getTargetBuiltins();
  }

  @Override public boolean isCLZForZeroUndef() {
    return tgt.isCLZForZeroUndef();
  }

  @Override public BuiltinVaListKind getBuiltinVaListKind() {
    return tgt.getBuiltinVaListKind();
  }

  @Override public boolean hasBuiltinMSVaList() {
    return tgt.hasBuiltinMSVaList();
  }

  @Override public boolean isValidClobber(StringRef Name) {
    return tgt.isValidClobber(Name);
  }

  @Override public boolean isValidGCCRegisterName(StringRef Name) {
    return tgt.isValidGCCRegisterName(Name);
  }

  @Override public StringRef getNormalizedGCCRegisterName(StringRef Name) {
    return tgt.getNormalizedGCCRegisterName(Name);
  }

  @Override public boolean validateGlobalRegisterVariable(StringRef RegName, int RegSize, bool$ref HasSizeMismatch) {
    return tgt.validateGlobalRegisterVariable(RegName, RegSize, HasSizeMismatch);
  }

  @Override public boolean validateOutputConstraint(ConstraintInfo Info) {
    return tgt.validateOutputConstraint(Info);
  }

  @Override public boolean validateInputConstraint(MutableArrayRef<ConstraintInfo> OutputConstraints, ConstraintInfo Info) {
    return tgt.validateInputConstraint(OutputConstraints, Info);
  }

  @Override public boolean validateOutputSize(StringRef $Prm0, int $Prm1) {
    return tgt.validateOutputSize($Prm0, $Prm1);
  }

  @Override public boolean validateInputSize(StringRef $Prm0, int $Prm1) {
    return tgt.validateInputSize($Prm0, $Prm1);
  }

  @Override public boolean validateConstraintModifier(StringRef $Prm0, byte $Prm1, int $Prm2, std.string $Prm3) {
    return tgt.validateConstraintModifier($Prm0, $Prm1, $Prm2, $Prm3);
  }

  @Override public boolean validateAsmConstraint(char$ptr Name, ConstraintInfo info) {
    return tgt.validateAsmConstraint(Name, info);
  }

  @Override public boolean resolveSymbolicName(char$ptr Name, ArrayRef<ConstraintInfo> OutputConstraints, uint$ref Index) {
    return tgt.resolveSymbolicName(Name, OutputConstraints, Index);
  }

  @Override public std.string convertConstraint(char$ptr Constraint) {
    return tgt.convertConstraint(Constraint);
  }

  @Override public char$ptr getClobbers() {
    return tgt.getClobbers();
  }

  @Override public boolean isNan2008() {
    return tgt.isNan2008();
  }

  @Override public Triple getTriple() {
    return tgt.getTriple();
  }

  @Override public DataLayout getDataLayout() {
    return tgt.getDataLayout();
  }

  @Override public boolean hasProtectedVisibility() {
    return tgt.hasProtectedVisibility();
  }

  @Override public std.string isValidSectionSpecifier(StringRef SR) {
    return tgt.isValidSectionSpecifier(SR);
  }

  @Override public void adjust(LangOptions Opts) {
    tgt.adjust(Opts);
  }

  @Override public boolean initFeatureMap(StringMapBool Features, DiagnosticsEngine Diags, StringRef CPU, std.vectorString FeatureVec) {
    return tgt.initFeatureMap(Features, Diags, CPU, FeatureVec);
  }

  @Override public StringRef getABI() {
    return tgt.getABI();
  }

  @Override public TargetCXXABI getCXXABI() {
    return tgt.getCXXABI();
  }

  @Override public boolean setCPU(std.string Name) {
    return tgt.setCPU(Name);
  }

  @Override public boolean setABI(std.string Name) {
    return tgt.setABI(Name);
  }

  @Override public boolean setFPMath(StringRef Name) {
    return tgt.setFPMath(Name);
  }

  @Override public void setFeatureEnabled(StringMapBool Features, StringRef Name, boolean Enabled) {
    tgt.setFeatureEnabled(Features, Name, Enabled);
  }

  @Override public boolean handleTargetFeatures(std.vectorString Features, DiagnosticsEngine Diags) {
    return tgt.handleTargetFeatures(Features, Diags);
  }

  @Override public boolean hasFeature(StringRef Feature) {
    return tgt.hasFeature(Feature);
  }

  @Override public boolean validateCpuSupports(StringRef Name) {
    return tgt.validateCpuSupports(Name);
  }

  @Override public int getRegParmMax() {
    return tgt.getRegParmMax();
  }

  @Override public boolean isTLSSupported() {
    return tgt.isTLSSupported();
  }

   @Override public char getMaxTLSAlign() {
    return tgt.getMaxTLSAlign();
  }

  @Override public boolean isSEHTrySupported() {
    return tgt.isSEHTrySupported();
  }

  @Override public boolean hasNoAsmVariants() {
    return tgt.hasNoAsmVariants();
  }

  @Override public int getEHDataRegisterNumber(int RegNo) {
    return tgt.getEHDataRegisterNumber(RegNo);
  }

  @Override public char$ptr getStaticInitSectionSpecifier() {
    return tgt.getStaticInitSectionSpecifier();
  }

  @Override public LangAS.Map getAddressSpaceMap() {
    return tgt.getAddressSpaceMap();
  }

  @Override public StringRef getPlatformName() {
    return tgt.getPlatformName();
  }

  @Override public VersionTuple getPlatformMinVersion() {
    return tgt.getPlatformMinVersion();
  }

  @Override public boolean isBigEndian() {
    return tgt.isBigEndian();
  }

  @Override public CallingConv getDefaultCallingConv(CallingConvMethodType MT) {
    return tgt.getDefaultCallingConv(MT);
  }

  @Override public CallingConvCheckResult checkCallingConvention(CallingConv CC) {
    return tgt.checkCallingConvention(CC);
  }

  @Override public boolean hasSjLjLowering() {
    return tgt.hasSjLjLowering();
  }

  @Override
  public /*virtual*/ boolean allowsLargerPreferedTypeAlignment() /*const*/ {
    return tgt.allowsLargerPreferedTypeAlignment();
  }

  
  @Override
  public /*virtual*/ void setSupportedOpenCLOpts() {
    tgt.setSupportedOpenCLOpts();
  }

  
  @Override
  public OpenCLOptions /*&*/ getSupportedOpenCLOpts() {
    return tgt.getSupportedOpenCLOpts();
  }
  
  @Override
  public OpenCLOptions /*&*/ getSupportedOpenCLOpts$Const() {
    return tgt.getSupportedOpenCLOpts$Const();
  }

  @Override
  public boolean validateTarget(DiagnosticsEngine /*&*/ Diags) /*const*/ {
    return tgt.validateTarget(Diags);
  }
  
  @Override
  protected ArrayRef<AddlRegName> getGCCAddlRegNames() {
    return tgt.getGCCAddlRegNames();
  }

  @Override
  protected IntType getPtrDiffTypeV(int AddrSpace) {
    return tgt.getPtrDiffTypeV(AddrSpace);
  }

  @Override
  protected long getPointerAlignV(int AddrSpace) {
    return tgt.getPointerAlignV(AddrSpace);
  }

  @Override
  protected long getPointerWidthV(int AddrSpace) {
    return tgt.getPointerWidthV(AddrSpace);
  }

  // Release/Retain doesn't need to be overwritten;
  // $destroy of target will be called when last reference to this is released
//  @Override
//  public void Release() {
//    tgt.Release();
//    super.Release();
//  }
//
//  @Override
//  public void Retain() {
//    tgt.Retain();
//    super.Retain();
//  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + 
            "<" + tgt.getClass().getSimpleName() + ">"; // NOI18N
  }
}
