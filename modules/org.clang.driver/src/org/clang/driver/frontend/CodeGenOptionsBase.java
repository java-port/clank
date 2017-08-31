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

package org.clang.driver.frontend;

import org.clank.support.*;
import org.clang.basic.codegenoptions.DebugInfoKind;
import org.clang.driver.frontend.CodeGenOptions.*;
import org.llvm.target.target.DebuggerKind;


/// \brief Bitfields of CodeGenOptions, split out from CodeGenOptions to ensure
/// that this large collection of bitfields is a trivial class type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptionsBase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed some field types to enums*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 30,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", old_line = 28,
 FQN="clang::CodeGenOptionsBase", NM="_ZN5clang18CodeGenOptionsBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang18CodeGenOptionsBaseE")
//</editor-fold>
public class CodeGenOptionsBase {
/*public:*/
  public /*JBIT unsigned int*/ boolean DisableIntegratedAS /*: 1*/;
  ///< -no-integrated-as
  public /*JBIT unsigned int*/ boolean CompressDebugSections /*: 1*/;
  ///< -Wa,-compress-debug-sections
  public /*JBIT unsigned int*/ boolean RelaxELFRelocations /*: 1*/;
  ///< -Wa,--mrelax-relocations
  public /*JBIT unsigned int*/ boolean AsmVerbose /*: 1*/;
  ///< -dA, -fverbose-asm.
  public /*JBIT unsigned int*/ boolean AssumeSaneOperatorNew /*: 1*/;
  ///< implicit __attribute__((malloc)) operator new
  public /*JBIT unsigned int*/ boolean Autolink /*: 1*/;
  ///< -fno-autolink
  public /*JBIT unsigned int*/ boolean ObjCAutoRefCountExceptions /*: 1*/;
  ///< Whether ARC should be EH-safe.
  public /*JBIT unsigned int*/ boolean Backchain /*: 1*/;
  ///< -mbackchain
  public /*JBIT unsigned int*/ boolean CoverageExtraChecksum /*: 1*/;
  ///< Whether we need a second checksum for functions in GCNO files.
  public /*JBIT unsigned int*/ boolean CoverageNoFunctionNamesInData /*: 1*/;
  ///< Do not include function names in GCDA files.
  public /*JBIT unsigned int*/ boolean CoverageExitBlockBeforeBody /*: 1*/;
  ///< Whether to emit the exit block before the body blocks in GCNO files.
  public /*JBIT unsigned int*/ boolean CXAAtExit /*: 1*/;
  ///< Use __cxa_atexit for calling destructors.
  public /*JBIT unsigned int*/ boolean CXXCtorDtorAliases /*: 1*/;
  ///< Emit complete ctors/dtors as linker
  ///< aliases to base ctors when possible.
  public /*JBIT unsigned int*/ boolean DataSections /*: 1*/;
  ///< Set when -fdata-sections is enabled.
  public /*JBIT unsigned int*/ boolean UniqueSectionNames /*: 1*/;
  ///< Set for -funique-section-names.
  public /*JBIT unsigned int*/ boolean DisableFPElim /*: 1*/;
  ///< Set when -fomit-frame-pointer is enabled.
  public /*JBIT unsigned int*/ boolean DisableFree /*: 1*/;
  ///< Don't free memory.
  public /*JBIT unsigned int*/ boolean DiscardValueNames /*: 1*/;
  ///< Discard Value Names from the IR (LLVMContext flag)
  public /*JBIT unsigned int*/ boolean DisableGCov /*: 1*/;
  ///< Don't run the GCov pass, for testing.
  public /*JBIT unsigned int*/ boolean DisableLLVMOpts /*: 1*/;
  ///< Don't run any optimizations, for use in
  ///< getting .bc files that correspond to the
  ///< internal state before optimizations are
  ///< done.
  public /*JBIT unsigned int*/ boolean DisableLLVMPasses /*: 1*/;
  ///< Don't run any LLVM IR passes to get
  ///< the pristine IR generated by the
  ///< frontend.
  public /*JBIT unsigned int*/ boolean DisableRedZone /*: 1*/;
  ///< Set when -mno-red-zone is enabled.
  public /*JBIT unsigned int*/ boolean DisableTailCalls /*: 1*/;
  ///< Do not emit tail calls.
  public /*JBIT unsigned int*/ boolean EmitDeclMetadata /*: 1*/;
  ///< Emit special metadata indicating what
  ///< Decl* various IR entities came from.
  ///< Only useful when running CodeGen as a
  ///< subroutine.
  public /*JBIT unsigned int*/ boolean EmitGcovArcs /*: 1*/;
  ///< Emit coverage data files, aka. GCDA.
  public /*JBIT unsigned int*/ boolean EmitGcovNotes /*: 1*/;
  ///< Emit coverage "notes" files, aka GCNO.
  public /*JBIT unsigned int*/ boolean EmitOpenCLArgMetadata /*: 1*/;
  ///< Emit OpenCL kernel arg metadata.
  public /*JBIT unsigned int*/ boolean EmulatedTLS /*: 1*/;
  public /*JBIT unsigned int*/ boolean ForbidGuardVariables /*: 1*/;
  ///< Issue errors if C++ guard variables
  ///< are required.
  public /*JBIT unsigned int*/ boolean FunctionSections /*: 1*/;
  ///< Set when -ffunction-sections is enabled.
  public /*JBIT unsigned int*/ boolean InstrumentFunctions /*: 1*/;
  ///< Set when -finstrument-functions is
  ///< enabled.
  public /*JBIT unsigned int*/ boolean XRayInstrumentFunctions /*: 1*/;
  ///< Set when -fxray-instrument is
  ///< enabled.
  
