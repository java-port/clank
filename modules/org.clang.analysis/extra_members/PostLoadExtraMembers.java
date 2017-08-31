@Override public PostLoad clone() {
  assert this.getClass() == PostLoad.class : "must be overridden in " + this.getClass();
  return new PostLoad(this);
}

@Override public PostLoad move() {
  assert this.getClass() == PostLoad.class : "must be overridden in " + this.getClass();
  return new PostLoad(JD$Move.INSTANCE, this);
}
