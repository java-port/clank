public PathDiagnosticLocationPair() {
  this.Start = new PathDiagnosticLocation();
  this.End = new PathDiagnosticLocation();
}

@Override public PathDiagnosticLocationPair clone() {
  return new PathDiagnosticLocationPair(this);
}
