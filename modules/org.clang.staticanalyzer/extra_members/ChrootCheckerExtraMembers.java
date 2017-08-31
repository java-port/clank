@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof CallExpr) {
    checkPreStmt((CallExpr) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new eval.Call(),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
