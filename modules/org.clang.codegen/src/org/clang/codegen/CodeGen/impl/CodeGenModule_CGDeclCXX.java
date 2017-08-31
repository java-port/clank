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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.llvm.ir.FunctionType;
import static org.llvm.support.sys.path.filename;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_CGDeclCXX">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_CGDeclCXX",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_CGDecl ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21EmitCXXGlobalDtorFuncEv;_ZN5clang7CodeGen13CodeGenModule21EmitCXXGlobalInitFuncEv;_ZN5clang7CodeGen13CodeGenModule21EmitPointerToInitFuncEPKNS_7VarDeclEPN4llvm14GlobalVariableEPNS5_8FunctionEPNS_11InitSegAttrE;_ZN5clang7CodeGen13CodeGenModule26EmitCXXThreadLocalInitFuncEv;_ZN5clang7CodeGen13CodeGenModule28EmitCXXGlobalVarDeclInitFuncEPKNS_7VarDeclEPN4llvm14GlobalVariableEb;_ZN5clang7CodeGen13CodeGenModule34CreateGlobalInitOrDestructFunctionEPN4llvm12FunctionTypeERKNS2_5TwineERKNS0_14CGFunctionInfoENS_14SourceLocationEb; -static-type=CodeGenModule_CGDeclCXX -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_CGDeclCXX extends CodeGenModule_CGDecl {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::CreateGlobalInitOrDestructFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 259,
 FQN="clang::CodeGen::CodeGenModule::CreateGlobalInitOrDestructFunction", NM="_ZN5clang7CodeGen13CodeGenModule34CreateGlobalInitOrDestructFunctionEPN4llvm12FunctionTypeERKNS2_5TwineERKNS0_14CGFunctionInfoENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule34CreateGlobalInitOrDestructFunctionEPN4llvm12FunctionTypeERKNS2_5TwineERKNS0_14CGFunctionInfoENS_14SourceLocationEb")
//</editor-fold>
public final Function /*P*/ CreateGlobalInitOrDestructFunction(FunctionType /*P*/ FTy, final /*const*/ Twine /*&*/ Name, final /*const*/ CGFunctionInfo /*&*/ FI) {
  return CreateGlobalInitOrDestructFunction(FTy, Name, FI, 
                                  new SourceLocation(), false);
}
public final Function /*P*/ CreateGlobalInitOrDestructFunction(FunctionType /*P*/ FTy, final /*const*/ Twine /*&*/ Name, final /*const*/ CGFunctionInfo /*&*/ FI, 
                                  SourceLocation Loc/*= SourceLocation()*/) {
  return CreateGlobalInitOrDestructFunction(FTy, Name, FI, 
                                  Loc, false);
}
public final Function /*P*/ CreateGlobalInitOrDestructFunction(FunctionType /*P*/ FTy, final /*const*/ Twine /*&*/ Name, final /*const*/ CGFunctionInfo /*&*/ FI, 
                                  SourceLocation Loc/*= SourceLocation()*/, boolean TLS/*= false*/) {
  Function /*P*/ Fn = Function.Create(FTy, GlobalValue.LinkageTypes.InternalLinkage, 
      Name, $AddrOf($this().getModule()));
  if (!$this().getLangOpts().AppleKext && !TLS) {
    {
      // Set the section if needed.
      /*const*/char$ptr/*char P*/ Section = $tryClone($this().getTarget().getStaticInitSectionSpecifier());
      if (Native.$bool(Section)) {
        Fn.setSection(new StringRef(Section));
      }
    }
  }
  
  $this().SetInternalFunctionAttributes((/*const*/ Decl /*P*/ )null, Fn, FI);
  
  Fn.setCallingConv(/*J:ToBase*/$this().getRuntimeCC());
  if (!$this().getLangOpts().Exceptions) {
    Fn.setDoesNotThrow();
  }
  if (!$this().isInSanitizerBlacklist(Fn, new SourceLocation(Loc))) {
    if ($this().getLangOpts().Sanitize.hasOneOf(SanitizerKind.Address
           | SanitizerKind.KernelAddress)) {
      Fn.addFnAttr(Attribute.AttrKind.SanitizeAddress);
    }
    if ($this().getLangOpts().Sanitize.has(SanitizerKind.Thread)) {
      Fn.addFnAttr(Attribute.AttrKind.SanitizeThread);
    }
    if ($this().getLangOpts().Sanitize.has(SanitizerKind.Memory)) {
      Fn.addFnAttr(Attribute.AttrKind.SanitizeMemory);
    }
    if ($this().getLangOpts().Sanitize.has(SanitizerKind.SafeStack)) {
      Fn.addFnAttr(Attribute.AttrKind.SafeStack);
    }
  }
  
  return Fn;
}


