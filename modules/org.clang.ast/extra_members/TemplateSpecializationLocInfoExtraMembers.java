public TemplateSpecializationLocInfo() {
  TemplateKWLoc = new SourceLocation();
  LAngleLoc = new SourceLocation();
  RAngleLoc = new SourceLocation();
}

public TemplateSpecializationLocInfo(TemplateSpecializationLocInfo $Prm0) {
  super($Prm0);
  this.TemplateKWLoc = new SourceLocation($Prm0.TemplateKWLoc);
  LAngleLoc = new SourceLocation($Prm0.LAngleLoc);
  RAngleLoc = new SourceLocation($Prm0.RAngleLoc);
}

@Override
public TemplateSpecializationLocInfo clone() {
  assert this.getClass() == TemplateSpecializationLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new TemplateSpecializationLocInfo(this);
}
