public ObjCInterfaceLocInfo() {
  NameLoc = new SourceLocation();
  NameEndLoc = new SourceLocation();
}

public ObjCInterfaceLocInfo(ObjCInterfaceLocInfo $Prm0) {
  this.NameLoc = new SourceLocation($Prm0.NameLoc);
  this.NameEndLoc = new SourceLocation($Prm0.NameEndLoc);
}

@Override
public ObjCInterfaceLocInfo clone() {
  assert this.getClass() == ObjCInterfaceLocInfo.class : "Why not overridden in " + this.getClass();
  return new ObjCInterfaceLocInfo(this);
}
