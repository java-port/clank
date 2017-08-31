@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof CallExpr) {
    checkPreStmt((CallExpr) stmt, C);
  }
}

@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof CallExpr) {
    checkPostStmt((CallExpr) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<CallExpr>(CallExpr.class),
  new DeadSymbols()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}

// MANUAL: we need to remove static but keep delay of initialization
private final class checkDeadSymbols$$ {
  // JAVA: must not be static!
   /*static final*//*static*/ CheckerProgramPointTag $Tag/*J*/;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"DeadSymbolsLeak"));
   private final MacOSKeychainAPIChecker $this;
   private checkDeadSymbols$$(MacOSKeychainAPIChecker owner) {
     this.$this = owner;
   }
   CheckerProgramPointTag Tag() {
     if ($Tag == null) {
       $Tag/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"DeadSymbolsLeak"));
     }
     return $Tag;
   }
}
private final checkDeadSymbols$$ checkDeadSymbols$$ = new checkDeadSymbols$$(this);
