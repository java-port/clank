public DependentNameLocInfo() {
  NameLoc = new SourceLocation();
}

public DependentNameLocInfo(DependentNameLocInfo $Prm0) {
  super($Prm0);
  this.NameLoc = new SourceLocation($Prm0.NameLoc);
}

@Override
public DependentNameLocInfo clone() {
  assert this.getClass() == DependentNameLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new DependentNameLocInfo(this);
}
