@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof ReturnStmt) {
    checkPreStmt((ReturnStmt) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new ASTDecl<ObjCImplementationDecl>(ObjCImplementationDecl.class),
  new PreObjCMessage(),
  new PostObjCMessage(),
  new PreCall(),
  new BeginFunction(),
  new EndFunction(),
  new eval.Assume(),
  new PointerEscape(),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
