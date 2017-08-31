public BuiltinLocInfo() {
  BuiltinLoc = new SourceLocation();
}

public BuiltinLocInfo(BuiltinLocInfo $Prm0) {
  this.BuiltinLoc = new SourceLocation($Prm0.BuiltinLoc);
}

@Override
public BuiltinLocInfo clone() {
  assert this.getClass() == BuiltinLocInfo.class : "Why not overridden in derived " + this.getClass();
  return new BuiltinLocInfo(this);
}
