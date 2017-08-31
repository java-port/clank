@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof ReturnStmt) {
    checkPreStmt((ReturnStmt) stmt, C);
  }
}

@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof ExplicitCastExpr) {
    checkPostStmt((ExplicitCastExpr) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new Bind(),
  new PreCall(),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class),
  new PostCall(),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ExplicitCastExpr>(ExplicitCastExpr.class),
  new PostObjCMessage(),
  new DeadSymbols(),
  new Event<ImplicitNullDerefEvent>(ImplicitNullDerefEvent.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}

// MANUAL: we need to remove static but keep delay of initialization
private static final class checkBind$$ {
  // JAVA: must not be static!
  // JAVA: can't initialize statically as "this" is used in init expr
  private final NullabilityChecker $this;

  private checkBind$$(NullabilityChecker owner) {
    this.$this = owner;
  }
  CheckerProgramPointTag $TagNullPassedToNonnull;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NullPassedToNonnull"));
  CheckerProgramPointTag $TagNullablePassedToNonnull;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NullablePassedToNonnull"));

  CheckerProgramPointTag TagNullPassedToNonnull() {
    if ($TagNullPassedToNonnull == null) {
      $TagNullPassedToNonnull/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"NullPassedToNonnull"));
    }
    return $TagNullPassedToNonnull;
  }

  CheckerProgramPointTag TagNullablePassedToNonnull() {
    if ($TagNullablePassedToNonnull == null) {
      $TagNullablePassedToNonnull/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"NullablePassedToNonnull"));
    }
    return $TagNullablePassedToNonnull;
  }
}
private final checkBind$$ checkBind$$ = new checkBind$$(this);

// MANUAL: we need to remove static but keep delay of initialization
private static final class checkPreStmt$$ {
  // JAVA: must not be static!
   private final NullabilityChecker $this;
   private checkPreStmt$$(NullabilityChecker owner) {
     this.$this = owner;
   }    
  CheckerProgramPointTag $TagNullReturnedFromNonnull;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NullReturnedFromNonnull"));
  CheckerProgramPointTag $TagNullableReturnedFromNonnull;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"NullableReturnedFromNonnull"));

  CheckerProgramPointTag TagNullReturnedFromNonnull() {
    if ($TagNullReturnedFromNonnull == null) {
      $TagNullReturnedFromNonnull/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"NullReturnedFromNonnull"));
    }
    return $TagNullReturnedFromNonnull;
  }

  CheckerProgramPointTag TagNullableReturnedFromNonnull() {
    if ($TagNullableReturnedFromNonnull == null) {
      $TagNullableReturnedFromNonnull/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"NullableReturnedFromNonnull"));
    }
    return $TagNullableReturnedFromNonnull;
  }    
}
private final checkPreStmt$$ checkPreStmt$$ = new checkPreStmt$$(this);
