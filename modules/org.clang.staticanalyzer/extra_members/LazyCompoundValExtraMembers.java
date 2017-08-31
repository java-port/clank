@Override
public LazyCompoundVal clone() {
  assert this.getClass() == LazyCompoundVal.class : "Why not overridden in " + this.getClass();
  return new LazyCompoundVal(this);
}

@Override
public LazyCompoundVal move() {
  assert this.getClass() == LazyCompoundVal.class : "Why not overridden in " + this.getClass();
  return new LazyCompoundVal(JD$Move.INSTANCE, this);
}