  ///< Set the minimum number of instructions in a function to determine selective
  ///< XRay instrumentation.
  public /*uint*/int XRayInstructionThreshold /*: 32*/;
  public /*JBIT unsigned int*/ boolean InstrumentForProfiling /*: 1*/;
  ///< Set when -pg is enabled.
  public /*JBIT unsigned int*/ boolean LessPreciseFPMAD /*: 1*/;
  ///< Enable less precise MAD instructions to
  ///< be generated.
  public /*JBIT unsigned int*/ boolean PrepareForLTO /*: 1*/;
  ///< Set when -flto is enabled on the
  ///< compile step.
  public /*JBIT unsigned int*/ boolean EmitSummaryIndex /*: 1*/;
  ///< Set when -flto=thin is enabled on the
  ///< compile step.
  public /*JBIT unsigned int*/ boolean IncrementalLinkerCompatible /*: 1*/;
  ///< Emit an object file which can
  ///< be used with an incremental
  ///< linker.
  public /*JBIT unsigned int*/ boolean MergeAllConstants /*: 1*/;
  ///< Merge identical constants.
  public /*JBIT unsigned int*/ boolean MergeFunctions /*: 1*/;
  ///< Set when -fmerge-functions is enabled.
  public /*JBIT unsigned int*/ boolean MSVolatile /*: 1*/;
  ///< Set when /volatile:ms is enabled.
  public /*JBIT unsigned int*/ boolean NoCommon /*: 1*/;
  ///< Set when -fno-common or C++ is enabled.
  public /*JBIT unsigned int*/ boolean NoDwarfDirectoryAsm /*: 1*/;
  ///< Set when -fno-dwarf-directory-asm is
  ///< enabled.
  public /*JBIT unsigned int*/ boolean NoExecStack /*: 1*/;
  ///< Set when -Wa,--noexecstack is enabled.
  public /*JBIT unsigned int*/ boolean FatalWarnings /*: 1*/;
  ///< Set when -Wa,--fatal-warnings is
  ///< enabled.
  public /*JBIT unsigned int*/ boolean EnableSegmentedStacks /*: 1*/;
  ///< Set when -fsplit-stack is enabled.
  public /*JBIT unsigned int*/ boolean NoImplicitFloat /*: 1*/;
  ///< Set when -mno-implicit-float is enabled.
  public /*JBIT unsigned int*/ boolean NoInfsFPMath /*: 1*/;
  ///< Assume FP arguments, results not +-Inf.
  public /*JBIT unsigned int*/ boolean NoSignedZeros /*: 1*/;
  ///< Allow ignoring the signedness of FP zero
  public /*JBIT unsigned int*/ boolean ReciprocalMath /*: 1*/;
  ///< Allow FP divisions to be reassociated.
  public /*JBIT unsigned int*/ boolean NoInline /*: 1*/;
  ///< Set when -fno-inline is enabled.
  ///< Disables use of the inline keyword.
  public /*JBIT unsigned int*/ boolean NoNaNsFPMath /*: 1*/;
  ///< Assume FP arguments, results not NaN.
  public /*JBIT unsigned int*/ boolean NoZeroInitializedInBSS /*: 1*/;
  public /*JBIT unsigned int*/ boolean OmitLeafFramePointer /*: 1*/;
  ///< Set when -momit-leaf-frame-pointer is
  ///< enabled.
  public /*JBYTE unsigned int*/ byte OptimizationLevel /*: 2*/;
  ///< The -O[0-3] option specified.
  public /*JBYTE unsigned int*/ byte OptimizeSize /*: 2*/;
  public /*JBIT unsigned int*/ boolean CoverageMapping /*: 1*/;
  ///< Generate coverage mapping regions to
  ///< enable code coverage analysis.
  public /*JBIT unsigned int*/ boolean DumpCoverageMapping /*: 1*/;
  public /*JBIT unsigned int*/ boolean RelaxAll /*: 1*/;
  ///< Relax all machine code instructions.
  public /*JBIT unsigned int*/ boolean RelaxedAliasing /*: 1*/;
  ///< Set when -fno-strict-aliasing is enabled.
  public /*JBIT unsigned int*/ boolean StructPathTBAA /*: 1*/;
  ///< Whether or not to use struct-path TBAA.
  public /*JBIT unsigned int*/ boolean SaveTempLabels /*: 1*/;
  ///< Save temporary labels.
  public /*JBIT unsigned int*/ boolean SanitizeAddressUseAfterScope /*: 1*/;
  ///< Enable use-after-scope detection
  ///< in AddressSanitizer
  public /*JBYTE unsigned int*/ byte SanitizeMemoryTrackOrigins /*: 2*/;
  ///< Enable tracking origins in
  ///< MemorySanitizer
  public /*JBIT unsigned int*/ boolean SanitizeMemoryUseAfterDtor /*: 1*/;
  ///< Enable use-after-delete detection
  ///< in MemorySanitizer
  public /*JBIT unsigned int*/ boolean SanitizeCfiCrossDso /*: 1*/;
  ///< Enable cross-dso support in CFI.
  public /*JBYTE unsigned int*/ byte SanitizeCoverageType /*: 2*/;
  ///< Type of sanitizer coverage
  ///< instrumentation.
  public /*JBIT unsigned int*/ boolean SanitizeCoverageIndirectCalls /*: 1*/;
  ///< Enable sanitizer coverage
  ///< for indirect calls.
  public /*JBIT unsigned int*/ boolean SanitizeCoverageTraceBB /*: 1*/;
  ///< Enable basic block tracing in
  ///< in sanitizer coverage.
  public /*JBIT unsigned int*/ boolean SanitizeCoverageTraceCmp /*: 1*/;
  ///< Enable cmp instruction tracing
  ///< in sanitizer coverage.
  public /*JBIT unsigned int*/ boolean SanitizeCoverage8bitCounters /*: 1*/;
  ///< Use 8-bit frequency counters
  ///< in sanitizer coverage.
  public /*JBIT unsigned int*/ boolean SanitizeCoverageTracePC /*: 1*/;
  ///< Enable PC tracing
  ///< in sanitizer coverage.
  public /*JBIT unsigned int*/ boolean SanitizeStats /*: 1*/;
  ///< Collect statistics for sanitizers.
  public /*JBIT unsigned int*/ boolean SimplifyLibCalls /*: 1*/;
  ///< Set when -fbuiltin is enabled.
  public /*JBIT unsigned int*/ boolean SoftFloat /*: 1*/;
  ///< -soft-float.
  public /*JBIT unsigned int*/ boolean StrictEnums /*: 1*/;
  ///< Optimize based on strict enum definition.
  public /*JBIT unsigned int*/ boolean StrictVTablePointers /*: 1*/;
  ///< Optimize based on the strict vtable pointers
  public /*JBIT unsigned int*/ boolean TimePasses /*: 1*/;
  ///< Set when -ftime-report is enabled.
  public /*JBIT unsigned int*/ boolean UnrollLoops /*: 1*/;
  ///< Control whether loops are unrolled.
  public /*JBIT unsigned int*/ boolean RerollLoops /*: 1*/;
  ///< Control whether loops are rerolled.
  public /*JBIT unsigned int*/ boolean NoUseJumpTables /*: 1*/;
  ///< Set when -fno-jump-tables is enabled.
  public /*JBIT unsigned int*/ boolean UnsafeFPMath /*: 1*/;
  ///< Allow unsafe floating point optzns.
  public /*JBIT unsigned int*/ boolean UnwindTables /*: 1*/;
  ///< Emit unwind tables.
  public /*JBIT unsigned int*/ boolean VectorizeBB /*: 1*/;
  ///< Run basic block vectorizer.
  public /*JBIT unsigned int*/ boolean VectorizeLoop /*: 1*/;
  ///< Run loop vectorizer.
  public /*JBIT unsigned int*/ boolean VectorizeSLP /*: 1*/;
  ///< Run SLP vectorizer.
  
