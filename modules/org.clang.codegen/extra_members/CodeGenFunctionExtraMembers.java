@FunctionalInterface public static interface AddressQualType2Void {
  void $call(CodeGenFunction $this, Address addr, QualType t);
}

@FunctionalInterface public static interface Address2Value {
  Value /*P*/ $call(CodeGenFunction $this, Address /*P*/ addr);
}

@FunctionalInterface public static interface ValueProducer {
  Value /*P*/ $call(CodeGenFunction $this);
}

@FunctionalInterface public static interface Value2Value {
  Value /*P*/ $call(CodeGenFunction $this, Value /*P*/ val);
}

@FunctionalInterface public static interface ValueQualType2Void {
  void $call(CodeGenFunction $this, Value /*P*/ val, QualType t);
}

@FunctionalInterface public static interface ValueOMPTaskDataTy2Void {
  void $call(CodeGenFunction $this, Value /*P*/ val, OMPTaskDataTy /*&*/ t);
}

@FunctionalInterface public static interface GenFun {
  void $call(CodeGenFunction $this);
}

@FunctionalInterface public static interface ThreeExpr2Void {
  void $call(CodeGenFunction /*&*/ $this, 
          /*const*/ Expr /*P*/ e1, 
          /*const*/ Expr /*P*/ e2, 
          /*const*/ Expr /*P*/ e3);
}

public type$ref<Instruction /*P*/> CurrentFuncletPad_ref = new type$ref<Instruction /*P*/>(){
  @Override
  public Instruction $deref() {
    return CurrentFuncletPad;
  }

  @Override
  public Instruction $set(Instruction value) {
    CurrentFuncletPad = value;
    return CurrentFuncletPad;
  }
};

public type$ref<FieldDecl /*P*/> LambdaThisCaptureField_ref = new type$ref<FieldDecl /*P*/>(){
  @Override
  public FieldDecl $deref() {
    return LambdaThisCaptureField;
  }

  @Override
  public FieldDecl $set(FieldDecl value) {
    LambdaThisCaptureField = value;
    return LambdaThisCaptureField;
  }
};

protected type$ref<ImplicitParamDecl> CXXStructorImplicitParamDecl_ref = new type$ref<ImplicitParamDecl>(){
  @Override
  public ImplicitParamDecl $deref() {
    return CXXStructorImplicitParamDecl;
  }

  @Override
  public ImplicitParamDecl $set(ImplicitParamDecl value) {
    CXXStructorImplicitParamDecl = value;
    return CXXStructorImplicitParamDecl;
  }

};

protected type$ref<Value /*P*/> CXXStructorImplicitParamValue_ref = new type$ref<Value /*P*/>() {
  @Override
  public Value $deref() {
    return CXXStructorImplicitParamValue;
  }

  @Override
  public Value $set(Value value) {
    CXXStructorImplicitParamValue = value;
    return CXXStructorImplicitParamValue;
  }
};

