public DependentTemplateSpecializationLocInfo() {
  TemplateKWLoc = new SourceLocation();
  LAngleLoc = new SourceLocation();
  RAngleLoc = new SourceLocation();
}

public DependentTemplateSpecializationLocInfo(DependentTemplateSpecializationLocInfo $Prm0) {
  super($Prm0);
  this.TemplateKWLoc = new SourceLocation($Prm0.TemplateKWLoc);
  LAngleLoc = new SourceLocation($Prm0.LAngleLoc);
  RAngleLoc = new SourceLocation($Prm0.RAngleLoc);
}

@Override
public DependentTemplateSpecializationLocInfo clone() {
  assert this.getClass() == DependentTemplateSpecializationLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new DependentTemplateSpecializationLocInfo(this);
}
