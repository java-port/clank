public static <T extends Stmt> T/*P*/ $new_uint_ASTContext$C_uint(final /*const*/ ASTContext /*&*/ C, int Alignment, New$ConstructorCallback<T/*P*/> New$StmtCtr) {
  return $new_uint_ASTContext$C_uint(C, Alignment, null, New$StmtCtr);
}
public static <T extends Stmt> T/*P*/ $new_uint_ASTContext$C_uint(final /*const*/ ASTContext /*&*/ C, int Alignment, type$ptr<?> Mem, New$ConstructorCallback<T/*P*/> New$StmtCtr) {
  // TODO: keep $this in created Stmt?
  return TrailingObjectsUtils.$new_uint_voidPtr(MemoryForStmt$Supplier, Mem, New$StmtCtr);
}

public static <T extends Stmt> T/*P*/ $new_uint_ASTContext$C$P_uint(final /*const*/ ASTContext /*&*/ C, New$ConstructorCallback<T/*P*/> New$StmtCtr) {
  return $new_uint_ASTContext$C_uint(C, /*JAVA*/1, New$StmtCtr);
}
public static <T extends Stmt> T/*P*/ $new_uint_ASTContext$C$P_uint(final /*const*/ ASTContext /*&*/ C, int Alignment, New$ConstructorCallback<T/*P*/> New$StmtCtr) {
  return $new_uint_ASTContext$C_uint(C, Alignment, New$StmtCtr);
}

protected Stmt(Stmt other) {
  Unnamed_field.CallExprBits.NumPreArgs = other.Unnamed_field.CallExprBits.NumPreArgs;
  Unnamed_field.CastExprBits.BasePathSize = other.Unnamed_field.CastExprBits.BasePathSize;
  Unnamed_field.CastExprBits.Kind = other.Unnamed_field.CastExprBits.Kind;
  Unnamed_field.CharacterLiteralBits.Kind = other.Unnamed_field.CharacterLiteralBits.Kind;
  Unnamed_field.CompoundStmtBits.NumStmts = other.Unnamed_field.CompoundStmtBits.NumStmts;
  Unnamed_field.DeclRefExprBits.HadMultipleCandidates = other.Unnamed_field.DeclRefExprBits.HadMultipleCandidates;
  Unnamed_field.DeclRefExprBits.HasFoundDecl = other.Unnamed_field.DeclRefExprBits.HasFoundDecl;
  Unnamed_field.DeclRefExprBits.HasQualifier = other.Unnamed_field.DeclRefExprBits.HasQualifier;
  Unnamed_field.DeclRefExprBits.HasTemplateKWAndArgsInfo = other.Unnamed_field.DeclRefExprBits.HasTemplateKWAndArgsInfo;
  Unnamed_field.DeclRefExprBits.RefersToEnclosingVariableOrCapture = other.Unnamed_field.DeclRefExprBits.RefersToEnclosingVariableOrCapture;
  Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = other.Unnamed_field.ExprBits.ContainsUnexpandedParameterPack;
  Unnamed_field.ExprBits.InstantiationDependent = other.Unnamed_field.ExprBits.InstantiationDependent;
  Unnamed_field.ExprBits.TypeDependent = other.Unnamed_field.ExprBits.TypeDependent;
  Unnamed_field.ExprBits.ValueDependent = other.Unnamed_field.ExprBits.ValueDependent;
  Unnamed_field.ExprBits.ObjectKind = other.Unnamed_field.ExprBits.ObjectKind;
  Unnamed_field.ExprBits.ValueKind = other.Unnamed_field.ExprBits.ValueKind;
  Unnamed_field.ExprWithCleanupsBits.CleanupsHaveSideEffects = other.Unnamed_field.ExprWithCleanupsBits.CleanupsHaveSideEffects;
  Unnamed_field.ExprWithCleanupsBits.NumObjects = other.Unnamed_field.ExprWithCleanupsBits.NumObjects;
  Unnamed_field.FloatingLiteralBits.IsExact = other.Unnamed_field.FloatingLiteralBits.IsExact;
  Unnamed_field.FloatingLiteralBits.Semantics = other.Unnamed_field.FloatingLiteralBits.Semantics;
  Unnamed_field.IfStmtBits.IsConstexpr = other.Unnamed_field.IfStmtBits.IsConstexpr;
  Unnamed_field.InitListExprBits.HadArrayRangeDesignator = other.Unnamed_field.InitListExprBits.HadArrayRangeDesignator;
  Unnamed_field.ObjCIndirectCopyRestoreExprBits.ShouldCopy = other.Unnamed_field.ObjCIndirectCopyRestoreExprBits.ShouldCopy;
  Unnamed_field.PseudoObjectExprBits.NumSubExprs = other.Unnamed_field.PseudoObjectExprBits.NumSubExprs;
  Unnamed_field.PseudoObjectExprBits.ResultIndex = other.Unnamed_field.PseudoObjectExprBits.ResultIndex;
  Unnamed_field.StmtBits.sClass = other.Unnamed_field.StmtBits.sClass;
  Unnamed_field.TypeTraitExprBits.Kind = other.Unnamed_field.TypeTraitExprBits.Kind;
  Unnamed_field.TypeTraitExprBits.NumArgs = other.Unnamed_field.TypeTraitExprBits.NumArgs;
  Unnamed_field.TypeTraitExprBits.Value = other.Unnamed_field.TypeTraitExprBits.Value;
  Unnamed_field.UnaryExprOrTypeTraitExprBits.IsType = other.Unnamed_field.UnaryExprOrTypeTraitExprBits.IsType;
  Unnamed_field.UnaryExprOrTypeTraitExprBits.Kind = other.Unnamed_field.UnaryExprOrTypeTraitExprBits.Kind;
}