@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION)
public final </*typename*/ T extends ParamTypeObjC> void EmitCallArgs(final CallArgList /*&*/ Args, /*const*/ T /*P*/ CallArgTypeInfo, 
            iterator_range</*const*/ Expr /*P*/ /*const*/> ArgRange) {
  EmitCallArgs(Args, CallArgTypeInfo, 
            ArgRange, 
            (/*const*/ FunctionDecl /*P*/ )null, 
            0);
}
public final </*typename*/ T extends ParamTypeObjC> void EmitCallArgs(final CallArgList /*&*/ Args, /*const*/ T /*P*/ CallArgTypeInfo, 
            iterator_range</*const*/ Expr /*P*/ /*const*/> ArgRange, 
            /*const*/ FunctionDecl /*P*/ CalleeDecl/*= null*/) {
  EmitCallArgs(Args, CallArgTypeInfo, 
            ArgRange, 
            CalleeDecl, 
            0);
}
public final </*typename*/ T extends ParamTypeObjC> void EmitCallArgs(final CallArgList /*&*/ Args, /*const*/ T /*P*/ CallArgTypeInfo, 
            iterator_range</*const*/ Expr /*P*/ /*const*/> ArgRange, 
            /*const*/ FunctionDecl /*P*/ CalleeDecl/*= null*/, 
            /*uint*/int ParamsToSkip/*= 0*/) {
  SmallVector<QualType> ArgTypes/*J*/= new SmallVector<QualType>(16, new QualType());
  Stmt.ConstExprIterator Arg = ((Stmt.ConstExprIterator)ArgRange.begin());
  assert Native.$bool((ParamsToSkip == 0 || CallArgTypeInfo != null)) : "Can't skip parameters if type info is not provided";
  if (CallArgTypeInfo != null) {
    boolean isGenericMethod = isObjCMethodWithTypeParams((ObjCMethodDecl)CallArgTypeInfo);

    // First, use the argument types that the type info knows about
    for (mapped_iterator<ParmVarDecl/*P*/, QualType> I = CallArgTypeInfo.param_type_begin().$add(ParamsToSkip), 
        E = CallArgTypeInfo.param_type_end();
         Native.$noteq_ptr(I, E); I.$preInc() , Arg.$preInc()) {
      assert (Arg.$noteq(((Stmt.ConstExprIterator)ArgRange.end()))) : "Running over edge of argument list!";
      assert isGenericMethod ||
             I.$star().$star().isVariablyModifiedType() ||
             I.$star().getNonReferenceType().$star().isObjCRetainableType() || 
             Native.$eq(getContext().getCanonicalType(I.$star().getNonReferenceType()).getTypePtr(),
                        getContext().getCanonicalType((Arg.$star()).getType()).getTypePtr()) : "type mismatch in call argument!";
      ArgTypes.push_back((QualType)I.$star());
    }
  }

  // Either we've emitted all the call args, or we have a call to variadic
  // function.
  assert Arg.$eq(ArgRange.end()) || 
         Native.$not(CallArgTypeInfo) || 
         CallArgTypeInfo.isVariadic() : "Extra arguments in non-variadic function!";

  // If we still have any arguments, emit them using the type of the argument.
  Iterator<Expr> iterator = new JavaIterator<Expr>(Arg, ArgRange.end());
  while(iterator.hasNext()) {
    ArgTypes.push_back(getVarArgType(iterator.next()));
  }

  EmitCallArgs1(Args, new ArrayRef<QualType>(ArgTypes, false), new iterator_range</*const*/ Expr /*P*/ /*const*/>(ArgRange), CalleeDecl, ParamsToSkip);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 106,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERKS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERKS1_")
//</editor-fold>
protected/*private*/ CodeGenFunction(final /*const*/ CodeGenFunction /*&*/ $Prm0) {  super(null); throw new UnsupportedOperationException("Deleted");}

/*public:*/
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
public CodeGenFunction(final CodeGenModule /*&*/ cgm) {
  this(cgm, false);
}
public CodeGenFunction(final CodeGenModule /*&*/ cgm, boolean suppressNewContext/*= false*/) {
  // : CodeGenTypeCache(cgm), CGM(cgm), Target(cgm.getTarget()), LoopStack(), Builder(cgm, cgm.getModule().getContext(), ConstantFolder(), CGBuilderInserterTy(this)), FnRetTy(), CurFn(null), CurGD(), PrologueCleanupDepth(), ReturnBlock(), ReturnValue(Address::invalid()), AllocaInsertPt(), CapturedStmtInfo(null), SanOpts(CGM.getLangOpts().Sanitize), IsSanitizerScope(false), CurFuncIsThunk(false), AutoreleaseResult(false), SawAsmBlock(false), CurSEHParent(null), IsOutlinedSEHHelper(false), BlockInfo(null), BlockPointer(null), LambdaCaptureFields(), LambdaThisCaptureField(null), NRVOFlags(), EHStack(), LifetimeExtendedCleanupStack(), SEHTryEpilogueStack(), CurrentFuncletPad(null), NormalCleanupDest(null), NextCleanupDestIndex(1), FirstBlockInfo(null), EHResumeBlock(null), ExceptionSlot(null), EHSelectorSlot(null), SEHCodeSlotStack(), SEHInfo(null), ObjCEHValueStack(), DebugInfo(CGM.getModuleDebugInfo()), DisableDebugInfo(false), DidCallStackSave(false), IndirectBranch(null), LocalDeclMap(), SizeArguments(), EscapedLocals(), LabelMap(), BreakContinueStack(), PGO(cgm), SwitchInsn(null), SwitchWeights(null), CaseRangeBlock(null), OpaqueLValues(), OpaqueRValues(), VLASizeMap(), UnreachableBlock(null), NumReturnExprs(0), NumSimpleReturnExprs(0), LastStopPoint(), CXXABIThisDecl(null), CXXABIThisValue(null), CXXThisValue(null), CXXABIThisAlignment(), CXXThisAlignment(), CXXDefaultInitExprThis(Address::invalid()), CXXInheritedCtorInitExprArgs(), CXXStructorImplicitParamDecl(null), CXXStructorImplicitParamValue(null), OutermostConditional(null), CurLexicalScope(null), CurEHLocation(), BlockByrefInfos(), TerminateLandingPad(null), TerminateHandler(null), TrapBB(null), DeferredReplacements() 
  //START JInit
  super(cgm);
  this./*&*/CGM=/*&*/cgm;
  this./*&*/Target=/*&*/cgm.getTarget();
  this.LoopStack = new LoopInfoStack();
  this.Builder = new CGBuilderTy(cgm, cgm.getModule().getContext(), new ConstantFolder(), 
      new CGBuilderInserter(this));
  this.FnRetTy = new QualType();
  this.CurFn = null;
  this.CurGD = new GlobalDecl();
  this.PrologueCleanupDepth = new EHScopeStack.stable_iterator();
  this.ReturnBlock = new JumpDest();
  this.ReturnValue = Address.invalid();
  this.AllocaInsertPt = new AssertingVH<Instruction>();
  this.CapturedStmtInfo = null;
  this.SanOpts = new SanitizerSet(CGM.getLangOpts().Sanitize);
  this.IsSanitizerScope = false;
  this.CurFuncIsThunk = false;
  this.AutoreleaseResult = false;
  this.SawAsmBlock = false;
  /*InClass*/this.CurSEHParent = null;
  this.IsOutlinedSEHHelper = false;
  this.BlockInfo = null;
  this.BlockPointer = null;
  this.LambdaCaptureFields = new DenseMap</*const*/ VarDecl /*P*/ , FieldDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (FieldDecl /*P*/ )null);
  this.LambdaThisCaptureField = null;
  this.NRVOFlags = new DenseMap</*const*/ VarDecl /*P*/ , Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Value /*P*/ )null);
  this.EHStack = new EHScopeStack();
  this.LifetimeExtendedCleanupStack = new SmallString(256);
  this.SEHTryEpilogueStack = new SmallVector</*const*/ JumpDest /*P*/ >(2, (/*const*/ JumpDest /*P*/ )null);
  /*InClass*/this.CurrentFuncletPad = null;
  this.NormalCleanupDest = null;
  this.NextCleanupDestIndex = 1;
  this.FirstBlockInfo = null;
  this.EHResumeBlock = null;
  this.ExceptionSlot = null;
  this.EHSelectorSlot = null;
  this.SEHCodeSlotStack = new SmallVector<Address>(1, new Address());
  /*InClass*/this.SEHInfo = null;
  this.ObjCEHValueStack = new SmallVector<Value /*P*/ >(8, (Value /*P*/ )null);
  this.DebugInfo = CGM.getModuleDebugInfo();
  this.DisableDebugInfo = false;
  this.DidCallStackSave = false;
  this.IndirectBranch = null;
  this.LocalDeclMap = new DenseMap</*const*/ Decl /*P*/ , Address>(DenseMapInfo$LikePtr.$Info(), new Address());
  this.SizeArguments = new SmallDenseMap</*const*/ ParmVarDecl /*P*/ , /*const*/ ImplicitParamDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 2, (/*const*/ ImplicitParamDecl /*P*/ )null);
  this.EscapedLocals = new DenseMapTypeInt<AllocaInst /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
  this.LabelMap = new DenseMap</*const*/ LabelDecl /*P*/ , JumpDest>(DenseMapInfo$LikePtr.$Info(), new JumpDest());
  this.BreakContinueStack = new SmallVector<BreakContinue>(8, new BreakContinue());
  this.PGO = new CodeGenPGO(cgm);
  this.SwitchInsn = null;
  this.SwitchWeights = null;
  this.CaseRangeBlock = null;
  this.OpaqueLValues = new DenseMap</*const*/ OpaqueValueExpr /*P*/ , LValue>(DenseMapInfo$LikePtr.$Info(), new LValue());
  this.OpaqueRValues = new DenseMap</*const*/ OpaqueValueExpr /*P*/ , RValue>(DenseMapInfo$LikePtr.$Info(), new RValue());
  this.VLASizeMap = new DenseMap</*const*/ Expr /*P*/ , Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Value /*P*/ )null);
  this.UnreachableBlock = null;
  this.NumReturnExprs = 0;
  this.NumSimpleReturnExprs = 0;
  this.LastStopPoint = new SourceLocation();
  this.CXXABIThisDecl = null;
  this.CXXABIThisValue = null;
  this.CXXThisValue = null;
  this.CXXABIThisAlignment = new CharUnits();
  this.CXXThisAlignment = new CharUnits();
  /*InClass*/this.CXXDefaultInitExprThis = Address.invalid();
  this.CXXInheritedCtorInitExprArgs = new CallArgList();
  this.CXXStructorImplicitParamDecl = null;
  this.CXXStructorImplicitParamValue = null;
  this.OutermostConditional = null;
  this.CurLexicalScope = null;
  this.CurEHLocation = new SourceLocation();
  this.BlockByrefInfos = new DenseMap</*const*/ ValueDecl /*P*/ , BlockByrefInfo>(DenseMapInfo$LikePtr.$Info(), new BlockByrefInfo());
  this.TerminateLandingPad = null;
  this.TerminateHandler = null;
  this.TrapBB = null;
  this.DeferredReplacements = new SmallVector<std.pair<Instruction /*P*/ , Value /*P*/ >>(4, new std.pairPtrPtr<Instruction /*P*/ , Value /*P*/ >());
  //END JInit
  if (!suppressNewContext) {
    CGM.getCXXABI().getMangleContext().startNewFunction();
  }

  FastMathFlags FMF/*J*/= new FastMathFlags();
  if (CGM.getLangOpts().FastMath) {
    FMF.setUnsafeAlgebra();
  }
  if (CGM.getLangOpts().FiniteMathOnly) {
    FMF.setNoNaNs();
    FMF.setNoInfs();
  }
  if (CGM.getCodeGenOpts().NoNaNsFPMath) {
    FMF.setNoNaNs();
  }
  if (CGM.getCodeGenOpts().NoSignedZeros) {
    FMF.setNoSignedZeros();
  }
  if (CGM.getCodeGenOpts().ReciprocalMath) {
    FMF.setAllowReciprocal();
  }
  Builder.setFastMathFlags(new FastMathFlags(FMF));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::~CodeGenFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 85,
 FQN="clang::CodeGen::CodeGenFunction::~CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionD0Ev",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionD0Ev")
