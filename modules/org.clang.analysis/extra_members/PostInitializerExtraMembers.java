@Override public PostInitializer clone() {
  assert this.getClass() == PostInitializer.class : "must be overridden in " + this.getClass();
  return new PostInitializer(this);
}

@Override public PostInitializer move() {
  assert this.getClass() == PostInitializer.class : "must be overridden in " + this.getClass();
  return new PostInitializer(JD$Move.INSTANCE, this);
}
