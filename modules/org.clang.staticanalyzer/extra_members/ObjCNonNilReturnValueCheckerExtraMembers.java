@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof ObjCArrayLiteral) {
    checkPostStmt((ObjCArrayLiteral) stmt, C);
  } else if (stmt instanceof ObjCDictionaryLiteral) {
    checkPostStmt((ObjCDictionaryLiteral) stmt, C);
  } else if (stmt instanceof ObjCBoxedExpr) {
    checkPostStmt((ObjCBoxedExpr) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new PostObjCMessage(),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCArrayLiteral>(ObjCArrayLiteral.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCDictionaryLiteral>(ObjCDictionaryLiteral.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCBoxedExpr>(ObjCBoxedExpr.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
