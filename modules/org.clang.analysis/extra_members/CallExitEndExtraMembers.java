@Override public CallExitEnd clone() {
  assert this.getClass() == CallExitEnd.class : "must be overridden in " + this.getClass();
  return new CallExitEnd(this);
}

@Override public CallExitEnd move() {
  assert this.getClass() == CallExitEnd.class : "must be overridden in " + this.getClass();
  return new CallExitEnd(JD$Move.INSTANCE, this);
}
