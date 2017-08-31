@Override public CFGTemporaryDtor clone() {
  assert this.getClass() == CFGTemporaryDtor.class : "must be overridden in " + this.getClass();
  return new CFGTemporaryDtor(this);
}

@Override public CFGTemporaryDtor move() {
  assert this.getClass() == CFGTemporaryDtor.class : "must be overridden in " + this.getClass();
  return new CFGTemporaryDtor(JD$Move.INSTANCE, this);
}