//</editor-fold>
public void $destroy() {
  assert (LifetimeExtendedCleanupStack.empty()) : "failed to emit a cleanup";

  // If there are any unclaimed block infos, go ahead and destroy them
  // now.  This can happen if IR-gen gets clever and skips evaluating
  // something.
  if ((FirstBlockInfo != null)) {
    CodeGenFunction.destroyBlockInfos(FirstBlockInfo);
  }
  if ((getLangOpts().OpenMP != 0)) {
    CGM.getOpenMPRuntime().functionFinished(/*Deref*/this);
  }
  //START JDestroy
  DeferredReplacements.$destroy();
  BlockByrefInfos.$destroy();
  CXXInheritedCtorInitExprArgs.$destroy();
  VLASizeMap.$destroy();
  OpaqueRValues.$destroy();
  OpaqueLValues.$destroy();
  PGO.$destroy();
  BreakContinueStack.$destroy();
  LabelMap.$destroy();
  EscapedLocals.$destroy();
  SizeArguments.$destroy();
  LocalDeclMap.$destroy();
  ObjCEHValueStack.$destroy();
  SEHCodeSlotStack.$destroy();
  SEHTryEpilogueStack.$destroy();
  LifetimeExtendedCleanupStack.$destroy();
  EHStack.$destroy();
  NRVOFlags.$destroy();
  LambdaCaptureFields.$destroy();
  AllocaInsertPt.$destroy();
  Builder.$destroy();
  LoopStack.$destroy();
  //super.$destroy();
  //END JDestroy
}

public static </*typename*/ T> boolean isObjCMethodWithTypeParams(/*const*/ T /*P*/ $Prm0) {
  return ($Prm0 instanceof ObjCMethodDecl) ? isObjCMethodWithTypeParams((ObjCMethodDecl)$Prm0) : isObjCMethodWithTypeParams$T($Prm0);
}
