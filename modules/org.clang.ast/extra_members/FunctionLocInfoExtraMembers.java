public FunctionLocInfo() {
  LocalRangeBegin = new SourceLocation();
  LParenLoc = new SourceLocation();
  RParenLoc = new SourceLocation();
  LocalRangeEnd = new SourceLocation();
}

public FunctionLocInfo(FunctionLocInfo $Prm0) {
  this.LocalRangeBegin = new SourceLocation($Prm0.LocalRangeBegin);
  LParenLoc = new SourceLocation($Prm0.LParenLoc);
  RParenLoc = new SourceLocation($Prm0.RParenLoc);
  LocalRangeEnd = new SourceLocation($Prm0.LocalRangeEnd);
}

@Override
public FunctionLocInfo clone() {
  assert this.getClass() == FunctionLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new FunctionLocInfo(this);
}
