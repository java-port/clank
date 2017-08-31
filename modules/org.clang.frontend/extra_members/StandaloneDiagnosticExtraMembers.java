public /*inline*/ StandaloneDiagnostic(StandaloneDiagnostic /*&&*/$Prm0) {
  // : ID(static_cast<StandaloneDiagnostic &&>().ID), Level(static_cast<StandaloneDiagnostic &&>().Level), Message(static_cast<StandaloneDiagnostic &&>().Message), Filename(static_cast<StandaloneDiagnostic &&>().Filename), LocOffset(static_cast<StandaloneDiagnostic &&>().LocOffset), Ranges(static_cast<StandaloneDiagnostic &&>().Ranges), FixIts(static_cast<StandaloneDiagnostic &&>().FixIts) 
  //START JInit
  this.ID = $Prm0.ID;
  this.Level = $Prm0.Level;
  this.Message = new std.string($Prm0.Message);
  this.Filename = new std.string($Prm0.Filename);
  this.LocOffset = $Prm0.LocOffset;
  this.Ranges = new std.vector<std.pairUIntUInt>($Prm0.Ranges);
  this.FixIts = new std.vector<StandaloneFixIt>($Prm0.FixIts);
  //END JInit
}

@Override public StandaloneDiagnostic clone() {
  return new StandaloneDiagnostic(this);
}

@Override public StandaloneDiagnostic move() {
  return new StandaloneDiagnostic(JD$Move.INSTANCE, this);
}
