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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import org.llvm.ir.*;
import org.llvm.ir.Module;
import org.llvm.profiledata.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.target.impl.*;
import org.clang.driver.frontend.CodeGenOptions;
import org.clang.basic.target.TargetInfo;
import org.llvm.ir.Type;
import org.clang.ast.llvm.DenseMapInfoGlobalDecl;
import org.clang.ast.llvm.DenseMapInfoQualType;
import org.clang.basic.codegenoptions.DebugInfoKind;
import static org.clang.codegen.impl.CodeGenModuleStatics.*;
import org.llvm.adt.java.ADTFunctionPointers.ErrorInfoBase2Void;
import static org.llvm.support.AdtsupportLlvmGlobals.handleAllErrors$T;
import org.llvm.transforms.utils.SanitizerStatReport;
import org.llvm.support.Error;


/// This class organizes the cross-function state that is used while generating
/// LLVM code.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 246,
 FQN="clang::CodeGen::CodeGenModule", NM="_ZN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public class CodeGenModule extends CodeGenModule_TargetInfo implements Destructors.ClassWithDestructor {
  
  // JAVA: typedef std::vector<Structor> CtorList
//  public final class CtorList extends std.vector<Structor>{ };
  protected/*private*/ final ASTContext /*&*/ Context;
  protected/*private*/ final /*const*/ LangOptions /*&*/ LangOpts;
  protected/*private*/ final /*const*/ HeaderSearchOptions /*&*/ HeaderSearchOpts; // Only used for debug info.
  protected/*private*/ final /*const*/ PreprocessorOptions /*&*/ PreprocessorOpts; // Only used for debug info.
  protected/*private*/ final /*const*/ CodeGenOptions /*&*/ CodeGenOpts;
  protected/*private*/ final Module /*&*/ TheModule;
  protected/*private*/ final DiagnosticsEngine /*&*/ Diags;
  protected/*private*/ final /*const*/ TargetInfo /*&*/ Target;
  protected/*private*/ std.unique_ptr<CGCXXABI> ABI;
  protected/*private*/ final LLVMContext /*&*/ VMContext;
  
  protected/*private*/ std.unique_ptr<CodeGenTBAA> TBAA;
  
  protected/*private*/ /*mutable */std.unique_ptr<TargetCodeGenInfo> TheTargetCodeGenInfo;
  
  // This should not be moved earlier, since its initialization depends on some
  // of the previous reference members being already initialized and also checks
  // if TheTargetCodeGenInfo is NULL
  protected/*private*/ CodeGenTypes Types;
  
  /// Holds information about C++ vtables.
  protected/*private*/ CodeGenVTables VTables;
  
  protected/*private*/ std.unique_ptr<CGObjCRuntime> ObjCRuntime;
  protected/*private*/ std.unique_ptr<CGOpenCLRuntime> OpenCLRuntime;
  protected/*private*/ std.unique_ptr<CGOpenMPRuntime> OpenMPRuntime;
  protected/*private*/ std.unique_ptr<CGCUDARuntime> CUDARuntime;
  protected/*private*/ std.unique_ptr<CGDebugInfo> DebugInfo;
  protected/*private*/ std.unique_ptr<ObjCEntrypoints> ObjCData;
  protected/*private*/ MDNode /*P*/ NoObjCARCExceptionsMetadata/* = null*/;
  protected/*private*/ std.unique_ptr<IndexedInstrProfReader> PGOReader;
  protected/*private*/ InstrProfStats PGOStats;
  protected/*private*/ std.unique_ptr<SanitizerStatReport> SanStats;
  
  // A set of references that have only been seen via a weakref so far. This is
  // used to remove the weak of the reference if we ever see a direct reference
  // or a definition.
  protected/*private*/ SmallPtrSet<GlobalValue /*P*/ > WeakRefReferences;
  
  /// This contains all the decls which have definitions but/ which are deferred
  /// for emission and therefore should only be output if they are actually
  /// used. If a decl is in this, then it is known to have not been referenced
  /// yet.
  protected/*private*/ std.mapTypeType<StringRef, GlobalDecl> DeferredDecls;
  protected/*private*/ std.vector<DeferredGlobal> DeferredDeclsToEmit;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::addDeferredDeclToEmit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 318,
   FQN="clang::CodeGen::CodeGenModule::addDeferredDeclToEmit", NM="_ZN5clang7CodeGen13CodeGenModule21addDeferredDeclToEmitEPN4llvm11GlobalValueENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21addDeferredDeclToEmitEPN4llvm11GlobalValueENS_10GlobalDeclE")
  //</editor-fold>
  protected/*private*/ final void addDeferredDeclToEmit(GlobalValue /*P*/ GV, GlobalDecl GD) {
    DeferredDeclsToEmit.emplace_back(new DeferredGlobal(GV, GD));
  }

  
  /// List of alias we have emitted. Used to make sure that what they point to
  /// is defined once we get to the end of the of the translation unit.
  protected/*private*/ std.vector<GlobalDecl> Aliases;
  
  // JAVA: typedef llvm::StringMap<llvm::TrackingVH<llvm::Constant> > ReplacementsTy
//  public final class ReplacementsTy extends StringMap<TrackingVH<Constant>>{ };
  protected/*private*/ StringMap<TrackingVH<Constant>> Replacements;
  
  /// List of global values to be replaced with something else. Used when we
  /// want to replace a GlobalValue but can't identify it by its mangled name
  /// anymore (because the name is already taken).
  protected/*private*/ SmallVector<std.pair<GlobalValue /*P*/ , Constant /*P*/ >> GlobalValReplacements;
  
  /// Set of global decls for which we already diagnosed mangled name conflict.
  /// Required to not issue a warning (on a mangling conflict) multiple times
  /// for the same decl.
  protected/*private*/ DenseSet<GlobalDecl> DiagnosedConflictingDefinitions;
  
  /// A queue of (optional) vtables to consider emitting.
  protected/*private*/ std.vector</*const*/ CXXRecordDecl /*P*/ > DeferredVTables;
  
  /// List of global values which are required to be present in the object file;
  /// bitcast to i8*. This is used for forcing visibility of symbols which may
  /// otherwise be optimized out.
  protected/*private*/ std.vector<WeakVH> LLVMUsed;
  protected/*private*/ std.vector<WeakVH> LLVMCompilerUsed;
  
  /// Store the list of global constructors and their respective priorities to
  /// be emitted when the translation unit is complete.
  protected/*private*/ std.vector<Structor> GlobalCtors;
  
  /// Store the list of global destructors and their respective priorities to be
  /// emitted when the translation unit is complete.
  protected/*private*/ std.vector<Structor> GlobalDtors;
  
  /// An ordered map of canonical GlobalDecls to their mangled names.
  protected/*private*/ MapVectorTypeType<GlobalDecl, StringRef> MangledDeclNames;
  protected/*private*/ StringMap<GlobalDecl/*, BumpPtrAllocatorImpl*/> Manglings;
  
  /// Global annotations.
  protected/*private*/ std.vector<Constant /*P*/ > Annotations;
  
  /// Map used to get unique annotation strings.
  protected/*private*/ StringMap<Constant /*P*/ > AnnotationStrings;
  
  protected/*private*/ StringMap<GlobalVariable /*P*/ > CFConstantStringMap;
  
  protected/*private*/ DenseMap<Constant /*P*/ , GlobalVariable /*P*/ > ConstantStringMap;
  protected/*private*/ DenseMap</*const*/ Decl /*P*/ , Constant /*P*/ > StaticLocalDeclMap;
  protected/*private*/ DenseMap</*const*/ Decl /*P*/ , GlobalVariable /*P*/ > StaticLocalDeclGuardMap;
  protected/*private*/ DenseMap</*const*/ Expr /*P*/ , Constant /*P*/ > MaterializedGlobalTemporaryMap;
  
  protected/*private*/ DenseMap<QualType, Constant /*P*/ > AtomicSetterHelperFnMap;
  protected/*private*/ DenseMap<QualType, Constant /*P*/ > AtomicGetterHelperFnMap;
  
  /// Map used to get unique type descriptor constants for sanitizers.
  protected/*private*/ DenseMap<QualType, Constant /*P*/ > TypeDescriptorMap;
  
  /// Map used to track internal linkage functions declared within
  /// extern "C" regions.
  // JAVA: typedef llvm::MapVector<IdentifierInfo *, llvm::GlobalValue *> StaticExternCMap
