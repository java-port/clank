public Capture() {
  this.VarAndKind = new PointerEnum2Pair<VarDecl /*P*/ , VariableCaptureKind>();
  this.Loc = new SourceLocation();      
}

@Override public Capture clone() {
  return new Capture().$assign(this);
}
