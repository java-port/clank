@Override
public SymbolVal clone() {
  assert this.getClass() == SymbolVal.class : "Why not overridden in " + this.getClass();
  return new SymbolVal(this);
}

@Override
public SymbolVal move() {
  assert this.getClass() == SymbolVal.class : "Why not overridden in " + this.getClass();
  return new SymbolVal(JD$Move.INSTANCE, this);
}