//  public final class StaticExternCMap extends MapVector<IdentifierInfo /*P*/ , GlobalValue /*P*/ >{ };
  protected/*private*/ MapVectorPtrPtr<IdentifierInfo /*P*/ , GlobalValue /*P*/ > StaticExternCValues;
  
  /// \brief thread_local variables defined or used in this TU.
  protected/*private*/ std.vector</*const*/ VarDecl /*P*/ > CXXThreadLocals;
  
  /// \brief thread_local variables with initializers that need to run
  /// before any thread_local variable in this TU is odr-used.
  protected/*private*/ std.vector<Function /*P*/ > CXXThreadLocalInits;
  protected/*private*/ std.vector</*const*/ VarDecl /*P*/ > CXXThreadLocalInitVars;
  
  /// Global variables with initializers that need to run before main.
  protected/*private*/ std.vector<Function /*P*/ > CXXGlobalInits;
  
  /// When a C++ decl with an initializer is deferred, null is
  /// appended to CXXGlobalInits, and the index of that null is placed
  /// here so that the initializer will be performed in the correct
  /// order. Once the decl is emitted, the index is replaced with ~0U to ensure
  /// that we don't re-emit the initializer.
  protected/*private*/ DenseMapTypeUInt</*const*/ Decl /*P*/ > DelayedCXXInitPosition;
  
  // JAVA: typedef std::pair<OrderGlobalInits, llvm::Function *> GlobalInitData
