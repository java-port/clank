@Override public CFGStmt clone() {
  assert this.getClass() == CFGStmt.class : "must be overridden in " + this.getClass();
  return new CFGStmt(this);
}

@Override public CFGStmt move() {
  assert this.getClass() == CFGStmt.class : "must be overridden in " + this.getClass();
  return new CFGStmt(JD$Move.INSTANCE, this);
}
