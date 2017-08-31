public ElaboratedLocInfo() {
  ElaboratedKWLoc = new SourceLocation();
  QualifierData = null;
}

public ElaboratedLocInfo(ElaboratedLocInfo $Prm0) {
  this.ElaboratedKWLoc = new SourceLocation($Prm0.ElaboratedKWLoc);
  this.QualifierData = $Clone($Prm0.QualifierData);
}

@Override
public ElaboratedLocInfo clone() {
  assert this.getClass() == ElaboratedLocInfo.class : "Must be overridden in derived " + this.getClass();
  return new ElaboratedLocInfo(this);
}
