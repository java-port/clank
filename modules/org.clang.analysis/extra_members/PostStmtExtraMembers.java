@Override public PostStmt clone() {
  assert this.getClass() == PostStmt.class : "must be overridden in " + this.getClass();
  return new PostStmt(this);
}

@Override public PostStmt move() {
  assert this.getClass() == PostStmt.class : "must be overridden in " + this.getClass();
  return new PostStmt(JD$Move.INSTANCE, this);
}
