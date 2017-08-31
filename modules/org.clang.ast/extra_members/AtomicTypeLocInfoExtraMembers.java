public AtomicTypeLocInfo() {
  KWLoc = new SourceLocation();
  LParenLoc = new SourceLocation();
  RParenLoc = new SourceLocation();
}

public AtomicTypeLocInfo(AtomicTypeLocInfo $Prm0) {
  this.KWLoc = new SourceLocation($Prm0.KWLoc);
  LParenLoc = new SourceLocation($Prm0.LParenLoc);
  RParenLoc = new SourceLocation($Prm0.RParenLoc);
}

@Override
public AtomicTypeLocInfo clone() {
  assert this.getClass() == AtomicTypeLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new AtomicTypeLocInfo(this);
}