//  public final class GlobalInitData extends std.pair<OrderGlobalInits, Function /*P*/ >{ };
  
  /// Global variables with initializers whose order of initialization is set by
  /// init_priority attribute.
  protected/*private*/ SmallVector<std.pair<OrderGlobalInits, Function /*P*/ >> PrioritizedCXXGlobalInits;
  
  /// Global destructor functions and arguments that need to run on termination.
  protected/*private*/ std.vector<std.pair<WeakVH, Constant /*P*/ >> CXXGlobalDtors;
  
  /// \brief The complete set of modules that has been imported.
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION)
  protected/*private*/ SetVector<org.clang.basic.Module /*P*/ > ImportedModules;
  
  /// \brief A vector of metadata strings.
  protected/*private*/ SmallVector<Metadata /*P*/ > LinkerOptionsMetadata;
  
  /// @name Cache for Objective-C runtime types
  /// @{
  
  /// Cached reference to the class for constant strings. This value has type
  /// int * but is actually an Obj-C class pointer.
  protected/*private*/ WeakVH CFConstantStringClassRef;
  
  /// Cached reference to the class for constant strings. This value has type
  /// int * but is actually an Obj-C class pointer.
  protected/*private*/ WeakVH ConstantStringClassRef;
  
  /// \brief The LLVM type corresponding to NSConstantString.
  protected/*private*/ StructType /*P*/ NSConstantStringType/* = null*/;
  
  /// \brief The type used to describe the state of a fast enumeration in
  /// Objective-C's for..in loop.
  protected/*private*/ QualType ObjCFastEnumerationStateType;
  
  /// @name Cache for Blocks Runtime Globals
  /// @{
  protected/*private*/ Constant /*P*/ NSConcreteGlobalBlock/* = null*/;
  protected/*private*/ Constant /*P*/ NSConcreteStackBlock/* = null*/;
  
  protected/*private*/ Constant /*P*/ BlockObjectAssign/* = null*/;
  protected/*private*/ Constant /*P*/ BlockObjectDispose/* = null*/;
  
  protected/*private*/ Type /*P*/ BlockDescriptorType/* = null*/;
  protected/*private*/ Type /*P*/ GenericBlockLiteralType/* = null*/;
  
  protected/*private*/ Unnamed_struct4 Block = new Unnamed_struct4();
  
  /// void @llvm.lifetime.start(i64 %size, i8* nocapture <ptr>)
  protected/*private*/ Constant /*P*/ LifetimeStartFn/* = null*/;
  
  /// void @llvm.lifetime.end(i64 %size, i8* nocapture <ptr>)
  protected/*private*/ Constant /*P*/ LifetimeEndFn/* = null*/;
  
  protected/*private*/ GlobalDecl initializedGlobalDecl;
  
  protected/*private*/ std.unique_ptr<SanitizerMetadata> SanitizerMD;
  
  /// @}
  protected/*private*/ DenseMapTypeBool</*const*/ Decl /*P*/ > DeferredEmptyCoverageMappingDecls;
  
  protected/*private*/ std.unique_ptr<CoverageMappingModuleGen> CoverageMapping;
  
  /// Mapping from canonical types to their metadata identifiers. We need to
  /// maintain this mapping because identifiers may be formed from distinct
  /// MDNodes.
  protected/*private*/ DenseMap<QualType, Metadata /*P*/ > MetadataIdMap;
  
  /// Return a reference to the configured Objective-C runtime.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getObjCRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 508,
   FQN="clang::CodeGen::CodeGenModule::getObjCRuntime", NM="_ZN5clang7CodeGen13CodeGenModule14getObjCRuntimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14getObjCRuntimeEv")
  //</editor-fold>
  public final CGObjCRuntime /*&*/ getObjCRuntime() {
    if (!ObjCRuntime.$bool()) {
      createObjCRuntime();
    }
    return ObjCRuntime.$star();
  }

  
  /// Return true iff an Objective-C runtime has been configured.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::hasObjCRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 514,
   FQN="clang::CodeGen::CodeGenModule::hasObjCRuntime", NM="_ZN5clang7CodeGen13CodeGenModule14hasObjCRuntimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14hasObjCRuntimeEv")
  //</editor-fold>
  public final boolean hasObjCRuntime() {
    return !!ObjCRuntime.$bool();
  }

  
  /// Return a reference to the configured OpenCL runtime.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getOpenCLRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 517,
   FQN="clang::CodeGen::CodeGenModule::getOpenCLRuntime", NM="_ZN5clang7CodeGen13CodeGenModule16getOpenCLRuntimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16getOpenCLRuntimeEv")
  //</editor-fold>
  public final CGOpenCLRuntime /*&*/ getOpenCLRuntime() {
    assert ($noteq_unique_ptr$_Tp$_Dp$C_nullptr_t(OpenCLRuntime, null));
    return OpenCLRuntime.$star();
  }

  
  /// Return a reference to the configured OpenMP runtime.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getOpenMPRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 523,
   FQN="clang::CodeGen::CodeGenModule::getOpenMPRuntime", NM="_ZN5clang7CodeGen13CodeGenModule16getOpenMPRuntimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule16getOpenMPRuntimeEv")
  //</editor-fold>
  public final CGOpenMPRuntime /*&*/ getOpenMPRuntime() {
    assert ($noteq_unique_ptr$_Tp$_Dp$C_nullptr_t(OpenMPRuntime, null));
    return OpenMPRuntime.$star();
  }

  
  /// Return a reference to the configured CUDA runtime.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getCUDARuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 529,
   FQN="clang::CodeGen::CodeGenModule::getCUDARuntime", NM="_ZN5clang7CodeGen13CodeGenModule14getCUDARuntimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14getCUDARuntimeEv")
  //</editor-fold>
  public final CGCUDARuntime /*&*/ getCUDARuntime() {
    assert ($noteq_unique_ptr$_Tp$_Dp$C_nullptr_t(CUDARuntime, null));
    return CUDARuntime.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getObjCEntrypoints">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 534,
   FQN="clang::CodeGen::CodeGenModule::getObjCEntrypoints", NM="_ZNK5clang7CodeGen13CodeGenModule18getObjCEntrypointsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule18getObjCEntrypointsEv")
  //</editor-fold>
  public final ObjCEntrypoints /*&*/ getObjCEntrypoints() /*const*/ {
    assert ($noteq_unique_ptr$_Tp$_Dp$C_nullptr_t(ObjCData, null));
    return ObjCData.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getPGOStats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 539,
   FQN="clang::CodeGen::CodeGenModule::getPGOStats", NM="_ZN5clang7CodeGen13CodeGenModule11getPGOStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule11getPGOStatsEv")
  //</editor-fold>
  public final InstrProfStats /*&*/ getPGOStats() {
    return PGOStats;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getPGOReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 540,
   FQN="clang::CodeGen::CodeGenModule::getPGOReader", NM="_ZNK5clang7CodeGen13CodeGenModule12getPGOReaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule12getPGOReaderEv")
  //</editor-fold>
  public final IndexedInstrProfReader /*P*/ getPGOReader() /*const*/ {
    return PGOReader.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getCoverageMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 542,
   FQN="clang::CodeGen::CodeGenModule::getCoverageMapping", NM="_ZNK5clang7CodeGen13CodeGenModule18getCoverageMappingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule18getCoverageMappingEv")
  //</editor-fold>
  public final CoverageMappingModuleGen /*P*/ getCoverageMapping() /*const*/ {
    return CoverageMapping.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getStaticLocalDeclAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 546,
   FQN="clang::CodeGen::CodeGenModule::getStaticLocalDeclAddress", NM="_ZN5clang7CodeGen13CodeGenModule25getStaticLocalDeclAddressEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule25getStaticLocalDeclAddressEPKNS_7VarDeclE")
  //</editor-fold>
  public final Constant /*P*/ getStaticLocalDeclAddress(/*const*/ VarDecl /*P*/ D) {
    return StaticLocalDeclMap.$at_T1$RR(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::setStaticLocalDeclAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 549,
   FQN="clang::CodeGen::CodeGenModule::setStaticLocalDeclAddress", NM="_ZN5clang7CodeGen13CodeGenModule25setStaticLocalDeclAddressEPKNS_7VarDeclEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule25setStaticLocalDeclAddressEPKNS_7VarDeclEPN4llvm8ConstantE")
  //</editor-fold>
  public final void setStaticLocalDeclAddress(/*const*/ VarDecl /*P*/ D, 
                           Constant /*P*/ C) {
    StaticLocalDeclMap.$set(D, C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getStaticLocalDeclGuardAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 558,
   FQN="clang::CodeGen::CodeGenModule::getStaticLocalDeclGuardAddress", NM="_ZN5clang7CodeGen13CodeGenModule30getStaticLocalDeclGuardAddressEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule30getStaticLocalDeclGuardAddressEPKNS_7VarDeclE")
  //</editor-fold>
  public final GlobalVariable /*P*/ getStaticLocalDeclGuardAddress(/*const*/ VarDecl /*P*/ D) {
    return StaticLocalDeclGuardMap.$at_T1$RR(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::setStaticLocalDeclGuardAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 561,
   FQN="clang::CodeGen::CodeGenModule::setStaticLocalDeclGuardAddress", NM="_ZN5clang7CodeGen13CodeGenModule30setStaticLocalDeclGuardAddressEPKNS_7VarDeclEPN4llvm14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule30setStaticLocalDeclGuardAddressEPKNS_7VarDeclEPN4llvm14GlobalVariableE")
  //</editor-fold>
  public final void setStaticLocalDeclGuardAddress(/*const*/ VarDecl /*P*/ D, 
                                GlobalVariable /*P*/ C) {
    StaticLocalDeclGuardMap.$set(D, C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getAtomicSetterHelperFnMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 569,
   FQN="clang::CodeGen::CodeGenModule::getAtomicSetterHelperFnMap", NM="_ZN5clang7CodeGen13CodeGenModule26getAtomicSetterHelperFnMapENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule26getAtomicSetterHelperFnMapENS_8QualTypeE")
  //</editor-fold>
  public final Constant /*P*/ getAtomicSetterHelperFnMap(QualType Ty) {
    return AtomicSetterHelperFnMap.$at_T1$C$R(Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::setAtomicSetterHelperFnMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 572,
   FQN="clang::CodeGen::CodeGenModule::setAtomicSetterHelperFnMap", NM="_ZN5clang7CodeGen13CodeGenModule26setAtomicSetterHelperFnMapENS_8QualTypeEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule26setAtomicSetterHelperFnMapENS_8QualTypeEPN4llvm8ConstantE")
  //</editor-fold>
  public final void setAtomicSetterHelperFnMap(QualType Ty, 
                            Constant /*P*/ Fn) {
    AtomicSetterHelperFnMap.$set(Ty, Fn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getAtomicGetterHelperFnMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 577,
   FQN="clang::CodeGen::CodeGenModule::getAtomicGetterHelperFnMap", NM="_ZN5clang7CodeGen13CodeGenModule26getAtomicGetterHelperFnMapENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule26getAtomicGetterHelperFnMapENS_8QualTypeE")
  //</editor-fold>
  public final Constant /*P*/ getAtomicGetterHelperFnMap(QualType Ty) {
    return AtomicGetterHelperFnMap.$at_T1$C$R(Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::setAtomicGetterHelperFnMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 580,
   FQN="clang::CodeGen::CodeGenModule::setAtomicGetterHelperFnMap", NM="_ZN5clang7CodeGen13CodeGenModule26setAtomicGetterHelperFnMapENS_8QualTypeEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule26setAtomicGetterHelperFnMapENS_8QualTypeEPN4llvm8ConstantE")
  //</editor-fold>
  public final void setAtomicGetterHelperFnMap(QualType Ty, 
                            Constant /*P*/ Fn) {
    AtomicGetterHelperFnMap.$set(Ty, Fn);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getTypeDescriptorFromMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 585,
   FQN="clang::CodeGen::CodeGenModule::getTypeDescriptorFromMap", NM="_ZN5clang7CodeGen13CodeGenModule24getTypeDescriptorFromMapENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24getTypeDescriptorFromMapENS_8QualTypeE")
  //</editor-fold>
  public final Constant /*P*/ getTypeDescriptorFromMap(QualType Ty) {
    return TypeDescriptorMap.$at_T1$C$R(Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::setTypeDescriptorInMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 588,
   FQN="clang::CodeGen::CodeGenModule::setTypeDescriptorInMap", NM="_ZN5clang7CodeGen13CodeGenModule22setTypeDescriptorInMapENS_8QualTypeEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule22setTypeDescriptorInMapENS_8QualTypeEPN4llvm8ConstantE")
  //</editor-fold>
  public final void setTypeDescriptorInMap(QualType Ty, Constant /*P*/ C) {
    TypeDescriptorMap.$set(Ty, C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getModuleDebugInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 592,
   FQN="clang::CodeGen::CodeGenModule::getModuleDebugInfo", NM="_ZN5clang7CodeGen13CodeGenModule18getModuleDebugInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule18getModuleDebugInfoEv")
  //</editor-fold>
  public final CGDebugInfo /*P*/ getModuleDebugInfo() {
    return DebugInfo.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getNoObjCARCExceptionsMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 594,
   FQN="clang::CodeGen::CodeGenModule::getNoObjCARCExceptionsMetadata", NM="_ZN5clang7CodeGen13CodeGenModule30getNoObjCARCExceptionsMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule30getNoObjCARCExceptionsMetadataEv")
  //</editor-fold>
  public final MDNode /*P*/ getNoObjCARCExceptionsMetadata() {
    if (!(NoObjCARCExceptionsMetadata != null)) {
      NoObjCARCExceptionsMetadata = MDNode.get(getLLVMContext(), new ArrayRef<Metadata /*P*/ >(None, true));
    }
    return NoObjCARCExceptionsMetadata;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 600,
   FQN="clang::CodeGen::CodeGenModule::getContext", NM="_ZNK5clang7CodeGen13CodeGenModule10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule10getContextEv")
  //</editor-fold>
  public final ASTContext /*&*/ getContext() /*const*/ {
    return Context;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 601,
   FQN="clang::CodeGen::CodeGenModule::getLangOpts", NM="_ZNK5clang7CodeGen13CodeGenModule11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule11getLangOptsEv")
  //</editor-fold>
  public final /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return LangOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getHeaderSearchOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 602,
   FQN="clang::CodeGen::CodeGenModule::getHeaderSearchOpts", NM="_ZNK5clang7CodeGen13CodeGenModule19getHeaderSearchOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule19getHeaderSearchOptsEv")
  //</editor-fold>
  public final /*const*/ HeaderSearchOptions /*&*/ getHeaderSearchOpts() /*const*/ {
    return HeaderSearchOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getPreprocessorOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 604,
   FQN="clang::CodeGen::CodeGenModule::getPreprocessorOpts", NM="_ZNK5clang7CodeGen13CodeGenModule19getPreprocessorOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule19getPreprocessorOptsEv")
  //</editor-fold>
  public final /*const*/ PreprocessorOptions /*&*/ getPreprocessorOpts() /*const*/ {
    return PreprocessorOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getCodeGenOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 606,
   FQN="clang::CodeGen::CodeGenModule::getCodeGenOpts", NM="_ZNK5clang7CodeGen13CodeGenModule14getCodeGenOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule14getCodeGenOptsEv")
  //</editor-fold>
  public final /*const*/ CodeGenOptions /*&*/ getCodeGenOpts() /*const*/ {
    return CodeGenOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 607,
   FQN="clang::CodeGen::CodeGenModule::getModule", NM="_ZNK5clang7CodeGen13CodeGenModule9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule9getModuleEv")
  //</editor-fold>
  public final Module /*&*/ getModule() /*const*/ {
    return TheModule;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getDiags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 608,
   FQN="clang::CodeGen::CodeGenModule::getDiags", NM="_ZNK5clang7CodeGen13CodeGenModule8getDiagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule8getDiagsEv")
  //</editor-fold>
  public final DiagnosticsEngine /*&*/ getDiags() /*const*/ {
    return Diags;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getDataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 609,
   FQN="clang::CodeGen::CodeGenModule::getDataLayout", NM="_ZNK5clang7CodeGen13CodeGenModule13getDataLayoutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule13getDataLayoutEv")
  //</editor-fold>
  public final /*const*/ DataLayout /*&*/ getDataLayout() /*const*/ {
    return TheModule.getDataLayout();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 612,
   FQN="clang::CodeGen::CodeGenModule::getTarget", NM="_ZNK5clang7CodeGen13CodeGenModule9getTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule9getTargetEv")
  //</editor-fold>
  public final /*const*/ TargetInfo /*&*/ getTarget() /*const*/ {
    return Target;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 617,
   FQN="clang::CodeGen::CodeGenModule::getCXXABI", NM="_ZNK5clang7CodeGen13CodeGenModule9getCXXABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule9getCXXABIEv")
  //</editor-fold>
  public final CGCXXABI /*&*/ getCXXABI() /*const*/ {
    return ABI.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getLLVMContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 618,
   FQN="clang::CodeGen::CodeGenModule::getLLVMContext", NM="_ZN5clang7CodeGen13CodeGenModule14getLLVMContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14getLLVMContextEv")
  //</editor-fold>
  public final LLVMContext /*&*/ getLLVMContext() {
    return VMContext;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::shouldUseTBAA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 620,
   FQN="clang::CodeGen::CodeGenModule::shouldUseTBAA", NM="_ZNK5clang7CodeGen13CodeGenModule13shouldUseTBAAEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule13shouldUseTBAAEv")
  //</editor-fold>
  public final boolean shouldUseTBAA() /*const*/ {
    return $noteq_unique_ptr$_Tp$_Dp$C_nullptr_t(TBAA, null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 624,
   FQN="clang::CodeGen::CodeGenModule::getTypes", NM="_ZN5clang7CodeGen13CodeGenModule8getTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule8getTypesEv")
  //</editor-fold>
  public final CodeGenTypes /*&*/ getTypes() {
    return Types;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getVTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 626,
   FQN="clang::CodeGen::CodeGenModule::getVTables", NM="_ZN5clang7CodeGen13CodeGenModule10getVTablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule10getVTablesEv")
  //</editor-fold>
  public final CodeGenVTables /*&*/ getVTables() {
    return VTables;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getItaniumVTableContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 628,
   FQN="clang::CodeGen::CodeGenModule::getItaniumVTableContext", NM="_ZN5clang7CodeGen13CodeGenModule23getItaniumVTableContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23getItaniumVTableContextEv")
  //</editor-fold>
  public final ItaniumVTableContext /*&*/ getItaniumVTableContext() {
    return VTables.getItaniumVTableContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getMicrosoftVTableContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 632,
   FQN="clang::CodeGen::CodeGenModule::getMicrosoftVTableContext", NM="_ZN5clang7CodeGen13CodeGenModule25getMicrosoftVTableContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule25getMicrosoftVTableContextEv")
  //</editor-fold>
  public final MicrosoftVTableContext /*&*/ getMicrosoftVTableContext() {
    return VTables.getMicrosoftVTableContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getGlobalCtors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 636,
   FQN="clang::CodeGen::CodeGenModule::getGlobalCtors", NM="_ZN5clang7CodeGen13CodeGenModule14getGlobalCtorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14getGlobalCtorsEv")
  //</editor-fold>
  public final std.vector<Structor> /*&*/ getGlobalCtors() {
    return GlobalCtors;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getGlobalDtors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 637,
   FQN="clang::CodeGen::CodeGenModule::getGlobalDtors", NM="_ZN5clang7CodeGen13CodeGenModule14getGlobalDtorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14getGlobalDtorsEv")
  //</editor-fold>
  public final std.vector<Structor> /*&*/ getGlobalDtors() {
    return GlobalDtors;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetLLVMVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 673,
   FQN="clang::CodeGen::CodeGenModule::GetLLVMVisibility", NM="_ZN5clang7CodeGen13CodeGenModule17GetLLVMVisibilityENS_10VisibilityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule17GetLLVMVisibilityENS_10VisibilityE")
  //</editor-fold>
  public static GlobalValue.VisibilityTypes GetLLVMVisibility(Visibility V) {
    switch (V) {
     case DefaultVisibility:
      return GlobalValue.VisibilityTypes.DefaultVisibility;
     case HiddenVisibility:
      return GlobalValue.VisibilityTypes.HiddenVisibility;
     case ProtectedVisibility:
      return GlobalValue.VisibilityTypes.ProtectedVisibility;
    }
    throw new llvm_unreachable("unknown visibility!");
  }

  
  public FoldingSet<BlockByrefHelpers> ByrefHelpersCache;
  
  /// Fetches the global unique block count.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getUniqueBlockCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 763,
   FQN="clang::CodeGen::CodeGenModule::getUniqueBlockCount", NM="_ZN5clang7CodeGen13CodeGenModule19getUniqueBlockCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19getUniqueBlockCountEv")
  //</editor-fold>
  public final int getUniqueBlockCount() {
    return ++Block.GlobalUniqueCount;
  }

  
//  /// \brief If the declaration has internal linkage but is inside an
//  /// extern "C" linkage specification, prepare to emit an alias for it
//  /// to the expected name.
//  /*template <typename SomeDecl> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::MaybeHandleStaticInExternC">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 2321,
//   FQN="clang::CodeGen::CodeGenModule::MaybeHandleStaticInExternC", NM="Tpl__ZN5clang7CodeGen13CodeGenModule26MaybeHandleStaticInExternCEPKT_PN4llvm11GlobalValueE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=Tpl__ZN5clang7CodeGen13CodeGenModule26MaybeHandleStaticInExternCEPKT_PN4llvm11GlobalValueE")
//  //</editor-fold>
//  public final </*typename*/ SomeDecl> void MaybeHandleStaticInExternC(/*const*/ SomeDecl /*P*/ D, 
//                            GlobalValue /*P*/ GV) {
//    if (!getLangOpts().CPlusPlus) {
//      return;
//    }
//    
//    // Must have 'used' attribute, or else inline assembly can't rely on
//    // the name existing.
//    if (Native.$not(D./*template */<UsedAttr>hasAttr())) {
//      return;
//    }
//    
//    // Must have internal linkage and an ordinary name.
//    if (Native.$not(D.getIdentifier()) || Native.$bool(Native.$noteq(D.getFormalLinkage(), Linkage.InternalLinkage))) {
//      return;
//    }
//    
//    // Must be in an extern "C" context. Entities declared directly within
//    // a record are not extern "C" even if the record is in such a context.
//    /*const*/ SomeDecl /*P*/ First = D.getFirstDecl();
//    if (Native.$bool(First.getDeclContext().isRecord()) || Native.$not(First.isInExternCContext())) {
//      return;
//    }
//    
//    // OK, this is an internal linkage entity inside an extern "C" linkage
//    // specification. Make a note of that so we can give it the "expected"
//    // mangled name if nothing else is using that name.
//    std.pairTypeBool<std.vector.iterator<std.pair<IdentifierInfo /*P*/ , GlobalValue /*P*/ > /*P*/ >> R = StaticExternCValues.insert(std.make_pair(D.getIdentifier(), GV));
//    
//    // If we have multiple internal linkage entities with the same name
//    // in extern "C" regions, none of them gets that name.
//    if (!R.second) {
//      R.first.$arrow().second = null;
//    }
//  }

  
  /// Add a destructor and object to add to the C++ global destructor function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::AddCXXDtorEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 867,
   FQN="clang::CodeGen::CodeGenModule::AddCXXDtorEntry", NM="_ZN5clang7CodeGen13CodeGenModule15AddCXXDtorEntryEPN4llvm8ConstantES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule15AddCXXDtorEntryEPN4llvm8ConstantES4_")
  //</editor-fold>
  public final void AddCXXDtorEntry(Constant /*P*/ DtorFn, Constant /*P*/ Object) {
    CXXGlobalDtors.emplace_back(new std.pairTypePtr<WeakVH, Constant /*P*/ >(new WeakVH(DtorFn), Object));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::setFunctionLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 1014,
   FQN="clang::CodeGen::CodeGenModule::setFunctionLinkage", NM="_ZN5clang7CodeGen13CodeGenModule18setFunctionLinkageENS_10GlobalDeclEPN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule18setFunctionLinkageENS_10GlobalDeclEPN4llvm8FunctionE")
  //</editor-fold>
  public final void setFunctionLinkage(GlobalDecl GD, Function /*P*/ F) {
    F.setLinkage(getFunctionLinkage(new GlobalDecl(GD)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getSanitizerMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 1070,
   FQN="clang::CodeGen::CodeGenModule::getSanitizerMetadata", NM="_ZN5clang7CodeGen13CodeGenModule20getSanitizerMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20getSanitizerMetadataEv")
  //</editor-fold>
  public final SanitizerMetadata /*P*/ getSanitizerMetadata() {
    return SanitizerMD.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::addDeferredVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 1074,
   FQN="clang::CodeGen::CodeGenModule::addDeferredVTable", NM="_ZN5clang7CodeGen13CodeGenModule17addDeferredVTableEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule17addDeferredVTableEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public final void addDeferredVTable(/*const*/ CXXRecordDecl /*P*/ RD) {
    DeferredVTables.push_back_T$C$R(RD);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::CodeGenModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 82,
   FQN="clang::CodeGen::CodeGenModule::CodeGenModule", NM="_ZN5clang7CodeGen13CodeGenModuleC1ERNS_10ASTContextERKNS_19HeaderSearchOptionsERKNS_19PreprocessorOptionsERKNS_14CodeGenOptionsERN4llvm6ModuleERNS_17DiagnosticsEngineEPNS_18CoverageSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModuleC1ERNS_10ASTContextERKNS_19HeaderSearchOptionsERKNS_19PreprocessorOptionsERKNS_14CodeGenOptionsERN4llvm6ModuleERNS_17DiagnosticsEngineEPNS_18CoverageSourceInfoE")
  //</editor-fold>
  public CodeGenModule(final ASTContext /*&*/ C, final /*const*/ HeaderSearchOptions /*&*/ HSO, 
      final /*const*/ PreprocessorOptions /*&*/ PPO, 
      final /*const*/ CodeGenOptions /*&*/ CGO, final Module /*&*/ M, 
      final DiagnosticsEngine /*&*/ diags) {
    this(C, HSO, 
      PPO, 
      CGO, M, 
      diags, 
      (CoverageSourceInfo /*P*/ )null);
  }
  public CodeGenModule(final ASTContext /*&*/ C, final /*const*/ HeaderSearchOptions /*&*/ HSO, 
      final /*const*/ PreprocessorOptions /*&*/ PPO, 
      final /*const*/ CodeGenOptions /*&*/ CGO, final Module /*&*/ M, 
      final DiagnosticsEngine /*&*/ diags, 
      CoverageSourceInfo /*P*/ CoverageInfo/*= null*/) {
    // : CodeGenTypeCache(), Context(C), LangOpts(C.getLangOpts()), HeaderSearchOpts(HSO), PreprocessorOpts(PPO), CodeGenOpts(CGO), TheModule(M), Diags(diags), Target(C.getTargetInfo()), ABI(createCXXABI(*this)), VMContext(M.getContext()), TBAA(), TheTargetCodeGenInfo(), Types(*this), VTables(*this), ObjCRuntime(), OpenCLRuntime(), OpenMPRuntime(), CUDARuntime(), DebugInfo(), ObjCData(), NoObjCARCExceptionsMetadata(null), PGOReader(), PGOStats(), SanStats(), WeakRefReferences(), DeferredDecls(), DeferredDeclsToEmit(), Aliases(), Replacements(), GlobalValReplacements(), DiagnosedConflictingDefinitions(), DeferredVTables(), LLVMUsed(), LLVMCompilerUsed(), GlobalCtors(), GlobalDtors(), MangledDeclNames(), Manglings(), Annotations(), AnnotationStrings(), CFConstantStringMap(), ConstantStringMap(), StaticLocalDeclMap(), StaticLocalDeclGuardMap(), MaterializedGlobalTemporaryMap(), AtomicSetterHelperFnMap(), AtomicGetterHelperFnMap(), TypeDescriptorMap(), StaticExternCValues(), CXXThreadLocals(), CXXThreadLocalInits(), CXXThreadLocalInitVars(), CXXGlobalInits(), DelayedCXXInitPosition(), PrioritizedCXXGlobalInits(), CXXGlobalDtors(), ImportedModules(), LinkerOptionsMetadata(), CFConstantStringClassRef(), ConstantStringClassRef(), NSConstantStringType(null), ObjCFastEnumerationStateType(), NSConcreteGlobalBlock(null), NSConcreteStackBlock(null), BlockObjectAssign(null), BlockObjectDispose(null), BlockDescriptorType(null), GenericBlockLiteralType(null), Block(), LifetimeStartFn(null), LifetimeEndFn(null), initializedGlobalDecl(), SanitizerMD(new SanitizerMetadata(*this)), DeferredEmptyCoverageMappingDecls(), CoverageMapping(), MetadataIdMap(), ByrefHelpersCache() 
    //START JInit
    super();
    this./*&*/Context=/*&*/C;
    this./*&*/LangOpts=/*&*/C.getLangOpts();
    this./*&*/HeaderSearchOpts=/*&*/HSO;
    this./*&*/PreprocessorOpts=/*&*/PPO;
    this./*&*/CodeGenOpts=/*&*/CGO;
    this./*&*/TheModule=/*&*/M;
    this./*&*/Diags=/*&*/diags;
    this./*&*/Target=/*&*/C.getTargetInfo();
    this.ABI = new std.unique_ptr<CGCXXABI>(createCXXABI(/*Deref*/this));
    this./*&*/VMContext=/*&*/M.getContext();
    this.TBAA = new std.unique_ptr<CodeGenTBAA>();
    this.TheTargetCodeGenInfo = new std.unique_ptr<TargetCodeGenInfo>();
    this.Types = new CodeGenTypes(/*Deref*/this);
    this.VTables = new CodeGenVTables(/*Deref*/this);
    this.ObjCRuntime = new std.unique_ptr<CGObjCRuntime>();
    this.OpenCLRuntime = new std.unique_ptr<CGOpenCLRuntime>();
    this.OpenMPRuntime = new std.unique_ptr<CGOpenMPRuntime>();
    this.CUDARuntime = new std.unique_ptr<CGCUDARuntime>();
    this.DebugInfo = new std.unique_ptr<CGDebugInfo>();
    this.ObjCData = new std.unique_ptr<ObjCEntrypoints>();
    /*InClass*/this.NoObjCARCExceptionsMetadata = null;
    this.PGOReader = new std.unique_ptr<IndexedInstrProfReader>();
    this.PGOStats = new InstrProfStats();
    this.SanStats = new std.unique_ptr<SanitizerStatReport>();
    this.WeakRefReferences = new SmallPtrSet<GlobalValue /*P*/ >(DenseMapInfo$LikePtr.$Info(), 10);
    this.DeferredDecls = new std.mapTypeType<StringRef, GlobalDecl>(StringRef.COMPARATOR, new GlobalDecl());
    this.DeferredDeclsToEmit = new std.vector<DeferredGlobal>(new DeferredGlobal());
    this.Aliases = new std.vector<GlobalDecl>(new GlobalDecl());
    this.Replacements = new StringMap<TrackingVH<Constant>>(new TrackingVH<Constant>(Constant.class));
    this.GlobalValReplacements = new SmallVector<std.pair<GlobalValue /*P*/ , Constant /*P*/ >>(8, new std.pairPtrPtr<GlobalValue /*P*/ , Constant /*P*/ >());
    this.DiagnosedConflictingDefinitions = new DenseSet<GlobalDecl>(DenseMapInfoGlobalDecl.$Info());
    this.DeferredVTables = new std.vector</*const*/ CXXRecordDecl /*P*/ >((/*const*/ CXXRecordDecl /*P*/ )null);
    this.LLVMUsed = new std.vector<WeakVH>(new WeakVH());
    this.LLVMCompilerUsed = new std.vector<WeakVH>(new WeakVH());
    this.GlobalCtors = new std.vector<Structor>(new Structor());
    this.GlobalDtors = new std.vector<Structor>(new Structor());
    this.MangledDeclNames = new MapVectorTypeType<GlobalDecl, StringRef>(DenseMapInfoGlobalDecl.$Info(), new StringRef());
    this.Manglings = new StringMap<GlobalDecl/*, BumpPtrAllocatorImpl*/>(new GlobalDecl());
    this.Annotations = new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
    this.AnnotationStrings = new StringMap<Constant /*P*/ >((Constant /*P*/ )null);
    this.CFConstantStringMap = new StringMap<GlobalVariable /*P*/ >((GlobalVariable /*P*/ )null);
    this.ConstantStringMap = new DenseMap<Constant /*P*/ , GlobalVariable /*P*/ >(DenseMapInfo$LikePtr.$Info(), (GlobalVariable /*P*/ )null);
    this.StaticLocalDeclMap = new DenseMap</*const*/ Decl /*P*/ , Constant /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Constant /*P*/ )null);
    this.StaticLocalDeclGuardMap = new DenseMap</*const*/ Decl /*P*/ , GlobalVariable /*P*/ >(DenseMapInfo$LikePtr.$Info(), (GlobalVariable /*P*/ )null);
    this.MaterializedGlobalTemporaryMap = new DenseMap</*const*/ Expr /*P*/ , Constant /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Constant /*P*/ )null);
    this.AtomicSetterHelperFnMap = new DenseMap<QualType, Constant /*P*/ >(DenseMapInfoQualType.$Info(), (Constant /*P*/ )null);
    this.AtomicGetterHelperFnMap = new DenseMap<QualType, Constant /*P*/ >(DenseMapInfoQualType.$Info(), (Constant /*P*/ )null);
    this.TypeDescriptorMap = new DenseMap<QualType, Constant /*P*/ >(DenseMapInfoQualType.$Info(), (Constant /*P*/ )null);
    this.StaticExternCValues = new MapVectorPtrPtr<IdentifierInfo /*P*/ , GlobalValue /*P*/ >(IdentifierInfo.DMI$IdentifierInfoPtr, (GlobalValue/*P*/)null);
    this.CXXThreadLocals = new std.vector</*const*/ VarDecl /*P*/ >((/*const*/ VarDecl /*P*/ )null);
    this.CXXThreadLocalInits = new std.vector<Function /*P*/ >((Function /*P*/ )null);
    this.CXXThreadLocalInitVars = new std.vector</*const*/ VarDecl /*P*/ >((/*const*/ VarDecl /*P*/ )null);
    this.CXXGlobalInits = new std.vector<Function /*P*/ >((Function /*P*/ )null);
    this.DelayedCXXInitPosition = new DenseMapTypeUInt</*const*/ Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.PrioritizedCXXGlobalInits = new SmallVector<std.pair<OrderGlobalInits, Function /*P*/ >>(8, new std.pairTypePtr<OrderGlobalInits, Function /*P*/ >(new OrderGlobalInits(), null));
    this.CXXGlobalDtors = new std.vector<std.pair<WeakVH, Constant /*P*/ >>(new std.pairTypePtr<WeakVH, Constant /*P*/ >(new WeakVH(), null));
    this.ImportedModules = new SetVector<org.clang.basic.Module /*P*/ >((org.clang.basic.Module /*P*/ )null);
    this.LinkerOptionsMetadata = new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
    this.CFConstantStringClassRef = new WeakVH();
    this.ConstantStringClassRef = new WeakVH();
    /*InClass*/this.NSConstantStringType = null;
    this.ObjCFastEnumerationStateType = new QualType();
    /*InClass*/this.NSConcreteGlobalBlock = null;
    /*InClass*/this.NSConcreteStackBlock = null;
    /*InClass*/this.BlockObjectAssign = null;
    /*InClass*/this.BlockObjectDispose = null;
    /*InClass*/this.BlockDescriptorType = null;
    /*InClass*/this.GenericBlockLiteralType = null;
    this.Block = new Unnamed_struct4();
    /*InClass*/this.LifetimeStartFn = null;
    /*InClass*/this.LifetimeEndFn = null;
    this.initializedGlobalDecl = new GlobalDecl();
    this.SanitizerMD = new std.unique_ptr<SanitizerMetadata>(new SanitizerMetadata(/*Deref*/this));
    this.DeferredEmptyCoverageMappingDecls = new DenseMapTypeBool</*const*/ Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), false);
    this.CoverageMapping = new std.unique_ptr<CoverageMappingModuleGen>();
    this.MetadataIdMap = new DenseMap<QualType, Metadata /*P*/ >(DenseMapInfoQualType.$Info(), (Metadata /*P*/ )null);
    this.ByrefHelpersCache = new FoldingSet<BlockByrefHelpers>(BlockByrefHelpers.$Trait());
    //END JInit
  
    // Initialize the type cache.
    final LLVMContext /*&*/ $LLVMContext = M.getContext();
    VoidTy = Type.getVoidTy($LLVMContext);
    Int8Ty = Type.getInt8Ty($LLVMContext);
    Int16Ty = Type.getInt16Ty($LLVMContext);
    Int32Ty = Type.getInt32Ty($LLVMContext);
    Int64Ty = Type.getInt64Ty($LLVMContext);
    FloatTy = Type.getFloatTy($LLVMContext);
    DoubleTy = Type.getDoubleTy($LLVMContext);
    PointerWidthInBits = $ulong2uchar(C.getTargetInfo().getPointerWidth(0));
    // JAVA: init unnamed unions
    Unnamed_field13.$assign(
       $long2uchar(C.toCharUnitsFromBits(C.getTargetInfo().getPointerAlign(0)).getQuantity()));
    Unnamed_field11.$assign(
       $long2uchar(C.toCharUnitsFromBits($uint2long(C.getTargetInfo().getIntAlign())).getQuantity()));
    IntTy = IntegerType.get($LLVMContext, C.getTargetInfo().getIntWidth());    
    Unnamed_field8.$assign(IntegerType.get($LLVMContext, $uchar2uint(PointerWidthInBits)));
    Unnamed_field9.$assign(Int8Ty.getPointerTo(0));
    Unnamed_field10.$assign(Unnamed_field9.Int8PtrTy.getPointerTo(0));
  
    RuntimeCC = getTargetCodeGenInfo().getABIInfo().getRuntimeCC();
    BuiltinCC = getTargetCodeGenInfo().getABIInfo().getBuiltinCC();
    if (LangOpts.ObjC1) {
      createObjCRuntime();
    }
    if (LangOpts.OpenCL) {
      createOpenCLRuntime();
    }
    if ((LangOpts.OpenMP != 0)) {
      createOpenMPRuntime();
    }
    if (LangOpts.CUDA) {
      createCUDARuntime();
    }
  
    // Enable TBAA unless it's suppressed. ThreadSanitizer needs TBAA even at O0.
    if (LangOpts.Sanitize.has(SanitizerKind.Thread)
       || (!CodeGenOpts.RelaxedAliasing && $2bits_uint2uint(CodeGenOpts.OptimizationLevel) > 0)) {
      TBAA.reset(new CodeGenTBAA(Context, VMContext, CodeGenOpts, getLangOpts(), 
              getCXXABI().getMangleContext()));
    }
  
    // If debug info or coverage generation is enabled, create the CGDebugInfo
    // object.
    if (CodeGenOpts.getDebugInfo() != DebugInfoKind.NoDebugInfo
       || CodeGenOpts.EmitGcovArcs || CodeGenOpts.EmitGcovNotes) {
      DebugInfo.reset(new CGDebugInfo(/*Deref*/this));
    }
  
    Block.GlobalUniqueCount = 0;
    if (C.getLangOpts().ObjC1) {
      ObjCData.reset(new ObjCEntrypoints());
    }
    if (CodeGenOpts.hasProfileClangUse()) {
      Expected<unique_ptr<IndexedInstrProfReader> > ReaderOrErr = null;
      try {
        ReaderOrErr = IndexedInstrProfReader.create_IndexedInstrProfReader(new Twine(CodeGenOpts.ProfileInstrumentUsePath));
        {
          Error E = null;
          try {
            E = ReaderOrErr.takeError();
            if (E.$bool()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
                    /*KEEP_STR*/"Could not read profile %0: %1");
                ErrorInfoBase2Void handler = /*[&, this, &DiagID]*/ (final /*const*/ ErrorInfoBase /*&*/ EI) -> {
                          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(getDiags().Report(DiagID)), new StringRef(CodeGenOpts.ProfileInstrumentUsePath)), 
                              new StringRef(EI.message())));
                        };
                handleAllErrors$T($c$.track(new Error(JD$Move.INSTANCE, std.move(E))), handler); $c$.clean();
              } finally {
                $c$.$destroy();
              }
            } else {
              PGOReader.$assignMove(std.move(ReaderOrErr.get()));
            }
          } finally {
            if (E != null) { E.$destroy(); }
          }
        }
      } finally {
        if (ReaderOrErr != null) { ReaderOrErr.$destroy(); }
      }
    }
  
    // If coverage mapping generation is enabled, create the
    // CoverageMappingModuleGen object.
    if (CodeGenOpts.CoverageMapping) {
      CoverageMapping.reset(new CoverageMappingModuleGen(/*Deref*/this, /*Deref*/CoverageInfo));
    }
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::~CodeGenModule">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 161,
   FQN="clang::CodeGen::CodeGenModule::~CodeGenModule", NM="_ZN5clang7CodeGen13CodeGenModuleD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModuleD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    ByrefHelpersCache.$destroy();
    MetadataIdMap.$destroy();
    CoverageMapping.$destroy();
    DeferredEmptyCoverageMappingDecls.$destroy();
    SanitizerMD.$destroy();
    ConstantStringClassRef.$destroy();
    CFConstantStringClassRef.$destroy();
    LinkerOptionsMetadata.$destroy();
    ImportedModules.$destroy();
    CXXGlobalDtors.$destroy();
    PrioritizedCXXGlobalInits.$destroy();
    DelayedCXXInitPosition.$destroy();
    CXXGlobalInits.$destroy();
    CXXThreadLocalInitVars.$destroy();
    CXXThreadLocalInits.$destroy();
    CXXThreadLocals.$destroy();
    StaticExternCValues.$destroy();
    TypeDescriptorMap.$destroy();
    AtomicGetterHelperFnMap.$destroy();
    AtomicSetterHelperFnMap.$destroy();
    MaterializedGlobalTemporaryMap.$destroy();
    StaticLocalDeclGuardMap.$destroy();
    StaticLocalDeclMap.$destroy();
    ConstantStringMap.$destroy();
    CFConstantStringMap.$destroy();
    AnnotationStrings.$destroy();
    Annotations.$destroy();
    Manglings.$destroy();
    MangledDeclNames.$destroy();
    GlobalDtors.$destroy();
    GlobalCtors.$destroy();
    LLVMCompilerUsed.$destroy();
    LLVMUsed.$destroy();
    DeferredVTables.$destroy();
    DiagnosedConflictingDefinitions.$destroy();
    GlobalValReplacements.$destroy();
    Replacements.$destroy();
    Aliases.$destroy();
    DeferredDeclsToEmit.$destroy();
    DeferredDecls.$destroy();
    WeakRefReferences.$destroy();
    SanStats.$destroy();
    PGOReader.$destroy();
    ObjCData.$destroy();
    DebugInfo.$destroy();
    CUDARuntime.$destroy();
    OpenMPRuntime.$destroy();
    OpenCLRuntime.$destroy();
    ObjCRuntime.$destroy();
    VTables.$destroy();
    Types.$destroy();
    TheTargetCodeGenInfo.$destroy();
    TBAA.$destroy();
    ABI.$destroy();
    //super.$destroy();
    //END JDestroy
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::CodeGenModule">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 247,
   FQN="clang::CodeGen::CodeGenModule::CodeGenModule", NM="_ZN5clang7CodeGen13CodeGenModuleC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen13CodeGenModuleC1ERKS1_")
  //</editor-fold>
  protected/*private*/ CodeGenModule(final /*const*/ CodeGenModule /*&*/ $Prm0) {  throw new UnsupportedOperationException("Deleted");}  


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", HeaderSearchOpts=" + HeaderSearchOpts // NOI18N
              + ", PreprocessorOpts=" + PreprocessorOpts // NOI18N
              + ", CodeGenOpts=" + CodeGenOpts // NOI18N
              + ", TheModule=" + TheModule // NOI18N
              + ", Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", Target=" + Target // NOI18N
              + ", ABI=" + ABI // NOI18N
              + ", VMContext=" + "[LLVMContext]" // NOI18N
              + ", TBAA=" + TBAA // NOI18N
              + ", TheTargetCodeGenInfo=" + TheTargetCodeGenInfo // NOI18N
              + ", Types=" + Types // NOI18N
              + ", VTables=" + VTables // NOI18N
              + ", ObjCRuntime=" + ObjCRuntime // NOI18N
              + ", OpenCLRuntime=" + OpenCLRuntime // NOI18N
              + ", OpenMPRuntime=" + OpenMPRuntime // NOI18N
              + ", CUDARuntime=" + CUDARuntime // NOI18N
              + ", DebugInfo=" + DebugInfo // NOI18N
              + ", ObjCData=" + ObjCData // NOI18N
              + ", NoObjCARCExceptionsMetadata=" + NoObjCARCExceptionsMetadata // NOI18N
              + ", PGOReader=" + PGOReader // NOI18N
              + ", PGOStats=" + PGOStats // NOI18N
              + ", SanStats=" + SanStats // NOI18N
              + ", WeakRefReferences=" + WeakRefReferences // NOI18N
              + ", DeferredDecls=" + "[Map$StringRef$GlobalDecl]" // NOI18N
              + ", DeferredDeclsToEmit=" + DeferredDeclsToEmit // NOI18N
              + ", Aliases=" + "[Vector$GlobalDecl]" // NOI18N
              + ", Replacements=" + Replacements // NOI18N
              + ", GlobalValReplacements=" + GlobalValReplacements // NOI18N
              + ", DiagnosedConflictingDefinitions=" + "[DenseSet$GlobalDecl]" // NOI18N
              + ", DeferredVTables=" + "[Vector$CXXRecordDecl]" // NOI18N
              + ", LLVMUsed=" + LLVMUsed // NOI18N
              + ", LLVMCompilerUsed=" + LLVMCompilerUsed // NOI18N
              + ", GlobalCtors=" + GlobalCtors // NOI18N
              + ", GlobalDtors=" + GlobalDtors // NOI18N
              + ", MangledDeclNames=" + MangledDeclNames // NOI18N
              + ", Manglings=" + "[StringMap$GlobalDecl]" // NOI18N
              + ", Annotations=" + Annotations // NOI18N
              + ", AnnotationStrings=" + AnnotationStrings // NOI18N
              + ", CFConstantStringMap=" + CFConstantStringMap // NOI18N
              + ", ConstantStringMap=" + ConstantStringMap // NOI18N
              + ", StaticLocalDeclMap=" + StaticLocalDeclMap // NOI18N
              + ", StaticLocalDeclGuardMap=" + StaticLocalDeclGuardMap // NOI18N
              + ", MaterializedGlobalTemporaryMap=" + MaterializedGlobalTemporaryMap // NOI18N
              + ", AtomicSetterHelperFnMap=" + AtomicSetterHelperFnMap // NOI18N
              + ", AtomicGetterHelperFnMap=" + AtomicGetterHelperFnMap // NOI18N
              + ", TypeDescriptorMap=" + TypeDescriptorMap // NOI18N
              + ", StaticExternCValues=" + StaticExternCValues // NOI18N
              + ", CXXThreadLocals=" + "[Vector$VarDecl]" // NOI18N
              + ", CXXThreadLocalInits=" + CXXThreadLocalInits // NOI18N
              + ", CXXThreadLocalInitVars=" + "[Vector$VarDecl]" // NOI18N
              + ", CXXGlobalInits=" + CXXGlobalInits // NOI18N
              + ", DelayedCXXInitPosition=" + "[DenseMapTypeUInt$Decl]" // NOI18N
              + ", PrioritizedCXXGlobalInits=" + PrioritizedCXXGlobalInits // NOI18N
              + ", CXXGlobalDtors=" + CXXGlobalDtors // NOI18N
              + ", ImportedModules=" + ImportedModules // NOI18N
              + ", LinkerOptionsMetadata=" + LinkerOptionsMetadata // NOI18N
              + ", CFConstantStringClassRef=" + CFConstantStringClassRef // NOI18N
              + ", ConstantStringClassRef=" + ConstantStringClassRef // NOI18N
              + ", NSConstantStringType=" + NSConstantStringType // NOI18N
              + ", ObjCFastEnumerationStateType=" + ObjCFastEnumerationStateType // NOI18N
              + ", NSConcreteGlobalBlock=" + NSConcreteGlobalBlock // NOI18N
              + ", NSConcreteStackBlock=" + NSConcreteStackBlock // NOI18N
              + ", BlockObjectAssign=" + BlockObjectAssign // NOI18N
              + ", BlockObjectDispose=" + BlockObjectDispose // NOI18N
              + ", BlockDescriptorType=" + BlockDescriptorType // NOI18N
              + ", GenericBlockLiteralType=" + GenericBlockLiteralType // NOI18N
              + ", Block=" + Block // NOI18N
              + ", LifetimeStartFn=" + LifetimeStartFn // NOI18N
              + ", LifetimeEndFn=" + LifetimeEndFn // NOI18N
              + ", initializedGlobalDecl=" + "[GlobalDecl]" // NOI18N
              + ", SanitizerMD=" + SanitizerMD // NOI18N
              + ", DeferredEmptyCoverageMappingDecls=" + "[DenseMapTypeBool$Decl]" // NOI18N
              + ", CoverageMapping=" + CoverageMapping // NOI18N
              + ", MetadataIdMap=" + MetadataIdMap // NOI18N
              + ", ByrefHelpersCache=" + ByrefHelpersCache // NOI18N
              + super.toString(); // NOI18N
  }
}
