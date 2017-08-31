@Override public PreImplicitCall clone() {
  assert this.getClass() == PreImplicitCall.class : "must be overridden in " + this.getClass();
  return new PreImplicitCall(this);
}

@Override public PreImplicitCall move() {
  assert this.getClass() == PreImplicitCall.class : "must be overridden in " + this.getClass();
  return new PreImplicitCall(JD$Move.INSTANCE, this);
}
