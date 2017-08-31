DeclUpdate() {
  this.Kind = -1;
}

@Override public DeclUpdate clone() {
  return new DeclUpdate().$assign(this);
}
