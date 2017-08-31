@Override public CFGInitializer clone() {
  assert this.getClass() == CFGInitializer.class : "must be overridden in " + this.getClass();
  return new CFGInitializer(this);
}

@Override public CFGInitializer move() {
  assert this.getClass() == CFGInitializer.class : "must be overridden in " + this.getClass();
  return new CFGInitializer(JD$Move.INSTANCE, this);
}
