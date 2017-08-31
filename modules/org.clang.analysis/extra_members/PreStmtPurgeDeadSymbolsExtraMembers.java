@Override public PreStmtPurgeDeadSymbols clone() {
  assert this.getClass() == PreStmtPurgeDeadSymbols.class : "must be overridden in " + this.getClass();
  return new PreStmtPurgeDeadSymbols(this);
}

@Override public PreStmtPurgeDeadSymbols move() {
  assert this.getClass() == PreStmtPurgeDeadSymbols.class : "must be overridden in " + this.getClass();
  return new PreStmtPurgeDeadSymbols(JD$Move.INSTANCE, this);
}
