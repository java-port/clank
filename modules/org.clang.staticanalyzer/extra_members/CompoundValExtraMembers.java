@Override
public CompoundVal clone() {
  assert this.getClass() == CompoundVal.class : "Why not overridden in " + this.getClass();
  return new CompoundVal(this);
}

@Override
public CompoundVal move() {
  assert this.getClass() == CompoundVal.class : "Why not overridden in " + this.getClass();
  return new CompoundVal(JD$Move.INSTANCE, this);
}
