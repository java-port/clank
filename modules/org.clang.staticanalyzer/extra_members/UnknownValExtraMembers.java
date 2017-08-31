@Override
public UnknownVal clone() {
  assert this.getClass() == UnknownVal.class : "Why not overridden in " + this.getClass();
  return new UnknownVal(this);
}

@Override
public UnknownVal move() {
  assert this.getClass() == UnknownVal.class : "Why not overridden in " + this.getClass();
  return new UnknownVal(JD$Move.INSTANCE, this);
}
