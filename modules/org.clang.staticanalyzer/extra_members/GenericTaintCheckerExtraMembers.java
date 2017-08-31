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
  new org.clang.staticanalyzer.core.ento.check.PostStmt<CallExpr>(CallExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
