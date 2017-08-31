public ParenLocInfo() {
  LParenLoc = new SourceLocation();
  RParenLoc = new SourceLocation();
}

public ParenLocInfo(ParenLocInfo $Prm0) {
  LParenLoc = new SourceLocation($Prm0.LParenLoc);
  RParenLoc = new SourceLocation($Prm0.RParenLoc);
}

@Override
public ParenLocInfo clone() {
  assert this.getClass() == ParenLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new ParenLocInfo(this);
}
