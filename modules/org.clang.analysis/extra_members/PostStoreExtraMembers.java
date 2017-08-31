@Override public PostStore clone() {
  assert this.getClass() == PostStore.class : "must be overridden in " + this.getClass();
  return new PostStore(this);
}

@Override public PostStore move() {
  assert this.getClass() == PostStore.class : "must be overridden in " + this.getClass();
  return new PostStore(JD$Move.INSTANCE, this);
}