  /// Attempt to use register sized accesses to bit-fields in structures, when
  /// possible.
  public /*JBIT unsigned int*/ boolean UseRegisterSizedBitfieldAccess /*: 1*/;
  public /*JBIT unsigned int*/ boolean VerifyModule /*: 1*/;
  ///< Control whether the module should be run
  ///< through the LLVM Verifier.
  public /*JBIT unsigned int*/ boolean StackRealignment /*: 1*/;
  ///< Control whether to force stack
  ///< realignment.
  public /*JBIT unsigned int*/ boolean UseInitArray /*: 1*/;
  ///< Control whether to use .init_array or
  ///< .ctors.
  public /*uint*/int StackAlignment /*: 32*/;
  ///< Overrides default stack
  ///< alignment, if not 0.
  public /*uint*/int StackProbeSize /*: 32*/;
  ///< Overrides default stack
  ///< probe size, even if 0.
  public /*JBIT unsigned int*/ boolean DebugColumnInfo /*: 1*/;
  ///< Whether or not to use column information
  ///< in debug info.
  public /*JBIT unsigned int*/ boolean DebugTypeExtRefs /*: 1*/;
  ///< Whether or not debug info should contain
  ///< external references to a PCH or module.
  public /*JBIT unsigned int*/ boolean DebugExplicitImport /*: 1*/;
  ///< Whether or not debug info should
  ///< contain explicit imports for
  ///< anonymous namespaces
  public /*JBIT unsigned int*/ boolean EmitLLVMUseLists /*: 1*/;
  ///< Control whether to serialize use-lists.
  public /*JBIT unsigned int*/ boolean WholeProgramVTables /*: 1*/;
  ///< Whether to apply whole-program
  ///  vtable optimization.
  
  /// Whether to use public LTO visibility for entities in std and stdext
  /// namespaces. This is enabled by clang-cl's /MT and /MTd flags.
  public /*JBIT unsigned int*/ boolean LTOVisibilityPublicStd /*: 1*/;
  
  /// The user specified number of registers to be used for integral arguments,
  /// or 0 if unspecified.
  public /*uint*/int NumRegisterParameters /*: 32*/;
  
  /// The lower bound for a buffer to be considered for stack protection.
  public /*uint*/int SSPBufferSize /*: 32*/;
  
  /// Dwarf version. Version zero indicates to LLVM that no DWARF should be
  /// emitted.
  public /*JBYTE unsigned int*/ byte DwarfVersion /*: 3*/;
  
