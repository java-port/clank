@Override public CFGBaseDtor clone() {
  assert this.getClass() == CFGBaseDtor.class : "must be overridden in " + this.getClass();
  return new CFGBaseDtor(this);
}

@Override public CFGBaseDtor move() {
  assert this.getClass() == CFGBaseDtor.class : "must be overridden in " + this.getClass();
  return new CFGBaseDtor(JD$Move.INSTANCE, this);
}
