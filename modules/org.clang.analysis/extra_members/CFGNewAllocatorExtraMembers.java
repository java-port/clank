@Override public CFGNewAllocator clone() {
  assert this.getClass() == CFGNewAllocator.class : "must be overridden in " + this.getClass();
  return new CFGNewAllocator(this);
}

@Override public CFGNewAllocator move() {
  assert this.getClass() == CFGNewAllocator.class : "must be overridden in " + this.getClass();
  return new CFGNewAllocator(JD$Move.INSTANCE, this);
}
