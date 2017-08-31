@Override public void $checkPostStmt(Stmt stmt, CheckerContext C) { if (stmt instanceof ImplicitCastExpr) { checkPostStmt((ImplicitCastExpr) stmt, C); } }

private final CheckBase $CHECKS[] = {
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ImplicitCastExpr>(ImplicitCastExpr.class)
};

@Override protected CheckBase[] $getChecks() { return $CHECKS; }
