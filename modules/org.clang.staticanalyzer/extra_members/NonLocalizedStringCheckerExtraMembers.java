@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof ObjCStringLiteral) {
    checkPostStmt((ObjCStringLiteral) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new PostCall(),
  new PreObjCMessage(),
  new PostObjCMessage(),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCStringLiteral>(ObjCStringLiteral.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}

public static final Comparator<std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>> PAIR_IIPTR_SELECTOR_COMPARATOR = new Comparator<std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector>>() {
  @Override
  public int compare(std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector> o1, std.pairPtrType</*const*/ IdentifierInfo /*P*/ , Selector> o2) {
    assert o1.first != null;
    assert o2.first != null;
    int res = (o1.first.compareKey(o2.first));
    if (res != 0) {
      return res;
    }
    assert o1.first == o2.first : "equal IdentifierInfo must be equal instances " + NativeTrace.getIdentityStr(o1.first) + " vs. " + NativeTrace.getIdentityStr(o2.first);
    return Selector.COMPARATOR.compare(o1.second, o2.second);
  }
};
