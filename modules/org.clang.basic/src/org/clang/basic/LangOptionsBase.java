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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.clang.basic.*;


/// Bitfields of LangOptions, split out from LangOptions in order to ensure that
/// this large collection of bitfields is a trivial class type.
//<editor-fold defaultstate="collapsed" desc="clang::LangOptionsBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 30,
 FQN="clang::LangOptionsBase", NM="_ZN5clang15LangOptionsBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang15LangOptionsBaseE")
//</editor-fold>
public class LangOptionsBase {
/*public:*/
  
  // FIXME: A lot of the BENIGN_ options should be COMPATIBLE_ instead.
  public /*JBIT unsigned int*/ boolean C99 /*: 1*/;
  public /*JBIT unsigned int*/ boolean C11 /*: 1*/;
  public /*JBIT unsigned int*/ boolean MSVCCompat /*: 1*/;
  public /*JBIT unsigned int*/ boolean MicrosoftExt /*: 1*/;
  public /*JBIT unsigned int*/ boolean AsmBlocks /*: 1*/;
  public /*JBIT unsigned int*/ boolean Borland /*: 1*/;
  public /*JBIT unsigned int*/ boolean CPlusPlus /*: 1*/;
  public /*JBIT unsigned int*/ boolean CPlusPlus11 /*: 1*/;
  public /*JBIT unsigned int*/ boolean CPlusPlus14 /*: 1*/;
  public /*JBIT unsigned int*/ boolean CPlusPlus1z /*: 1*/;
  public /*JBIT unsigned int*/ boolean ObjC1 /*: 1*/;
  public /*JBIT unsigned int*/ boolean ObjC2 /*: 1*/;
  public /*JBIT unsigned int*/ boolean ObjCDefaultSynthProperties /*: 1*/;
  public /*JBIT unsigned int*/ boolean EncodeExtendedBlockSig /*: 1*/;
  public /*JBIT unsigned int*/ boolean ObjCInferRelatedResultType /*: 1*/;
  public /*JBIT unsigned int*/ boolean AppExt /*: 1*/;
  public /*JBIT unsigned int*/ boolean Trigraphs /*: 1*/;
  public /*JBIT unsigned int*/ boolean LineComment /*: 1*/;
  public /*JBIT unsigned int*/ boolean Bool /*: 1*/;
  public /*JBIT unsigned int*/ boolean Half /*: 1*/;
  public /*JBIT unsigned int*/ boolean WChar /*: 1*/;
  public /*JBIT unsigned int*/ boolean DeclSpecKeyword /*: 1*/;
  public /*JBIT unsigned int*/ boolean DollarIdents /*: 1*/;
  public /*JBIT unsigned int*/ boolean AsmPreprocessor /*: 1*/;
  public /*JBIT unsigned int*/ boolean GNUMode /*: 1*/;
  public /*JBIT unsigned int*/ boolean GNUKeywords /*: 1*/;
  public /*JBIT unsigned int*/ boolean ImplicitInt /*: 1*/;
  public /*JBIT unsigned int*/ boolean Digraphs /*: 1*/;
  public /*JBIT unsigned int*/ boolean HexFloats /*: 1*/;
  public /*JBIT unsigned int*/ boolean CXXOperatorNames /*: 1*/;
  public /*JBIT unsigned int*/ boolean AppleKext /*: 1*/;
  public /*JBIT unsigned int*/ boolean PascalStrings /*: 1*/;
  public /*JBIT unsigned int*/ boolean WritableStrings /*: 1*/;
  public /*JBIT unsigned int*/ boolean ConstStrings /*: 1*/;
  public /*JBIT unsigned int*/ boolean LaxVectorConversions /*: 1*/;
  public /*JBIT unsigned int*/ boolean AltiVec /*: 1*/;
  public /*JBIT unsigned int*/ boolean ZVector /*: 1*/;
  public /*JBIT unsigned int*/ boolean Exceptions /*: 1*/;
  public /*JBIT unsigned int*/ boolean ObjCExceptions /*: 1*/;
  public /*JBIT unsigned int*/ boolean CXXExceptions /*: 1*/;
  public /*JBIT unsigned int*/ boolean SjLjExceptions /*: 1*/;
  public /*JBIT unsigned int*/ boolean ExternCNoUnwind /*: 1*/;
  public /*JBIT unsigned int*/ boolean TraditionalCPP /*: 1*/;
  public /*JBIT unsigned int*/ boolean RTTI /*: 1*/;
  public /*JBIT unsigned int*/ boolean RTTIData /*: 1*/;
  public /*JBIT unsigned int*/ boolean MSBitfields /*: 1*/;
  public /*JBIT unsigned int*/ boolean Freestanding /*: 1*/;
  public /*JBIT unsigned int*/ boolean NoBuiltin /*: 1*/;
  public /*JBIT unsigned int*/ boolean NoMathBuiltin /*: 1*/;
  public /*JBIT unsigned int*/ boolean GNUAsm /*: 1*/;
  public /*JBIT unsigned int*/ boolean Coroutines /*: 1*/;
  public /*JBIT unsigned int*/ boolean ThreadsafeStatics /*: 1*/;
  public /*JBIT unsigned int*/ boolean POSIXThreads /*: 1*/;
  public /*JBIT unsigned int*/ boolean Blocks /*: 1*/;
  public /*JBIT unsigned int*/ boolean EmitAllDecls /*: 1*/;
  public /*JBIT unsigned int*/ boolean MathErrno /*: 1*/;
  public /*JBIT unsigned int*/ boolean HeinousExtensions /*: 1*/;
  public /*JBIT unsigned int*/ boolean Modules /*: 1*/;
  public /*JBIT unsigned int*/ boolean CompilingModule /*: 1*/;
  public /*JBIT unsigned int*/ boolean ModulesDeclUse /*: 1*/;
  public /*JBIT unsigned int*/ boolean ModulesSearchAll /*: 1*/;
  public /*JBIT unsigned int*/ boolean ModulesStrictDeclUse /*: 1*/;
  public /*JBIT unsigned int*/ boolean ModulesErrorRecovery /*: 1*/;
  public /*JBIT unsigned int*/ boolean ImplicitModules /*: 1*/;
  public /*JBIT unsigned int*/ boolean ModulesLocalVisibility /*: 1*/;
  public /*JBIT unsigned int*/ boolean Optimize /*: 1*/;
  public /*JBIT unsigned int*/ boolean OptimizeSize /*: 1*/;
  public /*JBIT unsigned int*/ boolean Static /*: 1*/;
  public /*uint*/int PackStruct /*: 32*/;
  public /*uint*/int MaxTypeAlign /*: 32*/;
  public /*JBIT unsigned int*/ boolean AlignDouble /*: 1*/;
  public /*JBYTE unsigned int*/ byte PICLevel /*: 2*/;
  public /*JBIT unsigned int*/ boolean PIE /*: 1*/;
  public /*JBIT unsigned int*/ boolean GNUInline /*: 1*/;
  public /*JBIT unsigned int*/ boolean NoInlineDefine /*: 1*/;
  public /*JBIT unsigned int*/ boolean Deprecated /*: 1*/;
  public /*JBIT unsigned int*/ boolean FastMath /*: 1*/;
  public /*JBIT unsigned int*/ boolean FiniteMathOnly /*: 1*/;
  public /*JBIT unsigned int*/ boolean UnsafeFPMath /*: 1*/;
  public /*JBIT unsigned int*/ boolean ObjCGCBitmapPrint /*: 1*/;
  public /*JBIT unsigned int*/ boolean AccessControl /*: 1*/;
  public /*JBIT unsigned int*/ boolean CharIsSigned /*: 1*/;
  public /*JBIT unsigned int*/ boolean ShortWChar /*: 1*/;
  public /*JBIT unsigned int*/ boolean ShortEnums /*: 1*/;
  public /*JBIT unsigned int*/ boolean OpenCL /*: 1*/;
  public /*uint*/int OpenCLVersion /*: 32*/;
  public /*JBIT unsigned int*/ boolean NativeHalfType /*: 1*/;
  public /*JBIT unsigned int*/ boolean NativeHalfArgsAndReturns /*: 1*/;
  public /*JBIT unsigned int*/ boolean HalfArgsAndReturns /*: 1*/;
  public /*JBIT unsigned int*/ boolean CUDA /*: 1*/;
  public /*uint*/int OpenMP /*: 32*/;
  public /*JBIT unsigned int*/ boolean OpenMPUseTLS /*: 1*/;
  public /*JBIT unsigned int*/ boolean OpenMPIsDevice /*: 1*/;
  public /*JBIT unsigned int*/ boolean RenderScript /*: 1*/;
  public /*JBIT unsigned int*/ boolean CUDAIsDevice /*: 1*/;
  public /*JBIT unsigned int*/ boolean CUDAAllowVariadicFunctions /*: 1*/;
  public /*JBIT unsigned int*/ boolean CUDAHostDeviceConstexpr /*: 1*/;
  public /*JBIT unsigned int*/ boolean CUDADeviceFlushDenormalsToZero /*: 1*/;
  public /*JBIT unsigned int*/ boolean CUDADeviceApproxTranscendentals /*: 1*/;
  public /*JBIT unsigned int*/ boolean SizedDeallocation /*: 1*/;
  public /*JBIT unsigned int*/ boolean ConceptsTS /*: 1*/;
  public /*JBIT unsigned int*/ boolean ElideConstructors /*: 1*/;
  public /*JBIT unsigned int*/ boolean DumpRecordLayouts /*: 1*/;
  public /*JBIT unsigned int*/ boolean DumpRecordLayoutsSimple /*: 1*/;
  public /*JBIT unsigned int*/ boolean DumpVTableLayouts /*: 1*/;
  public /*JBIT unsigned int*/ boolean NoConstantCFStrings /*: 1*/;
  public /*JBIT unsigned int*/ boolean InlineVisibilityHidden /*: 1*/;
  public /*JBIT unsigned int*/ boolean ParseUnknownAnytype /*: 1*/;
  public /*JBIT unsigned int*/ boolean DebuggerSupport /*: 1*/;
  public /*JBIT unsigned int*/ boolean DebuggerCastResultToId /*: 1*/;
  public /*JBIT unsigned int*/ boolean DebuggerObjCLiteral /*: 1*/;
  public /*JBIT unsigned int*/ boolean SpellChecking /*: 1*/;
  public /*JBIT unsigned int*/ boolean SinglePrecisionConstants /*: 1*/;
  public /*JBIT unsigned int*/ boolean FastRelaxedMath /*: 1*/;
  public /*JBIT unsigned int*/ boolean DefaultFPContract /*: 1*/;
  public /*JBIT unsigned int*/ boolean NoBitFieldTypeAlign /*: 1*/;
  public /*JBIT unsigned int*/ boolean HexagonQdsp6Compat /*: 1*/;
  public /*JBIT unsigned int*/ boolean ObjCAutoRefCount /*: 1*/;
  public /*JBIT unsigned int*/ boolean ObjCWeakRuntime /*: 1*/;
  public /*JBIT unsigned int*/ boolean ObjCWeak /*: 1*/;
  public /*JBIT unsigned int*/ boolean ObjCSubscriptingLegacyRuntime /*: 1*/;
  public /*JBIT unsigned int*/ boolean FakeAddressSpaceMap /*: 1*/;
  public /*JBIT unsigned int*/ boolean IncludeDefaultHeader /*: 1*/;
  public /*JBIT unsigned int*/ boolean DelayedTemplateParsing /*: 1*/;
  public /*JBIT unsigned int*/ boolean BlocksRuntimeOptional /*: 1*/;
  public /*uint*/int ArrowDepth /*: 32*/;
  public /*uint*/int InstantiationDepth /*: 32*/;
  public /*uint*/int ConstexprCallDepth /*: 32*/;
  public /*uint*/int ConstexprStepLimit /*: 32*/;
  public /*uint*/int BracketDepth /*: 32*/;
  public /*uint*/int NumLargeByValueCopy /*: 32*/;
  public /*uint*/int MSCompatibilityVersion /*: 32*/;
  public /*JBYTE unsigned int*/ byte VtorDispMode /*: 2*/;
  public /*JBIT unsigned int*/ boolean ApplePragmaPack /*: 1*/;
  public /*JBIT unsigned int*/ boolean RetainCommentsFromSystemHeaders /*: 1*/;
  public /*JBYTE unsigned int*/ byte SanitizeAddressFieldPadding /*: 2*/;
/*protected:*/
  protected /*JBYTE unsigned int*/ byte MSPointerToMemberRepresentationMethod /*: 2*/;
  protected /*JBYTE unsigned int*/ byte DefaultCallingConv /*: 3*/;
  protected /*JBYTE unsigned int*/ byte AddressSpaceMapMangling /*: 2*/;
  protected /*JBYTE unsigned int*/ byte GC /*: 2*/;
  protected /*JBYTE unsigned int*/ byte ValueVisibilityMode /*: 3*/;
  protected /*JBYTE unsigned int*/ byte TypeVisibilityMode /*: 3*/;
  protected /*JBYTE unsigned int*/ byte StackProtector /*: 2*/;
  protected /*JBYTE unsigned int*/ byte SignedOverflowBehavior /*: 2*/;
  //<editor-fold defaultstate="collapsed" desc="clang::LangOptionsBase::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 30,
   FQN="clang::LangOptionsBase::operator=", NM="_ZN5clang15LangOptionsBaseaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang15LangOptionsBaseaSERKS0_")
  //</editor-fold>
  public /*inline*/ LangOptionsBase /*&*/ $assign(/*const*/ LangOptionsBase /*&*/ $Prm0) {
    this.C99 = $Prm0.C99;
    this.C11 = $Prm0.C11;
    this.MSVCCompat = $Prm0.MSVCCompat;
    this.MicrosoftExt = $Prm0.MicrosoftExt;
    this.AsmBlocks = $Prm0.AsmBlocks;
    this.Borland = $Prm0.Borland;
    this.CPlusPlus = $Prm0.CPlusPlus;
    this.CPlusPlus11 = $Prm0.CPlusPlus11;
    this.CPlusPlus14 = $Prm0.CPlusPlus14;
    this.CPlusPlus1z = $Prm0.CPlusPlus1z;
    this.ObjC1 = $Prm0.ObjC1;
    this.ObjC2 = $Prm0.ObjC2;
    this.ObjCDefaultSynthProperties = $Prm0.ObjCDefaultSynthProperties;
    this.EncodeExtendedBlockSig = $Prm0.EncodeExtendedBlockSig;
    this.ObjCInferRelatedResultType = $Prm0.ObjCInferRelatedResultType;
    this.AppExt = $Prm0.AppExt;
    this.Trigraphs = $Prm0.Trigraphs;
    this.LineComment = $Prm0.LineComment;
    this.Bool = $Prm0.Bool;
    this.Half = $Prm0.Half;
    this.WChar = $Prm0.WChar;
    this.DeclSpecKeyword = $Prm0.DeclSpecKeyword;
    this.DollarIdents = $Prm0.DollarIdents;
    this.AsmPreprocessor = $Prm0.AsmPreprocessor;
    this.GNUMode = $Prm0.GNUMode;
    this.GNUKeywords = $Prm0.GNUKeywords;
    this.ImplicitInt = $Prm0.ImplicitInt;
    this.Digraphs = $Prm0.Digraphs;
    this.HexFloats = $Prm0.HexFloats;
    this.CXXOperatorNames = $Prm0.CXXOperatorNames;
    this.AppleKext = $Prm0.AppleKext;
    this.PascalStrings = $Prm0.PascalStrings;
    this.WritableStrings = $Prm0.WritableStrings;
    this.ConstStrings = $Prm0.ConstStrings;
    this.LaxVectorConversions = $Prm0.LaxVectorConversions;
    this.AltiVec = $Prm0.AltiVec;
    this.ZVector = $Prm0.ZVector;
    this.Exceptions = $Prm0.Exceptions;
    this.ObjCExceptions = $Prm0.ObjCExceptions;
    this.CXXExceptions = $Prm0.CXXExceptions;
    this.SjLjExceptions = $Prm0.SjLjExceptions;
    this.ExternCNoUnwind = $Prm0.ExternCNoUnwind;
    this.TraditionalCPP = $Prm0.TraditionalCPP;
    this.RTTI = $Prm0.RTTI;
    this.RTTIData = $Prm0.RTTIData;
    this.MSBitfields = $Prm0.MSBitfields;
    this.Freestanding = $Prm0.Freestanding;
    this.NoBuiltin = $Prm0.NoBuiltin;
    this.NoMathBuiltin = $Prm0.NoMathBuiltin;
    this.GNUAsm = $Prm0.GNUAsm;
    this.Coroutines = $Prm0.Coroutines;
    this.ThreadsafeStatics = $Prm0.ThreadsafeStatics;
    this.POSIXThreads = $Prm0.POSIXThreads;
    this.Blocks = $Prm0.Blocks;
    this.EmitAllDecls = $Prm0.EmitAllDecls;
    this.MathErrno = $Prm0.MathErrno;
    this.HeinousExtensions = $Prm0.HeinousExtensions;
    this.Modules = $Prm0.Modules;
    this.CompilingModule = $Prm0.CompilingModule;
    this.ModulesDeclUse = $Prm0.ModulesDeclUse;
    this.ModulesSearchAll = $Prm0.ModulesSearchAll;
    this.ModulesStrictDeclUse = $Prm0.ModulesStrictDeclUse;
    this.ModulesErrorRecovery = $Prm0.ModulesErrorRecovery;
    this.ImplicitModules = $Prm0.ImplicitModules;
    this.ModulesLocalVisibility = $Prm0.ModulesLocalVisibility;
    this.Optimize = $Prm0.Optimize;
    this.OptimizeSize = $Prm0.OptimizeSize;
    this.Static = $Prm0.Static;
    this.PackStruct = $Prm0.PackStruct;
    this.MaxTypeAlign = $Prm0.MaxTypeAlign;
    this.AlignDouble = $Prm0.AlignDouble;
    this.PICLevel = $Prm0.PICLevel;
    this.PIE = $Prm0.PIE;
    this.GNUInline = $Prm0.GNUInline;
    this.NoInlineDefine = $Prm0.NoInlineDefine;
    this.Deprecated = $Prm0.Deprecated;
    this.FastMath = $Prm0.FastMath;
    this.FiniteMathOnly = $Prm0.FiniteMathOnly;
    this.UnsafeFPMath = $Prm0.UnsafeFPMath;
    this.ObjCGCBitmapPrint = $Prm0.ObjCGCBitmapPrint;
    this.AccessControl = $Prm0.AccessControl;
    this.CharIsSigned = $Prm0.CharIsSigned;
    this.ShortWChar = $Prm0.ShortWChar;
    this.ShortEnums = $Prm0.ShortEnums;
    this.OpenCL = $Prm0.OpenCL;
    this.OpenCLVersion = $Prm0.OpenCLVersion;
    this.NativeHalfType = $Prm0.NativeHalfType;
    this.NativeHalfArgsAndReturns = $Prm0.NativeHalfArgsAndReturns;
    this.HalfArgsAndReturns = $Prm0.HalfArgsAndReturns;
    this.CUDA = $Prm0.CUDA;
    this.OpenMP = $Prm0.OpenMP;
    this.OpenMPUseTLS = $Prm0.OpenMPUseTLS;
    this.OpenMPIsDevice = $Prm0.OpenMPIsDevice;
    this.RenderScript = $Prm0.RenderScript;
    this.CUDAIsDevice = $Prm0.CUDAIsDevice;
    this.CUDAAllowVariadicFunctions = $Prm0.CUDAAllowVariadicFunctions;
    this.CUDAHostDeviceConstexpr = $Prm0.CUDAHostDeviceConstexpr;
    this.CUDADeviceFlushDenormalsToZero = $Prm0.CUDADeviceFlushDenormalsToZero;
    this.CUDADeviceApproxTranscendentals = $Prm0.CUDADeviceApproxTranscendentals;
    this.SizedDeallocation = $Prm0.SizedDeallocation;
    this.ConceptsTS = $Prm0.ConceptsTS;
    this.ElideConstructors = $Prm0.ElideConstructors;
    this.DumpRecordLayouts = $Prm0.DumpRecordLayouts;
    this.DumpRecordLayoutsSimple = $Prm0.DumpRecordLayoutsSimple;
    this.DumpVTableLayouts = $Prm0.DumpVTableLayouts;
    this.NoConstantCFStrings = $Prm0.NoConstantCFStrings;
    this.InlineVisibilityHidden = $Prm0.InlineVisibilityHidden;
    this.ParseUnknownAnytype = $Prm0.ParseUnknownAnytype;
    this.DebuggerSupport = $Prm0.DebuggerSupport;
    this.DebuggerCastResultToId = $Prm0.DebuggerCastResultToId;
    this.DebuggerObjCLiteral = $Prm0.DebuggerObjCLiteral;
    this.SpellChecking = $Prm0.SpellChecking;
    this.SinglePrecisionConstants = $Prm0.SinglePrecisionConstants;
    this.FastRelaxedMath = $Prm0.FastRelaxedMath;
    this.DefaultFPContract = $Prm0.DefaultFPContract;
    this.NoBitFieldTypeAlign = $Prm0.NoBitFieldTypeAlign;
    this.HexagonQdsp6Compat = $Prm0.HexagonQdsp6Compat;
    this.ObjCAutoRefCount = $Prm0.ObjCAutoRefCount;
    this.ObjCWeakRuntime = $Prm0.ObjCWeakRuntime;
    this.ObjCWeak = $Prm0.ObjCWeak;
    this.ObjCSubscriptingLegacyRuntime = $Prm0.ObjCSubscriptingLegacyRuntime;
    this.FakeAddressSpaceMap = $Prm0.FakeAddressSpaceMap;
    this.IncludeDefaultHeader = $Prm0.IncludeDefaultHeader;
    this.DelayedTemplateParsing = $Prm0.DelayedTemplateParsing;
    this.BlocksRuntimeOptional = $Prm0.BlocksRuntimeOptional;
    this.ArrowDepth = $Prm0.ArrowDepth;
    this.InstantiationDepth = $Prm0.InstantiationDepth;
    this.ConstexprCallDepth = $Prm0.ConstexprCallDepth;
    this.ConstexprStepLimit = $Prm0.ConstexprStepLimit;
    this.BracketDepth = $Prm0.BracketDepth;
    this.NumLargeByValueCopy = $Prm0.NumLargeByValueCopy;
    this.MSCompatibilityVersion = $Prm0.MSCompatibilityVersion;
    this.VtorDispMode = $Prm0.VtorDispMode;
    this.ApplePragmaPack = $Prm0.ApplePragmaPack;
    this.RetainCommentsFromSystemHeaders = $Prm0.RetainCommentsFromSystemHeaders;
    this.SanitizeAddressFieldPadding = $Prm0.SanitizeAddressFieldPadding;
    this.MSPointerToMemberRepresentationMethod = $Prm0.MSPointerToMemberRepresentationMethod;
    this.DefaultCallingConv = $Prm0.DefaultCallingConv;
    this.AddressSpaceMapMangling = $Prm0.AddressSpaceMapMangling;
    this.GC = $Prm0.GC;
    this.ValueVisibilityMode = $Prm0.ValueVisibilityMode;
    this.TypeVisibilityMode = $Prm0.TypeVisibilityMode;
    this.StackProtector = $Prm0.StackProtector;
    this.SignedOverflowBehavior = $Prm0.SignedOverflowBehavior;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::LangOptionsBase::LangOptionsBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 30,
   FQN="clang::LangOptionsBase::LangOptionsBase", NM="_ZN5clang15LangOptionsBaseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/AnalyzerOptions.cpp -nm=_ZN5clang15LangOptionsBaseC1ERKS0_")
  //</editor-fold>
  public /*inline*/ LangOptionsBase(/*const*/ LangOptionsBase /*&*/ $Prm0) {
    /* : C99(.C99), C11(.C11), MSVCCompat(.MSVCCompat), MicrosoftExt(.MicrosoftExt), AsmBlocks(.AsmBlocks), Borland(.Borland), CPlusPlus(.CPlusPlus), CPlusPlus11(.CPlusPlus11), CPlusPlus14(.CPlusPlus14), CPlusPlus1z(.CPlusPlus1z), ObjC1(.ObjC1), ObjC2(.ObjC2), ObjCDefaultSynthProperties(.ObjCDefaultSynthProperties), EncodeExtendedBlockSig(.EncodeExtendedBlockSig), ObjCInferRelatedResultType(.ObjCInferRelatedResultType), AppExt(.AppExt), Trigraphs(.Trigraphs), LineComment(.LineComment), Bool(.Bool), Half(.Half), WChar(.WChar), DeclSpecKeyword(.DeclSpecKeyword), DollarIdents(.DollarIdents), AsmPreprocessor(.AsmPreprocessor), GNUMode(.GNUMode), GNUKeywords(.GNUKeywords), ImplicitInt(.ImplicitInt), Digraphs(.Digraphs), HexFloats(.HexFloats), CXXOperatorNames(.CXXOperatorNames), AppleKext(.AppleKext), PascalStrings(.PascalStrings), WritableStrings(.WritableStrings), ConstStrings(.ConstStrings), LaxVectorConversions(.LaxVectorConversions), AltiVec(.AltiVec), ZVector(.ZVector), Exceptions(.Exceptions), ObjCExceptions(.ObjCExceptions), CXXExceptions(.CXXExceptions), SjLjExceptions(.SjLjExceptions), ExternCNoUnwind(.ExternCNoUnwind), TraditionalCPP(.TraditionalCPP), RTTI(.RTTI), RTTIData(.RTTIData), MSBitfields(.MSBitfields), Freestanding(.Freestanding), NoBuiltin(.NoBuiltin), NoMathBuiltin(.NoMathBuiltin), GNUAsm(.GNUAsm), Coroutines(.Coroutines), ThreadsafeStatics(.ThreadsafeStatics), POSIXThreads(.POSIXThreads), Blocks(.Blocks), EmitAllDecls(.EmitAllDecls), MathErrno(.MathErrno), HeinousExtensions(.HeinousExtensions), Modules(.Modules), CompilingModule(.CompilingModule), ModulesDeclUse(.ModulesDeclUse), ModulesSearchAll(.ModulesSearchAll), ModulesStrictDeclUse(.ModulesStrictDeclUse), ModulesErrorRecovery(.ModulesErrorRecovery), ImplicitModules(.ImplicitModules), ModulesLocalVisibility(.ModulesLocalVisibility), Optimize(.Optimize), OptimizeSize(.OptimizeSize), Static(.Static), PackStruct(.PackStruct), MaxTypeAlign(.MaxTypeAlign), AlignDouble(.AlignDouble), PICLevel(.PICLevel), PIE(.PIE), GNUInline(.GNUInline), NoInlineDefine(.NoInlineDefine), Deprecated(.Deprecated), FastMath(.FastMath), FiniteMathOnly(.FiniteMathOnly), UnsafeFPMath(.UnsafeFPMath), ObjCGCBitmapPrint(.ObjCGCBitmapPrint), AccessControl(.AccessControl), CharIsSigned(.CharIsSigned), ShortWChar(.ShortWChar), ShortEnums(.ShortEnums), OpenCL(.OpenCL), OpenCLVersion(.OpenCLVersion), NativeHalfType(.NativeHalfType), NativeHalfArgsAndReturns(.NativeHalfArgsAndReturns), HalfArgsAndReturns(.HalfArgsAndReturns), CUDA(.CUDA), OpenMP(.OpenMP), OpenMPUseTLS(.OpenMPUseTLS), OpenMPIsDevice(.OpenMPIsDevice), RenderScript(.RenderScript), CUDAIsDevice(.CUDAIsDevice), CUDAAllowVariadicFunctions(.CUDAAllowVariadicFunctions), CUDAHostDeviceConstexpr(.CUDAHostDeviceConstexpr), CUDADeviceFlushDenormalsToZero(.CUDADeviceFlushDenormalsToZero), CUDADeviceApproxTranscendentals(.CUDADeviceApproxTranscendentals), SizedDeallocation(.SizedDeallocation), ConceptsTS(.ConceptsTS), ElideConstructors(.ElideConstructors), DumpRecordLayouts(.DumpRecordLayouts), DumpRecordLayoutsSimple(.DumpRecordLayoutsSimple), DumpVTableLayouts(.DumpVTableLayouts), NoConstantCFStrings(.NoConstantCFStrings), InlineVisibilityHidden(.InlineVisibilityHidden), ParseUnknownAnytype(.ParseUnknownAnytype), DebuggerSupport(.DebuggerSupport), DebuggerCastResultToId(.DebuggerCastResultToId), DebuggerObjCLiteral(.DebuggerObjCLiteral), SpellChecking(.SpellChecking), SinglePrecisionConstants(.SinglePrecisionConstants), FastRelaxedMath(.FastRelaxedMath), DefaultFPContract(.DefaultFPContract), NoBitFieldTypeAlign(.NoBitFieldTypeAlign), HexagonQdsp6Compat(.HexagonQdsp6Compat), ObjCAutoRefCount(.ObjCAutoRefCount), ObjCWeakRuntime(.ObjCWeakRuntime), ObjCWeak(.ObjCWeak), ObjCSubscriptingLegacyRuntime(.ObjCSubscriptingLegacyRuntime), FakeAddressSpaceMap(.FakeAddressSpaceMap), IncludeDefaultHeader(.IncludeDefaultHeader), DelayedTemplateParsing(.DelayedTemplateParsing), BlocksRuntimeOptional(.BlocksRuntimeOptional), ArrowDepth(.ArrowDepth), InstantiationDepth(.InstantiationDepth), ConstexprCallDepth(.ConstexprCallDepth), ConstexprStepLimit(.ConstexprStepLimit), BracketDepth(.BracketDepth), NumLargeByValueCopy(.NumLargeByValueCopy), MSCompatibilityVersion(.MSCompatibilityVersion), VtorDispMode(.VtorDispMode), ApplePragmaPack(.ApplePragmaPack), RetainCommentsFromSystemHeaders(.RetainCommentsFromSystemHeaders), SanitizeAddressFieldPadding(.SanitizeAddressFieldPadding), MSPointerToMemberRepresentationMethod(.MSPointerToMemberRepresentationMethod), DefaultCallingConv(.DefaultCallingConv), AddressSpaceMapMangling(.AddressSpaceMapMangling), GC(.GC), ValueVisibilityMode(.ValueVisibilityMode), TypeVisibilityMode(.TypeVisibilityMode), StackProtector(.StackProtector), SignedOverflowBehavior(.SignedOverflowBehavior)*/ 
    //START JInit
    this.C99 = $Prm0.C99;
    this.C11 = $Prm0.C11;
    this.MSVCCompat = $Prm0.MSVCCompat;
    this.MicrosoftExt = $Prm0.MicrosoftExt;
    this.AsmBlocks = $Prm0.AsmBlocks;
    this.Borland = $Prm0.Borland;
    this.CPlusPlus = $Prm0.CPlusPlus;
    this.CPlusPlus11 = $Prm0.CPlusPlus11;
    this.CPlusPlus14 = $Prm0.CPlusPlus14;
    this.CPlusPlus1z = $Prm0.CPlusPlus1z;
    this.ObjC1 = $Prm0.ObjC1;
    this.ObjC2 = $Prm0.ObjC2;
    this.ObjCDefaultSynthProperties = $Prm0.ObjCDefaultSynthProperties;
    this.EncodeExtendedBlockSig = $Prm0.EncodeExtendedBlockSig;
    this.ObjCInferRelatedResultType = $Prm0.ObjCInferRelatedResultType;
    this.AppExt = $Prm0.AppExt;
    this.Trigraphs = $Prm0.Trigraphs;
    this.LineComment = $Prm0.LineComment;
    this.Bool = $Prm0.Bool;
    this.Half = $Prm0.Half;
    this.WChar = $Prm0.WChar;
    this.DeclSpecKeyword = $Prm0.DeclSpecKeyword;
    this.DollarIdents = $Prm0.DollarIdents;
    this.AsmPreprocessor = $Prm0.AsmPreprocessor;
    this.GNUMode = $Prm0.GNUMode;
    this.GNUKeywords = $Prm0.GNUKeywords;
    this.ImplicitInt = $Prm0.ImplicitInt;
    this.Digraphs = $Prm0.Digraphs;
    this.HexFloats = $Prm0.HexFloats;
    this.CXXOperatorNames = $Prm0.CXXOperatorNames;
    this.AppleKext = $Prm0.AppleKext;
    this.PascalStrings = $Prm0.PascalStrings;
    this.WritableStrings = $Prm0.WritableStrings;
    this.ConstStrings = $Prm0.ConstStrings;
    this.LaxVectorConversions = $Prm0.LaxVectorConversions;
    this.AltiVec = $Prm0.AltiVec;
    this.ZVector = $Prm0.ZVector;
    this.Exceptions = $Prm0.Exceptions;
    this.ObjCExceptions = $Prm0.ObjCExceptions;
    this.CXXExceptions = $Prm0.CXXExceptions;
    this.SjLjExceptions = $Prm0.SjLjExceptions;
    this.ExternCNoUnwind = $Prm0.ExternCNoUnwind;
    this.TraditionalCPP = $Prm0.TraditionalCPP;
    this.RTTI = $Prm0.RTTI;
    this.RTTIData = $Prm0.RTTIData;
    this.MSBitfields = $Prm0.MSBitfields;
    this.Freestanding = $Prm0.Freestanding;
    this.NoBuiltin = $Prm0.NoBuiltin;
    this.NoMathBuiltin = $Prm0.NoMathBuiltin;
    this.GNUAsm = $Prm0.GNUAsm;
    this.Coroutines = $Prm0.Coroutines;
    this.ThreadsafeStatics = $Prm0.ThreadsafeStatics;
    this.POSIXThreads = $Prm0.POSIXThreads;
    this.Blocks = $Prm0.Blocks;
    this.EmitAllDecls = $Prm0.EmitAllDecls;
    this.MathErrno = $Prm0.MathErrno;
    this.HeinousExtensions = $Prm0.HeinousExtensions;
    this.Modules = $Prm0.Modules;
    this.CompilingModule = $Prm0.CompilingModule;
    this.ModulesDeclUse = $Prm0.ModulesDeclUse;
    this.ModulesSearchAll = $Prm0.ModulesSearchAll;
    this.ModulesStrictDeclUse = $Prm0.ModulesStrictDeclUse;
    this.ModulesErrorRecovery = $Prm0.ModulesErrorRecovery;
    this.ImplicitModules = $Prm0.ImplicitModules;
    this.ModulesLocalVisibility = $Prm0.ModulesLocalVisibility;
    this.Optimize = $Prm0.Optimize;
    this.OptimizeSize = $Prm0.OptimizeSize;
    this.Static = $Prm0.Static;
    this.PackStruct = $Prm0.PackStruct;
    this.MaxTypeAlign = $Prm0.MaxTypeAlign;
    this.AlignDouble = $Prm0.AlignDouble;
    this.PICLevel = $Prm0.PICLevel;
    this.PIE = $Prm0.PIE;
    this.GNUInline = $Prm0.GNUInline;
    this.NoInlineDefine = $Prm0.NoInlineDefine;
    this.Deprecated = $Prm0.Deprecated;
    this.FastMath = $Prm0.FastMath;
    this.FiniteMathOnly = $Prm0.FiniteMathOnly;
    this.UnsafeFPMath = $Prm0.UnsafeFPMath;
    this.ObjCGCBitmapPrint = $Prm0.ObjCGCBitmapPrint;
    this.AccessControl = $Prm0.AccessControl;
    this.CharIsSigned = $Prm0.CharIsSigned;
    this.ShortWChar = $Prm0.ShortWChar;
    this.ShortEnums = $Prm0.ShortEnums;
    this.OpenCL = $Prm0.OpenCL;
    this.OpenCLVersion = $Prm0.OpenCLVersion;
    this.NativeHalfType = $Prm0.NativeHalfType;
    this.NativeHalfArgsAndReturns = $Prm0.NativeHalfArgsAndReturns;
    this.HalfArgsAndReturns = $Prm0.HalfArgsAndReturns;
    this.CUDA = $Prm0.CUDA;
    this.OpenMP = $Prm0.OpenMP;
    this.OpenMPUseTLS = $Prm0.OpenMPUseTLS;
    this.OpenMPIsDevice = $Prm0.OpenMPIsDevice;
    this.RenderScript = $Prm0.RenderScript;
    this.CUDAIsDevice = $Prm0.CUDAIsDevice;
    this.CUDAAllowVariadicFunctions = $Prm0.CUDAAllowVariadicFunctions;
    this.CUDAHostDeviceConstexpr = $Prm0.CUDAHostDeviceConstexpr;
    this.CUDADeviceFlushDenormalsToZero = $Prm0.CUDADeviceFlushDenormalsToZero;
    this.CUDADeviceApproxTranscendentals = $Prm0.CUDADeviceApproxTranscendentals;
    this.SizedDeallocation = $Prm0.SizedDeallocation;
    this.ConceptsTS = $Prm0.ConceptsTS;
    this.ElideConstructors = $Prm0.ElideConstructors;
    this.DumpRecordLayouts = $Prm0.DumpRecordLayouts;
    this.DumpRecordLayoutsSimple = $Prm0.DumpRecordLayoutsSimple;
    this.DumpVTableLayouts = $Prm0.DumpVTableLayouts;
    this.NoConstantCFStrings = $Prm0.NoConstantCFStrings;
    this.InlineVisibilityHidden = $Prm0.InlineVisibilityHidden;
    this.ParseUnknownAnytype = $Prm0.ParseUnknownAnytype;
    this.DebuggerSupport = $Prm0.DebuggerSupport;
    this.DebuggerCastResultToId = $Prm0.DebuggerCastResultToId;
    this.DebuggerObjCLiteral = $Prm0.DebuggerObjCLiteral;
    this.SpellChecking = $Prm0.SpellChecking;
    this.SinglePrecisionConstants = $Prm0.SinglePrecisionConstants;
    this.FastRelaxedMath = $Prm0.FastRelaxedMath;
    this.DefaultFPContract = $Prm0.DefaultFPContract;
    this.NoBitFieldTypeAlign = $Prm0.NoBitFieldTypeAlign;
    this.HexagonQdsp6Compat = $Prm0.HexagonQdsp6Compat;
    this.ObjCAutoRefCount = $Prm0.ObjCAutoRefCount;
    this.ObjCWeakRuntime = $Prm0.ObjCWeakRuntime;
    this.ObjCWeak = $Prm0.ObjCWeak;
    this.ObjCSubscriptingLegacyRuntime = $Prm0.ObjCSubscriptingLegacyRuntime;
    this.FakeAddressSpaceMap = $Prm0.FakeAddressSpaceMap;
    this.IncludeDefaultHeader = $Prm0.IncludeDefaultHeader;
    this.DelayedTemplateParsing = $Prm0.DelayedTemplateParsing;
    this.BlocksRuntimeOptional = $Prm0.BlocksRuntimeOptional;
    this.ArrowDepth = $Prm0.ArrowDepth;
    this.InstantiationDepth = $Prm0.InstantiationDepth;
    this.ConstexprCallDepth = $Prm0.ConstexprCallDepth;
    this.ConstexprStepLimit = $Prm0.ConstexprStepLimit;
    this.BracketDepth = $Prm0.BracketDepth;
    this.NumLargeByValueCopy = $Prm0.NumLargeByValueCopy;
    this.MSCompatibilityVersion = $Prm0.MSCompatibilityVersion;
    this.VtorDispMode = $Prm0.VtorDispMode;
    this.ApplePragmaPack = $Prm0.ApplePragmaPack;
    this.RetainCommentsFromSystemHeaders = $Prm0.RetainCommentsFromSystemHeaders;
    this.SanitizeAddressFieldPadding = $Prm0.SanitizeAddressFieldPadding;
    this.MSPointerToMemberRepresentationMethod = $Prm0.MSPointerToMemberRepresentationMethod;
    this.DefaultCallingConv = $Prm0.DefaultCallingConv;
    this.AddressSpaceMapMangling = $Prm0.AddressSpaceMapMangling;
    this.GC = $Prm0.GC;
    this.ValueVisibilityMode = $Prm0.ValueVisibilityMode;
    this.TypeVisibilityMode = $Prm0.TypeVisibilityMode;
    this.StackProtector = $Prm0.StackProtector;
    this.SignedOverflowBehavior = $Prm0.SignedOverflowBehavior;
    //END JInit
    trackInstance();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::LangOptionsBase::LangOptionsBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 30,
   FQN="clang::LangOptionsBase::LangOptionsBase", NM="_ZN5clang15LangOptionsBaseC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang15LangOptionsBaseC1EOS0_")
  //</editor-fold>
  public /*inline*/ LangOptionsBase(JD$Move _dparam, LangOptionsBase /*&&*/$Prm0) {
    /* : C99(static_cast<LangOptionsBase &&>().C99), C11(static_cast<LangOptionsBase &&>().C11), MSVCCompat(static_cast<LangOptionsBase &&>().MSVCCompat), MicrosoftExt(static_cast<LangOptionsBase &&>().MicrosoftExt), AsmBlocks(static_cast<LangOptionsBase &&>().AsmBlocks), Borland(static_cast<LangOptionsBase &&>().Borland), CPlusPlus(static_cast<LangOptionsBase &&>().CPlusPlus), CPlusPlus11(static_cast<LangOptionsBase &&>().CPlusPlus11), CPlusPlus14(static_cast<LangOptionsBase &&>().CPlusPlus14), CPlusPlus1z(static_cast<LangOptionsBase &&>().CPlusPlus1z), ObjC1(static_cast<LangOptionsBase &&>().ObjC1), ObjC2(static_cast<LangOptionsBase &&>().ObjC2), ObjCDefaultSynthProperties(static_cast<LangOptionsBase &&>().ObjCDefaultSynthProperties), EncodeExtendedBlockSig(static_cast<LangOptionsBase &&>().EncodeExtendedBlockSig), ObjCInferRelatedResultType(static_cast<LangOptionsBase &&>().ObjCInferRelatedResultType), AppExt(static_cast<LangOptionsBase &&>().AppExt), Trigraphs(static_cast<LangOptionsBase &&>().Trigraphs), LineComment(static_cast<LangOptionsBase &&>().LineComment), Bool(static_cast<LangOptionsBase &&>().Bool), Half(static_cast<LangOptionsBase &&>().Half), WChar(static_cast<LangOptionsBase &&>().WChar), DeclSpecKeyword(static_cast<LangOptionsBase &&>().DeclSpecKeyword), DollarIdents(static_cast<LangOptionsBase &&>().DollarIdents), AsmPreprocessor(static_cast<LangOptionsBase &&>().AsmPreprocessor), GNUMode(static_cast<LangOptionsBase &&>().GNUMode), GNUKeywords(static_cast<LangOptionsBase &&>().GNUKeywords), ImplicitInt(static_cast<LangOptionsBase &&>().ImplicitInt), Digraphs(static_cast<LangOptionsBase &&>().Digraphs), HexFloats(static_cast<LangOptionsBase &&>().HexFloats), CXXOperatorNames(static_cast<LangOptionsBase &&>().CXXOperatorNames), AppleKext(static_cast<LangOptionsBase &&>().AppleKext), PascalStrings(static_cast<LangOptionsBase &&>().PascalStrings), WritableStrings(static_cast<LangOptionsBase &&>().WritableStrings), ConstStrings(static_cast<LangOptionsBase &&>().ConstStrings), LaxVectorConversions(static_cast<LangOptionsBase &&>().LaxVectorConversions), AltiVec(static_cast<LangOptionsBase &&>().AltiVec), ZVector(static_cast<LangOptionsBase &&>().ZVector), Exceptions(static_cast<LangOptionsBase &&>().Exceptions), ObjCExceptions(static_cast<LangOptionsBase &&>().ObjCExceptions), CXXExceptions(static_cast<LangOptionsBase &&>().CXXExceptions), SjLjExceptions(static_cast<LangOptionsBase &&>().SjLjExceptions), ExternCNoUnwind(static_cast<LangOptionsBase &&>().ExternCNoUnwind), TraditionalCPP(static_cast<LangOptionsBase &&>().TraditionalCPP), RTTI(static_cast<LangOptionsBase &&>().RTTI), RTTIData(static_cast<LangOptionsBase &&>().RTTIData), MSBitfields(static_cast<LangOptionsBase &&>().MSBitfields), Freestanding(static_cast<LangOptionsBase &&>().Freestanding), NoBuiltin(static_cast<LangOptionsBase &&>().NoBuiltin), NoMathBuiltin(static_cast<LangOptionsBase &&>().NoMathBuiltin), GNUAsm(static_cast<LangOptionsBase &&>().GNUAsm), Coroutines(static_cast<LangOptionsBase &&>().Coroutines), ThreadsafeStatics(static_cast<LangOptionsBase &&>().ThreadsafeStatics), POSIXThreads(static_cast<LangOptionsBase &&>().POSIXThreads), Blocks(static_cast<LangOptionsBase &&>().Blocks), EmitAllDecls(static_cast<LangOptionsBase &&>().EmitAllDecls), MathErrno(static_cast<LangOptionsBase &&>().MathErrno), HeinousExtensions(static_cast<LangOptionsBase &&>().HeinousExtensions), Modules(static_cast<LangOptionsBase &&>().Modules), CompilingModule(static_cast<LangOptionsBase &&>().CompilingModule), ModulesDeclUse(static_cast<LangOptionsBase &&>().ModulesDeclUse), ModulesSearchAll(static_cast<LangOptionsBase &&>().ModulesSearchAll), ModulesStrictDeclUse(static_cast<LangOptionsBase &&>().ModulesStrictDeclUse), ModulesErrorRecovery(static_cast<LangOptionsBase &&>().ModulesErrorRecovery), ImplicitModules(static_cast<LangOptionsBase &&>().ImplicitModules), ModulesLocalVisibility(static_cast<LangOptionsBase &&>().ModulesLocalVisibility), Optimize(static_cast<LangOptionsBase &&>().Optimize), OptimizeSize(static_cast<LangOptionsBase &&>().OptimizeSize), Static(static_cast<LangOptionsBase &&>().Static), PackStruct(static_cast<LangOptionsBase &&>().PackStruct), MaxTypeAlign(static_cast<LangOptionsBase &&>().MaxTypeAlign), AlignDouble(static_cast<LangOptionsBase &&>().AlignDouble), PICLevel(static_cast<LangOptionsBase &&>().PICLevel), PIE(static_cast<LangOptionsBase &&>().PIE), GNUInline(static_cast<LangOptionsBase &&>().GNUInline), NoInlineDefine(static_cast<LangOptionsBase &&>().NoInlineDefine), Deprecated(static_cast<LangOptionsBase &&>().Deprecated), FastMath(static_cast<LangOptionsBase &&>().FastMath), FiniteMathOnly(static_cast<LangOptionsBase &&>().FiniteMathOnly), UnsafeFPMath(static_cast<LangOptionsBase &&>().UnsafeFPMath), ObjCGCBitmapPrint(static_cast<LangOptionsBase &&>().ObjCGCBitmapPrint), AccessControl(static_cast<LangOptionsBase &&>().AccessControl), CharIsSigned(static_cast<LangOptionsBase &&>().CharIsSigned), ShortWChar(static_cast<LangOptionsBase &&>().ShortWChar), ShortEnums(static_cast<LangOptionsBase &&>().ShortEnums), OpenCL(static_cast<LangOptionsBase &&>().OpenCL), OpenCLVersion(static_cast<LangOptionsBase &&>().OpenCLVersion), NativeHalfType(static_cast<LangOptionsBase &&>().NativeHalfType), NativeHalfArgsAndReturns(static_cast<LangOptionsBase &&>().NativeHalfArgsAndReturns), HalfArgsAndReturns(static_cast<LangOptionsBase &&>().HalfArgsAndReturns), CUDA(static_cast<LangOptionsBase &&>().CUDA), OpenMP(static_cast<LangOptionsBase &&>().OpenMP), OpenMPUseTLS(static_cast<LangOptionsBase &&>().OpenMPUseTLS), OpenMPIsDevice(static_cast<LangOptionsBase &&>().OpenMPIsDevice), RenderScript(static_cast<LangOptionsBase &&>().RenderScript), CUDAIsDevice(static_cast<LangOptionsBase &&>().CUDAIsDevice), CUDAAllowVariadicFunctions(static_cast<LangOptionsBase &&>().CUDAAllowVariadicFunctions), CUDAHostDeviceConstexpr(static_cast<LangOptionsBase &&>().CUDAHostDeviceConstexpr), CUDADeviceFlushDenormalsToZero(static_cast<LangOptionsBase &&>().CUDADeviceFlushDenormalsToZero), CUDADeviceApproxTranscendentals(static_cast<LangOptionsBase &&>().CUDADeviceApproxTranscendentals), SizedDeallocation(static_cast<LangOptionsBase &&>().SizedDeallocation), ConceptsTS(static_cast<LangOptionsBase &&>().ConceptsTS), ElideConstructors(static_cast<LangOptionsBase &&>().ElideConstructors), DumpRecordLayouts(static_cast<LangOptionsBase &&>().DumpRecordLayouts), DumpRecordLayoutsSimple(static_cast<LangOptionsBase &&>().DumpRecordLayoutsSimple), DumpVTableLayouts(static_cast<LangOptionsBase &&>().DumpVTableLayouts), NoConstantCFStrings(static_cast<LangOptionsBase &&>().NoConstantCFStrings), InlineVisibilityHidden(static_cast<LangOptionsBase &&>().InlineVisibilityHidden), ParseUnknownAnytype(static_cast<LangOptionsBase &&>().ParseUnknownAnytype), DebuggerSupport(static_cast<LangOptionsBase &&>().DebuggerSupport), DebuggerCastResultToId(static_cast<LangOptionsBase &&>().DebuggerCastResultToId), DebuggerObjCLiteral(static_cast<LangOptionsBase &&>().DebuggerObjCLiteral), SpellChecking(static_cast<LangOptionsBase &&>().SpellChecking), SinglePrecisionConstants(static_cast<LangOptionsBase &&>().SinglePrecisionConstants), FastRelaxedMath(static_cast<LangOptionsBase &&>().FastRelaxedMath), DefaultFPContract(static_cast<LangOptionsBase &&>().DefaultFPContract), NoBitFieldTypeAlign(static_cast<LangOptionsBase &&>().NoBitFieldTypeAlign), HexagonQdsp6Compat(static_cast<LangOptionsBase &&>().HexagonQdsp6Compat), ObjCAutoRefCount(static_cast<LangOptionsBase &&>().ObjCAutoRefCount), ObjCWeakRuntime(static_cast<LangOptionsBase &&>().ObjCWeakRuntime), ObjCWeak(static_cast<LangOptionsBase &&>().ObjCWeak), ObjCSubscriptingLegacyRuntime(static_cast<LangOptionsBase &&>().ObjCSubscriptingLegacyRuntime), FakeAddressSpaceMap(static_cast<LangOptionsBase &&>().FakeAddressSpaceMap), IncludeDefaultHeader(static_cast<LangOptionsBase &&>().IncludeDefaultHeader), DelayedTemplateParsing(static_cast<LangOptionsBase &&>().DelayedTemplateParsing), BlocksRuntimeOptional(static_cast<LangOptionsBase &&>().BlocksRuntimeOptional), ArrowDepth(static_cast<LangOptionsBase &&>().ArrowDepth), InstantiationDepth(static_cast<LangOptionsBase &&>().InstantiationDepth), ConstexprCallDepth(static_cast<LangOptionsBase &&>().ConstexprCallDepth), ConstexprStepLimit(static_cast<LangOptionsBase &&>().ConstexprStepLimit), BracketDepth(static_cast<LangOptionsBase &&>().BracketDepth), NumLargeByValueCopy(static_cast<LangOptionsBase &&>().NumLargeByValueCopy), MSCompatibilityVersion(static_cast<LangOptionsBase &&>().MSCompatibilityVersion), VtorDispMode(static_cast<LangOptionsBase &&>().VtorDispMode), ApplePragmaPack(static_cast<LangOptionsBase &&>().ApplePragmaPack), RetainCommentsFromSystemHeaders(static_cast<LangOptionsBase &&>().RetainCommentsFromSystemHeaders), SanitizeAddressFieldPadding(static_cast<LangOptionsBase &&>().SanitizeAddressFieldPadding), MSPointerToMemberRepresentationMethod(static_cast<LangOptionsBase &&>().MSPointerToMemberRepresentationMethod), DefaultCallingConv(static_cast<LangOptionsBase &&>().DefaultCallingConv), AddressSpaceMapMangling(static_cast<LangOptionsBase &&>().AddressSpaceMapMangling), GC(static_cast<LangOptionsBase &&>().GC), ValueVisibilityMode(static_cast<LangOptionsBase &&>().ValueVisibilityMode), TypeVisibilityMode(static_cast<LangOptionsBase &&>().TypeVisibilityMode), StackProtector(static_cast<LangOptionsBase &&>().StackProtector), SignedOverflowBehavior(static_cast<LangOptionsBase &&>().SignedOverflowBehavior)*/ 
    //START JInit
    this.C99 = $Prm0.C99;
    this.C11 = $Prm0.C11;
    this.MSVCCompat = $Prm0.MSVCCompat;
    this.MicrosoftExt = $Prm0.MicrosoftExt;
    this.AsmBlocks = $Prm0.AsmBlocks;
    this.Borland = $Prm0.Borland;
    this.CPlusPlus = $Prm0.CPlusPlus;
    this.CPlusPlus11 = $Prm0.CPlusPlus11;
    this.CPlusPlus14 = $Prm0.CPlusPlus14;
    this.CPlusPlus1z = $Prm0.CPlusPlus1z;
    this.ObjC1 = $Prm0.ObjC1;
    this.ObjC2 = $Prm0.ObjC2;
    this.ObjCDefaultSynthProperties = $Prm0.ObjCDefaultSynthProperties;
    this.EncodeExtendedBlockSig = $Prm0.EncodeExtendedBlockSig;
    this.ObjCInferRelatedResultType = $Prm0.ObjCInferRelatedResultType;
    this.AppExt = $Prm0.AppExt;
    this.Trigraphs = $Prm0.Trigraphs;
    this.LineComment = $Prm0.LineComment;
    this.Bool = $Prm0.Bool;
    this.Half = $Prm0.Half;
    this.WChar = $Prm0.WChar;
    this.DeclSpecKeyword = $Prm0.DeclSpecKeyword;
    this.DollarIdents = $Prm0.DollarIdents;
    this.AsmPreprocessor = $Prm0.AsmPreprocessor;
    this.GNUMode = $Prm0.GNUMode;
    this.GNUKeywords = $Prm0.GNUKeywords;
    this.ImplicitInt = $Prm0.ImplicitInt;
    this.Digraphs = $Prm0.Digraphs;
    this.HexFloats = $Prm0.HexFloats;
    this.CXXOperatorNames = $Prm0.CXXOperatorNames;
    this.AppleKext = $Prm0.AppleKext;
    this.PascalStrings = $Prm0.PascalStrings;
    this.WritableStrings = $Prm0.WritableStrings;
    this.ConstStrings = $Prm0.ConstStrings;
    this.LaxVectorConversions = $Prm0.LaxVectorConversions;
    this.AltiVec = $Prm0.AltiVec;
    this.ZVector = $Prm0.ZVector;
    this.Exceptions = $Prm0.Exceptions;
    this.ObjCExceptions = $Prm0.ObjCExceptions;
    this.CXXExceptions = $Prm0.CXXExceptions;
    this.SjLjExceptions = $Prm0.SjLjExceptions;
    this.ExternCNoUnwind = $Prm0.ExternCNoUnwind;
    this.TraditionalCPP = $Prm0.TraditionalCPP;
    this.RTTI = $Prm0.RTTI;
    this.RTTIData = $Prm0.RTTIData;
    this.MSBitfields = $Prm0.MSBitfields;
    this.Freestanding = $Prm0.Freestanding;
    this.NoBuiltin = $Prm0.NoBuiltin;
    this.NoMathBuiltin = $Prm0.NoMathBuiltin;
    this.GNUAsm = $Prm0.GNUAsm;
    this.Coroutines = $Prm0.Coroutines;
    this.ThreadsafeStatics = $Prm0.ThreadsafeStatics;
    this.POSIXThreads = $Prm0.POSIXThreads;
    this.Blocks = $Prm0.Blocks;
    this.EmitAllDecls = $Prm0.EmitAllDecls;
    this.MathErrno = $Prm0.MathErrno;
    this.HeinousExtensions = $Prm0.HeinousExtensions;
    this.Modules = $Prm0.Modules;
    this.CompilingModule = $Prm0.CompilingModule;
    this.ModulesDeclUse = $Prm0.ModulesDeclUse;
    this.ModulesSearchAll = $Prm0.ModulesSearchAll;
    this.ModulesStrictDeclUse = $Prm0.ModulesStrictDeclUse;
    this.ModulesErrorRecovery = $Prm0.ModulesErrorRecovery;
    this.ImplicitModules = $Prm0.ImplicitModules;
    this.ModulesLocalVisibility = $Prm0.ModulesLocalVisibility;
    this.Optimize = $Prm0.Optimize;
    this.OptimizeSize = $Prm0.OptimizeSize;
    this.Static = $Prm0.Static;
    this.PackStruct = $Prm0.PackStruct;
    this.MaxTypeAlign = $Prm0.MaxTypeAlign;
    this.AlignDouble = $Prm0.AlignDouble;
    this.PICLevel = $Prm0.PICLevel;
    this.PIE = $Prm0.PIE;
    this.GNUInline = $Prm0.GNUInline;
    this.NoInlineDefine = $Prm0.NoInlineDefine;
    this.Deprecated = $Prm0.Deprecated;
    this.FastMath = $Prm0.FastMath;
    this.FiniteMathOnly = $Prm0.FiniteMathOnly;
    this.UnsafeFPMath = $Prm0.UnsafeFPMath;
    this.ObjCGCBitmapPrint = $Prm0.ObjCGCBitmapPrint;
    this.AccessControl = $Prm0.AccessControl;
    this.CharIsSigned = $Prm0.CharIsSigned;
    this.ShortWChar = $Prm0.ShortWChar;
    this.ShortEnums = $Prm0.ShortEnums;
    this.OpenCL = $Prm0.OpenCL;
    this.OpenCLVersion = $Prm0.OpenCLVersion;
    this.NativeHalfType = $Prm0.NativeHalfType;
    this.NativeHalfArgsAndReturns = $Prm0.NativeHalfArgsAndReturns;
    this.HalfArgsAndReturns = $Prm0.HalfArgsAndReturns;
    this.CUDA = $Prm0.CUDA;
    this.OpenMP = $Prm0.OpenMP;
    this.OpenMPUseTLS = $Prm0.OpenMPUseTLS;
    this.OpenMPIsDevice = $Prm0.OpenMPIsDevice;
    this.RenderScript = $Prm0.RenderScript;
    this.CUDAIsDevice = $Prm0.CUDAIsDevice;
    this.CUDAAllowVariadicFunctions = $Prm0.CUDAAllowVariadicFunctions;
    this.CUDAHostDeviceConstexpr = $Prm0.CUDAHostDeviceConstexpr;
    this.CUDADeviceFlushDenormalsToZero = $Prm0.CUDADeviceFlushDenormalsToZero;
    this.CUDADeviceApproxTranscendentals = $Prm0.CUDADeviceApproxTranscendentals;
    this.SizedDeallocation = $Prm0.SizedDeallocation;
    this.ConceptsTS = $Prm0.ConceptsTS;
    this.ElideConstructors = $Prm0.ElideConstructors;
    this.DumpRecordLayouts = $Prm0.DumpRecordLayouts;
    this.DumpRecordLayoutsSimple = $Prm0.DumpRecordLayoutsSimple;
    this.DumpVTableLayouts = $Prm0.DumpVTableLayouts;
    this.NoConstantCFStrings = $Prm0.NoConstantCFStrings;
    this.InlineVisibilityHidden = $Prm0.InlineVisibilityHidden;
    this.ParseUnknownAnytype = $Prm0.ParseUnknownAnytype;
    this.DebuggerSupport = $Prm0.DebuggerSupport;
    this.DebuggerCastResultToId = $Prm0.DebuggerCastResultToId;
    this.DebuggerObjCLiteral = $Prm0.DebuggerObjCLiteral;
    this.SpellChecking = $Prm0.SpellChecking;
    this.SinglePrecisionConstants = $Prm0.SinglePrecisionConstants;
    this.FastRelaxedMath = $Prm0.FastRelaxedMath;
    this.DefaultFPContract = $Prm0.DefaultFPContract;
    this.NoBitFieldTypeAlign = $Prm0.NoBitFieldTypeAlign;
    this.HexagonQdsp6Compat = $Prm0.HexagonQdsp6Compat;
    this.ObjCAutoRefCount = $Prm0.ObjCAutoRefCount;
    this.ObjCWeakRuntime = $Prm0.ObjCWeakRuntime;
    this.ObjCWeak = $Prm0.ObjCWeak;
    this.ObjCSubscriptingLegacyRuntime = $Prm0.ObjCSubscriptingLegacyRuntime;
    this.FakeAddressSpaceMap = $Prm0.FakeAddressSpaceMap;
    this.IncludeDefaultHeader = $Prm0.IncludeDefaultHeader;
    this.DelayedTemplateParsing = $Prm0.DelayedTemplateParsing;
    this.BlocksRuntimeOptional = $Prm0.BlocksRuntimeOptional;
    this.ArrowDepth = $Prm0.ArrowDepth;
    this.InstantiationDepth = $Prm0.InstantiationDepth;
    this.ConstexprCallDepth = $Prm0.ConstexprCallDepth;
    this.ConstexprStepLimit = $Prm0.ConstexprStepLimit;
    this.BracketDepth = $Prm0.BracketDepth;
    this.NumLargeByValueCopy = $Prm0.NumLargeByValueCopy;
    this.MSCompatibilityVersion = $Prm0.MSCompatibilityVersion;
    this.VtorDispMode = $Prm0.VtorDispMode;
    this.ApplePragmaPack = $Prm0.ApplePragmaPack;
    this.RetainCommentsFromSystemHeaders = $Prm0.RetainCommentsFromSystemHeaders;
    this.SanitizeAddressFieldPadding = $Prm0.SanitizeAddressFieldPadding;
    this.MSPointerToMemberRepresentationMethod = $Prm0.MSPointerToMemberRepresentationMethod;
    this.DefaultCallingConv = $Prm0.DefaultCallingConv;
    this.AddressSpaceMapMangling = $Prm0.AddressSpaceMapMangling;
    this.GC = $Prm0.GC;
    this.ValueVisibilityMode = $Prm0.ValueVisibilityMode;
    this.TypeVisibilityMode = $Prm0.TypeVisibilityMode;
    this.StackProtector = $Prm0.StackProtector;
    this.SignedOverflowBehavior = $Prm0.SignedOverflowBehavior;
    //END JInit
    trackInstance();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::LangOptionsBase::LangOptionsBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", line = 30,
   FQN="clang::LangOptionsBase::LangOptionsBase", NM="_ZN5clang15LangOptionsBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/LangOptions.cpp -nm=_ZN5clang15LangOptionsBaseC1Ev")
  //</editor-fold>
  public /*inline*/ LangOptionsBase() {
    trackInstance();
  }

  
  public String toString() {
    return "" + "C99=" + C99 // NOI18N
              + ", C11=" + C11 // NOI18N
              + ", MSVCCompat=" + MSVCCompat // NOI18N
              + ", MicrosoftExt=" + MicrosoftExt // NOI18N
              + ", AsmBlocks=" + AsmBlocks // NOI18N
              + ", Borland=" + Borland // NOI18N
              + ", CPlusPlus=" + CPlusPlus // NOI18N
              + ", CPlusPlus11=" + CPlusPlus11 // NOI18N
              + ", CPlusPlus14=" + CPlusPlus14 // NOI18N
              + ", CPlusPlus1z=" + CPlusPlus1z // NOI18N
              + ", ObjC1=" + ObjC1 // NOI18N
              + ", ObjC2=" + ObjC2 // NOI18N
              + ", ObjCDefaultSynthProperties=" + ObjCDefaultSynthProperties // NOI18N
              + ", EncodeExtendedBlockSig=" + EncodeExtendedBlockSig // NOI18N
              + ", ObjCInferRelatedResultType=" + ObjCInferRelatedResultType // NOI18N
              + ", AppExt=" + AppExt // NOI18N
              + ", Trigraphs=" + Trigraphs // NOI18N
              + ", LineComment=" + LineComment // NOI18N
              + ", Bool=" + Bool // NOI18N
              + ", Half=" + Half // NOI18N
              + ", WChar=" + WChar // NOI18N
              + ", DeclSpecKeyword=" + DeclSpecKeyword // NOI18N
              + ", DollarIdents=" + DollarIdents // NOI18N
              + ", AsmPreprocessor=" + AsmPreprocessor // NOI18N
              + ", GNUMode=" + GNUMode // NOI18N
              + ", GNUKeywords=" + GNUKeywords // NOI18N
              + ", ImplicitInt=" + ImplicitInt // NOI18N
              + ", Digraphs=" + Digraphs // NOI18N
              + ", HexFloats=" + HexFloats // NOI18N
              + ", CXXOperatorNames=" + CXXOperatorNames // NOI18N
              + ", AppleKext=" + AppleKext // NOI18N
              + ", PascalStrings=" + PascalStrings // NOI18N
              + ", WritableStrings=" + WritableStrings // NOI18N
              + ", ConstStrings=" + ConstStrings // NOI18N
              + ", LaxVectorConversions=" + LaxVectorConversions // NOI18N
              + ", AltiVec=" + AltiVec // NOI18N
              + ", ZVector=" + ZVector // NOI18N
              + ", Exceptions=" + Exceptions // NOI18N
              + ", ObjCExceptions=" + ObjCExceptions // NOI18N
              + ", CXXExceptions=" + CXXExceptions // NOI18N
              + ", SjLjExceptions=" + SjLjExceptions // NOI18N
              + ", ExternCNoUnwind=" + ExternCNoUnwind // NOI18N
              + ", TraditionalCPP=" + TraditionalCPP // NOI18N
              + ", RTTI=" + RTTI // NOI18N
              + ", RTTIData=" + RTTIData // NOI18N
              + ", MSBitfields=" + MSBitfields // NOI18N
              + ", Freestanding=" + Freestanding // NOI18N
              + ", NoBuiltin=" + NoBuiltin // NOI18N
              + ", NoMathBuiltin=" + NoMathBuiltin // NOI18N
              + ", GNUAsm=" + GNUAsm // NOI18N
              + ", Coroutines=" + Coroutines // NOI18N
              + ", ThreadsafeStatics=" + ThreadsafeStatics // NOI18N
              + ", POSIXThreads=" + POSIXThreads // NOI18N
              + ", Blocks=" + Blocks // NOI18N
              + ", EmitAllDecls=" + EmitAllDecls // NOI18N
              + ", MathErrno=" + MathErrno // NOI18N
              + ", HeinousExtensions=" + HeinousExtensions // NOI18N
              + ", Modules=" + Modules // NOI18N
              + ", CompilingModule=" + CompilingModule // NOI18N
              + ", ModulesDeclUse=" + ModulesDeclUse // NOI18N
              + ", ModulesSearchAll=" + ModulesSearchAll // NOI18N
              + ", ModulesStrictDeclUse=" + ModulesStrictDeclUse // NOI18N
              + ", ModulesErrorRecovery=" + ModulesErrorRecovery // NOI18N
              + ", ImplicitModules=" + ImplicitModules // NOI18N
              + ", ModulesLocalVisibility=" + ModulesLocalVisibility // NOI18N
              + ", Optimize=" + Optimize // NOI18N
              + ", OptimizeSize=" + OptimizeSize // NOI18N
              + ", Static=" + Static // NOI18N
              + ", PackStruct=" + PackStruct // NOI18N
              + ", MaxTypeAlign=" + MaxTypeAlign // NOI18N
              + ", AlignDouble=" + AlignDouble // NOI18N
              + ", PICLevel=" + PICLevel // NOI18N
              + ", PIE=" + PIE // NOI18N
              + ", GNUInline=" + GNUInline // NOI18N
              + ", NoInlineDefine=" + NoInlineDefine // NOI18N
              + ", Deprecated=" + Deprecated // NOI18N
              + ", FastMath=" + FastMath // NOI18N
              + ", FiniteMathOnly=" + FiniteMathOnly // NOI18N
              + ", UnsafeFPMath=" + UnsafeFPMath // NOI18N
              + ", ObjCGCBitmapPrint=" + ObjCGCBitmapPrint // NOI18N
              + ", AccessControl=" + AccessControl // NOI18N
              + ", CharIsSigned=" + CharIsSigned // NOI18N
              + ", ShortWChar=" + ShortWChar // NOI18N
              + ", ShortEnums=" + ShortEnums // NOI18N
              + ", OpenCL=" + OpenCL // NOI18N
              + ", OpenCLVersion=" + OpenCLVersion // NOI18N
              + ", NativeHalfType=" + NativeHalfType // NOI18N
              + ", NativeHalfArgsAndReturns=" + NativeHalfArgsAndReturns // NOI18N
              + ", HalfArgsAndReturns=" + HalfArgsAndReturns // NOI18N
              + ", CUDA=" + CUDA // NOI18N
              + ", OpenMP=" + OpenMP // NOI18N
              + ", OpenMPUseTLS=" + OpenMPUseTLS // NOI18N
              + ", OpenMPIsDevice=" + OpenMPIsDevice // NOI18N
              + ", RenderScript=" + RenderScript // NOI18N
              + ", CUDAIsDevice=" + CUDAIsDevice // NOI18N
              + ", CUDAAllowVariadicFunctions=" + CUDAAllowVariadicFunctions // NOI18N
              + ", CUDAHostDeviceConstexpr=" + CUDAHostDeviceConstexpr // NOI18N
              + ", CUDADeviceFlushDenormalsToZero=" + CUDADeviceFlushDenormalsToZero // NOI18N
              + ", CUDADeviceApproxTranscendentals=" + CUDADeviceApproxTranscendentals // NOI18N
              + ", SizedDeallocation=" + SizedDeallocation // NOI18N
              + ", ConceptsTS=" + ConceptsTS // NOI18N
              + ", ElideConstructors=" + ElideConstructors // NOI18N
              + ", DumpRecordLayouts=" + DumpRecordLayouts // NOI18N
              + ", DumpRecordLayoutsSimple=" + DumpRecordLayoutsSimple // NOI18N
              + ", DumpVTableLayouts=" + DumpVTableLayouts // NOI18N
              + ", NoConstantCFStrings=" + NoConstantCFStrings // NOI18N
              + ", InlineVisibilityHidden=" + InlineVisibilityHidden // NOI18N
              + ", ParseUnknownAnytype=" + ParseUnknownAnytype // NOI18N
              + ", DebuggerSupport=" + DebuggerSupport // NOI18N
              + ", DebuggerCastResultToId=" + DebuggerCastResultToId // NOI18N
              + ", DebuggerObjCLiteral=" + DebuggerObjCLiteral // NOI18N
              + ", SpellChecking=" + SpellChecking // NOI18N
              + ", SinglePrecisionConstants=" + SinglePrecisionConstants // NOI18N
              + ", FastRelaxedMath=" + FastRelaxedMath // NOI18N
              + ", DefaultFPContract=" + DefaultFPContract // NOI18N
              + ", NoBitFieldTypeAlign=" + NoBitFieldTypeAlign // NOI18N
              + ", HexagonQdsp6Compat=" + HexagonQdsp6Compat // NOI18N
              + ", ObjCAutoRefCount=" + ObjCAutoRefCount // NOI18N
              + ", ObjCWeakRuntime=" + ObjCWeakRuntime // NOI18N
              + ", ObjCWeak=" + ObjCWeak // NOI18N
              + ", ObjCSubscriptingLegacyRuntime=" + ObjCSubscriptingLegacyRuntime // NOI18N
              + ", FakeAddressSpaceMap=" + FakeAddressSpaceMap // NOI18N
              + ", IncludeDefaultHeader=" + IncludeDefaultHeader // NOI18N
              + ", DelayedTemplateParsing=" + DelayedTemplateParsing // NOI18N
              + ", BlocksRuntimeOptional=" + BlocksRuntimeOptional // NOI18N
              + ", ArrowDepth=" + ArrowDepth // NOI18N
              + ", InstantiationDepth=" + InstantiationDepth // NOI18N
              + ", ConstexprCallDepth=" + ConstexprCallDepth // NOI18N
              + ", ConstexprStepLimit=" + ConstexprStepLimit // NOI18N
              + ", BracketDepth=" + BracketDepth // NOI18N
              + ", NumLargeByValueCopy=" + NumLargeByValueCopy // NOI18N
              + ", MSCompatibilityVersion=" + MSCompatibilityVersion // NOI18N
              + ", VtorDispMode=" + VtorDispMode // NOI18N
              + ", ApplePragmaPack=" + ApplePragmaPack // NOI18N
              + ", RetainCommentsFromSystemHeaders=" + RetainCommentsFromSystemHeaders // NOI18N
              + ", SanitizeAddressFieldPadding=" + SanitizeAddressFieldPadding // NOI18N
              + ", MSPointerToMemberRepresentationMethod=" + MSPointerToMemberRepresentationMethod // NOI18N
              + ", DefaultCallingConv=" + DefaultCallingConv // NOI18N
              + ", AddressSpaceMapMangling=" + AddressSpaceMapMangling // NOI18N
              + ", GC=" + GC // NOI18N
              + ", ValueVisibilityMode=" + ValueVisibilityMode // NOI18N
              + ", TypeVisibilityMode=" + TypeVisibilityMode // NOI18N
              + ", StackProtector=" + StackProtector // NOI18N
              + ", SignedOverflowBehavior=" + SignedOverflowBehavior; // NOI18N
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }
  
  public static void clearStatistics() {
    instances = 0;
  }
  // JAVA: pass OS and return some integral value
  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s created:\t", LangOptionsBase.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    NativeTrace.dumpStatisticValue(LangOptionsBase.class.getSimpleName(), instances);
    return instances;
  }  
}
