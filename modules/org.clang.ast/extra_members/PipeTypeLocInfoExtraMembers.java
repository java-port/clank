public PipeTypeLocInfo() {
  KWLoc = new SourceLocation();
}

public PipeTypeLocInfo(PipeTypeLocInfo $Prm0) {
  this.KWLoc = new SourceLocation($Prm0.KWLoc);
}

@Override
public PipeTypeLocInfo clone() {
  assert this.getClass() == PipeTypeLocInfo.class : "Why not overridden in " + this.getClass();
  return new PipeTypeLocInfo(this);
}
