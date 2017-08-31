@Override public CFGDeleteDtor clone() {
  assert this.getClass() == CFGDeleteDtor.class : "must be overridden in " + this.getClass();
  return new CFGDeleteDtor(this);
}

@Override public CFGDeleteDtor move() {
  assert this.getClass() == CFGDeleteDtor.class : "must be overridden in " + this.getClass();
  return new CFGDeleteDtor(JD$Move.INSTANCE, this);
}
