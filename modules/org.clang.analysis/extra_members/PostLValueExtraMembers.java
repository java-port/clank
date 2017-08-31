@Override public PostLValue clone() {
  assert this.getClass() == PostLValue.class : "must be overridden in " + this.getClass();
  return new PostLValue(this);
}

@Override public PostLValue move() {
  assert this.getClass() == PostLValue.class : "must be overridden in " + this.getClass();
  return new PostLValue(JD$Move.INSTANCE, this);
}
