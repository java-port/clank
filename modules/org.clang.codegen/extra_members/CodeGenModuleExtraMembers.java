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
  this.DeferredDecls = new std.map<StringRef, GlobalDecl>(new GlobalDecl());
  this.DeferredDeclsToEmit = new std.vector<DeferredGlobal>(new DeferredGlobal());
  this.Aliases = new std.vector<GlobalDecl>(new GlobalDecl());
  this.Replacements = new StringMap<TrackingVH<Constant>>(new TrackingVH<Constant>());
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
  Unnamed_field13.PointerAlignInBytes
     = $long2uchar(C.toCharUnitsFromBits(C.getTargetInfo().getPointerAlign(0)).getQuantity());
  Unnamed_field11.IntAlignInBytes
     = $long2uchar(C.toCharUnitsFromBits($uint2long(C.getTargetInfo().getIntAlign())).getQuantity());
  IntTy = IntegerType.get($LLVMContext, C.getTargetInfo().getIntWidth());
  Unnamed_field8.IntPtrTy = IntegerType.get($LLVMContext, $uchar2uint(PointerWidthInBits));
  Unnamed_field9.Int8PtrTy = Int8Ty.getPointerTo(0);
  Unnamed_field10.Int8PtrPtrTy = Unnamed_field9.Int8PtrTy.getPointerTo(0);

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
