@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof ObjCAtSynchronizedStmt) {
    checkPreStmt((ObjCAtSynchronizedStmt) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new org.clang.staticanalyzer.core.ento.check.PreStmt<ObjCAtSynchronizedStmt>(ObjCAtSynchronizedStmt.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
