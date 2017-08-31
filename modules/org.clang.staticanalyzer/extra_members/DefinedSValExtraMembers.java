@Override
public DefinedSVal clone() {
  assert this.getClass() == DefinedSVal.class : "Why not overridden in " + this.getClass();
  return new DefinedSVal(this);
}

@Override
public DefinedSVal move() {
  assert this.getClass() == DefinedSVal.class : "Why not overridden in " + this.getClass();
  return new DefinedSVal(JD$Move.INSTANCE, this);
}
