@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof ObjCDictionaryLiteral) {
    checkPostStmt((ObjCDictionaryLiteral) stmt, C);
  } else if (stmt instanceof ObjCArrayLiteral) {
    checkPostStmt((ObjCArrayLiteral) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new PreObjCMessage(),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCDictionaryLiteral>(ObjCDictionaryLiteral.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCArrayLiteral>(ObjCArrayLiteral.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
