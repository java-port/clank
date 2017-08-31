public PointerLikeLocInfo() {
  StarLoc = new SourceLocation();
}

public PointerLikeLocInfo(PointerLikeLocInfo $Prm0) {
  this.StarLoc = new SourceLocation($Prm0.StarLoc);
}

@Override
public PointerLikeLocInfo clone() {
  assert this.getClass() == PointerLikeLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new PointerLikeLocInfo(this);
}