  /// Whether we should emit CodeView debug information. It's possible to emit
  /// CodeView and DWARF into the same object.
  public /*JBIT unsigned int*/ boolean EmitCodeView /*: 1*/;
  
  /// Number of path components to strip when emitting checks. (0 == full
  /// filename)
  public /*uint*/int EmitCheckPathComponentsToStrip /*: 32*/;
/*protected:*/
  ///< Set when -femulated-tls is enabled.
  /// \brief FP_CONTRACT mode (on/off/fast).
  protected /*JBYTE unsigned int*/ FPContractModeKind FPContractMode /*: 2*/;
  /// \brief Embed Bitcode mode (off/all/bitcode/marker).
  protected /*JBYTE unsigned int*/ EmbedBitcodeKind EmbedBitcode /*: 2*/;
  ///< -fno-zero-initialized-in-bss.
  /// \brief Method of Objective-C dispatch to use.
  protected /*JBYTE unsigned int*/ ObjCDispatchMethodKind ObjCDispatchMethod /*: 2*/;
  ///< If -Os (==1) or -Oz (==2) is specified.
  
  /// \brief Choose profile instrumenation kind or no instrumentation.
  protected /*JBYTE unsigned int*/ ProfileInstrKind ProfileInstr /*: 2*/;
  /// \brief Choose profile kind for PGO use compilation.
  protected /*JBYTE unsigned int*/ ProfileInstrKind ProfileUse /*: 2*/;
  ///< Dump the generated coverage mapping
  ///< regions.
  
  /// If -fpcc-struct-return or -freg-struct-return is specified.
  protected /*JBYTE unsigned int*/ StructReturnConventionKind StructReturnConvention /*: 2*/;
  
  /// The kind of generated debug info.
  protected /*JBYTE unsigned int*/ DebugInfoKind DebugInfo /*: 3*/;
  
  /// Tune the debug info for this debugger.
  protected /*JBYTE unsigned int*/ DebuggerKind DebuggerTuning /*: 2*/;
  
  /// The kind of inlining to perform.
  protected /*JBYTE unsigned int*/ InliningMethod Inlining /*: 2*/;
  
  // Vector functions library to use.
  protected /*JBIT unsigned int*/ VectorLibrary VecLib /*: 1*/;
  
