@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof ReturnStmt) {
    checkPreStmt((ReturnStmt) stmt, C);
  }
}

@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof ObjCIvarRefExpr) {
    checkPostStmt((ObjCIvarRefExpr) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new PostObjCMessage(),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCIvarRefExpr>(ObjCIvarRefExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class),
  new PreCall(),
  new PostCall(),
  new Location(),
  new Bind()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
