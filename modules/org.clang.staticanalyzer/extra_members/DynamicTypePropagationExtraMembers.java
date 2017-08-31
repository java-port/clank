@Override
public void $checkPostStmt(Stmt stmt, CheckerContext C) {
  if (stmt instanceof CastExpr) {
    checkPostStmt((CastExpr) stmt, C);
  } else if (stmt instanceof CXXNewExpr) {
    checkPostStmt((CXXNewExpr) stmt, C);
  }
}

private final CheckBase $CHECKS[] = {
  new PreCall(),
  new PostCall(),
  new DeadSymbols(),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<CastExpr>(CastExpr.class),
  new org.clang.staticanalyzer.core.ento.check.PostStmt<CXXNewExpr>(CXXNewExpr.class),
  new PreObjCMessage(),
  new PostObjCMessage()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}

// MANUAL: we need to remove static but keep delay of initialization
private final class checkPostStmt$$ {
  // JAVA: must not be static!
   /*static final*//*static*/ CheckerProgramPointTag $IllegalConv/*J*/;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"IllegalConversion"));
   private final DynamicTypePropagation $this;
   private checkPostStmt$$(DynamicTypePropagation owner) {
     this.$this = owner;
   }
   CheckerProgramPointTag IllegalConv() {
     if ($IllegalConv == null) {
       $IllegalConv/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"IllegalConversion"));
     }
     return $IllegalConv;
   }
}
private final checkPostStmt$$ checkPostStmt$$ = new checkPostStmt$$(this);

// MANUAL: we need to remove static but keep delay of initialization
private final class checkPreObjCMessage$$ {
  // JAVA: must not be static!
   /*static final*//*static*/ CheckerProgramPointTag $Tag/*J*/;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"ArgTypeMismatch"));
   private final DynamicTypePropagation $this;
   private checkPreObjCMessage$$(DynamicTypePropagation owner) {
     this.$this = owner;
   }
   CheckerProgramPointTag Tag() {
     if ($Tag == null) {
       $Tag/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"ArgTypeMismatch"));
     }
     return $Tag;
   }
}
private final checkPreObjCMessage$$ checkPreObjCMessage$$ = new checkPreObjCMessage$$(this);
