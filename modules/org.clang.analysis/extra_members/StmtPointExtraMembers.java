@Override public StmtPoint clone() {
  assert this.getClass() == StmtPoint.class : "must be overridden in " + this.getClass();
  return new StmtPoint(this);
}

@Override public StmtPoint move() {
  assert this.getClass() == StmtPoint.class : "must be overridden in " + this.getClass();
  return new StmtPoint(JD$Move.INSTANCE, this);
}
