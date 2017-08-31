public UnaryTransformTypeLocInfo() {
  KWLoc = new SourceLocation();
  LParenLoc = new SourceLocation();
  RParenLoc = new SourceLocation();
  UnderlyingTInfo = null;
}

public UnaryTransformTypeLocInfo(UnaryTransformTypeLocInfo $Prm0) {
  this.KWLoc = new SourceLocation($Prm0.KWLoc);
  LParenLoc = new SourceLocation($Prm0.LParenLoc);
  RParenLoc = new SourceLocation($Prm0.RParenLoc);
  UnderlyingTInfo = $Prm0.UnderlyingTInfo;
}

@Override
public UnaryTransformTypeLocInfo clone() {
  assert this.getClass() == UnaryTransformTypeLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new UnaryTransformTypeLocInfo(this);
}
