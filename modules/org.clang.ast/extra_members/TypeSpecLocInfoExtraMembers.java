public TypeSpecLocInfo() {
  NameLoc = new SourceLocation();
}

public TypeSpecLocInfo(TypeSpecLocInfo $Prm0) {
  this.NameLoc = new SourceLocation($Prm0.NameLoc);
}

@Override
public TypeSpecLocInfo clone() {
  assert this.getClass() == TypeSpecLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new TypeSpecLocInfo(this);
}
