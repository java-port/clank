@Override public BlockEntrance clone() {
  assert this.getClass() == BlockEntrance.class : "must be overridden in " + this.getClass();
  return new BlockEntrance(this);
}

@Override public BlockEntrance move() {
  assert this.getClass() == BlockEntrance.class : "must be overridden in " + this.getClass();
  return new BlockEntrance(JD$Move.INSTANCE, this);
}
