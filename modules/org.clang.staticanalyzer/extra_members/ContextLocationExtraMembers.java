public ContextLocation() {
  super();
  this.IsDead = false;
}

@Override public ContextLocation $assign(PathDiagnosticLocation $Prm0) {
  super.$assign($Prm0);
  this.IsDead = ((ContextLocation)$Prm0).IsDead;
  return this;
}

@Override public ContextLocation $assignMove(PathDiagnosticLocation $Prm0) {
  super.$assignMove($Prm0);
  this.IsDead = ((ContextLocation)$Prm0).IsDead;
  return this;
}

@Override public ContextLocation clone() {
  return new ContextLocation(this);
}

// Do not override $eq because ContextLocation is compared with pure PathDiagnosticLocation
// i.e. in EdgeBuilder.addEdge method
//@Override
//public boolean $eq(PathDiagnosticLocation RHS) {
//  if (this.IsDead != ((ContextLocation)RHS).IsDead) {
//    return false;
//  }
//  return super.$eq(RHS);
//}
//
//@Override
//public boolean $noteq(PathDiagnosticLocation X) {
//  return !$eq(X);
//}
