public TypeofLocInfo() {
  TypeofLoc = new SourceLocation();
  LParenLoc = new SourceLocation();
  RParenLoc = new SourceLocation();
}

public TypeofLocInfo(TypeofLocInfo $Prm0) {
  this.TypeofLoc = new SourceLocation($Prm0.TypeofLoc);
  LParenLoc = new SourceLocation($Prm0.LParenLoc);
  RParenLoc = new SourceLocation($Prm0.RParenLoc);
}

@Override
public TypeofLocInfo clone() {
  assert this.getClass() == TypeofLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new TypeofLocInfo(this);
}
