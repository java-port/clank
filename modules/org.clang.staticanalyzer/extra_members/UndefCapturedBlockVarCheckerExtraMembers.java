@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof BlockExpr) {
    checkPostStmt((BlockExpr) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new org.clang.staticanalyzer.core.ento.check.PostStmt<BlockExpr>(BlockExpr.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
