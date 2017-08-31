@Override public CFGMemberDtor clone() {
  assert this.getClass() == CFGMemberDtor.class : "must be overridden in " + this.getClass();
  return new CFGMemberDtor(this);
}

@Override public CFGMemberDtor move() {
  assert this.getClass() == CFGMemberDtor.class : "must be overridden in " + this.getClass();
  return new CFGMemberDtor(JD$Move.INSTANCE, this);
}
