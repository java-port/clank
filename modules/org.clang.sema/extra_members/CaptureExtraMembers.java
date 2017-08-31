public Capture() {
  this.VarAndNestedAndThis = new PointerIntPair<VarDecl /*P*/ >();
  this.InitExprAndCaptureKind = new PointerEnum2Pair<Object, CaptureKind>();
  this.Loc = new SourceLocation();
  this.EllipsisLoc = new SourceLocation();
  this.CaptureType = new QualType();      
}

@Override public Capture clone() {
  return new Capture(this);
}