/// \brief Emit the function that initializes C++ thread_local variables.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitCXXThreadLocalInitFunc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 399,
 FQN="clang::CodeGen::CodeGenModule::EmitCXXThreadLocalInitFunc", NM="_ZN5clang7CodeGen13CodeGenModule26EmitCXXThreadLocalInitFuncEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule26EmitCXXThreadLocalInitFuncEv")
//</editor-fold>
protected/*private*/ final void EmitCXXThreadLocalInitFunc() {
  $this().getCXXABI().EmitThreadLocalInitFuncs(/*Deref*/$this(), new ArrayRef</*const*/ VarDecl /*P*/ >($this().CXXThreadLocals, true), new ArrayRef<Function /*P*/ >($this().CXXThreadLocalInits, true), new ArrayRef</*const*/ VarDecl /*P*/ >($this().CXXThreadLocalInitVars, true));
  
  $this().CXXThreadLocalInits.clear();
  $this().CXXThreadLocalInitVars.clear();
  $this().CXXThreadLocals.clear();
}


/// Emit the function that initializes C++ globals.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitCXXGlobalInitFunc">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 408,
 FQN="clang::CodeGen::CodeGenModule::EmitCXXGlobalInitFunc", NM="_ZN5clang7CodeGen13CodeGenModule21EmitCXXGlobalInitFuncEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21EmitCXXGlobalInitFuncEv")
