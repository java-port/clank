@Override
public MemRegionVal clone() {
  assert this.getClass() == MemRegionVal.class : "Why not overridden in " + this.getClass();
  return new MemRegionVal(this);
}

@Override
public MemRegionVal move() {
  assert this.getClass() == MemRegionVal.class : "Why not overridden in " + this.getClass();
  return new MemRegionVal(JD$Move.INSTANCE, this);
}
