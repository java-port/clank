@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof Expr) {
    checkPostStmt((Expr) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new org.clang.staticanalyzer.core.ento.check.PostStmt<Expr>(Expr.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
