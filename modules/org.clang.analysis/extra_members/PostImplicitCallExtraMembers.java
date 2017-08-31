@Override public PostImplicitCall clone() {
  assert this.getClass() == PostImplicitCall.class : "must be overridden in " + this.getClass();
  return new PostImplicitCall(this);
}

@Override public PostImplicitCall move() {
  assert this.getClass() == PostImplicitCall.class : "must be overridden in " + this.getClass();
  return new PostImplicitCall(JD$Move.INSTANCE, this);
}
