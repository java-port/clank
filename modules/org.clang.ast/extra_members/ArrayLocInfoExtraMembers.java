public ArrayLocInfo() {
  LBracketLoc = new SourceLocation();
  RBracketLoc = new SourceLocation();
  Size = null;
}

public ArrayLocInfo(ArrayLocInfo $Prm0) {
  this.LBracketLoc = new SourceLocation($Prm0.LBracketLoc);
  RBracketLoc = new SourceLocation($Prm0.RBracketLoc);
  Size = $Prm0.Size;
}

@Override
public ArrayLocInfo clone() {
  assert this.getClass() == ArrayLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new ArrayLocInfo(this);
}
