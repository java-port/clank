@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof ObjCForCollectionStmt) {
    checkPostStmt((ObjCForCollectionStmt) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCForCollectionStmt>(ObjCForCollectionStmt.class),
  new PostObjCMessage(),
  new DeadSymbols(),
  new PointerEscape()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
