@Override public PreStmt clone() {
  assert this.getClass() == PreStmt.class : "must be overridden in " + this.getClass();
  return new PreStmt(this);
}

@Override public PreStmt move() {
  assert this.getClass() == PreStmt.class : "must be overridden in " + this.getClass();
  return new PreStmt(JD$Move.INSTANCE, this);
}