//</editor-fold>
protected/*private*/ final void EmitCXXGlobalInitFunc() {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    while (!$this().CXXGlobalInits.empty() && !($this().CXXGlobalInits.back() != null)) {
      $this().CXXGlobalInits.pop_back();
    }
    if ($this().CXXGlobalInits.empty() && $this().PrioritizedCXXGlobalInits.empty()) {
      return;
    }
    
    FunctionType /*P*/ FTy = FunctionType.get($this().VoidTy, false);
    final /*const*/ CGFunctionInfo /*&*/ FI = $this().getTypes().arrangeNullaryFunction();
    
    // Create our global initialization function.
    if (!$this().PrioritizedCXXGlobalInits.empty()) {
      SmallVector<Function /*P*/ > LocalCXXGlobalInits/*J*/= new SmallVector<Function /*P*/ >(8, (Function /*P*/ )null);
      llvm.array_pod_sort($this().PrioritizedCXXGlobalInits.begin(), 
          $this().PrioritizedCXXGlobalInits.end());
      // Iterate over "chunks" of ctors with same priority and emit each chunk
      // into separate function. Note - everything is sorted first by priority,
      // second - by lex order, so we emit ctor functions in proper order.
      for (type$ptr<std.pair<OrderGlobalInits, Function /*P*/ >> I = $tryClone($this().PrioritizedCXXGlobalInits.begin()), 
          /*P*/ E = $tryClone($this().PrioritizedCXXGlobalInits.end()); $noteq_ptr(I, E);) {
        type$ptr<std.pair<OrderGlobalInits, Function /*P*/ >> PrioE = std.upper_bound(I.$add(1), E, I.$star(), new GlobalInitPriorityCmp());
        
        LocalCXXGlobalInits.clear();
        /*uint*/int Priority = I./*->*/$star().first.priority;
        // Compute the function suffix from priority. Prepend with zeroes to make
        // sure the function names are also ordered as priorities.
        std.string PrioritySuffix = llvm.utostr($uint2ulong(Priority));
        // Priority is always <= 65535 (enforced by sema).
        PrioritySuffix.$assignMove($add_string_string$C(new std.string(6 - PrioritySuffix.size(), $$0), PrioritySuffix));
        Function /*P*/ Fn = $this().CreateGlobalInitOrDestructFunction(FTy, new Twine($add_T$C$P_string$C(/*KEEP_STR*/"_GLOBAL__I_", PrioritySuffix)), FI);
        
        for (; I.$less(PrioE); I.$preInc())  {
          LocalCXXGlobalInits.push_back(I./*->*/$star().second);
        }
        
        $c$.track(new CodeGenFunction(/*Deref*/$this())).GenerateCXXGlobalInitFunc(Fn, new ArrayRef<Function /*P*/ >(LocalCXXGlobalInits, true)); $c$.clean();
        $this().AddGlobalCtor(Fn, Priority);
      }
      $this().PrioritizedCXXGlobalInits.clear();
    }
    
    SmallString/*<128>*/ FileName/*J*/= new SmallString/*<128>*/(128);
    final SourceManager /*&*/ SM = $this().Context.getSourceManager();
    {
      /*const*/ FileEntry /*P*/ MainFile = SM.getFileEntryForID(SM.getMainFileID());
      if ((MainFile != null)) {
        // Include the filename in the symbol name. Including "sub_" matches gcc and
        // makes sure these symbols appear lexicographically behind the symbols with
        // priority emitted above.
        FileName.$assign(filename(new StringRef(MainFile.getName())));
      } else {
        FileName.$assign(/*STRINGREF_STR*/"<null>");
      }
    }
    
    for (/*size_t*/int i = 0; $less_uint(i, FileName.size()); ++i) {
      // Replace everything that's not [a-zA-Z0-9._] with a _. This set happens
      // to be the set of C preprocessing numbers.
      if (!isPreprocessingNumberBody(FileName.$at(i))) {
        FileName.$set(i, $$UNDERSCORE);
      }
    }
    
    Function /*P*/ Fn = $this().CreateGlobalInitOrDestructFunction(FTy, new Twine(/*KEEP_STR*/"_GLOBAL__sub_I_", FileName.$StringRef()), FI);
    
    $c$.track(new CodeGenFunction(/*Deref*/$this())).GenerateCXXGlobalInitFunc(Fn, new ArrayRef<Function /*P*/ >($this().CXXGlobalInits, true)); $c$.clean();
    $this().AddGlobalCtor(Fn);
    
    $this().CXXGlobalInits.clear();
  } finally {
    $c$.$destroy();
  }
}


/// Emit the function that destroys C++ globals.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitCXXGlobalDtorFunc">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 479,
 FQN="clang::CodeGen::CodeGenModule::EmitCXXGlobalDtorFunc", NM="_ZN5clang7CodeGen13CodeGenModule21EmitCXXGlobalDtorFuncEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21EmitCXXGlobalDtorFuncEv")
//</editor-fold>
protected/*private*/ final void EmitCXXGlobalDtorFunc() {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if ($this().CXXGlobalDtors.empty()) {
      return;
    }
    
    FunctionType /*P*/ FTy = FunctionType.get($this().VoidTy, false);
    
    // Create our global destructor function.
    final /*const*/ CGFunctionInfo /*&*/ FI = $this().getTypes().arrangeNullaryFunction();
    Function /*P*/ Fn = $this().CreateGlobalInitOrDestructFunction(FTy, new Twine(/*KEEP_STR*/"_GLOBAL__D_a"), FI);
    
    $c$.track(new CodeGenFunction(/*Deref*/$this())).GenerateCXXGlobalDtorsFunc(Fn, $this().CXXGlobalDtors); $c$.clean();
    $this().AddGlobalDtor(Fn);
  } finally {
    $c$.$destroy();
  }
}


