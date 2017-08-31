@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof DeclStmt) {
    checkPreStmt((DeclStmt) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new eval.Call(),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<DeclStmt>(DeclStmt.class),
  new LiveSymbols(),
  new DeadSymbols(),
  new RegionChanges()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
