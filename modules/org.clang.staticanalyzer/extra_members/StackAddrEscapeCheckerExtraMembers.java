@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof ReturnStmt) {
    checkPreStmt((ReturnStmt) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class),
  new EndFunction()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
