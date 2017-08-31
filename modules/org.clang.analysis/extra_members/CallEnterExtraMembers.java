@Override public CallEnter clone() {
  assert this.getClass() == CallEnter.class : "must be overridden in " + this.getClass();
  return new CallEnter(this);
}

@Override public CallEnter move() {
  assert this.getClass() == CallEnter.class : "must be overridden in " + this.getClass();
  return new CallEnter(JD$Move.INSTANCE, this);
}
