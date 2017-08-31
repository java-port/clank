@Override
public DefinedOrUnknownSVal clone() {
  assert this.getClass() == DefinedOrUnknownSVal.class : "Why not overridden in " + this.getClass();
  return new DefinedOrUnknownSVal(this);
}

@Override
public DefinedOrUnknownSVal move() {
  assert this.getClass() == DefinedOrUnknownSVal.class : "Why not overridden in " + this.getClass();
  return new DefinedOrUnknownSVal(JD$Move.INSTANCE, this);
}
