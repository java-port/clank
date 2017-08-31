@Override
public Comdat clone() {
  assert this.Name == null;
  assert this.SK == Comdat.SelectionKind.Any;
  return new Comdat();
}

@Override
public Comdat move() {
  return new Comdat(JD$Move.INSTANCE, this);
}