/// Emit the function that initializes the specified global (if PerformInit is
/// true) and registers its destructor.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitCXXGlobalVarDeclInitFunc">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 311,
 FQN="clang::CodeGen::CodeGenModule::EmitCXXGlobalVarDeclInitFunc", NM="_ZN5clang7CodeGen13CodeGenModule28EmitCXXGlobalVarDeclInitFuncEPKNS_7VarDeclEPN4llvm14GlobalVariableEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule28EmitCXXGlobalVarDeclInitFuncEPKNS_7VarDeclEPN4llvm14GlobalVariableEb")
//</editor-fold>
protected/*private*/ final void EmitCXXGlobalVarDeclInitFunc(/*const*/ VarDecl /*P*/ D, 
                            GlobalVariable /*P*/ Addr, 
                            boolean PerformInit) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    
    // According to E.2.3.1 in CUDA-7.5 Programming guide: __device__,
    // __constant__ and __shared__ variables defined in namespace scope,
    // that are of class type, cannot have a non-empty constructor. All
    // the checks have been done in Sema by now. Whatever initializers
    // are allowed are empty and we just need to ignore them here.
    if ($this().getLangOpts().CUDA && $this().getLangOpts().CUDAIsDevice
       && (D.hasAttr(CUDADeviceAttr.class) || D.hasAttr(CUDAConstantAttr.class)
       || D.hasAttr(CUDASharedAttr.class))) {
      return;
    }
    
    // Check if we've already initialized this decl.
    DenseMapIteratorTypeUInt</*const*/ Decl /*P*/ /*P*/> I = $this().DelayedCXXInitPosition.find(D);
    if (I.$noteq(/*NO_ITER_COPY*/$this().DelayedCXXInitPosition.end()) && I.$arrow().second == ~0/*U*/) {
      return;
    }
    
    FunctionType /*P*/ FTy = FunctionType.get($this().VoidTy, false);
    SmallString/*<256>*/ FnName/*J*/= new SmallString/*<256>*/(256);
    {
      raw_svector_ostream Out = null;
      try {
        Out/*J*/= new raw_svector_ostream(FnName);
        $this().getCXXABI().getMangleContext().mangleDynamicInitializer(D, Out);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    
    // Create a variable initialization function.
    Function /*P*/ Fn = $this().CreateGlobalInitOrDestructFunction(FTy, new Twine(FnName.str()), 
        $this().getTypes().arrangeNullaryFunction(), 
        D.getLocation());
    
    InitSegAttr /*P*/ ISA = D.getAttr(InitSegAttr.class);
    $c$.track(new CodeGenFunction(/*Deref*/$this())).GenerateCXXGlobalVarDeclInitFunc(Fn, D, Addr, 
        PerformInit); $c$.clean();
    
    GlobalVariable /*P*/ COMDATKey = $this().supportsCOMDAT() && D.isExternallyVisible() ? Addr : null;
    if ((D.getTLSKind().getValue() != 0)) {
      // FIXME: Should we support init_priority for thread_local?
      // FIXME: Ideally, initialization of instantiated thread_local static data
      // members of class templates should not trigger initialization of other
      // entities in the TU.
      // FIXME: We only need to register one __cxa_thread_atexit function for the
      // entire TU.
      $this().CXXThreadLocalInits.push_back_T$C$R(Fn);
      $this().CXXThreadLocalInitVars.push_back_T$C$R(D);
    } else if (PerformInit && (ISA != null)) {
      $this().EmitPointerToInitFunc(D, Addr, Fn, ISA);
    } else {
      InitPriorityAttr /*P*/ IPA = D.getAttr(InitPriorityAttr.class);
      if ((IPA != null)) {
        OrderGlobalInits Key/*J*/= new OrderGlobalInits(IPA.getPriority(), $this().PrioritizedCXXGlobalInits.size());
        $this().PrioritizedCXXGlobalInits.push_back(std.make_pair_T_Ptr($Clone(Key), Fn));
      } else if (isTemplateInstantiation(D.getTemplateSpecializationKind())) {
        // C++ [basic.start.init]p2:
        //   Definitions of explicitly specialized class template static data
        //   members have ordered initialization. Other class template static data
        //   members (i.e., implicitly or explicitly instantiated specializations)
        //   have unordered initialization.
        //
        // As a consequence, we can put them into their own llvm.global_ctors entry.
        //
        // If the global is externally visible, put the initializer into a COMDAT
        // group with the global being initialized.  On most platforms, this is a
        // minor startup time optimization.  In the MS C++ ABI, there are no guard
        // variables, so this COMDAT key is required for correctness.
        $this().AddGlobalCtor(Fn, 65535, COMDATKey);
      } else if (D.hasAttr(SelectAnyAttr.class)) {
        // SelectAny globals will be comdat-folded. Put the initializer into a
        // COMDAT group associated with the global, so the initializers get folded
        // too.
        $this().AddGlobalCtor(Fn, 65535, COMDATKey);
      } else {
        I.$assignMove($this().DelayedCXXInitPosition.find(D)); // Re-do lookup in case of re-hash.
        if (I.$eq(/*NO_ITER_COPY*/$this().DelayedCXXInitPosition.end())) {
          $this().CXXGlobalInits.push_back_T$C$R(Fn);
        } else if (I.$arrow().second != ~0/*U*/) {
          assert ($less_uint(I.$arrow().second, $this().CXXGlobalInits.size()) && $this().CXXGlobalInits.$at(I.$arrow().second) == null);
          $this().CXXGlobalInits.$set(I.$arrow().second, Fn);
        }
      }
    }
    
    // Remember that we already emitted the initializer for this global.
    $this().DelayedCXXInitPosition.$set(D, ~0/*U*/);
  } finally {
    $c$.$destroy();
  }
}


