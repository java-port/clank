@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof BinaryOperator) {
    checkPostStmt((BinaryOperator) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new org.clang.staticanalyzer.core.ento.check.PostStmt<BinaryOperator>(BinaryOperator.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
