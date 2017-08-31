@Override public CFGImplicitDtor clone() {
  assert this.getClass() == CFGImplicitDtor.class : "must be overridden in " + this.getClass();
  return new CFGImplicitDtor(this);
}

@Override public CFGImplicitDtor move() {
  assert this.getClass() == CFGImplicitDtor.class : "must be overridden in " + this.getClass();
  return new CFGImplicitDtor(JD$Move.INSTANCE, this);
}