  /// The default TLS model to use.
  protected /*JBYTE unsigned int*/ TLSModel DefaultTLSModel /*: 2*/;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptionsBase::CodeGenOptionsBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 30,
   FQN="clang::CodeGenOptionsBase::CodeGenOptionsBase", NM="_ZN5clang18CodeGenOptionsBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CodeGenOptions.cpp -nm=_ZN5clang18CodeGenOptionsBaseC1Ev")
  //</editor-fold>
  public /*inline*/ CodeGenOptionsBase() {
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenOptionsBase::CodeGenOptionsBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CodeGenOptions.h", line = 30,
   FQN="clang::CodeGenOptionsBase::CodeGenOptionsBase", NM="_ZN5clang18CodeGenOptionsBaseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang18CodeGenOptionsBaseC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CodeGenOptionsBase(/*const*/ CodeGenOptionsBase /*&*/ $Prm0) {
    /* : DisableIntegratedAS(.DisableIntegratedAS), CompressDebugSections(.CompressDebugSections), RelaxELFRelocations(.RelaxELFRelocations), AsmVerbose(.AsmVerbose), AssumeSaneOperatorNew(.AssumeSaneOperatorNew), Autolink(.Autolink), ObjCAutoRefCountExceptions(.ObjCAutoRefCountExceptions), Backchain(.Backchain), CoverageExtraChecksum(.CoverageExtraChecksum), CoverageNoFunctionNamesInData(.CoverageNoFunctionNamesInData), CoverageExitBlockBeforeBody(.CoverageExitBlockBeforeBody), CXAAtExit(.CXAAtExit), CXXCtorDtorAliases(.CXXCtorDtorAliases), DataSections(.DataSections), UniqueSectionNames(.UniqueSectionNames), DisableFPElim(.DisableFPElim), DisableFree(.DisableFree), DiscardValueNames(.DiscardValueNames), DisableGCov(.DisableGCov), DisableLLVMOpts(.DisableLLVMOpts), DisableLLVMPasses(.DisableLLVMPasses), DisableRedZone(.DisableRedZone), DisableTailCalls(.DisableTailCalls), EmitDeclMetadata(.EmitDeclMetadata), EmitGcovArcs(.EmitGcovArcs), EmitGcovNotes(.EmitGcovNotes), EmitOpenCLArgMetadata(.EmitOpenCLArgMetadata), EmulatedTLS(.EmulatedTLS), ForbidGuardVariables(.ForbidGuardVariables), FunctionSections(.FunctionSections), InstrumentFunctions(.InstrumentFunctions), XRayInstrumentFunctions(.XRayInstrumentFunctions), XRayInstructionThreshold(.XRayInstructionThreshold), InstrumentForProfiling(.InstrumentForProfiling), LessPreciseFPMAD(.LessPreciseFPMAD), PrepareForLTO(.PrepareForLTO), EmitSummaryIndex(.EmitSummaryIndex), IncrementalLinkerCompatible(.IncrementalLinkerCompatible), MergeAllConstants(.MergeAllConstants), MergeFunctions(.MergeFunctions), MSVolatile(.MSVolatile), NoCommon(.NoCommon), NoDwarfDirectoryAsm(.NoDwarfDirectoryAsm), NoExecStack(.NoExecStack), FatalWarnings(.FatalWarnings), EnableSegmentedStacks(.EnableSegmentedStacks), NoImplicitFloat(.NoImplicitFloat), NoInfsFPMath(.NoInfsFPMath), NoSignedZeros(.NoSignedZeros), ReciprocalMath(.ReciprocalMath), NoInline(.NoInline), NoNaNsFPMath(.NoNaNsFPMath), NoZeroInitializedInBSS(.NoZeroInitializedInBSS), OmitLeafFramePointer(.OmitLeafFramePointer), OptimizationLevel(.OptimizationLevel), OptimizeSize(.OptimizeSize), CoverageMapping(.CoverageMapping), DumpCoverageMapping(.DumpCoverageMapping), RelaxAll(.RelaxAll), RelaxedAliasing(.RelaxedAliasing), StructPathTBAA(.StructPathTBAA), SaveTempLabels(.SaveTempLabels), SanitizeAddressUseAfterScope(.SanitizeAddressUseAfterScope), SanitizeMemoryTrackOrigins(.SanitizeMemoryTrackOrigins), SanitizeMemoryUseAfterDtor(.SanitizeMemoryUseAfterDtor), SanitizeCfiCrossDso(.SanitizeCfiCrossDso), SanitizeCoverageType(.SanitizeCoverageType), SanitizeCoverageIndirectCalls(.SanitizeCoverageIndirectCalls), SanitizeCoverageTraceBB(.SanitizeCoverageTraceBB), SanitizeCoverageTraceCmp(.SanitizeCoverageTraceCmp), SanitizeCoverage8bitCounters(.SanitizeCoverage8bitCounters), SanitizeCoverageTracePC(.SanitizeCoverageTracePC), SanitizeStats(.SanitizeStats), SimplifyLibCalls(.SimplifyLibCalls), SoftFloat(.SoftFloat), StrictEnums(.StrictEnums), StrictVTablePointers(.StrictVTablePointers), TimePasses(.TimePasses), UnrollLoops(.UnrollLoops), RerollLoops(.RerollLoops), NoUseJumpTables(.NoUseJumpTables), UnsafeFPMath(.UnsafeFPMath), UnwindTables(.UnwindTables), VectorizeBB(.VectorizeBB), VectorizeLoop(.VectorizeLoop), VectorizeSLP(.VectorizeSLP), UseRegisterSizedBitfieldAccess(.UseRegisterSizedBitfieldAccess), VerifyModule(.VerifyModule), StackRealignment(.StackRealignment), UseInitArray(.UseInitArray), StackAlignment(.StackAlignment), StackProbeSize(.StackProbeSize), DebugColumnInfo(.DebugColumnInfo), DebugTypeExtRefs(.DebugTypeExtRefs), DebugExplicitImport(.DebugExplicitImport), EmitLLVMUseLists(.EmitLLVMUseLists), WholeProgramVTables(.WholeProgramVTables), LTOVisibilityPublicStd(.LTOVisibilityPublicStd), NumRegisterParameters(.NumRegisterParameters), SSPBufferSize(.SSPBufferSize), DwarfVersion(.DwarfVersion), EmitCodeView(.EmitCodeView), EmitCheckPathComponentsToStrip(.EmitCheckPathComponentsToStrip), FPContractMode(.FPContractMode), EmbedBitcode(.EmbedBitcode), ObjCDispatchMethod(.ObjCDispatchMethod), ProfileInstr(.ProfileInstr), ProfileUse(.ProfileUse), StructReturnConvention(.StructReturnConvention), DebugInfo(.DebugInfo), DebuggerTuning(.DebuggerTuning), Inlining(.Inlining), VecLib(.VecLib), DefaultTLSModel(.DefaultTLSModel)*/ 
    //START JInit
    this.DisableIntegratedAS = $Prm0.DisableIntegratedAS;
    this.CompressDebugSections = $Prm0.CompressDebugSections;
    this.RelaxELFRelocations = $Prm0.RelaxELFRelocations;
    this.AsmVerbose = $Prm0.AsmVerbose;
    this.AssumeSaneOperatorNew = $Prm0.AssumeSaneOperatorNew;
    this.Autolink = $Prm0.Autolink;
    this.ObjCAutoRefCountExceptions = $Prm0.ObjCAutoRefCountExceptions;
    this.Backchain = $Prm0.Backchain;
    this.CoverageExtraChecksum = $Prm0.CoverageExtraChecksum;
    this.CoverageNoFunctionNamesInData = $Prm0.CoverageNoFunctionNamesInData;
    this.CoverageExitBlockBeforeBody = $Prm0.CoverageExitBlockBeforeBody;
    this.CXAAtExit = $Prm0.CXAAtExit;
    this.CXXCtorDtorAliases = $Prm0.CXXCtorDtorAliases;
    this.DataSections = $Prm0.DataSections;
    this.UniqueSectionNames = $Prm0.UniqueSectionNames;
    this.DisableFPElim = $Prm0.DisableFPElim;
    this.DisableFree = $Prm0.DisableFree;
    this.DiscardValueNames = $Prm0.DiscardValueNames;
    this.DisableGCov = $Prm0.DisableGCov;
    this.DisableLLVMOpts = $Prm0.DisableLLVMOpts;
    this.DisableLLVMPasses = $Prm0.DisableLLVMPasses;
    this.DisableRedZone = $Prm0.DisableRedZone;
    this.DisableTailCalls = $Prm0.DisableTailCalls;
    this.EmitDeclMetadata = $Prm0.EmitDeclMetadata;
    this.EmitGcovArcs = $Prm0.EmitGcovArcs;
    this.EmitGcovNotes = $Prm0.EmitGcovNotes;
    this.EmitOpenCLArgMetadata = $Prm0.EmitOpenCLArgMetadata;
    this.EmulatedTLS = $Prm0.EmulatedTLS;
    this.ForbidGuardVariables = $Prm0.ForbidGuardVariables;
    this.FunctionSections = $Prm0.FunctionSections;
    this.InstrumentFunctions = $Prm0.InstrumentFunctions;
    this.XRayInstrumentFunctions = $Prm0.XRayInstrumentFunctions;
    this.XRayInstructionThreshold = $Prm0.XRayInstructionThreshold;
    this.InstrumentForProfiling = $Prm0.InstrumentForProfiling;
    this.LessPreciseFPMAD = $Prm0.LessPreciseFPMAD;
    this.PrepareForLTO = $Prm0.PrepareForLTO;
    this.EmitSummaryIndex = $Prm0.EmitSummaryIndex;
    this.IncrementalLinkerCompatible = $Prm0.IncrementalLinkerCompatible;
    this.MergeAllConstants = $Prm0.MergeAllConstants;
    this.MergeFunctions = $Prm0.MergeFunctions;
    this.MSVolatile = $Prm0.MSVolatile;
    this.NoCommon = $Prm0.NoCommon;
    this.NoDwarfDirectoryAsm = $Prm0.NoDwarfDirectoryAsm;
    this.NoExecStack = $Prm0.NoExecStack;
    this.FatalWarnings = $Prm0.FatalWarnings;
    this.EnableSegmentedStacks = $Prm0.EnableSegmentedStacks;
    this.NoImplicitFloat = $Prm0.NoImplicitFloat;
    this.NoInfsFPMath = $Prm0.NoInfsFPMath;
    this.NoSignedZeros = $Prm0.NoSignedZeros;
    this.ReciprocalMath = $Prm0.ReciprocalMath;
    this.NoInline = $Prm0.NoInline;
    this.NoNaNsFPMath = $Prm0.NoNaNsFPMath;
    this.NoZeroInitializedInBSS = $Prm0.NoZeroInitializedInBSS;
    this.OmitLeafFramePointer = $Prm0.OmitLeafFramePointer;
    this.OptimizationLevel = $Prm0.OptimizationLevel;
    this.OptimizeSize = $Prm0.OptimizeSize;
    this.CoverageMapping = $Prm0.CoverageMapping;
    this.DumpCoverageMapping = $Prm0.DumpCoverageMapping;
    this.RelaxAll = $Prm0.RelaxAll;
    this.RelaxedAliasing = $Prm0.RelaxedAliasing;
    this.StructPathTBAA = $Prm0.StructPathTBAA;
    this.SaveTempLabels = $Prm0.SaveTempLabels;
    this.SanitizeAddressUseAfterScope = $Prm0.SanitizeAddressUseAfterScope;
    this.SanitizeMemoryTrackOrigins = $Prm0.SanitizeMemoryTrackOrigins;
    this.SanitizeMemoryUseAfterDtor = $Prm0.SanitizeMemoryUseAfterDtor;
    this.SanitizeCfiCrossDso = $Prm0.SanitizeCfiCrossDso;
    this.SanitizeCoverageType = $Prm0.SanitizeCoverageType;
    this.SanitizeCoverageIndirectCalls = $Prm0.SanitizeCoverageIndirectCalls;
    this.SanitizeCoverageTraceBB = $Prm0.SanitizeCoverageTraceBB;
    this.SanitizeCoverageTraceCmp = $Prm0.SanitizeCoverageTraceCmp;
    this.SanitizeCoverage8bitCounters = $Prm0.SanitizeCoverage8bitCounters;
    this.SanitizeCoverageTracePC = $Prm0.SanitizeCoverageTracePC;
    this.SanitizeStats = $Prm0.SanitizeStats;
    this.SimplifyLibCalls = $Prm0.SimplifyLibCalls;
    this.SoftFloat = $Prm0.SoftFloat;
    this.StrictEnums = $Prm0.StrictEnums;
    this.StrictVTablePointers = $Prm0.StrictVTablePointers;
    this.TimePasses = $Prm0.TimePasses;
    this.UnrollLoops = $Prm0.UnrollLoops;
    this.RerollLoops = $Prm0.RerollLoops;
    this.NoUseJumpTables = $Prm0.NoUseJumpTables;
    this.UnsafeFPMath = $Prm0.UnsafeFPMath;
    this.UnwindTables = $Prm0.UnwindTables;
    this.VectorizeBB = $Prm0.VectorizeBB;
    this.VectorizeLoop = $Prm0.VectorizeLoop;
    this.VectorizeSLP = $Prm0.VectorizeSLP;
    this.UseRegisterSizedBitfieldAccess = $Prm0.UseRegisterSizedBitfieldAccess;
    this.VerifyModule = $Prm0.VerifyModule;
    this.StackRealignment = $Prm0.StackRealignment;
    this.UseInitArray = $Prm0.UseInitArray;
    this.StackAlignment = $Prm0.StackAlignment;
    this.StackProbeSize = $Prm0.StackProbeSize;
    this.DebugColumnInfo = $Prm0.DebugColumnInfo;
    this.DebugTypeExtRefs = $Prm0.DebugTypeExtRefs;
    this.DebugExplicitImport = $Prm0.DebugExplicitImport;
    this.EmitLLVMUseLists = $Prm0.EmitLLVMUseLists;
    this.WholeProgramVTables = $Prm0.WholeProgramVTables;
    this.LTOVisibilityPublicStd = $Prm0.LTOVisibilityPublicStd;
    this.NumRegisterParameters = $Prm0.NumRegisterParameters;
    this.SSPBufferSize = $Prm0.SSPBufferSize;
    this.DwarfVersion = $Prm0.DwarfVersion;
    this.EmitCodeView = $Prm0.EmitCodeView;
    this.EmitCheckPathComponentsToStrip = $Prm0.EmitCheckPathComponentsToStrip;
    this.FPContractMode = $Prm0.FPContractMode;
    this.EmbedBitcode = $Prm0.EmbedBitcode;
    this.ObjCDispatchMethod = $Prm0.ObjCDispatchMethod;
    this.ProfileInstr = $Prm0.ProfileInstr;
    this.ProfileUse = $Prm0.ProfileUse;
    this.StructReturnConvention = $Prm0.StructReturnConvention;
    this.DebugInfo = $Prm0.DebugInfo;
    this.DebuggerTuning = $Prm0.DebuggerTuning;
    this.Inlining = $Prm0.Inlining;
    this.VecLib = $Prm0.VecLib;
    this.DefaultTLSModel = $Prm0.DefaultTLSModel;
    //END JInit
  }

  
  public String toString() {
    return "" + "DisableIntegratedAS=" + DisableIntegratedAS // NOI18N
              + ", CompressDebugSections=" + CompressDebugSections // NOI18N
              + ", RelaxELFRelocations=" + RelaxELFRelocations // NOI18N
              + ", AsmVerbose=" + AsmVerbose // NOI18N
              + ", AssumeSaneOperatorNew=" + AssumeSaneOperatorNew // NOI18N
              + ", Autolink=" + Autolink // NOI18N
              + ", ObjCAutoRefCountExceptions=" + ObjCAutoRefCountExceptions // NOI18N
              + ", Backchain=" + Backchain // NOI18N
              + ", CoverageExtraChecksum=" + CoverageExtraChecksum // NOI18N
              + ", CoverageNoFunctionNamesInData=" + CoverageNoFunctionNamesInData // NOI18N
              + ", CoverageExitBlockBeforeBody=" + CoverageExitBlockBeforeBody // NOI18N
              + ", CXAAtExit=" + CXAAtExit // NOI18N
              + ", CXXCtorDtorAliases=" + CXXCtorDtorAliases // NOI18N
              + ", DataSections=" + DataSections // NOI18N
              + ", UniqueSectionNames=" + UniqueSectionNames // NOI18N
              + ", DisableFPElim=" + DisableFPElim // NOI18N
              + ", DisableFree=" + DisableFree // NOI18N
              + ", DiscardValueNames=" + DiscardValueNames // NOI18N
              + ", DisableGCov=" + DisableGCov // NOI18N
              + ", DisableLLVMOpts=" + DisableLLVMOpts // NOI18N
              + ", DisableLLVMPasses=" + DisableLLVMPasses // NOI18N
              + ", DisableRedZone=" + DisableRedZone // NOI18N
              + ", DisableTailCalls=" + DisableTailCalls // NOI18N
              + ", EmitDeclMetadata=" + EmitDeclMetadata // NOI18N
              + ", EmitGcovArcs=" + EmitGcovArcs // NOI18N
              + ", EmitGcovNotes=" + EmitGcovNotes // NOI18N
              + ", EmitOpenCLArgMetadata=" + EmitOpenCLArgMetadata // NOI18N
              + ", EmulatedTLS=" + EmulatedTLS // NOI18N
              + ", ForbidGuardVariables=" + ForbidGuardVariables // NOI18N
              + ", FunctionSections=" + FunctionSections // NOI18N
              + ", InstrumentFunctions=" + InstrumentFunctions // NOI18N
              + ", XRayInstrumentFunctions=" + XRayInstrumentFunctions // NOI18N
              + ", XRayInstructionThreshold=" + XRayInstructionThreshold // NOI18N
              + ", InstrumentForProfiling=" + InstrumentForProfiling // NOI18N
              + ", LessPreciseFPMAD=" + LessPreciseFPMAD // NOI18N
              + ", PrepareForLTO=" + PrepareForLTO // NOI18N
              + ", EmitSummaryIndex=" + EmitSummaryIndex // NOI18N
              + ", IncrementalLinkerCompatible=" + IncrementalLinkerCompatible // NOI18N
              + ", MergeAllConstants=" + MergeAllConstants // NOI18N
              + ", MergeFunctions=" + MergeFunctions // NOI18N
              + ", MSVolatile=" + MSVolatile // NOI18N
              + ", NoCommon=" + NoCommon // NOI18N
              + ", NoDwarfDirectoryAsm=" + NoDwarfDirectoryAsm // NOI18N
              + ", NoExecStack=" + NoExecStack // NOI18N
              + ", FatalWarnings=" + FatalWarnings // NOI18N
              + ", EnableSegmentedStacks=" + EnableSegmentedStacks // NOI18N
              + ", NoImplicitFloat=" + NoImplicitFloat // NOI18N
              + ", NoInfsFPMath=" + NoInfsFPMath // NOI18N
              + ", NoSignedZeros=" + NoSignedZeros // NOI18N
              + ", ReciprocalMath=" + ReciprocalMath // NOI18N
              + ", NoInline=" + NoInline // NOI18N
              + ", NoNaNsFPMath=" + NoNaNsFPMath // NOI18N
              + ", NoZeroInitializedInBSS=" + NoZeroInitializedInBSS // NOI18N
              + ", OmitLeafFramePointer=" + OmitLeafFramePointer // NOI18N
              + ", OptimizationLevel=" + OptimizationLevel // NOI18N
              + ", OptimizeSize=" + OptimizeSize // NOI18N
              + ", CoverageMapping=" + CoverageMapping // NOI18N
              + ", DumpCoverageMapping=" + DumpCoverageMapping // NOI18N
              + ", RelaxAll=" + RelaxAll // NOI18N
              + ", RelaxedAliasing=" + RelaxedAliasing // NOI18N
              + ", StructPathTBAA=" + StructPathTBAA // NOI18N
              + ", SaveTempLabels=" + SaveTempLabels // NOI18N
              + ", SanitizeAddressUseAfterScope=" + SanitizeAddressUseAfterScope // NOI18N
              + ", SanitizeMemoryTrackOrigins=" + SanitizeMemoryTrackOrigins // NOI18N
              + ", SanitizeMemoryUseAfterDtor=" + SanitizeMemoryUseAfterDtor // NOI18N
              + ", SanitizeCfiCrossDso=" + SanitizeCfiCrossDso // NOI18N
              + ", SanitizeCoverageType=" + SanitizeCoverageType // NOI18N
              + ", SanitizeCoverageIndirectCalls=" + SanitizeCoverageIndirectCalls // NOI18N
              + ", SanitizeCoverageTraceBB=" + SanitizeCoverageTraceBB // NOI18N
              + ", SanitizeCoverageTraceCmp=" + SanitizeCoverageTraceCmp // NOI18N
              + ", SanitizeCoverage8bitCounters=" + SanitizeCoverage8bitCounters // NOI18N
              + ", SanitizeCoverageTracePC=" + SanitizeCoverageTracePC // NOI18N
              + ", SanitizeStats=" + SanitizeStats // NOI18N
              + ", SimplifyLibCalls=" + SimplifyLibCalls // NOI18N
              + ", SoftFloat=" + SoftFloat // NOI18N
              + ", StrictEnums=" + StrictEnums // NOI18N
              + ", StrictVTablePointers=" + StrictVTablePointers // NOI18N
              + ", TimePasses=" + TimePasses // NOI18N
              + ", UnrollLoops=" + UnrollLoops // NOI18N
              + ", RerollLoops=" + RerollLoops // NOI18N
              + ", NoUseJumpTables=" + NoUseJumpTables // NOI18N
              + ", UnsafeFPMath=" + UnsafeFPMath // NOI18N
              + ", UnwindTables=" + UnwindTables // NOI18N
              + ", VectorizeBB=" + VectorizeBB // NOI18N
              + ", VectorizeLoop=" + VectorizeLoop // NOI18N
              + ", VectorizeSLP=" + VectorizeSLP // NOI18N
              + ", UseRegisterSizedBitfieldAccess=" + UseRegisterSizedBitfieldAccess // NOI18N
              + ", VerifyModule=" + VerifyModule // NOI18N
              + ", StackRealignment=" + StackRealignment // NOI18N
              + ", UseInitArray=" + UseInitArray // NOI18N
              + ", StackAlignment=" + StackAlignment // NOI18N
              + ", StackProbeSize=" + StackProbeSize // NOI18N
              + ", DebugColumnInfo=" + DebugColumnInfo // NOI18N
              + ", DebugTypeExtRefs=" + DebugTypeExtRefs // NOI18N
              + ", DebugExplicitImport=" + DebugExplicitImport // NOI18N
              + ", EmitLLVMUseLists=" + EmitLLVMUseLists // NOI18N
              + ", WholeProgramVTables=" + WholeProgramVTables // NOI18N
              + ", LTOVisibilityPublicStd=" + LTOVisibilityPublicStd // NOI18N
              + ", NumRegisterParameters=" + NumRegisterParameters // NOI18N
              + ", SSPBufferSize=" + SSPBufferSize // NOI18N
              + ", DwarfVersion=" + DwarfVersion // NOI18N
              + ", EmitCodeView=" + EmitCodeView // NOI18N
              + ", EmitCheckPathComponentsToStrip=" + EmitCheckPathComponentsToStrip // NOI18N
              + ", FPContractMode=" + FPContractMode // NOI18N
              + ", EmbedBitcode=" + EmbedBitcode // NOI18N
              + ", ObjCDispatchMethod=" + ObjCDispatchMethod // NOI18N
              + ", ProfileInstr=" + ProfileInstr // NOI18N
              + ", ProfileUse=" + ProfileUse // NOI18N
              + ", StructReturnConvention=" + StructReturnConvention // NOI18N
              + ", DebugInfo=" + DebugInfo // NOI18N
              + ", DebuggerTuning=" + DebuggerTuning // NOI18N
              + ", Inlining=" + Inlining // NOI18N
              + ", VecLib=" + VecLib // NOI18N
              + ", DefaultTLSModel=" + DefaultTLSModel; // NOI18N
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected void $destroy() {}
}
