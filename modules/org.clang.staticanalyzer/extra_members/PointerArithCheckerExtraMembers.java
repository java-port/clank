@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof UnaryOperator) {
    checkPreStmt((UnaryOperator) stmt, C);
  } else if (stmt instanceof BinaryOperator) {
    checkPreStmt((BinaryOperator) stmt, C);
  } else if (stmt instanceof ArraySubscriptExpr) {
    checkPreStmt((ArraySubscriptExpr) stmt, C);
  } else if (stmt instanceof CastExpr) {
    checkPreStmt((CastExpr) stmt, C);
  }
}

@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof CastExpr) {
    checkPostStmt((CastExpr) stmt, C);
  } else if (stmt instanceof CXXNewExpr) {
    checkPostStmt((CXXNewExpr) stmt, C);
  } else if (stmt instanceof CallExpr) {
    checkPostStmt((CallExpr) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new org.clang.staticanalyzer.core.ento.check.PreStmt<BinaryOperator>(BinaryOperator.class),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<UnaryOperator>(UnaryOperator.class),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<ArraySubscriptExpr>(ArraySubscriptExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<CastExpr>(CastExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<CastExpr>(CastExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<CXXNewExpr>(CXXNewExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<CallExpr>(CallExpr.class),
  new org.clang.staticanalyzer.core.ento.check.DeadSymbols()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