private static boolean assertThisConsumedByCreatedStmt(Stmt createdObj, type$ptr Mem) {
  // Not all classes derived from Stmt have trailing objects.
  // They must pass Mem as null into Stmt.$new(null, CtrLambda);
  assert createdObj != null;
  assert Mem != null;
  if (ThreadLocalThisSupplier.isNullMemoryMarker(Mem)) {
    assert /*REMOVE*/true || !(createdObj instanceof TrailingObjects) : "when create TrailingObjects child " + NativeTrace.getIdentityStr(createdObj) + ", then Mem must be provided externally";
    assert !(createdObj instanceof ITrailingObjectsJavaBase) : "when create ITrailingObjectsJavaBase child " + NativeTrace.getIdentityStr(createdObj) + ", then Mem must be provided externally";
    assert /*REMOVE*/(createdObj.$this$plus1 == null) || (createdObj.$this$plus1.$array() == null && createdObj.$this$plus1.$index() == 1);
  } else {
    assert /*REMOVE*/true || (createdObj instanceof TrailingObjects) || (createdObj instanceof ITrailingObjectsJavaBase): "when create Stmt child " + NativeTrace.getIdentityStr(createdObj) + ", then Mem must be null, as Stmt.$new(null, ...) or class must be ITrailingObjectsJavaBase or TrailingObjects derived";
    assert Mem.$star() == createdObj : "createdDecl should be in Mem, but got: " + Mem.$star();
    assert createdObj.$this$plus1.$sub(1).$eq(Mem) : "expected " + Mem + " vs. " + createdObj.$this$plus1.$sub(1);
  }
  return true;
}

private static final ThreadLocalThisSupplier<Stmt> MemoryForStmt$Supplier = ThreadLocalThisSupplier.Create(Stmt::assertThisConsumedByCreatedStmt, Stmt.class.getName(), true);

private final type$ptr<?> $this$plus1 = $toConst(MemoryForStmt$Supplier.consumeAssignedMemory$GetThisPlus1(this));

protected final type$ptr<?> $this() {
  assert $this$plus1 != null;
  return $this$plus1.$sub(1);
}

protected final type$ptr<?> $this$plus1() {
  return $this$plus1;
}

public type$ptr<?> $TrailingObjects() {
  return $this$plus1();
}
