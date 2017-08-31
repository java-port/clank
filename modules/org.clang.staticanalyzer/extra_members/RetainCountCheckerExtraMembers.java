@Override public void $checkPreStmt(Stmt stmt, CheckerContext C) { if (stmt instanceof ReturnStmt) { checkPreStmt((ReturnStmt) stmt, C); } }

@Override public void $checkPostStmt(Stmt stmt, CheckerContext C) { if (stmt instanceof BlockExpr) { checkPostStmt((BlockExpr) stmt, C); } else if (stmt instanceof CastExpr) { checkPostStmt((CastExpr) stmt, C); } else if (stmt instanceof ObjCArrayLiteral) { checkPostStmt((ObjCArrayLiteral) stmt, C); } else if (stmt instanceof ObjCDictionaryLiteral) { checkPostStmt((ObjCDictionaryLiteral) stmt, C); } else if (stmt instanceof ObjCDictionaryLiteral) { checkPostStmt((ObjCDictionaryLiteral) stmt, C); } else if (stmt instanceof ObjCIvarRefExpr) { checkPostStmt((ObjCIvarRefExpr) stmt, C); } }

private final CheckBase $CHECKS[] = {
  new Bind(),
  new DeadSymbols(),
  new EndAnalysis(),
  new EndFunction(),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<BlockExpr>(BlockExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<CastExpr>(CastExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCArrayLiteral>(ObjCArrayLiteral.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCDictionaryLiteral>(ObjCDictionaryLiteral.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCBoxedExpr>(ObjCBoxedExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCIvarRefExpr>(ObjCIvarRefExpr.class),
  new PostCall(),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class),
  new RegionChanges(),
  new eval.Assume(),
  new eval.Call()
};

@Override protected CheckBase[] $getChecks() { return $CHECKS; }

// MANUAL: we need to remove static but keep delay of initialization
private static final class checkPreStmt$$ {
  private final RetainCountChecker $this;
  private checkPreStmt$$(RetainCountChecker owner) {
    this.$this = owner;
  }   
  // JAVA: must not be static!
  CheckerProgramPointTag $AutoreleaseTag;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"Autorelease"));

  CheckerProgramPointTag AutoreleaseTag() {
    if ($AutoreleaseTag == null) {
      $AutoreleaseTag/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"Autorelease"));
    }
    return $AutoreleaseTag;
  }
}
private final checkPreStmt$$ checkPreStmt$$ = new checkPreStmt$$(this);

private static final class checkReturnWithRetEffect$$ {
  private final RetainCountChecker $this;
  private checkReturnWithRetEffect$$(RetainCountChecker owner) {
    this.$this = owner;
  }       
  // JAVA: must not be static
  // JAVA: can not initialize statically since "this" is used in initialisation
  /*static*/ CheckerProgramPointTag $ReturnOwnLeakTag/*J*/;//= new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"ReturnsOwnLeak"));
  /*static*/ CheckerProgramPointTag $ReturnNotOwnedTag/*J*/;//= new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"ReturnNotOwnedForOwned"));
  CheckerProgramPointTag ReturnOwnLeakTag() {
    if ($ReturnOwnLeakTag == null) {
      $ReturnOwnLeakTag/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"ReturnsOwnLeak"));
    }
    return $ReturnOwnLeakTag;
  }  

  CheckerProgramPointTag ReturnNotOwnedTag() {
    if ($ReturnNotOwnedTag == null) {
      $ReturnNotOwnedTag/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"ReturnNotOwnedForOwned"));
    }
    return $ReturnNotOwnedTag;
  }    
}
private final checkReturnWithRetEffect$$ checkReturnWithRetEffect$$ = new checkReturnWithRetEffect$$(this);
