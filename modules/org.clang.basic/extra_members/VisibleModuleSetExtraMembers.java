@Override public VisibleModuleSet clone() {
  // only for check of cloneable, in collections have to use move
  assert this.Generation == 0 : "only empty is expected here";
  assert this.ImportLocs.empty() : "only empty is expected here";
  return new VisibleModuleSet();
}

@Override public VisibleModuleSet move() {
  return new VisibleModuleSet(JD$Move.INSTANCE, this);
}
