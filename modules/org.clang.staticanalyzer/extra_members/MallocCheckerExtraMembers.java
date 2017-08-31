@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof CXXDeleteExpr) {
    checkPreStmt((CXXDeleteExpr) stmt, C);
  } else if (stmt instanceof ReturnStmt) {
    checkPreStmt((ReturnStmt) stmt, C);
  }
}

@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof CallExpr) {
    checkPostStmt((CallExpr) stmt, C);
  } else if (stmt instanceof CXXNewExpr) {
    checkPostStmt((CXXNewExpr) stmt, C);
  } else if (stmt instanceof BlockExpr) {
    checkPostStmt((BlockExpr) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new DeadSymbols(),
  new PointerEscape(),
  new ConstPointerEscape(),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class),
  new PreCall(),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<CallExpr>(CallExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<CXXNewExpr>(CXXNewExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<CXXDeleteExpr>(CXXDeleteExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<BlockExpr>(BlockExpr.class),
  new PostObjCMessage(),
  new Location(),
  new eval.Assume()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
