private final CheckBase $CHECKS[] = {
  new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PreStmt<CXXDeleteExpr>(CXXDeleteExpr.class),
  new PreObjCMessage(),
  new ObjCMessageNil(),
  new PreCall()
};

@Override protected CheckBase[] $getChecks() { return $CHECKS; }

@Override
public void $checkPreStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof CallExpr) {
    checkPreStmt((CallExpr) stmt, C);
  } else if (stmt instanceof CXXDeleteExpr) {
    checkPreStmt((CXXDeleteExpr) stmt, C);
  }
}

// MANUAL: we need to remove static but keep delay of initialization
private final class HandleNilReceiver$$ {
  // JAVA: must not be static!
   /*static final*//*static*/ CheckerProgramPointTag $Tag/*J*/;// = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"NilReceiver"));
   private final CallAndMessageChecker $this;
   private HandleNilReceiver$$(CallAndMessageChecker owner) {
     this.$this = owner;
   }
   CheckerProgramPointTag Tag() {
     if ($Tag == null) {
       $Tag/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"NilReceiver"));
     }
     return $Tag;
   }
}
private final HandleNilReceiver$$ HandleNilReceiver$$ = new HandleNilReceiver$$(this);
