@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof CastExpr) {
    checkPreStmt((CastExpr) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new org.clang.staticanalyzer.core.ento.check.PreStmt<CastExpr>(CastExpr.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
