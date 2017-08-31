@Override
public LocAsInteger clone() {
  assert this.getClass() == LocAsInteger.class : "Why not overridden in " + this.getClass();
  return new LocAsInteger(this);
}

@Override
public LocAsInteger move() {
  assert this.getClass() == LocAsInteger.class : "Why not overridden in " + this.getClass();
  return new LocAsInteger(JD$Move.INSTANCE, this);
}
