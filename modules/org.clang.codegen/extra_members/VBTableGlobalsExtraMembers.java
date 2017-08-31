@Override
public VBTableGlobals clone() {
  VBTableGlobals res = new VBTableGlobals();
  if (this.VBTables != null) {
    res.VBTables = this.VBTables.clone();
  }
  res.Globals = this.Globals.clone();
  return res;
}

@Override
public VBTableGlobals $assign(VBTableGlobals other) {
  this.VBTables.$assign(other.VBTables);
  this.Globals.$assign(other.Globals);
  return this;
}
