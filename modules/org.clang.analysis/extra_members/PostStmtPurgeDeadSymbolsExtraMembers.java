@Override public PostStmtPurgeDeadSymbols clone() {
  assert this.getClass() == PostStmtPurgeDeadSymbols.class : "must be overridden in " + this.getClass();
  return new PostStmtPurgeDeadSymbols(this);
}

@Override public PostStmtPurgeDeadSymbols move() {
  assert this.getClass() == PostStmtPurgeDeadSymbols.class : "must be overridden in " + this.getClass();
  return new PostStmtPurgeDeadSymbols(JD$Move.INSTANCE, this);
}
