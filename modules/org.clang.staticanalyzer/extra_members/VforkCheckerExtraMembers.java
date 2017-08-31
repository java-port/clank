@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof ReturnStmt) {
    checkPreStmt((ReturnStmt) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new PreCall(),
  new PostCall(),
  new Bind(),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
