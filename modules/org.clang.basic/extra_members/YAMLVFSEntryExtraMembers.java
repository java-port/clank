public /*inline*/ YAMLVFSEntry /*&*/ $assign(YAMLVFSEntry /*&&*/$Prm0) {
  assert this != EMPTY;
  this.VPath.$assign($Prm0.VPath);
  this.RPath.$assign($Prm0.RPath);
  return /*Deref*/this;
}

@Override public YAMLVFSEntry clone() {
  return new YAMLVFSEntry(this.VPath, this.RPath);
}

@Override public YAMLVFSEntry move() {
  return new YAMLVFSEntry(JD$Move.INSTANCE, this);
}