/// Create a global pointer to a function that will initialize a global
/// variable.  The user has requested that this pointer be emitted in a specific
/// section.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitPointerToInitFunc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp", line = 296,
 FQN="clang::CodeGen::CodeGenModule::EmitPointerToInitFunc", NM="_ZN5clang7CodeGen13CodeGenModule21EmitPointerToInitFuncEPKNS_7VarDeclEPN4llvm14GlobalVariableEPNS5_8FunctionEPNS_11InitSegAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21EmitPointerToInitFuncEPKNS_7VarDeclEPN4llvm14GlobalVariableEPNS5_8FunctionEPNS_11InitSegAttrE")
//</editor-fold>
protected/*private*/ final void EmitPointerToInitFunc(/*const*/ VarDecl /*P*/ D, 
                     GlobalVariable /*P*/ GV, 
                     Function /*P*/ InitFunc, 
                     InitSegAttr /*P*/ ISA) {
  GlobalVariable /*P*/ PtrArray = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable($this().TheModule, InitFunc.getType(), /*isConstant=*/ true, 
      GlobalValue.LinkageTypes.PrivateLinkage, InitFunc, new Twine(/*KEEP_STR*/"__cxx_init_fn_ptr"));
   });
  PtrArray.setSection(ISA.getSection());
  $this().addUsedGlobal(PtrArray);
  {
    
    // If the GV is already in a comdat group, then we have to join it.
    Comdat /*P*/ C = GV.getComdat();
    if ((C != null)) {
      PtrArray.setComdat(C);
    }
  }
}

} // END OF class CodeGenModule_CGDeclCXX
