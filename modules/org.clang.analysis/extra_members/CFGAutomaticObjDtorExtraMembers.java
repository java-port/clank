@Override public CFGAutomaticObjDtor clone() {
  assert this.getClass() == CFGAutomaticObjDtor.class : "must be overridden in " + this.getClass();
  return new CFGAutomaticObjDtor(this);
}

@Override public CFGAutomaticObjDtor move() {
  assert this.getClass() == CFGAutomaticObjDtor.class : "must be overridden in " + this.getClass();
  return new CFGAutomaticObjDtor(JD$Move.INSTANCE, this);
}
