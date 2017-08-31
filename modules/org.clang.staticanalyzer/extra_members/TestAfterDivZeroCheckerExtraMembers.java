@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof BinaryOperator) {
    checkPreStmt((BinaryOperator) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new org.clang.staticanalyzer.core.ento.check.PreStmt<BinaryOperator>(BinaryOperator.class),
  new BranchCondition(),
  new EndFunction()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
